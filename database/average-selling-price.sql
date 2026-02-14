# Write your MySQL query statement below
select p.product_id,(case when sum(u.units)=0 then 0.00 else round(sum(u.units*p.price)/sum(u.units),2) end) as average_price
from prices p
left join unitssold u
on p.product_id=u.product_id
and u.purchase_date>=p.start_date
and u.purchase_date<=p.end_date
group by p.product_id