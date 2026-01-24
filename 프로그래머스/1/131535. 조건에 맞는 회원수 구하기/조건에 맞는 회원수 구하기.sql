-- 코드를 입력하세요
SELECT count(*) as users 
from USER_INFO
WHERE YEAR(JOINED) = 2021
and AGE BETWEEN 20 AND 29;
