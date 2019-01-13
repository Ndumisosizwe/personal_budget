-- periods
INSERT INTO budget_period VALUES
  (1, 'NBS MHLONGO', now(), 'JUNE', 2018),
  (2, 'NBS MHLONGO', now(), 'JULY', 2018),
  (3, 'NBS MHLONGO', now(), 'AUGUST', 2018),
  (4, 'NBS MHLONGO', now(), 'SEPTEMBER', 2018),
  (5, 'NBS MHLONGO', now(), 'OCTOBER', 2018);

-- budgets
INSERT INTO budget VALUES (1, 'NBS MHLONGO', now(), 10040, 0.0, 1);
INSERT INTO budget VALUES (2, 'NBS MHLONGO', now(), 9441, 0.0, 2);
INSERT INTO budget VALUES (3, 'NBS MHLONGO', now(), 10040, 0.0, 3);
INSERT INTO budget VALUES (4, 'NBS MHLONGO', now(), 7387, 0.0, 4);

-- transactions in JUNE 2018
INSERT INTO transaction VALUES
  (1, 'NBS MHLONGO', now(), 17300, 'Monthly Salary (Nett)', 'INCOME', 1),
  (2, 'NBS MHLONGO', now(), 2700, 'Car Installment MFC', 'EXPENSE', 1),
  (3, 'NBS MHLONGO', now(), 1060, 'Car Insurance Mi Way', 'EXPENSE', 1),
  (4, 'NBS MHLONGO', now(), 3500, 'Monthly Rental', 'EXPENSE', 1);

-- transactions in JULY 2018
INSERT INTO transaction VALUES
  (5, 'NBS MHLONGO', now(), 17300, 'Monthly Salary (Nett)', 'INCOME', 2),
  (6, 'NBS MHLONGO', now(), 2700, 'Car Installment MFC', 'EXPENSE', 2),
  (7, 'NBS MHLONGO', now(), 1060, 'Car Insurance Mi Way', 'EXPENSE', 2),
  (8, 'NBS MHLONGO', now(), 3500, 'Monthly Rental', 'EXPENSE', 2),
  (9, 'NBS MHLONGO', now(), 300, 'NSFAS Repayment', 'EXPENSE', 2),
  (10, 'NBS MHLONGO', now(), 299, 'Planet Fitness Gym', 'EXPENSE', 2);

-- transactions in AUGUST 2018
INSERT INTO transaction VALUES
  (11, 'NBS MHLONGO', now(), 17300, 'Monthly Salary (Nett)', 'INCOME', 3),
  (12, 'NBS MHLONGO', now(), 2700, 'Car Installment MFC', 'EXPENSE', 3),
  (13, 'NBS MHLONGO', now(), 1060, 'Car Insurance Mi Way', 'EXPENSE', 3),
  (14, 'NBS MHLONGO', now(), 3500, 'Monthly Rental', 'EXPENSE', 3);

-- transactions in SEPTEMBER 2018
INSERT INTO transaction VALUES
  (15, 'NBS MHLONGO', now(), 24297, 'Nett Salary', 'INCOME', 4),
  (16, 'NBS MHLONGO', now(), 2700, 'Car Installment MFC', 'EXPENSE', 4),
  (17, 'NBS MHLONGO', now(), 1060, 'Car Insurance Mi Way', 'EXPENSE', 4),
  (18, 'NBS MHLONGO', now(), 4000, 'Monthly Rental', 'EXPENSE', 4),
  (19, 'NBS MHLONGO', now(), 1000, 'Discovery Medical Aid', 'EXPENSE', 4),
  (20, 'NBS MHLONGO', now(), 1200, 'Telkom Mobile & LTE', 'EXPENSE', 4),
  (21, 'NBS MHLONGO', now(), 1500, 'FNB Credit Card Repayment', 'EXPENSE', 4),
  (22, 'NBS MHLONGO', now(), 300, 'NSFAS Repayment', 'EXPENSE', 4),
  (23, 'NBS MHLONGO', now(), 650, 'Fuel for new month (October)', 'EXPENSE', 4),
  (24, 'NBS MHLONGO', now(), 2500, 'Allan Gray Retirement Annuity', 'EXPENSE', 4),
  (25, 'NBS MHLONGO', now(), 2000, 'Savings Flexi', 'EXPENSE', 4);







