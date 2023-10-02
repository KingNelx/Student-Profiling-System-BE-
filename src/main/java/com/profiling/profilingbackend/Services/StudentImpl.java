package com.profiling.profilingbackend.Services;


import com.profiling.profilingbackend.Entity.Education;
import com.profiling.profilingbackend.Entity.Parents;
import com.profiling.profilingbackend.Entity.Student;
import com.profiling.profilingbackend.Repository.EducationRepo;
import com.profiling.profilingbackend.Repository.ParentRepo;
import com.profiling.profilingbackend.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    private EducationRepo educationRepo;

    @Autowired
    private ParentRepo parentRepo;

    @Transactional
    @Override
    public ResponseEntity <String> addNewStudent(@RequestBody Student student) {

        Education education = student.getEducation();
        Parents parents = student.getParents();
        Optional <Student> existingID = studentRepo.findByStudentID(student.getStudentID());

        if(existingID.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" CURRENT DATA ALREADY SAVED ");
        }
        try{
            if(education == null || education.getId() == null || parents == null || parents.getId() == null){
                educationRepo.save(education);
                parentRepo.save(parents);
                studentRepo.save(student);
                return ResponseEntity.status(HttpStatus.OK).body(" NEW STUDENT ADDED ");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
    }

        @Override
    public List <Student> queryAllStudents(){
        if(studentRepo.findAll().isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return studentRepo.findAll();
    }

    @Override
    public Optional <Student> getStudentByID(@PathVariable String id){
        if(studentRepo.findById(id).isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return studentRepo.findById(id);
    }

    @Override
    public ResponseEntity <String> deleteStudentData(@PathVariable String id){

        Optional <Student> studentDataHandler = studentRepo.findById(id);

        if(studentDataHandler.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" DATA DOES NOT EXIST ");
        }

        Student studentHandler = studentDataHandler.get();
        studentRepo.deleteById(id);
        educationRepo.deleteById(studentHandler.getEducation().getId());
        parentRepo.deleteById(studentHandler.getParents().getId());

        return ResponseEntity.status(HttpStatus.OK).body(" STUDENT DATA HAS BEEN DELETED ");
    }

    @Override
    @Transactional
    public ResponseEntity <String> updateStudentData(@PathVariable String id, @RequestBody Student newData){
        try{
            Student studentData = studentRepo.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
            if(studentData != null){
                studentData.setStudentID(newData.getStudentID());
                studentData.setFirstName(newData.getFirstName());
                studentData.setLastName(newData.getLastName());
                studentData.setMiddleInitial(newData.getMiddleInitial());
                studentData.setDateOfBirth(newData.getDateOfBirth());
                studentData.setGender(newData.getGender());
                studentData.setContactNumber(newData.getContactNumber());
                studentData.setEmailAddress(newData.getEmailAddress());
                studentData.setAddress(newData.getAddress());

                Education educationData = studentData.getEducation();
                if(educationData != null && educationData.getId() != null){
                    educationData.setEducationLevel(newData.getEducation().getEducationLevel());
                    educationData.setSchoolName(newData.getEducation().getSchoolName());
                    educationData.setGradeLevel(newData.getEducation().getGradeLevel());
                    educationData.setDateStarted(newData.getEducation().getDateStarted());
                    educationData.setExpectedGraduationYear(newData.getEducation().getExpectedGraduationYear());
                    educationData.setSchoolAddress(newData.getEducation().getSchoolAddress());
                }

                Parents parentsData = studentData.getParents();
                if(parentsData != null && parentsData.getId() != null){
                    parentsData.setFathersFullName(newData.getParents().getFathersFullName());
                    parentsData.setFathersAge(newData.getParents().getFathersAge());
                    parentsData.setFathersAddress(newData.getParents().getFathersAddress());
                    parentsData.setFathersContactNumber(newData.getParents().getFathersContactNumber());
                    parentsData.setFathersCivilStatus(newData.getParents().getFathersCivilStatus());
                    parentsData.setFathersOccupation(newData.getParents().getFathersOccupation());
                    parentsData.setFathersEducationLevel(newData.getParents().getFathersEducationLevel());
                    parentsData.setFathersDateOfBirth(newData.getParents().getFathersDateOfBirth());

                    parentsData.setMothersFullName(newData.getParents().getMothersFullName());
                    parentsData.setMothersAge(newData.getParents().getMothersAge());
                    parentsData.setMothersAddress(newData.getParents().getMothersAddress());
                    parentsData.setMothersContactNumber(newData.getParents().getMothersContactNumber());
                    parentsData.setMothersCivilStatus(newData.getParents().getMothersCivilStatus());
                    parentsData.setMothersOccupation(newData.getParents().getMothersOccupation());
                    parentsData.setMothersEducationLevel(newData.getParents().getMothersEducationLevel());
                    parentsData.setMothersDateOfBirth(newData.getParents().getMothersDateOfBirth());
                }
                studentRepo.save(studentData);
                educationRepo.save(educationData);
                parentRepo.save(parentsData);

                return ResponseEntity.status(HttpStatus.OK).body(" STUDENT DATA UPDATED ");
            }
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" AN ERROR OCCURRED ");
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    public List <Student> fetchAllMales(){
      try{
          if(!studentRepo.findByGender("MALE").isEmpty()){
              return studentRepo.findByGender("MALE");
          }
      }catch (Exception e){
          throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
      }
      throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    }

    @Override
    public List <Student> fetchAllFemales(){
        try{
            if(!studentRepo.findByGender("FEMALE").isEmpty()){
                return studentRepo.findByGender("FEMALE");
            }
        }catch (Exception e){
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    }

//    @Override
//    public List <Education> fetchAllElementary(){
//        try{
//            if(!studentRepo.findByEducationLevel("ELEMENTARY").isEmpty()){
//                return studentRepo.findByEducationLevel("ELEMENTARY");
//            }
//        }catch(Exception e){
//            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
//    }
}
