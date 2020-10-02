package kyh.labs.lab4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TollFeeCalculatorTEST {
private final TollFeeCalculator freeorNot= new TollFeeCalculator("testData/Lab4.txt");



    @Test
    @DisplayName("Testing that isTollFreeDate works")
    void yesOrNo() {
        LocalDateTime date = LocalDateTime.parse("2020-06-30 07:20", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        assertTrue(freeorNot.isTollFreeDate(date));
        date = LocalDateTime.parse("2020-05-30 06", DateTimeFormatter.ofPattern("yyyy-HH-dd HH:mm"));

        // in med datum av olika slag , ut med resultat . Datum av den typen av bugg.
    }

}

