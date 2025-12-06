125 questions



1\. List all the columns of the Salespeople table.



 select \* from salespeople;

+------+---------+-----------+------+

| SNUM | SNAME   | CITY      | COMM |

+------+---------+-----------+------+

| 1001 | Peel    | London    | 0.12 |

| 1002 | Serres  | San Jose  | 0.13 |

| 1003 | AxelRod | New York  | 0.10 |

| 1004 | Motika  | London    | 0.11 |

| 1005 | Fran    | London    | 0.26 |

| 1007 | Rifkin  | Barcelona | 0.15 |

+------+---------+-----------+------+





2\. List all customers with a rating of 100.



 select \* from customers where rating>100;

+------+----------+----------+--------+------+

| CNUM | CNAME    | CITY     | RATING | SNUM |

+------+----------+----------+--------+------+

| 2002 | Giovanni | Rome     |    200 | 1003 |

| 2003 | Liu      | San Jose |    200 | 1002 |

| 2004 | Grass    | Berlin   |    300 | 1002 |

| 2008 | Cisneros | San Jose |    300 | 1007 |

+------+----------+----------+--------+------+

4 rows in set (0.02 sec)





3\. Find all records in the Customer table with NULL values in the city column.



  select \* from customers where city='null';





4\. Find the largest order taken by each salesperson on each date.



 select s.sname, o.odate, max(o.amt) as largest\_order from orders o join salespeople s on o.snum= s.snum group by s.sname, o.odate;

+---------+------------+---------------+

| sname   | odate      | largest\_order |

+---------+------------+---------------+

| Peel    | 1996-10-03 |        767.19 |

| Peel    | 1996-10-05 |       4723.00 |

| Peel    | 1996-10-06 |       9891.88 |

| Serres  | 1996-10-03 |       5160.45 |

| Serres  | 1996-10-06 |       1309.95 |

| AxelRod | 1996-10-04 |       1713.23 |

| Motika  | 1996-10-03 |       1900.10 |

| Rifkin  | 1996-10-03 |       1098.16 |

+---------+------------+---------------+



5\. Arrange the Orders table by descending customer number.



select \* from orders o join customers c on o.cnum=c.cnum order by  c.cnum desc;



select \* from orders where order by cnum desc;



SELECT \*

FROM orders

WHERE cnum IN (SELECT cnum FROM customers)

ORDER BY cnum DESC;







select \* from orders o join customers c on o.cnum=c.cnum order by  o.cnum desc;

+------+---------+------------+------+------+------+----------+----------+--------+------+

| ONUM | AMT     | ODATE      | CNUM | SNUM | CNUM | CNAME    | CITY     | RATING | SNUM |

+------+---------+------------+------+------+------+----------+----------+--------+------+

| 3001 |   18.69 | 1996-10-03 | 2008 | 1007 | 2008 | Cisneros | San Jose |    300 | 1007 |

| 3006 | 1098.16 | 1996-10-03 | 2008 | 1007 | 2008 | Cisneros | San Jose |    300 | 1007 |

| 3002 | 1900.10 | 1996-10-03 | 2007 | 1004 | 2007 | Pereira  | Rome     |    100 | 1004 |

| 3008 | 4723.00 | 1996-10-05 | 2006 | 1001 | 2006 | Clemens  | London   |    100 | 1001 |

| 3011 | 9891.88 | 1996-10-06 | 2006 | 1001 | 2006 | Clemens  | London   |    100 | 1001 |

| 3010 | 1309.95 | 1996-10-06 | 2004 | 1002 | 2004 | Grass    | Berlin   |    300 | 1002 |

| 3005 | 5160.45 | 1996-10-03 | 2003 | 1002 | 2003 | Liu      | San Jose |    200 | 1002 |

| 3007 |   75.75 | 1996-10-04 | 2002 | 1003 | 2002 | Giovanni | Rome     |    200 | 1003 |

| 3009 | 1713.23 | 1996-10-04 | 2002 | 1003 | 2002 | Giovanni | Rome     |    200 | 1003 |

| 3003 |  767.19 | 1996-10-03 | 2001 | 1001 | 2001 | Hoffman  | London   |    100 | 1001 |

+------+---------+------------+------+------+------+----------+----------+--------+------+

10 rows in set (0.01 sec)



mysql> select \* from orders o join customers c on o.cnum=c.cnum order by  c.cnum desc;

+------+---------+------------+------+------+------+----------+----------+--------+------+

| ONUM | AMT     | ODATE      | CNUM | SNUM | CNUM | CNAME    | CITY     | RATING | SNUM |

+------+---------+------------+------+------+------+----------+----------+--------+------+

| 3001 |   18.69 | 1996-10-03 | 2008 | 1007 | 2008 | Cisneros | San Jose |    300 | 1007 |

| 3006 | 1098.16 | 1996-10-03 | 2008 | 1007 | 2008 | Cisneros | San Jose |    300 | 1007 |

| 3002 | 1900.10 | 1996-10-03 | 2007 | 1004 | 2007 | Pereira  | Rome     |    100 | 1004 |

| 3008 | 4723.00 | 1996-10-05 | 2006 | 1001 | 2006 | Clemens  | London   |    100 | 1001 |

