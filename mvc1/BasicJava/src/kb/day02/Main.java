package kb.day02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        int m, kor, math, eng, num;
        Score score = new Score();
        boolean exit = false;
        while(!exit){
            System.out.print("1. 성적표구하기\n2. 종료\n>> ");
            m = sc.nextInt();
            switch (m){
                case 1:
                    System.out.print("이름, 국어점수, 영어점수, 수학점수를 차례로 입력하시오 >> ");
                    name = sc.next();
                    kor = sc.nextInt();
                    eng = sc.nextInt();
                    math = sc.nextInt();

                    score.printInfo(name, kor, eng, math);
                    //
                    break;
                case 2:
                    // 종료
                    exit = true;
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못입력하셨습니다.");
            }
        }
        sc.close();
    }
}
