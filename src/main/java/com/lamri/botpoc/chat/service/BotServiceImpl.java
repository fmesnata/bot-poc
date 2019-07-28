package com.lamri.botpoc.chat.service;

import com.lamri.botpoc.chat.dao.IntentDAO;
import com.lamri.botpoc.chat.dto.*;
import com.lamri.botpoc.chat.model.Answer;
import com.lamri.botpoc.chat.model.Intent;
import com.lamri.botpoc.witai.MessageReport;
import com.lamri.botpoc.witai.MessageSender;
import com.lamri.botpoc.witai.model.WitaiIntent;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class BotServiceImpl implements BotService {

    private IntentDAO intentDAO;

    private MessageSender messageSender;

    public BotServiceImpl(IntentDAO intentDAO, MessageSender messageSender) {
        this.intentDAO = intentDAO;
        this.messageSender = messageSender;
    }

    @Override
    public BotMessage getAnswer(UserMessage message) {
        List<WitaiIntent> witaiIntents = analyseUserMessage(message);

        return makeAppropriateAnswer(witaiIntents);
    }

    private List<WitaiIntent> analyseUserMessage(UserMessage message) {
        MessageReport send = messageSender.send(message);

        return send.getEntities().getIntent();
    }

    private BotMessage makeAppropriateAnswer(List<WitaiIntent> witaiIntents) {
        if (witaiIntents == null || witaiIntents.get(0).getConfidence() < 0.5) {
            return new BotMessageDontUnderstand();
        }

        return intentDAO.findByLabel(witaiIntents.get(0).getValue())
                .map(this::makeMessageBasedOnIntent)
                .orElse(new BotMessageBroken());
    }

    private BotMessage makeMessageBasedOnIntent(Intent intent) {
        BotMessage botMessage = new BotMessage();
        botMessage.setMood(intent.getMood());
        Answer selectedAnswer = selectRandomAnswer(intent.getAnswers());
        botMessage.setText(selectedAnswer.getText());
        botMessage.setTime(LocalDateTime.now());
        return botMessage;
    }

    private Answer selectRandomAnswer(List<Answer> answers) {
        Random random = new Random();
        random.nextInt();

        return answers.get(random.nextInt(answers.size()));
    }

}
