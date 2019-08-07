package com.lamri.botpoc.chat.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BotMessage {

    private LocalDateTime time = LocalDateTime.now();

    private String author = "Bot";

    private String text;

    private Mood mood;
}
