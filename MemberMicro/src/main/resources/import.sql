INSERT INTO member (`member_id`,`age`, `email_id`, `first_name`, `gender`, `last_name`,`password`) VALUES ('member1', 20, 'member1@gmail.com', 'user', 'm', '1', '123456');
INSERT INTO member (`member_id`,`age`, `email_id`, `first_name`, `gender`, `last_name`,`password`) VALUES ('member2', 30, 'menber2@gmail.com', 'user', 'f', '2', '123456');
INSERT INTO member (`member_id`,`age`, `email_id`, `first_name`, `gender`, `last_name`,`password`) VALUES ('member3', 35, 'member3@gmail.com', 'user', 'm', '3', '123456');

INSERT INTO member_policy (`member_policy_id`, `due_date`, `memberid`, `policy_id`, `premium_id`, `topup`) VALUES (1, '2021-07-13', 'member1', 'p1', 'pr1', 2000);
INSERT INTO member_policy (`member_policy_id`, `due_date`, `memberid`, `policy_id`, `premium_id`, `topup`) VALUES (2, '2021-07-14', 'member2', 'p2', 'pr2', 3000);
INSERT INTO member_policy (`member_policy_id`, `due_date`, `memberid`, `policy_id`, `premium_id`, `topup`) VALUES (3, '2021-07-15', 'member3', 'p3', 'pr3', 4000);

INSERT INTO member_premium (`member_premium_id`, `due_date`, `last_premium_date`, `late_payment_charge`, `member_id`, `policy_id`, `premium_due_amount`) VALUES (1, '2021-07-14', '2021-01-20', 1000, 'member1', 'p1', 20000);
INSERT INTO member_premium (`member_premium_id`, `due_date`, `last_premium_date`, `late_payment_charge`, `member_id`, `policy_id`, `premium_due_amount`) VALUES (2, '2021-07-15', '2021-02-21', 1000, 'member2', 'p2', 50000);
INSERT INTO member_premium (`member_premium_id`, `due_date`, `last_premium_date`, `late_payment_charge`, `member_id`, `policy_id`, `premium_due_amount`) VALUES (3, '2021-07-16', '2021-02-22', 1000, 'member3', 'p3', 60000);
