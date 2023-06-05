package com.profiling.profilingbackend.Service;
import com.profiling.profilingbackend.Model.Clerk;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public interface ClerkService {

    ResponseEntity <String> registerNewClerk(Clerk registerClerk);
    List <Clerk> getAllClerk();
    Optional <Clerk> getClerkInfo();
    ResponseEntity <String> updateClerkInfo(String id, Clerk newClerk);
    ResponseEntity <String> deleteClerkInfo(String id);

}
