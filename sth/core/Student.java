package sth.core;
import java.util.ArrayList;
import java.util.Iterator;
import sth.core.exception.BadEntryException;
import sth.core.exception.NoSuchDisciplineIdException;
import java.util.Collections;
import java.util.*;
import sth.core.Discipline.DisciplineComparator;
import sth.core.Discipline;


public class Student extends Person implements java.io.Serializable{
    private boolean _isRepresentative;
    private Course _course;
    private ArrayList <Discipline> _disciplines;

    public Student(int id, int phoneNumber, String name, boolean del){
        super(id, name, phoneNumber);
        _isRepresentative = del;
        _disciplines= new ArrayList<Discipline>();

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

    /*package*/ void addDiscipline(Discipline d){
        _disciplines.add(d);
    }

    /*package*/ void setRepresentative(boolean rep){
        _isRepresentative = rep;
    }

    /*package*/ int getNumDiscipline(){
        return _disciplines.size();
    }


    /*package*/boolean isRepresentative(){
    return _isRepresentative;
    }

    public ArrayList<String> tooString(){
        ArrayList<String> stringArr= new ArrayList<String>();
        if( _isRepresentative == true ){
            String str = "DELEGADO|";
            str+= super.toString();
            stringArr.add(aux(str));
            return stringArr;
        }
        else{
            String str = "ALUNO|";
            str+= super.toString();
            stringArr.add(aux(str));
            return stringArr;
        }
    }



    private String aux(String str){
        ArrayList<Discipline> disciplinesort= new ArrayList<Discipline>(_disciplines);
        Discipline dis = new Discipline();
        Discipline.DisciplineComparator comp = dis.new DisciplineComparator();
        disciplinesort.sort(comp);
        String l;
        l = str;
        for(Discipline d:disciplinesort){
            l+="\n" + "* " + _course.getName()+" - " + d.getName();
        }

        return l;
    }



    /*package*/ ArrayList<Discipline> getArrayListDisciplines(){
        return _disciplines;
    }

}
