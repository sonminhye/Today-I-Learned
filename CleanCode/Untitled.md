```
-- Suggested testing environment:
-- http://sqlite.online/

-- Example case create statement:
CREATE TABLE directors (
  id INTEGER NOT NULL PRIMARY KEY,
  name VARCHAR(30) NOT NULL
);

CREATE TABLE movies (
  id INTEGER NOT NULL PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
  directorId INTEGER NOT NULL REFERENCES directors (id)
);

INSERT INTO directors(id, name) VALUES(1, 'Michael Curtiz');
INSERT INTO directors(id, name) VALUES(2, 'Alfred Hitchcock');
INSERT INTO directors(id, name) VALUES(3, 'Steven Spielberg');

INSERT INTO movies(id, name, directorId) VALUES(1, 'Casablanca', 1);
INSERT INTO movies(id, name, directorId) VALUES(2, 'Yankee Doodle Dandy', 1);
INSERT INTO movies(id, name, directorId) VALUES(3, 'Psycho', 2);

-- Expected output (in any order):
-- director         number of films
-- ------------------------------
-- Michael Curtiz   2
-- Alfred Hitchcock 1
-- Steven Spielberg 0

-- Explanation:
-- In this example.
-- Casablanca and Yankee Doodle Dandy were both directed by Michael Curtiz, so he has two films.
-- Alfred Hitchcock has directed only Psycho, so he has one film.
-- Steven Spielberg has not directed any films, so he has a total of 0.
```





```
-- Suggested testing environment: 
-- http://sqlite.online/

-- Example case create statement:
CREATE TABLE roads (
  name VARCHAR(20) PRIMARY KEY NOT NULL,
  length INTEGER NOT NULL
);

INSERT INTO roads(name, length) VALUES('A417', 120);  
INSERT INTO roads(name, length) VALUES('A40', 532);  
INSERT INTO roads(name, length) VALUES('B41', 27);  
INSERT INTO roads(name, length) VALUES('M25', 480);  
INSERT INTO roads(name, length) VALUES('M1', 982);

-- Insert answer here

SELECT * FROM longRoads;

-- Expected output (in any order):
-- name    length
-- ----------------------------
-- A40     532
-- M25     480
-- M1      982
```





```
-- Suggested testing environment:
-- http://sqlite.online/

-- Insert answer here

INSERT INTO locations(id, address, latitude, longitude) VALUES(1, '124 Southampton Row, Bloomsbury, London', 51.520686, -0.123091);
INSERT INTO locations(id, address, latitude, longitude) VALUES(2, 'Woodlands Heights, Vanbrugh Hill, London', 51.4826, 0.0077);

SELECT * FROM locations;

-- Expected output (in any order):
-- id    address                                     latitude     longitude
-- ------------------------------------------------------------------------
-- 1     124 Southampton Row, Bloomsbury, London     51.520686    -0.123091
-- 2     Woodlands Heights, Vanbrugh Hill, London    51.4826      0.0077
```





```
-- Suggested testing environment:
-- http://sqlite.online/

-- Example case create statement:
CREATE TABLE employees (
  id INTEGER NOT NULL PRIMARY KEY,
  name VARCHAR(30) NOT NULL
);

CREATE TABLE sales (
  employeeId INTEGER NOT NULL REFERENCES employees(id), 
  value INTEGER NOT NULL CHECK(value > 0)
);

INSERT INTO employees(id, name) VALUES(1, 'John');
INSERT INTO employees(id, name) VALUES(2, 'Mark');
INSERT INTO employees(id, name) VALUES(3, 'Jane');

INSERT INTO sales(employeeId, value) VALUES(1, 100);
INSERT INTO sales(employeeId, value) VALUES(3, 300);

-- Expected output:
-- name
-- ----
-- Mark

-- Explanation:
-- In this example.
-- John and Jane both have sales. Only Mark has no sales.
```





```
import java.util.ArrayList;
import java.util.List;

public class Shelf {
    private List<String> items = new ArrayList<>();
    
    public void put(String item) {
        if(item != null && !item.isEmpty()) {
            this.items.add(item);
        }
    }
	    
    public boolean take(String item) {
        if(items.contains(item)) {
            items.remove(item);
            return true;
        }
        
        return false;
    }
}
```







```
-- Suggested testing environment:
-- http://sqlite.online/

-- Example case create statement:
CREATE TABLE fsia (
  companyName VARCHAR(30) NOT NULL PRIMARY KEY,
  marketCapitalization FLOAT NOT NULL
);

CREATE TABLE fsib (
  companyName VARCHAR(30) NOT NULL PRIMARY KEY,
  sharePrice FLOAT NOT NULL,
  sharesOutstanding INTEGER NOT NULL
);

INSERT INTO fsia(companyName, marketCapitalization) VALUES('Baggage Enterprise.', 12500);
INSERT INTO fsia(companyName, marketCapitalization) VALUES('Fun Book Corporation', 10000);

INSERT INTO fsib(companyName, sharePrice, sharesOutstanding) VALUES('Macaroni Inc.', 8, 1000);
INSERT INTO fsib(companyName, sharePrice, sharesOutstanding) VALUES('Solitude Ltd.', 12.5, 600);
INSERT INTO fsib(companyName, sharePrice, sharesOutstanding) VALUES('Universal Exports LLC', 1.2, 2300);

-- Expected output:
-- companyName           marketCapitalization
-- ---------------------------------------------
-- Baggage Enterprise    12500 
-- Fun Book Corporation  10000 
-- Macaroni Inc.         8000 
-- Solitude Ltd.         7500 
-- Universal Exports LLC 2760  

-- Explanation:
-- In this example.
-- Baggage Enterprise is the largest company, it therefore appears first in the results.
-- The companies descend in order by marketCapitalization until Universal Exports LLC which is the smallest.
```





```
-- Suggested testing environment: 
-- http://sqlite.online/

-- Insert answer here

-- The statements below should pass.
INSERT INTO menuItems(id, title, url) VALUES(1, 'Home', 'https://www.testdome.com');
INSERT INTO menuItems(id, title, url) VALUES(2, 'For developers', 'https://www.testdome.com/for-developers');
INSERT INTO menuItems(id, title, url) VALUES(3, 'Certificates', 'https://www.testdome.com/certificates');

-- The statement below should fail because its using the same url value as the menu item with id 3.
INSERT INTO menuItems(id, title, url) VALUES(4, 'Question marketplace', 'https://www.testdome.com/certificates');
```