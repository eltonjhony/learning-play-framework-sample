# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table discount_coupon (
  id                        bigint auto_increment not null,
  customer_name             varchar(255),
  value                     double,
  constraint pk_discount_coupon primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table discount_coupon;

SET FOREIGN_KEY_CHECKS=1;

