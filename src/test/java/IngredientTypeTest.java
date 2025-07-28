import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void testValuesNotNull() {
        for (IngredientType type : IngredientType.values()) {
            assertNotNull(type);
        }
    }

    @Test
    public void testEnumNames() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
        assertEquals("FILLING", IngredientType.FILLING.name());
    }
}