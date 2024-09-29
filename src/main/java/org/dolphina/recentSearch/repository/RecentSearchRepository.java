package org.dolphina.recentSearch.repository;

import org.dolphina.recentSearch.entity.SearchHistory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecentSearchRepository {

    // redis 와 연결
    private RedisTemplate<String, String> redisTemplate;

    public RecentSearchRepository(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // lpush (limit 10)
    public void addRecentSearch(String userId, String keyword) {
        String key = "recent_search:" + userId; // recent_search:dolphin
        redisTemplate.opsForList().leftPush(key, keyword);
        redisTemplate.opsForList().trim(key, 0, 9);
    }

    // range (get 10)
    public List<String> getRecentSearch(String userId) {
        String key = "recent_search:" + userId;
        return redisTemplate.opsForList().range(key, 0, -1);
    }

}
