DO $$
BEGIN
IF EXISTS (SELECT * FROM pg_class WHERE relname = 'order_info' AND relkind = 'r') THEN
	DROP TABLE order_info;
END IF;

CREATE TABLE order_info (
  id SERIAL,
  first_user_id VARCHAR NOT NULL,
  second_user_id VARCHAR NOT NULL,
  restaurant_id VARCHAR NOT NULL,
  dining_begin_time timestamp without time zone NOT NULL,
  dining_end_time timestamp without time zone NOT NULL,
  last_update_time timestamp without time zone NOT NULL,
  CONSTRAINT order_info_pkey PRIMARY KEY (id));

END
$$