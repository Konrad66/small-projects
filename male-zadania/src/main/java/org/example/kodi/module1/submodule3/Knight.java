package org.example.kodi.module1.submodule3;

public class Knight {

    private Quest quest;

    public Knight(Quest quest) {
        this.quest = quest;
    }

    void recognizeQuest(Quest quest) {
        quest.process();
    }
}