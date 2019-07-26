package com.lamri.botpoc.chat.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "answer")
@Data
public class Answer {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String text;

    @ManyToOne(targetEntity = Intent.class)
    private Intent intent;
}
