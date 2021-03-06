package com.aifule.jxc.core.dao.mysql;

import com.aifule.jxc.core.domain.Goods;
import com.aifule.jxc.core.mybatispage.Page;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer gid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated
     */
    int insert(Goods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated
     */
    int insertSelective(Goods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated
     */
    Goods selectByPrimaryKey(Integer gid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Goods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Goods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbg.generated
     */
    List<Goods> selectsBySelective(@Param("record") Goods record, Page page);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbg.generated
     */
    List<Goods> selectsByOneKey(@Param("name") String name, @Param("value") Object value, Page page);


    /**
     * @return
     */

    List<Goods> sxinshang(Page page);
}