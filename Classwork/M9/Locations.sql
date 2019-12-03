Use SuperHero;

-- insert into Locations (`name`, `description`, address, longitude, latitude) values ('starbucks','nice place','123 street ave','29.123456','32.123456');
-- SELECT locationId, `name`, `description`, address, longitude, latitude FROM Locations WHERE locationId = 1;
-- UPDATE Locations SET `name` = 'star', `description` = 'bad place', address = '345 ave street', longitude = '-29.012345', latitude = '21.123456' WHERE locationId = 1;
-- DELETE FROM LOCATIONS WHERE locationId = 1;

insert into Sightings (`description`, address, longitude, latitude) values ('starbucks','nice place','123 street ave','29.123456','32.123456');
SELECT locationId, `name`, `description`, address, longitude, latitude FROM Locations WHERE locationId = 1;
-- UPDATE Locations SET `name` = 'star', `description` = 'bad place', address = '345 ave street', longitude = '-29.012345', latitude = '21.123456' WHERE locationId = 1;
-- DELETE FROM LOCATIONS WHERE locationId = 1;