package week2.task3;

public class Task3 {
}

//TODO: khai báo 3 class tương ứng với 3 đối tượng thực tế ở dưới

class Dog {
    String name;
    String sex;
    double wieght;

    public Dog(String name, String sex, float wieght) {
        this.name = name;
        this.sex = sex;
        this.wieght = wieght;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getWieght() {
        return wieght;
    }
    public void setWieght(double wieght) {
        this.wieght = wieght;
    }

    //phương thức eat
    public void eat( String food) {
        System.out.println(this.name +" ăn " + food);

    }

    //phương thức hate
    public void  hate(String something) {
        System.out.println(this.getName() +" ghét " + something);
    }

    //phương thức đo cân nặng
    public void docannang(){
        if(this.wieght>10) System.out.println("This dog is fat");
        else if(this.wieght<3) System.out.println("This dog is skinny");
        else System.out.println("This dog is handsome");
    }
}

class Teacher{
    String name;
    String sex;
    int age;

    public Teacher(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //phương thức dậy học lớp nào
    public void whatclass(String ws){
        System.out.println("Thầy dậy lớp " + ws);
    }

    //phương thức so tuổi
    public void youngOrOld(){
        if(this.age<22) System.out.println("Thầy còn trẻ");
        else System.out.println("Thầy đã già");
    }

    //phương thức cho điểm học sinh
    public void diem( double diem){
        if(diem > 8) System.out.println("Thầy đẹp trai");
        else System.out.println("Thầy hết đẹp trai rồi");
    }
}

class Player{
    String id;
    int level;
    int gold;

    public Player(String id, int level, int gold) {
        this.id = id;
        this.level = level;
        this.gold = gold;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    //phương thức nhận xét lv
    public void nhanXetLv(){
        if(this.level<20) System.out.println("Player " + this.id + " is NOOB");
        else if(this.level<70) System.out.println("Player " + this.id + " is GOOD");
        else System.out.println("Player " + this.id + " is MASTER");
    }

    //phương thức nhận xét vang
    public void nhanXetVang(){
        if(this.gold<100000) System.out.println("Player " + this.id + " is POOR");
        else if(this.gold<10000000) System.out.println("Player " + this.id + " is NORMAL");
        else System.out.println("Player " + this.id + " is RICK");
    }

    //phương thức đo thời gian chơi
    public void sogio( int hours){
        if(hours>16) System.out.println("Thằng này nghiện game");
        else System.out.println("Thằng này bình thường");
    }
}