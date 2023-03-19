-- 7. The genres of movies that Christopher Lloyd has appeared in, sorted alphabetically.
-- (8 rows) Hint: DISTINCT will prevent duplicate values in your query results.

SELECT DISTINCT genre_name 
FROM genre 
JOIN movie_genre ON genre.genre_id = movie_genre.genre_id 
JOIN movie ON movie_genre.movie_id = movie.movie_id 
JOIN movie_actor ON movie_actor.movie_id = movie.movie_id
JOIN person ON person.person_id = movie_actor.actor_id
WHERE person_name ='Christopher Lloyd'
order by genre_name asc;

-- person_id = 1062
-- select * from person where person_name ='Christopher Lloyd';

-- select * from public.movie_actor where actor_id = 1062