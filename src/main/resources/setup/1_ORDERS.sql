DROP TABLE SALES;

CREATE TABLE ORDERS (
  order         BLOB,
  city         VARCHAR2(25) AS (JSON_VALUE(sale, '$.location.city'  RETURNING VARCHAR2(25))),
  state        VARCHAR2(25) AS (JSON_VALUE(sale, '$.location.state' RETURNING VARCHAR2(25))),
  sale_amount  NUMBER       AS (JSON_VALUE(sale, '$.sales_amount'   RETURNING NUMBER))
)
LOB (order) STORE AS SECUREFILE
(
  ENABLE STORAGE IN ROW
);

DROP TABLE SALES_HISTORY;

CREATE TABLE ORDERS_HISTORY (
  order         BLOB,
  order_date    DATE         AS (TO_DATE(JSON_VALUE(sale, '$.date'), 'YYYY-MM-DD HH24:MI:SS')),
  city         VARCHAR2(25) AS (JSON_VALUE(sale, '$.location.city'  RETURNING VARCHAR2(25))),
  state        VARCHAR2(25) AS (JSON_VALUE(sale, '$.location.state' RETURNING VARCHAR2(25))),
  sale_amount  NUMBER       AS (JSON_VALUE(sale, '$.sales_amount'   RETURNING NUMBER))
)
LOB (order) STORE AS SECUREFILE
(
  ENABLE STORAGE IN ROW
);