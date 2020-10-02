package kyh.lectures.lecture7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Main {

    public static void readFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("testData/Lab4.txt"));
        while(sc.hasNext()) {
            int x = sc.nextInt();
            if (x < 1) {
                throw new IllegalArgumentException();
            } else {
                for (int i = 0; i < x; i++) {
                    System.out.println("Hello");
                }
            }
        }
    }

    public static void test(Scanner sc){
        System.out.println(sc.next());
    }

    public static void main(String[] args) {

        /*int width = Math.toIntExact(Math.round(Math.random()*9+1));

        double r = Math.random()*9+1;
        System.out.println(r);
        long r2 = Math.round(r);
        System.out.println(r2);
        int height = Math.toIntExact(r2);
        System.out.println(height);

        Shape rect = new Rectangle(width, height);*/
        //System.out.println(rect.getArea() + " " + rect.getCircumference());
        //int diceRoll = Math.toIntExact(Math.round(Math.random()*5 + 1));
        //System.out.println(diceRoll);


        /*try {
            readFile();
        } catch(IllegalArgumentException e) {
            System.err.println("Input a number larger than 0");
        } catch(FileNotFoundException e) {
            System.err.println("Input a number larger than 0");
        } catch(Exception e) {
            System.err.println("Something else went wrong");
        }*/



        //try {
            test(null);
            /*canner sc = new Scanner(System.in);
            String input = sc.next();
            if(input.equals("Hello")) {
                throw new Exception("This is an error");
            }
            Exception ex = new NotHelloException("");*/
        /*} catch(Exception e) {
            System.out.println(e.getMessage());
        }*/


    }
}
