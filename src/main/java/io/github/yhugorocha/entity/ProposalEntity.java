package io.github.yhugorocha.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "proposal")
public class ProposalEntity {

    @Id
    @Generated
    private Long id;

    private String customer;

    @Column(name = "prece_tonne", columnDefinition = "DECIMAL(10, 2)")
    private BigDecimal priceTonne;

    private Integer tonnes;

    private String country;

    @Column(name = "proposal_validity_days")
    private Integer proposalValidityDays;

    private LocalDateTime created;
}
