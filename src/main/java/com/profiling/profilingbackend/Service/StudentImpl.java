package com.profiling.profilingbackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

import com.profiling.profilingbackend.Model.EducationalBG;
import com.profiling.profilingbackend.Model.FamilyBG;
import com.profiling.profilingbackend.Model.OtherBG;
import com.profiling.profilingbackend.Model.PersonalBG;
import com.profiling.profilingbackend.Model.Student;
import com.profiling.profilingbackend.Repository.EducationalBGRepo;
import com.profiling.profilingbackend.Repository.FamilyBGRepo;
import com.profiling.profilingbackend.Repository.OtherBGRepo;
import com.profiling.profilingbackend.Repository.PersonalBGRepo;
import com.profiling.profilingbackend.Repository.StudentRepo;

@Service
public class StudentImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private PersonalBGRepo personalBGRepo;

    @Autowired
    private EducationalBGRepo educationalBGRepo;

    @Autowired
    private FamilyBGRepo familyBGRepo;

    @Autowired
    private OtherBGRepo otherBGRepo;

    @Override
    public ResponseEntity<String> registerStudent(@RequestBody Student registerStudent) {
        PersonalBG personalBG = registerStudent.getPersonalBG();
        EducationalBG educationalBG = registerStudent.getEducationalBG();
        FamilyBG familyBG = registerStudent.getFamilyBG();
        OtherBG otherBG = registerStudent.getOtherBG();

        if (personalBG == null || educationalBG == null || familyBG == null || otherBG == null) {
            throw new HttpClientErrorException(HttpStatus.EXPECTATION_FAILED);
        } else if (personalBG.getId() == null || educationalBG.getId() == null || familyBG.getId() == null
                || otherBG.getId() == null) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        studentRepo.save(registerStudent);
        personalBGRepo.save(personalBG);
        educationalBGRepo.save(educationalBG);
        familyBGRepo.save(familyBG);
        otherBGRepo.save(otherBG);

        return ResponseEntity.ok(" STUDENT SUCCESFULLY REGISTERED ");
    }

    @Override
    public List<Student> getAllStudentsInfo() {
        if (studentRepo.findAll().isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return studentRepo.findAll();
    }

    @Override
    public Optional<Student> getStudentsInfoById(@PathVariable String id) {
        if (!studentRepo.findById(id).isPresent()) {
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return studentRepo.findById(id);
    }

    @Override
    public ResponseEntity<String> updateStudentAccount(@PathVariable String id,
            @RequestBody Student updateStudentAccount) {
        Student existingStudentAccountInfo = studentRepo.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        existingStudentAccountInfo.setStudentID(updateStudentAccount.getStudentID());
        existingStudentAccountInfo.setPassword(updateStudentAccount.getPassword());
        studentRepo.save(existingStudentAccountInfo);
        return ResponseEntity.ok(" STUDENT ACCOUNT GOT ACCEPTED ");
    }

}
