with qualified1 as(
    select i1.pid
    from insurance i1
    where exists(
        select 1
        from insurance i2
        where i1.pid<>i2.pid
        and i1.tiv_2015=i2.tiv_2015
    )
),
qualified2 as(
    select i1.pid
    from insurance i1
    where not exists(
        select 1
        from insurance i2
        where i1.pid<>i2.pid
        and i1.lon=i2.lon
        and i1.lat=i2.lat
    )
)
select round(sum(tiv_2016),2) as tiv_2016
from insurance
where pid in (select pid from qualified1)
and pid in (select pid from qualified2)