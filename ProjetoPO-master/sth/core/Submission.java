package sth.core;

public class Submission{
    private String _message;
    private Student _student;

    public Submission(Student st,String message){
        _message=message;
        _student=st;
    }
    /*package*/String toString(){
        return _message;/*id do aluno??*/
    }
    /*package*/int getStudentId(){
        return _student.getId();/*id do aluno??*/
    }
}