| 3011 | 9891.88 | 1996-10-06 | 2006 | 1001 | 2006 | Clemens  | London   |    100 | 1001 |

| 3010 | 1309.95 | 1996-10-06 | 2004 | 1002 | 2004 | Grass    | Berlin   |    300 | 1002 |

| 3005 | 5160.45 | 1996-10-03 | 2003 | 1002 | 2003 | Liu      | San Jose |    200 | 1002 |

| 3007 |   75.75 | 1996-10-04 | 2002 | 1003 | 2002 | Giovanni | Rome     |    200 | 1003 |

| 3009 | 1713.23 | 1996-10-04 | 2002 | 1003 | 2002 | Giovanni | Rome     |    200 | 1003 |

| 3003 |  767.19 | 1996-10-03 | 2001 | 1001 | 2001 | Hoffman  | London   |    100 | 1001 |

+------+---------+------------+------+------+------+----------+----------+--------+------+

10 rows in set (0.00 sec)





6\. Find which salespeople currently have orders in the Orders table.



select DISTINCT s.snum, s.sname from salespeople s join orders o on s.snum=o.snum;



select snum, sname from salespeople where snum in (select snum from orders);





 select DISTINCT s.snum, s.sname from salespeople s join orders o on s.snum=o.snum;

+------+---------+

| snum | sname   |

+------+---------+

| 1001 | Peel    |

| 1002 | Serres  |

| 1003 | AxelRod |

| 1004 | Motika  |

| 1007 | Rifkin  |

+------+---------+

5 rows in set (0.00 sec)



mysql> select snum, sname from salespeople where snum in (select snum from orders);

+------+---------+

| snum | sname   |

+------+---------+

| 1001 | Peel    |

| 1002 | Serres  |

| 1003 | AxelRod |

| 1004 | Motika  |

| 1007 | Rifkin  |

+------+---------+

5 rows in set (0.00 sec)





7\. List names of all customers matched with the salespeople serving them.



select c.cnum, c.cname, c.city,s.sname from customers c join salespeople s on c.snum=s.snum;





 select c.cnum, c.cname, c.city,s.sname from customers c join salespeople s on c.snum=s.snum;

+------+----------+----------+---------+

| cnum | cname    | city     | sname   |

+------+----------+----------+---------+

| 2001 | Hoffman  | London   | Peel    |

| 2002 | Giovanni | Rome     | AxelRod |

| 2003 | Liu      | San Jose | Serres  |

| 2004 | Grass    | Berlin   | Serres  |

| 2006 | Clemens  | London   | Peel    |

| 2007 | Pereira  | Rome     | Motika  |

| 2008 | Cisneros | San Jose | Rifkin  |

+------+----------+----------+---------+

7 rows in set (0.00 sec)



8\. Find the names and numbers of all salespeople who had more than one customer.



use joins+group by+having



select s.snum, s.sname from salespeople s join  customers c on s.snum = c.snum group by s.snum, s.sname having count(c.snum)>1;



 select s.snum, s.sname from salespeople s join  customers c on s.snum = c.snum group by s.snum, s.sname having count(c.snum)>1;

+------+--------+

| snum | sname  |

+------+--------+

| 1001 | Peel   |

| 1002 | Serres |

+------+--------+

2 rows in set (0.01 sec)



select snum , sname from salespeople where snum in (select snum from customers group by snum having count(cnum)>1);



 select snum , sname from salespeople where snum in (select snum from customers group by snum having count(cnum)>1);

+------+--------+

| snum | sname  |

+------+--------+

| 1001 | Peel   |

| 1002 | Serres |

+------+--------+





9\. Count the orders of each of the salespeople and output the results in descending order.



select s.snum, s.sname , count(o.snum) as total\_order from salespeople s join orders o on s.snum=o.snum group by s.snum,s.sname;





select s.snum, s.sname , count(o.snum) as total\_order from salespeople s join orders o on s.snum=o.snum group by s.snum,s.sname;

+------+---------+-------------+

| snum | sname   | total\_order |

+------+---------+-------------+

| 1001 | Peel    |           3 |

| 1002 | Serres  |           2 |

| 1003 | AxelRod |           2 |

| 1004 | Motika  |           1 |

| 1007 | Rifkin  |           2 |

+------+---------+-------------+

5 rows in set (0.00 sec)





10\. List the Customer table if and only if one or more of the customers in the Customer table are

located in San Jose.



select \* from customers where city in ('san jose');





note if one in san jose then print all customers



select \* from customers where exists (select 1 from customers where city = 'san jose');

+------+----------+----------+--------+------+

| CNUM | CNAME    | CITY     | RATING | SNUM |

+------+----------+----------+--------+------+

| 2001 | Hoffman  | London   |    100 | 1001 |

| 2002 | Giovanni | Rome     |    200 | 1003 |

| 2003 | Liu      | San Jose |    200 | 1002 |

| 2004 | Grass    | Berlin   |    300 | 1002 |

| 2006 | Clemens  | London   |    100 | 1001 |

| 2007 | Pereira  | Rome     |    100 | 1004 |

