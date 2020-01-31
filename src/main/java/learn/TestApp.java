package learn;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author zh_yan
 * @ClassName TestApp
 * @Description TODO
 * @Date 2020/1/12
 * @Version 1.0
 **/
public class TestApp {
    public static void main(String[] args) {
        Phone iPhoneX =new Phone(1,"1号华为",66.6);
        Phone matePro = new Phone(1,"2号华为",55.5);
        Phone XXX = new Phone(1,"3号华为",55.5);

        Student student1 =new Student(1001,"22",iPhoneX);
        Student student2 = new Student(1002, "33", matePro);
        Student student3 = new Student(1003, "44", XXX);

        /*Set<Student> students= new HashSet<>();*/
        Set<Student> students = new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1 == o2){
                    return 0;
                }
                int result = o1.getId() - o2.getId();
                if(result == 0){
                    return o1.getStudentName().compareTo(o2.getStudentName());
                }
                return result;
            }
        });

        students.add(student1);
        students.add(student2);
        students.add(student3);

        Teacher teacher = new Teacher();
        teacher.setId(1011);
        teacher.setTeacherName("老王");
        teacher.setStudents(students);

        student1.study(teacher);

    }
}
