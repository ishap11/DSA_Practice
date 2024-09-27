# Write your MySQL query statement below
SELECT 'Low Salary' as category,
count(account_id) as accounts_count
from Accounts where income<20000
UNION
SELECT 'Average Salary' as category,
count(account_id) as accounts_count
from Accounts where income>=20000 and income<=50000
UNION
SELECT 'High Salary' as category,
count(account_id) as accounts_count
from Accounts where income > 50000;