-- 14. The names of actors who've appeared in the movies in the "Back to the Future Collection", sorted alphabetically.
-- (28 rows)

select distinct person_name
from movie
join collection on movie.collection_id = collection.collection_id
join movie_actor on movie.movie_id = movie_actor.movie_id
join person on movie_actor.actor_id = person.person_id
where collection_name = 'Back to the Future Collection'
order by person_name asc;
