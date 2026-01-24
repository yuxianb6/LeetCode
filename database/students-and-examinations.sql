# Write your MySQL query statement below
select s.student_id,s.student_name,sub.subject_name,coalesce(count(e.subject_name),0) as attended_exams
from students s cross join subjects sub left join examinations e
on sub.subject_name=e.subject_name and s.student_id=e.student_id
group by s.student_id,sub.subject_name
order by s.student_id,s.student_name,sub.subject_name