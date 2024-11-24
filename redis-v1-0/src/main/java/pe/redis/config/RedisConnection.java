package pe.redis.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@RequiredArgsConstructor
@Configuration
@EnableCaching
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConnection {

    private final RedisProperties properties;

    @Bean
    public RedisConnectionFactory jedisConnectionFactory(){
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(properties.getHost());
        redisStandaloneConfiguration.setPassword(properties.getPassword());
        redisStandaloneConfiguration.setDatabase(properties.getDatabase());
        redisStandaloneConfiguration.setPort(properties.getPort());

        JedisClientConfiguration jedisClientConfiguration = JedisClientConfiguration.builder()
                //.useSsl()
                //.and()
                .usePooling()
                .and()
                .readTimeout(properties.getTimeout())
                .build();
        return new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
    }
}
