package sth.core;
import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;
import sth.core.exception.BadEntryException;

public class Discipline{
    private String _name;
    private int _capacity;
    private ArrayList<Student> _students;
    private ArrayList<Teacher> _teachers;
    private ArrayList<Project> _projects;
    private Course _course;

    public Discipline(){};
    public Discipline(String s,Course c){
        _name=s;
        _course=c;
        _students= new ArrayList<Student>();
    }


    /*package*/String getName(){
        return _name;
    }


    /*package*/Course getCourse(){
        return _course;
    }


    /*package*/void addCourse(Course course){
        _course = course;
    }


    /*package*/ ArrayList<Student> getStudents(){
        return _students;
}


    /*package*/ void addTeacher(Teacher t){
        _teachers.add(t);
    }


    /*package*/void enrollStudent(Student st){
        if(st.getNumDiscipline()<6){
            boolean enroll = true;
            ArrayList <Discipline> lstDisc = st.getArrayListDisciplines();
            for (Discipline dsc : lstDisc){
                if ((dsc.getName()).equals(_name)){
                    enroll = false;
                    break;
                }
            }
            if (enroll == true){
                _students.add(st);
                st.addDiscipline(this);
            }
        }
        else{

        }

    }


    /*package*/void createProject(String name){
        Project p=new Project(name);
        _projects.add(p);
    }


    /*package*/Project getProject(String name){
        Iterator<Project> iterator = _projects.iterator();
        while(iterator.hasNext()){
            Project project= iterator.next();
            if(project.getName().equals(name)){
                return project;
            }
        }
        return null;
    }


    /*package*/ ArrayList<Project> getAllProjects(){
        return _projects;
    }
    class DisciplineComparator implements Comparator<Discipline>{
        @Override
        public int compare(Discipline a,Discipline b){
           if (a.getName().compareTo(b.getName()) <= -1) {
               return -1;
           } if (a.getName().compareTo(b.getName()) >= 1){
               return 1;
           } return 0;
       }
    }


}
