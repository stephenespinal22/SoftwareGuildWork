Use dvdLibrary;


insert into directors(DirectorName) values (?);
select DirectorId,DirectorName from directors;
select DirectorId,DirectorName from directors where DirectorId = ?; 
update directors set DirectorName = ? where DirectorId = ?;
delete from directors where DirectorId = ?;