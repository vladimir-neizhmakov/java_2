package lesson_3;


import java.util.HashMap;
import java.util.Set;


public class WordsOfText {

    String[] arr;
    HashMap<String, Integer> map = new HashMap<>();

    public WordsOfText(String text) {
       this.arr = text.toLowerCase().split(" ");
       FillMap();
    }

    public String CountWords() {
        String str="";
        for (String k : map.keySet()) {
            str = str + "Слово '"+ k + "' встречается " + map.get(k)+" раз\n";
        }
        return str;
    }

    public Set<String> ExtractWords (){
        return map.keySet();
    }

    private void FillMap () {
        for (String s:arr) {
            int counter=0;
            for (int i = 0; i < arr.length; i++) {
                if (s.equals(arr[i])) {
                    counter++;
                }
            }
            map.put(s,counter);
        }
    }

}
