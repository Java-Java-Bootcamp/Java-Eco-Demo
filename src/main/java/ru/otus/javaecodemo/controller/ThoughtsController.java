package ru.otus.javaecodemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.javaecodemo.controller.model.ThoughtDto;
import ru.otus.javaecodemo.service.ThoughtsService;

import java.util.List;

@RestController
@RequestMapping("/thoughts")
public class ThoughtsController {
    private final ThoughtsService thoughtsService;

    public ThoughtsController(ThoughtsService thoughtsService) {
        this.thoughtsService = thoughtsService;
    }

    @GetMapping
    public List<ThoughtDto> getThoughts() {
        return thoughtsService.getThoughts();
    }

    @PostMapping
    public void saveThought(@RequestBody String description) {
        thoughtsService.saveThought(description);
    }
}
