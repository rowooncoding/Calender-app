package com.example.calenderapp.event;

import java.time.Duration;
import java.time.ZonedDateTime;

public class Meeting extends AbstractEvent {
    public Meeting(int id, String title, ZonedDateTime startAt, ZonedDateTime endAt) {
        super(id, title, startAt, endAt);
    }

    @Override
    public void print() {

    }
}
