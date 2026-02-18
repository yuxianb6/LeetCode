# Write your MySQL query statement below
with prev as(
    select num,lag(num)over(order by id )as prev1,lag(num,2)over (order by id )as prev2
    from logs
)
select distinct num as ConsecutiveNums
from prev
where prev1=num and prev2=num
