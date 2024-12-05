package kiosk.model;

public class Order {
    private Food food; //음식
    private int quantity; //수량

    public Order(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public Food getFood() {
        return food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int calculateTotalPrice() {
        return food.getPrice() * quantity;
    }
}
