package com.reactive.controller;

import com.reactive.entity.Tutorial;
import com.reactive.service.TutorialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tutorial")
public class TutorialController {
    private final TutorialService tutorialService;

    @GetMapping("/{id}")
    public Mono<Tutorial> getTutorialById(@PathVariable Integer id){
        return tutorialService.findById(id);
    }

    @PostMapping("/save")
    public Mono<Tutorial> saveTutorial(@RequestBody Tutorial tutorial){
        return tutorialService.save(tutorial);
    }

    @PutMapping("/{id}")
    public Mono<Tutorial> updateTutorial(@PathVariable Integer id, @RequestBody Tutorial tutorial){
        return tutorialService.update(id, tutorial);
    }

    @GetMapping
    public Flux<Tutorial> findAll(){
        return tutorialService.findAll();
    }

    @GetMapping("/findAll/titleContains/{title}")
    public Flux<Tutorial> findAllContainsTitle(@PathVariable String title){
        return tutorialService.findByTitleContaining(title);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteTutorialById(@PathVariable Integer id){
        return tutorialService.deleteById(id);
    }

    @DeleteMapping
    public Mono<Void> deleteTutorialById(){
        return tutorialService.deleteAll();
    }

    @GetMapping("/published")
    public Flux<Tutorial> findByPublished(@RequestParam Boolean published){
        return tutorialService.findByPublished(published);
    }
}
