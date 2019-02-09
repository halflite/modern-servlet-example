CREATE TABLE `admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `account_id` bigint(20) NOT NULL COMMENT 'アカウントid',
  `division` varchar(16) NOT NULL COMMENT '役割',
  `modified` timestamp NOT NULL COMMENT '更新日時',
  `created` timestamp NOT NULL COMMENT '登録日時',
  PRIMARY KEY (`id`),
  KEY `division` (`division`),
  KEY `created` (`created`),
  KEY `account_id` (`account_id`),
  CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='管理者'