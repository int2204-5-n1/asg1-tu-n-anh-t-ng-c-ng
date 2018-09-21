package week1;

public class StudentManagement {

    // TODO: khai báo thuộc tính students là array chứa các đối tượng thuộc lớp Student (max. 100)

    public static Student students[]=new Student[100]; //Student[] student = new Student[100];
    public int dem = 0;

    public boolean sameGroup(Student s1, Student s2) {
        return (s1.getGroup().equals(s2.getGroup()));
    }

    void studentsByGroup() {
        for(int i=0 ; i < dem ; i++) {
            boolean check = true;
            for (int j = 0; j < i; j++)
                if (students[i].getGroup().equals(students[j].getGroup())) {
                    check = false;
                    break;
                }
            if (check == true) {

                System.out.println("Group " + students[i].getGroup() + ":");
//                System.out.println("\n");
                for (int j = i; j < dem; ++j)
                    if (students[i].getGroup().equals(students[j].getGroup())) {
                        System.out.println(students[j].getInfo());
//                        System.out.println("\n");
                    }
                System.out.println("");
            }

        }
    }

    void removeStudent(String id) {
        int index = 0;
        for(int i=0; i<dem; i++) if (students[i].getId().equals(id)) index = i;
        for(int j= index; j<dem-1;j++) students[j] = students[j+1];
        students[dem-1]= null;
        dem--;
    }

    public static void main(String[] args) {
        Student s1 = new Student("Nguyen Van A","16021111","nguyenvana@gmail.com");
        Student s2 = new Student("Nguyen Van B","16022222","nguyenvanb@gmail.com");
        Student s3 = new Student("Nguyen Van C","16023333","nguyenvanc@gmail.com");
        Student s4 = new Student("Nguyen Van D","16024444","nguyenvand@gmail.com");
        Student s5 = new Student();

        s2.setGroup("INT22042");
        s5.setGroup("INT22042");

        StudentManagement sm = new StudentManagement();
        sm.students[0] = s1;
        sm.dem ++;
        sm.students[1] = s2;
        sm.dem ++;
        sm.students[2] = s3;
        sm.dem ++;
        sm.students[3] = s4;
        sm.dem ++;
        sm.students[4] = s5;
        sm.dem ++;

        System.out.println("Test sameGroup :");
        System.out.println("s1 vs s2: " + sm.sameGroup(s1,s2));
        System.out.println("s2 vs s3: " + sm.sameGroup(s2,s3));
        System.out.println("s1 vs s3: " + sm.sameGroup(s1,s3));
        System.out.println("---------------------------------------");

        System.out.println("Test student by group :\n");
        sm.studentsByGroup();
        System.out.println("---------------------------------------");

        System.out.print("Test remove ");
        sm.removeStudent("16022222");
        System.out.println("id 16022222: ");
        for (int i = 0 ; i < sm.dem; i ++){
            System.out.println(sm.students[i].getInfo());

        }
    }
}
