CREATE TABLE `account_table` (
  `account_id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `client_id` int(6) unsigned NOT NULL,
  `account_type` varchar(15) NOT NULL,
  `amount` float NOT NULL,
  `currency_code` varchar(3) NOT NULL,
  `account_status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  KEY `client_id` (`client_id`),
  CONSTRAINT `account_table_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client_table` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100001 DEFAULT CHARSET=latin1;


CREATE TABLE `account_table` (
  `account_id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `client_id` int(6) unsigned NOT NULL,
  `account_type` varchar(15) NOT NULL,
  `amount` float NOT NULL,
  `currency_code` varchar(3) NOT NULL,
  `account_status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  KEY `client_id` (`client_id`),
  CONSTRAINT `account_table_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client_table` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100001 DEFAULT CHARSET=latin1;



CREATE TABLE `login_table` (
  `login_id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `user_role` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`login_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=latin1;
