package sth.core;

public abstract class Person{
    private int _id;
    private String _name;
    private int _phoneNumber;

    public Person(int id, int name, int phoneNumber){
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

    public void setPhoneNumber(int i){
        if (i > 0){
            _phoneNumber = phoneNumber;
        }
    }

    public int getPhoneNumber(){
        return _phoneNumber;
    }

    public String toString(){
        String p = "";
        return "Name: " + _name + " ID: "+ _id +
         "Phone Number: "+ _phoneNumber;
    }

    void parseContext(String context, School school) throws BadEntryException {
        throw new BadEntryException("Should not have extra context: " + context);
    }

}
