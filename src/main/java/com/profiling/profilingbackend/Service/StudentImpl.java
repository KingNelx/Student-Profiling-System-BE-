package com.profiling.profilingbackend.Service;


import com.profiling.profilingbackend.Model.EducationalBG;
import com.profiling.profilingbackend.Model.FamilyBG;
import com.profiling.profilingbackend.Model.Student;
import com.profiling.profilingbackend.Repository.EducationalBGRepo;
import com.profiling.profilingbackend.Repository.FamilyBGRepo;
import com.profiling.profilingbackend.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
@Service
public class StudentImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private EducationalBGRepo educationalBGRepo;
    @Autowired
    private FamilyBGRepo familyBGRepo;

    @Override
    public ResponseEntity <String> registerStudent(@RequestBody Student registerStudents){

//        EducationalBG educationalBG = registerStudents.getEducationalBG();
//        FamilyBG familyBG = registerStudents.getFamilyBG();
//
//        if(educationalBG == null || familyBG == null){
//            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
//        }
//
//        educationalBGRepo.save(educationalBG);
//        familyBGRepo.save(familyBG);
        studentRepo.save(registerStudents);
        return ResponseEntity.ok(" NEW STUDENT ADDED ");
    }

    @Override
    public List <Student> getAllStudents(){
        if(studentRepo.findAll().isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return studentRepo.findAll();
    }

    @Override
    public Optional <Student> getStudentDataByID(@PathVariable String id){
        if(!studentRepo.findById(id).isPresent()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return studentRepo.findById(id);
    }

    @Override
    public ResponseEntity <String> removeStudentDataByID(@PathVariable String id){
       Optional <Student> studentHandler = studentRepo.findById(id);
       if(!studentHandler.isPresent()){
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
       }
       Student student = studentHandler.get();
       educationalBGRepo.deleteById(student.getEducationalBG().getId());
       familyBGRepo.deleteById(student.getFamilyBG().getId());

       return ResponseEntity.ok(" STUDENT WITH ID: " + id + " DATA HAS BEEN DELETED ");
    }


    @Override
    public ResponseEntity <String> updateStudentData(@RequestBody Student updateStudent, @PathVariable String id){
        Student existingStudentData = studentRepo.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        existingStudentData.setStudentID(updateStudent.getStudentID());
        existingStudentData.setFirstName(updateStudent.getFirstName());
        existingStudentData.setLastName(updateStudent.getLastName());
        existingStudentData.setAge(updateStudent.getAge());
        existingStudentData.setGender(updateStudent.getGender());
        existingStudentData.setCourse(updateStudent.getCourse());
        existingStudentData.setEmail(updateStudent.getEmail());
        existingStudentData.setContactNumber(updateStudent.getContactNumber());

        studentRepo.save(existingStudentData);
        return ResponseEntity.ok(" STUDENT DATA WITH ID: "+ id + "SUCCESSFULLY UPDATED");
    }

    @Override
    public List <Student> findAllMales(){
        if(studentRepo.findByGender("MALE").isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return studentRepo.findByGender("MALE");
    }

    @Override
    public List <Student> findAllFemales(){
        if(studentRepo.findByGender("FEMALE").isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return studentRepo.findByGender("FEMALE");
    }

    @Override
    public List <Student> findAllBSIT(){
        if(studentRepo.findByCourse("BSIT").isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return studentRepo.findByCourse("BSIT");
    }

    @Override
    public List <Student> findAllBSIS(){
        if(studentRepo.findByCourse("BSIS").isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return studentRepo.findByCourse("BSIS");
    }

    @Override
    public List <Student> findAllBSCS(){
        if(studentRepo.findByCourse("BSCS").isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return studentRepo.findByCourse("BSCS");
    }
}
