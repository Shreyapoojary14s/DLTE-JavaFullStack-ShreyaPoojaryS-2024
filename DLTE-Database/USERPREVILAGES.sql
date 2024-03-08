
SQL> create user Asha identified by asha1234;

User created.

SQL> grant select on transactionsanalysis to asha;

Grant succeeded.


SQL> grant connect to Asha;
Grant succeeded

SQL> alter session set current_schema=system;

//delete
SQL> create user SEETHARAM identified by seetha1234 ;

User created.

SQL> grant delete on transactionsanalysis to seetha;

Grant succeeded.

SQL> grant connect to SEETHARAM;
Grant succeeded.

SQL> alter session set current_schema=system;

Session altered.

--GRANT 
SQL> create user Harith identified by shreya123;

User created.

SQL> grant select on transactionsanalysis to shreya;

Grant succeeded.

SQL> grant connect to shreya;

Grant succeeded.

SQL> alter session set current_schema=system;

Session altered.

-------SIRI
SQL> create user siri identified by siri1234;

User created.

SQL> grant insert on transactionsanalysis to siri;

Grant succeeded.

SQL> grant connect to siri;

Grant succeeded.

SQL> alter session set current_schema=system;

Session altered.


SQL> create user nandu identified by siri1234;

User created.

SQL> grant update on transactionsanalysis to siri;

Grant succeeded.

SQL> grant connect to siri;

Grant succeeded.

SQL> alter session set current_schema=system;

Session altered.