DROP TABLE SALES;

CREATE TABLE ORDERS (
  order_detail  BLOB,
  city          VARCHAR2(25) AS (JSON_VALUE(order_detail, '$.location.city'  RETURNING VARCHAR2(25))),
  state         VARCHAR2(25) AS (JSON_VALUE(order_detail, '$.location.state' RETURNING VARCHAR2(25))),
  sale_amount   NUMBER       AS (JSON_VALUE(order_detail, '$.sales_amount'   RETURNING NUMBER))
)
LOB (order_detail) STORE AS SECUREFILE
(
  ENABLE STORAGE IN ROW
);

DROP TABLE SALES_HISTORY;

CREATE TABLE ORDERS_HISTORY (
  order_detail  BLOB,
  order_date    DATE         AS (TO_DATE(JSON_VALUE(order_detail, '$.date'), 'YYYY-MM-DD HH24:MI:SS')),
  city          VARCHAR2(25) AS (JSON_VALUE(order_detail, '$.location.city'  RETURNING VARCHAR2(25))),
  state         VARCHAR2(25) AS (JSON_VALUE(order_detail, '$.location.state' RETURNING VARCHAR2(25))),
  sale_amount   NUMBER       AS (JSON_VALUE(order_detail, '$.sales_amount'   RETURNING NUMBER))
)
LOB (order_detail) STORE AS SECUREFILE
(
  ENABLE STORAGE IN ROW
);