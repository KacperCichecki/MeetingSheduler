package com.company.model;


public class Meeting {
    private int start;
    private int end;

    public Meeting(int start, int end) {
        if (start >= end) {
            throw new RuntimeException("start time can't by later then end meeting time");
        }
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
