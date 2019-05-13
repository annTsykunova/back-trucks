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
    public CacheManager cacheManager(
//            Ticker ticker
    ) {
        CaffeineCache messageCache = buildCache("countries",
//                ticker,
                5);
//        CaffeineCache notificationCache = buildCache("notifications", ticker, 60);
        SimpleCacheManager manager = new SimpleCacheManager();
        manager.setCaches(Arrays.asList(messageCache));
        return manager;
    }

    private CaffeineCache buildCache(String name,
//                                     Ticker ticker,
                                     int secondsToExpire) {
        return new CaffeineCache(name, Caffeine.newBuilder()
                .expireAfterWrite(secondsToExpire, TimeUnit.SECONDS)
                .maximumSize(100)
//                .ticker(ticker)
                .build());
    }

//    @Bean
//    public Ticker ticker() {
//        return Ticker.systemTicker();
//    }
}

