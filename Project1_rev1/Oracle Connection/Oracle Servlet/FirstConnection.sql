--CREATE TABLE lookuptable_role (userrole_id NUMBER (15), status VARCHAR2 (15), Primary Key (userrole_id));

--CREATE TABLE lookuptable_ReimStatus (reimstatus_id NUMBER (15), status VARCHAR2 (15), Primary Key (reimstatus_id));


--CREATE TABLE lookuptable_ReimType (reimtpye_id NUMBER (15), status VARCHAR (15), Primary Key (reimtpye_id));

CREATE TABLE usertable2
(user_id NUMBER (15), firstname VARCHAR2 (15), lastname VARCHAR2 (15), password VARCHAR2 (15), userrole_id NUMBER (15), Primary Key (user_id),Constraint rolefk2 FOREIGN Key (userrole_id) 
REFERENCES lookuptable_role (userrole_id));

--CREATE TABLE reimtable (reim_id NUMBER (15),auth_id NUMBER (15), resolver_id NUMBER (15), reimstatus_id NUMBER (15), reimtpye_id NUMBER (15) ,reciptimage VARCHAR (15), Primary Key (reim_id), 
--Constraint userrolefk FOREIGN Key (auth_id) REFERENCES usertable (user_id), 
--Constraint resolverrolefk FOREIGN Key (resolver_id) REFERENCES usertable (user_id), 
--Constraint reimstatusfk FOREIGN Key (reimstatus_id) REFERENCES lookuptable_ReimStatus (reimstatus_id),
--Constraint reimtypefk FOREIGN Key (reimtpye_id) REFERENCES lookuptable_ReimType (reimtpye_id));

--INSERT INTO lookuptable_role VALUES ( 1, 'Employee');

--INSERT INTO lookuptable_role VALUES ( 2, 'Manager');

--INSERT INTO lookuptable_role VALUES ( 3, 'SuperManager');

--INSERT INTO lookuptable_ReimStatus VALUES ( 1, 'Pending');

--INSERT INTO lookuptable_ReimStatus VALUES ( 2, 'Approved');

--INSERT INTO lookuptable_ReimStatus VALUES ( 3, 'Denied');

--INSERT INTO lookuptable_ReimType VALUES ( 1, 'Lodging');

--INSERT INTO lookuptable_ReimType VALUES ( 2, 'Travel');

--INSERT INTO lookuptable_ReimType VALUES ( 3, 'Other');

--INSERT INTO usertable2 VALUES ( 1, 'James', 'Cameron', 12345, 1);

INSERT INTO usertable2 VALUES ( 3, 'Jim', 'Chan', 'cool', 3);

INSERT INTO usertable2 VALUES ( 4, 'Bob', 'Chan', 'cool', 1);

--INSERT INTO reimtable VALUES (1, 1, 2, 1, 1, 'noimage');

--Select * from usertable2 WHERE firstname = 'Jack';

Select firstname From usertable2 WHERE firstname = 'Jim';

commit;