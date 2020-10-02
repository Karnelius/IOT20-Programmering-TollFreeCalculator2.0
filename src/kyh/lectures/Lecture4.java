package kyh.lectures;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Lecture4 {

    public static void printPathIfWordInFile(File f, String word) {
        try {
            Scanner sc = new Scanner(f);
            while(sc.hasNext()) {
                if(sc.next().equals(word)) {
                    System.out.println(f.getCanonicalPath());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void traverseTree(File dir, String word) {
        for(File f: dir.listFiles()) {
            if(f.isDirectory()) {
                traverseTree(f, word);
            } else {
                printPathIfWordInFile(f, word);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("Välkommen till FileCrawler!");
        System.out.println("Skriv in ett sökord så listar jag alla filer som innehåller det ordet");
        System.out.print("Sökord: ");
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        traverseTree(new File(".") ,word);
    }



    public static void printFile(String content) {
        File file = new File("CJL.txt");
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(content);
            fw.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void readFile() {
        File file = new File("CJL.txt");
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int sum(int i) {
        if(i == 0) {
            return 0;
        } else {
            return sum(i-1)+i;
        }
    }

}
