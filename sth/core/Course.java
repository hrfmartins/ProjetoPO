package sth.core;
import java.util.*;
import sth.core.exception.BadEntryException;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Comparator;


    public class Course{
        private String _name;
        private ArrayList<Student> _students;
        private ArrayList<Student> _representatives;
        private ArrayList<Discipline> _disciplines;


        public Course(String name){
            _name = name;
        }


        /*package*/ void parseDiscipline(String name){
            Discipline dis = new Discipline(name, this);
            _disciplines.add(dis);
            dis.addCourse(this);
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


        /*protected*/ void removeRepresentative(Student st){
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
