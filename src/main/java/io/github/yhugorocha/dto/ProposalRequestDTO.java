package io.github.yhugorocha.dto;

import java.math.BigDecimal;

public record ProposalRequestDTO(String costumer,
                                 BigDecimal priceTonne,
                                 Integer tonnes,
                                 String country,
                                 Integer proposalValidityDays) {
}
