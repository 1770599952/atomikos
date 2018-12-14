package com.atomikos.dao1;

import com.atomikos.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 *  Test1 datasource
 */
@Repository
public interface Test1Dao {

    @Insert("INSERT INTO `users` (`username`,`password`) VALUES (#{username},#{password})")
    void insertTest1(User user);
}
