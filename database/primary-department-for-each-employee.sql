# Write your MySQL query statement below
select employee_id,department_id
from employee
where primary_flag='Y'
or (primary_flag='N' and employee_id in(
    select employee_id
    from employee
    group by employee_id
    having count(department_id)=1
))