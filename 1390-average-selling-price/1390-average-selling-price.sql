# Write your MySQL query statement below
Select Prices.product_id , IFNULL(round(SUM(price * units) / SUM(units),2 ),0)as average_price
FROM Prices LEFT JOIN UnitsSold 
ON Prices.product_id = UnitsSold.product_id and
UnitsSold.purchase_date between start_date and end_date
group by product_id