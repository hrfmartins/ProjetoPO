package sth.core;

public class Answer{
    private String _message;
    private int _hours;

    public Answer(String message,int hours){
        _message=message;
        _hours=hours;
    }
    /*package*/ String getMessage(){
        return _message;
    }
    /*package*/ int getHours(){
        return _hours;
    }

}