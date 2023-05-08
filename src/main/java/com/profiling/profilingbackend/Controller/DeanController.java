package com.profiling.profilingbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.profiling.profilingbackend.Model.Dean;
import com.profiling.profilingbackend.Service.DeanService;
import java.util.Optional;

@RestController
@RequestMapping("api/dean")
public class DeanController {

    @Autowired
    private DeanService deanService;

    @PostMapping("/registerDean")
    public ResponseEntity<String> registerDean(@RequestBody Dean registerDean) {
        return deanService.registerDean(registerDean);
    }

    @GetMapping("/getAllDeans")
    public List <Dean> getAllDeans(){
        return deanService.getAllDeans();
    }

    @GetMapping("/getDeanInfoByID/{id}")
    public Optional <Dean> getDeanInfoByID(@PathVariable String id){
        return deanService.getDeanInfoByID(id);
    }

    @PutMapping ("/updateDeansInfoByID/{id}")
    public ResponseEntity <String> updteDeansCurrentData(@PathVariable String id, @RequestBody Dean newDeansData){
        return deanService.updateDeansCurrentData(id, newDeansData);
    }

    @DeleteMapping("/deleteDeansDataByID/{id}")
    public ResponseEntity <String> removeDeansDataByID(@PathVariable String id){
        return deanService.removeDeansDataByID(id);
    }
}
