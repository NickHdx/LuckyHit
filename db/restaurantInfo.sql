DO $$
BEGIN
IF EXISTS (SELECT * FROM pg_class WHERE relname = 'restaurant_info' AND relkind = 'r') THEN
	DROP TABLE restaurant_info;
END IF;

CREATE TABLE restaurant_info (
  id SERIAL,
  name VARCHAR(256) NOT NULL,
  address VARCHAR NOT NULL,
  flavor_list VARCHAR NOT NULL,
  small_image VARCHAR NULL,
  big_image VARCHAR NULL,
  last_update_time timestamp without time zone NOT NULL,
  CONSTRAINT restaurant_info_pkey PRIMARY KEY (id));

END
$$