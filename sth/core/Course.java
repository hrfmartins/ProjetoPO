package sth.core;
import java.util.*;
import sth.core.exception.BadEntryException;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Comparator;


    public class Course implements java.io.Serializable{
        private static final long serialVersionUID = 201810051538L;
        private String _name;
        private ArrayList<Student> _students;
        private ArrayList<Student> _representatives;
        private ArrayList<Discipline> _disciplines;

        public Course(){}
        public Course(String name){
            System.out.println("construtor no curso");
            _name = name;
            _students = new ArrayList<Student>();
            _representatives = new ArrayList<Student>();
            _disciplines = new ArrayList<Discipline>();
        }


        /*package*/ Discipline parseDiscipline(String name){
            for (Discipline d : _disciplines){
                if (d.getName().equals(name))
                    return d;
            }
            Discipline x = new Discipline(name, this);
            _disciplines.add(x);
            return x;
        }


        /*package*/ String getName(){
            return _name;
        }
        /*package*/ ArrayList<Discipline> getDiscipline(){
            return _disciplines;
        }


        /*protected*/ void addDiscipline(Discipline d){
            _disciplines.add(d);
        }


        /*protected*/ void addStudent(Student st){
            System.out.println(st.getName());
            _students.add(st);
            st.setCourse(this);
        }


        /*protected*/ void addRepresentative(Student st)throws BadEntryException{
            if (!(st.isRepresentative()) && _representatives.size() != 7){
                _representatives.add(st);
                st.setRepresentative(true);
            }

            else{
                if (st.isRepresentative()){
                    throw new BadEntryException("Student is already a representative");
                }
                else{
                    throw new BadEntryException("Limit of max representatives");
                }
            }
        }


        /*protected*/ void removeRepresentative(Student st) throws BadEntryException {
            if(st.isRepresentative()){
                _representatives.remove(st);
                st.setRepresentative(false);
            }

            else{
                throw new BadEntryException("Student is not a representative");
            }
        }

        class CourseComparator implements Comparator<Course>{
            @Override
            public int compare(Course a,Course b){
               if (a.getName().compareTo(b.getName()) <= -1) {
                   return -1;
               } if (a.getName().compareTo(b.getName()) >= 1) {
                   return 1;
               } return 0;
           }
       }
}
