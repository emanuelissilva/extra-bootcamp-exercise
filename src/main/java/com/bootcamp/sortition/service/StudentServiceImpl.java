package com.bootcamp.sortition.service;

import com.bootcamp.sortition.model.Student;
import com.bootcamp.sortition.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> randomStudents(){
        Long qty = studentRepository.count();
        List<Student> studentList = new ArrayList<>();
        while (studentList.size()<10){
            int idx = (int)(Math.random() * qty);
            Page<Student> studentPage = studentRepository.findAll(PageRequest.of(idx, 1));
            if (studentPage.hasContent()){
                if(!studentList.contains(studentPage.getContent().get(0))){
                    studentList.add(studentPage.getContent().get(0));
                }
            }
        }
        return studentList;
    }
}
