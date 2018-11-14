package sth.core;
import sth.core.exception.BadEntryException;
import java.util.Iterator;
import java.util.List;


    public class Course{
        private String _name;
        private List<Student> _students;
        private List<Student> _representatives;
        private List<Discipline> _disciplines;


        public Course(String name){
            _name = name;
        }

        public String getName(){
            return _name;
        }

        /*protected*/ void addDiscipline(Discipline d){
            _disciplines.add(d);
        }

        /*protected*/ void addStudent(Student st){
            _students.add(st);
            st.setCourse(this);

        }

        /*protected*/ void addRepresentative(Student st){
            if (st.isRepresentative()){
                _representatives.add(st);
            }

            else{
                throw new BadEntryException("No Max disciplines exceeded");

            }
        }

        /*protected
    }
