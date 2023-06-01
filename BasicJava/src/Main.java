import java.util.Scanner;

import static java.lang.Math.abs;

class StaticSample{
    public int n;
    public void g(){
        m = 20;
    }

    public static int m;

    public static void f(){
        m = 5 ;
    }
}

// Static을 이용한 환율 계산기
class CurrencyConverter{
    private static double rate;

    public static double toDollor(double won) {
        return won / rate;
    }

    public static double toKWR(double dollar) {
        return dollar * rate;
    }

    public static void setRate(double r) {
        rate = r;
    }
}

abstract class Shape{
    public abstract void draw();
}

class Circle extends Shape{

    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

public class Main {
    public static void main(String[] args) {
        //System.out.println(abs(-5)); Math 패키지도 static function 으로 구성됨
        Scanner sc = new Scanner(System.in);
        System.out.print("환율(1달러)");
        double rate = sc.nextInt();
        CurrencyConverter.setRate(rate);
        System.out.println("백만원은 $ " + CurrencyConverter.toDollor(1000000) + "입니다.");
        System.out.println("$100은 " + CurrencyConverter.toKWR(100) + "입니다.");
        sc.close();

        Circle c = new Circle();
        c.draw();
    }
}