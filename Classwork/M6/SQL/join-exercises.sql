USE PersonalTrainer;

-- inverse inner join
-- SELECT
 --   Project.Name ProjectName,
 --   Worker.FirstName,
 --   Worker.LastName
-- FROM Project
-- LEFT OUTER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
-- LEFT OUTER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
-- WHERE ProjectWorker.WorkerId IS NULL; -- Throws out projects with workers.

-- Projects without workers, we only need the bridge table to confirm.
-- SELECT
--    Project.Name ProjectName
-- FROM Project
-- LEFT OUTER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
-- WHERE ProjectWorker.WorkerId IS NULL;

-- Select all columns from ExerciseCategory and Exercise.
-- The tables should be joined on ExerciseCategoryId.
-- This query returns all Exercises and their associated ExerciseCategory.
-- 64 rows

select *
from ExerciseCategory 
inner join Exercise on ExerciseCategory.ExerciseCategoryId = Exercise.ExerciseCategoryId;

    
-- Select ExerciseCategory.Name and Exercise.Name
-- where the ExerciseCategory does not have a ParentCategoryId (it is null).
-- Again, join the tables on their shared key (ExerciseCategoryId).
-- 9 rows

select
ExerciseCategory.`Name` , Exercise.`Name`
from ExerciseCategory
inner join Exercise on ExerciseCategory.ExerciseCategoryId = Exercise.ExerciseCategoryId
where ParentCategoryId is null;


-- The query above is a little confusing. At first glance, it's hard to tell
-- which Name belongs to ExerciseCategory and which belongs to Exercise.
-- Rewrite the query using an aliases. 
-- Alias ExerciseCategory.Name as 'CategoryName'.
-- Alias Exercise.Name as 'ExerciseName'.
-- 9 rows

select
c.`Name` , e.`Name`
from ExerciseCategory as c
inner join Exercise as e
	on c.ExerciseCategoryId = e.ExerciseCategoryId
where ParentCategoryId is null;

-- Select FirstName, LastName, and BirthDate from Client
-- and EmailAddress from Login 
-- where Client.BirthDate is in the 1990s.
-- Join the tables by their key relationship. 
-- What is the primary-foreign key relationship?
-- 35 rows

select 
c.FirstName,
c.LastName,
c.BirthDate,
l.EmailAddress
from `Client` as c
inner join Login as l on c.ClientId = l.ClientId
where c.BirthDate like '199%';

-- Select Workout.Name, Client.FirstName, and Client.LastName
-- for Clients with LastNames starting with 'C'?
-- How are Clients and Workouts related?
-- 25 rows

select 
w.`Name`,
c.FirstName,
c.LastName
from `Client` as c
inner join ClientWorkout as cw
	on c.ClientId = cw.ClientId
inner join Workout as w
	on cw.WorkoutId = w.WorkoutId
where c.LastName like 'C%';

-- Select Names from Workouts and their Goals.
-- This is a many-to-many relationship with a bridge table.
-- Use aliases appropriately to avoid ambiguous columns in the result.

select 
w.`Name`,
g.`Name`
from Workout as w
inner join WorkoutGoal as wg
	on w.WorkoutId = wg.workoutId
inner join Goal as g 
	on g.GoalId = wg.Goalid;


-- Select FirstName and LastName from Client.
-- Select ClientId and EmailAddress from Login.
-- Join the tables, but make Login optional.
-- 500 rows

select
c.firstname,
c.lastname,
l.clientId,
l.emailaddress
from `client` as c
left outer join login as l on c.clientid = l.clientid;


-- Using the query above as a foundation, select Clients
-- who do _not_ have a Login.
-- 200 rows

select
c.firstname,
c.lastname,
l.clientId,
l.emailaddress
from `client` as c
left outer join login as l on c.clientid = l.clientid
where l.clientId is null;

