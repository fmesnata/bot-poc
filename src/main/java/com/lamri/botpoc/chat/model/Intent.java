package com.lamri.botpoc.chat.model;

import com.lamri.botpoc.chat.dto.Mood;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "intent")
@Data
public class Intent {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String label;

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private Mood mood;

    @OneToMany(mappedBy = "intent", targetEntity = Answer.class, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();
}
