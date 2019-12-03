drop database if exists dvdLibrary;
Create database dvdLibrary;

Use dvdLibrary;

create table dvds( 
DvdId int primary key auto_increment,
Title varchar(50) not null, 
DirectorId int not null,

Description varchar(255) not null );

create table directors(

DirectorId int primary key auto_increment,
DirectorName varchar(50)

);

alter table dvds 
	add foreign key fk_dvds_directors(DirectorId) references directors(DirectorId);
    
insert into directors(DirectorName) values
('W.Sisters');

insert into dvds (Title, Description, DirectorId) values 
('The matrix', 'Whoa!',1), 
('The matrix Reloaded', 'Whoa reloaded!',1), 
('The matrix Revolution', 'Totally',1);
