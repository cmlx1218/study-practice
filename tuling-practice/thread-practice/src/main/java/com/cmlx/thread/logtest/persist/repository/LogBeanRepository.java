package com.cmlx.thread.logtest.persist.repository;

import com.cmlx.thread.logtest.persist.entity.LogBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author CMLX
 * @Date -> 2021/5/15 15:27
 * @Desc ->
 **/
public interface LogBeanRepository extends JpaRepository<LogBean, Integer> {
}
