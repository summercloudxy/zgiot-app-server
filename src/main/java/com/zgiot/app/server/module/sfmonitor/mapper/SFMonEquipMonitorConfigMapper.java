package com.zgiot.app.server.module.sfmonitor.mapper;

import com.zgiot.app.server.module.sfmonitor.controller.EquipmentBaseInfo;
import com.zgiot.app.server.module.sfmonitor.controller.EquipmentRelateToSignalWrapper ;
import com.zgiot.app.server.module.sfmonitor.pojo.SFMonEquipMonitorConfig;
import com.zgiot.app.server.module.sfmonitor.pojo.SignalWrapperMatchRule;
import com.zgiot.app.server.module.sfmonitor.pojo.StateControlAreaInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SFMonEquipMonitorConfigMapper {

    @Select("select * from tb_sfmon_signal_wrapper_rule where zone_code=#{zoneCode}")
    List<SignalWrapperMatchRule> getWrapperMatchRule(@Param("zoneCode") String zoneCode);

    List<EquipmentRelateToSignalWrapper> getSignalWrapperData(@Param("zoneCode") String zoneCode);

    @Select("select a.tag_name from tb_metric_tag a,rel_sfmon_tag_displayzone b,tb_sfmon_displayzone c " +
            "where c.code=#{zoneCode} and c.id=b.zone_id and b.metric_tag_code=a.code")
    String getStateControlWrapperName(@Param("zoneCode") String zoneCode);

    @Insert("insert into tb_sfmon_equipmonitor_config (thing_code,metric_tag_name,`key`,`value`,selected,model)  values(#{thingCode},#{metricTagName},#{key},#{value},#{selected},#{model})")
    void addEquipmentMonitorInfo(SFMonEquipMonitorConfig sfMonEquipMonitorConfig);

    @Select("select a.value from tb_sfmon_equipmonitor_config a,tb_sfmon_equipmonitor_info b " +
            "where b.id=#{id} and b.thing_code=a.thing_code and a.key=#{type}")
    List<String> getJumpOrParameterData(@Param("id") int id,@Param("type") String type);

    List<EquipmentRelateToSignalWrapper> getEquipmentRelateToSignalWrapperByThingCode(@Param("thingCode") String thingCode,@Param("zoneCode") String zoneCode);

    StateControlAreaInfo getParameterAreaData(@Param("thingCode") String thingCode,@Param("zoneCode") String zoneCode);

    void deleteEquipmentConfig(SFMonEquipMonitorConfig sfMonEquipMonitorConfig);

}
