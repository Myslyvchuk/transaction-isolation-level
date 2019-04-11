DROP TABLE IF EXISTS public.customer_info;


 CREATE TABLE public.customer_info
 (
     cust_name character varying(255) NOT NULL,
     balance bigint,
     CONSTRAINT customer_info_cust_name_key UNIQUE (cust_name)
 );