| 2008 | Cisneros | San Jose |    300 | 1007 |

+------+----------+----------+--------+------+

7 rows in set (0.02 sec)



select \* from customers where 'san jose' exists(select 1 from customers where city = 'san jose');





11\. Match salespeople to customers according to what city they lived in.





select s.sname,c.cname,c.city from salespeople s join customers c on c.city=s.city order by s.snum;







 select s.sname,c.cname,c.city from salespeople s join customers c on c.city=s.city order by s.snum;

+--------+----------+----------+

| sname  | cname    | city     |

+--------+----------+----------+

| Peel   | Hoffman  | London   |

| Peel   | Clemens  | London   |

| Serres | Liu      | San Jose |

| Serres | Cisneros | San Jose |

| Motika | Hoffman  | London   |

| Motika | Clemens  | London   |

| Fran   | Hoffman  | London   |

| Fran   | Clemens  | London   |

+--------+----------+----------+



12\. Find the largest order taken by each salesperson.



select s.sname, max(o.amt) from salespeople s join orders o on s.snum = o.snum group by o.snum;



select s.sname, max(o.amt) max\_amt from salespeople s join orders o on s.snum = o.snum group by o.snum order by max\_amt desc;





13\. Find customers in San Jose who have a rating above 200.



select cnum,cname,city,rating from customers where city='san jose' and rating>200;



 select cnum,cname,city,rating from customers where city='san jose' and rating>200;

+------+----------+----------+--------+

| cnum | cname    | city     | rating |

+------+----------+----------+--------+

| 2008 | Cisneros | San Jose |    300 |

+------+----------+----------+--------+



14\. List the names and commissions of all salespeople in London.



select snum, sname, city, comm from salespeople where city='london';





15\. List all the orders of salesperson Motika from the Orders table.





select s.sname , s.snum, o.cnum from salespeople s join orders o on s.snum=o.snum and s.sname = 'motika';





 select s.sname , s.snum, o.cnum from salespeople s join orders o on s.snum=o.snum and s.sname = 'motika';

+--------+------+------+

| sname  | snum | cnum |

+--------+------+------+

| Motika | 1004 | 2007 |

+--------+------+------+

1 row in set (0.01 sec)





16\. Find all customers with orders on October 3.



select \* from customers c join orders o on c.cnum=o.cnum where o.odate='1996-10-03';



select \* from customers c join orders o on c.cnum=o.cnum where o.odate='1996-10-03';

+------+----------+----------+--------+------+------+---------+------------+------+------+

| CNUM | CNAME    | CITY     | RATING | SNUM | ONUM | AMT     | ODATE      | CNUM | SNUM |

+------+----------+----------+--------+------+------+---------+------------+------+------+

| 2008 | Cisneros | San Jose |    300 | 1007 | 3001 |   18.69 | 1996-10-03 | 2008 | 1007 |

| 2007 | Pereira  | Rome     |    100 | 1004 | 3002 | 1900.10 | 1996-10-03 | 2007 | 1004 |

| 2001 | Hoffman  | London   |    100 | 1001 | 3003 |  767.19 | 1996-10-03 | 2001 | 1001 |

| 2003 | Liu      | San Jose |    200 | 1002 | 3005 | 5160.45 | 1996-10-03 | 2003 | 1002 |

| 2008 | Cisneros | San Jose |    300 | 1007 | 3006 | 1098.16 | 1996-10-03 | 2008 | 1007 |

+------+----------+----------+--------+------+------+---------+------------+------+------+





17\. Give the sums of the amounts from the Orders table, grouped by date, eliminating all those

dates where the SUM was not at least 2000.00 above the MAX amount.



select odate, sum(amt) as total\_amt from orders  where odate='1996-10-03' group by odate order by total\_amt desc;



select odate, sum(amt) as total\_amt from orders  where odate='1996-10-03' group by odate order by total\_amt desc;

+------------+-----------+

| odate      | total\_amt |

+------------+-----------+

| 1996-10-03 |   8944.59 |

+------------+-----------+



18\. Select all orders that had amounts that were greater than at least one of the orders from

October 6.





select \* from orders where amt > any (select amt from orders where odate='1996-10-06');





19\. Write a query that uses the EXISTS operator to extract all salespeople who have customers

with a rating of 300.



select s.snum, s.sname from salespeople s where exists (select 1 from customers c where c.snum = s.snum and c.rating = 300);



+------+--------+

| snum | sname  |

+------+--------+

| 1002 | Serres |

| 1007 | Rifkin |

+------+--------+







20\. Find all pairs of customers having the same rating.



select \* from customers c1 where exist (select 1 from customers c2  where c1.rating=c2.rating);



 SELECT \*

    -> FROM customers c1

    -> WHERE EXISTS (

    ->     SELECT 1

    ->     FROM customers c2

    ->     WHERE c1.rating = c2.rating

    ->       AND c1.cnum <> c2.cnum

    -> );

+------+----------+----------+--------+------+

| CNUM | CNAME    | CITY     | RATING | SNUM |

+------+----------+----------+--------+------+

| 2001 | Hoffman  | London   |    100 | 1001 |

