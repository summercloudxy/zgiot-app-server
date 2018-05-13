ALTER TABLE tb_thing_tag ADD COLUMN web_path varchar(255) DEFAULT '' COMMENT '页面路由';
INSERT INTO `tb_thing_tag` VALUES ('100', '100', '机械设备', '1', null, '4', '2018-03-26 14:34:06', null, null, null, 'machine/');
INSERT INTO `tb_thing_tag` VALUES ('101', '101', '设备信息', '100', null, '4', '2018-03-26 14:34:06', null, null, null, 'machine/deviceInfo');
INSERT INTO `tb_thing_tag` VALUES ('102', '102', '破碎设备', '101', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('103', '103', '破碎机', '102', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('104', '104', '筛分设备', '101', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('105', '105', '分级筛', '104', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('106', '106', '脱水筛', '104', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('107', '107', '脱介筛', '104', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('108', '108', '分选设备', '101', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('109', '109', '跳汰机', '108', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('110', '110', '动筛', '108', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('111', '111', '浅槽分选机', '108', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('112', '112', '重介旋流器', '108', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('113', '113', 'TBS分选机', '108', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('114', '114', 'TCS分选机', '108', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('115', '115', '螺旋分选机', '108', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('116', '116', '浮选机', '108', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('117', '117', '浮选柱', '108', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('118', '118', '脱水设备', '101', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('119', '119', '离心机', '118', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('120', '120', '压滤机', '118', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('121', '121', '加压过滤', '118', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('122', '122', '干燥机', '118', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('123', '123', '分级浓缩', '101', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('124', '124', '分级旋流器', '123', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('125', '125', '浓缩机', '123', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('126', '126', '输送设备', '101', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('127', '127', '皮带机', '126', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('128', '128', '刮板机', '126', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('129', '129', '给煤机', '126', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('130', '130', '斗提机', '126', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('131', '131', '辅助设备', '101', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('132', '132', '磁选机', '131', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('133', '133', '除铁器', '131', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('134', '134', '空压机', '131', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('135', '135', '储气罐', '131', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('136', '136', '加药', '131', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('137', '137', '起重设备', '131', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('138', '138', '预处理器', '131', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('139', '139', '水泵', '131', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('140', '140', '除尘器', '131', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('141', '141', '桶', '131', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('142', '142', '桶/箱', '131', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('143', '143', '部件信息', '100', null, '4', '2018-03-26 14:34:06', null, null, null, 'machine/partInfo');
INSERT INTO `tb_thing_tag` VALUES ('144', '144', '阀门信息', '100', null, '4', '2018-03-26 14:34:06', null, null, null, 'machine/valveInfo');
INSERT INTO `tb_thing_tag` VALUES ('145', '145', '管道信息', '100', null, '4', '2018-03-26 14:34:06', null, null, null, 'machine/pipeInfo');
INSERT INTO `tb_thing_tag` VALUES ('146', '146', '闸板信息', '100', null, '4', '2018-03-26 14:34:06', null, null, null, 'machine/flashboardInfo');
INSERT INTO `tb_thing_tag` VALUES ('147', '147', '溜槽信息', '100', null, '4', '2018-03-26 14:34:06', null, null, null, 'machine/chuteInfo');
INSERT INTO `tb_thing_tag` VALUES ('148', '148', '电气设备', '1', null, '4', '2018-03-26 14:34:06', null, null, null, 'fieldList/');
INSERT INTO `tb_thing_tag` VALUES ('149', '149', '仪表信息', '148', null, '4', '2018-03-26 14:34:06', null, null, null, 'electric/meter');
INSERT INTO `tb_thing_tag` VALUES ('150', '150', '测灰仪', '149', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('151', '151', '粒位计', '149', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('152', '152', '密度计', '149', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('153', '153', '扭矩表', '149', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('154', '154', '皮带秤', '149', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('155', '155', '压力表', '149', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('156', '156', '液位仪', '149', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('157', '157', '入料电磁流量计', '149', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('158', '158', 'TCS顶水电磁流量计', '149', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('159', '159', '定压水电磁流量计', '149', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('160', '160', '尾矿排料电磁流量计', '149', null, '4', '2018-03-26 14:34:06', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('162', '162', '变压器信息', '148', null, '4', '2018-03-26 14:34:06', null, null, null, 'electric/transformer');
INSERT INTO `tb_thing_tag` VALUES ('163', '163', '建筑设备', '1', null, '4', '2018-03-26 14:34:06', null, null, null, 'building/');
INSERT INTO `tb_thing_tag` VALUES ('164', '164', '生产车间管理', '163', null, '4', '2018-03-26 14:34:06', null, null, null, 'building/workshop');
INSERT INTO `tb_thing_tag` VALUES ('165', '165', '储煤仓总仓位管理', '163', null, '4', '2018-03-26 14:34:06', null, null, null, 'building/deport');
INSERT INTO `tb_thing_tag` VALUES ('201', 'COAL', '原煤大区', null, null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('202', 'SAVECOAL', '原煤储运系统', '201', null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('203', '8-COAL-1', '8#原煤1#仓', '202', null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('204', '8-COAL-2', '8#原煤2#仓', '202', null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('205', '13-COAL-3', '13#原煤3#仓', '202', null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('206', '13-COAL-4', '13#原煤4#仓', '202', null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('207', 'READYCOAL', '原煤准备系统', '201', null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('208', 'READYCOAL-MAIN', '原煤准备系统', '207', null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('209', 'READYCOAL-HELP', '辅助设备', '207', null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('210', 'WASH', '洗选大区', null, null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('211', 'SEDIMENTATION', '沉降系统', '210', null, '5', null, null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('212', 'PRODUCTION', '生产辅助系统', '210', null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('213', 'CLEAR', '清水系统', '212', null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('214', 'SEWAGE', '污水系统', '212', null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('215', 'COALBYPASS', '末煤旁路系统', '210', null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('216', 'WASHINGPUBLIC', '洗选公用系统', '210', null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('217', 'LUMPCOAL', '块煤系统', '210', null, '5', null, null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('218', 'CONCENTRATION', '浓缩系统', '210', null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('219', 'DOSING', '加药总览', '218', null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('220', 'CONCENTRATION-MAIN', '浓缩系统', '218', null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('221', 'CONCENTRATION-HELP', '辅助设备', '218', null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('222', 'LOADCAR', '装车大区', null, null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('223', 'FASTLOADING', '快速装车系统', '222', null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('224', 'CLEAN-COAL-A', '精煤A仓', '223', null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('225', 'CLEAN-COAL-B', '精煤B仓', '223', null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('226', 'MIXED-COAL-C', '混煤C仓', '223', null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('227', 'MIXED-COAL-D', '混煤D仓', '223', null, '5', '2018-04-17 16:16:00', null, null, null, '');
INSERT INTO `tb_thing_tag` VALUES ('228', 'TRANSPORTATION', '矸石运输系统', '222', null, '5', '2018-04-17 16:16:00', null, null, null, '');