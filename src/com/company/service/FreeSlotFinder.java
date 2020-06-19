package com.company.service;

import com.company.model.FreeSlot;
import com.company.model.Meeting;

import java.util.ArrayList;
import java.util.List;

public class FreeSlotFinder {

    private final int startWorkingTime;
    private final int endWorkingTime;

    public FreeSlotFinder() {
        this(800, 1600);
    }

    public FreeSlotFinder(int startWorkingTime) {
        this(startWorkingTime, 1600);
    }

    public FreeSlotFinder(int startWorkingTime, int endWorkingTime) {
        this.startWorkingTime = startWorkingTime;
        this.endWorkingTime = endWorkingTime;
    }

    public List<FreeSlot> findFreeSlots(List<Meeting> meetingList) {
        int startFreeSlotTime = startWorkingTime;
        List<FreeSlot> freeSlots = new ArrayList<>();

        for (Meeting meeting : meetingList) {
            if (meeting.getStart() > startFreeSlotTime) {
                freeSlots.add(new FreeSlot(startFreeSlotTime, meeting.getStart()));
            }
            startFreeSlotTime = meeting.getEnd();
        }

        if (startFreeSlotTime < endWorkingTime) {
            freeSlots.add(new FreeSlot(startFreeSlotTime, endWorkingTime));
        }
        return freeSlots;
    }

    public List<FreeSlot> findCommonFreeSlot(List<FreeSlot> freeSlotsA, List<FreeSlot> freeSlotsB) {
        List<FreeSlot> commonFreeSlots = new ArrayList<>();

        for (FreeSlot freeSlotA : freeSlotsA) {
            for (FreeSlot freeSlotB : freeSlotsB) {
                if (freeSlotB.getStart() >= freeSlotA.getEnd()) {
                    break;
                } else if (freeSlotA.getStart() > freeSlotB.getEnd()) {
                    continue;
                } else {
                    int startFreeSlot = Math.max(freeSlotB.getStart(), freeSlotA.getStart());
                    int endFreeSlot = Math.min(freeSlotB.getEnd(), freeSlotA.getEnd());
                    commonFreeSlots.add(new FreeSlot(startFreeSlot, endFreeSlot));
                }
            }
        }
        return commonFreeSlots;
    }
}
