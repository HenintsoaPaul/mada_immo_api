package mada_immo.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DateService {
    public LocalDate getFirstDayOfMonth( LocalDate date ) {
        int nbDayz = date.getDayOfMonth();
        return date.minusDays( nbDayz );
    }

    public LocalDate getLastDayOfMonth( LocalDate date ) {
        int nbDayz = date.getDayOfMonth();
        return date.plusMonths( 1 ).minusDays( nbDayz );
    }
}
