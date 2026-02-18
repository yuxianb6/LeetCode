with closest as(
    select product_id,max(change_date) as closest_date
    from products
    where change_date<='2019-08-16'
    group by product_id
),
list as(
    select distinct product_id
    from products
)
select l.product_id,(case when c.closest_date is not null then p.new_price else 10 end)as price
from list l left join closest c 
on l.product_id=c.product_id
left join products p
on c.product_id=p.product_id
and p.change_date=c.closest_date