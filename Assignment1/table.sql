CREATE TABLE login_table (
login_id INT(6) UNSIGNED AUTO_INCREMENT,
username VARCHAR(30) NOT NULL,
password VARCHAR(30) NOT NULL,
user_role VARCHAR(10),
PRIMARY KEY (login_id)
);

CREATE TABLE client_table (
client_id INT(6) UNSIGNED AUTO_INCREMENT,
full_name VARCHAR(30) NOT NULL,
address VARCHAR(30) NOT NULL,
CNP VARCHAR(10) NOT NULL,
login_id INT(6) UNSIGNED NOT NULL, 
PRIMARY KEY (client_id),
FOREIGN KEY (login_id) REFERENCES login_table(login_id)
);

CREATE TABLE account_table (
account_id INT(6) UNSIGNED AUTO_INCREMENT,
client_id INT(6) UNSIGNED NOT NULL,
account_type VARCHAR(15) NOT NULL,
amount FLOAT(6) NOT NULL,
currency_code VARCHAR(3) NOT NULL,
account_status TINYINT,
PRIMARY KEY (account_id),
FOREIGN KEY (client_id) REFERENCES client_table(client_id)
);



