# Write your MySQL query statement below
select stu.student_id,stu.student_name,sub.subject_name,sum(case when e.student_id is not null then 1 else 0 end)as attended_exams
from students stu
cross join subjects sub
left join examinations e
on stu.student_id=e.student_id
and sub.subject_name=e.subject_name
group by stu.student_id,sub.subject_name
order by stu.student_id,sub.subject_name