| 2002 | Giovanni | Rome     |    200 | 1003 |

| 2003 | Liu      | San Jose |    200 | 1002 |

| 2004 | Grass    | Berlin   |    300 | 1002 |

| 2006 | Clemens  | London   |    100 | 1001 |

| 2007 | Pereira  | Rome     |    100 | 1004 |

| 2008 | Cisneros | San Jose |    300 | 1007 |

+------+----------+----------+--------+------+



SELECT \*

FROM customers

WHERE rating IN (

    SELECT rating

    FROM customers

    GROUP BY rating

    HAVING COUNT(\*) > 1

);



21\. Find all customers whose CNUM is 1000 above the SNUM of Serres.



 select \* from customers where cnum=(select snum + 1000 from salespeople where sname ='serres');

+------+----------+------+--------+------+

| CNUM | CNAME    | CITY | RATING | SNUM |

+------+----------+------+--------+------+

| 2002 | Giovanni | Rome |    200 | 1003 |

+------+----------+------+--------+------+



22\. Give the salespeople’s commissions as percentages instead of decimal numbers.





 select snum, comm\*100 percentage from salespeople;

+------+------------+

| snum | percentage |

+------+------------+

| 1001 |      12.00 |

| 1002 |      13.00 |

| 1003 |      10.00 |

| 1004 |      11.00 |

| 1005 |      26.00 |

| 1007 |      15.00 |

+------+------------+



23\. Find the largest order taken by each salesperson on each date, eliminating those MAX orders

which are less than $3000.00 in value.



select o.odate, max(o.amt) max\_amt from orders o join salespeople s on o.snum=s.snum group by o.odate having max\_amt > 3000 order by max\_amt desc;

+------------+---------+

| odate      | max\_amt |

+------------+---------+

| 1996-10-06 | 9891.88 |

| 1996-10-03 | 5160.45 |

| 1996-10-05 | 4723.00 |

+------------+---------+



24\. List the largest orders for October 3, for each salesperson.



select o.odate, max(o.amt) max\_amt from orders o join salespeople s on o.snum=s.snum where o.odate='1996-10-03' order by max\_amt desc;

+------------+---------+

| odate      | max\_amt |

+------------+---------+

| 1996-10-03 | 5160.45 |

+------------+---------+



25\. Find all customers located in cities where Serres (SNUM 1002) has customers.



select \* from customers where city in (select city from customers where (select snum from salespeople where sname='serres'));

+------+----------+----------+--------+------+

| CNUM | CNAME    | CITY     | RATING | SNUM |

+------+----------+----------+--------+------+

| 2001 | Hoffman  | London   |    100 | 1001 |

| 2002 | Giovanni | Rome     |    200 | 1003 |

| 2003 | Liu      | San Jose |    200 | 1002 |

| 2004 | Grass    | Berlin   |    300 | 1002 |

| 2006 | Clemens  | London   |    100 | 1001 |

| 2007 | Pereira  | Rome     |    100 | 1004 |

| 2008 | Cisneros | San Jose |    300 | 1007 |

+------+----------+----------+--------+------+

7 rows in set (0.02 sec)



26\. Select all customers with a rating above 200.00.



 select \* from customers where rating > 200;

+------+----------+----------+--------+------+

| CNUM | CNAME    | CITY     | RATING | SNUM |

+------+----------+----------+--------+------+

| 2004 | Grass    | Berlin   |    300 | 1002 |

| 2008 | Cisneros | San Jose |    300 | 1007 |

+------+----------+----------+--------+------+





27\. Count the number of salespeople currently listing orders in the Orders table.





28\. Write a query that produces all customers serviced by salespeople with a commission above

12%. Output the customer’s name and the salesperson’s rate of commission.





29\. Find salespeople who have multiple customers.





 select s.sname, count(c.snum) as c from salespeople s join customers c on c.snum=s.snum group by c.snum having  c>1;

+--------+---+

| sname  | c |

+--------+---+

| Peel   | 2 |

| Serres | 2 |

+--------+---+





30\. Find salespeople with customers located in their city.



select  s.sname,  s.city,c.city  from salespeople s join customers c on s.snum = c.cnum and s.city=c.city;

+--------+----------+----------+----------+

| sname  | cname    | city     | city     |

+--------+----------+----------+----------+

| Fran   | Hoffman  | London   | London   |

| Motika | Hoffman  | London   | London   |

| Peel   | Hoffman  | London   | London   |

| Serres | Liu      | San Jose | San Jose |

| Fran   | Clemens  | London   | London   |

| Motika | Clemens  | London   | London   |

| Peel   | Clemens  | London   | London   |

| Serres | Cisneros | San Jose | San Jose |

+--------+----------+----------+----------+





31\. Find all salespeople whose name starts with ‘P’ and the fourth character is ‘l’.



 select \* from salespeople WHERE SNAME LIKE 'P\_\_l%';

+------+-------+--------+------+

| SNUM | SNAME | CITY   | COMM |

+------+-------+--------+------+

| 1001 | Peel  | London | 0.12 |

+------+-------+--------+------+





32\. Write a query that uses a subquery to obtain all orders for the customer named Cisneros.

