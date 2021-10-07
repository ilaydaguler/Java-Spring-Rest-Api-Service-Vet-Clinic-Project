package com.works.redisrepositories;

import com.works.model.VendorSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableRedisRepositories
public interface VendorSessionRepository extends CrudRepository<VendorSession, Integer> {
}
