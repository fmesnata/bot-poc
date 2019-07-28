package com.lamri.botpoc.chat.dto;

public class BotMessageBroken extends BotMessage {

    @Override
    public String getText() {
        return "BROKEN";
    }

    @Override
    public Mood getMood() {
        return Mood.WOOZY;
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
