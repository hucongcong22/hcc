package com.aifule.jxc.core.dao.mysql;

import com.aifule.jxc.core.domain.Odersxiang;
import com.aifule.jxc.core.mybatispage.Page;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OdersxiangMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table odersxiang
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer oderid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table odersxiang
     *
     * @mbg.generated
     */
    int insert(Odersxiang record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table odersxiang
     *
     * @mbg.generated
     */
    int insertSelective(Odersxiang record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table odersxiang
     *
     * @mbg.generated
     */
    Odersxiang selectByPrimaryKey(Integer oderid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table odersxiang
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Odersxiang record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table odersxiang
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Odersxiang record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbg.generated
     */
    List<Odersxiang> selectsBySelective(@Param("record") Odersxiang record, Page page);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appointment
     *
     * @mbg.generated
     */
    List<Odersxiang> selectsByOneKey(@Param("name") String name, @Param("value") Object value, Page page);
}