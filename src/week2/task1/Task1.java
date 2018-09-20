package week2.task1;

public class Task1 {

    public static int gcd(int a, int b) {
        // TODO: Tính ước chung lớn nhất của 2 số a, b
        if(a==0) return b;      // nếu a=0 thì ucln sẽ là số b!=0
        else if(b==0) return a;      // tương tự trên
        else {
            int tmp;
            while (b != 0) {
                tmp = a % b;
                a = b;
                b = tmp;
            }
            return a;
        }
    }

    public static int fibonacci(int n) {
        // TODO: Tìm số fibonacci ở vị trí n
        if(n==0) return 0;          //f(0) = 0
        else if(n==1) return 1;      //f(1) = 1
        else return fibonacci(n-1) + fibonacci(n-2);    // đệ quy
    }
}
