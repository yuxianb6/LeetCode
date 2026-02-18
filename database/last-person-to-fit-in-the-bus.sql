with ordered as(
    select turn, person_id,person_name,weight,sum(weight) over(order by turn rows between unbounded preceding and current row) total_weight
    from queue
    order by turn
)
select person_name
from ordered
where total_weight=(
    select max(total_weight)
    from ordered
    where total_weight<=1000
)