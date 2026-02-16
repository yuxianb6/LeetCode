# Write your MySQL query statement below
with first_order as(
    select *
    from (
        select
            customer_id,
            delivery_id,
            order_date,
            row_number() over(
                partition by customer_id
                order by order_date
            ) as rn
        from delivery
    ) t
    where rn = 1
)

select round(sum(case when d.order_date=d.customer_pref_delivery_date then 1 else 0 end)*100/count(distinct f.delivery_id),2) as immediate_percentage
from first_order f
left join delivery d
on d.delivery_id=f.delivery_id
-- select *
-- from first_order