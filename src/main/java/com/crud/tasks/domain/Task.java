package com.crud.tasks.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@AllArgsConstructor
@Entity(name = "tasks")
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @Column(name = "name")
    private String title;

    @NonNull
    @Column(name = "description")
    private String content;
}
