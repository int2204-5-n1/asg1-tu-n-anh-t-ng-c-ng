package week1;

public class Student {

    // TODO: khai báo các thuộc tính cho Student

    private String name, id, group, email;

    // TODO: khai báo các phương thức getter, setter cho Student

    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public String getGroup(){
        return group;
    }
    public String getEmail(){
        return email;
    }
    public void setName(String n){
        name = n;
    }
    public void setId(String n){
        id = n;
    }
    public void setGroup(String n){
        group = n;
    }
    public void setEmail(String n){
        email = n;
    }

    /**
     * Constructor 1
     */
    Student() {
        this.name = "Student";
        this.id = "000";
        this.group = "INT22041";
        this.email = "uet@vnu.edu.vn";
    }

    /**
     * Constructor 2
     * @param n
     * @param sid
     * @param em
     */
    Student(String n, String sid, String em) {
        this.name = n;
        this.id = sid;
        this.group = "INT22041";
        this.email = em;
    }

    /**
     * Constructor 3
     * @param s
     */
    Student(Student s) {
        this.name = s.getName();
        this.id = s.getId();
        this.group = s.getGroup();
        this.email = s.getEmail();
    }

    String getInfo() {
        String result =this.name + " " +this.id +" " +this.group + " " + this.email;
        return  result;
    }
}
