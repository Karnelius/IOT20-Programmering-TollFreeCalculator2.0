package kyh.labs.lab4;

import org.junit.jupiter.api.*;


import java.io.File;
import java.io.OptionalDataException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TollFeeCalculatorTEST {
public final TollFeeCalculator tester = new TollFeeCalculator("testData/Lab4.txt");


    @Test
    @DisplayName("Testing that isTollFreeDate works")
    void yesOrNo() {
        LocalDateTime date = LocalDateTime.parse("2020-07-25 07:20", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        assertTrue(tester.isTollFreeDate(date));


        // in med datum av olika slag , ut med resultat . Datum av den typen av bugg.
    }


    @Test
    @DisplayName("Testing that TollFeePerPassing works")
    void yesOrNo2(){
        LocalDateTime dateFee8_0600_0629 = LocalDateTime.parse("2020-04-10 06:15", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(8,tester.getTollFeePerPassing(dateFee8_0600_0629));

        LocalDateTime dateFee13_0630_0659 = LocalDateTime.parse("2020-04-10 06:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(13,tester.getTollFeePerPassing(dateFee13_0630_0659));

        LocalDateTime dateFee18_0700_0759 = LocalDateTime.parse("2020-04-10 07:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(18,tester.getTollFeePerPassing(dateFee18_0700_0759));

        LocalDateTime dateFee13_0800_0829 = LocalDateTime.parse("2020-04-10 08:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(13,tester.getTollFeePerPassing(dateFee13_0800_0829));

        // 14:20 rött - Bugg.

        LocalDateTime dateFee8_0830_1459 = LocalDateTime.parse("2020-04-10 14:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(8,tester.getTollFeePerPassing(dateFee8_0830_1459));

        LocalDateTime dateFee13_1500_1529 = LocalDateTime.parse("2020-04-10 15:29", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(13,tester.getTollFeePerPassing(dateFee13_1500_1529));

        LocalDateTime dateFee18_1530_1659 = LocalDateTime.parse("2020-04-10 16:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(18,tester.getTollFeePerPassing(dateFee18_1530_1659));

        LocalDateTime dateFee13_1700_1759 = LocalDateTime.parse("2020-04-10 17:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(13,tester.getTollFeePerPassing(dateFee13_1700_1759));

        LocalDateTime dateFee8_1800_1829 = LocalDateTime.parse("2020-04-10 18:05", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(8,tester.getTollFeePerPassing(dateFee8_1800_1829));

        LocalDateTime dateFee0_1830_0559 = LocalDateTime.parse("2020-04-10 22:15", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(0,tester.getTollFeePerPassing(dateFee0_1830_0559));
    }


    /*@DisplayName("Testing that max 1 fee per passing works")
    @Test
    void yesOrNo3() {
        LocalDateTime date1 = LocalDateTime.parse("07:20", DateTimeFormatter.ofPattern("HH:mm"));
        LocalDateTime date2 = LocalDateTime.parse("08:29", DateTimeFormatter.ofPattern("HH:mm"));
        assertEquals(tester.getTotalFeeCost(date1));

    }*/

    @DisplayName("Test if amount is max 60")
    @Test
    void yesOrNo4(){
        LocalDateTime[] dateTest1 = new LocalDateTime[10];
        dateTest1[0] = LocalDateTime.parse("2020-06-01 06:01", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 8
        dateTest1[1] = LocalDateTime.parse("2020-06-01 06:01", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 8
        dateTest1[2] = LocalDateTime.parse("2020-06-01 06:01", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 8
        dateTest1[3] = LocalDateTime.parse("2020-06-01 06:01", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 8
        dateTest1[4] = LocalDateTime.parse("2020-06-01 06:01", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 8
        dateTest1[5] = LocalDateTime.parse("2020-06-01 06:01", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 8
        dateTest1[6] = LocalDateTime.parse("2020-06-01 06:01", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 8
        dateTest1[7] = LocalDateTime.parse("2020-06-01 06:01", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 8
        dateTest1[8] = LocalDateTime.parse("2020-06-01 06:01", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 8
        dateTest1[9] = LocalDateTime.parse("2020-06-01 06:01", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 8
                                                                                                                        //Total 8x10 = 80 but expected 60 (max).
        Assertions.assertEquals(60, tester.getTotalFeeCost(dateTest1));
        }

       //@DisplayName("Test if length is same as lenght in input file: Lab4.txt")
       //@Test
        // Jämföra dateString.lenght med dates.lenght
        // ny instans av tollfeecalculcaotr


        //@DisplayName("Test if only 1 fee under 60 min")
        //@Test
        //assertEquals(10, tester.getTotalFeeCost(dateTest1));


    }



