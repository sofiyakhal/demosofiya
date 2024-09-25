package maybank.etiqa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;


import java.math.BigDecimal;
import java.time.LocalDate;

    @Entity
    public class Policy {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotBlank(message= "Policy number is required")
        @Pattern( regexp = "^[A-Z0-9]{5,10}$", message = "Policy number must be between 5 and 10 characters, " +
                "containing only uppercase letters and digits")
        private String policyNumber;
        @NotBlank(message= "Holder name is required")
        private String holderName;
        @NotNull(message= "Premium is required")
        @DecimalMin(value= "0.0", inclusive = false, message = "Premium must be greater than zero")
        private BigDecimal premium;
        private LocalDate startDate;
        private LocalDate endDate;

        public Policy() {
        }

        public Policy(String policyNumber, String holderName, BigDecimal premium, LocalDate startDate, LocalDate endDate) {
            this.policyNumber = policyNumber;
            this.holderName = holderName;
            this.premium = premium;
            this.startDate = startDate;
            this.endDate = endDate;
        }
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


