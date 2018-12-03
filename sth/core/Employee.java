package sth.core;
import java.util.List;
import java.util.Iterator;
import java.util.*;


public class Employee extends Person  {

    public Employee(int id, int phoneNumber, String name){
        super(id, name, phoneNumber);
    }
    public ArrayList<String> tooString(){
        ArrayList<String> stringArr= new ArrayList<String>();
        String str = "FUNCIONÁRIO|";
        str+= super.toString();
        stringArr.add(str);
        return stringArr;
    }
}
