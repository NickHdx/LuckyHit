DO $$
BEGIN
IF EXISTS (SELECT * FROM pg_class WHERE relname = 'flavor_map' AND relkind = 'r') THEN
	DROP TABLE flavor_map;
END IF;

CREATE TABLE flavor_map (
  id SERIAL,
  userid VARCHAR NOT NULL,
  flavorlist VARCHAR NOT NULL,
  lastupdatetime timestamp without time zone NOT NULL,
  CONSTRAINT flavor_map_pkey PRIMARY KEY (id));

END
$$