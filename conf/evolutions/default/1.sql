# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table discount_coupon (
  id                        bigint not null,
  customer_name             varchar(255),
  value                     double,
  constraint pk_discount_coupon primary key (id))
;

create sequence discount_coupon_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists discount_coupon;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists discount_coupon_seq;

