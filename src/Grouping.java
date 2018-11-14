import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Grouping {

    static ArrayList<Person> group1 = new ArrayList<>();
    static ArrayList<Person> group2 = new ArrayList<>();
    static ArrayList<Person> group3 = new ArrayList<>();
    static ArrayList<Person> group4 = new ArrayList<>();

    static ArrayList<Person> tc = new ArrayList<>();
    static ArrayList<Person> tnc = new ArrayList<>();
    static ArrayList<Person> ntc = new ArrayList<>();
    static ArrayList<Person> ntnc = new ArrayList<>();

    public static ArrayList<Person>[] grouping(ArrayList<Person> people) {
        ArrayList<Person>[] group = new ArrayList[] {group1, group2, group3, group4};


        for (Person p : people) {
            if (!p.fixed_group.equals("0")) {
                int g_index = Integer.parseInt(p.fixed_group) - 1;
                group[g_index].add(p);
            } else {
                categorize(p);
            }
        }


        Collections.shuffle(tc);
        Collections.shuffle(tnc);
        Collections.shuffle(ntc);
        Collections.shuffle(ntnc);

        ArrayList<Person> non_fixed = new ArrayList<>();
        non_fixed.addAll(tc);
        non_fixed.addAll(tnc);
        non_fixed.addAll(ntc);
        non_fixed.addAll(ntnc);

        Random r = new Random();
        int i = r.nextInt(4);

        for (Person p : non_fixed) {
            group[i % 4].add(p);
            i++;
        }

        return group;
    }

    private static String categorize(Person person) {
        if (person.talk) { //talk
            if (person.christian) { //talk & christian
                tc.add(person);
                return "TC";
            } else { //talk, not christian
                tnc.add(person);
                return "TNC";
            }
        } else { //not talk
            if (person.christian) {
                ntc.add(person);
                return "NTC";
            } else {
                ntnc.add(person);
                return "NTNC";
            }
        }
    }
}
