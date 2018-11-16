package sth.core;
import java.util.ArrayList;
import java.util.Iterator;

public class Project{
    private String _name;
    private boolean _closed;
    /*private Survey _survey;*/
    /*private List<Submission> _submissions;*/

    public Project(String name){
        _name=name;
        _closed=false;
        /*_submissions=new List<Submission>();*/
    }


    /*package*/String getName(){
        return _name;
    }


    /*package*/ void close(){
        _closed=true;
    }


                                          /*duvidas*/
    /*package void setSuvey(Survey survey){
        _survey=survey;
    }



    package Survey getSurvey(){
        return _survey;
    }



    package void addSubmissions(Studen st,String message){

    }
    */

}
