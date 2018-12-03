package sth.core;
import sth.core.exception.BadEntryException;
import sth.core.exception.NoSuchDisciplineIdException;
import sth.core.exception.NoSuchPersonIdException;
import java.util.*;

public abstract class Person implements java.io.Serializable{

    private static final long serialVersionUID = 201810051538L;
    private int _id;
    private String _name;
    private int _phoneNumber;

    public Person(int id, String name, int phoneNumber){
        _id = id;
        _name = name;
        _phoneNumber = phoneNumber;
    }

    public String getName(){
        return _name;
    }

    public int getId(){
        return _id;
    }

    public void setPhoneNumber(int phoneNumber){
        if (phoneNumber > 0){
            _phoneNumber = phoneNumber;
        }
    }

    public int getPhoneNumber(){
        return _phoneNumber;
    }
    public String toString(){
        String number=""+_phoneNumber;
        String number1=number.substring(0, 3);
        String number2=number.substring(3,6);
        String number3=number.substring(6,9);
        return ""+_id+"|"+number1+" "+number2+" "+number3+"|"+_name;
    }

    public ArrayList<String> tooString(){
        ArrayList<String> arrLst = new ArrayList<String>();
        return arrLst;
    }






    void parseContext(String context, School school) throws BadEntryException {
        throw new BadEntryException("Should not have extra context: " + context);
    }
    class IdComparator implements Comparator<Person>{
        @Override
        public int compare(Person a, Person b){
            if (a.getId() < b.getId()) {
                return -1;
            } if (a.getId() > b.getId()) {
                return 1;
            } return 0;
        }
    }




}
