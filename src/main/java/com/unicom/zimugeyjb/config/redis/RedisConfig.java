package com.unicom.zimugeyjb.config.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
@Data
@Component
@ConfigurationProperties(prefix = "caching")
public class RedisConfig {

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        //重点在这四行代码
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }


//    //本节的重点配置，让缓存的序列化方式使用redisTemplate.getValueSerializer()
//    @Bean
//    public RedisCacheManager redisCacheManager(RedisTemplate redisTemplate) {
//        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisTemplate.getConnectionFactory());
//        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisTemplate.getValueSerializer()));
//        return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
//    }


    /** 自定义redisCacheManager  可以自定义缓存时间  上面的方法不行    */
    @Bean
    public RedisCacheManager redisCacheManager(RedisTemplate redisTemplate) {
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisTemplate.getConnectionFactory());

        RedisCacheManager redisCacheManager = new RedisCacheManager(redisCacheWriter,
                /** 默认的redis缓存配置 */
                this.buildRedisCacheConfigurationWithTTL(redisTemplate,RedisCacheConfiguration.defaultCacheConfig().getTtl().getSeconds()),
                //针对每一个cache做个性化缓存配置
                this.getRedisCacheConfigurationMap(redisTemplate));

        return  redisCacheManager;
    }

    /** 配置注入，key是缓存名称，value是缓存有效期   读取yml配置文件中的缓存有效时间 */
    private Map<String,Long> ttlmap;

    /** 根据ttlmap的属性装配结果，个性化RedisCacheConfiguration     个性化的配置cache失效时间  */
    private Map<String, RedisCacheConfiguration> getRedisCacheConfigurationMap(RedisTemplate redisTemplate) {
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();

        for(Map.Entry<String, Long> entry : ttlmap.entrySet()){
            String cacheName = entry.getKey();
            Long ttl = entry.getValue();
            redisCacheConfigurationMap.put(cacheName,this.buildRedisCacheConfigurationWithTTL(redisTemplate,ttl));
        }

        return redisCacheConfigurationMap;
    }


    /** 让缓存的序列化方式使用redisTemplate.getValueSerializer()，并未每一个缓存分别设置ttl  */
    private RedisCacheConfiguration buildRedisCacheConfigurationWithTTL(RedisTemplate redisTemplate,Long ttl){
        return  RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisTemplate.getValueSerializer()))
                .entryTtl(Duration.ofSeconds(ttl));
    }



}