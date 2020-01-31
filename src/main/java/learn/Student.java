package learn;

/**
 * @author zh_yan
 * @ClassName Student
 * @Description TODO
 * @Date 2020/1/12
 * @Version 1.0
 **/
public class Student {
    private Integer id;
    private String studentName;
    private Phone phone;

    public Student(Integer id, String studentName, Phone phone) {
        this.id = id;
        this.studentName = studentName;
        this.phone = phone;
    }

    //省略getter/setter

    public Integer getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public void study(Teacher teacher) {
        teacher.teach();
    }
}
