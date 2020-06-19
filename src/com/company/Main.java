package com.company;

import com.company.model.FreeSlot;
import com.company.model.Meeting;
import com.company.service.FreeSlotFinder;
import com.company.service.MeetingParser;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[][] meetingsArrayA = {{900, 930}, {930, 1000}, {1100, 1230}};
        int[][] meetingsArrayB = {{930, 1000}, {1400, 1500}};

        MeetingParser meetingParser = new MeetingParser();
        List<Meeting> meetingA = meetingParser.createMeetingList(meetingsArrayA);
        List<Meeting> meetingB = meetingParser.createMeetingList(meetingsArrayB);
        System.out.println("meetingA: " + meetingA);
        System.out.println("meetingB: " + meetingB);

        FreeSlotFinder freeSlotFinder = new FreeSlotFinder();
        List<FreeSlot> freeSlotsA = freeSlotFinder.findFreeSlots(meetingA);
        List<FreeSlot> freeSlotsB = freeSlotFinder.findFreeSlots(meetingB);
        System.out.println("freeSlotsA: " + freeSlotsA);
        System.out.println("freeSlotsB: " + freeSlotsB);

        List<FreeSlot> commonFreeSlots = freeSlotFinder.findCommonFreeSlot(freeSlotsA, freeSlotsB);
        System.out.println("commonFreeSlots: " + commonFreeSlots);
    }
}
