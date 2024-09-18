package maybank.etiqa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Service {
    @Id
    @GeneratedValue
    private Long id;
    private String serviceType;
    private LocalDate serviceDate;
    private String description;

    @ManyToOne
    @JoinColumn(name="policy_id")
    private Policy policy;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getServiceType() {
        return serviceType;
    }
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public LocalDate getServiceDate() {
        return serviceDate;
    }
    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Policy getPolicy() {
        return policy;
    }
    public void setPolicy(Policy policy) {
        this.policy = policy;
    }
}
