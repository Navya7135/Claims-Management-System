INSERT INTO Policy (`policy_id`, `policy_name`, `benefit_id`,`premium_amt`, `tenure`) VALUES ('p1', 'policyA', 'b1' , 30000, 5);
INSERT INTO Policy  (`policy_id`, `policy_name`, `benefit_id`,`premium_amt`, `tenure`) VALUES ('p2', 'policyB', 'b2', 50000, 6);
INSERT INTO Policy  (`policy_id`, `policy_name`, `benefit_id`,`premium_amt`, `tenure`) VALUES ('p3', 'policyC', 'b3', 20000, 8);

INSERT INTO Member_Policy (`member_policy_id`, `benefit_id`, `claim_amt`, `member_id`, `policy_id`, `subscription_date`, `tenure`) VALUES (1, 'b1', 30000, 'member1', 'p1', '2021-01-01', 2);
INSERT INTO Member_Policy (`member_policy_id`, `benefit_id`, `claim_amt`, `member_id`, `policy_id`, `subscription_date`, `tenure`) VALUES (2, 'b2', 30000, 'member1', 'p2', '2021-01-01', 2);
INSERT INTO Member_Policy (`member_policy_id`, `benefit_id`, `claim_amt`, `member_id`, `policy_id`, `subscription_date`, `tenure`) VALUES (3, 'b2', 50000, 'member2', 'p2', '2021-01-01', 5);
INSERT INTO Member_Policy (`member_policy_id`, `benefit_id`, `claim_amt`, `member_id`, `policy_id`, `subscription_date`, `tenure`) VALUES (4, 'b3', 20000, 'member2', 'p1', '2021-01-01', 6);
INSERT INTO Member_Policy (`member_policy_id`, `benefit_id`, `claim_amt`, `member_id`, `policy_id`, `subscription_date`, `tenure`) VALUES (5, 'b5', 30000, 'member1', 'p3', '2021-01-01', 2);

INSERT INTO Provider_Policy (`provider_policy_id`, `hospital_id`, `location`, `policy_id`) VALUES (1, 'h1', 'hyderabad', 'p1');
INSERT INTO Provider_Policy (`provider_policy_id`, `hospital_id`, `location`, `policy_id`) VALUES (2, 'h2', 'Moulali', 'p1');
INSERT INTO Provider_Policy (`provider_policy_id`, `hospital_id`, `location`, `policy_id`) VALUES (3, 'h1', 'hyderabad', 'p2');
INSERT INTO Provider_Policy (`provider_policy_id`, `hospital_id`, `location`, `policy_id`) VALUES (4, 'h2', 'hyderabad', 'p3');
INSERT INTO Provider_Policy (`provider_policy_id`, `hospital_id`, `location`, `policy_id`) VALUES (5, 'h3', 'kukatpally', 'p1');

INSERT INTO Benefits (`benefit_id`, `benefit`,`policy_id`) VALUES ('b1', 'free vaccine','p1');
INSERT INTO Benefits (`benefit_id`, `benefit`,`policy_id`) VALUES ('b2', 'free eye checkup','p1');
INSERT INTO Benefits (`benefit_id`, `benefit`,`policy_id`) VALUES ('b3', 'free blood test','p2');
INSERT INTO Benefits (`benefit_id`, `benefit`,`policy_id`) VALUES ('b4', 'free diabetic test','p3');
INSERT INTO Benefits (`benefit_id`, `benefit`,`policy_id`) VALUES ('b5', 'free covid test','p1');

