package ru.otus.javaecodemo.controller.model;

import java.time.LocalDateTime;

public record ThoughtDto(String description, LocalDateTime createdAt) {}
