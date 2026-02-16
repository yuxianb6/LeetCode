select activity_date as day,count(distinct user_id)as active_users
from activity
-- where activity_date > DATE_SUB('2019-07-27', INTERVAL 30 DAY)
where activity_date > '2019-07-27'- INTERVAL 30 DAY
and activity_date<='2019-07-27'
group by activity_date

