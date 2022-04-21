package io.everyonecodes.drhouse_admission;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/uuids")
public class UuidCacheEndpoint {

    private final UUIDProvider uuidProvider;

    public UuidCacheEndpoint(UUIDProvider uuidProvider) {
        this.uuidProvider = uuidProvider;
    }

    //Has the get mapping that returns all the cached patient names alongside their assigned UUIDs, like in the example below.
    @GetMapping
    List<String> getAllPatients() {
        return uuidProvider.getCacheSnapshot();
    }

    //Has the “/{patientName}” get mapping that returns the cached patient UUID for that particular name
    // if it was previously cached, otherwise null.
    @GetMapping("/{patientName}")
    String getUuidViaName(@PathVariable String patientName){
        var result = uuidProvider.findUUID(patientName);
        if (result.isEmpty()){
            return null;
        }
        return result;
    }
}
