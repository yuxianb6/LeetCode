select 
product_id,
coalesce(
    max(case when change_date<='2019-08-16' then new_price end),
    10
) as price
from products
group by product_id
