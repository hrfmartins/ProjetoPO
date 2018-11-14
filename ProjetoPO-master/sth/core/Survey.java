package sth.core;

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
        Answer a= new(message,hours);

    }
    /*package*/ void getResults(){

    }
}
