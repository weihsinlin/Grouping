public class Person {
    String name, gender;
    boolean talk, christian, counselor;
    String fixed_group;

    public Person(String name, String gender, String talk, String christian, String counselor, String fixed_group) {
        this.name = name;
        this.gender = gender.toUpperCase();
        this.fixed_group = fixed_group;
        this.talk = talk.toUpperCase().equals("Y");
        this.christian = christian.toUpperCase().equals("Y");
        this.counselor = counselor.toUpperCase().equals("Y");
    }

    public Person() {
        this.name = "";
    }

    @Override
    public String toString() {
        return "Name: " + name + " Talk = " + talk + " Christian = " + christian + " Counselor = " + counselor + " Fixed_group = " + fixed_group;
    }

}
