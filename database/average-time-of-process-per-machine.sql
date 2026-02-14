# Write your MySQL query statement below
with process as(
    select s.machine_id,s.process_id,(e.timestamp-s.timestamp) as time
    from activity s
    join activity e
    on s.machine_id=e.machine_id
    and s.process_id=e.process_id
    and s.activity_type='start'
    and e.activity_type='end'
)
select machine_id,cast(avg(time) as DECIMAL(10,3)) as processing_time
from process
group by machine_id