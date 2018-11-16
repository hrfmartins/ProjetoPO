package sth.core;
import java.util.ArrayList;
import java.util.Iterator;
import sth.core.exception.BadEntryException;
import java.util.Collections;
import java.util.*;
import sth.core.Discipline.DisciplineComparator;
import sth.core.Discipline;


public class Student extends Person{
    private boolean _isRepresentative;
    private Course _course;
    private ArrayList <Discipline> _disciplines;

    public Student(int id, int phoneNumber, String name, boolean del){
        super(id, name, phoneNumber);
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

    public String[] tooString(){
        if( _isRepresentative == true ){
            String str = "Delegado|";
            str+= super.toString();
            return aux(str);
        }
        else{
            String str = "Aluno|";
            str+= super.toString();
            return aux(str);
        }
    }


    private String[] aux(String str){
        ArrayList<Discipline> disciplinesort= new ArrayList<Discipline>(_disciplines);
        Discipline dis = new Discipline();
        Discipline.DisciplineComparator comp = dis.new DisciplineComparator();
        disciplinesort.sort(comp);
        String[] l = new String[1+disciplinesort.size()];
        l[0] = str;
        int i = 1;
        for(Discipline d:disciplinesort){
            l[i]= "* " + _course.getName()+" - " + d.getName();
            i++;
        }

        return l;
    }



    /*package*/ ArrayList<Discipline> getArrayListDisciplines(){
        return _disciplines;
    }

}
