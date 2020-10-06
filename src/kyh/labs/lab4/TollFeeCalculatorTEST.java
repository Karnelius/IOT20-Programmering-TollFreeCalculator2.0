package kyh.labs.lab4;

import org.junit.jupiter.api.*;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import static org.junit.jupiter.api.Assertions.*;


public class TollFeeCalculatorTEST {
public final TollFeeCalculator tester = new TollFeeCalculator("testData/Lab4.txt");


    @Test
    @DisplayName("Testing that isTollFreeDate works")
    void Test() {
        LocalDateTime date = LocalDateTime.parse("2020-07-25 07:20", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        assertTrue(tester.isTollFreeDate(date));
    }


    @Test
    @DisplayName("Bug #1 - Testing that TollFeePerPassing works") // 14:20 rött - Bugg.
        //Testar så att rätt taxa tas från rätt tidsintervall. Exempelvis 14:20 var fel tidigare.
    void Bug1(){
        LocalDateTime dateFee8_0600_0629 = LocalDateTime.parse("2020-04-10 06:15", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(8,tester.getTollFeePerPassing(dateFee8_0600_0629));

        LocalDateTime dateFee13_0630_0659 = LocalDateTime.parse("2020-04-10 06:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(13,tester.getTollFeePerPassing(dateFee13_0630_0659));

        LocalDateTime dateFee18_0700_0759 = LocalDateTime.parse("2020-04-10 07:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(18,tester.getTollFeePerPassing(dateFee18_0700_0759));

        LocalDateTime dateFee13_0800_0829 = LocalDateTime.parse("2020-04-10 08:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(13,tester.getTollFeePerPassing(dateFee13_0800_0829));

        LocalDateTime dateFee8_0830_1459 = LocalDateTime.parse("2020-04-10 14:20", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
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


    @Test
    @DisplayName("Bug #2 - Test if total amount is max 60")
    //Testar så att max taxan per dag är 60.
    void Bug2(){
        LocalDateTime[] dateTest1 = new LocalDateTime[10];
        dateTest1[0] = LocalDateTime.parse("2020-06-01 08:01", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 13
        dateTest1[1] = LocalDateTime.parse("2020-06-01 09:02", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 8
        dateTest1[2] = LocalDateTime.parse("2020-06-01 10:03", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 8
        dateTest1[3] = LocalDateTime.parse("2020-06-01 11:04", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 8
        dateTest1[4] = LocalDateTime.parse("2020-06-01 12:05", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 8
        dateTest1[5] = LocalDateTime.parse("2020-06-01 13:06", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 8
        dateTest1[6] = LocalDateTime.parse("2020-06-01 14:07", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 8
        dateTest1[7] = LocalDateTime.parse("2020-06-01 15:08", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 13
        dateTest1[8] = LocalDateTime.parse("2020-06-01 16:09", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 18
        dateTest1[9] = LocalDateTime.parse("2020-06-01 17:10", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 13
                                                                                                                        // Total 105 but expected 60.
        Assertions.assertEquals(60, tester.getTotalFeeCost(dateTest1));
        }

    @Test
    @DisplayName("Bug #3 - Tests if only 1 fee (max fee) get added within 60 min")
    // Testar så att det endast dras 1 taxa per 60 min.
    void Bug3(){
        LocalDateTime[] dateTest1 = new LocalDateTime[5];
        dateTest1[0] = LocalDateTime.parse("2020-10-05 07:51", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 18
        dateTest1[1] = LocalDateTime.parse("2020-10-05 08:02", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 13
        dateTest1[2] = LocalDateTime.parse("2020-10-05 08:03", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 13
        dateTest1[3] = LocalDateTime.parse("2020-10-05 08:04", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 13
        dateTest1[4] = LocalDateTime.parse("2020-10-05 08:05", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 13

        Assertions.assertEquals(18, tester.getTotalFeeCost(dateTest1));
    }

    @Test
    @DisplayName("Bug #4 - Test if length is same as length in input file: Lab4.txt")
    //Testar så att längden på textfilen(inputen) är samma som outputen.
    void Bug4(){
        TollFeeCalculator tester = new TollFeeCalculator("testData/Lab4.txt");
        assertEquals(tester.testDates.length, tester.testDateStrings.length);
       }


    @Test
    @DisplayName("Bug #5 - Tests if fee will be added exactly on exactly 60 min")
    //Testar så att en taxa läggs på exakt på 60min.
    void Bug5(){
        LocalDateTime[] dateTest2 = new LocalDateTime[4];
        dateTest2[0] = LocalDateTime.parse("2020-12-01 08:31", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 8
        dateTest2[1] = LocalDateTime.parse("2020-12-01 09:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 8
        dateTest2[2] = LocalDateTime.parse("2020-12-01 10:29", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 8
        dateTest2[3] = LocalDateTime.parse("2020-12-01 11:28" , DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));   //Fee 8

        Assertions.assertEquals(16, tester.getTotalFeeCost(dateTest2));
    }

    @Test
    @DisplayName("Bug #6 - Tests if it's in the same day")
    //Testar så att det inte finns fler inputs med olika dagar. Då en fil = en 24h dag.
    void Bug6() {
        TollFeeCalculator tester = new TollFeeCalculator("testData/Lab4.txt");

        int dayOne = tester.testDates[0].getDayOfYear();
        for(int i = 0; i < tester.testDates.length; i++) {

            Assertions.assertEquals(dayOne, tester.testDates[i].getDayOfYear());


        }
    }

    @Test
    @DisplayName("Bug #7 - Testing if exception is thrown.")
    //Testar isolerat så att en exception är thrown.
    void Bug7(){
        LocalDateTime[] dateTest2 = new LocalDateTime[4];
        dateTest2[3] = LocalDateTime.parse("2020-12-01 11:28" , DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertThrows(Exception.class, () -> tester.throwException());
    }

}


