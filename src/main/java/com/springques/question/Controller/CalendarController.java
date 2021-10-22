package com.springques.question.Controller;

import com.springques.question.Model.Calendar;
import com.springques.question.Model.CalendarInput;
import com.springques.question.Model.CalendarOutput;
import com.springques.question.Service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class CalendarController {

    @Autowired
    public CalendarService calendarService;

    @GetMapping("/calendarList")
    public List<Calendar> getsCalendarlist() throws ParseException {
        return calendarService.getCalendars();
    }

    @PostMapping("/findStoreAvailability")
    public CalendarOutput getStaus(@RequestBody CalendarInput calendarInput) throws ParseException {
        calendarService.getCalendars();
        System.out.println(calendarInput);
        return calendarService.getCalendarOutput(calendarInput);
    }

}
