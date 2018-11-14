import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String input_path = "/Users/Philip/Desktop/input.csv";
        String output_path = "/Users/Philip/Desktop/output.csv";
        ArrayList<Person> people = ReadWrite.read(input_path);
        ArrayList<Person>[] groups = Grouping.grouping(people);

        ReadWrite.write(groups, output_path);

    }
}
