--activity9
-- Create the customers table
create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);

----insert values
insert all
into customers values(3002, 'Nick Rimando', 'New York', 100, 5001)
into customers values(3007, 'Brad Davis', 'New York', 200, 5001)
into customers values(3005, 'Graham Zusi', 'California', 200, 5002)
into customers values(3008, 'Julian Green', 'London', 300, 5002)
into customers values(3004, 'Fabian Johnson', 'Paris', 300, 5006)
into customers values(3009, 'Geoff Cameron', 'Berlin', 100, 5003)
into customers values(3003, 'Jozy Altidor', 'Moscow', 200, 5007)
into customers values(3001, 'Brad Guzan', 'London', 300, 5005)
select 1 from dual


----creating salesman table
CREATE TABLE salesman(
salesman_id     int not null ,
salesman_name    varchar2(20),
salesman_city    varchar2(20),
commission       int)

INSERT ALL
    INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13)
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11)
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14)
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13)
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12)
SELECT 1 FROM DUAL;

-- Write an SQL statement to know which salesman are working for which customer.
SELECT a.customer_name AS "Customer Name", a.city, b.salesman_name AS "Salesman", b.commission 
FROM customers a 
INNER JOIN salesman b
ON a.salesman_id=b.salesman_id;

-- Write an SQL statement to make a list in ascending order for the customer who holds a grade less than 300 and works either through a salesman
SELECT a.customer_name, a.city, a.grade, b.salesman_name AS "Salesman", b.salesman_city
FROM customers a 
LEFT OUTER JOIN salesman b
ON a.salesman_id=b.salesman_id WHERE a.grade<300 
ORDER BY a.customer_id;