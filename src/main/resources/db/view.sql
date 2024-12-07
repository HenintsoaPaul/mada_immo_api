CREATE OR REPLACE VIEW gain_mensuel
AS SELECT to_char(date_trunc('month', lf.date_location), 'Mon yyyy') AS month_year,
       SUM(loyer_mensuel * (commission / 100))                    AS gain
FROM location_fille lf
         JOIN (location l
    JOIN (type_bien tb JOIN bien b ON b.id_type_bien = tb.id_type_bien) btb
               ON l.id_bien = btb.id_bien) mere ON mere.id_location = lf.id_location_mere
GROUP BY date_trunc('month', lf.date_location)
ORDER BY date_trunc('month', lf.date_location)