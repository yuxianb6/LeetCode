
with reports as(
    select reports_to ,count(employee_id) as reports_count ,round(avg(age),0) as average_age
    from employees
    group by reports_to
)
select r.reports_to as employee_id,e.name,r.reports_count,r.average_age
from reports r
join employees e
on r.reports_to=e.employee_id



