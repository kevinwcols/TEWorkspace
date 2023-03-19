-- 9. Remove "Memento" from the movie table
-- You'll have to remove data from two other tables before you can remove it (13 rows, 2 rows, 1 row)

-- Delete from movie_actor table:

DELETE FROM movie_actor -- delete records from movie_actor table
WHERE movie_id = -- where clause to get movie_id is equal to
(SELECT movie_id -- select column movie_id
FROM movie -- from movie table
WHERE title = 'Memento'); -- where clause to get movie title is 'Memento';


-- Delete from movie_genre table:

DELETE FROM movie_genre -- delete records from movie_genre table
WHERE movie_id = -- where clause to get movie_id is equal to
(SELECT movie_id -- select column movie_id
FROM movie -- from movie table
WHERE title = 'Memento'); -- where clause to get movie title is 'Memento';


-- Delete from movie table:

DELETE FROM movie -- delete from movie table
WHERE title = 'Memento'; -- where clause to get movie title is 'Memento'
