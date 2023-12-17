package polymorphism.lab04WildFarm;

public abstract class Food {
    private Integer quantity;

    public Food(Integer quantity) {
        this.setQuantity(quantity);
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return this.quantity;
    }
}
