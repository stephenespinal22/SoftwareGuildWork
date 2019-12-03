drop database if exists GuessNumber;
Create database GuessNumber;

Use GuessNumber;

create table Game( 
gameId int primary key auto_increment,
answer varchar(4), 
isFinished bool not null default 0);

create table Round( 
roundId int primary key auto_increment,
gameId int not null, 
roundName int,
guess varchar(4) not null, 
result varchar(7),
`timeStamp` varchar(50),
FOREIGN KEY fk_Game_gameId(gameId) REFERENCES Game(gameId) 
);

