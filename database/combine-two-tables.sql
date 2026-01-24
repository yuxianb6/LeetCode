# Write your MySQL query statement below
select lastName,firstName,city,state
from person p left join address a
on p.personId=a.personId