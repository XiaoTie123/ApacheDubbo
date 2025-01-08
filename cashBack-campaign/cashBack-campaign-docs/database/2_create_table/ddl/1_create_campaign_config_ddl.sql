--
-- Table structure for table `campaign_config`
--
DROP TABLE IF EXISTS cashBack_campaign.`campaign_config`;
CREATE TABLE cashBack_campaign.`campaign_config` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'name',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'description',
  `status` tinyint(1) NOT NULL COMMENT 'status',
  `del_flg` tinyint(1) NOT NULL COMMENT 'del_flg',
  `created_time` datetime DEFAULT NULL COMMENT 'created_time',
  `updated_time` datetime DEFAULT NULL COMMENT 'updated_time',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='campaign_config';