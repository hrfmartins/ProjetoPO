import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class Teacher extends Person{
    private List<Discipline> _disciplines;

    public Teacher(int id,int phoneNumber,String name){
        super(id,phoneNumber,name);
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
