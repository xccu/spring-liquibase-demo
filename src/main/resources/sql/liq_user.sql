CREATE TABLE liq_user  (
  user_id varchar(36) NOT NULL COMMENT 'id值',
  name varchar(255) NOT NULL COMMENT '用户名',
  sex varchar(10) NULL COMMENT '性别',
  age int NOT NULL default 0 COMMENT '年龄',
  PRIMARY KEY (user_id)
)
