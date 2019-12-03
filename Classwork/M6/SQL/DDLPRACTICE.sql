DROP DATABASE IF EXISTS TrackIt;
CREATE DATABASE TrackIt;

-- Note the USE! It's important.
USE TrackIt;

CREATE TABLE Task (
    TaskId INT PRIMARY KEY AUTO_INCREMENT,
    Title VARCHAR(100) NOT NULL,
    Details TEXT NULL,
    DueDate DATE NOT NULL,
    EstimatedHours DECIMAL(5, 2) NULL
);

CREATE TABLE Project (
    ProjectId CHAR(50) PRIMARY KEY,
    `Name` VARCHAR(100) NOT NULL,
    Summary VARCHAR(2000) NULL,
    DueDate DATE NOT NULL,
    IsActive BOOL NOT NULL DEFAULT 1
);

ALTER TABLE Task
    ADD COLUMN (
        ProjectId CHAR(50) NOT NULL
    ),
    ADD CONSTRAINT fk_Task_Project
        FOREIGN KEY (ProjectId) 
        REFERENCES Project(ProjectId);
        
CREATE TABLE Worker (
    WorkerId INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    ProjectId CHAR(50) NOT NULL,
    FOREIGN KEY fk_Worker_Project (ProjectId)
        REFERENCES Project(ProjectId)	
);

-- issues with above table It's possible to add a Worker with no FirstName or LastName. 
-- Both columns are nullable. We should fix that. A Worker with a NULL name isn't very useful.
-- When we first described our issue tracker, we said, "A worker is optionally associated 
-- with many projects." Note the word many. The current Worker contains a ProjectId from the 
-- Project table. That means each Worker record can be linked to one and only one project. 
-- We should fix that as well. No one will use our issue tracker if a worker can only be assigned 
-- to a single project.

ALTER TABLE Worker
    DROP FOREIGN KEY fk_Worker_Project,
    DROP COLUMN ProjectId;
 
 -- Deletes a table if it's not part of a dependency.
-- DROP TABLE TableName;

-- Deletes an entire database. Be very, very careful with this one.
-- DROP DATABASE DatabaseName;

ALTER TABLE Worker
    MODIFY COLUMN FirstName VARCHAR(50) NOT NULL,
    MODIFY COLUMN LastName VARCHAR(50) NOT NULL;

CREATE TABLE ProjectWorker (
    ProjectId CHAR(50) NOT NULL,
    WorkerId INT NOT NULL,
    PRIMARY KEY pk_ProjectWorker (ProjectId, WorkerId),
    FOREIGN KEY fk_ProjectWorker_Project (ProjectId)
        REFERENCES Project(ProjectId),
    FOREIGN KEY fk_ProjectWorker_Worker (WorkerId)
        REFERENCES Worker(WorkerId)
);

-- This approach destroys the existing database and starts from scratch each time you run it.
-- It's good for new development, but won't work for existing
--   databases that must be altered but left intact.
DROP DATABASE IF EXISTS TrackIt;

CREATE DATABASE TrackIt;

-- Make sure we're in the correct database before we add schema.
USE TrackIt;

CREATE TABLE Project (
    ProjectId CHAR(50) PRIMARY KEY,
    `Name` VARCHAR(100) NOT NULL,
    Summary VARCHAR(2000) NULL,
    DueDate DATE NOT NULL,
    IsActive BOOL NOT NULL DEFAULT 1
);

CREATE TABLE Worker (
    WorkerId INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL
);

CREATE TABLE ProjectWorker (
    ProjectId CHAR(50) NOT NULL,
    WorkerId INT NOT NULL,
    PRIMARY KEY pk_ProjectWorker (ProjectId, WorkerId),
    FOREIGN KEY fk_ProjectWorker_Project (ProjectId)
        REFERENCES Project(ProjectId),
    FOREIGN KEY fk_ProjectWorker_Worker (WorkerId)
        REFERENCES Worker(WorkerId)
);

CREATE TABLE Task (
    TaskId INT PRIMARY KEY AUTO_INCREMENT,
    Title VARCHAR(100) NOT NULL,
    Details TEXT NULL,
    DueDate DATE NOT NULL,
    EstimatedHours DECIMAL(5, 2) NULL,
    ProjectId CHAR(50) NOT NULL,
    WorkerId INT NOT NULL,
    FOREIGN KEY fk_Task_ProjectWorker (ProjectId, WorkerId)
        REFERENCES ProjectWorker(ProjectId, WorkerId)
);