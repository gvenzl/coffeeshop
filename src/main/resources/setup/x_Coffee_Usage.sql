CREATE OR REPLACE VIEW COFFEE_USAGE_HIST (city, state, sale_date, coffee_beans_lb)
AS
  SELECT s.city,
         s.state,
         s.sale_date,
         (j.coffee_beans*0.0022046) as coffee_beans_lb
    FROM orders_history s, JSON_TABLE(s.order, '$.order[*]'
                     COLUMNS (coffee_beans   VARCHAR2(24) PATH '$.coffee_used_gram')
                 )j;


