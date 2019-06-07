package pl.coderslab.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Calendar;

//@Component
@Repository
public class SimpleCustomerLogger implements CustomerLogger {
    @Override
    public void log(String message) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        System.out.println("" + hour + ":" + minute + ": " + message);
    }
}
