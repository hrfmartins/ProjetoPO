package sth.core;

import sth.core.exception.BadEntryException;
import sth.core.exception.ImportFileException;
import sth.core.exception.NoSuchPersonIdException;
import sth.core.exception.NoSuchDisciplineIdException;
import sth.core.exception.NoSuchProjectIdException;
import java.util.*;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.*;


/**
 * The façade class
 */
public class SchoolManager implements java.io.Serializable{

    private static final long serialVersionUID = 201810051538L;
    private School _school;
    private int _loggedIn;

    public SchoolManager() {
        _school = new School();
    }

    public void open(String fileName) throws IOException,ClassNotFoundException{
        ObjectInputStream obIn = null;
        try {
            FileInputStream fpin = new FileInputStream(fileName);
            obIn = new ObjectInputStream(fpin);
            Object anObject = obIn.readObject();
            School s=(School)anObject;
            _school=s;
        } finally {
            if (obIn != null)
            obIn.close();
        }
    }

    public void save(String fileName) throws IOException,ClassNotFoundException{
        ObjectOutputStream obOut = null;
        try{
            FileOutputStream fpout = new FileOutputStream(fileName);
            obOut = new ObjectOutputStream(fpout);
            obOut.writeObject(_school);

        }finally{
            if (obOut != null)
                obOut.close();
        }
    }

    /**
     * @param datafile
     * @throws ImportFileException
     * @throws InvalidCourseSelectionException
     */
    public void importFile(String datafile) throws ImportFileException,BadEntryException{
        try {
            _school.importFile(datafile);
        } catch (IOException | BadEntryException e) {
            throw new ImportFileException(e);
        }
    }

    /**
     * Do the login of the user with the given identifier.

     * @param id identifier of the user to login
     * @throws NoSuchPersonIdException if there is no uers with the given identifier
     */
    public void login(int id) throws NoSuchPersonIdException {
        Person p = _school.getPerson(id);
        if (p == null) {
            throw new NoSuchPersonIdException(id);
        } else {
            _loggedIn = id;

        }
    }


    /**
     * @return true when the currently logged in person is an administrative
     */
    /*public boolean isLoggedUserAdministrative() {
        if ((_school.getPerson(_loggedIn)) instanceof Administrative) {
            return true;
        }
        return false;
    }
    */

    /**
     * @return true when the currently logged in person is a professor
     */
    public boolean isLoggedUserProfessor() {
        Teacher t = null;
        t = _school.getTeacher(_loggedIn);
        if ( t!=null) {
            return true;
        }
        return false;
    }

    /**
     * @return true when the currently logged in person is a student
     */
    public boolean isLoggedUserStudent() {
        Student t = null;
        t = _school.getStudent(_loggedIn);
        if (t!=null) {
            return true;
        }return false;
    }

    /**
     * @return true when the currently logged in person is a representative
     */
    public boolean isLoggedUserRepresentative() {
        Student t = null;
        t = _school.getStudent(_loggedIn);
        if (t!=null) {
             if (t.isRepresentative() == true ) {
                return true;
            }
        }
        return false;
    }


    public String showPerson(int i) {
        Person p = _school.getPerson(i);
        return strAux(p.tooString());
    }


    public void setPhoneNumber(int phoneNumber) {
        Person p = _school.getPerson(_loggedIn);
        p.setPhoneNumber(phoneNumber);
    }


    public String[] getPersonByName(String name) {
        ArrayList<Person> lststr = new ArrayList<Person>(_school.getPersonByName(name));
        lststr.sort(new IdComparator());
        int i = 0;
        String s[] = new String[lststr.size()];
        for (Person p: lststr){
            s[i] = strAux(p.tooString());
            i++;

        }
        return s;
    }

    public String strAux (ArrayList<String> list){
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }





    public String showLogPerson() {
        Person p = _school.getPerson(_loggedIn);
        return strAux(p.tooString());
    }


    public String[] showAllPersons() {
        List<Person> lststr = new ArrayList<Person>(_school.getPersonArrayList());
        lststr.sort(new IdComparator());
        int i = 0;
        String s[] = new String[lststr.size()];
        for (Person p: lststr){
            s[i] = strAux(p.tooString());
            i++;

        }
        return s;
    }


    public void closeProject(String dis, String name) throws NoSuchDisciplineIdException, NoSuchProjectIdException {
        Person p = _school.getPerson(_loggedIn);
        Teacher t = (Teacher)p;
        t.closeProject(dis,name);
    }


    public void createProject(String dis, String name) throws NoSuchDisciplineIdException {
        Person p = _school.getPerson(_loggedIn);
        Teacher t = (Teacher)p;
        t.createProject(dis,name);
    }


    public String[] showDisciplineStudents(String dis) throws NoSuchDisciplineIdException{
        Teacher tea = _school.getTeacher(_loggedIn);
        Discipline discip = tea.getDiscipline(dis);
        ArrayList<Student> students = new ArrayList<Student>(discip.getStudents());
        System.out.println(students.size());
        students.sort(new IdComparator());

        String[] s = new String[students.size()];
        int i = 0;

        for (Student p: students){
            System.out.println(strAux(p.tooString()));
            s[i] = strAux(p.tooString());
            i++;
        }
        return s;
    }

    class IdComparator implements Comparator<Person>{
        @Override
        public int compare(Person a, Person b){
            if (a.getId() < b.getId()) {
                return -1;
            } if (a.getId() > b.getId()) {
                return 1;
            } return 0;
        }
    }

}