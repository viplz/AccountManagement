
-- Table structure for tb_user
-- ----------------------------

CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_code` varchar(15) NOT NULL COMMENT '编码',
  `user_name` varchar(20) DEFAULT NULL COMMENT '名称',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `state` int(2) DEFAULT NULL COMMENT '状态',
  `create_at` varchar(19) DEFAULT NULL COMMENT '注册时间',
  `last_login_at` varchar(19) DEFAULT NULL COMMENT '最后登录时间',
  `user_type` int(2) DEFAULT NULL COMMENT '账户类型',
  `version` bigint(20) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
