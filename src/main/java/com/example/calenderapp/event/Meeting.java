package com.example.calenderapp.event;

import java.time.Duration;
import java.time.ZonedDateTime;

public class Meeting extends AbstractEvent {
    public Meeting(int id, String title, ZonedDateTime startAt, ZonedDateTime endAt, Duration duration, ZonedDateTime createdAt, ZonedDateTime modifiedAt, boolean deletedYn) {
        super(id, title, startAt, endAt, duration, createdAt, modifiedAt, deletedYn);
    }

    @Override
    public void print() {

    }
}
