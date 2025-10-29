SELECT e.employee_id
FROM Employees e
LEFT JOIN Employees m
  ON e.manager_id = m.employee_id
WHERE e.salary < 30000
  AND e.manager_id IS NOT NULL     -- they must have had a manager
  AND m.employee_id IS NULL        -- that manager no longer exists (left)
ORDER BY e.employee_id;
