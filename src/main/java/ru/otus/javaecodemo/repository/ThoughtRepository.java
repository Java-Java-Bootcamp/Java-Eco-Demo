package ru.otus.javaecodemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.javaecodemo.repository.entity.Thought;

public interface ThoughtRepository extends JpaRepository<Thought, Long> {
}
