package kyh.lectures.lecture5;

public class MyInt {
    private int i;

    public MyInt(int in) {
        i = in;
    }

    public int getInt() {
        return i;
    }

    public void setInt(int in) {
        i = in;
    }

    public boolean equals(MyInt i) {
        return getInt() == i.getInt();
    }
}
