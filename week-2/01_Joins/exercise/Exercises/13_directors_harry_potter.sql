-- 13. The directors of the movies in the "Harry Potter Collection", sorted alphabetically.
-- (4 rows)

select distinct person_name
from movie
join collection on movie.collection_id = collection.collection_id
join person on movie.director_id = person.person_id
where collection_name = 'Harry Potter Collection'
order by person_name asc;
