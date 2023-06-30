import java.util.ArrayList;

public class TestingArray {
    public static void main(String[] args) {
        ArrayList<String> ar = new ArrayList<>();

        // var ar =new LinkedList<>(); alitle
        // var ar =new ArrayList<>(); medium
        // var ar =new Vector<>(); alot of data

        ar.add("Java");
        ar.add("is");
        ar.add("OOP");
        ar.add("and");
        ar.add("easy");
        // for (int i = 0; i < ar.size(); i++) {
        // System.out.println(ar.get(i));
        // }
        ar.set(2, "Object Oriented Programming");
        ar.add(1, "Programming language");
        for (String /* or var */ s : ar) { // foreach
            System.out.println(s);
        }

    }
}
