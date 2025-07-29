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
                {988f, 88f, 988 * 2 + 88f},     // Флюоресцентная булка + соус Space Sauce
                {300f, 300f, 300 * 2 + 300f},   // Красная булка + мясо бессмертного моллюска
                {200f, 0f, 200 * 2 + 0f}        // Белая булка + без начинки
        });
    }

    @Before
    public void setup() {
        burger = new Burger();
    }

    @Test
    public void testBurgerPriceWithDifferentData() {
        Bun bun = mock(Bun.class);
        Ingredient ingredient = mock(Ingredient.class);

        when(bun.getPrice()).thenReturn(bunPrice);
        when(ingredient.getPrice()).thenReturn(ingredientPrice);

        burger.setBuns(bun);
        burger.ingredients = new ArrayList<>();
        burger.ingredients.add(ingredient);

        float actualPrice = burger.getPrice();

        assertEquals(expectedPrice, actualPrice, 0.01f);
    }
}