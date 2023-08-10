package kb.day03;

class Test {
    private String s;
    private int i;

    public Test() {
        this(3);
    }
    public Test(int i) {
        this("hello", i);
    }
    public Test(String s) {
        this(s, 3);
    }

    public Test(String s, int i) {
        this.s = s;
        this.i = i;
    }

    public void aa(Object... obj) {
        System.out.println("Test.aa");
        for (Object o : obj) {
            System.out.print(o+" ");
        }
        System.out.println();
    }
}


public class VariableArgsExam {
    public static void main(String[] args) {
        Test t = new Test();
        t.aa(1);
        t.aa();
        t.aa(1,2,3);
        t.aa(1,3,5);
        t.aa(1, 2.4, 'S');




    }
}
