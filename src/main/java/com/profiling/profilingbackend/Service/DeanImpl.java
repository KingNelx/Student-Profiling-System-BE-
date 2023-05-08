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

import com.profiling.profilingbackend.Model.Dean;
import com.profiling.profilingbackend.Repository.DeanRepo;

@Service
public class DeanImpl implements DeanService {

    @Autowired
    private DeanRepo deanRepo;

    @Override
    public ResponseEntity<String> registerDean(@RequestBody Dean registerDean) {
        deanRepo.save(registerDean);
        return ResponseEntity.ok(" REGISTER NEW DEAN ");
    }

    @Override
    public List<Dean> getAllDeans() {
        if (deanRepo.findAll().isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return deanRepo.findAll();

    }

    @Override
    public Optional<Dean> getDeanInfoByID(@PathVariable String id) {
        if (!deanRepo.findById(id).isPresent()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return deanRepo.findById(id);
    }

    @Override
    public ResponseEntity<String> updateDeansCurrentData(@PathVariable String id, @RequestBody Dean newDean) {
        Dean existingDeansData = deanRepo.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        existingDeansData.setFirstName(newDean.getFirstName());
        existingDeansData.setLastName(newDean.getLastName());
        existingDeansData.setEmail(newDean.getEmail());
        existingDeansData.setUserName(newDean.getUserName());
        existingDeansData.setPassword(newDean.getPassword());
        deanRepo.save(existingDeansData);
        return ResponseEntity.ok(" DEANS DATA GOT UPDATED ");
    }

    @Override
    public ResponseEntity<String> removeDeansDataByID(@PathVariable String id) {
        if (!deanRepo.findById(id).isPresent()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        deanRepo.deleteById(id);
        return ResponseEntity.ok(" DEANS DATA DELETED ");
    }

}
