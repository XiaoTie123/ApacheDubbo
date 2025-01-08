--
-- Table structure for table `point_config`
--
DROP TABLE IF EXISTS point_engine.`point_config`;
CREATE TABLE point_engine.`point_config` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'name',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'description',
  `transfer_type` int DEFAULT NULL COMMENT 'transfer_type',  
  `transfer_amount` double DEFAULT NULL COMMENT 'transfer_amount',
  `point` double DEFAULT NULL COMMENT 'point',
  `percentage` double DEFAULT NULL COMMENT 'percentage',
  `status` tinyint(1) NOT NULL COMMENT 'status',
  `del_flg` tinyint(1) NOT NULL COMMENT 'del_flg',
  `created_time` datetime DEFAULT NULL COMMENT 'created_time',
  `updated_time` datetime DEFAULT NULL COMMENT 'updated_time',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='point_config';