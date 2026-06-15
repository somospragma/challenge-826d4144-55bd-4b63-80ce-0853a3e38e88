package com.pragma.projectmanagement.infrastructure.persistence;

import com.pragma.projectmanagement.domain.model.TeamPPBehavior;
import org.springframework.data.jpa.repository.JpaRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TeamPPRepository extends JpaRepository<TeamPPBehavior, Long> {
    Flux<TeamPPBehavior> findAll();
    Mono<TeamPPBehavior> findById(Long id);
    Mono<TeamPPBehavior> save(TeamPPBehavior behavior);
    Mono<Void> deleteById(Long id);
}