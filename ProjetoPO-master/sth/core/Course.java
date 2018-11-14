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
            if (!(st.isRepresentative()) && _representatives.length() != 7){
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
