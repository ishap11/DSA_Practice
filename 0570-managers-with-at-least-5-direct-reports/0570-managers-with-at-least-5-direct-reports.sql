# Write your MySQL query statement below
select m.name
from Employee as e 
join Employee as m
on e.managerId  = m.id
group by m.name , m.id
having count(e.id) >= 5;
