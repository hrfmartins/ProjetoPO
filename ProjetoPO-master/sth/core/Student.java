package sth.core;
import java.util.List;
import java.util.Iterator;


public class Student extends Person{
    private boolean _isRepresentative;
    private Course _course;
    private List <Discipline> _disciplines;

    public Student(int id, int phoneNumber, String name, boolean del){
        super.Person(id, name, phoneNumber);
        _isRepresentative = del;

    }

    /*package*/ Course getCourse(){
        return _course;
    }

    /*package*/ void setCourse(Course c){
        _course = c;
    }

    /*package*/ addDiscipline(Discipline d){
        _disciplines.add(d);
    }
    /*package*/ setRepresentative(boolean rep){
    _isRepresentative = rep;
    }

    /*package*/ int getNumDiscipline(){
        return _disciplines.length();
    }


    /*package*/ isRepresentative(){
    return _isRepresentative;
    }

    public String toString(){
        String s = super.toString();
        s = s + "Delegado: " + _isRepresentative
        for( Discipline d : _disciplines){
            s=s+" "+d.getName();
    }


}
