package sth.core;
import java.util.Iterator;
import sth.core.exception.BadEntryException;
import sth.core.exception.NoSuchPersonIdException;
import java.util.*;

import java.io.IOException;

/**
 * School implementation.
 */
public class School implements java.io.Serializable {

  /** Serial number for serialization. */
    private static final long serialVersionUID = 201810051538L;
    private ArrayList<Course> _courses;
    private HashSet<Person> _persons;
    private HashSet<Student> _students;
    private HashSet<Teacher> _teachers;
    //private HashSet<Employee> _employees;

    public School(){
        _courses = new ArrayList<Course>();
        _persons = new HashSet<Person>();
        _students=new HashSet<Student>();
        _teachers=new HashSet<Teacher>();
        //private HashSet<Employee> _persons
    }

  /**
    * @param filename
    * @throws BadEntryException
    * @throws IOException
    */
    void importFile(String filename) throws IOException, BadEntryException {
        Parser p=new Parser(this);
        p.parseFile(filename);
    }


    /*package*/ Course parseCourse(String course){
        for (Course c: _courses){
            if (c.getName().equals(course)){
                return c;
            }
            
        }
        //if it reaches this part, there's not a course with that name yet
        Course cs = new Course(course);
        _courses.add(cs);
        return cs;
        }


    /*package*/ Teacher getTeacher(int id) {
        for (Teacher teach : _teachers){
            if ((teach.getId()) == id){
                return teach;
            }
        }
        return null;
    }
    /*package*/ Student getStudent(int id) {
        for (Student s : _students){
            if ((s.getId()) == id){
                return s;
            }
        }
        return null;
    }
    /*package*/ Person getPerson(int id) {
        for (Person p : _persons){
            if ((p.getId()) == id){
                return p;
            }
        }
        return null;
    }
    /*package*/ void addPerson(Person p) {
        _persons.add(p);

    }


    /*package*/ void addStudent(Student p) {
        _students.add(p);

    }


    /*package void addEmployee(Employee p) {
        _employees.add(p);
    }*/

    /*package*/ void addTeacher(Teacher p) {
        _teachers.add(p);

    }

    public ArrayList<Person> getPersonByName(String name){
        ArrayList<Person> ArrayList = new ArrayList<Person>();
        for (Person p : _persons){
            if (p.getName().toLowerCase().contains(name.toLowerCase())){
                ArrayList.add(p);
            }
        }
        return ArrayList;
    }


    public HashSet<Person> getPersonArrayList(){
        return _persons;
    }



}
