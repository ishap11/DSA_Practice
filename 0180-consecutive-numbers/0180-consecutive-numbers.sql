# Write your MySQL query statement below
select l1.num as ConsecutiveNums 
from Logs as l1
join Logs as l2
join logs as l3
on l1.num = l2.num AND l2.num = l3.num
where l1.id = l2.id + 1 AND l2.id = l3.id + 1
group by l1.num;
