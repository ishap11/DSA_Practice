# Write your MySQL query statement below
select s.year , s.price , p.product_name
from Sales AS s JOIN Product AS p
ON s.product_id = p.product_id;