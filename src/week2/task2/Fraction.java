package week2.task2;

import java.util.*;


public class Fraction {

    // TODO: khai báo các thuộc tính
    private int numerator;
    private int denominator;

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public Fraction(int numerator, int denominator) {
        // TODO: khởi tạo giá trị cho các thuộc tính numberator (tử số), denominator (mẫu số)
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // hàm tối giản phân số và đổi dấu
    public static void toigian(Fraction n) {
        if(n.denominator==0) return;
        int a = n.numerator;
        int b = n.denominator;
        int tmp;
        while(b!=0){
            tmp = a%b;
            a = b;
            b = tmp;
        }
        n.denominator /= a;
        n.numerator /= a;
        if(n.numerator > 0 && n.denominator < 0) {
            n.numerator *= -1;
            n.denominator *= -1;
        }
    }

    public Fraction add(Fraction other) {
        // TODO: Phương thức cộng hai phân số (this và other), trả về đối tượng Fraction mới
        Fraction add = new Fraction(1,1);
        add.numerator = this.numerator*other.denominator + other.numerator*this.denominator;
        add.denominator = this.denominator*other.denominator;
        toigian(add);
        return add;
    }

    public Fraction subtract(Fraction other) {
        // TODO: Phương thức trừ hai phân số (this và other), trả về đối tượng Fraction mới
        Fraction sub = new Fraction(1,1);
        sub.numerator = this.numerator*other.denominator - other.numerator*this.denominator;
        sub.denominator = this.denominator*other.denominator;
        if(sub.numerator < 0){
            sub.numerator *= -1;
            toigian(sub);
            sub.numerator *= -1;
        }
        else toigian(sub);
        return sub;
    }

    public Fraction multiply(Fraction other) {
        // TODO: Phương thức nhân hai phân số (this và other), trả về đối tượng Fraction mới
        Fraction mul = new Fraction(1,1);
        mul.numerator = this.numerator*other.numerator;
        mul.denominator = this.denominator*other.denominator;
        toigian(mul);
        return mul;
    }

    public Fraction divide(Fraction other) {
        // TODO: Phương thức chia hai phân số (this và other), trả về đối tượng Fraction mới
        Fraction div = new Fraction(1,1);
        div.numerator = this.numerator*other.denominator;
        div.denominator = this.denominator*other.numerator;
        toigian(div);
        return div;
    }

    // So sanh hai phan so co bang nhau hay khong
    public boolean equals(Object obj){
        if (obj instanceof Fraction)
        {
            Fraction other = (Fraction) obj;
            if (this.numerator * other.denominator == other.numerator * this.denominator)
            {
                return true;
            }
            else {
                return false;
            }
        }
        else{
            return false;
        }
    }
}
