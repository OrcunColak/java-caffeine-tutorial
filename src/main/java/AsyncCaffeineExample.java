import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class AsyncCaffeineExample {

    public static void main() {
        AsyncLoadingCache<String, String> cache = Caffeine.newBuilder()
                .maximumSize(100)
                .buildAsync(AsyncCaffeineExample::fetchDataFromDatabase);

        cache.get("key").thenAccept(System.out::println);
    }

    // ForkJoinPool.commonPool-worker-1 calls this
    private static String fetchDataFromDatabase(String key) {
        log.info("fetchDataFromDatabase is called");
        return "fetchedValue"; // Simulating database fetch
    }
}
