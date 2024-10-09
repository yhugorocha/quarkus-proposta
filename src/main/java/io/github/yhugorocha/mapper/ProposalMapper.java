package io.github.yhugorocha.mapper;

import io.github.yhugorocha.dto.ProposalDetailDTO;
import io.github.yhugorocha.dto.ProposalRequestDTO;
import io.github.yhugorocha.entity.ProposalEntity;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;

@ApplicationScoped
public class ProposalMapper {

    public ProposalDetailDTO toProposalDetailDTO(ProposalEntity proposalEntity){
        return ProposalDetailDTO.builder()
                .id(proposalEntity.getId())
                .customer(proposalEntity.getCustomer())
                .priceTonne(proposalEntity.getPriceTonne())
                .tonnes(proposalEntity.getTonnes())
                .country(proposalEntity.getCountry())
                .proposalValidityDays(proposalEntity.getProposalValidityDays())
                .created(proposalEntity.getCreated())
                .build();
    }

    public ProposalEntity toProposalEntity(ProposalRequestDTO proposalRequestDTO){
        return ProposalEntity.builder()
                .customer(proposalRequestDTO.customer())
                .priceTonne(proposalRequestDTO.priceTonne())
                .tonnes(proposalRequestDTO.tonnes())
                .country(proposalRequestDTO.country())
                .proposalValidityDays(proposalRequestDTO.proposalValidityDays())
                .created(LocalDateTime.now())
                .build();
    }

}
