# Write your MySQL query statement below
select e2.name
from employee e2
where e2.id in(
    select e1.managerId
    from employee e1
    group by e1.managerId
    having count(e1.id)>=5
)