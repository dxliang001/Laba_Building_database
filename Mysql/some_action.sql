-- Big Join
SELECT *
FROM Employees e
JOIN Roles r ON e.role_id = r.role_id
JOIN Departments d ON e.department_id = d.department_id
JOIN ProjectEmployees pe ON e.emp_id = pe.emp_id
JOIN Projects p ON pe.project_id = p.project_id
JOIN Clients c ON p.client_id = c.client_id
JOIN ProjectMaterials pm ON p.project_id = pm.project_id
JOIN Materials m ON pm.material_id = m.material_id
JOIN Suppliers s ON m.supplier_id = s.supplier_id
JOIN Inventory i ON m.material_id = i.material_id
JOIN Payments pay ON (c.client_id = pay.client_id AND p.project_id = pay.project_id)
JOIN Invoices inv ON (c.client_id = inv.client_id AND p.project_id = inv.project_id AND pay.payment_id = inv.payment_id)
JOIN Expenses exp ON p.project_id = exp.project_id;

-- Not HW 
SELECT DISTINCT
    Clients.client_id, Clients.client_name,
    Projects.project_id, Projects.project_name, Projects.start_date, Projects.end_date, Projects.project_status,
    Payments.payment_id, Payments.amount as payment_amount, Payments.payment_date, Payments.payment_method,
    Invoices.invoice_id, Invoices.issue_date, Invoices.due_date, Invoices.total_amount as invoice_total_amount,
    Expenses.expense_id, Expenses.amount as expense_amount, Expenses.expense_date, Expenses.description
FROM Clients
LEFT JOIN Projects ON Clients.client_id = Projects.client_id
LEFT JOIN Payments ON Projects.project_id = Payments.project_id
LEFT JOIN Invoices ON Projects.project_id = Invoices.project_id
LEFT JOIN Expenses ON Projects.project_id = Expenses.project_id;

-- left join
SELECT Employees.first_name, Employees.last_name, Roles.role_name
FROM Employees 
LEFT JOIN Roles ON Employees.role_id = Roles.role_id;

-- right join
SELECT Projects.project_name, Clients.client_name
FROM Projects
RIGHT JOIN Clients ON Projects.client_id = Clients.client_id;

-- Inner join
SELECT Projects.project_name, Clients.client_name, Employees.emp_id
FROM Projects
RIGHT JOIN Clients ON Projects.client_id = Clients.client_id
INNER JOIN ProjectEmployees ON Projects.project_id = ProjectEmployees.project_id
INNER JOIN Employees ON ProjectEmployees.emp_id = Employees.emp_id;

-- inner join
SELECT Employees.first_name, Employees.last_name, Departments.department_name
FROM Employees 
INNER JOIN Departments ON Employees.department_id = Departments.department_id;

-- outer join
SELECT Materials.material_name, Suppliers.supplier_name
FROM Materials
LEFT JOIN Suppliers ON Materials.supplier_id = Suppliers.supplier_id
UNION 
SELECT Materials.material_name, Suppliers.supplier_name
FROM Materials
RIGHT JOIN Suppliers ON Materials.supplier_id = Suppliers.supplier_id;



-- Group by without having
SELECT material_id, SUM(quantity_required) as total_quantity
FROM ProjectMaterials
GROUP BY material_id;

SELECT material_id, SUM(quantity_on_hand) as total_quantity
FROM Inventory
GROUP BY material_id;

SELECT client_id, SUM(payment_amount) as total_payment
FROM Payments
GROUP BY client_id;

SELECT Clients.client_name, COUNT(Projects.project_id) AS total_projects
FROM Clients
INNER JOIN Projects ON Clients.client_id = Projects.client_id
GROUP BY Clients.client_name;

SELECT Clients.client_name, SUM(Payments.amount) AS total_payment_amount
FROM Clients
INNER JOIN Payments ON Clients.client_id = Payments.client_id
GROUP BY Clients.client_name;

SELECT Projects.project_name, MAX(Payments.amount) AS max_payment_amount
FROM Projects
INNER JOIN Payments ON Projects.project_id = Payments.project_id
GROUP BY Projects.project_name;

SELECT Clients.client_name, AVG(Invoices.total_amount) AS average_invoice_amount
FROM Clients
INNER JOIN Invoices ON Clients.client_id = Invoices.client_id
GROUP BY Clients.client_name;

-- Group by with having
SELECT material_id, SUM(quantity_required) as total_quantity
FROM ProjectMaterials
GROUP BY material_id
HAVING total_quantity > 10000;

SELECT material_id, SUM(quantity_on_hand) as total_quantity
FROM Inventory
GROUP BY material_id
HAVING total_quantity < 1000;

SELECT client_id, SUM(amount) as total_payment
FROM Payments
GROUP BY client_id
HAVING total_payment > 50000;

SELECT Clients.client_name, COUNT(Projects.project_id) AS total_projects
FROM Clients
INNER JOIN Projects ON Clients.client_id = Projects.client_id
GROUP BY Clients.client_name
HAVING COUNT(Projects.project_id) > 1;

SELECT Clients.client_name, SUM(Payments.amount) AS total_payment_amount
FROM Clients
INNER JOIN Payments ON Clients.client_id = Payments.client_id
GROUP BY Clients.client_name
HAVING SUM(Payments.amount) > 5000;

SELECT Projects.project_name, MAX(Payments.amount) AS max_payment_amount
FROM Projects
INNER JOIN Payments ON Projects.project_id = Payments.project_id
GROUP BY Projects.project_name
HAVING MAX(Payments.amount) > 2000;

SELECT Clients.client_name, AVG(Invoices.total_amount) AS average_invoice_amount
FROM Clients
INNER JOIN Invoices ON Clients.client_id = Invoices.client_id
GROUP BY Clients.client_name
HAVING AVG(Invoices.total_amount) < 1000;
