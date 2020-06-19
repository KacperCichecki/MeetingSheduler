package com.company.service;

import com.company.model.Meeting;

import java.util.ArrayList;
import java.util.List;

public class MeetingParser {

    public List<Meeting> createMeetingList(int[][] meetingsArray) {

        List<Meeting> meetings = new ArrayList<>();

        for (int[] meeting : meetingsArray) {
            meetings.add(new Meeting(meeting[0], meeting[1]));
        }
        return meetings;
    }
}
