import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class BurgerPriceParameterizedTest {

    private final float bunPrice;
    private final float ingredientPrice;
    private final float expectedPrice;

    private Burger burger;

    public BurgerPriceParameterizedTest(float bunPrice, float ingredientPrice, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "Булка: {0}, Ингредиент: {1} → Цена: {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {500f, 100f, 1100f},  // 500*2 + 100
                {700f, 200f, 1600f},  // 700*2 + 200
                {1000f, 0f, 2000f}    // 1000*2 + 0
        });
    }

    @Before
    public void setup() {
        burger = new Burger();
    }

    @Test
    public void testBurgerPriceWithDifferentData() {
        var bun = mock(Bun.class);
        var ingredient = mock(Ingredient.class);

        when(bun.getPrice()).thenReturn(bunPrice);
        when(ingredient.getPrice()).thenReturn(ingredientPrice);

        burger.setBuns(bun);
        burger.ingredients = new ArrayList<>();
        burger.ingredients.add(ingredient);

        float actualPrice = burger.getPrice();

        assertEquals(expectedPrice, actualPrice, 0.01f);
    }
}