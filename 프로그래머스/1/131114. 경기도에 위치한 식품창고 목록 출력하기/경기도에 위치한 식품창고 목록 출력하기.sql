-- 코드를 입력하세요
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, 
(case when FREEZER_YN is NULL then 'N' else FREEZER_YN END) as FREEZER_YN
from FOOD_WAREHOUSE 
where address like "경기도%"
order by WAREHOUSE_ID; 