package com.zgiot.app.server.module.equipments.mapper;

import com.zgiot.app.server.module.equipments.pojo.RelThingSystem;
import org.apache.ibatis.annotations.*;

@Mapper
public interface RelThingSystemMapper {

    @Insert("INSERT INTO rel_thing_system(thing_code,system_id,update_time) " +
            "VALUES(#{thing_code},#{system_id},NOW())")
    void addRelThingSystem(RelThingSystem relThingSystem);

    @Delete("DELETE FROM rel_thing_system where thing_code = #{thing_code}")
    void deleteRelThingSystemByThingCode(@Param("thing_code") String thing_code);
}
