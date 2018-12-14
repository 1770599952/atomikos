package com.atomikos.dao;

import com.atomikos.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * Test datasource
 */
@Repository
public interface TestDao {

    @Insert("INSERT INTO `users` (`username`,`password`) VALUES (#{username},#{password})")
    void insertTest(User user);
}
