use dvdLibrary;

insert into dvds (title,description) values ('',''); -- Create
select id, title, description From dvds; -- Read All 
select id, title, description From dvds where id = 0;	-- Read By Id
update dvds set title = '', description = '' where id = 0; -- Update 
delete from dvds where id = 0; -- Delete