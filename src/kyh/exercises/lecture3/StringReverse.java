package kyh.exercises.lecture3;

public class StringReverse {
    public static String reverse(String in) {
        String result = "";

        for (int i=in.length()-1; i>=0; i--) {
            result = result + in.charAt(i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse("Hello World"));
    }
}
