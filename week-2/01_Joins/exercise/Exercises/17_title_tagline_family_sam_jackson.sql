-- 17. The titles and taglines of movies that are in the "Family" genre that Samuel L. Jackson has acted in.
-- Order the results alphabetically by movie title.
-- (4 rows)

select title, tagline
from movie
join movie_actor on movie.movie_id = movie_actor.movie_id
join movie_genre on movie.movie_id = movie_genre.movie_id
join genre on movie_genre.genre_id = genre.genre_id
join person on movie_actor.actor_id = person.person_id
where genre_name = 'Family'
and person_name = 'Samuel L. Jackson'
order by title asc;
