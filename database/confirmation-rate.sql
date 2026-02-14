# Write your MySQL query statement below
with confirm as(
    select user_id,sum(case when action='confirmed' then 1 else 0 end)as confirms,count(action) as total
    from confirmations
    group by user_id
)
-- signup as(
--     select user_id,count(timestamp)as signs
--     from signups
--     group by user_id
-- ),
select s.user_id,(case when c.confirms is null then 0.00 else cast(c.confirms/c.total as DECIMAL(10,2)) end )as confirmation_rate
from signups s
left join confirm c
on s.user_id=c.user_id
