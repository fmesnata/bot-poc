package com.lamri.botpoc.chat.service;

import com.lamri.botpoc.chat.dto.BotMessage;
import com.lamri.botpoc.chat.dto.UserMessage;

public interface BotService {

    BotMessage getAnswer(UserMessage message);
}
