ALTER TABLE History
ALTER COLUMN type TYPE varchar(25),
ALTER COLUMN client TYPE varchar(15),
ALTER COLUMN account TYPE varchar(150),
ALTER COLUMN via TYPE varchar(15),
ALTER COLUMN start TYPE varchar(35),
ALTER COLUMN wait TYPE varchar(16),
ALTER COLUMN duration TYPE varchar(16),
ALTER COLUMN record TYPE varchar(2048);

ALTER TABLE account
ALTER COLUMN phone TYPE varchar(15),
ALTER COLUMN address TYPE varchar(150),
ALTER COLUMN account TYPE varchar(150);

