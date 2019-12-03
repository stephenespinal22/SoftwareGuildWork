use PersonalTrainer;

-- Use an aggregate to count the number of Clients.
-- 500 rows

SELECT
COUNT(client.clientid)
FROM Client;

-- Use an aggregate to count Client.BirthDate.
-- The number is different than total Clients. Why?
-- 463 rows


SELECT
COUNT(Client.Birthdate)
FROM Client;

-- Group Clients by City and count them.
-- Order by the number of Clients desc.
-- 20 rows
-- ------------------

SELECT 
COUNT(Client.clientid)
FROM Client
GROUP BY Client.City;

-- Calculate a total per invoice using only the InvoiceLineItem table.
-- Group by InvoiceId.
-- You'll need an expression for the line item total: Price * Quantity.
-- Aggregate per group using SUM().
-- 1000 rows
-- ------------------

SELECT
	InvoiceId,
    SUM(Price * Quantity) InvoiceTotal
FROM InvoiceLineItem
GROUP BY InvoiceId;

-- Calculate a total per invoice using only the InvoiceLineItem table.
-- (See above.)
-- Only include totals greater than $500.00.
-- Order from lowest total to highest.
-- 234 rows
-- ------------------

SELECT
	InvoiceId,
    SUM(Price * Quantity) InvoiceTotal
FROM InvoiceLineItem
GROUP BY InvoiceId
HAVING InvoiceTotal > 500
ORDER BY InvoiceTotal ASC;

-- Calculate the average line item total
-- grouped by InvoiceLineItem.Description.
-- 3 rows
-- ------------------

SELECT
	Description,
    AVG(Price * Quantity) AvgTotal
FROM InvoiceLineItem
GROUP BY Description;


-- Select ClientId, FirstName, and LastName from Client
-- for clients who have *paid* over $1000 total.
-- Paid is Invoice.InvoiceStatus = 2.
-- Order by LastName, then FirstName.
-- 146 rows
-- ------------------

SELECT 
c.clientId, c.FirstName, c.LastName,
SUM(ilt.price * ilt.quantity) total
FROM `Client` as c
INNER JOIN Invoice as i on c.clientid = i.clientid
INNER JOIN InvoiceLineItem as ilt on i.invoiceid = ilt.invoiceid
where i.invoicestatus = 2
Group by c.clientid
having total > 1000 
Order BY c.lastname, c.firstname;

-- Count exercises by category.
-- Group by ExerciseCategory.Name.
-- Order by exercise count descending.
-- 13 rows
-- ------------------

SELECT 
ec.name,
COUNT(e.exerciseid) totalAmount
FROM ExerciseCategory as ec
inner join exercise as e on e.exercisecategoryid = ec.exercisecategoryid
group by ec.`name`
order by totalamount desc;

-- Select Exercise.Name along with the minimum, maximum,
-- and average ExerciseInstance.Sets.
-- Order by Exercise.Name.
-- 64 rows
-- ------------------

SELECT
e.`name`,
MIN(ei.sets),
MAX(ei.sets),
AVG(ei.sets)
FROM exercise as e 
inner join exerciseInstance as ei on e.exerciseid = ei.exerciseid
-- group by id here and not name first becuase name might be null
group by e.exerciseid,e.name
order by e.name;

-- Find the minimum and maximum Client.BirthDate
-- per Workout.
-- 26 rows
-- Sample: 
-- WorkoutName, EarliestBirthDate, LatestBirthDate
-- '3, 2, 1... Yoga!', '1928-04-28', '1993-02-07'
-- ------------------

SELECT
w.name,
MIN(c.BirthDate) as EarliestBirthdate,
MAX(c.BirthDate) as LatestBirthdate
FROM `CLient` as c
inner join clientworkout as cw on c.clientid = cw.clientid
inner join workout as w on cw.workoutid = w.workoutid
group by w.workoutid,w.name;

-- Count client goals.
-- Be careful not to exclude rows for clients without goals.
-- 500 rows total
-- 50 rows with no goals
-- ------------------

