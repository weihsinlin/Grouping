import java.util.ArrayList;
import java.util.Collections;

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
        ArrayList<Person>[] groups = new ArrayList[] {group1, group2, group3, group4};


        for (Person p : people) {
            if (!p.fixed_group.equals("0")) {
                int g_index = Integer.parseInt(p.fixed_group) - 1;
                groups[g_index].add(p);
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


//        Random r = new Random();
//        int i = r.nextInt(4);
        int i = which_min(groups);

        for (Person p : non_fixed) {
            groups[i % 4].add(p);
            i++;
        }

        return groups;
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

    private static int which_min(ArrayList<Person>[] groups) {
        int[] arr = new int[] {groups[0].size(), groups[1].size(), groups[2].size(), groups[3].size()};
        int min = arr[0];
        int rtn = 0;
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                rtn = i;
            }
        }

        return rtn;


    }
}
