package com.profiling.profilingbackend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.profiling.profilingbackend.Model.Dean;

@Service
public interface DeanService {


    // register dean
    ResponseEntity <String> registerDean(Dean registerDean);

    // get all dean
    List <Dean> getAllDeans();

    // get dean by id
    Optional <Dean> getDeanInfoByID(String id);

    // edit dean data
    ResponseEntity <String> updateDeansCurrentData(String id, Dean newDean);
   
    // delete dean by id
    ResponseEntity <String> removeDeansDataByID(String id);
}
