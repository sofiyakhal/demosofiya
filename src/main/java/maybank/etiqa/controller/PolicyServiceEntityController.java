package maybank.etiqa.controller;

import maybank.etiqa.model.PolicyServiceEntity;
import maybank.etiqa.service.PolicyServiceEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class PolicyServiceEntityController {

    @Autowired
    private PolicyServiceEntityService policyServiceEntityService;

    @GetMapping
    public List<PolicyServiceEntity> getAllServices() {
        return policyServiceEntityService.getAllServices();
    }

    @PostMapping
    public PolicyServiceEntity createService(@RequestBody PolicyServiceEntity policyServiceEntity) {
        return policyServiceEntityService.createService(policyServiceEntity);
    }

    @PutMapping("/{id}")
    public PolicyServiceEntity updateService(@PathVariable Long id, @RequestBody PolicyServiceEntity policyServiceEntityDetails) {
        return policyServiceEntityService.updatePolicyService(id, policyServiceEntityDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id) {
        policyServiceEntityService.deletePolicyService(id);
    }
}
