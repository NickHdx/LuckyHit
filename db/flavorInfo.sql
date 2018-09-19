DO $$
BEGIN
IF EXISTS (SELECT * FROM pg_class WHERE relname = 'flavor_info' AND relkind = 'r') THEN
	DROP TABLE flavor_info;
END IF;

CREATE TABLE flavor_info (
  id SERIAL,
  name VARCHAR(256) NOT NULL,
  lastupdatetime timestamp without time zone NOT NULL,
  CONSTRAINT flavor_info_pkey PRIMARY KEY (id));

END
$$