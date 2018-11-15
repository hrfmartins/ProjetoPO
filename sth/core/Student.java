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

    void parseContext(String lineContext, School school) throws BadEntryException {
        String components[] =  lineContext.split("\\|");

       if (components.length != 2)
         throw new BadEntryException("Invalid line context " + lineContext);

       if (_course == null) {
         _course = school.parseCourse(components[0]);
         _course.addStudent(this);
       }

       Discipline dis = _course.parseDiscipline(components[1]);
       dis.enrollStudent(this);
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
