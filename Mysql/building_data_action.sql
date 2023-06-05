USE `laba_test` ;

INSERT INTO Roles (role_id, role_name, role_description)
VALUES (1, 'Manager', 'Responsible for managing the team'),
	   (2, 'Engineer', 'Responsible for engineering tasks'),
       (3, 'Architect', 'Responsible for architectural designs'),
       (4, 'Foreman', 'Oversees the construction site'),
       (5, 'Worker', 'Performs the construction work'),
       (6, 'Accountant', 'Handles company finances');

UPDATE Roles
SET role_description = 'Handling company finances'
WHERE role_id = 6;        

DELETE FROM Roles WHERE role_id = 6;   
       
INSERT INTO Departments (department_id, department_name, department_description)
VALUES (1, 'Construction', 'Responsible for the actual construction work'),
	   (2, 'Engineering', 'Handles engineering tasks'),
       (3, 'Architecture', 'Handles architectural design'),
       (4, 'Accounting', 'Manages financial affairs'),
       (5, 'HR', 'Manages employee-related tasks'),
       (6, 'Procurement', 'Handles purchase of materials');

DELETE FROM Departments WHERE department_id = 6;   

INSERT INTO Employees (emp_id, first_name, last_name, role_id, department_id, hire_date, email, phone_number)
VALUES (1, 'John', 'Doe', 1, 1, '2022-01-01', 'john.doe@example.com', '123-456-7890'),
	   (2, 'Jane', 'Smith', 2, 2, '2023-02-01', 'jane.smith@example.com', '321-654-0987'),
       (3, 'Bob', 'Johnson', 3, 3, '2023-03-01', 'bob.johnson@example.com', '789-012-3456'),
       (4, 'Alice', 'Williams', 4, 1, '2023-04-01', 'alice.williams@example.com', '654-321-7890'),
       (5, 'Charlie', 'Brown', 5, 1, '2023-05-01', 'charlie.brown@example.com', '210-654-3210'),
       (6, 'David', 'Jones', 6, 4, '2023-06-01', 'david.jones@example.com', '876-543-2109');

UPDATE Employees
SET phone_number = '111-111-1111'
WHERE emp_id = 1;

DELETE FROM Employees WHERE emp_id = 6;   

INSERT INTO Clients (client_id, client_name, contact_name, client_address, client_email, client_phone)
VALUES (1, 'Client Company', 'Jane Smith', '123 Main St', 'client@example.com', '098-765-4321'),
	   (2, 'Client Co', 'Tom Lee', '234 Main St', 'clientco@example.com', '111-222-3333'),
       (3, 'Alpha Ltd', 'Susan Miller', '345 High St', 'alphaltd@example.com', '444-555-6666'),
       (4, 'Beta Corp', 'Robert Brown', '456 Park Ave', 'betacorp@example.com', '777-888-9999'),
       (5, 'Gamma Inc', 'Patricia Davis', '567 King St', 'gammainc@example.com', '000-111-2222'),
       (6, 'Delta Plc', 'James Wilson', '678 Queen St', 'deltaplc@example.com', '333-444-5555');

ALTER TABLE Clients
ADD Country varchar(255);
       
UPDATE Clients
SET Country = 'USA'
WHERE client_id > 0;

SELECT * From Clients;
       
UPDATE Clients
SET phone_number = '212-111-1111'
WHERE client_id = 1;       

Delete FROM Clients WHERE client_id = 6;

INSERT INTO Projects (project_id, project_name, start_date, end_date, client_id, project_status)
VALUES (1, 'New Building', '2022-02-01', '2022-12-01', 1, 'In Progress'),
	   (2, 'Office Block', '2023-07-01', '2024-06-30', 2, 'Planned'),
       (3, 'Shopping Mall', '2023-08-01', NULL, 3, 'In Progress'),
       (4, 'Apartment Building', '2023-09-01', NULL, 4, 'In Progress'),
       (5, 'Parking Garage', '2023-10-01', '2024-07-30', 5, 'Planned'),
       (6, 'Townhouse Complex', '2023-11-01', NULL, 6, 'In Progress');
       
