import java.util.ArrayList;
import java.util.Collections;

public class Grouping {

    static ArrayList<Person> group1 = new ArrayList<>();
    static ArrayList<Person> group2 = new ArrayList<>();
    static ArrayList<Person> group3 = new ArrayList<>();
    static ArrayList<Person> group4 = new ArrayList<>();

    static ArrayList<Person> tcm = new ArrayList<>();
    static ArrayList<Person> tncm = new ArrayList<>();
    static ArrayList<Person> ntcm= new ArrayList<>();
    static ArrayList<Person> ntncm = new ArrayList<>();

    static ArrayList<Person> tcf = new ArrayList<>();
    static ArrayList<Person> tncf = new ArrayList<>();
    static ArrayList<Person> ntcf = new ArrayList<>();
    static ArrayList<Person> ntncf = new ArrayList<>();

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


        Collections.shuffle(tcm);
        Collections.shuffle(tncm);
        Collections.shuffle(ntcm);
        Collections.shuffle(ntncm);
        Collections.shuffle(tcf);
        Collections.shuffle(tncf);
        Collections.shuffle(ntcf);
        Collections.shuffle(ntncf);

        ArrayList<Person> non_fixed = new ArrayList<>();
        non_fixed.addAll(tcm);
        non_fixed.addAll(tncm);
        non_fixed.addAll(ntcm);
        non_fixed.addAll(ntncm);
        non_fixed.addAll(tcf);
        non_fixed.addAll(tncf);
        non_fixed.addAll(ntcf);
        non_fixed.addAll(ntncf);


//        Random r = new Random();
//        int i = r.nextInt(4);
        int i = which_min(groups);

        for (Person p : non_fixed) {
            groups[i % 4].add(p);
            i++;
        }

        return groups;
    }

    private static void categorize(Person person) {
        if (person.talk) { //talk
            if (person.christian) { //talk & christian
                if (person.gender.equals("M")) { //talk & christian & male
                    tcm.add(person);
                } else { //talk & christian & female
                    tcf.add(person);
                }
            } else { //talk, not christian
                if (person.gender.equals("M")) { //talk, not christian, male
                    tncm.add(person);
                } else { //talk, not christian, female
                    tncf.add(person);
                }
            }
        } else { //not talk
            if (person.christian) { //not talk, christian
                if (person.gender.equals("M")) { //not talk, christian, male
                    ntcm.add(person);
                } else { //not talk, christian, female
                    ntcf.add(person);
                }
            } else { //not talk, not christian
                if (person.gender.equals("M")) { //not talk, not christian, male
                    ntncm.add(person);
                } else { //not talk, not christian, female
                    ntncf.add(person);
                }
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
