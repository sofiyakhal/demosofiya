package maybank.etiqa.controller;

import maybank.etiqa.model.Policy;
import maybank.etiqa.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/policies")
@Validated
public class SampleController {

    @Autowired
    private PolicyService policyService;

    @GetMapping
    public List<Policy> getAllPolicies(){
        return policyService.getAllPolicies();
    }
    @PostMapping
    public ResponseEntity<?> createPolicy(@Valid @RequestBody Policy policy) {
        try {
            Policy createdPolicy = policyService.createPolicy(policy);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPolicy);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePolicy(@PathVariable Long id, @Valid @RequestBody Policy policyDetails){
        try {
            Policy updatedPolicy = policyService.updatePolicy((long) id,policyDetails);
            return ResponseEntity.ok(updatedPolicy);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePolicy(@PathVariable Long id) {
        try {
            policyService.deletePolicy(id);
            return ResponseEntity.noContent().build();
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Policy not found with id: " + id);
        }
    }
    }


