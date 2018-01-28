package com.su.eclient8081.dao;

import com.su.eclient8081.bean.User;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * User映射类
 *
 */
@Repository
@Mapper
public interface UserMapper
{
  @Select("SELECT * FROM T_USER WHERE PHONE=#{phone}")
  List<User> findUserByPhone(@Param("phone") String phone);

  @Insert("insert into t_user (name,password,phone)values(#{name},#{password},#{phone})")
  int insert(@Param("name")String name,@Param("password")String password,@Param("phone")String phone);
}
