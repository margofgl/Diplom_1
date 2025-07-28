import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTest {

    @Test
    public void testIngredientCreation() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус фирменный Space Sauce", 88.0f);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
        assertEquals("Соус фирменный Space Sauce", ingredient.getName());
        assertEquals(88.0f, ingredient.getPrice(), 0.01f);
    }
}