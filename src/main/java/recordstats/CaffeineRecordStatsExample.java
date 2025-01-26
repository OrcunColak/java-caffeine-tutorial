package recordstats;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;

// Caffeine provides rich metrics that you can integrate with monitoring systems like Prometheus, Micrometer, or OpenTelemetry.
@Slf4j
class CaffeineRecordStatsExample {

    public static void main() {
        Cache<String, String> cache = Caffeine.newBuilder()
                .maximumSize(100)
                .recordStats() // Enable statistics
                .build();

        // MeterRegistry registry = ...; // your app's MeterRegistry
        // registry.gauge("cache.size", cache, c -> c.estimatedSize());
        // registry.gauge("cache.hitRate", cache, c -> c.stats().hitRate());
    }
}
