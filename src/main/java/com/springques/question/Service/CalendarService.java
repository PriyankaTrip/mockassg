package com.springques.question.Service;

import com.springques.question.Model.Calendar;
import com.springques.question.Model.CalendarInput;
import com.springques.question.Model.CalendarOutput;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Service
public class CalendarService {

    List<Calendar> calendars = new ArrayList<>();
    SimpleDateFormat formatter = new SimpleDateFormat("hh:mm");

    public List<Calendar> getCalendars() throws ParseException {

        Date time1 = formatter.parse("13:30");
        Date time2 = formatter.parse("13:30");
        Date time3 = formatter.parse("13:30");
        calendars.add(new Calendar("STORE001", "ALL", formatter.format(time1)));
        calendars.add(new Calendar("STORE002", "SUNDAY", formatter.format(time2)));
        calendars.add(new Calendar("STORE003", "MONDAY", formatter.format(time3)));
        return calendars;
    }

    public CalendarOutput getCalendarOutput(CalendarInput calendarInput) throws ParseException {

        /*String dateTime = calendarInput.getReqDate();
        SimpleDateFormat formatt=new SimpleDateFormat("hh:mm");
        Date date=formatt.parse(dateTime);
        formatt.applyPattern("hh:mm");
        String dateStr = formatt.format(date);

        //String formatted = calendarInput.getReqDate().toString("hh: mm");
        //SimpleDateFormat formate = new SimpleDateFormat("yyyy-mm-dd'T'hh:mm:ss.SSS'Z'");
        String  calanderList = calendars.stream().filter(c -> c.getLocationID().equals(calendarInput.getStoreID()))
                .map(c -> c.getCutOffTime()).findFirst().orElse(null);
        System.out.println(calanderList);

         */

        CalendarOutput calendarOutput = null;
        if(calendarInput.getStoreID().equals("STORE001")) {
            calendarOutput = new CalendarOutput(calendarInput, "Available");
        }
        else
        {
            Date date = new SimpleDateFormat("yyyy-mm-dd'T'hh:mm:ss.SSS'Z'").parse(calendarInput.getRequestDate());
            System.out.println(date);
            //System.out.println(date.getDay());
            final List<Integer> BUSINESS_DAYS = Arrays.asList(
                    Calendar.SAT,Calendar.SUN,Calendar.MON,Calendar.TUE,
                    Calendar.WED,Calendar.THU,Calendar.FRI);
            for(Integer b: BUSINESS_DAYS)
            {
                if(b.equals(date.getDay())){
                    System.out.println("yes"+b);
                    if(b.equals(0) && calendarInput.getStoreID().equals("STORE002")){
                        calendarOutput = new CalendarOutput(calendarInput, "Available");
                    }
                    else if(b.equals(1) && calendarInput.getStoreID().equals("STORE003")){
                        calendarOutput = new CalendarOutput(calendarInput, "Available");
                    }
                    else {
                        calendarOutput = new CalendarOutput(calendarInput, "Not Available");
                    }
                }
            }
        }
        return calendarOutput;
    }
}
