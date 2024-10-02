package io.github.yhugorocha.service;

import io.github.yhugorocha.dto.ProposalDetailDTO;
import io.github.yhugorocha.dto.ProposalRequestDTO;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface ProposalService {

    ProposalDetailDTO findFullProposal(Long id);

    void createNewProposal(ProposalRequestDTO proposalRequestDTO);

    void removeProposal(Long id);
}
