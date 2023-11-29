package com.profiling.profilingbackend.Implementation;
import java.util.List;
import java.util.Optional;

import com.profiling.profilingbackend.Entity.Course;
import com.profiling.profilingbackend.Entity.Student;
import com.profiling.profilingbackend.Repository.CourseRepo;
import com.profiling.profilingbackend.Repository.StudentRepo;
import com.profiling.profilingbackend.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StudentImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Override
    @Transactional
    public ResponseEntity <String> addNewStudent(@RequestBody Student student){

        Optional <Student> existingFirstName = studentRepo.findByFirstName(student.getFirstName());
        Optional <Student> existingLastName = studentRepo.findByLastName(student.getLastName());
        Optional <Student> existingStudentId = studentRepo.findByStudentId(student.getStudentId());

        boolean doesFirstNameExist = existingFirstName.isPresent();
        boolean doesLastNameExist = existingLastName.isPresent();
        boolean doesStudentIdExist = existingStudentId.isPresent();

        try{
            if(doesFirstNameExist && doesLastNameExist && doesStudentIdExist){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(" DATA ALREADY EXIST ");
            }
           List <Course> myCourse = student.getMyCourse();
            try{
                if(myCourse.isEmpty()){
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" COURSE CAN NOT BE EMPTY ");
                }else{
                    for(Course course : myCourse) {
                        courseRepo.save(course);
                    }
                    studentRepo.save(student);
                    return ResponseEntity.status(HttpStatus.OK).body(" NEW STUDENT ADDED ");
                }
            }catch (Exception e){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG " + e.getCause());
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG " + e.getCause());
        }
    }
}