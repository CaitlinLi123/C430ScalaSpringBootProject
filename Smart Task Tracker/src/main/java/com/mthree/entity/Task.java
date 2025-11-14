package com.mthree.entity;

import org.jetbrains.annotations.NotNull;
import javax.annotation.Priority;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    private String description;
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}