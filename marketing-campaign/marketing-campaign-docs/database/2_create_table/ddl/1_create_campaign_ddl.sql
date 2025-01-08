--
-- Table structure for table `campaign`
--
DROP TABLE IF EXISTS aplus_market_db.`campaign`;
CREATE TABLE aplus_market_db.`campaign` (
  `campaign_id` int NOT NULL AUTO_INCREMENT COMMENT 'campaign_id',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'name',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'description',
  `campaigntype` tinyint(1) NOT NULL COMMENT 'campaigntype',
  `issueraccount` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'issueraccount',
  `floataccount` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'floataccount',
  `start_datetime` datetime(3) DEFAULT NULL COMMENT 'start_datetime',
  `end_datetime` datetime(3) DEFAULT NULL COMMENT 'end_datetime',
  `logo` varchar(255) DEFAULT NULL COMMENT 'logo',
  `priority` int DEFAULT NULL COMMENT 'priority',
  `status` tinyint(1) NOT NULL COMMENT 'status',
  `del_flg` tinyint(1) NOT NULL COMMENT 'del_flg',
  `created_time` datetime DEFAULT NULL COMMENT 'created_time',
  `updated_time` datetime DEFAULT NULL COMMENT 'updated_time',
  PRIMARY KEY (`campaign_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='campaign';