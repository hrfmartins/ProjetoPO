package sth.core;

import sth.core.exception.BadEntryException;
import sth.core.exception.ImportFileException;
import sth.core.exception.NoSuchPersonIdException;
import sth.core.exception.NoSuchDisciplineIdException;
import sth.core.exception.NoSuchProjectIdException;

import java.io.IOException;
import java.io.FileNotFoundException;


/**
 * The façade class
 */
public class SchoolManager {
    private School _school;
    private int _loggedIn;

    public SchoolManager() {
        _school = new School();
    }

    /**
     * @param datafile
     * @throws ImportFileException
     * @throws InvalidCourseSelectionException
     */
    public void importFile(String datafile) throws ImportFileException {
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
        if ((_school.getPerson(_loggedIn)) instanceof Teacher) {
            return true;
        }
        return false;
    }

    /**
     * @return true when the currently logged in person is a student
     */
    public boolean isLoggedUserStudent() {
        if ((_school.getPerson(_loggedIn)) instanceof Student) {
            return true;
        }
        return false;
    }

    /**
     * @return true when the currently logged in person is a representative
     */
    public boolean isLoggedUserRepresentative() {
        if (((_school.getPerson(_loggedIn)) instanceof Student) && (_school.getPerson(_loggedIn)).isRepresentative()); {
            return True;
        }

    }


    public String showPerson(int i) {
        Person p = _school.getPerson(i);
        return p.tooString();
    }


    public void setPhoneNumber(int phoneNumber) {
        _loggedIn.setPhoneNumber(phoneNumber);
    }


    public String[] getPersonByName(String name) {
        ArrayList<Person> lststr = new ArrayList<Person>(_school.getPersonByName(name));
        lststr.sort(new IdComparator());
        int i = 0;
        String s[] = new String[lststr.size()];
        for (Person p: lststr){
            s[i] = p.tooString();
            i++;

        }
        return s;
    }



    public String showLoggedPerson() {
        Person p=school.getPerson();
        return p.tooString();
    }


    public String[] ShowAllPersons() {
        ArrayList<Person> lststr = new ArrayList<Person>(_school.getPersonArrayList());
        lststr.sort(new IdComparator());
        int i = 0;
        String s[] = new String(lststr.size());
        for (Person p: lststr){
            s[i] = p.tooString();
            i++;

        }
        return s;
    }


    public void closeProject(String dis, String name) throws NoSuchDisciplineIdException, NoSuchProjectIdException {
        Teacher t = _school.getPerson(_loggedIn);
        t.closeProject(dis,name);
    }


    public void CreateProject(String dis, String name) throws NoSuchDisciplineIdException {
        Teacher t = _school.getPerson(_loggedIn);
        t.createProject(dis,name);
    }


    public String[] ShowDisciplineStudents(String dis) throws NoSuchDisciplineIdException{
        Teacher t = _school.getPerson(_loggedIn);
        Discipline discipline = t.getDiscipline(dis);
        ArrayList<Students> students = new ArrayList<Students>();
        students = ArrayListdiscipline.getStudents();
        students.sort(new IdComparator());
        String s[] = new String(students.size());

        for (Student p: students){
            s[i] = p.tooString();
            i++;
        }
        return s;
        }


}
