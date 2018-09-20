package week2.task2;


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
        if(n.numerator==0) return;
        int a = n.numerator;
        int b = n.denominator;
        if(a > 0 && b > 0) {
            int tmp;
            while (b != 0) {
                tmp = a % b;
                a = b;
                b = tmp;
            }
            n.denominator /= a;
            n.numerator /= a;
        }
        else if(a < 0 && b < 0) {
            a *= -1;
            b *= -1;
            int tmp;
            while (b != 0) {
                tmp = a % b;
                a = b;
                b = tmp;
            }
            a *= -1;
            n.denominator /= a;
            n.numerator /= a;
        }
        else{
            if(a < 0) a *= -1;
            if(b < 0) b *= -1;
            int tmp;
            while (b != 0) {
                tmp = a % b;
                a = b;
                b = tmp;
            }
            n.denominator /= a;
            n.numerator /= a;
            n.numerator *= -1;
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
    public boolean equals(Fraction other){
        Fraction n = new Fraction(this.numerator, this.denominator);
        toigian(n);
        toigian(other);
        if(n.numerator == other.numerator && n.denominator == other.denominator)
            return true;
        else return false;
    }
}
