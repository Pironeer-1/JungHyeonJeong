-- 조건에 맞는 개발자 찾기
SELECT DISTINCT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS D,
    (SELECT CODE
    FROM SKILLCODES
    WHERE NAME IN ('Python', 'C#')
    ) AS S
WHERE (D.SKILL_CODE & S.CODE) = S.CODE
ORDER BY ID;