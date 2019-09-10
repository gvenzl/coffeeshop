DROP TABLE ORDERS;

CREATE TABLE ORDERS (
  order_details  BLOB,
  city           VARCHAR2(25) AS (JSON_VALUE(order_details, '$.location.city'  RETURNING VARCHAR2(25))),
  state          VARCHAR2(25) AS (JSON_VALUE(order_details, '$.location.state' RETURNING VARCHAR2(25))),
  sale_amount    NUMBER       AS (JSON_VALUE(order_details, '$.sales_amount'   RETURNING NUMBER))
)
LOB (order_details) STORE AS SECUREFILE
(
  ENABLE STORAGE IN ROW
);

DROP TABLE ORDERS_HISTORY;

CREATE TABLE ORDERS_HISTORY (
  order_details  BLOB,
  order_date     DATE         AS (TO_DATE(JSON_VALUE(order_details, '$.date'), 'YYYY-MM-DD HH24:MI:SS')),
  city           VARCHAR2(25) AS (JSON_VALUE(order_details, '$.location.city'  RETURNING VARCHAR2(25))),
  state          VARCHAR2(25) AS (JSON_VALUE(order_details, '$.location.state' RETURNING VARCHAR2(25))),
  sale_amount    NUMBER       AS (JSON_VALUE(order_details, '$.sales_amount'   RETURNING NUMBER))
)
LOB (order_details) STORE AS SECUREFILE
(
  ENABLE STORAGE IN ROW
);
