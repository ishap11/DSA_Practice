# Write your MySQL query statement below
-- select round(sum(player_login_again)/count(distinct player_id) , 2) as fraction
-- from 
-- (select player_id , 
-- datediff(event_date , min(event_date) over(partition by player_id)) = 1 as player_login_again
-- from activity ) as new_table;

SELECT 
    ROUND(COUNT(DISTINCT next_day.player_id) / COUNT(DISTINCT first_login.player_id),2) AS fraction
FROM (
    SELECT player_id, MIN(event_date) AS first_login_date
    FROM Activity
    GROUP BY player_id
) first_login
LEFT JOIN Activity next_day
    ON first_login.player_id = next_day.player_id
   AND next_day.event_date = first_login.first_login_date + INTERVAL 1 DAY;
