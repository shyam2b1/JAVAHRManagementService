CREATE TABLE `employee` (
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `job_title` varchar(45) DEFAULT NULL,
  `salary` int DEFAULT NULL,
  `reports_to` varchar(45) DEFAULT NULL,
  `employee_id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1058 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
