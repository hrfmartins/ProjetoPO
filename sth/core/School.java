package sth.core;
import java.util.ArrayList;
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
    private ArrayList <Course> _courses;
    private ArrayList <Person> _persons;

    public School(){
        _courses = new ArrayList<Course>();
        _persons = new ArrayList<Person>();
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
        Course cs = new Course(course);
        _courses.add(cs);
        }


    /*package*/ Person getPerson(int id) {
        for (Person p : _persons){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public ArrayList<Person> getPersonByName(String name){
        ArrayList<Person> ArrayList = new ArrayList<Person>(_persons);
        for (Person p : _persons){
            if ((p.getName()).equals(name)){
                ArrayList.add(p);
            }
        }
        return ArrayList;
    }


    public ArrayList <Person> getPersonArrayList(){
        return _persons;
    }



}
