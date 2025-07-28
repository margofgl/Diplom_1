public class Ingredient {
    private final IngredientType type;
    private final String name;
    private final float price;

    public Ingredient(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public IngredientType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}