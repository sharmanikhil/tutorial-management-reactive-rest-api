package com.reactive.service;

import com.reactive.entity.Tutorial;
import com.reactive.exception.DataNotFoundException;
import com.reactive.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TutorialService {
    private final TutorialRepository tutorialRepository;

    public Flux<Tutorial> findAll() {
        return tutorialRepository.findAll();
    }

    public Flux<Tutorial> findByTitleContaining(String title) {
        return tutorialRepository.findByTitleContaining(title);
    }

    public Mono<Tutorial> findById(Integer id) {
        return tutorialRepository.findById(id).switchIfEmpty(Mono.error(new DataNotFoundException("Tutorial not found with " + id)));
    }

    public Mono<Tutorial> save(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    public Mono<Tutorial> update(Integer id, Tutorial tutorial) {
        return tutorialRepository.findById(id)
                .switchIfEmpty(Mono.error(new DataNotFoundException("Tutorial not found with " + id)))
                .flatMap(tutorialSnapshotDb -> {
                    tutorialSnapshotDb.setDescription(tutorial.getDescription());
                    tutorialSnapshotDb.setPublished(tutorial.getPublished());
                    tutorialSnapshotDb.setTitle(tutorial.getTitle());
                    return tutorialRepository.save(tutorialSnapshotDb);
                });
    }

    public Mono<Void> deleteById(Integer id) {
        return tutorialRepository.deleteById(id);
    }

    public Mono<Void> deleteAll() {
        return tutorialRepository.deleteAll();
    }

    public Flux<Tutorial> findByPublished(boolean isPublished) {
        return tutorialRepository.findByPublished(isPublished);
    }
}
