package kev.spring.mybatis.generator.dao;

import kev.spring.mybatis.generator.entity.UserModValue;

public interface UserModValueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_mod_values
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_mod_values
     *
     * @mbg.generated
     */
    int insert(UserModValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_mod_values
     *
     * @mbg.generated
     */
    int insertSelective(UserModValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_mod_values
     *
     * @mbg.generated
     */
    UserModValue selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_mod_values
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserModValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_mod_values
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UserModValue record);
}