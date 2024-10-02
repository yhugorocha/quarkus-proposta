package io.github.yhugorocha.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record ProposalDetailDTO(Long id,
                                String customer,
                                BigDecimal priceTonne,
                                Integer tonnes,
                                String country,
                                Integer proposalValidityDays,
                                LocalDateTime created) {
}
