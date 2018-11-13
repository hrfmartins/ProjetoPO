package sth.core;

public class Discipline{
    private String _name;
    private int _capacity;
    private List<Student> _students;
    private List<Teacher> _teachers;
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
        if(st.getNumDiscipline()<7){
            _students.add(s);
            st.addDiscipline(this);
        }
        else{

        }

    }
    /*package*/void createProject(String s){
        Project p=new Project(s);

    }

}
