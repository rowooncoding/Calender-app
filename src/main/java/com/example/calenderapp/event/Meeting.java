package com.example.calenderapp.event;

import java.time.ZonedDateTime;
import java.util.Set;

public class Meeting extends AbstractEvent {
    private Set<String> participants; // 사람은 중복되지 않기 때문에 set 자료구조로 설정
    private String meetingRoom;
    private String agenda;

    public Meeting(int id, String title, ZonedDateTime startAt, ZonedDateTime endAt, Set<String> participants, String meetingRoom, String agenda) {
        super(id, title, startAt, endAt);

        this.participants = participants;
        this.meetingRoom = meetingRoom;
        this.agenda = agenda;
    }

    @Override
    public void print() {
        System.out.printf("[회의] %s : %s%n", getTitle(), agenda);
    }
}
