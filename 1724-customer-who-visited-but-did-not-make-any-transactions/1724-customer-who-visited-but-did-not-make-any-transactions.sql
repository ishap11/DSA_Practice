# Write your MySQL query statement below
select v.customer_id , COUNT(*) AS count_no_trans
FROM Visits v LEFT JOIN Transactions t
ON v.visit_id = t.visit_id
WHERE t.transaction_id IS NULL
group by  v.customer_id;