package maybank.etiqa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String policyNumber;
    private String holderName;
    private BigDecimal premium;
    private LocalDate startDate;
    private LocalDate endDate;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPolicyNumber() {
        return policyNumber;
    }
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }
    public String getHolderName() {
        return holderName;
    }
    public void setHolderName(String holderName) {
        if (holderName == null || holderName.trim().isEmpty()) {
            throw new IllegalArgumentException("Holder name cannot be empty");
        }
        this.holderName = holderName;
    }
    public BigDecimal getPremium() {
        return premium;
    }
    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
