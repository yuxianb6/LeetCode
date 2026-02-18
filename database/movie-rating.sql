with user_cnt as(
    select user_id,count(movie_id) as cnt
    from movieRating
    group by user_id
),
user_greatest as(
    select u.name
    from users u join user_cnt c
    on u.user_id=c.user_id
    order by c.cnt desc,u.name asc
    limit 1
),
febrating as(
    select movie_id,avg(rating) as rating
    from movieRating
    where created_at>'2020-01-31' and created_at<'2020-03-01'
    group by movie_id
),
movie_highest as(
    select title
    from movies m join febrating f
    on m.movie_id=f.movie_id
    order by f.rating desc,m.title asc
    limit 1
)
select name as results
from user_greatest
union all
select *  from movie_highest