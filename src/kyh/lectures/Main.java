package kyh.lectures;

class MyInt {
    private int i = 0;
    public MyInt(int i) {
        this.i = i;
    }

    public void setNumber(int i) {
        this.i = i;
    }

    public int getNumber() {
        return this.i;
    }
}

public class Main {

    /*public static changeName(Dog inputDog) {
        inputDog.setName("Hej");
    }*/

    public static void changeNumber(MyInt i) {
        i.setNumber(8);
    }

    public static void main(String[] args) {
        /*Dog dog = new Dog("Fido");
        changeName(dog);
        System.out.println(dog);
*/
        MyInt i = new MyInt(5);
        //changeNumber(i);
        System.out.println(i.getNumber());
    }
}



