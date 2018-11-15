import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        String input_path = "/Users/Philip/Desktop/input.csv";

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        System.out.println();
        String d = dateFormat.format(date);

        String output_path = "/Users/Philip/Desktop/" + d + "分組.csv";

        ArrayList<Person> people = ReadWrite.read(input_path);
        ArrayList<Person>[] groups = Grouping.grouping(people);

        ReadWrite.write(groups, output_path);

    }
}
