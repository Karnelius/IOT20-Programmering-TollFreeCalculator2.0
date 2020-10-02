package kyh.lectures;

public class Lecture1 {
    static void printHelloWorldWithName(String name) {
        System.out.println("Hello World " + name);
    }

    static void testSwitch() {
        int i = 1;
        switch(i) {
            case 0:
                System.out.println("Zero");
                break;
            case 1:
                System.out.println("One");
                break;
            default:
                System.out.println("Other");
        }
    }

    static void testFor() {
        for(int i = 0; i < 100; i++) {
            if (i == 1) {
                System.out.println(i);
            }
        }
        for(int i = 0; i < 100; i++) {
            if (i == 23) {
                System.out.println(i);
                break;
            } else {
                System.out.println("Number is not 23");
            }
        }
    }

    static void testVariables() {
        boolean isHomeless = false;
        double height = 1.79;
        int age = 33;
        String name = "David ";
        if (age == 23) {
            System.out.println("Hello World " + name + age + " " + isHomeless + " " + height);
        } else {
            System.out.println("Falsk ålder");
        }
    }

    static void testWhile() {
        int age = 32;
        while(age != 100) {
            age++;
            System.out.println("Programmet avslutat " + 50.0 / 3.0);
        }
    }

    public static void main(String[] args) {
        String name = "David";
        if(name == "David") {
            printHelloWorldWithName("David");
        } else if(name == "Nils") {
            printHelloWorldWithName("Nils");
        }
    }
}
