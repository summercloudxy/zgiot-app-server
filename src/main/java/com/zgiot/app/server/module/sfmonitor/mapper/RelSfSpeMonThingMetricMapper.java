package com.zgiot.app.server.module.sfmonitor.mapper;

import com.zgiot.app.server.module.sfmonitor.pojo.RelSfSpeMonThingMetric;
import com.zgiot.app.server.module.sfmonitor.pojo.RelSfSpeMonThingMetricExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RelSfSpeMonThingMetricMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rel_sfspemon_thing_metric
     *
     * @mbggenerated Thu Apr 26 14:58:13 CST 2018
     */
    int countByExample(RelSfSpeMonThingMetricExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rel_sfspemon_thing_metric
     *
     * @mbggenerated Thu Apr 26 14:58:13 CST 2018
     */
    int deleteByExample(RelSfSpeMonThingMetricExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rel_sfspemon_thing_metric
     *
     * @mbggenerated Thu Apr 26 14:58:13 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rel_sfspemon_thing_metric
     *
     * @mbggenerated Thu Apr 26 14:58:13 CST 2018
     */
    int insert(RelSfSpeMonThingMetric record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rel_sfspemon_thing_metric
     *
     * @mbggenerated Thu Apr 26 14:58:13 CST 2018
     */
    int insertSelective(RelSfSpeMonThingMetric record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rel_sfspemon_thing_metric
     *
     * @mbggenerated Thu Apr 26 14:58:13 CST 2018
     */
    List<RelSfSpeMonThingMetric> selectByExample(RelSfSpeMonThingMetricExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rel_sfspemon_thing_metric
     *
     * @mbggenerated Thu Apr 26 14:58:13 CST 2018
     */
    RelSfSpeMonThingMetric selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rel_sfspemon_thing_metric
     *
     * @mbggenerated Thu Apr 26 14:58:13 CST 2018
     */
    int updateByExampleSelective(@Param("record") RelSfSpeMonThingMetric record, @Param("example") RelSfSpeMonThingMetricExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rel_sfspemon_thing_metric
     *
     * @mbggenerated Thu Apr 26 14:58:13 CST 2018
     */
    int updateByExample(@Param("record") RelSfSpeMonThingMetric record, @Param("example") RelSfSpeMonThingMetricExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rel_sfspemon_thing_metric
     *
     * @mbggenerated Thu Apr 26 14:58:13 CST 2018
     */
    int updateByPrimaryKeySelective(RelSfSpeMonThingMetric record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rel_sfspemon_thing_metric
     *
     * @mbggenerated Thu Apr 26 14:58:13 CST 2018
     */
    int updateByPrimaryKey(RelSfSpeMonThingMetric record);
}