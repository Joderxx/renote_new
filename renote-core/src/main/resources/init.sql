create schema renote collate utf8mb4_0900_ai_ci;


create table advice
(
	advice_id bigint(11) auto_increment
		primary key,
	message varchar(255) not null,
	user_id bigint(11) not null,
	create_time bigint(11) null,
	watch tinyint null
);

create table avatar
(
	avatar_id bigint(11) auto_increment
		primary key,
	content mediumblob not null,
	create_time bigint(11) null,
	modified_time bigint(11) null,
	suffix varchar(10) null
);

create table collect_table
(
	collect_id bigint(11) auto_increment
		primary key,
	filename varchar(255) null,
	type varchar(4) null,
	create_time bigint(11) null,
	user_id bigint(11) null,
	private_id bigint(11) null,
	parent_id bigint(11) default 0 null,
	watch int(255) null,
	comment int(255) null
);

create table comment
(
	comment_id bigint(11) auto_increment
		primary key,
	content varchar(255) null,
	create_time bigint(11) null,
	user_id bigint(11) null,
	public_id bigint(11) null,
	share_id bigint(11) null,
	parent_id bigint(11) default 0 null
);

create table `group`
(
	group_id int(4) auto_increment
		primary key,
	name varchar(20) not null,
	description varchar(50) null,
	constraint name
		unique (name)
);

create table group_role
(
	id int auto_increment
		primary key,
	group_id int not null,
	role_id int not null,
	constraint group_role_group_id_role_id_uindex
		unique (group_id, role_id)
);

create table note_content
(
	content_id bigint(11) auto_increment
		primary key,
	content mediumblob null,
	tags varchar(255) null
);

create table private_note
(
	private_id bigint(11) auto_increment
		primary key,
	filename varchar(255) not null,
	type varchar(4) null,
	create_time bigint(11) null,
	user_id bigint(11) null,
	parent_id bigint(11) default 0 null,
	content_id bigint(11) null,
	source varchar(4) null,
	suffix varchar(50) null,
	del tinyint null
);

create table public_note
(
	public_id bigint(11) auto_increment
		primary key,
	filename varchar(255) null,
	type varchar(4) null,
	create_time bigint(11) null,
	user_id bigint(11) null,
	private_id bigint(11) null,
	parent_id bigint(11) default 0 null,
	watch int(4) null,
	comment int(4) null
);

create table role
(
	role_id int(4) auto_increment
		primary key,
	name varchar(20) not null,
	description varchar(50) null,
	constraint name
		unique (name)
);

create table share_note
(
	share_id bigint(11) auto_increment
		primary key,
	filename varchar(255) null,
	type varchar(4) null,
	create_time bigint(11) null,
	private_id bigint(11) null,
	user_id bigint(11) null,
	sign varchar(255) null,
	`key` tinyint null
);

create table user
(
	user_id bigint(11) auto_increment
		primary key,
	username varchar(20) not null,
	password varchar(150) not null,
	create_time bigint(11) null,
	experience bigint(11) null,
	level int(4) null,
	reward int(4) null,
	vip tinyint null,
	expire_time bigint(11) null,
	group_id int(4) null,
	email varchar(50) null,
	phone varchar(50) null,
	qq varchar(50) null,
	wechat varchar(50) null,
	alipay varchar(50) null,
	github varchar(50) null,
	constraint user_email_uindex
		unique (email),
	constraint user_username_uindex
		unique (username),
	constraint username
		unique (username)
);

create table word
(
	word_id bigint(11) auto_increment
		primary key,
	name varchar(255) not null,
	url varchar(255) not null,
	description varchar(255) not null
);

