package org.example.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class DateGeneratorImpl implements DateGenerator{
    @Override
    public LocalDate generateDate() {
        LocalDate startDate = LocalDate.of(2010, 1, 1);
        long days = ChronoUnit.DAYS.between(startDate, LocalDate.now());
        return startDate.plusDays(new Random().nextInt((int) days + 1));
    }
}
