package com.xuyang.wocexample.mapper;

import com.xuyang.wocexample.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * mapper的具体表达式
 */
//Dao层：负责数据持久化，与数据库进行联络的任务都封装在其中，Dao层的数据源以及相关的数据库连接参数都在Spring配置文件中进行配置。
// Dao接口中的方法都大同小异，因为对数据库的基本操作类似：insert、delete、update，select。

@Mapper//标记mapper文件位置，否则在Application.class启动类上配置mapper包扫描
@Repository
public interface UserMapper {


    /**
     * 查询用户名是否存在，若存在，不允许注册
     * 注解@Param(value) 若value与可变参数相同，注解可省略
     * 注解@Results  列名和字段名相同，注解可省略
     * @param username
     * @return
     */
    //查询数据库中用户名是否存在,返回User对象
    @Select(value = "select u.username,u.password from user u where u.username=#{username}")
    @Results
            ({@Result(property = "username",column = "username"),
                    @Result(property = "password",column = "password")})
    User findUserByName(@Param("username") String username);

    /**
     * 注册  插入一条user记录
     * @param user
     * @return
     */
    //向数据库插入一条信息，void方法
    @Insert("insert into user values(#{id},#{username},#{password})")
    //加入该注解可以保存对象后，查看对象插入id
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void regist(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    //返回非0值
    @Select("select u.id from user u where u.username = #{username} and password = #{password}")
    Long login(User user);

    //获得全部账户的数量
    @Select("select count(*) from user")
    public int getuserCount();

    //查询数据库中用户名是否存在,返回User对象
    @Delete("delete from user u where u.username = #{username}")
    void delete(User user);
}
