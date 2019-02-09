CREATE TABLE `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `email` varchar(255) NOT NULL COMMENT 'メールアドレス',
  `hashed_password` varchar(255) NOT NULL COMMENT 'パスワード(ハッシュ)',
  `display_name` varchar(64) NOT NULL DEFAULT '' COMMENT '表示名',
  `status` varchar(16) NOT NULL COMMENT '状態',
  `modified` timestamp NOT NULL COMMENT '更新日時',
  `created` timestamp NOT NULL COMMENT '登録日時',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `status` (`status`),
  KEY `created` (`created`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='アカウント'