DO $$
BEGIN
IF EXISTS (SELECT * FROM pg_class WHERE relname = 'restaurant_info' AND relkind = 'r') THEN
	DROP TABLE restaurant_info;
END IF;

CREATE TABLE restaurant_info (
  id SERIAL,
  name VARCHAR(256) NOT NULL,
  address VARCHAR NOT NULL,
  flavorlist VARCHAR NOT NULL,
  image VARCHAR NULL,
  lastupdatetime timestamp without time zone NOT NULL,
  CONSTRAINT restaurant_info_pkey PRIMARY KEY (id));

END
$$