-- ----------------------------
-- Table structure for sec_user
-- ----------------------------
DROP TABLE IF EXISTS `sec_user`;
CREATE TABLE `sec_user`  (
                             `id` bigint NOT NULL COMMENT '主键',
                             `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
                             `password` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
                             `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
                             `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
                             `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
                             `birthday` datetime NULL DEFAULT NULL COMMENT '生日',
                             `sex` int NULL DEFAULT NULL COMMENT '性别，男-1，女-2',
                             `status` int NOT NULL DEFAULT 1 COMMENT '状态，启用-1，禁用-0',
                             `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                             `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
                             PRIMARY KEY (`id`) USING BTREE,
                             UNIQUE INDEX `username`(`username` ASC) USING BTREE,
                             UNIQUE INDEX `phone`(`phone` ASC) USING BTREE,
                             UNIQUE INDEX `email`(`email` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sec_user
-- ----------------------------
INSERT INTO `sec_user` VALUES (1072806377661009920, 'admin', '$2a$10$64iuSLkKNhpTN19jGHs7xePvFsub7ZCcCmBqEYw8fbACGTE3XetYq', '管理员', '17300000000', 'admin@163.com', '2000-01-01 09:20:18', 1, 1, '2023-12-13 09:20:40', '2023-12-13 09:21:02', 0);
INSERT INTO `sec_user` VALUES (1072806378780889088, 'user001', '$2a$10$OUDl4thpcHfs7WZ1kMUOb.ZO5eD4QANW5E.cexBLiKDIzDNt87QbO', '普通用户001', '17300001111', 'user001@163.com', '2003-02-13 09:22:01', 2, 1, '2023-12-13 09:21:55', '2023-12-13 09:22:23', 0);

-- ----------------------------
-- Table structure for sec_role
-- ----------------------------
DROP TABLE IF EXISTS `sec_role`;
CREATE TABLE `sec_role`  (
                             `id` bigint NOT NULL COMMENT '主键',
                             `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名',
                             `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
                             `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                             `deleted` tinyint(1) NOT NULL DEFAULT 0,
                             PRIMARY KEY (`id`) USING BTREE,
                             UNIQUE INDEX `name`(`name` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sec_role
-- ----------------------------
INSERT INTO `sec_role` VALUES (1072806379208708096, '管理员', '超级管理员', '2023-12-13 09:27:39', '2023-12-13 09:27:44', 0);
INSERT INTO `sec_role` VALUES (1072806379238068224, '普通用户', '普通用户', '2023-12-13 09:27:46', '2023-12-13 09:27:48', 0);

-- ----------------------------
-- Table structure for sec_permission
-- ----------------------------
DROP TABLE IF EXISTS `sec_permission`;
CREATE TABLE `sec_permission`  (
                                   `id` bigint NOT NULL COMMENT '主键',
                                   `parent_id` bigint NOT NULL COMMENT '父级id',
                                   `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名',
                                   `type` int NOT NULL COMMENT '权限类型，页面-1，按钮-2',
                                   `url` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型为页面时，代表前端路由地址，类型为按钮时，代表后端接口地址',
                                   `method` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '后端接口访问方式',
                                   `permission` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限表达式',
                                   `sort` int NOT NULL COMMENT '排序',
                                   `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                   `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                   `deleted` tinyint(1) NOT NULL DEFAULT 0,
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sec_permission
-- ----------------------------
INSERT INTO `sec_permission` VALUES (1072806379288399872, 0, '测试页面', 1, '/test', NULL, 'page:test', 1, '2023-12-13 09:33:44', '2023-12-13 09:33:44', 0);
INSERT INTO `sec_permission` VALUES (1072806379313565696, 1072806379288399872, '测试页面-查询', 2, '/**/test', 'GET', 'btn:test:query', 1, '2023-12-13 09:33:44', '2023-12-13 09:33:44', 0);
INSERT INTO `sec_permission` VALUES (1072806379330342912, 1072806379288399872, '测试页面-添加', 2, '/**/test', 'POST', 'btn:test:insert', 2, '2023-12-13 09:33:44', '2023-12-13 09:33:44', 0);
INSERT INTO `sec_permission` VALUES (1072806379342925824, 0, '监控在线用户页面', 1, '/monitor', NULL, 'page:monitor:online', 2, '2023-12-13 09:33:44', '2023-12-13 09:33:44', 0);
INSERT INTO `sec_permission` VALUES (1072806379363897344, 1072806379342925824, '在线用户页面-查询', 2, '/**/api/monitor/online/user', 'GET', 'btn:monitor:online:query', 1, '2023-12-13 09:33:44', '2023-12-13 09:33:44', 0);
INSERT INTO `sec_permission` VALUES (1072806379384868864, 1072806379342925824, '在线用户页面-踢出', 2, '/**/api/monitor/online/user/kickout', 'DELETE', 'btn:monitor:online:kickout', 2, '2023-12-13 09:33:44', '2023-12-13 09:33:44', 0);

-- ----------------------------
-- Table structure for sec_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sec_user_role`;
CREATE TABLE `sec_user_role`  (
                                  `user_id` bigint NOT NULL COMMENT '用户主键',
                                  `role_id` bigint NOT NULL COMMENT '角色主键',
                                  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                  `deleted` tinyint(1) NOT NULL DEFAULT 0,
                                  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sec_user_role
-- ----------------------------
INSERT INTO `sec_user_role` VALUES (1072806377661009920, 1072806379208708096, '2023-12-13 09:37:22', '2023-12-13 09:37:22', 0);
INSERT INTO `sec_user_role` VALUES (1072806378780889088, 1072806379238068224, '2023-12-13 09:37:22', '2023-12-13 09:37:22', 0);

-- ----------------------------
-- Table structure for sec_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sec_role_permission`;
CREATE TABLE `sec_role_permission`  (
                                        `role_id` bigint NOT NULL COMMENT '角色主键',
                                        `permission_id` bigint NOT NULL COMMENT '权限主键',
                                        `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                        `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                        `deleted` tinyint(1) NOT NULL DEFAULT 0,
                                        PRIMARY KEY (`role_id`, `permission_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sec_role_permission
-- ----------------------------
INSERT INTO `sec_role_permission` VALUES (1072806379208708096, 1072806379288399872, '2023-12-13 09:38:25', '2023-12-13 09:38:25', 0);
INSERT INTO `sec_role_permission` VALUES (1072806379208708096, 1072806379313565696, '2023-12-13 09:38:25', '2023-12-13 09:38:25', 0);
INSERT INTO `sec_role_permission` VALUES (1072806379208708096, 1072806379330342912, '2023-12-13 09:38:25', '2023-12-13 09:38:25', 0);
INSERT INTO `sec_role_permission` VALUES (1072806379208708096, 1072806379342925824, '2023-12-13 09:38:25', '2023-12-13 09:38:25', 0);
INSERT INTO `sec_role_permission` VALUES (1072806379208708096, 1072806379363897344, '2023-12-13 09:38:25', '2023-12-13 09:38:25', 0);
INSERT INTO `sec_role_permission` VALUES (1072806379208708096, 1072806379384868864, '2023-12-13 09:38:25', '2023-12-13 09:38:25', 0);
INSERT INTO `sec_role_permission` VALUES (1072806379238068224, 1072806379288399872, '2023-12-13 09:38:25', '2023-12-13 09:38:25', 0);
INSERT INTO `sec_role_permission` VALUES (1072806379238068224, 1072806379313565696, '2023-12-13 09:38:25', '2023-12-13 09:38:25', 0);
