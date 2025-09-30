# Write your MySQL query statement below
select 
    r.contest_id  , ROUND(COUNT(DISTINCT u.user_id)*100.0/ (SELECT COUNT(*) FROM users), 2) as percentage 
from users u
join register r
on u.user_id  = r.user_id 
GROUP BY r.contest_id
order by percentage desc , r.contest_id asc;