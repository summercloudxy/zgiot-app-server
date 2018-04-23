DELETE FROM `tb_alert_rule` WHERE metric_code in ('LE1','LE2');

INSERT INTO `tb_alert_rule` ( `thing_code`, `metric_code`, `rule_type`, `alert_level`, `lower_limit`, `upper_limit`, `enable`) VALUES ( '700A', 'LE1', '1', '30', '41.00', '100.00', '1');
INSERT INTO `tb_alert_rule` ( `thing_code`, `metric_code`, `rule_type`, `alert_level`, `lower_limit`, `upper_limit`, `enable`) VALUES ( '700A', 'LE2', '1', '30', '41.00', '100.00', '1');
INSERT INTO `tb_alert_rule` ( `thing_code`, `metric_code`, `rule_type`, `alert_level`, `lower_limit`, `upper_limit`, `enable`) VALUES ( '700B', 'LE2', '1', '30', '41.00', '100.00', '1');
INSERT INTO `tb_alert_rule` ( `thing_code`, `metric_code`, `rule_type`, `alert_level`, `lower_limit`, `upper_limit`, `enable`) VALUES ( '700B', 'LE1', '1', '30', '41.00', '100.00', '1');
INSERT INTO `tb_alert_rule` ( `thing_code`, `metric_code`, `rule_type`, `alert_level`, `lower_limit`, `upper_limit`, `enable`) VALUES ( '700C', 'LE1', '1', '30', '41.00', '100.00', '1');
INSERT INTO `tb_alert_rule` ( `thing_code`, `metric_code`, `rule_type`, `alert_level`, `lower_limit`, `upper_limit`, `enable`) VALUES ( '700C', 'LE2', '1', '30', '41.00', '100.00', '1');
INSERT INTO `tb_alert_rule` ( `thing_code`, `metric_code`, `rule_type`, `alert_level`, `lower_limit`, `upper_limit`, `enable`) VALUES ( '700D', 'LE2', '1', '30', '41.00', '100.00', '1');
INSERT INTO `tb_alert_rule` ( `thing_code`, `metric_code`, `rule_type`, `alert_level`, `lower_limit`, `upper_limit`, `enable`) VALUES ( '700D', 'LE1', '1', '30', '41.00', '100.00', '1');
INSERT INTO `tb_alert_rule` ( `thing_code`, `metric_code`, `rule_type`, `alert_level`, `lower_limit`, `upper_limit`, `enable`) VALUES ( '1200A', 'LE1', '1', '30', '9.00', '100.00', '1');
INSERT INTO `tb_alert_rule` ( `thing_code`, `metric_code`, `rule_type`, `alert_level`, `lower_limit`, `upper_limit`, `enable`) VALUES ( '2200A', 'LE1', '1', '30', '9.00', '100.00', '1');
INSERT INTO `tb_alert_rule` ( `thing_code`, `metric_code`, `rule_type`, `alert_level`, `lower_limit`, `upper_limit`, `enable`) VALUES ( '900A', 'LE1', '1', '30', '17.00', '100.00', '1');
