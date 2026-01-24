# Write your MySQL query statement below
select user_id as buyer_id,join_date,count(order_id) as orders_in_2019
from users left join orders o
on users.user_id=o.buyer_id
   AND o.order_date >= '2019-01-01'
   AND o.order_date <  '2020-01-01'
group by user_id