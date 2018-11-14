import java.io.*;
import java.util.ArrayList;


public class ReadWrite {
    public static ArrayList<Person> read(String input_path) {
        ArrayList<Person> rtn = new ArrayList<Person>();
        String line = null;

        try {
            FileReader fr = new FileReader(input_path);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                for (int i = 0; i < data.length; i++) data[i] = data[i].trim();
                Person p = new Person(data[0], data[1], data[2], data[3], data[4]);
                rtn.add(p);
            }


        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find file '" + input_path + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + input_path + "'");
        }

        return rtn;
    }

    public static void write(ArrayList<Person>[] groups, String output_path) {
        ArrayList<Person> g1 = groups[0];
        ArrayList<Person> g2 = groups[1];
        ArrayList<Person> g3 = groups[2];
        ArrayList<Person> g4 = groups[3];
        int[] sizes = new int[]{g1.size(), g2.size(), g3.size(), g4.size()};
        int max_index = max(sizes);

        while (g1.size() < max_index) g1.add(new Person());
        while (g2.size() < max_index) g2.add(new Person());
        while (g3.size() < max_index) g3.add(new Person());
        while (g4.size() < max_index) g4.add(new Person());

        FileWriter fw = null;
        try {
            fw = new FileWriter(output_path);
            String header = "Group1, Group2, Group3, Group4\n";
            fw.append(header);
            for (int i = 0; i < max_index; i++) {
                String line = g1.get(i).name + ", " + g2.get(i).name + ", " + g3.get(i).name + ", " + g4.get(i).name + "\n";
                fw.append(line);
            }
            System.out.println("CSV file was created successfully !!!");

        } catch (IOException ex) {
            System.out.println("Error in CsvFileWriter !!!");
            ex.printStackTrace();
        } finally {
            try {
                fw.flush();
                fw.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    private static int max(int[] arr) {
        int rtn = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (rtn < arr[i]) rtn = arr[i];
        }
        return rtn;
    }
}
