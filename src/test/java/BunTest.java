import org.junit.Test;
import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void testGetName() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988.0f);
        assertEquals("Флюоресцентная булка R2-D3", bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988.0f);
        assertEquals(988.0f, bun.getPrice(), 0.01f);
    }
}