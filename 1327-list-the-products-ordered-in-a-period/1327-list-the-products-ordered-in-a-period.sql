# Write your MySQL query statement below
select p.product_name , sum(o.unit)  as unit
from Products as p
JOIN orders as o
on p.product_id = o.product_id 
and o.order_date LIKE '2020-02-%' 
GROUP BY p.product_name
HAVING SUM(o.unit) >= 100;
