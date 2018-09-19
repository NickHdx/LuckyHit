DO $$
BEGIN
IF EXISTS (SELECT * FROM pg_class WHERE relname = 'user_info' AND relkind = 'r') THEN
	DROP TABLE user_info;
END IF;

CREATE TABLE user_info (
  id VARCHAR NOT NULL,
  name VARCHAR(256) NOT NULL,
  flavorlist VARCHAR NULL,
  status SMALLINT NOT NULL,
  lastlogintime timestamp without time zone NOT NULL,
  CONSTRAINT user_info_pkey PRIMARY KEY (id));

END
$$