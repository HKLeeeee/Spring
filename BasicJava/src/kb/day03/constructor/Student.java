package kb.day03.constructor;


public class Student{
    private String name;
    private int age;
    private String addr;
    public Student(){
        this("희경", 26, "서초구");
    }
    public Student(String name, int age, String addr) {
        this(name, age);
        this.addr = addr;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}

//    Student[] students = new Student[5]; // 객체타입 -> null 로 초기화됨!


