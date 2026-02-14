# Write your MySQL query statement below
select id
from weather w
where exists(
    select 1
    from weather w2
    where w.recordDate=w2.recordDate+interval 1 day
    and w.temperature>w2.temperature
)