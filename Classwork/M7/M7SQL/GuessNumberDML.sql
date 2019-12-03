use GuessNumber;


update Game set isFinished = false where gameId = 2;

insert into Game (answer) values (?);
select gameId, isFinished from Game;
select gameId, isFinished from Game where gameId = ?;

insert into Round (gameId, guess) values (?,?);
select `timeStamp`,roundName, gameId, guess, result from Round order by `timeStamp`;

