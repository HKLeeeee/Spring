package kb.day03.constructor;

public class StudentView {
    public static void main(String[] args) {
        System.out.println("***학생 관리 프로그램***");
        StudentService studentService = new StudentService(10);

        System.out.println("1. 전체학생 검색하기 ----");
        Student[] students = studentService.findAll();
        for(Student s : students){
            if (s == null) {
                break;
            }
            System.out.println(s);
        }

        System.out.println("2. 이름에 해당하는 학생 검색하기 ----");
        Student std = studentService.findByName("희정3");
        System.out.println("std = " + std);



    }
}
