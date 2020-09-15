create table country(
	id int primary key auto_increment not null,
    country_name char(40) unique 
    
)Engine=InnoDB;

create table star(
		id int primary key auto_increment not null,
        first_name varchar(40),
        last_name varchar(40),
        country_id int
        
)Engine=InnoDB;


create table creator(
	id int primary key auto_increment not null,
    first_name varchar(40),
    last_name varchar(40),
    country_id int
    
)Engine=InnoDB;

create table movie(
	id int primary key auto_increment not null,
    name nvarchar(255) unique,
	year int(11),
    runtime int unsigned 
    
)Engine=InnoDB;


create table series(
	id int primary key auto_increment not null,
    name nvarchar(255) unique,
    year int(11),
    runtime int unsigned 
)Engine=InnoDB;


create table cartoon(
	id int primary key auto_increment not null,
    name nvarchar(255) unique,
    year int(11),
    runtime int unsigned     
)Engine=InnoDB;

create table movie_star(
	id int primary key auto_increment not null,
    movie_id int,
    star_id int,
    
    foreign key (movie_id) references movie(id),
    foreign key (star_id) references star(id)
)Engine=InnoDB;


create table series_star(
	id int primary key auto_increment not null,
    series_id int,
    star_id int,
    
    foreign key (series_id) references series(id),
    foreign key (star_id) references star(id)
)Engine=InnoDB;

create table cartoon_creator(
	id int primary key not null auto_increment,
    cartoon_id int,
    creator_id int,
    
    foreign key(cartoon_id) references cartoon(id),
    foreign key(creator_id) references creator(id)
)Engine=InnoDB;

create table genre(
	id int primary key not null auto_increment,
    name varchar(30) unique
)Engine=InnoDB;

create table movie_genre(
	id int primary key not null auto_increment,
    movie_id int,
    genre_id int,
    foreign key(movie_id) references movie(id),
    foreign key (genre_id) references genre(id)
)Engine=InnoDB;

create table series_genre(
	id int primary key not null auto_increment,
    series_id int,
    genre_id int,
    
    foreign key(series_id) references series(id),
    foreign key (genre_id) references genre(id)
)Engine=InnoDB;

create table cartoon_genre(
	id int primary key not null auto_increment,
    cartoon_id int,
    genre_id int,
    
    foreign key(cartoon_id) references cartoon(id),
    foreign key (genre_id) references genre(id)
)Engine=InnoDB;

