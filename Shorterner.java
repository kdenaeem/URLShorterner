import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class Shorterner {
    private final ConcurrentHashMap<String, String> shortToLong = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, String> longtoShort = new ConcurrentHashMap<>();

    public String shorten(String longURL) {
        if (!isValidURL(longURL)) {
            return null;
        }
        if (longtoShort.containsKey(longURL)) {
            return longtoShort.get(longURL);
        }

        String existingShort = longtoShort.get(longURL);
        if (existingShort != null) {
            return existingShort;
        }

        try {
            String shortUrl = Integer.toHexString(longURL.hashCode());
            String existing = shortToLong.putIfAbsent(shortUrl, longURL);
            if (existing != null) {
                return shortUrl;
            }

            longtoShort.put(longURL, shortUrl);
            return shortUrl;
        } catch (Exception e) {
            return null;
        }

    }
    public String getOriginalUrl(String shortURL) {
        if (shortURL == null || shortURL.isEmpty()) {
            return null;
        }

        return shortToLong.get(shortURL);
    }

    private boolean isValidURL(String urlString) {
        if (urlString == null || urlString.trim().isEmpty()) {
            return false;
        }
        return true;
    }

}
