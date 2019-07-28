package com.lamri.botpoc.witai;

import com.lamri.botpoc.chat.dto.UserMessage;

public interface MessageSender {

    MessageReport send(UserMessage message);
}
