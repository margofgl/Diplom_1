import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;
    private Bun bun;
    private Ingredient ingredient;

    @Before
    public void setup() {
        burger = new Burger();
        bun = mock(Bun.class);
        ingredient = mock(Ingredient.class);
    }

    @Test
    public void testSetBuns() {
        when(bun.getName()).thenReturn("Черная булка Spicy");
        when(bun.getPrice()).thenReturn(990.0f);

        burger.setBuns(bun);
        assertEquals("Черная булка Spicy", burger.bun.getName());
    }

    @Test
    public void testAddIngredient() {
        when(ingredient.getName()).thenReturn("Мясо бессмертного моллюска Protostomia");
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        burger.ingredients = new ArrayList<>();
        burger.ingredients.add(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ing1 = mock(Ingredient.class);
        Ingredient ing2 = mock(Ingredient.class);
        burger.ingredients = new ArrayList<>();
        burger.ingredients.add(ing1);
        burger.ingredients.add(ing2);

        burger.moveIngredient(0, 1);
        assertEquals(ing1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        when(bun.getPrice()).thenReturn(990.0f);
        when(ingredient.getPrice()).thenReturn(300.0f);

        burger.setBuns(bun);
        burger.ingredients = new ArrayList<>();
        burger.ingredients.add(ingredient);

        float price = burger.getPrice();
        assertEquals(2280.0f, price, 0.01f); // булка*2 + ингредиент
    }
    @Test
    public void testGetReceipt() {
        when(bun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        when(bun.getPrice()).thenReturn(988.0f);
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient.getName()).thenReturn("Соус фирменный Space Sauce");
        when(ingredient.getPrice()).thenReturn(88.0f);

        burger.setBuns(bun);
        burger.ingredients = new ArrayList<>();
        burger.ingredients.add(ingredient);

        String receipt = burger.getReceipt();

        assertTrue(receipt.contains("Флюоресцентная булка R2-D3"));
        assertTrue(receipt.contains("Соус фирменный Space Sauce"));
        assertTrue(receipt.contains("Price:"));
    }
}