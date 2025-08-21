public class Cat extends Animal {

    private static final int MAX_RUN_DISTANCE = 200;
    private static int catsCount = 0;
    private boolean isFull; // сытость

    public Cat(String name) {
        super(name);
        catsCount++;
        this.isFull = false; // изначально кот голоден
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. Максимум: " + MAX_RUN_DISTANCE + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать!");
    }

    // Метод для еды из миски
    public void eatFromBowl(FoodBowl bowl, int foodAmount) {
        if (bowl.hasEnoughFood(foodAmount)) {
            bowl.takeFood(foodAmount);
            this.isFull = true;
            System.out.println(name + " покушал " + foodAmount + " единиц еды и наелся.");
        } else {
            System.out.println(name + " не может поесть - недостаточно еды в миске.");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatsCount() {
        return catsCount;
    }

}
