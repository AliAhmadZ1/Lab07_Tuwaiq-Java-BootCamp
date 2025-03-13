package com.example.lab07tuwaiqjavabootcamp.Service;

import com.example.lab07tuwaiqjavabootcamp.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getAllStudent() {
        return students;
    }

    public boolean addStudent(Student student) {
        for (Student s : students) {
            if (s.getId().equals(student.getId())) {
                return false;
            }
        }
        if (student.getNumberOfRequiredCourses() < student.getNumberOfCoursesPassing())
            return false;
        students.add(student);
        return true;
    }

    public boolean updateStudent(String id, Student student) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                students.set(students.indexOf(s), student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                students.remove(s);
                return true;
            }
        }
        return false;
    }

    public boolean passCourses(String id, int courses) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                if (s.getNumberOfCoursesPassing() + courses <= s.getNumberOfRequiredCourses()) {
                    s.setNumberOfCoursesPassing(s.getNumberOfCoursesPassing() + courses);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean graduate(String id){
        for (Student s: students){
            if (s.getId().equals(id)) {
                if (s.getNumberOfRequiredCourses() == s.getNumberOfCoursesPassing()) {
                    s.setStatus("graduated");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean clearance(String id){
        for (Student s: students){
            if (s.getId().equals(id)) {
                if (s.getNumberOfRequiredCourses() == s.getNumberOfCoursesPassing()) {
                    s.setStatus("graduated");
                    return true;
                }
                s.setNumberOfRequiredCourses(s.getNumberOfCoursesPassing());
                s.setStatus("withdrawn");
                return true;
            }
        }
        return false;
    }

}
