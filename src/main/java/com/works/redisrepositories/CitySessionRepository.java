package com.works.redisrepositories;

import com.works.model.CitySession;

import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;
@EnableRedisRepositories
public interface CitySessionRepository extends CrudRepository<CitySession, Integer> {

}
