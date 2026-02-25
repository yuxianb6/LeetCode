with sum as(
    select person_id,person_name,turn,sum(weight)over(order by turn asc) as total
    from queue
)
select person_name
from sum 
where total=(
    select max(total)
    from sum
    where total<=1000 

)

