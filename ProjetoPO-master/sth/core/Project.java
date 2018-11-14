package sth.core;
import java.util.List;
import java.util.Iterator;

public class Project{
    private String _name;
    private String _description;
    private boolean closed;
    private Survey _survey;
    private List<Submission> _submissions;

    public Project(String name,String des){
        _name=name;
        _description=_description;
        closed=false;
        _submissions=new List<Submission>();
    }
    /*package*/String getName(){
        return _name;
    }
    /*package*/void close(){
        closed=true;
    }                                       /*duvidas*/
    /*package*/ void setSuvey(Survey survey){
        _survey=survey;
    }
    /*package*/ Survey getSurvey(){
        return _survey;

    }
    /*package*/ void addSubmissions(Studen st,String message){

    }
}
