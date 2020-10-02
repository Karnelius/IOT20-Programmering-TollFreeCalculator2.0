package kyh.lectures.lecture5;

public abstract class Animal {
    protected String name;
    protected String sound;

    public Animal(String name) {
        this.name = name;
    }

    protected int calculateSpeed() {
        return name.length()*5;
    }

    public String getName() {
        return name;
    }

    public void setName(String inputName) {
        name = inputName;
    }

    public void printSound() {
        System.out.println(name + ": " + sound);
    }
}