SELECT 
client.clientid,
Count(clientgoal.goalid) 
FROM client
left join clientGoal on  clientgoal.clientid = client.clientid
group by client.clientid;


-- Select Exercise.Name, Unit.Name, 
-- and minimum and maximum ExerciseInstanceUnitValue.Value
-- for all exercises with a configured ExerciseInstanceUnitValue.
-- Order by Exercise.Name, then Unit.Name.
-- 82 rows
-- ------------------

SELECT 
e.name, u.name,
MIN(uv.`value`) as 'min value',
MAX(uv.`value`) as 'max value'
FROM Exercise e
INNER JOIN ExerciseInstance ei 
	ON e.ExerciseId = ei.ExerciseId
INNER JOIN ExerciseInstanceUnitValue uv 
	ON ei.ExerciseInstanceId = uv.ExerciseInstanceId
INNER JOIN Unit u ON uv.UnitId = u.UnitId
GROUP BY e.ExerciseId, e.`Name`, u.UnitId, u.`Name`
ORDER BY e.`Name`, u.`Name`;

-- Modify the query above to include ExerciseCategory.Name.
-- Order by ExerciseCategory.Name, then Exercise.Name, then Unit.Name.
-- 82 rows
-- -----------------

SELECT 
e.name as 'exercise name',
 u.name 'unit name',
 ec.name'exercise category name',
MIN(uv.`value`) as 'min value',
MAX(uv.`value`) as 'max value'
FROM Exercise e
INNER JOIN ExerciseInstance ei 
	ON e.ExerciseId = ei.ExerciseId
INNER JOIN ExerciseInstanceUnitValue uv 
	ON ei.ExerciseInstanceId = uv.ExerciseInstanceId
INNER JOIN Unit u ON uv.UnitId = u.UnitId
INNER JOIN ExerciseCategory ec ON ec.exercisecategoryId = e.exercisecategoryId
GROUP BY e.ExerciseId, e.`Name`, u.UnitId, u.`Name`
ORDER BY ec.`name`, e.`Name`, u.`Name`;

-- Select the minimum and maximum age in years for
-- each Level.
-- To calculate age in years, use the MySQL function DATEDIFF.
-- 4 rows
-- ------------------

SELECT
	l.`Name` LevelName,
	MIN(DATEDIFF(CURDATE(), c.BirthDate) / 365) MinAge,
    MAX(DATEDIFF(CURDATE(), c.BirthDate) / 365) MaxAge
FROM Level as l
INNER JOIN Workout as w ON l.levelid = w.levelid
INNER JOIN ClientWorkout as cw ON cw.workoutid = w.workoutid
INNER JOIN `CLient` as c on c.clientid = cw.clientid
GROUP BY l.levelid, l.name
ORDER BY MinAge;

-- Stretch Goal!
-- Count logins by email extension (.com, .net, .org, etc...).
-- Research SQL functions to isolate a very specific part of a string value.
-- 27 rows (27 unique email extensions)
-- ------------------


-- SUBSTRING_INDEX(string, delimiter, number)
SELECT
	SUBSTRING_INDEX(EmailAddress, '.', -1) tld,
COUNT(l.emailaddress) as number
From Login as l
Group by tld;

-- Stretch Goal!
-- Match client goals to workout goals.
-- Select Client FirstName and LastName and Workout.Name for
-- all workouts that match at least 2 of a client's goals.
-- Order by the client's last name, then first name.
-- 139 rows
-- ------------------

SELECT
	w.`Name` WorkoutName,
    CONCAT(c.FirstName, ' ', c.LastName) ClientName,
    COUNT(cg.GoalId)
FROM Client c
INNER JOIN ClientGoal cg ON c.ClientId = cg.ClientId
INNER JOIN WorkoutGoal wg ON cg.GoalId = wg.GoalId
INNER JOIN Workout w ON wg.WorkoutId = w.WorkoutId
GROUP BY w.WorkoutId, w.`Name`, c.ClientId, c.FirstName, c.LastName
HAVING COUNT(cg.GoalId) > 1
ORDER BY c.LastName, c.FirstName;