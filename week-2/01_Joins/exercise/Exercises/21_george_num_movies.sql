-- 21. For every person in the person table with the first name of "George", list the number of movies they've been in. Name the count column 'num_of_movies'.
-- Include all Georges, even those that have not appeared in any movies. Display the names in alphabetical order. 
-- (59 rows)

select person_name, count(person_id) as num_of_movies
from movie_actor
left join movie on movie.movie_id = movie_actor.movie_id
left join person on person.person_id = movie_actor.actor_id -- or person.person_id = movie.director_id
where person_name like 'George %'
group by person_name, person_id
order by person_name asc; 

