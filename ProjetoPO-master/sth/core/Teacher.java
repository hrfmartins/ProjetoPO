import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;



public class Teacher extends Person{
    private List<Discipline> _disciplines;

    public Teacher(int id,int phoneNumber,String name){
        super(id,phoneNumber,name);
    }


    void parseContext(String lineContext, School school) throws BadEntryException {
        String components[] =  lineContext.split("\\|");

        if (components.length != 2)
            throw new BadEntryException("Invalid line context " + lineContext);

        Course course = school.parseCourse(components[0]);
        Discipline discipline = course.parseDiscipline(components[1]);

        discipline.addTeacher(this);
    }


    /*package*/ void createProject(){

    }

    /*package*/ void addDiscipline(Discipline d){
    _disciplines.add(d);
    }


    public String toString(){
        String s = super.toString();
        for(Discipline d: _disciplines){
            s=s+" "+d.getName();
        }
    }
}
