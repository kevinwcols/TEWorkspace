-- 11. The titles of the movies in the "Star Wars Collection" ordered by release date, most recent first. 
-- (9 rows)

select title
from movie
join collection on movie.collection_id = collection.collection_id
where collection_name = 'Star Wars Collection'
order by release_date desc;
