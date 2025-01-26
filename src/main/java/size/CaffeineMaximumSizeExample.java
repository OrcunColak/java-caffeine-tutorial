import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

public static void main() {

    Cache<String, String> cache = Caffeine.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .maximumSize(100)
            .build();

    // Put and Get Example
    cache.put("key", "value");
    String value = cache.getIfPresent("key");
    System.out.println(value); // Output: value
}
