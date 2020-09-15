insert into country(country_name)
values
('France'),
('USA'),
('Bosnia and Herzegovina'),
('Croatia'),
('Serbia'),
('England'),
('Italy'),
('Mexico'),
('Germany'),
('Albania'),
('Greece'),
('Portugal'),
('Poland'),
('Russia'),
('Macedonia'),
('Slovenia');


Select * from star inner join country on star.country_id=country.id;

Insert into star(first_name,last_name,country_id) values ('Leonardo','DiCaprio',2);
Insert into star(first_name,last_name,country_id) values ('Joaquin','Phoenix',2);
Insert into star(first_name,last_name,country_id) values ('Steve','Carrell',2);
Insert into star(first_name,last_name,country_id) values ('Til','Schweiger',9);
Insert into star(first_name,last_name,country_id) values ('Branko','Djuric',3);
Insert into star(first_name,last_name,country_id) values ('Nikola','Kojo',5);
Insert into star(first_name,last_name,country_id) values ('Ivo','Gregurevic',4);
Insert into star(first_name,last_name,country_id) values ('Sebastian','Cavazza',16);

Select * from movie;
insert into movie(name,year,runtime) values 
('The Wolf of Wall Street',2013,180),
('Once Upon a Time in Hollywood',2019,160),
('The Reveant',2015,154),
('Inception',2010,162),
('Catch Me If You Can',2002,141),
('Joker',2019,122),
('Get Smart',2008,95),
('One Way',2006,114),
('No Mans Land',2001,98),
('We are not Angels',1992,98),
('Ungiven',2015,90),
('AI Rising',2018,90);

insert into series(name,year,runtime) values
('The Wolf of Wall Street',2013,180),
('Once Upon a Time in Hollywood',2019,160),
('The Reveant',2015,154),
('Inception',2010,162),
('Catch Me If You Can',2002,141),
('Joker',2019,122),
('Get Smart',2008,95),
('One Way',2006,114),
('No Mans Land',2001,98),
('We are not Angels',1992,98),
('Ungiven',2015,90),
('AI Rising',2018,90);

Insert into series(name,year,seasons) values
('The office',2005,9),
('Space force',2020,1),
('Just shoot me!',1997,7),
('Dark',2017,3),
('Stranger Things',2016,3),
('Narcos',2018,2),
('Peaky Blinders',2013,5),
('Modern Family',2009,11),
('Mindhunter',2017,2),
('Brooklyn Nine-Nine',2013,7);


select * from creator;
insert into creator(first_name,last_name,country_id) values
('Matt','Groening',2),
('René','Goscinny',1),
('Mike','Judge',2),
('Tex','Avery',2),
('Charles','Schulz',2),
('Seth','MacFarlane',2),
('Walt','Disney',2),
('Elsie','Segar',2),
('Stephen','Hillenburg',2);

select * from cartoon;
alter table cartoon drop runtime;
alter table cartoon add seasons int unsigned;
insert into cartoon (name,year,seasons) values
('Family guy',1999,19),
('South Park',1997,23),
('Asterix',1959,3),
('The Looney Tunes Show',2011,2),
('Mickey Mouse',2013,5),
('DuckTales',2017,3),
('Spongebob SquarePants',1999,12);

select * from genre;
insert into genre(name) values
('Action'),
('Comedy'),
('Thriller'),
('Horror'),
('Mystery'),
('Romance'),
('Fantasy'),
('Drama');
Select * from genre;
insert into genre(name) values ('Adventure');
Select * from movie_genre;

insert into movie_genre(movie_id,genre_id) values
(1,2),
(1,11),
(2,2),
(2,8),
(3,9),
(3,12),
(4,1),
(4,10),
(5,11),
(6,11),
(6,8),
(7,2),
(7,1),
(8,3),
(8,5),
(9,8),
(10,2),
(11,8),
(12,10),
(12,6);

select * from series;
insert into genre(name) values ('Animation');

insert into series_genre(series_id,genre_id) values
(1,13),
(2,2),
(3,13),
(4,5),
(5,4),
(6,11),
(7,11),
(8,13),
(9,11),
(10,13);

insert into cartoon_genre(cartoon_id,genre_id) values
(1,13),
(2,14),
(3,14),
(4,14),
(5,2),
(6,2),
(7,14);
