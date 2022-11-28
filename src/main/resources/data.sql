create table Person
(
	id integer not null AUTO_INCREMENT,
	name varchar(255) not null,
	primary key(id)
);
create table Tour
(
	id integer not null auto_increment,
	name varchar(255) not null,
	primary key(id)
);

insert into Tour(id,name) values(1,'Gamla Stan');
insert into Tour(id,name) values(2,'Vasa Museum');
insert into Tour(id,name) values(3,'Gota Canal');
insert into Tour(id,name) values(4,'Kiruna and the Ice Hotel');