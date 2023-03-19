-- 23. The name and date established of parks opened in the 1960s (6 rows)

select park_name, date_established
from park
where extract(year from date_established) between 1960 and 1969 ;