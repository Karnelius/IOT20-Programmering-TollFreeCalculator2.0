package kyh.labs.lab4;

import javax.swing.text.DateFormatter;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

public class TollFeeCalculator {

    public String[] testDateStrings;
    public LocalDateTime[] testDates;



    public TollFeeCalculator(String inputFile) {
        try {
            Scanner sc = new Scanner(new File(inputFile));
            String[] dateStrings = sc.nextLine().split(", ");
            //ToDo Bug #4.
            LocalDateTime[] dates = new LocalDateTime[dateStrings.length];
            testDateStrings = dateStrings;
            testDates = dates;
            for (int i = 0; i < dates.length; i++) {

                dates[i] = LocalDateTime.parse(dateStrings[i], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

                int dayOne = dates[0].getDayOfYear();
                if (dates[i].getDayOfYear() != dayOne) {
                    throw new Exception();

                }
            }
            //ToDO Bug #7.
            sc.close();
            System.out.println("The total fee for the inputfile is " + getTotalFeeCost(dates));
            //ToDo Bug #6.
        } catch (DateTimeParseException e) {
            System.err.println("Could not parse the dates:  " + e + " Please try again!");
        } catch (IOException e) {
            System.err.println("Could not read the file " + inputFile);
        }
        //ToDo #8. (Till vilken funktion? Inget förändrat i programmet...?)
        catch (Exception e) {
            System.err.println("Wrong date");
        } finally{
            System.out.println("This wonderful TollFeeCalculator is finally closed");
        }
    }

    //ToDo Bug #3.
    public int getTotalFeeCost(LocalDateTime[] dates) {
        int totalFee = 0;
        LocalDateTime intervalStart = dates[0];
        int maxFeesunder60min = 0;
        for(LocalDateTime date: dates) {
            long diffInMinutes = intervalStart.until(date, ChronoUnit.MINUTES);
            int fee = 0;
            //Todo Bug #5.
            if(diffInMinutes >= 60) {
                //fee = getTollFeePerPassing(date) + maxFeesunder60min;
                maxFeesunder60min = 0;
                intervalStart = date;
                totalFee += getTollFeePerPassing(date);
            } else {
                maxFeesunder60min = Math.max(getTollFeePerPassing(date), maxFeesunder60min);
                totalFee += fee;
            }
            System.out.println(date.toString() +"\n" + "Fee: " + getTollFeePerPassing(date)+ "\n" + "---------" );
        }
        //Todo Bug #2.
        return Math.min(totalFee + maxFeesunder60min, 60);
    }

    //ToDo Bug #1. (Bug #9 remove minutes in if / else if?)
    public int getTollFeePerPassing(LocalDateTime date) {
        if (isTollFreeDate(date)) return 0;
        int hour = date.getHour();
        int minute = date.getMinute();
        if (hour == 6 && minute <= 29) return 8;
        else if (hour == 6) return 13;
        else if (hour == 7) return 18;
        else if (hour == 8 && minute<= 29) return 13;
        else if (hour >= 8 && hour <15) return 8;
        else if (hour == 15 && minute <= 29) return 13;
        else if (hour == 15 || hour == 16) return 18;
        else if (hour == 17) return 13;
        else if (hour == 18 && minute <= 29) return 8;
        else return 0;
    }

    public boolean isTollFreeDate(LocalDateTime date) {
        return date.getDayOfWeek().getValue() == 6 || date.getDayOfWeek().getValue() == 7 || date.getMonth().getValue() == 7;
    }

    public static void main(String[] args) {
        new TollFeeCalculator("testData/Lab4.txt");
    }



}
