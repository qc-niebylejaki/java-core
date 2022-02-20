package com.qc.comparable;

public class Attendant implements Comparable<Attendant> {

    private long attendanceNo;
    private String name;

    public Attendant(long attendanceNo, String name) {
        this.attendanceNo = attendanceNo;
        this.name = name;
    }

    public long getAttendanceNo() {
        return attendanceNo;
    }

    public void setAttendanceNo(long attendanceNo) {
        this.attendanceNo = attendanceNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Attendant o) {
        return Long.compare(this.attendanceNo, o.attendanceNo);
    }

    @Override
    public String toString() {
        return "Attendant{" +
                "attendanceNo=" + attendanceNo +
                ", name='" + name + '\'' +
                '}';
    }
}
