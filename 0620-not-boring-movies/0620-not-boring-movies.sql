# Write your MySQL query statement below
Select *
from Cinema
where description != "boring" and id%2 != 0 
Order by rating desc