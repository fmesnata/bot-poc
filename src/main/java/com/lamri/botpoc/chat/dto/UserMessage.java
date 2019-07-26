package com.lamri.botpoc.chat.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserMessage {

    private LocalDateTime time;

    private String text;

    private String sender;

}
