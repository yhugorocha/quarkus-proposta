package io.github.yhugorocha.message;

import io.github.yhugorocha.dto.ProposalRequestDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class KafkaEvent {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Channel("proposal-out")
    Emitter<ProposalRequestDTO> proposalRequestEmitter;

    public void sendNewKafkaEvent(ProposalRequestDTO proposalRequestDTO){
        LOG.info("-- Enviando nova proposta para topico kafka --");
        proposalRequestEmitter.send(proposalRequestDTO).toCompletableFuture().join();
    }

}
