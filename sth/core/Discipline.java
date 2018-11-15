package sth.core;
import java.util.List;
import java.util.Iterator;

public class Discipline{
    private String _name;
    private int _capacity;
    private List<Student> _students;
    private List<Teacher> _teachers;
    private List<Project> _projects;
    private Course _course;

    public Discipline(String s,Course c){
        _name=s;
        _course=c;
        _students= new List<Student>();
    }

    /*package*/String getName(){
        return _name;
    }

    /*package*/Course getCourse(){
        return _course;
    }

    /*package*/void addTeacher(Teacher t){
        _teachers.add(t);
    }

    /*package*/void enrollStudent(Student st){
        if(st.getNumDiscipline()<6){
            boolean enroll = true;
            List <Discipline> lstDisc = st.getListDisciplines(st.getId());
            for (Discipline dsc : lstDisc){
                if ((dsc.getname()).equals(_name)){
                    enroll = false;
                    break;
                }
            }
            if (enroll == true){
                _students.add(s);
                st.addDiscipline(this);
            }
        }
        else{

        }

    }
    /*package*/void createProject(String name,String des){
        Project p=new Projeto(name,des);
        _projects.add(p);


    }
    /*package*/Project getProject(String name){
        Iterator<Projeto> iterator = _projects.iterator();
        while(iterator.hasNext()){
            Project project= iterator.next();
            if(project.getName().equals(name)){
                return project;
            }
        }

    }

}
