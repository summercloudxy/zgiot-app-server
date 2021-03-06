package com.zgiot.app.server.module.equipments.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zgiot.app.server.module.equipments.constants.EquipmentConstant;
import com.zgiot.app.server.module.equipments.mapper.*;
import com.zgiot.app.server.module.equipments.controller.*;
import com.zgiot.app.server.module.equipments.pojo.*;
import com.zgiot.app.server.module.equipments.service.ThingManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.zgiot.app.server.module.equipments.constants.EquipmentConstant.*;


@Service
public class ThingManagementServiceImpl implements ThingManagementService {

    @Autowired
    private ThingManagementMapper thingMapper;
    @Autowired
    private ThingTagManagementMapper thingTagManagementMapper;
    @Autowired
    private ThingPositionMapper thingPositionMapper;
    @Autowired
    private ThingPropertiesMapper thingPropertiesMapper;
    @Autowired
    private RelThingtagThingMapper relThingtagThingMapper;
    @Autowired
    private RelThingSystemMapper relThingSystemMapper;

    /**
     * 根据RelThingtagThing获取thingCode
     *
     * @param relThingtagThingList
     * @return
     */
    public List<String> getThingCodeListByRelThingtagThing(List<RelThingtagThing> relThingtagThingList) {
        List<String> thingCodeList = null;
        if (relThingtagThingList != null && relThingtagThingList.size() > 0) {
            thingCodeList = new ArrayList<>();
            for (int i = 0; i < relThingtagThingList.size(); i++) {
                thingCodeList.add(relThingtagThingList.get(i).getThingCode());
            }
        }
        return thingCodeList;
    }

    public PageHelpInfo getDeviceInfoByThingCode(List<String> thingCodeList, int pageNum, int pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<DeviceInfo> deviceInfoList = new ArrayList<>();
        if (thingCodeList != null && thingCodeList.size() > 0) {
            deviceInfoList = thingMapper.getDeviceInfoByThingcode(thingCodeList);
            List<ThingProperties> thingPropertiesList = thingPropertiesMapper.getThingPropertiesByThingCode(thingCodeList);
            if (deviceInfoList != null && deviceInfoList.size() > 0) {
                for (int i = 0; i < deviceInfoList.size(); i++) {
                    for (int j = 0; j < thingPropertiesList.size(); j++) {
                        if (deviceInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(ENABLE_DATE)) {
                            deviceInfoList.get(i).setEnableDate(thingPropertiesList.get(j).getPropValue());
                        }
                        if (deviceInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(DISABLE_DATE)) {
                            deviceInfoList.get(i).setDisableDate(thingPropertiesList.get(j).getPropValue());
                        }
                        if (deviceInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(SPECIFICATION)) {
                            deviceInfoList.get(i).setSpecification(thingPropertiesList.get(j).getPropValue());
                        }
                        if (deviceInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(MANUFACTURER)) {
                            deviceInfoList.get(i).setManufacturer(thingPropertiesList.get(j).getPropValue());
                        }
                        if (deviceInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(POWER_PROPERTIES)) {
                            deviceInfoList.get(i).setPowerProperties(thingPropertiesList.get(j).getPropValue());
                        }
                        if (deviceInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(ANGLE)) {
                            deviceInfoList.get(i).setAngle(thingPropertiesList.get(j).getPropValue());
                        }
                        if (deviceInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(GRANULARITY)) {
                            deviceInfoList.get(i).setGranularity(thingPropertiesList.get(j).getPropValue());
                        }
                        if (deviceInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(IMAGE_NAME)) {
                            deviceInfoList.get(i).setImageName(thingPropertiesList.get(j).getPropValue());
                        }
                    }
                }
            }
        }

        PageHelpInfo pageHelpInfo = new PageHelpInfo();
        pageHelpInfo.setList(deviceInfoList);
        pageHelpInfo.setSum(page.getTotal());
        return pageHelpInfo;
    }

    public PageHelpInfo getPartsInfoByThingCode(List<String> thingCodeList, int pageNum, int pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<PartsInfo> partsInfoList = new ArrayList<>();
        if (thingCodeList != null && thingCodeList.size() > 0) {
            partsInfoList = thingMapper.getPartsInfoByThingcode(thingCodeList);
            List<ThingProperties> thingPropertiesList = thingPropertiesMapper.getThingPropertiesByThingCode(thingCodeList);
            if (partsInfoList != null && partsInfoList.size() > 0) {
                for (int i = 0; i < partsInfoList.size(); i++) {
                    for (int j = 0; j < thingPropertiesList.size(); j++) {
                        if (partsInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(PARENT_THING_CODE)) {
                            partsInfoList.get(i).setParentThingCode(thingPropertiesList.get(j).getPropValue());
                        }
                        if (partsInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(PARENT_THING_NAME)) {
                            partsInfoList.get(i).setParentThingName(thingPropertiesList.get(j).getPropValue());
                        }
                        if (partsInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(ENABLE_DATE)) {
                            partsInfoList.get(i).setEnableDate(thingPropertiesList.get(j).getPropValue());
                        }
                        if (partsInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(DISABLE_DATE)) {
                            partsInfoList.get(i).setDisableDate(thingPropertiesList.get(j).getPropValue());
                        }
                        if (partsInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(SPECIFICATION)) {
                            partsInfoList.get(i).setSpecification(thingPropertiesList.get(j).getPropValue());
                        }
                        if (partsInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(MANUFACTURER)) {
                            partsInfoList.get(i).setManufacturer(thingPropertiesList.get(j).getPropValue());
                        }
                        if (partsInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(THING_TYPE)) {
                            partsInfoList.get(i).setThingType(thingPropertiesList.get(j).getPropValue());
                        }
                        if (partsInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(COMPONENT_TYPE_CODE_RULE)) {
                            partsInfoList.get(i).setThingTypeName(thingPropertiesList.get(j).getPropValue());
                        }
                        if (partsInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(START_TYPE)) {
                            partsInfoList.get(i).setStartType(thingPropertiesList.get(j).getPropValue());
                        }
                        if (partsInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(RATED_POWER)) {
                            partsInfoList.get(i).setRatedPower(thingPropertiesList.get(j).getPropValue());
                        }
                        if (partsInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(VOLTAGE_LEVEL)) {
                            partsInfoList.get(i).setVoltageLevel(thingPropertiesList.get(j).getPropValue());
                        }
                        if (partsInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(EXPLOSION_PROOF)) {
                            partsInfoList.get(i).setExplosionProof(thingPropertiesList.get(j).getPropValue());
                        }
                        if (partsInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(Grade)) {
                            partsInfoList.get(i).setGrade(thingPropertiesList.get(j).getPropValue());
                        }
                        if (partsInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(INSULATION_GRADE)) {
                            partsInfoList.get(i).setInsulationGrade(thingPropertiesList.get(j).getPropValue());
                        }
                        if (partsInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(PROTECTION_GRADE)) {
                            partsInfoList.get(i).setProtectionGrade(thingPropertiesList.get(j).getPropValue());
                        }
                        if (partsInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(RATED_CURRENT)) {
                            partsInfoList.get(i).setRatedCurrent(thingPropertiesList.get(j).getPropValue());
                        }
                    }
                }
            }
        }

        PageHelpInfo pageHelpInfo = new PageHelpInfo();
        pageHelpInfo.setList(partsInfoList);
        pageHelpInfo.setSum(page.getTotal());
        return pageHelpInfo;
    }

