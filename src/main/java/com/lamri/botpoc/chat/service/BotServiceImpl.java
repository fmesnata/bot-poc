package com.lamri.botpoc.chat.service;

import com.lamri.botpoc.chat.dao.IntentDAO;
import com.lamri.botpoc.chat.dto.BotMessage;
import com.lamri.botpoc.chat.dto.Mood;
import com.lamri.botpoc.chat.dto.UserMessage;
import com.lamri.botpoc.chat.model.Intent;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BotServiceImpl implements BotService {

    private IntentDAO intentDAO;

    public BotServiceImpl(IntentDAO intentDAO) {
        this.intentDAO = intentDAO;
    }

    @Override
    public BotMessage getAnswer(UserMessage message) {

        Intent intent = intentDAO.findByLabel(message.getText());
        BotMessage answer = new BotMessage();

        if (intent != null) {
            answer.setMood(Mood.HAPPY);
            answer.setText(intent.getAnswers().get(0).getText());
            answer.setTime(LocalDateTime.now());
        } else {
            answer.setMood(Mood.SORRY);
            answer.setText("DONT_UNDERSTAND");
            answer.setTime(LocalDateTime.now());
        }

        return answer;
    }
}