Assume you do not know his customer number.



 select cnum, onum from orders where cnum = (select cnum from customers where cname='cisneros');

+------+------+

| cnum | onum |

+------+------+

| 2008 | 3001 |

| 2008 | 3006 |

+------+------+



33\. Find the largest orders for Serres and Rifkin.



 select o.onum, o.amt, o.snum from orders o where o.snum =(select s.snum from salespeople s where s.sname= 'serres' or sname='rikin');

+------+---------+------+

| onum | amt     | snum |

+------+---------+------+

| 3005 | 5160.45 | 1002 |

| 3010 | 1309.95 | 1002 |

+------+---------+------+



34\. Extract the Salespeople table in the following order : SNUM, SNAME, COMMISSION, CITY.



 select snum, sname, comm as commission, city from salespeople;

+------+---------+------------+-----------+

| snum | sname   | commission | city      |

+------+---------+------------+-----------+

| 1001 | Peel    |       0.12 | London    |

| 1002 | Serres  |       0.13 | San Jose  |

| 1003 | AxelRod |       0.10 | New York  |

| 1004 | Motika  |       0.11 | London    |

| 1005 | Fran    |       0.26 | London    |

| 1007 | Rifkin  |       0.15 | Barcelona |

+------+---------+------------+-----------+





35\. Select all customers whose names fall in between ‘A’ and ‘G’ alphabetical range.



select \* from  customers where cname between 'a' and 'g';





 select \* from  customers where cname between 'a' and 'g';

+------+----------+----------+--------+------+

| CNUM | CNAME    | CITY     | RATING | SNUM |

+------+----------+----------+--------+------+

| 2006 | Clemens  | London   |    100 | 1001 |

| 2008 | Cisneros | San Jose |    300 | 1007 |

+------+----------+----------+--------+------+





36\. Select all the possible combinations of customers that you can assign.



37\. Select all orders that are greater than the average for October 4.



 select onum,odate, amt from orders where amt > (select avg(amt) from orders where odate='1996-10-04');

+------+------------+---------+

| onum | odate      | amt     |

+------+------------+---------+

| 3002 | 1996-10-03 | 1900.10 |

| 3005 | 1996-10-03 | 5160.45 |

| 3006 | 1996-10-03 | 1098.16 |

| 3008 | 1996-10-05 | 4723.00 |

| 3009 | 1996-10-04 | 1713.23 |

| 3010 | 1996-10-06 | 1309.95 |

| 3011 | 1996-10-06 | 9891.88 |

+------+------------+---------+



38\. Write a select command using a corelated subquery that selects the names and numbers of all

customers with ratings equal to the maximum for their city.







39\. Write a query that totals the orders for each day and places the results in descending order.



 select odate, sum(amt) as total\_sum from orders group by odate order by total\_sum desc ;

+------------+-----------+

| odate      | total\_sum |

+------------+-----------+

| 1996-10-06 |  11201.83 |

| 1996-10-03 |   8944.59 |

| 1996-10-05 |   4723.00 |

| 1996-10-04 |   1788.98 |

+------------+-----------+



40\. Write a select command that produces the rating followed by the name of each customer in

San Jose.









41\. Find all orders with amounts smaller than any amount for a customer in San Jose.



(sub query with joins)



select o.onum , o.amt, o.snum from orders o where o.amt <any(select o.amt from orders o join customers c on o.cnum = c.cnum where c.city='san jose');



+------+---------+------+

| onum | amt     | snum |

+------+---------+------+

| 3001 |   18.69 | 1007 |

| 3002 | 1900.10 | 1004 |

| 3003 |  767.19 | 1001 |

| 3006 | 1098.16 | 1007 |

| 3007 |   75.75 | 1003 |

| 3008 | 4723.00 | 1001 |

| 3009 | 1713.23 | 1003 |

| 3010 | 1309.95 | 1002 |

+------+---------+------+



42\. Find all orders with above average amounts for their customers.



select o.onum , o.amt from orders o where o.amt > (select avg(o1.amt) from orders o1  where o.cnum = o1.cnum );

+------+---------+

| onum | amt     |

+------+---------+

| 3006 | 1098.16 |

| 3009 | 1713.23 |

| 3011 | 9891.88 |

+------+---------+



43\. Write a query that selects the highest rating in each city.



 select city , max(rating) as max\_rate from customers group by city having max(rating);

+----------+----------+

| city     | max\_rate |

+----------+----------+

| London   |      100 |

| Rome     |      200 |

| San Jose |      300 |

| Berlin   |      300 |

+----------+----------+





**important**

44\. Write a query that calculates the amount of the salesperson’s commission on each order by a

customer with a rating above 100.00.





commission\_amount = order\_amount × salesperson\_commission\_rate





**45. Count the customers with ratings above San Jose’s average.**



select \* from customers where rating > (select avg(rating) from customers where city='san jose');

+------+----------+----------+--------+------+

| CNUM | CNAME    | CITY     | RATING | SNUM |

+------+----------+----------+--------+------+

| 2004 | Grass    | Berlin   |    300 | 1002 |

| 2008 | Cisneros | San Jose |    300 | 1007 |

