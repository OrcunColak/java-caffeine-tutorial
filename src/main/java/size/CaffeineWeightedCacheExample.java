import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;


// See https://medium.com/@ishmeetsingh477/master-caffeine-javas-ultimate-caching-guide-17fb72ab0264
// Why use a weigher?
// Suppose you’re caching objects with varying memory footprints.
// A single large object might be more costly than several small ones.
// By specifying a weigher, you can fine-tune eviction policies to consider the actual resource usage rather than mere count.
public static void main() {
    LoadingCache<String, byte[]> cache = Caffeine.newBuilder()
            .maximumWeight(10_000_000)  // Max 10MB total
            .weigher((String key, byte[] value) -> value.length)
            .build(key -> loadLargeObject(key));

    // Entries with larger byte[] arrays count more against the total.
    cache.get("largeData");
}

private static byte[] loadLargeObject(String key) {
    // Pretend we’re loading a large byte array from somewhere
    return new byte[1_000_000];
}
