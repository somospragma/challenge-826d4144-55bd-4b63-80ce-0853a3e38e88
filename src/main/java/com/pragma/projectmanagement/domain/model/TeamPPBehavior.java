package com.pragma.projectmanagement.application.service;

import com.pragma.projectmanagement.domain.model.TeamPPBehavior;
import com.pragma.projectmanagement.infrastructure.persistence.TeamPPRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TeamPPService {
    private final TeamPPRepository teamPPRepository;

    public TeamPPService(TeamPPRepository teamPPRepository) {
        this.teamPPRepository = teamPPRepository;
    }

    public Flux<TeamPPBehavior> getAllBehaviors() {
        return teamPPRepository.findAll();
    }

    public Mono<TeamPPBehavior> getBehaviorById(Long id) {
        return teamPPRepository.findById(id);
    }

    public Mono<TeamPPBehavior> saveBehavior(TeamPPBehavior behavior) {
        return teamPPRepository.save(behavior);
    }

    public Mono<Void> deleteBehavior(Long id) {
        return teamPPRepository.deleteById(id);
    }
}