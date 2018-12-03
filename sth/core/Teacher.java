package sth.core;
import java.util.Iterator;
import java.util.*;
import sth.core.exception.BadEntryException;
import sth.core.exception.NoSuchDisciplineIdException;
import sth.core.exception.NoSuchProjectIdException;
import sth.core.Discipline.DisciplineComparator;
import sth.core.Discipline;
import sth.core.Course.CourseComparator;
import sth.core.Course;

public class Teacher extends Person implements java.io.Serializable{
    private ArrayList<Discipline> _disciplines;
    private ArrayList<Course> _courses;

    public Teacher(int id,String name,int phoneNumber){
        super(id,name,phoneNumber);
        _disciplines= new ArrayList<Discipline>();
        _courses= new ArrayList<Course>();
    }


    void parseContext(String lineContext, School school) throws BadEntryException {
        String components[] =  lineContext.split("\\|");

        if (components.length != 2)
            throw new BadEntryException("Invalid line context " + lineContext);
        int flag=0;
        Course course = school.parseCourse(components[0]);
        if (_courses.size() != 0){
            for(Course c : _courses){
                if((course.getName()).equals(c.getName())){
                    flag=1;
                }
            }
        }

        if(flag==0){
            _courses.add(course);
        }
        Discipline discipline = course.parseDiscipline(components[1]);
        _disciplines.add(discipline);
        discipline.addTeacher(this);


    }

    /*package*/ void addDiscipline(Discipline d){
    _disciplines.add(d);
    }
    /*package*/ ArrayList<Course> getCourses(){
        return _courses;
    }



    public ArrayList<String> tooString(){
        String first = "DOCENTE|"+super.toString();
        ArrayList<Discipline> _disciplinesort= new ArrayList<Discipline>(_disciplines);
        Discipline dis = new Discipline();
        Discipline.DisciplineComparator comp = dis.new DisciplineComparator();
        _disciplinesort.sort(comp);
        ArrayList<Course> _cour=new ArrayList<Course>(_courses);
        Course cour = new Course();
        Course.CourseComparator comp1 = cour.new CourseComparator();
        _cour.sort(comp1);
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList=transforma(_cour,_disciplinesort,first);
        return arrayList;

    }
    /*package*/static ArrayList<String> transforma(ArrayList<Course> ArrayListCourse,ArrayList<Discipline> ArrayListDis,String first){
        ArrayList<String> disciplines = new ArrayList<String>();
        disciplines.add(first);
        for(Course c:ArrayListCourse){
            for(Discipline d:ArrayListDis){
                if(((d.getCourse()).getName()).equals(c.getName())){
                    disciplines.add("* "+ c.getName()+" - "+d.getName());
                }
            }
        }
        return disciplines;
    }


    /*package*/ Discipline getDiscipline(String disc) throws NoSuchDisciplineIdException {
        for (Discipline d: _disciplines){
            if (disc.equals(d.getName())) {
                return d;
            }
        } throw new NoSuchDisciplineIdException(disc);
    }

    /*package*/ void createProject(String disC,String name) throws NoSuchDisciplineIdException {
        Discipline d = null;
        for(Discipline dis: _disciplines){
            if (disC.equals(d.getName())){
                d = dis;
            }
        } if (d == null){
            throw new NoSuchDisciplineIdException(disC);
        } else{
            d.createProject(name);
        }
    }


    /*package*/ void closeProject(String strDis, String name) throws NoSuchDisciplineIdException, NoSuchProjectIdException {
        int success = 0;
        Iterator<Discipline> iterator=_disciplines.iterator();
        Discipline d= iterator.next();
        while(iterator.hasNext()){
            d= iterator.next();
            if(d.getName().equals(strDis)){
                success=1;
                break;
            }

        }
        if (success == 0){
            throw new NoSuchDisciplineIdException(strDis);
        } else{
            ArrayList<Project> projects= new ArrayList<Project>();
            projects = d.getAllProjects();
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