+------+----------+----------+--------+------+

2 rows in set (0.00 sec)



**46. Write a query that  produces all pairs of salespeople with themselves as well as duplicate rows**

**with the order reversed.**





**47. Find all salespeople that are located in either Barcelona or London.**



 select \* from salespeople where city in ('Barcelona','london');

+------+--------+-----------+------+

| SNUM | SNAME  | CITY      | COMM |

+------+--------+-----------+------+

| 1001 | Peel   | London    | 0.12 |

| 1004 | Motika | London    | 0.11 |

| 1005 | Fran   | London    | 0.26 |

| 1007 | Rifkin | Barcelona | 0.15 |

+------+--------+-----------+------+



**48. Find all salespeople with only one customer.**



select snum, count(snum) as counter from  customers group by snum having counter<=1;

+------+---------+

| snum | counter |

+------+---------+

| 1003 |       1 |

| 1004 |       1 |

| 1007 |       1 |

+------+---------+



SELECT snum, COUNT(\*) AS customer\_count

FROM customers

GROUP BY snum

HAVING COUNT(\*) = 1;





**49. Write a query that joins the Customer table to itself to find all pairs of customers served by a**

**single salesperson.**







**50. Write a query that will give you all orders for more than $1000.00**



select \* from orders where amt>1000 order by amt desc;

+------+---------+------------+------+------+

| ONUM | AMT     | ODATE      | CNUM | SNUM |

+------+---------+------------+------+------+

| 3011 | 9891.88 | 1996-10-06 | 2006 | 1001 |

| 3005 | 5160.45 | 1996-10-03 | 2003 | 1002 |

| 3008 | 4723.00 | 1996-10-05 | 2006 | 1001 |

| 3002 | 1900.10 | 1996-10-03 | 2007 | 1004 |

| 3009 | 1713.23 | 1996-10-04 | 2002 | 1003 |

| 3010 | 1309.95 | 1996-10-06 | 2004 | 1002 |

| 3006 | 1098.16 | 1996-10-03 | 2008 | 1007 |

+------+---------+------------+------+------+



**51. Write a query that lists each order number followed by the name of the customer who made**

**that order.**



 select o.onum,c.cname from orders o join customers c on o.cnum = c.cnum;

+------+----------+

| onum | cname    |

+------+----------+

| 3003 | Hoffman  |

| 3007 | Giovanni |

| 3009 | Giovanni |

| 3005 | Liu      |

| 3010 | Grass    |

| 3008 | Clemens  |

| 3011 | Clemens  |

| 3002 | Pereira  |

| 3001 | Cisneros |

| 3006 | Cisneros |

+------+----------+





**52. Write 2 queries that select all salespeople (by name and number) who have customers in their**

**cities who they do not service, one using a join and one a corelated subquery. Which solution**

**is more elegant?**



 select s.sname, s.snum from salespeople s join customers c on s.city=c.city and s.snum<>c.snum;

+--------+------+

| sname  | snum |

+--------+------+

| Fran   | 1005 |

| Motika | 1004 |

| Fran   | 1005 |

| Motika | 1004 |

| Serres | 1002 |

+--------+------+

5 rows in set (0.03 sec)





select s.sname, s.snum from salespeople s where snum !=any (select c.snum from customers c where c.city=s.city);



SELECT s.sname, s.snum

FROM salespeople s

WHERE EXISTS (

  SELECT 1

  FROM customers c

  WHERE c.city = s.city

)

AND NOT EXISTS (

  SELECT 1

  FROM customers c

  WHERE c.snum = s.snum

  AND c.city = s.city

);





**53. Write a query that selects all customers whose ratings are equal to or greater than ANY (in the**

**SQL sense) of Serres’?**



select \* from customers where rating >any(select c.rating  from customers c join salespeople s on s.snum=c.snum and s.sname = "serres");

+------+----------+----------+--------+------+

| CNUM | CNAME    | CITY     | RATING | SNUM |

+------+----------+----------+--------+------+

| 2004 | Grass    | Berlin   |    300 | 1002 |

| 2008 | Cisneros | San Jose |    300 | 1007 |

+------+----------+----------+--------+------+





**54. Write 2 queries that will produce all orders taken on October 3 or October 4.**



select \* from orders where odate in ("1996-10-03","1996-10-04");

+------+---------+------------+------+------+

| ONUM | AMT     | ODATE      | CNUM | SNUM |

+------+---------+------------+------+------+

| 3001 |   18.69 | 1996-10-03 | 2008 | 1007 |

| 3002 | 1900.10 | 1996-10-03 | 2007 | 1004 |

| 3003 |  767.19 | 1996-10-03 | 2001 | 1001 |

| 3005 | 5160.45 | 1996-10-03 | 2003 | 1002 |

| 3006 | 1098.16 | 1996-10-03 | 2008 | 1007 |

| 3007 |   75.75 | 1996-10-04 | 2002 | 1003 |

| 3009 | 1713.23 | 1996-10-04 | 2002 | 1003 |

+------+---------+------------+------+------+



select \* from orders where odate = "1996-10-03" or odate="1996-10-04";

+------+---------+------------+------+------+

