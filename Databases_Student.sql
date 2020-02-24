CREATE database student;
use student;

CREATE TABLE person (
id int not null,
nama varchar (100),
birth_place varchar (51),
birth_date date,
Age int(100),
PRIMARY KEY(id)
);

CREATE TABLE gender (
id int not null,
name_gender varchar (100),
PRIMARY KEY(id)
);

insert into person values (1, 'Flo', 'Jakarta', '1998-06-03', '21');
insert into person values (2, 'Arum', 'Surabaya', '1999-09-01', '20');
insert into person values (3, 'Vio', 'Bandung', '2001-07-04', '18');
insert into person values (4, 'Grak', 'Tangerang', '2000-02-01', '19');
insert into person values (5, 'Raz', 'Purwokerto', '2002-08-07', '17');
insert into person values (6, 'Raz', 'Purwokerto', '2002-08-07', '17');

select * from person;
select * from gender;

insert into gender values (1, 'Laki-Laki');
insert into gender values (2, 'Perempuan');

alter table person drop age;

alter table `person` add foreign key (id_gender) references `gender`(id);

alter table person add id_gender varchar(100);

update person set id_gender = '1' where id = 1;
update person set id_gender = '2' where id = 2;
update person set id_gender = '1' where id = 3;
update person set id_gender = '1' where id = 4;
update person set id_gender = '2' where id = 5;

#inner join :
select * from `person` inner join `gender` on `person`.`id_gender` = `gender`.`id`;
#student gender laki-laki :
select * from `person` inner join `gender` on `person`.`id_gender` = `gender`.`id` where id_gender = 1;
#student gender perempuan :
select * from `person` inner join `gender` on `person`.`id_gender` = `gender`.`id` where id_gender = 2;

#tampil usia :
select *, year(curdate()) - year(birth_date) as age from person;

#usia lebih dari 20 tahun :
select * from person where year(curdate()) - year(birth_date) > 20;

#usia kurang dari 18 tahun :
select * from person where year(curdate()) - year(birth_date) < 18;

#birth_place di jakarta :
select * from person where birth_place = 'jakarta'; 

#birth_place di jakarta, laki - laki, usia 20 tahun :
select * from person where birth_place = 'jakarta' and id_gender = 1 and timestampdiff(year, birth_date, curdate()) >= 20;

#birth_place in jakarta or bandung and male gender :
select * from person where birth_place = 'jakarta' or birth_place = 'bandung' and id_gender = 1 and timestampdiff(year, birth_date, curdate()) >= 20;

