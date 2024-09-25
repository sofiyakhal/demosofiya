package maybank.etiqa.service;

import maybank.etiqa.model.PolicyServiceEntity;
import maybank.etiqa.repository.PolicyServiceEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; //test

import java.util.List;

@Service
public class PolicyServiceEntityService {

    @Autowired
    private PolicyServiceEntityRepository policyServiceEntityRepository;

    public List<PolicyServiceEntity> getAllServices() {
        return policyServiceEntityRepository.findAll();
    }

    public PolicyServiceEntity createService(PolicyServiceEntity policyServiceEntity) {
        return policyServiceEntityRepository.save(policyServiceEntity);
    }

    public PolicyServiceEntity updatePolicyService(long id, PolicyServiceEntity policyServiceEntityDetails) {
        PolicyServiceEntity existingService = (PolicyServiceEntity) policyServiceEntityRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Service not found with id: " + id));
        existingService.setServiceType(policyServiceEntityDetails.getServiceType());
        existingService.setServiceDate(policyServiceEntityDetails.getServiceDate());
        existingService.setDescription(policyServiceEntityDetails.getDescription());

        return policyServiceEntityRepository.save(existingService);
    }

    public void deletePolicyService(Long id) {
        policyServiceEntityRepository.deleteById(id);
    }
}
