package io.github.yhugorocha.repository;

import io.github.yhugorocha.entity.ProposalEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProposalRepository implements PanacheRepository<ProposalEntity> {
}
