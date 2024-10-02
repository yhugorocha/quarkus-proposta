package io.github.yhugorocha.service.impl;

import io.github.yhugorocha.dto.ProposalDetailDTO;
import io.github.yhugorocha.dto.ProposalRequestDTO;
import io.github.yhugorocha.entity.ProposalEntity;
import io.github.yhugorocha.mapper.ProposalMapper;
import io.github.yhugorocha.message.KafkaEvent;
import io.github.yhugorocha.repository.ProposalRepository;
import io.github.yhugorocha.service.ProposalService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ProposalServiceImpl implements ProposalService {

    @Inject
    ProposalRepository proposalRepository;

    @Inject
    KafkaEvent kafkaEvent;

    @Inject
    ProposalMapper proposalMapper;

    @Override
    public ProposalDetailDTO findFullProposal(Long id) {
        return proposalMapper.toProposalDetailDTO(proposalRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("Proposal NotFound")));
    }

    @Transactional
    @Override
    public void createNewProposal(ProposalRequestDTO proposalRequestDTO) {
        proposalRepository.persist(proposalMapper.toProposalEntity(proposalRequestDTO));
        kafkaEvent.sendNewKafkaEvent(proposalRequestDTO);
    }

    @Override
    public void removeProposal(Long id) {
        ProposalEntity proposalEntity = proposalRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("Proposal NotFound"));
        proposalRepository.delete(proposalEntity);
    }
}
