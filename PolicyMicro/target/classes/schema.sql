DROP TABLE IF EXISTS Policy ;
  
CREATE TABLE Policy (
  policy_id VARCHAR(255) PRIMARY KEY,
  policy_name VARCHAR(250) NOT NULL,
  benefit_id VARCHAR(255) NOT NULL,
  premium_amt double NOT NULL,
  tenure bigint(20) DEFAULT NULL
);
DROP TABLE IF EXISTS member_policy;
  
CREATE TABLE Member_policy (
  member_policy_id INT   PRIMARY KEY,
  benefit_id VARCHAR(250) NOT NULL,
  claim_amt double NOT NULL,
member_id VARCHAR(250) NOT NULL,
  policy_id VARCHAR(250) DEFAULT NULL,
subscription_date date NOT NULL,
tenure INT   
);
DROP TABLE IF EXISTS Provider_Policy;
  
CREATE TABLE Provider_Policy (
  provide_policy_id INT  PRIMARY KEY,
  hospital_id VARCHAR(250) NOT NULL,
  location VARCHAR(250) NOT NULL,
  policy_id VARCHAR(250) DEFAULT NULL
);
DROP TABLE IF EXISTS benefits;
  
CREATE TABLE Benefits (
  benefit_id VARCHAR(250)  PRIMARY KEY,
  benefit VARCHAR(250) NOT NULL,
  policy_id VARCHAR(250) NOT NULL,
  FOREIGN KEY(policy_id) REFERENCES Policy(policy_id)
   
);