# Write your MySQL query statement below
select 
    DATE_FORMAT(trans_date, '%Y-%m') AS month, 
    country , 
    COUNT(id) as trans_count , 
    SUM(if(state = 'approved' , 1, 0)) as approved_count , 
    SUM(amount) as trans_total_amount , 
    SUM(IF(state='approved', amount, 0)) as approved_total_amount

from Transactions 
group by month , country;