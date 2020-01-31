package learn;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.Set;

/**
 * @author zh_yan
 * @ClassName Teacher
 * @Description TODO
 * @Date 2020/1/12
 * @Version 1.0
 **/
public class Teacher {
    private Integer id;
    private String teacherName;
    private Set<Student> students;

    public Integer getId() {
        return id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void teach(){
        System.out.println(this.teacherName + "在上课");
        System.out.println("学生名单");

        students.forEach(student ->
                        System.out.println(student.getId()+","+student.getStudentName() + ","+
                                student.getPhone().getBrand())
                );
    }

    class MyComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getId()-o2.getId();//降序排列
        }
    }


}
