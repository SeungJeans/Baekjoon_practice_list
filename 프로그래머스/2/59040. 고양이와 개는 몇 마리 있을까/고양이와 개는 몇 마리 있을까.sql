-- 코드를 입력하세요
SELECT ANIMAL_TYPE, count(*) as count from ANIMAL_INS 
where animal_type in ('Cat', 'Dog')
group by ANIMAL_TYPE 
order by ANIMAL_TYPE;