    /**
     * 设备信息列表
     *
     * @param id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageHelpInfo getAllDeviceInfo(Long id, int pageNum, int pageSize) {
        List<RelThingtagThing> relThingtagThingList = relThingtagThingMapper.getRelThingtagThingByTwoLevelId(id);
        List<String> thingCodeList = getThingCodeListByRelThingtagThing(relThingtagThingList);
        PageHelpInfo pageHelpInfo = getDeviceInfoByThingCode(thingCodeList, pageNum, pageSize);
        return pageHelpInfo;
    }

    /**
     * 设备信息列表
     *
     * @param id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageHelpInfo getDeviceInfoByThingTagId(Long id, int pageNum, int pageSize) {
        List<RelThingtagThing> relThingtagThingList = relThingtagThingMapper.getRelThingtagThingByThreeLevelId(id);
        List<String> thingCodeList = getThingCodeListByRelThingtagThing(relThingtagThingList);
        PageHelpInfo pageHelpInfo = getDeviceInfoByThingCode(thingCodeList, pageNum, pageSize);
        return pageHelpInfo;
    }

    /**
     * 部件信息列表
     *
     * @param id
     * @return
     */
    @Override
    public PageHelpInfo getPartsInfoByThingTagId(Long id, int pageNum, int pageSize) {
        List<RelThingtagThing> relThingtagThingList = relThingtagThingMapper.getRelThingtagThingByThingTagCode(id);
        List<String> thingCodeList = getThingCodeListByRelThingtagThing(relThingtagThingList);
        PageHelpInfo pageHelpInfo = getPartsInfoByThingCode(thingCodeList, pageNum, pageSize);
        return pageHelpInfo;
    }

    @Override
    public List<Thing> getThingByCode(String thingCode, String thingType1Code) {
        thingCode = "%" + thingCode + "%";
        return thingMapper.getThingByCode(thingCode, thingType1Code);
    }

    @Override
    public boolean getThingByThingCode(String thingCode) {
        List<Thing> thingList = thingMapper.getThingByThingCode(thingCode);
        return thingList != null && thingList.size() > 0;
    }

    @Transactional
    public void addDevice(DeviceInfo deviceInfo) {
        // thing
        Thing thing = new Thing();
        thing.setThingCode(deviceInfo.getThingCode());
        thing.setThingName(deviceInfo.getThingName());
        thing.setThingType1Code(EquipmentConstant.THING_TYPE1_CODE_DEVICE);
        thing.setThingShortName(deviceInfo.getThingShortname());
        thingMapper.addThing(thing);

        // thingPosition
        ThingPosition thingPosition = new ThingPosition();
        thingPosition.setThingCode(deviceInfo.getThingCode());
        thingPosition.setBuildingId(Long.parseLong(deviceInfo.getBuildingId().toString()));
        thingPosition.setFloor(Integer.parseInt(deviceInfo.getFloor().toString()));
        thingPosition.setLocationArea(deviceInfo.getLocationArea().toString());
        Double locationX = null;
        if (deviceInfo.getLocationX() != null && !"".equals(deviceInfo.getLocationX())) {
            locationX = Double.parseDouble(deviceInfo.getLocationX());
        }
        thingPosition.setLocationX(locationX);
        Double locationY = null;
        if (deviceInfo.getLocationY() != null && !"".equals(deviceInfo.getLocationY())) {
            locationY = Double.parseDouble(deviceInfo.getLocationY());
        }
        thingPosition.setLocationY(locationY);
        thingPositionMapper.addThingPosition(thingPosition);

        // relThingtagThing
        RelThingtagThing relThingtagThing = new RelThingtagThing();
        relThingtagThing.setThingCode(deviceInfo.getThingCode());
        relThingtagThing.setThingTagCode(deviceInfo.getThingTagCode());
        relThingtagThing.setCreateDate(new Date());
        relThingtagThingMapper.addRelThingtagThing(relThingtagThing);

        // relThingSystem
        RelThingSystem relThingSystem = new RelThingSystem();
        relThingSystem.setSystemId(Long.parseLong(deviceInfo.getSystemId().toString()));
        relThingSystem.setThingCode(deviceInfo.getThingCode());
        relThingSystem.setUpdateTime(new Date());
        relThingSystemMapper.addRelThingSystem(relThingSystem);

        // thingProperties
        ThingProperties tp = new ThingProperties();
        tp.setThingCode(deviceInfo.getThingCode());
        tp.setPropKey(EquipmentConstant.SPECIFICATION);
        tp.setPropValue(deviceInfo.getSpecification());
        tp.setPropType(EquipmentConstant.PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(EquipmentConstant.MANUFACTURER);
        tp.setPropValue(deviceInfo.getManufacturer());
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(EquipmentConstant.POWER_PROPERTIES);
        tp.setPropValue(deviceInfo.getPowerProperties());
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(EquipmentConstant.ENABLE_DATE);
        tp.setPropValue(deviceInfo.getEnableDate());
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(EquipmentConstant.DISABLE_DATE);
        tp.setPropValue(deviceInfo.getDisableDate());
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(EquipmentConstant.ANGLE);
        tp.setPropValue(deviceInfo.getAngle());
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(EquipmentConstant.GRANULARITY);
        tp.setPropValue(deviceInfo.getGranularity());
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(EquipmentConstant.IMAGE_NAME);
        tp.setPropValue(deviceInfo.getImageName());
        tp.setPropType(EquipmentConstant.PROP_TYPE_DISP_PROP);
        thingPropertiesMapper.addThingProperties(tp);

    }

    @Transactional
    public void deleteDevice(Long id) {
        Thing thing = thingMapper.getThingById(id);
        String thingCode = thing.getThingCode();
        // thing
        thingMapper.deleteThingById(id);

        // thingPosition
        thingPositionMapper.deleteThingPosition(thingCode);

        // relThingtagThing
        relThingtagThingMapper.deleteRelThingtagThingByThingCode(thingCode);

        // relThingSystem
        relThingSystemMapper.deleteRelThingSystemByThingCode(thingCode);

        // thingProperties
        thingPropertiesMapper.deleteThingPropertiesByThingCode(thingCode);

    }

    @Transactional
    public void editDevice(DeviceInfo deviceInfo) {
        deleteDevice(deviceInfo.getId());
        addDevice(deviceInfo);
    }

    @Transactional
    public void addChute(ChuteInfo chuteInfo) {

        String parentThingCode = chuteInfo.getStartThingCode() + "-" + chuteInfo.getTerminalThingCode();
        String thingType = "." + LC + "-";
        String thingCode = getThingCodeByInfo(parentThingCode, thingType, THING_TYPE1_CODE_CHUTE);
        //插入tb_thing表
        Thing thing = new Thing();
        thing.setThingCode(thingCode);
        thing.setThingName(chuteInfo.getThingName());
        thing.setThingType1Code(THING_TYPE1_CODE_CHUTE);
        thingMapper.addThing(thing);

        //插入tb_thing_properties表
        ThingProperties tp1 = new ThingProperties();
        tp1.setThingCode(thingCode);
        tp1.setPropKey(START_THING_CODE);
        tp1.setPropValue(chuteInfo.getStartThingCode());
        tp1.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp1);

        ThingProperties tp2 = new ThingProperties();
        tp2.setThingCode(thingCode);
        tp2.setPropKey(START_THING_NAME);
        tp2.setPropValue(chuteInfo.getStartThingName());
        tp2.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp2);

