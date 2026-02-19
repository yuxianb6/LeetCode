with ranking as(
    select *,dense_rank()over(partition by departmentId order by salary desc) as rn
    from employee
)
select d.name as Department,r.name as Employee,r.salary
from ranking r join department d
on r.departmentId=d.id
where r.rn<=3