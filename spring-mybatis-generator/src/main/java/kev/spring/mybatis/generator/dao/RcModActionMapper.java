package kev.spring.mybatis.generator.dao;

import kev.spring.mybatis.generator.entity.RcModAction;

public interface RcModActionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rc_mod_actions
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rc_mod_actions
     *
     * @mbg.generated
     */
    int insert(RcModAction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rc_mod_actions
     *
     * @mbg.generated
     */
    int insertSelective(RcModAction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rc_mod_actions
     *
     * @mbg.generated
     */
    RcModAction selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rc_mod_actions
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(RcModAction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rc_mod_actions
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(RcModAction record);
}