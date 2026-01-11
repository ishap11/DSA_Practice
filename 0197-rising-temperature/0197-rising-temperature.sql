# Write your MySQL query statement below
select w2.id
from Weather w1
inner join Weather w2
on w2.recordDate = DATE_ADD(w1.recordDate , interval 1 day)
where  w2.temperature > w1.temperature;