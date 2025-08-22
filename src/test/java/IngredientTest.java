import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTest {

    @Test
    public void testIngredientCreationSauce() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус фирменный Space Sauce", 88f);

        assertEquals(IngredientType.SAUCE, ingredient.getType());
        assertEquals("Соус фирменный Space Sauce", ingredient.getName());
        assertEquals(88f, ingredient.getPrice(), 0.01f);
    }

    @Test
    public void testIngredientCreationFilling() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Мясо бессмертного моллюска Protostomia", 300f);

        assertEquals(IngredientType.FILLING, ingredient.getType());
        assertEquals("Мясо бессмертного моллюска Protostomia", ingredient.getName());
        assertEquals(300f, ingredient.getPrice(), 0.01f);
    }
}