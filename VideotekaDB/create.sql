create table Country(
	country_id int primary key auto_increment not null,
    name char(40)
    
);

create table Actor(
		actor_id int primary key auto_increment not null,
        firstName char(40),
        lastName char(40),
        DoB date,
        country_id int,
        
        Foreign key(country_id) references Country(country_id)
);

create table Creator(
	creator_id int primary key auto_increment not null,
    firstName char(40),
    lastName char(40),
    DoB date,
    country_id int,
    
    Foreign key(country_id) references Country(country_id)
);

create table Movie(
	movie_id int primary key auto_increment not null,
    movieName nvarchar(40),
    actor_id int,
    
    Foreign key(actor_id) references Actor(actor_id)
);


create table Series(
	series_id int primary key auto_increment not null,
    seriesName nvarchar(40),
    actor_id int,
    
    Foreign key(actor_id) references Actor(actor_id)
);


create table Anime(
	anime_id int primary key auto_increment not null,
    animeName nvarchar(40),
    creator_id int,
    
    Foreign key(creator_id) references Creator(creator_id)
);

create table Entertainment(
	entertainment_id int primary key auto_increment not null,
    movie_id int,
    series_id int,
    anime_id int,
    
    foreign key(movie_id) references Movie(movie_id),
    foreign key(series_id) references Series(series_id),
    foreign key(anime_id) references Anime(anime_id)
    
);
