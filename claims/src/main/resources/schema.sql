DROP TABLE IF EXISTS Claims ;
  
CREATE TABLE claims (
  claim_id INT PRIMARY KEY,
  benefits_availed VARCHAR(255) NOT NULL,
claim_desc VARCHAR(255) NOT NULL,
claim_status VARCHAR(255) NOT NULL,
hospital_id VARCHAR(255) NOT NULL,
member_id VARCHAR(255) NOT NULL,
policy_id VARCHAR(255) NOT NULL,
remarks VARCHAR(255) NOT NULL,
 total_bill double,
 total_claimed_amt double
);