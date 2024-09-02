-- 부서별 평균 연봉 조회하기
SELECT B.DEPT_ID, DEPT_NAME_EN, ROUND(AVG(SAL)) AS AVG_SAL 
FROM HR_DEPARTMENT A JOIN HR_EMPLOYEES B
ON A.DEPT_ID = B.DEPT_ID
GROUP BY B.DEPT_ID, DEPT_NAME_EN
ORDER BY AVG_SAL DESC;