DROP TABLE IF EXISTS Member ;
  
CREATE TABLE Member (
  member_id VARCHAR(255) PRIMARY KEY,
  age INT NOT NULL,
email_id VARCHAR(255) NOT NULL,
first_name VARCHAR(255) NOT NULL,
gender VARCHAR(255) NOT NULL,
last_name VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL
);
DROP TABLE IF EXISTS member_policy;
  
CREATE TABLE Member_policy (
  member_policy_id INT   PRIMARY KEY,
  due_date date NOT NULL,
member_id VARCHAR(250) NOT NULL,
  policy_id VARCHAR(250) NOT NULL,
premium_id VARCHAR(250) NOT NULL,
topup VARCHAR(250) NOT NULL  
);
DROP TABLE IF EXISTS member_Premium;
  
CREATE TABLE member_Premium (
  member_premium_id INT  PRIMARY KEY,
  due_date date NOT NULL,
   last_premium_date date NOT NULL,
 last_payment_date date NOT NULL,
  member_id VARCHAR(250) NOT NULL,
policy_id VARCHAR(250) NOT NULL,
premium_due_amount double NOT NULL
);