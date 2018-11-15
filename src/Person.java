public class Person {
    String name, gender;
    boolean talk, christian, counselor;
    String fixed_group;

    public Person(String name, String gender, String talk, String christian, String counselor, String fixed_group) {
        this.name = name;
        this.gender = gender.toUpperCase();
        this.fixed_group = fixed_group;

        if (talk.toUpperCase().equals("Y")) {
            this.talk = true;
        } else {
            this.talk = false;
        }

        if (christian.toUpperCase().equals("Y")) {
            this.christian = true;
        } else {
            this.christian = false;
        }
        if (counselor.toUpperCase().equals("Y")) {
            this.counselor = true;
        } else {
            this.counselor = false;
        }
    }

    public Person() {
        this.name = "";
    }

    @Override
    public String toString() {
        return "Name: " + name + " Talk = " + talk + " Christian = " + christian + " Counselor = " + counselor + " Fixed_group = " + fixed_group;
    }

}
