package kb.day02;


public class Score {
    private int totalScore(int kor, int eng, int math) {
        return kor+eng+math;
    }

    private double meanScore(int totalScore, double n){
        return totalScore/n;
    }

    private char grade(double meanScore) {
        return (meanScore >= 80)? 'A' : 'F';
    }

    public void printInfo(String name, int kor, int eng, int math){
        System.out.printf("이름 : %s\n", name);
        System.out.printf("국어점수 : %s\n", kor);
        System.out.printf("영어점수 : %d\n", eng);
        System.out.printf("수학점수 : %d\n", math);

        int totalScore = totalScore(kor, eng, math);
        double meanScore = meanScore(totalScore, 3);
        char grade = grade(meanScore);

        System.out.printf("총점 : %d\n", totalScore);
        System.out.printf("평균 : %2f\n", meanScore);
        System.out.printf("등급 : %s\n", grade);
        System.out.println();
    }

    public void printInfo(String name, int totalScore, double meanScore, char grade){
        System.out.printf("이름 : %s\n", name);
        System.out.printf("총점 : %d\n", totalScore);
        System.out.printf("평균 : %2f\n", meanScore);
        System.out.printf("등급 : %s\n", grade);
        System.out.println();
    }
}
