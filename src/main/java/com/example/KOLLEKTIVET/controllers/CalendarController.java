package com.example.KOLLEKTIVET.controllers;

import com.example.KOLLEKTIVET.models.CalendarResponse;
import com.example.KOLLEKTIVET.models.CalendarEvent;
import com.example.KOLLEKTIVET.repositories.CalendarEventRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;


@RestController
@RequestMapping("/api/calendar")
public class CalendarController {

    @Autowired
    private CalendarEventRepository eventRepository;

    @GetMapping("/current")
    public CalendarResponse getCurrentCalendar() {

        LocalDate today = LocalDate.now();
        YearMonth ym = YearMonth.of(today.getYear(), today.getMonth());

        int daysInMonth = ym.lengthOfMonth();
        int firstDay = ym.atDay(1).getDayOfWeek().getValue(); 
        int todayDayOfMonth = today.getDayOfMonth();  

        return new CalendarResponse(
                today.getMonth().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("no")),
                today.getYear(),
                daysInMonth,
                firstDay,
                todayDayOfMonth
        );
    }

    @GetMapping("/events")
    public List<CalendarEvent> getEventsForCurrentMonth() {
        return eventRepository.findAll();
    }

    @PostMapping("/events")
    public CalendarEvent createEvent(@RequestBody CalendarEvent newEvent) {
        return eventRepository.save(newEvent);
    }

    @GetMapping("/month")
    public CalendarResponse getCalendarForMonth(
            @RequestParam int year,
            @RequestParam int month
    ) {
        YearMonth ym = YearMonth.of(year, month);
        LocalDate today = LocalDate.now();

        int daysInMonth = ym.lengthOfMonth();
        int firstDay = ym.atDay(1).getDayOfWeek().getValue();
        int todayDayOfMonth = (today.getYear() == year && today.getMonthValue() == month)
                ? today.getDayOfMonth()
                : -1; 

        return new CalendarResponse(
                ym.getMonth().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("no")),
                year,
                daysInMonth,
                firstDay,
                todayDayOfMonth
        );
    }

    @GetMapping("/events/month")
    public List<CalendarEvent> getEventsForMonth(
            @RequestParam int year,
            @RequestParam int month
    ) {
        List<CalendarEvent> all = eventRepository.findAll();

        return all.stream()
                .filter(ev -> {
                    if (ev.getDate() == null) return false;
                    LocalDate d = LocalDate.parse(ev.getDate());
                    return d.getYear() == year && d.getMonthValue() == month;
                })
                .toList();
    }

}
