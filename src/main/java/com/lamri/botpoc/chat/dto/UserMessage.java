package com.lamri.botpoc.chat.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class UserMessage {

    private LocalDateTime time;

    @NotBlank
    @Size(min = 2, max = 20)
    private String author;

    @NotBlank
    @Size(min = 2, max = 50)
    private String text;
}
