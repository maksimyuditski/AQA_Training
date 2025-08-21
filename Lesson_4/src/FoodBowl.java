public class FoodBowl {

    private int foodAmount;

    public FoodBowl(int initialFood) {
        this.foodAmount = Math.max(0, initialFood); // Не отрицательное
    }

    public boolean hasEnoughFood(int requestedAmount) {
        return foodAmount >= requestedAmount;
    }

    public void takeFood(int amount) {
        if (hasEnoughFood(amount)) {
            foodAmount -= amount;
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("В миску добавили " + amount + " единиц еды. Всего: " + foodAmount);
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }

}
