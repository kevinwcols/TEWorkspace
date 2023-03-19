-- Database: Meetups

DROP DATABASE IF EXISTS Meetups;

CREATE DATABASE Meetups
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

DROP TABLESPACE IF EXISTS indexspace;

-- you have to create the pg_indexes subdirectory before this statement will work
CREATE TABLESPACE indexspace OWNER postgres LOCATION 'C:\Program Files\PostgreSQL\12\data\pg_indexes' ;

BEGIN TRANSACTION;

DROP TABLE IF EXISTS member, interest_group, interest_group_member, event, event_group_member CASCADE;
DROP SEQUENCE IF EXISTS seq_member, seq_interest_group, seq_event_number; 

/* need a junction table if you have a many to many relationship per David Evans */
/* Each Member has the following attributes:

* Member Number
* Last Name
* First Name
* Email Address
* Phone Number (some members may not provide one)
* Date of Birth
* Flag indicating if they want reminder emails  */

CREATE SEQUENCE seq_member;

CREATE TABLE member (
    member_number int NOT NULL DEFAULT nextval('seq_member'),
    last_name varchar(75) NOT NULL,
    first_name varchar(75) NOT NULL,
    email_address varchar(75) NOT NULL,
    phone_number varchar(25),
    birthday date NOT NULL,
    reminder_email_flag numeric(1) NOT NULL DEFAULT 0,
	CONSTRAINT PK_member PRIMARY KEY(member_number)
);

CREATE INDEX idx_mem_member_number ON member(member_number) TABLESPACE indexspace; 
CREATE INDEX idx_mem_last_name ON member(last_name) TABLESPACE indexspace;
CREATE INDEX idx_mem_first_name ON member(first_name) TABLESPACE indexspace;
CREATE INDEX idx_mem_email_address ON member(email_address) TABLESPACE indexspace;
CREATE INDEX idx_mem_reminder_email_flag ON member(reminder_email_flag) TABLESPACE indexspace;

/*
Each Interest Group has the following attributes:

* Group Number
* Name (no two groups can have the same name)
* Has zero-to-many Members  
*/

CREATE SEQUENCE seq_interest_group;

CREATE TABLE interest_group (
    group_number int NOT NULL DEFAULT nextval('seq_interest_group'),
    group_name varchar(75) NOT NULL UNIQUE,
	CONSTRAINT PK_group_number PRIMARY KEY(group_number)
);

CREATE INDEX idx_ig_group_number ON interest_group(group_number) TABLESPACE indexspace; 
CREATE INDEX idx_ig_group_name ON interest_group(group_name) TABLESPACE indexspace;

CREATE TABLE interest_group_member (
    group_number int NOT NULL,
    member_number int,
	PRIMARY KEY(group_number, member_number),
	FOREIGN KEY(group_number) REFERENCES interest_group(group_number),
    FOREIGN KEY(member_number) REFERENCES member(member_number)
);

CREATE INDEX idx_igm_group_number ON interest_group_member(group_number) TABLESPACE indexspace;
CREATE INDEX idx_igm_member_number ON interest_group_member(member_number) TABLESPACE indexspace;

/* Each Event has the following attributes:

* Event Number
* Name
* Description
* Start Date and Time
* Duration (minimum of 30 minutes)
* Group running this event
* Has zero-to-many Members */

CREATE SEQUENCE seq_event_number;

CREATE TABLE event (
    event_number int NOT NULL DEFAULT nextval('seq_event_number'),
    event_name varchar(100) NOT NULL,
    description varchar(200),
    start_date timestamp DEFAULT current_timestamp,
    duration_in_minutes int DEFAULT 30 CHECK (duration_in_minutes >= 30),
	CONSTRAINT PK_event_number PRIMARY KEY(event_number)
);

CREATE INDEX idx_event_event_number ON event(event_number) TABLESPACE indexspace;
CREATE INDEX idx_event_event_name ON event(event_name) TABLESPACE indexspace;
CREATE INDEX idx_event_start_date ON event(start_date) TABLESPACE indexspace;
CREATE INDEX idx_event_duration_in_minutes ON event(duration_in_minutes) TABLESPACE indexspace;

