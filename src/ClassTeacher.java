import java.util.ArrayList;
import java.util.Iterator;

public class ClassTeacher {
    private String groupName;
    private ArrayList<Teacher> teacherList;
    private Integer maxTeachers;

    public ClassTeacher(String groupName, ArrayList<Teacher> teacherList, Integer maxTeachers) {
        this.groupName = groupName;
        this.maxTeachers = maxTeachers;
        teacherList = new ArrayList<>(maxTeachers);
    }

    public void addTeacher(Teacher teacher){
        teacherList.add(teacher);
    }
    public void addSalary(Teacher teacher, Double salary){
        Iterator<Teacher> iterator;
        iterator = teacherList.iterator();
        while(iterator.hasNext()){
            Teacher teacher1 = iterator.next();
            if(teacher.equals(teacher)){
                teacher1.setSalary(teacher1.getSalary() + salary);
            }
        }
        // throw new Exception TeacherNotFound
    }
    public void removeTeacher(Teacher teacher){
        Iterator<Teacher> iterator;
        iterator = teacherList.iterator();
        while(iterator.hasNext()){
            Teacher teacher1 = iterator.next();
            if(teacher1.equals(teacher)){
                iterator.remove();
            }
        }

        // throw new Exception TeacherNotFound
    }

    public void changeCondition(Teacher teacher,TeacherCondition teacherCondition){
        Iterator<Teacher> iterator;
        iterator = teacherList.iterator();
        while(iterator.hasNext()){
            Teacher teacher1 = iterator.next();
            if(teacher1.equals(teacher)){
                teacher1.setTeacherCondition(teacherCondition);
            }
        }

        // throw new Exception TeacherNotFound
    }

    public Teacher search(String lastName) throws Exception {
        Iterator<Teacher> iterator;
        iterator = teacherList.iterator();
        while(iterator.hasNext()){
            Teacher teacher1 = iterator.next();
            if(lastName.compareTo(teacher1.getLastName()) == 0){
                return teacher1;
            }
        }
        throw new Exception("Brak nauczyciela!");
    }
  //  public  Teacher searchPartial(String lastName);





}
