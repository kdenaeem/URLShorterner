import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ShortenerTest {
    @Test
    public void testBasicShortening() {
        Shorterner shorterner = new Shorterner();
        String longURL = "www.example.com";

        String shortURL = shorterner.shorten(longURL);
        assertNotNull(shortURL);
        assertEquals(longURL, shorterner.getOriginalUrl(shortURL));
    }
    @Test
    public void testNullAndEmptyInputs() {
        Shorterner shorterner = new Shorterner();
        assertNull(shorterner.shorten(null));
        assertNull(shorterner.shorten(""));
        assertNull(shorterner.shorten("   "));
        assertNull(shorterner.getOriginalUrl(null));
        assertNull(shorterner.getOriginalUrl(""));
    }


}
