package kyh.labs.lab4;

import org.junit.jupiter.api.*;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class TollFeeCalculatorTEST {
private final TollFeeCalculator tester = new TollFeeCalculator("testData/Lab4.txt");



   /* @Test
    @DisplayName("Testing that isTollFreeDate works")
    void yesOrNo() {
        LocalDateTime date = LocalDateTime.parse("2020-07-25 07:20", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        assertTrue(tester.isTollFreeDate(date));


        // in med datum av olika slag , ut med resultat . Datum av den typen av bugg.
    }
*/


        // Testar om summan som returnas är korrekt med tiderna under getTollFeePerPassing.
    @Test
    @DisplayName("Testing that TollFeePerPassing works")
    void yesOrNo2(){
        LocalDateTime date = LocalDateTime.parse("2020-04-10 06:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(tester.getTollFeePerPassing(date), 8);

        //Assertions.assertEquals(tester.getTollFeePerPassing(LocalDateTime.parse("2020-10-05 10:20",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))),10);

        LocalDateTime.parse("2020-04-10 06:45", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(tester.getTollFeePerPassing(date), 13);

        LocalDateTime.parse("2020-04-10 07:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(tester.getTollFeePerPassing(date), 18);

        LocalDateTime.parse("2020-04-10 08:15", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(tester.getTollFeePerPassing(date), 13);

        LocalDateTime.parse("2020-04-10 08:45", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(tester.getTollFeePerPassing(date), 8);

        LocalDateTime.parse("2020-04-10 13:20", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(tester.getTollFeePerPassing(date), 8);

        LocalDateTime.parse("2020-04-10 15:05", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(tester.getTollFeePerPassing(date), 13);

        LocalDateTime.parse("2020-04-10 15:45", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(tester.getTollFeePerPassing(date), 18);

        LocalDateTime.parse("2020-04-10 17:05", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(tester.getTollFeePerPassing(date), 13);

        LocalDateTime.parse("2020-04-10 18:15", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(tester.getTollFeePerPassing(date), 8);

        LocalDateTime.parse("2020-04-10 18:45", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(tester.getTollFeePerPassing(date), 0);
//ToDO får inte till Expected, den blir alltid noll (dvs return 0) - fast jag anger date - som är date+tid ovanför...



    }



}

