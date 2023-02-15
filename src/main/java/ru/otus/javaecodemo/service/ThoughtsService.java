package ru.otus.javaecodemo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.javaecodemo.controller.model.ThoughtDto;
import ru.otus.javaecodemo.repository.ThoughtRepository;
import ru.otus.javaecodemo.repository.entity.Thought;
import ru.otus.javaecodemo.service.kafka.KafkaProducer;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ThoughtsService {
    private final ThoughtRepository thoughtRepository;

    private final KafkaProducer kafkaProducer;


    public void saveThought(String description) {
        thoughtRepository.save(new Thought(description, LocalDateTime.now()));
        kafkaProducer.sendMessage("Created new thought: " + description);
    }

    public List<ThoughtDto> getThoughts() {
        return thoughtRepository.findAll().stream()
                .map(thought -> new ThoughtDto(thought.getDescription(), thought.getCreatedAt()))
                .toList();
    }
}
