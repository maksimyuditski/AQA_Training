public abstract class Animal {

    protected String name;
    protected static int totalAnimalsCount = 0;

    public Animal(String name) {
        this.name = name;
        totalAnimalsCount++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public String getName() {
        return name;
    }

    public static int getTotalAnimalsCount() {
        return totalAnimalsCount;
    }

}