CREATE TABLE event_group_member (
    event_number int NOT NULL,
    member_number int,
    group_number int NOT NULL,
	    PRIMARY KEY(event_number, member_number, group_number),
	    FOREIGN KEY(event_number) REFERENCES event(event_number),
        FOREIGN KEY(member_number) REFERENCES member(member_number),
        FOREIGN KEY(group_number) REFERENCES interest_group(group_number)
);

CREATE INDEX idx_idx_egm_event_number ON event_group_member(event_number) TABLESPACE indexspace;
CREATE INDEX idx_egm_member_number ON event_group_member(member_number) TABLESPACE indexspace;
CREATE INDEX idx_egm_group_number ON event_group_member(group_number) TABLESPACE indexspace;

/*
Requirements
1.) All tables must have a primary key.
2.) Populate the tables with data for at least four events, three groups, and eight members.
3.) Make sure each event has at least one member assigned to it, and each group has at least two members.
*/

INSERT INTO MEMBER ( member_number, last_name, first_name, email_address, phone_number, birthday, reminder_email_flag)
VALUES (nextval('seq_member'), 'Wenger', 'Kevin', 'kevinwcols@yahoo.com', '614-555-5111', '1900-01-25', 1 );

INSERT INTO MEMBER ( member_number, last_name, first_name, email_address, phone_number, birthday, reminder_email_flag)
VALUES (nextval('seq_member'), 'Smith', 'Sarah', 'ssmith@gmail.com', '614-444-4444', '1956-05-21', 0 );

INSERT INTO MEMBER ( member_number, last_name, first_name, email_address, phone_number, birthday, reminder_email_flag)
VALUES (nextval('seq_member'), 'Watt', 'TJ', 'tjthegreat@gmail.com', 'null', '1998-03-09', 1 );

INSERT INTO MEMBER ( member_number, last_name, first_name, email_address, phone_number, birthday, reminder_email_flag)
VALUES (nextval('seq_member'), 'Steele', 'Sage', 'ssteele@gmail.com', null, '1987-10-12', 0 );

INSERT INTO MEMBER ( member_number, last_name, first_name, email_address, phone_number, birthday, reminder_email_flag)
VALUES (nextval('seq_member'), 'Day', 'Ryan', 'rday@yahoo.com', '614-GOBUCKS', '1970-03-23', 0 );

INSERT INTO MEMBER ( member_number, last_name, first_name, email_address, phone_number, birthday, reminder_email_flag)
VALUES (nextval('seq_member'), 'Elliott', 'Ezekial', 'zeke@yahoo.com', '614-569-8952', '1997-07-21', 0 );

INSERT INTO MEMBER ( member_number, last_name, first_name, email_address, phone_number, birthday, reminder_email_flag)
VALUES (nextval('seq_member'), 'McLaurin', 'Terry', 'scaryterry@yahoo.com', '614-648-8902', '1996-08-03', 0 );

INSERT INTO MEMBER ( member_number, last_name, first_name, email_address, phone_number, birthday, reminder_email_flag)
VALUES (nextval('seq_member'), 'Vrabel', 'Mike', 'titanscoach@gmail.com', '614-769-8390', '1984-01-07', 1 );

INSERT INTO INTEREST_GROUP ( group_number, group_name )
VALUES (nextval('seq_interest_group'), 'Running');

INSERT INTO INTEREST_GROUP ( group_number, group_name )
VALUES (nextval('seq_interest_group'), 'Music');

INSERT INTO INTEREST_GROUP ( group_number, group_name )
VALUES (nextval('seq_interest_group'), 'Database Programming');

INSERT INTO INTEREST_GROUP ( group_number, group_name )
VALUES (nextval('seq_interest_group'), 'tOSU Football');

