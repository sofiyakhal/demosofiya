package maybank.etiqa.repository;

import maybank.etiqa.model.PolicyServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PolicyServiceEntityRepository extends JpaRepository<PolicyServiceEntity, Long> {
}
