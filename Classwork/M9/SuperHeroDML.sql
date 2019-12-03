Use SuperHero;

 -- insert into Locations (`name`, `description`, address, longitude, latitude) values ('starbucks','nice place','123 street ave','29.123456','32.123456');
 SELECT locationId, `name`, `description`, address, longitude, latitude FROM Locations WHERE locationId = 1;
-- UPDATE Locations SET `name` = 'star', `description` = 'bad place', address = '345 ave street', longitude = '-29.012345', latitude = '21.123456' WHERE locationId = 1;
-- DELETE FROM LOCATIONS WHERE locationId = 1;

-- insert into Sightings (`description`, locationId, sightingDate) values ('doing a cool flip',2,'2019/10/14 2:40');
SELECT sightingId, `description`, locationId, sightingDate FROM Sightings ORDER BY STR_TO_DATE(sightingDate, '%m/%d/%Y %h:%i %p') DESC;
UPDATE Sightings SET `description` = 'a really good fight', locationId = 1, sightingDate = '2019/10/22' WHERE sightingId = 1;
-- DELETE FROM Sightings WHERE sightingId = 1;

-- insert into Organizations (`name`,`description`, contactInfo) values ('Justice League','super cool guys','555-555-5555');
SELECT orgId, `name`,`description`, contactInfo FROM Organizations WHERE orgId = 1;
-- DELETE FROM Sightings WHERE sightingId = 1;

SELECT loc.locationId, `name`, loc.`description`, address, longitude, latitude, sightingId, Sightings.`description`, sightingDate FROM Locations AS loc JOIN Sightings 
ON loc.locationId = Sightings.locationId WHERE sightingId = 8;


Select org.orgId, `name`,`description`, contactInfo FROM Organizations as org JOIN SuperPersonOrganization as spo ON org.orgId = spo.orgId Where spo.superId = 5;


-- Update SuperPersons Set imagePath = '/images/spiderman.jpg' Where superId = 1;

SELECT loc.locationId, `name`, loc.`description`, address, longitude, latitude, Sightings.sightingId, Sightings.`description`, sightingDate FROM Locations AS loc JOIN Sightings ON loc.locationId = Sightings.locationId WHERE loc.locationId = 1;



