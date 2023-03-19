-- 4. Add a "Sports" genre to the genre table. Add the movie "Coach Carter" to the newly created genre. (1 row each)

-- insert the 'Sports' genre into the genre table
INSERT INTO genre(genre_name) VALUES ('Sports');

-- insert the movie 'Coach Carter' to the newly created genre('Sports')
INSERT INTO movie_genre(movie_id, genre_id)
VALUES ((SELECT movie_id FROM movie WHERE title = 'Coach Carter'), (SELECT genre_id FROM genre WHERE genre_name = 'Sports'));
