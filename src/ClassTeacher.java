import Exceptions.MaxTeacherNumber;
import Exceptions.TeacherNotFound;
import Exceptions.ThisTeacherExists;

import java.util.*;

public class ClassTeacher {
    private String groupName;
    private ArrayList<Teacher> teacherList;

    public String getGroupName() {
        return groupName;
    }

    public Integer getMaxTeachers() {
        return maxTeachers;
    }

    private Integer maxTeachers;

    public ClassTeacher(String groupName, Integer maxTeachers) {
        this.groupName = groupName;
        this.maxTeachers = maxTeachers;
        teacherList = new ArrayList<>(maxTeachers);
    }
    public ArrayList<Teacher> getTeacherList(){
        return teacherList;
    }

    public void addTeacher(Teacher teacher) throws ThisTeacherExists, MaxTeacherNumber {
        if(teacherList.size() == maxTeachers){
            throw new MaxTeacherNumber("Max teacher number! Can't add any more teachers");
        }
        Iterator<Teacher> iterator;
        iterator = teacherList.iterator();
        while(iterator.hasNext()){
            Teacher teacher1 = iterator.next();
            if(teacher1.equals(teacher)){
                throw new ThisTeacherExists("This teacher exists");
            }
        }
        teacherList.add(teacher);
    }

    public void addSalary(Teacher teacher, Double salary) throws TeacherNotFound {
        Iterator<Teacher> iterator;
        iterator = teacherList.iterator();
        while(iterator.hasNext()){
            Teacher teacher1 = iterator.next();
            if(teacher.equals(teacher1)){
                teacher1.setSalary(teacher1.getSalary() + salary);
                return;
            }
        }
        throw new TeacherNotFound("Teacher not Found at addTeacher");
    }

    public void removeTeacher(Teacher teacher) throws TeacherNotFound {
        Iterator<Teacher> iterator;
        iterator = teacherList.iterator();
        while(iterator.hasNext()){
            Teacher teacher1 = iterator.next();
            if(teacher1.equals(teacher)){
                iterator.remove();
                return;
            }
        }

        throw new TeacherNotFound("Teacher not Found at removeTeacher");
    }


    public boolean changeCondition(Teacher teacher,TeacherCondition teacherCondition) throws TeacherNotFound {
        Iterator<Teacher> iterator;
        iterator = teacherList.iterator();

        while(iterator.hasNext()){
            Teacher teacher1 = iterator.next();
            if(teacher1.equals(teacher)){
                teacher1.setTeacherCondition(teacherCondition);
                return true;
            }
        }

        throw new TeacherNotFound("Teacher not Found at changeCondition");
    }

    public Teacher searchByLastName(String lastName) throws Exception {
        Iterator<Teacher> iterator;
        iterator = teacherList.iterator();
        while(iterator.hasNext()){
            Teacher teacher1 = iterator.next();
            if(lastName.compareTo(teacher1.getLastName()) == 0){
                return teacher1;
            }
        }
        throw new TeacherNotFound("Teacher not Found at addTeacher");
    }

    public List<Teacher> searchPartial(String query) {
        List<Teacher> results = new ArrayList<>();
        for (Teacher teacher : teacherList) {
            if (teacher.getFirstName().contains(query) || teacher.getLastName().contains(query)) {
                results.add(teacher);
            }
        }
        return results;
    }
    public int countByCondition(TeacherCondition teacherCondition){
        int counter =0;
        for (Teacher teacher: teacherList) {
            if(teacher.getTeacherCondition() == teacherCondition){
                counter+=1;
            }

        }
        return counter;
    }
    public void summary(){
        for (Teacher teacher: teacherList) {
            System.out.println(teacher.toString());
        }
    }

    public List<Teacher> sortByLastName(){
        ArrayList<Teacher> teachers = teacherList;
        teachers.sort(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        return teachers;
    }

    public List<Teacher> sortBySalary(){
        ArrayList<Teacher> teachers = teacherList;
        teachers.sort(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return o1.getSalary().compareTo(o2.getSalary());
            }
        });

        return teachers;
    }

    public Double maxSalary(){
        return Collections.max(teacherList, new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return o1.getSalary().compareTo(o2.getSalary());
            }
        }).getSalary();
    }

}
