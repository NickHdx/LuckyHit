DO $$
BEGIN
IF EXISTS (SELECT * FROM pg_class WHERE relname = 'order_info' AND relkind = 'r') THEN
	DROP TABLE order_info;
END IF;

CREATE TABLE order_info (
  id SERIAL,
  firstuserid VARCHAR NOT NULL,
  seconduserid VARCHAR NULL,
  restaurantid VARCHAR NOT NULL,
  diningbegintime timestamp without time zone NOT NULL,
  diningendtime timestamp without time zone NOT NULL,
  status SMALLINT NOT NULL,
  lastupdatetime timestamp without time zone NOT NULL,
  CONSTRAINT order_info_pkey PRIMARY KEY (id));

END
$$