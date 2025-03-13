package com.example.lab07tuwaiqjavabootcamp.Service;

import com.example.lab07tuwaiqjavabootcamp.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher> teachers = new ArrayList<>();

    public ArrayList<Teacher> getAllTeachers(){
        return teachers;
    }

    public boolean addTeacher(Teacher teacher){
        for (Teacher t: teachers){
            if (t.getId().equals(teacher.getId()))
                return false;
        }
        teachers.add(teacher);
        return true;
    }

    public boolean updateTeacher(String id,Teacher teacher){
        for (Teacher t: teachers){
            if (t.getId().equals(id)){
                teachers.set(teachers.indexOf(t), teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeacher(String id){
        for (Teacher t: teachers){
            if (t.getId().equals(id)){
                teachers.remove(t);
                return true;
            }
        }
        return false;
    }
}
