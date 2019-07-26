package com.lamri.botpoc.chat.api;

import com.lamri.botpoc.chat.dto.BotMessage;
import com.lamri.botpoc.chat.dto.UserMessage;
import com.lamri.botpoc.chat.service.BotService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BotController {

    private BotService botService;

    public BotController(BotService botService) {
        this.botService = botService;
    }

    @PostMapping("/chat")
    public BotMessage chat(@RequestBody UserMessage message) {
        return botService.getAnswer(message);
    }
}
