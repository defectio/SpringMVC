-- springMVC sec06_resultmap에서 필요한 table

--drop table OrderItem;

CREATE TABLE OrderItem (
    id varchar2(10),
    cnt number(8),
    remark varchar2(10),
    address varchar2(50)
);

--ALTER TABLE OrderItem ADD CONSTRAINT order_id_pk PRIMARY KEY(num);

