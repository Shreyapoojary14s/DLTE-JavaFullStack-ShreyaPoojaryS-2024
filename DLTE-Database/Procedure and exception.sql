---transaction analysis procedure and exception

create or replace procedure insert_transaction(
    t_id number,
    t_date date,
    t_to varchar2,
    t_amount number,
    t_remark varchar2,
    infos_op out varchar2
    )
as
begin 
 insert into Transactions_Task(transaction_id,transaction_amount,transaction_date,transaction_to,transaction_remarks) values(t_id,t_amount,t_date,t_to,t_remark);
 infos_op:='done';
exception 
when OTHERS then 
infos_op:='not done'||SQLERRM;
end;
/

variable infos_op varchar2;
execute insert_transaction(TRANSACTION_SEQUENCE.nextval,'20-JAN-2020','Shreya',650,'Education',:infos_op);
print infos_op;


create or replace procedure delete_date(
  enter_date date,
  err_info out VARCHAR
  )
  as
  begin 
   delete from transactions_task where transaction_date=enter_date;
   err_info:='no error';
  exception
   when others then
   err_info:='error due to'||SQLERRM;
END;
/



52
variable err_info varchar2;
execute delete_date('22-FEB-2022',:err_info);


create or replace procedure filter_transactions(
   to_names out VARCHAR2,
   filter_err out VARCHAR2   
)
as 
 begin select transaction_to into to_names from transactions_task where transaction_remarks='Education';
 filter_err:='done';
 exception
  when no_data_found then
  filter_err:='No data ';
  when others then
  filter_err:='error due to'||SQLERRM;
end;
/
variable to_name varchar;
variable filter_error varchar2;
execute filter_transactions(:to_name,:filter_error);
print to_name;
print filter_error;