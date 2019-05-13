package by.baranavichy.backtrucks.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by Vanya on 13.05.2019.
 */

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCache countryCache = buildCache("countries", 20, TimeUnit.SECONDS);

        SimpleCacheManager manager = new SimpleCacheManager();
        manager.setCaches(Arrays.asList(countryCache));
        return manager;
    }

    private CaffeineCache buildCache(String name, int expireTime, TimeUnit timeUnit) {
        return new CaffeineCache(name, Caffeine.newBuilder()
                .expireAfterWrite(expireTime, timeUnit)
                .maximumSize(100)
                .build());
    }

}

