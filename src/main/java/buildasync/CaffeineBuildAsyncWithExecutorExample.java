package buildasync;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Caffeine internally manages concurrency.
// By default, it uses a bounded thread pool for asynchronous operations, but you can supply your own Executor.
@Slf4j
class CaffeineBuildAsyncWithExecutorExample {

    private static final Executor customExecutor = Executors.newFixedThreadPool(4);

    public static void main() {
        AsyncLoadingCache<String, String> cache = Caffeine.newBuilder()
                .maximumSize(100)
                .executor(customExecutor)
                .buildAsync(CaffeineBuildAsyncWithExecutorExample::fetchDataFromDatabase);

        cache.get("key").thenAccept(System.out::println);
    }

    // ForkJoinPool.commonPool-worker-1 calls this
    private static String fetchDataFromDatabase(String key) {
        log.info("fetchDataFromDatabase is called");
        return "fetchedValue"; // Simulating database fetch
    }
}