| ONUM | AMT     | ODATE      | CNUM | SNUM |

+------+---------+------------+------+------+

| 3001 |   18.69 | 1996-10-03 | 2008 | 1007 |

| 3002 | 1900.10 | 1996-10-03 | 2007 | 1004 |

| 3003 |  767.19 | 1996-10-03 | 2001 | 1001 |

| 3005 | 5160.45 | 1996-10-03 | 2003 | 1002 |

| 3006 | 1098.16 | 1996-10-03 | 2008 | 1007 |

| 3007 |   75.75 | 1996-10-04 | 2002 | 1003 |

| 3009 | 1713.23 | 1996-10-04 | 2002 | 1003 |

+------+---------+------------+------+------+



**55. Write a query that produces all pairs of orders by a given customer. Name that customer and**

**eliminate duplicates.**



select c.cname, o.onum from customers c join orders o on c.cnum=o.cnum where group by o.cnum;







**56. Find only those customers whose ratings are higher than every customer in Rome.**



 select \*from customers where rating>all (select rating from customers where city='rome');

+------+----------+----------+--------+------+

| CNUM | CNAME    | CITY     | RATING | SNUM |

+------+----------+----------+--------+------+

| 2004 | Grass    | Berlin   |    300 | 1002 |

| 2008 | Cisneros | San Jose |    300 | 1007 |

+------+----------+----------+--------+------+



select \*from customers where rating>(select max(rating) from customers where city='rome');









57\. Write a query on the Customers table whose output will exclude all customers with a rating <=

100.00, unless they are located in Rome.



select \* from customers where rating>100 or city='rome';





select \* from customers where (rating>=100 or city='rome');





**58. Find all rows from the Customers table for which the salesperson number is 1001.**



select c.cnum , s.snum from customers c join salespeople s on c.snum=s.snum where s.snum=1001;



select \* from customers where snum=1001;



**59. Find the total amount in Orders for each salesperson for whom this total is greater than the**

**amount of the largest order in the table.**



select s.snum, sum(o.amt) total\_amt from orders o join salespeople s on o.snum=s.snum group by s.snum having total\_amt > max(o.amt);



select s.snum, sum(o.amt) total\_amt from orders o join salespeople s on o.snum=s.snum group by s.snum having total\_amt > max(o.amt);

+------+-----------+

| snum | total\_amt |

+------+-----------+

| 1007 |   1116.85 |

| 1001 |  15382.07 |

| 1002 |   6470.40 |

| 1003 |   1788.98 |

+------+-----------+



60\. Write a query that selects all orders save those with zeroes or NULLs in the amount field.



select \* from orders where amt!=0 and amt is not null;



**61. Produce all combinations of salespeople and customer names such that the former precedes**

**the latter alphabetically, and the latter has a rating of less than 200.**











**62. List all Salespeople’s names and the Commission they have earned.**



select \* from salespeople where comm!=0 and comm is not null;



**63. Write a query that produces the names and cities of all customers with the same rating as**

**Hoffman. Write the query using Hoffman’s CNUM rather than his rating, so that it would still be**

**usable if his rating changed.**



select \* from customers where rating = (select rating from customers where cname='hoffman');



**64. Find all salespeople for whom there are customers that follow them in alphabetical order.**







**65. Write a query that produces the names and ratings of all customers of all who have above**

**average orders.**



select c.cname, c.rating from customers c join orders o on c.cnum=o.cnum ;



**66. Find the SUM of all purchases from the Orders table.**



select sum(amt) as total\_amt from orders;



**67. Write a SELECT command that produces the order number, amount and date for all rows in**

**the order table.**



select onum, amt, \[date] from orders





**68. Count the number of nonNULL rating fields in the Customers table (including repeats).**



select count(rating) from customers;



**69. Write a query that gives the names of both the salesperson and the customer for each order**

**after the order number.**





mysql> select o.onum, s.sname, c.cname from orders o join customers c on o.cnum=c.cnum join salespeople s on s.snum = c.snum;

+------+---------+----------+

| onum | sname   | cname    |

+------+---------+----------+

| 3003 | Peel    | Hoffman  |

| 3007 | AxelRod | Giovanni |

| 3009 | AxelRod | Giovanni |

| 3005 | Serres  | Liu      |

| 3010 | Serres  | Grass    |

| 3008 | Peel    | Clemens  |

| 3011 | Peel    | Clemens  |

| 3002 | Motika  | Pereira  |

| 3001 | Rifkin  | Cisneros |

| 3006 | Rifkin  | Cisneros |

+------+---------+----------+



**70. List the commissions of all salespeople servicing customers in London.**



select Distinct s.comm from salespeople s join customers c on s.snum=c.snum where c.city = 'london';



**71. Write a query using ANY or ALL that will find all salespeople who have no customers located in**

**their city.**



SELECT \*

FROM salespeople s

