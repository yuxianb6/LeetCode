with cleaned as(
    select c.customer_id,count(distinct c.product_key) as cnt
    from product p
    join customer c
    on p.product_key=c.product_key
    group by c.customer_id
)
select customer_id
from cleaned
where cnt>=(
    select count(distinct product_key)
    from product
)