INSERT INTO interest_group_member ( group_number, member_number )
VALUES ( ( select group_number from INTEREST_GROUP where group_name in ( 'Running' ) ), ( select member_number from member where last_name in ( 'Wenger' ) ) ) ;

INSERT INTO interest_group_member ( group_number, member_number )
VALUES ( ( select group_number from INTEREST_GROUP where group_name in ( 'tOSU Football' ) ), ( select member_number from member where last_name in ( 'Wenger' ) ) ) ;

INSERT INTO interest_group_member ( group_number, member_number )
VALUES ( ( select group_number from INTEREST_GROUP where group_name in ( 'Music' ) ), ( select member_number from member where last_name in ( 'Wenger' ) ) ) ;

INSERT INTO interest_group_member ( group_number, member_number )
VALUES ( ( select group_number from INTEREST_GROUP where group_name in ( 'Database Programming' ) ), ( select member_number from member where last_name in ( 'Wenger') ) ) ;

INSERT INTO interest_group_member ( group_number, member_number )
VALUES ( ( select group_number from INTEREST_GROUP where group_name in ( 'Music' ) ), ( select member_number from member where last_name in ( 'Smith' ) ) ) ;

INSERT INTO interest_group_member ( group_number, member_number )
VALUES ( ( select group_number from INTEREST_GROUP where group_name in ( 'Database Programming' ) ), ( select member_number from member where last_name in ( 'Smith') ) ) ;

INSERT INTO interest_group_member ( group_number, member_number )
VALUES ( ( select group_number from INTEREST_GROUP where group_name in ( 'Music' ) ), ( select member_number from member where last_name in ( 'Watt' ) ) ) ;

INSERT INTO interest_group_member ( group_number, member_number )
VALUES ( ( select group_number from INTEREST_GROUP where group_name in ( 'Running' ) ), ( select member_number from member where last_name in ( 'Watt') ) ) ;

INSERT INTO interest_group_member ( group_number, member_number )
VALUES ( ( select group_number from INTEREST_GROUP where group_name in ( 'Music' ) ), ( select member_number from member where last_name in ( 'Steele' ) ) ) ;

INSERT INTO interest_group_member ( group_number, member_number )
VALUES ( ( select group_number from INTEREST_GROUP where group_name in ( 'Running' ) ), ( select member_number from member where last_name in ( 'Steele') ) ) ;

INSERT INTO interest_group_member ( group_number, member_number )
VALUES ( ( select group_number from INTEREST_GROUP where group_name in ( 'Database Programming' ) ), ( select member_number from member where last_name in ( 'Day' ) ) ) ;

INSERT INTO interest_group_member ( group_number, member_number )
VALUES ( ( select group_number from INTEREST_GROUP where group_name in ( 'tOSU Football' ) ), ( select member_number from member where last_name in ( 'Day') ) ) ;

INSERT INTO interest_group_member ( group_number, member_number )
VALUES ( ( select group_number from INTEREST_GROUP where group_name in ( 'Running' ) ), ( select member_number from member where last_name in ( 'Elliott' ) ) ) ;

INSERT INTO interest_group_member ( group_number, member_number )
VALUES ( ( select group_number from INTEREST_GROUP where group_name in ( 'tOSU Football' ) ), ( select member_number from member where last_name in ( 'Elliott') ) ) ;

INSERT INTO interest_group_member ( group_number, member_number )
VALUES ( ( select group_number from INTEREST_GROUP where group_name in ( 'Music' ) ), ( select member_number from member where last_name in ( 'McLaurin' ) ) ) ;

INSERT INTO interest_group_member ( group_number, member_number )
VALUES ( ( select group_number from INTEREST_GROUP where group_name in ( 'tOSU Football' ) ), ( select member_number from member where last_name in ( 'McLaurin') ) ) ;

INSERT INTO interest_group_member ( group_number, member_number )
VALUES ( ( select group_number from INTEREST_GROUP where group_name in ( 'Running' ) ), ( select member_number from member where last_name in ( 'Vrabel' ) ) ) ;

