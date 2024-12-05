package mada_immo;

import mada_immo.service.DateService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MadaImmoApiApplicationTests {

    @Autowired
    private DateService dateService;

    @Test
    void getLastDayOfMonthTest() {
        // Assertions
        assertEquals( LocalDate.of( 2024, 2, 29 ), dateService.getLastDayOfMonth( LocalDate.of( 2024, 2, 4 ) ) );
        assertEquals( LocalDate.of( 2024, 3, 29 ), dateService.getLastDayOfMonth( LocalDate.of( 2024, 3, 1 ) ) );
    }

    @AfterEach
    public void tearDown() {
        System.out.println( "Test completed! All ok..." );
    }
}
