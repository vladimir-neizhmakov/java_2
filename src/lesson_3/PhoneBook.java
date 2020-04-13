package lesson_3;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private Person person = new Person();
    private HashMap<Integer, String> phone = new HashMap<>();
    private HashMap<Integer, String> email = new HashMap<>();

    public void addRecord(String family, String tel, String mail){
        int currentID = person.addPerson(family);
        phone.put(currentID,tel);
        email.put(currentID,mail);
    }
/*
    public String getRecordByFamily(String family){
        String str="";
        for (Integer key:person.getPersonKeyByFamily(family)
             ) {
            str +="Фамилия: "+person.getPersonByKey(key)+" Телефон: "+phone.get(key)+" EMail: "+email.get(key)+"\n";
        }
        return str;
    }
*/
    public ArrayList<String> getPhoneByFamily(String family){
        ArrayList<String> al = new ArrayList();
        for (Integer key:person.getPersonKeyByFamily(family)
        ) {
            al.add(phone.get(key));
        }
        return al;
    }

    public ArrayList<String> getMailByFamily(String family){
        ArrayList<String> al = new ArrayList();
        for (Integer key:person.getPersonKeyByFamily(family)
        ) {
            al.add(email.get(key));
        }
        return al;
    }
}
