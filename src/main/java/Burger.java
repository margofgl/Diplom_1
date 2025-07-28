import java.util.ArrayList;
import java.util.List;

public class Burger {
    public Bun bun;
    public List<Ingredient> ingredients = new ArrayList<>();

    public void setBuns(Bun bun) {
        this.bun = bun;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void removeIngredient(int index) {
        ingredients.remove(index);
    }

    public void moveIngredient(int index, int newIndex) {
        Ingredient ingredient = ingredients.remove(index);
        ingredients.add(newIndex, ingredient);
    }

    public float getPrice() {
        float price = bun.getPrice() * 2; // верх и низ булки
        for (Ingredient ingredient : ingredients) {
            price += ingredient.getPrice();
        }
        return price;
    }

    public String getReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().name().toLowerCase(), ingredient.getName()));
        }
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("Price: %f%n", getPrice()));
        return receipt.toString();
    }
}