# Write your MySQL query statement below
Select m.name
from Employee e JOIN Employee m  where e.managerId = m.id 
group by e.managerId
having count(*) >=5