WHERE s.city <> ALL (

    SELECT c.city

    FROM customers c





SELECT \*

FROM salespeople s

WHERE NOT EXISTS (

    SELECT 1

    FROM customers c

    WHERE c.snum = s.snum

      AND c.city = s.city

);







**72. Write a query using the EXISTS operator that selects all salespeople with customers located in**

**their cities who are not assigned to them.**







**73. Write a query that selects all customers serviced by Peel or Motika. (Hint : The SNUM field**

**relates the two tables to one another.)**



select c.cname, s.sname, s.snum from customers c join salespeople s on c.snum=s.snum where s.sname = 'peel' or s.sname = 'motika';





**74. Count the number of salespeople registering orders for each day. (If a salesperson has more**

**than one order on a given day, he or she should be counted only once.)**



 select o.odate , COUNT(DISTINCT s.snum) from salespeople s join orders o on s.snum=o.snum  group by  o.odate order by o.odate;

+------------+------------------------+

| odate      | COUNT(DISTINCT s.snum) |

+------------+------------------------+

| 1996-10-03 |                      4 |

| 1996-10-04 |                      1 |

| 1996-10-05 |                      1 |

| 1996-10-06 |                      2 |

+------------+------------------------+





**75. Find all orders attributed to salespeople in London.**





select \* from orders where snum =any (select snum from salespeople where city='london');



select \* from orders where snum in (select snum from salespeople where city='london');



select o.\* from orders o join salespeople s on o.snum = s.snum where s.city='london';



+------+---------+------------+------+------+

| ONUM | AMT     | ODATE      | CNUM | SNUM |

+------+---------+------------+------+------+

| 3003 |  767.19 | 1996-10-03 | 2001 | 1001 |

| 3008 | 4723.00 | 1996-10-05 | 2006 | 1001 |

| 3011 | 9891.88 | 1996-10-06 | 2006 | 1001 |

| 3002 | 1900.10 | 1996-10-03 | 2007 | 1004 |

+------+---------+------------+------+------+





**76. Find all orders by customers not located in the same cities as their salespeople.**



mysql> select o.\* from orders o join customers c on c.cnum=o.cnum join salespeople s on o.snum = s.snum where s.city<>c.city;

+------+---------+------------+------+------+

| ONUM | AMT     | ODATE      | CNUM | SNUM |

+------+---------+------------+------+------+

| 3007 |   75.75 | 1996-10-04 | 2002 | 1003 |

| 3009 | 1713.23 | 1996-10-04 | 2002 | 1003 |

| 3010 | 1309.95 | 1996-10-06 | 2004 | 1002 |

| 3002 | 1900.10 | 1996-10-03 | 2007 | 1004 |

| 3001 |   18.69 | 1996-10-03 | 2008 | 1007 |

| 3006 | 1098.16 | 1996-10-03 | 2008 | 1007 |

+------+---------+------------+------+------+

6 rows in set (0.00 sec)





77\. Find all salespeople who have customers with more than one current order.



select distinct s.\* from salespeople s join customers c on s.snum = c.snum join orders o on c.cnum = o.cnum group by c.cnum having count(o.onum)>1;



+------+---------+-----------+------+

| SNUM | SNAME   | CITY      | COMM |

+------+---------+-----------+------+

| 1001 | Peel    | London    | 0.12 |

| 1003 | AxelRod | New York  | 0.10 |

| 1007 | Rifkin  | Barcelona | 0.15 |

+------+---------+-----------+------+

3 rows in set (0.00 sec)



**78. Write a query that extracts from the Customers table every customer assigned to a**

**salesperson who currently has at least one other customer (besides the customer being**

**selected) with orders in the Orders table.**

trick--------

SELECT c1.\*

FROM customers c1

WHERE EXISTS (

    SELECT 1

    FROM customers c2

    JOIN orders o ON c2.cnum = o.cnum

    WHERE c2.snum = c1.snum    -- same salesperson

      AND c2.cnum <> c1.cnum   -- other customer

);







**79. Write a query that selects all customers whose names begin with ‘C’.**



select \* from customers where cname like 'c%';







**80. Write a query on the Customers table that will find the highest rating in each city. Put the output**

**in this form : for the city (city) the highest rating is : (rating).**





select city , max(rating) from customers group by city ;



 select concat('for the city',city,'the highest rating is : ',max(rating)) as result from customers group by city;

+-------------------------------------------------+

| result                                          |

+-------------------------------------------------+

| for the cityLondonthe highest rating is : 100   |

| for the cityRomethe highest rating is : 200     |

| for the citySan Josethe highest rating is : 300 |

| for the cityBerlinthe highest rating is : 300   |

+-------------------------------------------------+

4 rows in set (0.01 sec)





**81. Write a query that will produce the SNUM values of all salespeople with orders currently in the** 

**Orders table (without any repeats).** 



&nbsp;SELECT DISTINCT s.snum, s.sname

&nbsp;   -> FROM salespeople s

&nbsp;   -> JOIN orders o ON s.snum = o.snum;

+------+---------+

| snum | sname   |

+------+---------+

| 1001 | Peel    |

| 1002 | Serres  |

| 1003 | AxelRod |

| 1004 | Motika  |

| 1007 | Rifkin  |

+------+---------+



SELECT DISTINCT snum

&nbsp;   -> FROM orders;

+------+

| snum |

+------+

| 1001 |

| 1002 |

| 1003 |

| 1004 |

| 1007 |

+------+







 

