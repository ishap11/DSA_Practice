# Write your MySQL query statement below
SELECT Users.user_id ,
 CONCAT(UPPER(LEFT(name, 1)), LCASE(SUBSTRING(name, 2))) AS name
FROM Users
ORDER BY
Users.user_id ASC