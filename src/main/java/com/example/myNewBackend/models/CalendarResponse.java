package com.example.myNewBackend.models;

public class CalendarResponse {
    private String monthName;
    private int year;
    private int daysInMonth;
    private int firstDayOfWeek;
    private int todayDayOfMonth;

    public CalendarResponse(String monthName, int year, int daysInMonth, int firstDayOfWeek, int todayDayOfMonth) {
        this.monthName = monthName;
        this.year = year;
        this.daysInMonth = daysInMonth;
        this.firstDayOfWeek = firstDayOfWeek;
        this.todayDayOfMonth = todayDayOfMonth;
    }

    // GETTERS (må ha for at JSON-serialisering skal funke)
    public String getMonthName() {
        return monthName;
    }

    public int getYear() {
        return year;
    }

    public int getDaysInMonth() {
        return daysInMonth;
    }

    public int getFirstDayOfWeek() {
        return firstDayOfWeek;
    }

    public int getTodayDayOfMonth() {
        return todayDayOfMonth;
    }
}
