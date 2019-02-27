
CREATE table `user_info`(
    id VARCHAR (32) NOT NULL PRIMARY KEY COMMENT '主键',
    user_name VARCHAR (32) COMMENT '用户姓名',
    login_name VARCHAR (32)  comment '登陆名',
    password VARCHAR (32)  COMMENT '登录密码',
    sex VARCHAR (6) comment '性别:1-男;2-女',
    user_phone VARCHAR (32)  COMMENT '用户电话',
    wx_open_id VARCHAR (128) COMMENT '微信oenId',
    school_id VARCHAR (32) COMMENT '所属驾校ID',
    stage VARCHAR (32) COMMENT '阶段（教练和学员会有该值）',
    license_type VARCHAR (32) COMMENT '驾照类型（教练和学员会有该值）',
    is_enabled VARCHAR (6) comment '是否启用(101-启用,102-禁用)',
    user_role VARCHAR (6) commont'角色'
    backup1 VARCHAR (32) COMMENT '备用字段1(用于角色类型区分,关联类型表)',
    backup2 VARCHAR (32) COMMENT '备用字段2',
    update_time TIMESTAMP not null default current_timestamp on update current_timestamp,
    create_time TIMESTAMP NOT  NULL DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户表';

-- CREATE table `role_info`(
--     id VARCHAR (32) NOT NULL PRIMARY KEY COMMENT '主键',
--     role_name VARCHAR (32) COMMENT '角色名',
--     backup1 VARCHAR (32) COMMENT '备用字段1',
--     backup2 VARCHAR (32) COMMENT '备用字段2',
--     school_id VARCHAR (32) COMMENT '所属驾校ID',
--     auths VARCHAR (128) COMMENT '权限(可表示多个权限，用逗号隔开。权限名称存于类型表中)',
--     update_time TIMESTAMP not null default current_timestamp on update current_timestamp,
--     create_time TIMESTAMP NOT  NULL DEFAULT CURRENT_TIMESTAMP
-- )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '角色表';z

-- CREATE table `user_role`(
--     id VARCHAR (32) NOT NULL PRIMARY KEY COMMENT '主键',
--     role_id VARCHAR (32) COMMENT '角色ID',
--     user_id VARCHAR (32) COMMENT '用户ID',
--     school_id VARCHAR (32) COMMENT '所属驾校ID',
--     backup1 VARCHAR (32) COMMENT '备用字段1',
--     backup2 VARCHAR (32) COMMENT '备用字段2',
--     update_time TIMESTAMP not null default current_timestamp on update current_timestamp,
--     create_time TIMESTAMP NOT  NULL DEFAULT CURRENT_TIMESTAMP
-- )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户角色分配表';

CREATE table `appointment_info`(
    id VARCHAR (32) NOT NULL PRIMARY KEY COMMENT '主键',
    coach_id VARCHAR (32) COMMENT '学员ID',
    trainee_id VARCHAR (32) COMMENT '教练ID',
    license_type VARCHAR (6) comment '练习类型',
    appointment_date DATE COMMENT '预约日期',
    time_interval VARCHAR (6) COMMENT '预约时段(存类型表code)',
    stage VARCHAR(32) COMMENT '阶段（科目二或者科目三）',
    school_id VARCHAR (32) COMMENT '所属驾校ID',
    backup1 VARCHAR (32) COMMENT '备用字段1',

    backup2 VARCHAR (32) COMMENT '备用字段2',
    update_time TIMESTAMP not null default current_timestamp on update current_timestamp,
    create_time TIMESTAMP NOT  NULL DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '预约表';

CREATE table `school_info`(
    id VARCHAR (32) NOT NULL PRIMARY KEY COMMENT '主键',
    school_name VARCHAR (32) COMMENT '驾校名称',
    introduce VARCHAR (32) COMMENT '驾校简介',
    backup1 VARCHAR (32) COMMENT '备用字段1',
    backup2 VARCHAR (32) COMMENT '备用字段2',
    update_time TIMESTAMP not null default current_timestamp on update current_timestamp,
    create_time TIMESTAMP NOT  NULL DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '驾校表';

CREATE table `type_info`(
    id VARCHAR (32) NOT NULL PRIMARY KEY COMMENT '主键',
    type_code VARCHAR (32) COMMENT '类型编码',
    type_name VARCHAR (32) COMMENT '类型名称',
    small_code VARCHAR (32) COMMENT '小类编码',
    small_name VARCHAR (32) COMMENT '小类名称',
    backup1 VARCHAR (32) COMMENT '备用字段1',
    backup2 VARCHAR (32) COMMENT '备用字段2',
    school_id VARCHAR (32) COMMENT '所属驾校ID',
    update_time TIMESTAMP not null default current_timestamp on update current_timestamp,
    create_time TIMESTAMP NOT  NULL DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '类型表';









