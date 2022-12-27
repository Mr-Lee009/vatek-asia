select * from
(select adddate('1970-01-01',t4.i*10000 + t3.i*1000 + t2.i*100 + t1.i*10 + t0.i) selected_date from
 (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t0,
 (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t1,
 (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t2,
 (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t3,
 (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t4) v
where selected_date between '2022-12-01' and '2022-12-31' order by selected_date asc;

DELIMITER $$
CREATE PROCEDURE createDayOfMonth()
BEGIN
   select * from
             (select adddate('1970-01-01',t4.i*10000 + t3.i*1000 + t2.i*100 + t1.i*10 + t0.i) selected_date from
             (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t0,
             (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t1,
             (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t2,
             (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t3,
             (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t4) v
   where selected_date between '2022-12-01' and '2022-12-31' order by selected_date asc;
END; $$
DELIMITER ;


call createDayOfMonth();

CREATE DATABASE vatek_hotel;
USE vatek_hotel;


create table hotel(
  ID int(11) auto_increment primary key ,
  NAME_HOTEL nvarchar(256) UNIQUE NOT NULL ,
  DESCRIPTION nvarchar(1024)
);

create table zoom(
  ID int(11) auto_increment primary key ,
  NAME_ZOOM nvarchar(256) UNIQUE NOT NULL ,
  DESCRIPTION nvarchar(1024),
  ROOM_TYPE nvarchar(1024),
  ID_HOTEL int(11) NOT NULL
);

create table user(
  ID int(11) auto_increment primary key ,
  NAME nvarchar(256)
);


ALTER TABLE zoom ADD FOREIGN KEY(ID_HOTEL) REFERENCES hotel(ID);

create table booking(
  ID int(11) auto_increment primary key ,
  ID_ZOOM int(11) NOT NULL ,
  ID_USER int(11) NOT NULL ,
  FROM_DATE DATETIME NOT NULL ,
  TO_DATE DATETIME NOT NULL,
  FOREIGN KEY(ID_ZOOM) REFERENCES zoom(ID),
  FOREIGN KEY(ID_USER) REFERENCES user(ID)
);

select * from user;
select * from hotel;
select * from zoom;
select * from booking;

select * from booking  where DATE(FROM_DATE) BETWEEN DATE (NOW()) AND DATE (NOW()+3);

select *  from
    (select selected_date from
             (select adddate('1970-01-01',t4.i*10000 + t3.i*1000 + t2.i*100 + t1.i*10 + t0.i) selected_date from
             (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t0,
             (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t1,
             (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t2,
             (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t3,
             (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t4) v
   where selected_date between '2022-12-01' and '2022-12-31' order by selected_date asc) date_of_month
   left join

(select * from booking ) booking_zoom

on  selected_date = DATE(booking_zoom.FROM_DATE)
order by  selected_date;
;

select * from booking where ID_ZOOM = 1;

select DATE(NOW());

CREATE PROCEDURE checlOverLap();



DELIMITER $$
CREATE PROCEDURE checkOverLapV4(IN formDate NVARCHAR(256),IN toDate NVARCHAR(256))
BEGIN
    Declare v_Count Integer default 0;
    Declare v_Found Integer default 1;

    DECLARE _formDate DATETIME;
    DECLARE _toDate DATETIME;

    DECLARE _query_formDate DATETIME;
    DECLARE _query_toDate DATETIME;

    DECLARE _isOverLap BOOLEAN DEFAULT FALSE;

    Declare My_Cursor CURSOR for (select FROM_DATE,TO_DATE from booking  where ID_ZOOM = 1);

    DECLARE CONTINUE HANDLER FOR NOT FOUND Set v_Found = 0;
    Open My_Cursor;
    My_Loop :
    loop
        fetch My_Cursor into _formDate,_toDate;

        set _query_toDate = STR_TO_DATE(toDate,'%Y-%m-%d %H:%i:%s');
        set _query_formDate = STR_TO_DATE(formDate,'%Y-%m-%d %H:%i:%s');

        if v_Found = 0 then
            Leave My_Loop;
        End if;

        if((_query_formDate <= _toDate) and (_query_toDate >= _formDate)) then
            set _isOverLap = true;
        end if;

        Set v_Count = v_Count + 1;

    end loop My_Loop;
    -- Đóng con trỏ.

    select _isOverLap as isOverLap , v_Count as count;
    close My_Cursor;
     Set v_Count = 0;
END; $$
DELIMITER ;


call checkOverLapV3('2022-11-05 16:41:18','2024-11-30 16:41:26');

select * from booking;

select STR_TO_DATE('2022-12-27 16:41:18','%Y-%m-%d %H:%i:%s');

select (StartA <= EndB) and (EndA >= StartB);

select (STR_TO_DATE('2022-12-05 16:41:18','%Y-%m-%d %H:%i:%s') <= STR_TO_DATE('2022-11-05 16:41:18','%Y-%m-%d %H:%i:%s'))
    and (STR_TO_DATE('2022-12-10 16:41:18','%Y-%m-%d %H:%i:%s') >= STR_TO_DATE('2022-12-04 16:41:18','%Y-%m-%d %H:%i:%s'));
