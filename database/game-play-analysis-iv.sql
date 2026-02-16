with first_log as(
    select player_id,min(event_date) as event_date
    from activity
    group by player_id
),second_day as(
    select a.player_id 
    from first_log f
    left join activity a
    on f.player_id=a.player_id
    and a.event_date=f.event_date+interval 1 day
)
select round(count(s.player_id)/count(f.player_id),2) as fraction
from first_log f
left join second_day s
on f.player_id=s.player_id