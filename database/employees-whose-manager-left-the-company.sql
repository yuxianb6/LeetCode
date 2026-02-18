select e1.employee_id
from employees e1
where salary<30000
and (not exists(
    select 1
    from employees e2
    where e1.manager_id=e2.employee_id
) and manager_id is not null)