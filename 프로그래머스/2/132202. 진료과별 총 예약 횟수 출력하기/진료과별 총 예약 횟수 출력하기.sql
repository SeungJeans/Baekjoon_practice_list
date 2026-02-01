-- 코드를 입력하세요
SELECT MCDP_CD as "진료과코드", count(distinct PT_NO) as "5월예약건수"  
from APPOINTMENT
where APNT_YMD >= '2022-05-01' AND APNT_YMD < '2022-06-01'
group by MCDP_CD    
order by count(distinct PT_NO), MCDP_CD;  