package com.lamri.botpoc.chat.api;

import com.lamri.botpoc.chat.dto.BotMessage;
import com.lamri.botpoc.chat.dto.UserMessage;
import com.lamri.botpoc.chat.service.BotService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class BotController {

    private BotService botService;

    public BotController(BotService botService) {
        this.botService = botService;
    }

    @CrossOrigin
    @PostMapping("/chat")
    public BotMessage chat(@Valid @RequestBody UserMessage message) {
        return botService.getAnswer(message);
    }
}
