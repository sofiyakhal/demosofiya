package maybank.etiqa.service;

import maybank.etiqa.model.Policy;
import maybank.etiqa.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    public List<Policy> getAllPolicies(){
        return policyRepository.findAll();
    }
    public Policy getPolicyByNumber(String policyNumber) {
        return policyRepository.findByPolicyNumber(policyNumber);
    }
    public Policy createPolicy(Policy policy){
        return policyRepository.save(policy);
    }
    public void deletePolicy(Long id){
        policyRepository.deleteById(id);
    }
    public Policy savePolicy(Policy policy){
        policyRepository.save(policy);
        return policy;
    }
    public Policy updatePolicy(Long id, Policy policyDetails){
        Policy existingPolicy = policyRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Policy not found with ID: " + id)); ;
        existingPolicy.setHolderName(policyDetails.getHolderName());
        existingPolicy.setPremium(policyDetails.getPremium());
        existingPolicy.setStartDate(policyDetails.getStartDate());
        existingPolicy.setEndDate(policyDetails.getEndDate());
        return policyRepository.save(existingPolicy);
    }
    }



