INSERT INTO `tb_metric` (`metric_category_code`, `metric_name`, `metric_code`, `metric_type1_code`, `metric_type2_code`, `metric_type3_code`, `value_type`, `value_unit`) VALUES ('SIG', '开到位', 'TAP_OPEN', 'S', 'TAP_OPEN', NULL, 'BOO', NULL);
INSERT INTO `tb_metric` (`metric_category_code`, `metric_name`, `metric_code`, `metric_type1_code`, `metric_type2_code`, `metric_type3_code`, `value_type`, `value_unit`) VALUES ('SIG', '关到位', 'TAP_CLOSE', 'S', 'TAP_CLOSE', NULL, 'BOO', NULL);
INSERT INTO `tb_metric` (`metric_category_code`, `metric_name`, `metric_code`, `metric_type1_code`, `metric_type2_code`, `metric_type3_code`, `value_type`, `value_unit`) VALUES ('SIG', '电流', 'CURRENT', 'PR', 'CURRENT', NULL, 'FLT', NULL);
INSERT INTO `tb_metric` (`metric_category_code`, `metric_name`, `metric_code`, `metric_type1_code`, `metric_type2_code`, `metric_type3_code`, `value_type`, `value_unit`) VALUES ('SIG', '联锁切换按钮', 'INTERLOCK', 'SS', 'INTERLOCK', NULL, 'BOO', NULL);
INSERT INTO `tb_metric` (`metric_category_code`, `metric_name`, `metric_code`, `metric_type1_code`, `metric_type2_code`, `metric_type3_code`, `value_type`, `value_unit`) VALUES ('SIG', '液位选择联锁', 'LEVEL_LOCK', 'SS', 'LEVEL_LOCK', NULL, 'BOO', NULL);
INSERT INTO `tb_metric` (`metric_category_code`, `metric_name`, `metric_code`, `metric_type1_code`, `metric_type2_code`, `metric_type3_code`, `value_type`, `value_unit`) VALUES ('SIG', '瞬时带煤量', 'COAL_CAP', 'PR', 'COAL_CAP', NULL, 'FLT', NULL);
INSERT INTO `tb_metric` (`metric_category_code`, `metric_name`, `metric_code`, `metric_type1_code`, `metric_type2_code`, `metric_type3_code`, `value_type`, `value_unit`) VALUES ('SIG', '频率', 'FREQUENCY', 'PR', 'FREQUENCY', NULL, 'FLT', NULL);
INSERT INTO `tb_metric` (`metric_category_code`, `metric_name`, `metric_code`, `metric_type1_code`, `metric_type2_code`, `metric_type3_code`, `value_type`, `value_unit`) VALUES ('SIG', '当前液位', 'LEVEL', 'PR', 'LEVEL', NULL, 'FLT', NULL);
INSERT INTO `tb_metric` (`metric_category_code`, `metric_name`, `metric_code`, `metric_type1_code`, `metric_type2_code`, `metric_type3_code`, `value_type`, `value_unit`) VALUES ('SIG', '智能控制', 'I_CONTROL', 'SS', 'I_CONTROL', NULL, 'BOO', NULL);
INSERT INTO `tb_metric` (`metric_category_code`, `metric_name`, `metric_code`, `metric_type1_code`, `metric_type2_code`, `metric_type3_code`, `value_type`, `value_unit`) VALUES ('SIG', '卸料次序', 'UNLOAD_SEQ', 'PR', 'UNLOAD_SEQ', NULL, 'INT', NULL);
INSERT INTO `tb_metric` (`metric_category_code`, `metric_name`, `metric_code`, `metric_type1_code`, `metric_type2_code`, `metric_type3_code`, `value_type`, `value_unit`) VALUES ('SIG', '压滤机当前板数', 'PLATE_CNT', 'PR', 'PLATE_CNT', NULL, 'INT', NULL);
INSERT INTO `tb_metric` (`metric_category_code`, `metric_name`, `metric_code`, `metric_type1_code`, `metric_type2_code`, `metric_type3_code`, `value_type`, `value_unit`) VALUES ('SIG', '压滤机总板数', 'PLATE_TTL', 'PR', 'PLATE_TTL', NULL, 'INT', NULL);
INSERT INTO `tb_metric` (`metric_category_code`, `metric_name`, `metric_code`, `metric_type1_code`, `metric_type2_code`, `metric_type3_code`, `value_type`, `value_unit`) VALUES ('SIG', '进料结束系统判断', 'FEED_ASUM', 'S', 'FEED_ASUM', NULL, 'INT', NULL);