INSERT INTO interest_group_member ( group_number, member_number )
VALUES ( ( select group_number from INTEREST_GROUP where group_name in ( 'tOSU Football' ) ), ( select member_number from member where last_name in ( 'Vrabel') ) ) ;

INSERT INTO EVENT ( event_number, event_name, description, start_date, duration_in_minutes )
VALUES (nextval('seq_event_number'), 'tOSU Football Game', 'The House that Harley Built', '2022-11-26', 180);

INSERT INTO EVENT ( event_number, event_name, description, start_date, duration_in_minutes )
VALUES (nextval('seq_event_number'), 'Lollapalooza', 'Annual concert', '2016-09-05', 720);

INSERT INTO EVENT ( event_number, event_name, description, start_date, duration_in_minutes )
VALUES (nextval('seq_event_number'), 'Columbus Marathon', '26.2 mile run', '2018-10-13', 120);

INSERT INTO EVENT ( event_number, event_name, description, start_date, duration_in_minutes )
VALUES (nextval('seq_event_number'), 'TE Module 2', 'Mr. Mack''s Module 2 class', '2022-11-19', 240);

INSERT INTO EVENT ( event_number, event_name, description, start_date )
VALUES (nextval('seq_event_number'), 'Radio', 'Listening to the radio', '2020-05-01');

-- SELECT member_number, group_number from interest_group_member ORDER BY GROUP_NUMBER;

-- select * from EVENT_GROUP_MEMBER

INSERT INTO EVENT_GROUP_MEMBER ( member_number, group_number, event_number )
VALUES ( 1, 1, 3 );

INSERT INTO EVENT_GROUP_MEMBER ( member_number, group_number, event_number )
VALUES ( 3, 1, 3 );

INSERT INTO EVENT_GROUP_MEMBER ( member_number, group_number, event_number )
VALUES ( 4, 1, 3 );

INSERT INTO EVENT_GROUP_MEMBER ( member_number, group_number, event_number )
VALUES ( 6, 1, 3 );

INSERT INTO EVENT_GROUP_MEMBER ( member_number, group_number, event_number )
VALUES ( 8, 1, 3 );

INSERT INTO EVENT_GROUP_MEMBER ( member_number, group_number, event_number )
VALUES ( 1, 2, 2 );

INSERT INTO EVENT_GROUP_MEMBER ( member_number, group_number, event_number )
VALUES ( 2, 2, 2 );

INSERT INTO EVENT_GROUP_MEMBER ( member_number, group_number, event_number )
VALUES ( 3, 2, 2 );

INSERT INTO EVENT_GROUP_MEMBER ( member_number, group_number, event_number )
VALUES ( 4, 2, 5 );

INSERT INTO EVENT_GROUP_MEMBER ( member_number, group_number, event_number )
VALUES ( 7, 2, 5 );

INSERT INTO EVENT_GROUP_MEMBER ( member_number, group_number, event_number )
VALUES ( 1, 3, 4 );

INSERT INTO EVENT_GROUP_MEMBER ( member_number, group_number, event_number )
VALUES ( 2, 3, 4 );

INSERT INTO EVENT_GROUP_MEMBER ( member_number, group_number, event_number )
VALUES ( 5, 3, 4 );

INSERT INTO EVENT_GROUP_MEMBER ( member_number, group_number, event_number )
VALUES ( 1, 4, 1 );

INSERT INTO EVENT_GROUP_MEMBER ( member_number, group_number, event_number )
VALUES ( 5, 4, 1 );

INSERT INTO EVENT_GROUP_MEMBER ( member_number, group_number, event_number )
VALUES ( 6, 4, 1 );

INSERT INTO EVENT_GROUP_MEMBER ( member_number, group_number, event_number )
VALUES ( 7, 4, 1 );

INSERT INTO EVENT_GROUP_MEMBER ( member_number, group_number, event_number )
VALUES ( 8, 4, 1 );

COMMIT;
