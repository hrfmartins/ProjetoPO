package sth.core;
import java.util.List;
import java.util.Iterator;

public class Survey{
    List<Student> _students;
    List<Answer> _answers;
    /*falta o enum nao percebi muito bem*/
    public Survey(){
        _students=new List<Student>();
        _answers=new List<Answer>();
    }
    /*package*/ void open(){


    }
    /*package*/ void close(){

    }
    /*package*/ void finalize(){

    }
    /*package*/ void addAnswer(Student st,int hours,String message){
        _students.add(st);
        Answer a = new Answer(message,hours);
    }

    /*package*/ void getResults(){
    }
}
