package kyh.labs.lab4;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;


public class TollFeeCalculatorTEST {


    @Test
    @DisplayName("Testing that isTollFreeDate works")
    void Test() {
        LocalDateTime date = LocalDateTime.parse("2020-07-25 07:20", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        assertTrue(TollFeeCalculator.isTollFreeDate(date));
    }


    @Test
    @DisplayName("Bug #1 - Testing that TollFeePerPassing works") // 14:20 rött - Bugg.
        //Testar så att rätt taxa tas från rätt tidsintervall. Exempelvis 14:20 var fel tidigare, tidigare var det fel vid halvtimmar, exempelvis 14:20 räknades som "else" = 8 kr.
    void Bug1(){
        LocalDateTime dateFee8_0600_0629 = LocalDateTime.parse("2020-04-10 06:15", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(8,TollFeeCalculator.getTollFeePerPassing(dateFee8_0600_0629));

        LocalDateTime dateFee13_0630_0659 = LocalDateTime.parse("2020-04-10 06:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(13,TollFeeCalculator.getTollFeePerPassing(dateFee13_0630_0659));

        LocalDateTime dateFee18_0700_0759 = LocalDateTime.parse("2020-04-10 07:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(18,TollFeeCalculator.getTollFeePerPassing(dateFee18_0700_0759));

        LocalDateTime dateFee13_0800_0829 = LocalDateTime.parse("2020-04-10 08:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(13,TollFeeCalculator.getTollFeePerPassing(dateFee13_0800_0829));

        LocalDateTime dateFee8_0830_1459 = LocalDateTime.parse("2020-04-10 14:20", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(8,TollFeeCalculator.getTollFeePerPassing(dateFee8_0830_1459));

        LocalDateTime dateFee13_1500_1529 = LocalDateTime.parse("2020-04-10 15:29", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(13,TollFeeCalculator.getTollFeePerPassing(dateFee13_1500_1529));

        LocalDateTime dateFee18_1530_1659 = LocalDateTime.parse("2020-04-10 16:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(18,TollFeeCalculator.getTollFeePerPassing(dateFee18_1530_1659));

        LocalDateTime dateFee13_1700_1759 = LocalDateTime.parse("2020-04-10 17:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(13,TollFeeCalculator.getTollFeePerPassing(dateFee13_1700_1759));

        LocalDateTime dateFee8_1800_1829 = LocalDateTime.parse("2020-04-10 18:05", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(8,TollFeeCalculator.getTollFeePerPassing(dateFee8_1800_1829));

        LocalDateTime dateFee0_1830_0559 = LocalDateTime.parse("2020-04-10 22:15", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Assertions.assertEquals(0,TollFeeCalculator.getTollFeePerPassing(dateFee0_1830_0559));
    }


    @Test
    @DisplayName("Bug #2(+1) - Test if total amount is max 60") // 2 buggar
    //Testar så att max taxan per dag är 60. 2 Buggar som testas här, tidigare var det maxtaxa 60 som användes automatiskt med Math.max vilket resulterade i maxtaxa = 60. Samt bugg 2 att maxtaxan får uppgå till max 60 kr.
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
        Assertions.assertEquals(60, TollFeeCalculator.getTotalFeeCost(dateTest1));
        }

    @Test
    @DisplayName("Bug #3(+1) - Tests if only 1 fee (max fee) get added within 60 min")
    // Testar så att det endast dras 1 taxa per 60 min, tidigare kunde flera olika taxor dras och nu dras endast 1 taxa per 60 min och det är den högsta (bug 2).
    void Bug3(){
        LocalDateTime[] dateTest1 = new LocalDateTime[5];
        dateTest1[0] = LocalDateTime.parse("2020-10-05 07:51", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 18
        dateTest1[1] = LocalDateTime.parse("2020-10-05 08:02", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 13
        dateTest1[2] = LocalDateTime.parse("2020-10-05 08:03", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 13
        dateTest1[3] = LocalDateTime.parse("2020-10-05 08:04", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 13
        dateTest1[4] = LocalDateTime.parse("2020-10-05 08:05", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 13

        Assertions.assertEquals(18, TollFeeCalculator.getTotalFeeCost(dateTest1));
    }

    @Test
    @DisplayName("Bug #4 - Test if length is same as length in input file: Lab4.txt")
    //Testar så att längden på textfilen(inputen) är samma som outputen. Tidigare fanns det lenght-1, vilket resulterade i -1 output.
    void Bug4(){
        TollFeeCalculator tester = new TollFeeCalculator("testData/Lab4.txt");
        assertEquals(tester.testDates.length, tester.testDateStrings.length);
       }


    @Test
    @DisplayName("Bug #5 - Tests if fee will be added exactly on exactly 60 min")
    //Testar så att en taxa läggs på exakt på 60min, inte på 59 osv. Brytet går på 60 min.
    void Bug5(){
        LocalDateTime[] dateTest2 = new LocalDateTime[4];
        dateTest2[0] = LocalDateTime.parse("2020-12-01 08:31", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 8
        dateTest2[1] = LocalDateTime.parse("2020-12-01 09:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 8
        dateTest2[2] = LocalDateTime.parse("2020-12-01 10:29", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));    //Fee 8
        dateTest2[3] = LocalDateTime.parse("2020-12-01 11:28" , DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));   //Fee 8

        Assertions.assertEquals(16, TollFeeCalculator.getTotalFeeCost(dateTest2));
    }

    @Test
    @DisplayName("Bug #6 - Tests if it's in the same day")
    //Testar så att det inte finns fler inputs med olika dagar. Då en fil = en 24h dag.Dvs tar filen ett annat datum, så får vi ett felmeddelande med "Wrong Date".
    void Bug6() {
        TollFeeCalculator tester = new TollFeeCalculator("testData/Lab4.txt");

        int dayOne = tester.testDates[0].getDayOfYear();
        for(int i = 0; i < tester.testDates.length; i++) {

            Assertions.assertEquals(dayOne, tester.testDates[i].getDayOfYear());
        }
    }

    @Test
    @DisplayName("Bug #7 - Testing that if a wrong-message would pop up if the inputfile does not match the error-text file.")
    //Buggar där inga fel skrivs ut när fel exempelvis fel input fil läses in eller fel datum skrivs i Lab4.txt filen.
    void Bug7(){
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setErr(new PrintStream(outputStreamCaptor));

        TollFeeCalculator tester = new TollFeeCalculator("testData/Lab14.txt");

        assertEquals("Could not read the file testData/Lab14.txt", outputStreamCaptor.toString().trim());
    }
}


