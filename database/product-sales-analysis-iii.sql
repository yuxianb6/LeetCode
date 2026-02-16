with first_year as(
    select product_id,min(year) as year
    from sales
    group by product_id
)
select f.product_id,f.year as first_year,s.quantity,s.price
from first_year f
join sales s
on f.product_id=s.product_id
and f.year=s.year