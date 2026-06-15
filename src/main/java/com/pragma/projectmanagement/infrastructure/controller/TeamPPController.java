package com.pragma.projectmanagement.application.service;

import com.pragma.projectmanagement.domain.model.TeamPPBehavior;
import com.pragma.projectmanagement.infrastructure.persistence.TeamPPRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

class TeamPPServiceTest {

    @Mock
    private TeamPPRepository teamPPRepository;

    @InjectMocks
    private TeamPPService teamPPService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllBehaviors() {
        TeamPPBehavior behavior = new TeamPPBehavior("Behavior 1");
        when(teamPPRepository.findAll()).thenReturn(Flux.just(behavior));
        StepVerifier.create(teamPPService.getAllBehaviors()).expectNext(behavior).verifyComplete();
    }

    @Test
    void getBehaviorById() {
        Long id = 1L;
        TeamPPBehavior behavior = new TeamPPBehavior("Behavior 1");
        when(teamPPRepository.findById(id)).thenReturn(Mono.just(behavior));
        StepVerifier.create(teamPPService.getBehaviorById(id)).expectNext(behavior).verifyComplete();
    }

    @Test
    void saveBehavior() {
        TeamPPBehavior behavior = new TeamPPBehavior("Behavior 1");
        when(teamPPRepository.save(behavior)).thenReturn(Mono.just(behavior));
        StepVerifier.create(teamPPService.saveBehavior(behavior)).expectNext(behavior).verifyComplete();
    }

    @Test
    void deleteBehavior() {
        Long id = 1L;
        when(teamPPRepository.deleteById(id)).thenReturn(Mono.empty());
        StepVerifier.create(teamPPService.deleteBehavior(id)).verifyComplete();
    }
}