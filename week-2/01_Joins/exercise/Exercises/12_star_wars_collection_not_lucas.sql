-- 12. The titles of the movies in the "Star Wars Collection" that weren't directed by George Lucas, sorted alphabetically.
-- (5 rows)

select title
from movie
join collection on movie.collection_id = collection.collection_id
join person on movie.director_id = person.person_id
where collection_name = 'Star Wars Collection'
and person_name <> 'George Lucas'
order by title asc;
