# Write your MySQL query statement below
Select name , bonus
from Employee LEFT JOIN Bonus
on Employee.empId = Bonus.empId 
where bonus < 1000 or bonus is null;