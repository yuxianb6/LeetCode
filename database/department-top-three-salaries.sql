SELECT
    d.name AS Department,
    e.name AS Employee,
    e.salary AS Salary
FROM (
    SELECT *,
           DENSE_RANK() OVER (
               PARTITION BY departmentId
               ORDER BY salary DESC
           ) AS r
    FROM employee
) e
JOIN department d
    ON e.departmentId = d.id
WHERE r <= 3;
