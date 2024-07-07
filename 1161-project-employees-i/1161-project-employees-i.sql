# Write your MySQL query statement below
Select project_id , ROUND(AVG(experience_years),2) as average_years
from Project LEFT JOIN Employee
On Project.employee_id = Employee.employee_id
group by project_id