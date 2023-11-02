import java.util.Date;

public class Teacher implements Comparable<Teacher> {
    private String firstName;
    private String lastName;
    private Date yearOfBirth;
    private TeacherCondition teacherCondition;
    private Double salary;

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public Teacher(String firstName, String lastName, Date yearOfBirth, TeacherCondition teacherCondition, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.teacherCondition = teacherCondition;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", teacherCondition=" + teacherCondition +
                ", salary=" + salary +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setTeacherCondition(TeacherCondition teacherCondition) {
        this.teacherCondition = teacherCondition;
    }

    @Override
    public int compareTo(Teacher o) {
        return this.lastName.compareTo(o.getLastName());
    }
}
