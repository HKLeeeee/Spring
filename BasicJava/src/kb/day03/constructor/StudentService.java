package kb.day03.constructor;

/**
 * 학생들의 정보를 관리하는 Businness Logic 클래스
 * ex) 등록, 수정, 삭제, 전체검색, 부분 검색
 */
public class StudentService {
    private int n;
    private Student[] students;
    private int savedCnt=0;
    /**
     * 학생 5명 초기화
     */
    public StudentService(int n) {
        this.n = n;
        this.students = new Student[n];
        students[savedCnt++] = new Student("희정1", 23, "서울");
        students[savedCnt++]  = new Student("희정2", 23, "서울");
        students[savedCnt++] = new Student("희정3", 23, "서울");
        students[savedCnt++]  = new Student("희정4", 23, "서울");
        students[savedCnt++]  = new Student("희정5", 23, "서울");
    }


    /**
     * 전체학생 검색
     */
    public Student[] findAll(){
//        for (Student student : students){
//            System.out.println(student);
//        } // -> 서비스 코드에서 출력 x
        return students;
    }

    /** document 주석
     * 이름에 해당하는 학생정보 검색(이름은 중복안됨)
     * @return : 찾는 경우 Student 리턴, 없는 경우 null
     * @param name: 찾을 이름 정보
     */
    public Student findByName(String name) {
        for (Student student : students) {
            if (student.getName() == name) {
                return student;
            }
        }
        return null;
    }

    public int getSavedCnt() {
        return savedCnt;
    }
}