-- Does the Client, Romeo Seaward, have a Login?
-- Decide using a single query.
-- nope :(

select
c.firstname,
c.lastname,
ifnull(l.clientId,'[no login]') as hasLogin
from `client` as c
left outer join login as l on c.clientid = l.clientid
where c.firstname = 'Romeo' and c.lastname = 'Seaward';

-- Select ExerciseCategory.Name and its parent ExerciseCategory's Name.
-- This requires a self-join.
-- 12 rows

SELECT
	p.`Name` ParentCategory,
    ec.`Name` Category
FROM ExerciseCategory ec
INNER JOIN ExerciseCategory p 
	ON ec.ParentCategoryId = p.ExerciseCategoryId;
    
-- Rewrite the query above so that every ExerciseCategory.Name is
-- included, even if it doesn't have a parent.
-- 16 rows

SELECT
	p.`Name` ParentCategory,
    ec.`Name` Category
FROM ExerciseCategory ec
left JOIN ExerciseCategory p 
	ON ec.ParentCategoryId = p.ExerciseCategoryId;
    
-- Are there Clients who are not signed up for a Workout?
-- 50 rows

select 
c.firstname,
c.lastname,
ifnull(cw.workoutId, 'no') as hasWorkout
from `client` as c
left join clientworkout as cw on c.clientId = cw.clientId
where cw.workoutId is null;

-- Which Beginner-Level Workouts satisfy at least one of Shell Creane's Goals?
-- Goals are associated to Clients through ClientGoal.
-- Goals are associated to Workouts through WorkoutGoal.
-- 6 rows, 4 unique rows

select
w.`name`
from client as c
inner join clientgoal as cg on c.clientID = cg.clientid
inner join goal as g on g.goalid = cg.goalid
inner join workoutgoal as wg on wg.goalid = g.goalid
inner join workout as w on w.workoutid = wg.workoutid
where c.firstname = 'Shell' and
c.lastname = 'Creane' and 
w.levelid = 1 and 
g.goalid is not null;

SELECT
	w.WorkoutId,
	w.`Name` WorkoutName
FROM Client c
INNER JOIN ClientGoal cg ON c.ClientId = cg.ClientId
INNER JOIN WorkoutGoal wg ON cg.GoalId = wg.GoalId
INNER JOIN Workout w ON wg.WorkoutId = w.WorkoutId
WHERE c.FirstName = 'Shell'
AND c.LastName = 'Creane'
AND w.LevelId = 1;


-- Select all Workouts. 
-- Join to the Goal, 'Core Strength', but make it optional.
-- You may have to look up the GoalId before writing the main query.
-- If you filter on Goal.Name in a WHERE clause, Workouts will be excluded.
-- Why?
-- 26 Workouts, 3 Goals

select
w.`name`,
g.`name`
from workout as w
left join workoutgoal as wg on w.workoutid = wg.workoutid and wg.goalid = 10
left join goal as g on wg.goalid = g.goalid;

-- The relationship between Workouts and Exercises is... complicated.
-- Workout links to WorkoutDay (one day in a Workout routine)
-- which links to WorkoutDayExerciseInstance 
-- (Exercises can be repeated in a day so a bridge table is required) 
-- which links to ExerciseInstance 
-- (Exercises can be done with different weights, repetions,
-- laps, etc...) 
-- which finally links to Exercise.
-- Select Workout.Name and Exercise.Name for related Workouts and Exercises.

select
w.`name`,
e.`name`
from workout as w
inner join workoutday as wd on w.workoutId = wd.workoutId
inner join workoutdayexerciseinstance as wdei on wd.workoutdayid = wdei.workoutdayid
inner join exerciseinstance as ei on wdei.exerciseinstanceid = ei.exerciseinstanceid
inner join exercise as e on ei.exerciseid = e.exerciseid;

   
-- An ExerciseInstance is configured with ExerciseInstanceUnitValue.
-- It contains a Value and UnitId that links to Unit.
-- Example Unit/Value combos include 10 laps, 15 minutes, 200 pounds.
-- Select Exercise.Name, ExerciseInstanceUnitValue.Value, and Unit.Name
-- for the 'Plank' exercise. 
-- How many Planks are configured, which Units apply, and what 
-- are the configured Values?
-- 4 rows, 1 Unit, and 4 distinct Values

select 
e.`name`,
eiuv.`value`,
u.`name`
from exercise as e
inner join exerciseinstance as ei on e.exerciseid = ei.exerciseid
inner join ExerciseInstanceUnitValue as eiuv on ei.exerciseinstanceid = eiuv.exerciseinstanceid
inner join unit as u on eiuv.unitid = u.unitid
where e.`name` = 'Plank';