UPDATE Projects
SET end_date = DATE_ADD(start_date, INTERVAL 5 YEAR)
WHERE end_date IS NULL AND project_id > 0;

DELETE FROM Projects WHERE projects_id = 6;

INSERT INTO Suppliers (supplier_id, supplier_name, supplier_address, supplier_email, supplier_phone)
VALUES (1, 'Supplier Company', '456 Second St', 'supplier@example.com', '456-789-0123'),
       (2, 'Alpha Supply', '789 Second St', 'alpha@example.com', '555-666-7777'),
       (3, 'Beta Products', '890 Third Ave', 'beta@example.com', '888-999-0000'),
       (4, 'Gamma Goods', '901 Fourth Rd', 'gamma@example.com', '111-222-3333'),
       (5, 'Delta Materials', '012 Fifth St', 'delta@example.com', '444-555-6666'),
       (6, 'Epsilon Items', '123 Sixth Ave', 'epsilon@example.com', '777-888-9999');

DELETE FROM Suppliers WHERE supplier_id = 6;

INSERT INTO Materials (material_id, material_name, material_description, supplier_id)
VALUES (1, 'Bricks', 'High quality bricks', 1),
	   (2, 'Cement', 'High quality cement', 2),
       (3, 'Steel', 'Strong steel rods', 3),
       (4, 'Wood', 'High quality timber', 4),
       (5, 'Glass', 'Clear window glass', 5),
       (6, 'Plastic', 'Durable plastic', 6);

INSERT INTO Inventory (inventory_id, material_id, quantity_on_hand)
VALUES (1, 1, 10000),
	   (2, 2, 1000),
       (3, 3, 1500),
       (4, 4, 1200),
       (5, 5, 1800),
       (6, 6, 2000);

UPDATE Inventory
SET quantity_on_hand = 8000
WHERE inventory_id = 1;

INSERT INTO ProjectMaterials (project_id, material_id, quantity_required)
VALUES (1, 1, 2000),
	   (2, 2, 500),
       (3, 3, 400),
       (4, 4, 600),
       (5, 5, 350),
       (6, 6, 700);

INSERT INTO ProjectEmployees (project_id, emp_id)
VALUES (1, 1),
	   (2, 2),
       (3, 3),
       (4, 4),
       (5, 5),
       (6, 6);
       
UPDATE ProjectEmployees
SET project_id = 5
WHERE emp_id = 5;

-- Insert data into Payments
INSERT INTO Payments (payment_id, client_id, project_id, amount, payment_date, payment_method)
VALUES (1, 1, 1, 30000.00, '2022-02-01', 'Credit Card'),
       (2, 2, 2, 552000.00, '2023-07-01', 'Bank Transfer'),
       (3, 3, 3, 5493000.00, '2023-08-01', 'Check'),
       (4, 4, 4, 45453000.00, '2023-09-01', 'Bank Transfer'),
       (5, 5, 5, 3000.00, '2023-10-01', 'Check'),
       (6, 6, 6, 46463000.00, '2023-11-01', 'Bank Transfer');
       

-- Insert data into Invoices
INSERT INTO Invoices (invoice_id, client_id, project_id, issue_date, due_date, total_amount, payment_id)
VALUES (1, 1, 1, '2022-02-01', '2022-12-01', 30000.00, 1),
       (2, 2, 2, '2023-07-01', '2024-06-30', 552000.00, 2),
       (3, 3, 3, '2023-08-01', '2028-08-01' , 5493000.00, 3),
       (4, 4, 4, '2023-09-01', '2028-09-01' , 45453000.00, 4),
       (5, 5, 5, '2023-10-01', '2024-07-30', 3000.00, 5),
       (6, 6, 6, '2023-11-01', '2028-11-01', 46463000.00, 6);
       
SELECT * FROM Roles;
SELECT * FROM Departments;
SELECT * FROM Employees;
SELECT * FROM Clients;
SELECT * FROM Projects;
SELECT * FROM Suppliers;
SELECT * FROM Materials;
SELECT * FROM Inventory;
SELECT * FROM ProjectMaterials;
SELECT * FROM ProjectEmployees;
SELECT * FROM Payments;
SELECT * FROM Invoices;
SELECT * FROM Expenses;