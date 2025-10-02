# Write your MySQL query statement below
select round(sum(player_login_again)/count(distinct player_id) , 2) as fraction
from 
(select player_id , 
datediff(event_date , min(event_date) over(partition by player_id)) = 1 as player_login_again
from activity ) as new_table;

-- select as fraction
-- from
-- (select player_id , 
--        device_id , 
--        min(event_date) as first_login_date , 
--        games_played
-- from Activity
-- group by player_id) as new_table;