        ThingProperties tp3 = new ThingProperties();
        tp3.setThingCode(thingCode);
        tp3.setPropKey(TERMINAL_THING_CODE);
        tp3.setPropValue(chuteInfo.getTerminalThingCode());
        tp3.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp3);

        ThingProperties tp4 = new ThingProperties();
        tp4.setThingCode(thingCode);
        tp4.setPropKey(TERMINAL_THING_NAME);
        tp4.setPropValue(chuteInfo.getTerminalThingName());
        tp4.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp4);

        ThingProperties tp5 = new ThingProperties();
        tp5.setThingCode(thingCode);
        tp5.setPropKey(ENABLE_DATE);
        tp5.setPropValue(chuteInfo.getEnableDate());
        tp5.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp5);

        ThingProperties tp6 = new ThingProperties();
        tp6.setThingCode(thingCode);
        tp6.setPropKey(DISABLE_DATE);
        tp6.setPropValue(chuteInfo.getDisableDate());
        tp6.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp6);

        //插入rel_thing_system表
        RelThingSystem rts = new RelThingSystem();
        rts.setThingCode(thingCode);
        rts.setSystemId(chuteInfo.getThingSystemId());
        relThingSystemMapper.addRelThingSystem(rts);

        // relThingtagThing
        RelThingtagThing relThingtagThing = new RelThingtagThing();
        relThingtagThing.setThingCode(thingCode);
        relThingtagThing.setThingTagCode(chuteInfo.getThingTagCode());
        relThingtagThing.setCreateDate(new Date());
        relThingtagThingMapper.addRelThingtagThing(relThingtagThing);

    }

    /**
     * 删除，溜槽和管道可共用此方法
     *
     * @param id
     */
    @Transactional
    public void delChuteOrPipe(Long id) {
        Thing t = thingMapper.getThingById(id);
        if (null != t) {
            String thingCode = t.getThingCode();
            thingMapper.deleteThingById(id);
            thingPropertiesMapper.deleteThingPropertiesByThingCode(thingCode);
            relThingSystemMapper.deleteRelThingSystemByThingCode(thingCode);
            relThingtagThingMapper.deleteRelThingtagThingByThingCode(thingCode);
        }
    }

    @Transactional
    public void editChute(ChuteInfo chuteInfo) {
        Long id = chuteInfo.getId();
        delChuteOrPipe(id);
        addChute(chuteInfo);
    }

    @Transactional
    public void addParts(PartsInfo partsInfo) {
        // thing
        Thing thing = new Thing();
        String thingCode = getThingCodeByInfo(partsInfo.getParentThingCode(), partsInfo.getThingType(),
                EquipmentConstant.THING_TYPE1_CODE_PARTS);
        thing.setThingCode(thingCode);
        thing.setThingName(partsInfo.getThingName());
        thing.setThingType1Code(EquipmentConstant.THING_TYPE1_CODE_PARTS);
        thingMapper.addThing(thing);

        // relThingtagThing
        RelThingtagThing relThingtagThing = new RelThingtagThing();
        relThingtagThing.setThingCode(thingCode);
        relThingtagThing.setThingTagCode(partsInfo.getThingTagCode());
        relThingtagThing.setCreateDate(new Date());
        relThingtagThingMapper.addRelThingtagThing(relThingtagThing);

        // thingProperties
        ThingProperties tp = new ThingProperties();
        tp.setThingCode(thingCode);
        tp.setPropKey(EquipmentConstant.SPECIFICATION);
        tp.setPropValue(partsInfo.getSpecification());
        tp.setPropType(EquipmentConstant.PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(EquipmentConstant.MANUFACTURER);
        tp.setPropValue(partsInfo.getManufacturer());
        tp.setPropType(EquipmentConstant.PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(EquipmentConstant.THING_TYPE);
        tp.setPropValue(partsInfo.getThingType());
        tp.setPropType(EquipmentConstant.PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(EquipmentConstant.COMPONENT_TYPE_CODE_RULE);
        tp.setPropValue(partsInfo.getThingTypeName());
        tp.setPropType(EquipmentConstant.PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(EquipmentConstant.PARENT_THING_CODE);
        tp.setPropValue(partsInfo.getParentThingCode());
        tp.setPropType(EquipmentConstant.PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(EquipmentConstant.PARENT_THING_NAME);
        tp.setPropValue(partsInfo.getParentThingName());
        tp.setPropType(EquipmentConstant.PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(EquipmentConstant.ENABLE_DATE);
        tp.setPropValue(partsInfo.getEnableDate());
        tp.setPropType(EquipmentConstant.PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(EquipmentConstant.DISABLE_DATE);
        tp.setPropValue(partsInfo.getDisableDate());
        tp.setPropType(EquipmentConstant.PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(EquipmentConstant.START_TYPE);
        tp.setPropValue(partsInfo.getStartType());
        tp.setPropType(EquipmentConstant.PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(EquipmentConstant.RATED_POWER);
        tp.setPropValue(partsInfo.getRatedPower());
        tp.setPropType(EquipmentConstant.PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(EquipmentConstant.VOLTAGE_LEVEL);
        tp.setPropValue(partsInfo.getVoltageLevel());
        tp.setPropType(EquipmentConstant.PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(EquipmentConstant.EXPLOSION_PROOF);
        tp.setPropValue(partsInfo.getExplosionProof());
        tp.setPropType(EquipmentConstant.PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(EquipmentConstant.Grade);
        tp.setPropValue(partsInfo.getGrade());
        tp.setPropType(EquipmentConstant.PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(EquipmentConstant.INSULATION_GRADE);
        tp.setPropValue(partsInfo.getInsulationGrade());
        tp.setPropType(EquipmentConstant.PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(EquipmentConstant.PROTECTION_GRADE);
        tp.setPropValue(partsInfo.getProtectionGrade());
        tp.setPropType(EquipmentConstant.PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(EquipmentConstant.RATED_CURRENT);
        tp.setPropValue(partsInfo.getRatedCurrent());
        tp.setPropType(EquipmentConstant.PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);
    }

    @Transactional
    public void deleteParts(Long id) {
        Thing thing = thingMapper.getThingById(id);
        String thingCode = thing.getThingCode();
        // thing
        thingMapper.deleteThingById(id);

        // relThingtagThing
        relThingtagThingMapper.deleteRelThingtagThingByThingCode(thingCode);

        // thingProperties
        thingPropertiesMapper.deleteThingPropertiesByThingCode(thingCode);

    }

    @Transactional
    public void editParts(PartsInfo partsInfo) {
        deleteParts(partsInfo.getId());
        addParts(partsInfo);
    }

    /**
     * 获取该设备的thingCode
     *
     * @param parentThingCode     701
     * @param thingType           .BJ.BS-
     * @param thingType1CodeParts PARTS
     * @return
     */
    private String getThingCodeByInfo(String parentThingCode, String thingType, String thingType1CodeParts) {
        String thingCode = "";
        String likeThingCode = parentThingCode + thingType + "%";
        List<Thing> thingList = thingMapper.getThingByType(likeThingCode, thingType1CodeParts);
        if (thingList != null && thingList.size() > 0) {
            Collections.sort(thingList, new Comparator<Thing>() {
                @Override
                public int compare(Thing o1, Thing o2) {
                    Integer code1 = Integer.parseInt(o1.getThingCode().substring(o1.getThingCode().lastIndexOf("-") + 1));
                    Integer code2 = Integer.parseInt(o2.getThingCode().substring(o2.getThingCode().lastIndexOf("-") + 1));
                    return code2 - code1;
                }
            });

            Thing thing = thingList.get(0);
            thingCode = new Integer(Integer.parseInt(thing.getThingCode()
                    .substring(thing.getThingCode().lastIndexOf("-") + 1)) + 1).toString();
            thingCode = parentThingCode + thingType + thingCode;
        } else {
            thingCode = parentThingCode + thingType + 1;
        }
        return thingCode;
    }

    /*3.30 begin*/

    //管道
    @Transactional
    public void addPipe(PipeInfo pipeInfo) {

        String parentThingCode = pipeInfo.getStartThingCode() + "-" + pipeInfo.getTerminalThingCode();
        String thingType = "." + GD + "-";
        String thingCode = getThingCodeByInfo(parentThingCode, thingType, THING_TYPE1_CODE_PIPE);
        //插入tb_thing表
        Thing thing = new Thing();
        thing.setThingCode(thingCode);
        thing.setThingName(pipeInfo.getThingName());
        thing.setThingType1Code(THING_TYPE1_CODE_PIPE);
        thingMapper.addThing(thing);

        //插入tb_thing_properties表
        ThingProperties tp1 = new ThingProperties();
        tp1.setThingCode(thingCode);
        tp1.setPropKey(START_THING_CODE);
        tp1.setPropValue(pipeInfo.getStartThingCode());
        tp1.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp1);

        ThingProperties tp2 = new ThingProperties();
        tp2.setThingCode(thingCode);
        tp2.setPropKey(START_THING_NAME);
        tp2.setPropValue(pipeInfo.getStartThingName());
        tp2.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp2);

        ThingProperties tp3 = new ThingProperties();
        tp3.setThingCode(thingCode);
        tp3.setPropKey(TERMINAL_THING_CODE);
        tp3.setPropValue(pipeInfo.getTerminalThingCode());
        tp3.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp3);

        ThingProperties tp4 = new ThingProperties();
        tp4.setThingCode(thingCode);
        tp4.setPropKey(TERMINAL_THING_NAME);
        tp4.setPropValue(pipeInfo.getTerminalThingName());
        tp4.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp4);

        ThingProperties tp5 = new ThingProperties();
        tp5.setThingCode(thingCode);
        tp5.setPropKey(ENABLE_DATE);
        tp5.setPropValue(pipeInfo.getEnableDate());
        tp5.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp5);

        ThingProperties tp6 = new ThingProperties();
        tp6.setThingCode(thingCode);
        tp6.setPropKey(DISABLE_DATE);
        tp6.setPropValue(pipeInfo.getDisableDate());
        tp6.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp6);

        ThingProperties tp7 = new ThingProperties();
        tp7.setThingCode(thingCode);
        tp7.setPropKey(MANUFACTURER);
        tp7.setPropValue(pipeInfo.getManufacturer());
        tp7.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp7);

        ThingProperties tp8 = new ThingProperties();
        tp8.setThingCode(thingCode);
        tp8.setPropKey(NOMINAL_DIAMETER);
        tp8.setPropValue(pipeInfo.getNominalDiameter());
        tp8.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp8);

        //插入rel_thing_system表
        RelThingSystem rts = new RelThingSystem();
        rts.setThingCode(thingCode);
        rts.setSystemId(pipeInfo.getThingSystemId());
        relThingSystemMapper.addRelThingSystem(rts);

        // relThingtagThing
        RelThingtagThing relThingtagThing = new RelThingtagThing();
        relThingtagThing.setThingCode(thingCode);
        relThingtagThing.setThingTagCode(pipeInfo.getThingTagCode());
        relThingtagThing.setCreateDate(new Date());
        relThingtagThingMapper.addRelThingtagThing(relThingtagThing);

    }

    @Transactional
    public void editPipe(PipeInfo pipeInfo) {
        Long id = pipeInfo.getId();
        delChuteOrPipe(id);
        addPipe(pipeInfo);
    }

    //闸板
    @Transactional
    public void addFlashboard(FlashboardInfo flashboardInfo) {

        String parentThingCode = flashboardInfo.getParentThingCode();
        String thingType = "." + ZB + "-";
        String thingCode = getThingCodeByInfo(parentThingCode, thingType, THING_TYPE1_CODE_FLASHBOARD);
        //插入tb_thing表
        Thing thing = new Thing();
        thing.setThingCode(thingCode);
        thing.setThingName(flashboardInfo.getThingName());
        thing.setThingType1Code(THING_TYPE1_CODE_FLASHBOARD);
        thingMapper.addThing(thing);

        //插入tb_thing_properties表
        ThingProperties tp1 = new ThingProperties();
        tp1.setThingCode(thingCode);
        tp1.setPropKey(SUBJECT_TYPE);
        tp1.setPropValue(flashboardInfo.getSubjectType());
        tp1.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp1);

        ThingProperties tp2 = new ThingProperties();
        tp2.setThingCode(thingCode);
        tp2.setPropKey(PARENT_THING_CODE);
        tp2.setPropValue(flashboardInfo.getParentThingCode());
        tp2.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp2);

        ThingProperties tp3 = new ThingProperties();
        tp3.setThingCode(thingCode);
        tp3.setPropKey(PARENT_THING_NAME);
        tp3.setPropValue(flashboardInfo.getParentThingName());
        tp3.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp3);

        ThingProperties tp4 = new ThingProperties();
        tp4.setThingCode(thingCode);
        tp4.setPropKey(FLASHBOARD_TYPE);
        tp4.setPropValue(flashboardInfo.getFlashboardType());
        tp4.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp4);

        ThingProperties tp5 = new ThingProperties();
        tp5.setThingCode(thingCode);
        tp5.setPropKey(MANUFACTURER);
        tp5.setPropValue(flashboardInfo.getManufacturer());
        tp5.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp5);

        ThingProperties tp6 = new ThingProperties();
        tp6.setThingCode(thingCode);
        tp6.setPropKey(ENABLE_DATE);
        tp6.setPropValue(flashboardInfo.getEnableDate());
        tp6.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp6);

        ThingProperties tp7 = new ThingProperties();
        tp7.setThingCode(thingCode);
        tp7.setPropKey(DISABLE_DATE);
        tp7.setPropValue(flashboardInfo.getDisableDate());
        tp7.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp7);

        ThingProperties tp8 = new ThingProperties();
        tp8.setThingCode(thingCode);
        tp8.setPropKey(FLASHBOARD_EXECUTION_MODE);
        tp8.setPropValue(flashboardInfo.getFlashboardExecutionMode());
        tp8.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp8);

        ThingProperties tp9 = new ThingProperties();
        tp9.setThingCode(thingCode);
        tp9.setPropKey(FLASHBOARD_CONTROL_MODE);
        tp9.setPropValue(flashboardInfo.getFlashboardControlMode());
        tp9.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp9);

        // 插入thingPosition表
        ThingPosition thingPosition = new ThingPosition();
        thingPosition.setThingCode(thingCode);
        thingPosition.setBuildingId(flashboardInfo.getBuildingId());
        thingPosition.setFloor(flashboardInfo.getFloor());

        thingPositionMapper.addThingPosition(thingPosition);

        // relThingtagThing
        RelThingtagThing relThingtagThing = new RelThingtagThing();
        relThingtagThing.setThingCode(thingCode);
        relThingtagThing.setThingTagCode(flashboardInfo.getThingTagCode());
        relThingtagThing.setCreateDate(new Date());
        relThingtagThingMapper.addRelThingtagThing(relThingtagThing);

    }

    @Transactional
    public void delFlashboardOrValve(Long id) {
        Thing t = thingMapper.getThingById(id);
        if (null != t) {
            String thingCode = t.getThingCode();
            thingMapper.deleteThingById(id);
            thingPropertiesMapper.deleteThingPropertiesByThingCode(thingCode);
            thingPositionMapper.deleteThingPosition(thingCode);
            relThingtagThingMapper.deleteRelThingtagThingByThingCode(thingCode);
        }
    }

    @Transactional
    public void editFlashboard(FlashboardInfo flashboardInfo) {
        Long id = flashboardInfo.getId();
        delFlashboardOrValve(id);
        addFlashboard(flashboardInfo);
    }


    //阀门
    @Transactional
    public void addValve(ValveInfo valveInfo) {

        String parentThingCode = valveInfo.getParentThingCode();
        String thingType = "." + FM + "-";
        String thingCode = getThingCodeByInfo(parentThingCode, thingType, THING_TYPE1_CODE_VALVE);
        //插入tb_thing表
        Thing thing = new Thing();
        thing.setThingCode(thingCode);
        thing.setThingName(valveInfo.getThingName());
        thing.setThingType1Code(THING_TYPE1_CODE_VALVE);
        thingMapper.addThing(thing);

        //插入tb_thing_properties表
        ThingProperties tp1 = new ThingProperties();
        tp1.setThingCode(thingCode);
        tp1.setPropKey(SUBJECT_TYPE);
        tp1.setPropValue(valveInfo.getSubjectType());
        tp1.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp1);

        ThingProperties tp2 = new ThingProperties();
        tp2.setThingCode(thingCode);
        tp2.setPropKey(PARENT_THING_CODE);
        tp2.setPropValue(valveInfo.getParentThingCode());
        tp2.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp2);

        ThingProperties tp3 = new ThingProperties();
        tp3.setThingCode(thingCode);
        tp3.setPropKey(PARENT_THING_NAME);
        tp3.setPropValue(valveInfo.getParentThingName());
        tp3.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp3);

        ThingProperties tp4 = new ThingProperties();
        tp4.setThingCode(thingCode);
        tp4.setPropKey(VALVE_TYPE);
        tp4.setPropValue(valveInfo.getValveType());
        tp4.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp4);

        ThingProperties tp5 = new ThingProperties();
        tp5.setThingCode(thingCode);
        tp5.setPropKey(MANUFACTURER);
        tp5.setPropValue(valveInfo.getManufacturer());
        tp5.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp5);

        ThingProperties tp6 = new ThingProperties();
        tp6.setThingCode(thingCode);
        tp6.setPropKey(ENABLE_DATE);
        tp6.setPropValue(valveInfo.getEnableDate());
        tp6.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp6);

        ThingProperties tp7 = new ThingProperties();
        tp7.setThingCode(thingCode);
        tp7.setPropKey(DISABLE_DATE);
        tp7.setPropValue(valveInfo.getDisableDate());
        tp7.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp7);

        ThingProperties tp8 = new ThingProperties();
        tp8.setThingCode(thingCode);
        tp8.setPropKey(VALVE_EXECUTION_MODE);
        tp8.setPropValue(valveInfo.getValveExecutionMode());
        tp8.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp8);

        ThingProperties tp9 = new ThingProperties();
        tp9.setThingCode(thingCode);
        tp9.setPropKey(VALVE_CONTROL_MODE);
        tp9.setPropValue(valveInfo.getValveControlMode());
        tp9.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp9);

        ThingProperties tp10 = new ThingProperties();
        tp10.setThingCode(thingCode);
        tp10.setPropKey(VALVE_PURPOSE);
        tp10.setPropValue(valveInfo.getValvePurpose());
        tp10.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp10);

        ThingProperties tp11 = new ThingProperties();
        tp11.setThingCode(thingCode);
        tp11.setPropKey(NOMINAL_DIAMETER);
        tp11.setPropValue(valveInfo.getNominalDiameter());
        tp11.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp11);

        ThingProperties tp12 = new ThingProperties();
        tp12.setThingCode(thingCode);
        tp12.setPropKey(SPECIFICATION);
        tp12.setPropValue(valveInfo.getSpecification());
        tp12.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp12);

        // 插入thingPosition表
        ThingPosition thingPosition = new ThingPosition();
        thingPosition.setThingCode(thingCode);
        thingPosition.setBuildingId(valveInfo.getBuildingId());
        thingPosition.setFloor(valveInfo.getFloor());

        thingPositionMapper.addThingPosition(thingPosition);

        // relThingtagThing
        RelThingtagThing relThingtagThing = new RelThingtagThing();
        relThingtagThing.setThingCode(thingCode);
        relThingtagThing.setThingTagCode(valveInfo.getThingTagCode());
        relThingtagThing.setCreateDate(new Date());
        relThingtagThingMapper.addRelThingtagThing(relThingtagThing);

    }


    @Transactional
    public void editValve(ValveInfo valveInfo) {
        Long id = valveInfo.getId();
        delFlashboardOrValve(id);
        addValve(valveInfo);
    }

    /*3.30 end*/

    @Override
    public PageHelpInfo getPipeInfoByThingTagId(Long id, int pageNum, int pageSize) {
        List<RelThingtagThing> relThingtagThingList = relThingtagThingMapper.getRelThingtagThingByThingTagCode(id);
        List<String> thingCodeList = getThingCodeListByRelThingtagThing(relThingtagThingList);
        PageHelpInfo pageHelpInfo = getPipeInfoByThingCode(thingCodeList, pageNum, pageSize);
        return pageHelpInfo;
    }

    private PageHelpInfo getPipeInfoByThingCode(List<String> thingCodeList, int pageNum, int pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<PipeInfo> pipeInfoList = new ArrayList<>();
        if (thingCodeList != null && thingCodeList.size() > 0) {
            pipeInfoList = thingMapper.getPipeInfoByThingcode(thingCodeList);
            List<ThingProperties> thingPropertiesList = thingPropertiesMapper.getThingPropertiesByThingCode(thingCodeList);
            if (pipeInfoList != null && pipeInfoList.size() > 0) {
                for (int i = 0; i < pipeInfoList.size(); i++) {
                    for (int j = 0; j < thingPropertiesList.size(); j++) {
                        if (pipeInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(START_THING_NAME)) {
                            pipeInfoList.get(i).setStartThingName(thingPropertiesList.get(j).getPropValue());
                        }
                        if (pipeInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(START_THING_CODE)) {
                            pipeInfoList.get(i).setStartThingCode(thingPropertiesList.get(j).getPropValue());
                        }
                        if (pipeInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(TERMINAL_THING_NAME)) {
                            pipeInfoList.get(i).setTerminalThingName(thingPropertiesList.get(j).getPropValue());
                        }
                        if (pipeInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(TERMINAL_THING_CODE)) {
                            pipeInfoList.get(i).setTerminalThingCode(thingPropertiesList.get(j).getPropValue());
                        }
                        if (pipeInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(ENABLE_DATE)) {
                            pipeInfoList.get(i).setEnableDate(thingPropertiesList.get(j).getPropValue());
                        }
                        if (pipeInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(DISABLE_DATE)) {
                            pipeInfoList.get(i).setDisableDate(thingPropertiesList.get(j).getPropValue());
                        }
                        if (pipeInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(MANUFACTURER)) {
                            pipeInfoList.get(i).setManufacturer(thingPropertiesList.get(j).getPropValue());
                        }
                        if (pipeInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(NOMINAL_DIAMETER)) {
                            pipeInfoList.get(i).setNominalDiameter(thingPropertiesList.get(j).getPropValue());
                        }
                    }
                }
            }
        }

        PageHelpInfo pageHelpInfo = new PageHelpInfo();
        pageHelpInfo.setList(pipeInfoList);
        pageHelpInfo.setSum(page.getTotal());
        return pageHelpInfo;
    }

    @Override
    public PageHelpInfo getChuteInfoByThingTagId(Long id, int pageNum, int pageSize) {
        List<RelThingtagThing> relThingtagThingList = relThingtagThingMapper.getRelThingtagThingByThingTagCode(id);
        List<String> thingCodeList = getThingCodeListByRelThingtagThing(relThingtagThingList);
        PageHelpInfo pageHelpInfo = getChuteInfoByThingCode(thingCodeList, pageNum, pageSize);
        return pageHelpInfo;
    }

    private PageHelpInfo getChuteInfoByThingCode(List<String> thingCodeList, int pageNum, int pageSize) {
        PageHelpInfo pageHelpInfo = getPipeInfoByThingCode(thingCodeList, pageNum, pageSize);

        List<PipeInfo> pipeInfoList = pageHelpInfo.getList();

        List<ChuteInfo> chuteInfoList = new ArrayList<>();
        for (int i = 0; i < pipeInfoList.size(); i++) {
            PipeInfo pipeInfo = pipeInfoList.get(i);
            ChuteInfo chuteInfo = new ChuteInfo();
            chuteInfo.setId(pipeInfo.getId());
            chuteInfo.setThingCode(pipeInfo.getThingCode());
            chuteInfo.setThingName(pipeInfo.getThingName());
            chuteInfo.setStartThingName(pipeInfo.getStartThingName());
            chuteInfo.setStartThingCode(pipeInfo.getStartThingCode());
            chuteInfo.setTerminalThingName(pipeInfo.getTerminalThingName());
            chuteInfo.setTerminalThingCode(pipeInfo.getTerminalThingCode());
            chuteInfo.setThingSystemId(pipeInfo.getThingSystemId());
            chuteInfo.setThingSystemName(pipeInfo.getThingSystemName());
            chuteInfo.setEnableDate(pipeInfo.getEnableDate());
            chuteInfo.setDisableDate(pipeInfo.getDisableDate());
            chuteInfo.setUpdateDate(pipeInfo.getUpdateDate());
            chuteInfoList.add(chuteInfo);
        }
        pageHelpInfo.setList(chuteInfoList);
        return pageHelpInfo;
    }

    @Override
    public PageHelpInfo getValveInfoByThingTagId(Long id, int pageNum, int pageSize) {
        List<RelThingtagThing> relThingtagThingList = relThingtagThingMapper.getRelThingtagThingByThingTagCode(id);
        List<String> thingCodeList = getThingCodeListByRelThingtagThing(relThingtagThingList);
        PageHelpInfo pageHelpInfo = getValveInfoByThingCode(thingCodeList, pageNum, pageSize);
        return pageHelpInfo;
    }

    private PageHelpInfo getValveInfoByThingCode(List<String> thingCodeList, int pageNum, int pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<ValveInfo> valveInfoList = new ArrayList<>();
        if (thingCodeList != null && thingCodeList.size() > 0) {
            valveInfoList = thingMapper.getValveInfoByThingcode(thingCodeList);
            List<ThingProperties> thingPropertiesList = thingPropertiesMapper.getThingPropertiesByThingCode(thingCodeList);
            if (valveInfoList != null && valveInfoList.size() > 0) {
                for (int i = 0; i < valveInfoList.size(); i++) {
                    for (int j = 0; j < thingPropertiesList.size(); j++) {
                        if (valveInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(PARENT_THING_CODE)) {
                            valveInfoList.get(i).setParentThingCode(thingPropertiesList.get(j).getPropValue());
                        }
                        if (valveInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(PARENT_THING_NAME)) {
                            valveInfoList.get(i).setParentThingName(thingPropertiesList.get(j).getPropValue());
                        }
                        if (valveInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(ENABLE_DATE)) {
                            valveInfoList.get(i).setEnableDate(thingPropertiesList.get(j).getPropValue());
                        }
                        if (valveInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(DISABLE_DATE)) {
                            valveInfoList.get(i).setDisableDate(thingPropertiesList.get(j).getPropValue());
                        }
                        if (valveInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(SUBJECT_TYPE)) {
                            valveInfoList.get(i).setSubjectType(thingPropertiesList.get(j).getPropValue());
                        }
                        if (valveInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(VALVE_TYPE)) {
                            valveInfoList.get(i).setValveType(thingPropertiesList.get(j).getPropValue());
                        }
                        if (valveInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(MANUFACTURER)) {
                            valveInfoList.get(i).setManufacturer(thingPropertiesList.get(j).getPropValue());
                        }
                        if (valveInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(SPECIFICATION)) {
                            valveInfoList.get(i).setSpecification(thingPropertiesList.get(j).getPropValue());
                        }
                        if (valveInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(VALVE_EXECUTION_MODE)) {
                            valveInfoList.get(i).setValveExecutionMode(thingPropertiesList.get(j).getPropValue());
                        }
                        if (valveInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(VALVE_CONTROL_MODE)) {
                            valveInfoList.get(i).setValveControlMode(thingPropertiesList.get(j).getPropValue());
                        }
                        if (valveInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(VALVE_PURPOSE)) {
                            valveInfoList.get(i).setValvePurpose(thingPropertiesList.get(j).getPropValue());
                        }
                        if (valveInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(NOMINAL_DIAMETER)) {
                            valveInfoList.get(i).setNominalDiameter(thingPropertiesList.get(j).getPropValue());
                        }
                    }
                }
            }
        }

        PageHelpInfo pageHelpInfo = new PageHelpInfo();
        pageHelpInfo.setList(valveInfoList);
        pageHelpInfo.setSum(page.getTotal());
        return pageHelpInfo;
    }

    @Override
    public PageHelpInfo getFlashboardInfoByThingTagId(Long id, int pageNum, int pageSize) {
        List<RelThingtagThing> relThingtagThingList = relThingtagThingMapper.getRelThingtagThingByThingTagCode(id);
        List<String> thingCodeList = getThingCodeListByRelThingtagThing(relThingtagThingList);
        PageHelpInfo pageHelpInfo = getFlashboardInfoByThingCode(thingCodeList, pageNum, pageSize);
        return pageHelpInfo;
    }

    private PageHelpInfo getFlashboardInfoByThingCode(List<String> thingCodeList, int pageNum, int pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<FlashboardInfo> flashboardInfoList = new ArrayList<>();
        if (thingCodeList != null && thingCodeList.size() > 0) {
            flashboardInfoList = thingMapper.getFlashboardInfoByThingcode(thingCodeList);
            List<ThingProperties> thingPropertiesList = thingPropertiesMapper.getThingPropertiesByThingCode(thingCodeList);
            if (flashboardInfoList != null && flashboardInfoList.size() > 0) {
                for (int i = 0; i < flashboardInfoList.size(); i++) {
                    for (int j = 0; j < thingPropertiesList.size(); j++) {
                        if (flashboardInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(PARENT_THING_CODE)) {
                            flashboardInfoList.get(i).setParentThingCode(thingPropertiesList.get(j).getPropValue());
                        }
                        if (flashboardInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(PARENT_THING_NAME)) {
                            flashboardInfoList.get(i).setParentThingName(thingPropertiesList.get(j).getPropValue());
                        }
                        if (flashboardInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(ENABLE_DATE)) {
                            flashboardInfoList.get(i).setEnableDate(thingPropertiesList.get(j).getPropValue());
                        }
                        if (flashboardInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(DISABLE_DATE)) {
                            flashboardInfoList.get(i).setDisableDate(thingPropertiesList.get(j).getPropValue());
                        }
                        if (flashboardInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(SUBJECT_TYPE)) {
                            flashboardInfoList.get(i).setSubjectType(thingPropertiesList.get(j).getPropValue());
                        }
                        if (flashboardInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(FLASHBOARD_TYPE)) {
                            flashboardInfoList.get(i).setFlashboardType(thingPropertiesList.get(j).getPropValue());
                        }
                        if (flashboardInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(MANUFACTURER)) {
                            flashboardInfoList.get(i).setManufacturer(thingPropertiesList.get(j).getPropValue());
                        }
                        if (flashboardInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(FLASHBOARD_EXECUTION_MODE)) {
                            flashboardInfoList.get(i).setFlashboardExecutionMode(thingPropertiesList.get(j).getPropValue());
                        }
                        if (flashboardInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(FLASHBOARD_CONTROL_MODE)) {
                            flashboardInfoList.get(i).setFlashboardControlMode(thingPropertiesList.get(j).getPropValue());
                        }
                    }
                }
            }
        }

        PageHelpInfo pageHelpInfo = new PageHelpInfo();
        pageHelpInfo.setList(flashboardInfoList);
        pageHelpInfo.setSum(page.getTotal());
        return pageHelpInfo;
    }

    @Transactional
    public void addMeter(MeterInfo meterInfo) {
        String parentThingCode = meterInfo.getParentThingCode();
        String thingType = meterInfo.getThingType();
        String thingCode = getThingCodeByInfo(parentThingCode, thingType, THING_TYPE1_CODE_METER);
        meterInfo.setThingCode(thingCode);

        // 获取thingtagcode
        ThingTag thingTag = thingTagManagementMapper.getThingTagByTagName(meterInfo.getThingTagName());

        //插入tb_thing表
        Thing thing = new Thing();
        thing.setThingCode(thingCode);
        thing.setThingName(meterInfo.getThingName());
        thing.setThingType1Code(THING_TYPE1_CODE_METER);
        thingMapper.addThing(thing);

        // thingPosition
        ThingPosition thingPosition = new ThingPosition();
        thingPosition.setThingCode(meterInfo.getThingCode());
        thingPosition.setBuildingId(Long.parseLong(meterInfo.getBuildingId().toString()));
        thingPosition.setFloor(Integer.parseInt(meterInfo.getFloor().toString()));
        thingPositionMapper.addThingPosition(thingPosition);

        // relThingtagThing
        RelThingtagThing relThingtagThing = new RelThingtagThing();
        relThingtagThing.setThingCode(meterInfo.getThingCode());
        relThingtagThing.setThingTagCode(thingTag.getCode());
        relThingtagThing.setCreateDate(new Date());
        relThingtagThingMapper.addRelThingtagThing(relThingtagThing);

        //插入tb_thing_properties表
        ThingProperties tp = new ThingProperties();
        tp.setThingCode(thingCode);
        tp.setPropKey(SUBJECT_TYPE);
        tp.setPropValue(meterInfo.getSubjectType());
        tp.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(MANUFACTURER);
        tp.setPropValue(meterInfo.getManufacturer());
        tp.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(PARENT_THING_CODE);
        tp.setPropValue(meterInfo.getParentThingCode());
        tp.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(PARENT_THING_NAME);
        tp.setPropValue(meterInfo.getParentThingName());
        tp.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(ENABLE_DATE);
        tp.setPropValue(meterInfo.getEnableDate());
        tp.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(DISABLE_DATE);
        tp.setPropValue(meterInfo.getDisableDate());
        tp.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(SPECIFICATION);
        tp.setPropValue(meterInfo.getSpecification());
        tp.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        tp.setPropKey(INSTRUMENT_TYPE);
        tp.setPropValue(meterInfo.getThingType());
        tp.setPropType(PROP_TYPE_PROP);
        thingPropertiesMapper.addThingProperties(tp);

        List<ConfigInfo> configList = meterInfo.getConfigList();
        if (configList != null && configList.size() > 0) {
            for (int i = 0; i < configList.size(); i++) {
                tp.setPropKey(configList.get(i).getKey());
                tp.setPropValue(configList.get(i).getValue());
                tp.setPropType(PROP_TYPE_PROP);
                thingPropertiesMapper.addThingProperties(tp);
            }
        }

    }

    @Transactional
    public void deleteMeter(Long id) {
        Thing thing = thingMapper.getThingById(id);
        String thingCode = thing.getThingCode();
        thingMapper.deleteThingById(id);
        thingPositionMapper.deleteThingPosition(thingCode);
        relThingtagThingMapper.deleteRelThingtagThingByThingCode(thingCode);
        thingPropertiesMapper.deleteThingPropertiesByThingCode(thingCode);
    }

    @Transactional
    public void editMeter(MeterInfo meterInfo) {
        deleteMeter(meterInfo.getId());
        addMeter(meterInfo);
    }

    @Override
    public PageHelpInfo getAllMeterInfo(Long id, int pageNum, int pageSize) {
        List<RelThingtagThing> relThingtagThingList = relThingtagThingMapper.getRelThingtagThingByThreeLevelId(id);
        List<String> thingCodeList = getThingCodeListByRelThingtagThing(relThingtagThingList);
        PageHelpInfo pageHelpInfo = getMeterInfoByThingCode(thingCodeList, pageNum, pageSize);
        return pageHelpInfo;
    }

    @Override
    public PageHelpInfo getMeterInfoByThingTagId(Long id, int pageNum, int pageSize) {
        List<RelThingtagThing> relThingtagThingList = relThingtagThingMapper.getRelThingtagThingByThingTagCode(id);
        List<String> thingCodeList = getThingCodeListByRelThingtagThing(relThingtagThingList);
        PageHelpInfo pageHelpInfo = getMeterInfoByThingCode(thingCodeList, pageNum, pageSize);
        return pageHelpInfo;
    }

    private PageHelpInfo getMeterInfoByThingCode(List<String> thingCodeList, int pageNum, int pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<MeterInfo> meterInfoList = new ArrayList<>();
        if (thingCodeList != null && thingCodeList.size() > 0) {
            meterInfoList = thingMapper.getMeterInfoByThingcode(thingCodeList);
            List<ThingProperties> thingPropertiesList = thingPropertiesMapper.getThingPropertiesByThingCode(thingCodeList);
            if (meterInfoList != null && meterInfoList.size() > 0) {
                for (int i = 0; i < meterInfoList.size(); i++) {
                    for (int j = 0; j < thingPropertiesList.size(); j++)
                        if (meterInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(PARENT_THING_CODE)) {
                            meterInfoList.get(i).setParentThingCode(thingPropertiesList.get(j).getPropValue());
                        } else if (meterInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(PARENT_THING_NAME)) {
                            meterInfoList.get(i).setParentThingName(thingPropertiesList.get(j).getPropValue());
                        } else if (meterInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(ENABLE_DATE)) {
                            meterInfoList.get(i).setEnableDate(thingPropertiesList.get(j).getPropValue());
                        } else if (meterInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(DISABLE_DATE)) {
                            meterInfoList.get(i).setDisableDate(thingPropertiesList.get(j).getPropValue());
                        } else if (meterInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(SUBJECT_TYPE)) {
                            meterInfoList.get(i).setSubjectType(thingPropertiesList.get(j).getPropValue());
                        } else if (meterInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(INSTRUMENT_TYPE)) {
                            meterInfoList.get(i).setThingType(thingPropertiesList.get(j).getPropValue());
                        } else if (meterInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(MANUFACTURER)) {
                            meterInfoList.get(i).setManufacturer(thingPropertiesList.get(j).getPropValue());
                        } else if (meterInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())
                                && thingPropertiesList.get(j).getPropKey().equals(SPECIFICATION)) {
                            meterInfoList.get(i).setSpecification(thingPropertiesList.get(j).getPropValue());
                        } else if (meterInfoList.get(i).getThingCode().equals(thingPropertiesList.get(j).getThingCode())) {
                            ConfigInfo configInfo = new ConfigInfo();
                            configInfo.setKey(thingPropertiesList.get(j).getPropKey());
                            configInfo.setValue(thingPropertiesList.get(j).getPropValue());
                            meterInfoList.get(i).getConfigList().add(configInfo);
                        }
                }
            }
        }

        PageHelpInfo pageHelpInfo = new PageHelpInfo();
        pageHelpInfo.setList(meterInfoList);
        pageHelpInfo.setSum(page.getTotal());
        return pageHelpInfo;
    }

    @Override
    public PageHelpInfo getPartsInfoByThingCode(String thingCode, int pageNum, int pageSize) {
        String where = thingCode + ".%";
        List<PartsInfo> partsInfoList = thingMapper.getPartsInfoByThingId(where);

        List<String> thingCodeList = new ArrayList<>();
        if (partsInfoList != null && partsInfoList.size() > 0) {
            for (PartsInfo aPartsInfoList : partsInfoList) {
                thingCodeList.add(aPartsInfoList.getThingCode());
            }
        }

        PageHelpInfo pageHelpInfo = getPartsInfoByThingCode(thingCodeList, pageNum, pageSize);
        return pageHelpInfo;
    }

    @Override
    public List<Thing> getThingByCodeOrName(String codeOrName, String type) {
        codeOrName = "%" + codeOrName + "%";
        return thingMapper.getThingByCodeOrName(codeOrName, codeOrName, type);
    }

    @Override
    public PageHelpInfo getThingInfoByThingCode(String thingCode, String type, int pageNum, int pageSize) {
        List<String> thingCodeList = new ArrayList<>();
        thingCodeList.add(thingCode);
        PageHelpInfo pageHelpInfo = null;
        if (THING_TYPE1_CODE_DEVICE.equals(type)) {
            pageHelpInfo = getDeviceInfoByThingCode(thingCodeList, pageNum, pageSize);
        } else if (THING_TYPE1_CODE_PARTS.equals(type)) {
            pageHelpInfo = getPartsInfoByThingCode(thingCodeList, pageNum, pageSize);
        } else if (THING_TYPE1_CODE_PIPE.equals(type)) {
            pageHelpInfo = getPipeInfoByThingCode(thingCodeList, pageNum, pageSize);
        } else if (THING_TYPE1_CODE_CHUTE.equals(type)) {
            pageHelpInfo = getChuteInfoByThingCode(thingCodeList, pageNum, pageSize);
        } else if (THING_TYPE1_CODE_VALVE.equals(type)) {
            pageHelpInfo = getValveInfoByThingCode(thingCodeList, pageNum, pageSize);
        } else if (THING_TYPE1_CODE_FLASHBOARD.equals(type)) {
            pageHelpInfo = getFlashboardInfoByThingCode(thingCodeList, pageNum, pageSize);
        } else if (THING_TYPE1_CODE_METER.equals(type)) {
            pageHelpInfo = getMeterInfoByThingCode(thingCodeList, pageNum, pageSize);
        }
        return pageHelpInfo;
    }

}
