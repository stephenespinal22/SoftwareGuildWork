USE TrackIt2;



SELECT *
FROM Worker
WHERE WorkerId IN (
    SELECT WorkerId FROM ProjectWorker
);

-- This doesn't do what we want.
SELECT
    p.Name ProjectName,
    MIN(t.TaskId) MinTaskId
    -- t.Title is what we want, but the SQL Engine 
    -- doesn't know which Task we're talking about!
    -- t.Title is not part of a group and there's 
    -- no aggregate guaranteed to grab the Title from the MinTaskId.
FROM Project p
INNER JOIN Task t ON p.ProjectId = t.ProjectId
GROUP BY p.ProjectId, p.Name;

SELECT
    g.ProjectName,
    g.MinTaskId,
    t.Title MinTaskTitle
FROM Task t
INNER JOIN (
    SELECT
        p.Name ProjectName,
        MIN(t.TaskId) MinTaskId
    FROM Project p
    INNER JOIN Task t ON p.ProjectId = t.ProjectId
    GROUP BY p.ProjectId, p.Name) g ON t.TaskId = g.MinTaskId;
    
    SELECT
    p.Name ProjectName,
    MIN(t.TaskId) MinTaskId,
    (SELECT Title FROM Task 
    WHERE TaskId = MIN(t.TaskId)) MinTaskTitle
FROM Project p
INNER JOIN Task t ON p.ProjectId = t.ProjectId
GROUP BY p.ProjectId, p.Name