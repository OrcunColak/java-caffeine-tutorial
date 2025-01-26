package refreshing;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

public class CaffeineRefreshAfterWriteExample {

    // When an entry is queried after 5 minutes, a refresh is triggered asynchronously.
    // The old value is returned immediately, and the new value is fetched in the background.
    public static void main() {
        LoadingCache<String, String> cache = Caffeine.newBuilder()
                .refreshAfterWrite(java.time.Duration.ofMinutes(5))
                .build(CaffeineRefreshAfterWriteExample::fetchDataFromService);
    }

    private static String fetchDataFromService(String key) {
        return "";
    }

}
