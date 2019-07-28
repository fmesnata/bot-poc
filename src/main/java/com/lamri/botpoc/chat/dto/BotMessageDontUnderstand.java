package com.lamri.botpoc.chat.dto;

public class BotMessageDontUnderstand extends BotMessage {

    @Override
    public String getText() {
        return "DONT_UNDERSTAND";
    }

    @Override
    public Mood getMood() {
        return Mood.SORRY;
    }

    @Override
    public void setText(String text) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setMood(Mood mood) {
        throw new UnsupportedOperationException();
    }
}
