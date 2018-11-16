package sth.core;
import java.util.Iterator;
import java.util.ArrayList;
import sth.core.exception.BadEntryException;
import sth.core.exception.NoSuchDisciplineIdException;
import sth.core.exception.NoSuchProjectIdException;

public class Teacher extends Person{
    private ArrayList<Discipline> _disciplines;

    public Teacher(int id,String name,int phoneNumber){
        super(id,name,phoneNumber);
    }


    void parseContext(String lineContext, School school) throws BadEntryException {
        String components[] =  lineContext.split("\\|");

        if (components.length != 2)
            throw new BadEntryException("Invalid line context " + lineContext);

        Course course = school.parseCourse(components[0]);
        _courses.add(course);
        Discipline discipline = course.parseDiscipline(components[1]);
        _disciplines.add(discipline);
        discipline.addTeacher(this);
    }

    /*package*/ void addDiscipline(Discipline d){
    _disciplines.add(d);
    }


    public String tooString(){
        String first = "Teacher|"+super.toString();
        ArrayList<Discipline> _disciplinesort= new ArrayList<Discipline>(_disciplines);
        _disciplinesort.sort(new DisciplineComparator());
        ArrayList<Course> _course=createArrayListCoursesort(_disciplinesort);
        String[] ArrayList=transforma(_course,disciplinesort,first);
        return ArrayList;

    }



    /*package*/ static ArrayList<Course> createArrayListCoursesort(ArrayList<Discipline> l){
        ArrayList<Course> _course= new ArrayList<Course>();
        for(Discipline d:l){
            _course.add(d.getCourse());
        }
        _course.sort(new CourseComparator());
        return _course;


    }

    /*package*/static String[] transforma(ArrayList<Course> ArrayListCourse,ArrayList<Discipline> ArrayListDis,String first){
        String[] ArrayList = new String[1+ArrayListDis.size()];
        ArrayList[0]=first;
        i=1;
        for(Course c:ArrayListCourse){
            for(Discipline d:ArrayListDis){
                if(((d.getCourse()).getName()).equals(c.getName())){
                    ArrayList[i]="* "+_c.getName()+" - "+d.getName();
                    i++;
                }
            }
        }
        return ArrayList;
    }


    /*package*/ Discipline getDiscipline(String disc) throws NoSuchDisciplineIdException {
        for (Discipline d: _disciplines){
            if (disc.equals(d.getName())) {
                return d;
            }
        } throw new NoSuchDisciplineIdException(disc);
    }

    /*package*/ void createProject(String dis,String name) throws NoSuchDisciplineIdException {
        Discipline d = null;
        for(Discipline dis: _disciplines){
            if (dis.equals(d.getName())){
                d = dis;
            }
        } if (d == null){
            throw new NoSuchDisciplineIdException(dis);
        } else{
            d.createProject(name);
        }
    }


    /*package*/ void closeProject(String strDis, String name) throws NoSuchDisciplineIdException, NoSuchProjectIdException {
        Discipline d = null;
        for(Discipline dis: _disciplines){
            if (strDis.equals(d.getName())){
                d = dis;
            }
        } if (d == null){
            throw new NoSuchDisciplineIdException(strDis);
        } else{
            ArrayList<Project> projects= new ArrayList<Project>();
            projects = d.getAllProjects(name);
            boolean suc = false;
            for(Project proj: projects){
                if (name.equals(proj.getName())){
                    proj.close();
                    suc = true;
                }
            } if (suc != true){
                throw new NoSuchProjectIdException(name);
            }
        }
    }


}
