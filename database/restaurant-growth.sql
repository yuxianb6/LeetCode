with cnt as(
    select visited_on,sum(amount)as cnt
    from customer
    group by visited_on
),
t as(
    select row_number() over(order by visited_on)as rn,visited_on,sum(cnt)over (order by visited_on rows  between 6 preceding and current row)as amount,round(avg(cnt)over (order by visited_on rows  between 6 preceding and current row),2)as average_amount
    from cnt
    order by visited_on
)
select visited_on,amount,average_amount
from t
where rn>=7
