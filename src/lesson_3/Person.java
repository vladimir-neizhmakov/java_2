package lesson_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Person {

    private HashMap<Integer,String> person = new HashMap<>();

    public int addPerson (String family){
        Set<Integer> kset = person.keySet();
        int maxID=0;
        for (Integer k : kset) {
            maxID = maxID > k ? maxID : k;
        }
        person.put(maxID+1,family);
        return maxID+1;
    }
    public String getPersonByKey (Integer id){
        return person.get(id);
    }
    public ArrayList<Integer> getPersonKeyByFamily (String family){
        Set<Integer> kset = person.keySet();
        ArrayList al = new ArrayList();
        for (Integer k : kset) {
            if (person.get(k) == family) {al.add(k);}
        }
        return al;
    }

}
