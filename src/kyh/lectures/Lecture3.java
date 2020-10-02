package kyh.lectures;

import java.io.File;
import java.util.Scanner;

public class Lecture3 {
    public static void printAbsolutePath() {
        File file = new File("C://dapppp");
        System.out.println("Filen ligger här: " + file.getAbsolutePath());
    }

    public static void guessTheNumber() {
        int answer = 13;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gissa på ett tal: ");

        while(scanner.hasNext()) {
            int number = scanner.nextInt();
            if(number < answer) {
                System.out.println("Din gissning är för stor, gissa lägre");
            } else if (number < answer) {
                System.out.println("Din gissning är för litet, gissa högre");
            } else {
                System.out.println("Grattis!");
                break;
            }
        }
    }

    public static String printEveryOtherWord(String s) {
        String result = "";
        Scanner sc = new Scanner(s);
        while(sc.hasNext()) {
            result = result + " " + sc.next();
            if(sc.hasNext()) {
                sc.next();
            }
        }
        return result;
    }

    public static String reverseSentence(String s) {
        String result = "";
        Scanner sc = new Scanner(s);
        while(sc.hasNext()) {
            result = sc.next() + " " + result;
        }
        return result;
    }

    public static void main(String[] args) {
        String quote = "Stan är full av tanter och tragik";
        System.out.println(reverseSentence(quote));
    }










}
