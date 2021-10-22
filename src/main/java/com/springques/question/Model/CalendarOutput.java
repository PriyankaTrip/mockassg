package com.springques.question.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CalendarOutput {
    private CalendarInput calendarInput;
    private String status;
}
