package kev.spring.mybatis.generator.dao;

import kev.spring.mybatis.generator.entity.RcMod;

public interface RcModMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rc_mods
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rc_mods
     *
     * @mbg.generated
     */
    int insert(RcMod record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rc_mods
     *
     * @mbg.generated
     */
    int insertSelective(RcMod record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rc_mods
     *
     * @mbg.generated
     */
    RcMod selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rc_mods
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(RcMod record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rc_mods
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(RcMod record);
}