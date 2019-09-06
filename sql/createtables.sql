create table organization (
	id int not null primary key,
	name varchar(200), 
	email_domain varchar(50),
	active bool not null default false,
	modified_by varchar(20),
	modified_date timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
	);
  
insert into organization (id, name, email_domain, active, modified_by) values (1, 'Publicis.Sapient', 'publicissapient.com', true, 'admin');
insert into organization (id, name, email_domain, active, modified_by) values (2, 'Mindtree', 'mindtree.com', true, 'admin');
insert into organization (id, name, email_domain, active, modified_by) values (3, 'Accenture', 'accenture.com', true, 'admin');
insert into organization (id, name, email_domain, active, modified_by) values (4, 'Infosys', 'infosys.com', true, 'admin');
insert into organization (id, name, email_domain, active, modified_by) values (5, 'Wipro', 'wipro.com', true, 'admin');
insert into organization (id, name, email_domain, active, modified_by) values (6, 'Cognizant', 'cognizant.com', true, 'admin');
insert into organization (id, name, email_domain, active, modified_by) values (7, 'IBM India', 'in.ibm.com', true, 'admin');
insert into organization (id, name, email_domain, active, modified_by) values (8, 'TCS', 'tcs.com', true, 'admin');
insert into organization (id, name, email_domain, active, modified_by) values (9, 'HCL', 'hcl.com', true, 'admin');
insert into organization (id, name, email_domain, active, modified_by) values (10, 'Capco', 'capco.com', true, 'admin');
insert into organization (id, name, email_domain, active, modified_by) values (11, 'Dell', 'dell.com', true, 'admin');
insert into organization (id, name, email_domain, active, modified_by) values (12, 'Oracle', 'oracle.com', true, 'admin');
insert into organization (id, name, email_domain, active, modified_by) values (13, 'Mphasis', 'mphasis.com', true, 'admin');
insert into organization (id, name, email_domain, active, modified_by) values (14, 'Morgan Stanley', 'morganstanley.com', true, 'admin');
insert into organization (id, name, email_domain, active, modified_by) values (15, 'JP Morgan Chase', 'jpmorgan.com', true, 'admin');
insert into organization (id, name, email_domain, active, modified_by) values (16, 'Deloitte', 'deloitte.com', true, 'admin');
insert into organization (id, name, email_domain, active, modified_by) values (17, 'KPMG', 'kpmg.com', true, 'admin');
insert into organization (id, name, email_domain, active, modified_by) values (18, 'Ernst & Young India', 'in.ey.com', true, 'admin');
insert into organization (id, name, email_domain, active, modified_by) values (19, 'PwC', 'pwc.com', true, 'admin');
insert into organization (id, name, email_domain, active, modified_by) values (20, 'Biocon', 'biocon.com', true, 'admin');
insert into organization (id, name, email_domain, active, modified_by) values (21, 'Truplat', 'gmail.com', true, 'admin');

create table user (
	user_id int not null primary key auto_increment,
	first_name varchar(25) not null, 
	last_name varchar(25) not null, 
	personal_email_address varchar(50) not null,
	official_email_address varchar(50) not null unique,
	gender varchar(10) not null, 
	dob date,
	contact_number varchar(25), 
	city varchar(25) not null, 
	pincode varchar(10) not null, 
	restricted_access varchar(5) not null, 
	organization_id int,
	active boolean not null default false,
  	modified_by varchar(20) not null default 'admin',
  	modified_date timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 	FOREIGN KEY (organization_id)
      	REFERENCES organization(id)
	);
	
CREATE TABLE user_credential (
  user_id int not null primary key,
  pass_word varchar(75) DEFAULT NULL,
  active tinyint(1) NOT NULL DEFAULT '0',
  activation_code varchar(100) DEFAULT NULL,
  activation_time timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  retry int,
  CONSTRAINT user_credential_user_id FOREIGN KEY (user_id) REFERENCES user (user_id)
	);

create table real_estate(
	id int not null primary key auto_increment,	
	transaction_type varchar(10) not null, 
	property_type varchar(10) not null, 
	unit_type varchar(10) not null, 
	locality varchar(50) not null, 
	city varchar(25) not null, 
	area int not null, 
	amount int not null,
	title varchar(100) not null, 
	description varchar(1000) not null, 
    FULLTEXT (title, description),
	image_name1 varchar(100),
    image_name2 varchar(100),
    image_name3 varchar(100),
    image_name4 varchar(100),
    image_name5 varchar(100), 
	user_id int not null,
	deleted boolean not null default false,
  	modified_date timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CONSTRAINT fk_real_estate_user_id FOREIGN KEY (user_id) REFERENCES user (user_id)
	);

create table automobile(
	id int not null primary key auto_increment,	
	vehicle_type varchar(10) not null, 
	fuel_type varchar(10) not null, 
	make varchar(50) not null, 
	model varchar(50) not null, 
	locality varchar(50) not null, 
	city varchar(25) not null, 
	driven int not null, 
	amount int not null,
	title varchar(100) not null, 
	description varchar(1000) not null, 
    FULLTEXT (title, description),
	image_name1 varchar(100),
    image_name2 varchar(100),
    image_name3 varchar(100),
    image_name4 varchar(100),
    image_name5 varchar(100),
	user_id int not null,
	deleted boolean not null default false,
  	modified_date timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CONSTRAINT fk_automobile_user_id FOREIGN KEY (user_id) REFERENCES user (user_id)
	);

create table electronic(
	id int not null primary key auto_increment,	
	electronic_type varchar(40) not null, 
	locality varchar(50) not null, 
	city varchar(25) not null, 
	amount int not null,
	title varchar(100) not null, 
    description varchar(1000) not null, 
    FULLTEXT (title, description),
	image_name1 varchar(100),
    image_name2 varchar(100),
    image_name3 varchar(100),
    image_name4 varchar(100),
    image_name5 varchar(100), 
    user_id int not null,
	deleted boolean not null default false,
  	modified_date timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CONSTRAINT fk_electronic_user_id FOREIGN KEY (user_id) REFERENCES user (user_id)
	);

create table lifestyle(
	id int not null primary key auto_increment,
	lifestyle_type varchar(40) not null, 
	locality varchar(50) not null, 
	city varchar(25) not null, 
	amount int not null,
	title varchar(100) not null, 
    description varchar(1000) not null, 
    FULLTEXT (title, description),
	image_name1 varchar(100),
    image_name2 varchar(100),
    image_name3 varchar(100),
    image_name4 varchar(100),
    image_name5 varchar(100), 
    user_id int not null,
	deleted boolean not null default false,
  	modified_date timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CONSTRAINT fk_lifestyle_user_id FOREIGN KEY (user_id) REFERENCES user (user_id)
	);
	
create table bookmark(
	id int not null primary key auto_increment,	
	post_id int not null,
    category_name varchar(20) not null,
	user_id int not null,
  	modified_date timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CONSTRAINT fk_bookmark_user_id FOREIGN KEY (user_id) REFERENCES user (user_id)
	);