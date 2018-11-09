prompt Creating SBSS_MENU...
create table SBSS_MENU
(
  id           VARCHAR2(36) not null,
  menuname     VARCHAR2(200),
  url          VARCHAR2(1000),
  sortorder    NUMBER(2),
  menulevel    NUMBER(2),
  parentmenuid VARCHAR2(36)
)
;

prompt Creating SBSS_ROLE...
create table SBSS_ROLE
(
  id   INTEGER,
  name VARCHAR2(20)
)
;

prompt Creating SBSS_ROLE_MENU...
create table SBSS_ROLE_MENU
(
  id      INTEGER,
  role_id INTEGER,
  menu_id INTEGER
)
;

prompt Creating SBSS_USER...
create table SBSS_USER
(
  id       INTEGER,
  username VARCHAR2(20),
  password VARCHAR2(20)
)
;

prompt Creating SBSS_USER_ROLE...
create table SBSS_USER_ROLE
(
  id      INTEGER,
  user_id INTEGER,
  role_id INTEGER
)
;

prompt Loading SBSS_MENU...
insert into SBSS_MENU (id, menuname, url, sortorder, menulevel, parentmenuid)
values ('4', '角色管理', '/index', 2, 3, '2');
insert into SBSS_MENU (id, menuname, url, sortorder, menulevel, parentmenuid)
values ('3', '用户管理', '/index', 1, 3, '2');
insert into SBSS_MENU (id, menuname, url, sortorder, menulevel, parentmenuid)
values ('2', '系统管理', null, 1, 2, '1');
insert into SBSS_MENU (id, menuname, url, sortorder, menulevel, parentmenuid)
values ('1', '根菜单', null, 1, 1, '-1');
insert into SBSS_MENU (id, menuname, url, sortorder, menulevel, parentmenuid)
values ('5', '业务办理', null, 1, 2, '1');
insert into SBSS_MENU (id, menuname, url, sortorder, menulevel, parentmenuid)
values ('6', '信息管理', '/index', 1, 3, '5');
insert into SBSS_MENU (id, menuname, url, sortorder, menulevel, parentmenuid)
values ('8', '删除信息', '/delmsg', null, null, null);
insert into SBSS_MENU (id, menuname, url, sortorder, menulevel, parentmenuid)
values ('7', '查看信息', '/viewmsg', null, null, null);
commit;
prompt 8 records loaded
prompt Loading SBSS_ROLE...
insert into SBSS_ROLE (id, name)
values (1, 'ROLE_ADMIN');
insert into SBSS_ROLE (id, name)
values (2, 'ROLE_USER');
commit;
prompt 2 records loaded
prompt Loading SBSS_ROLE_MENU...
insert into SBSS_ROLE_MENU (id, role_id, menu_id)
values (1, 1, 4);
insert into SBSS_ROLE_MENU (id, role_id, menu_id)
values (2, 1, 3);
insert into SBSS_ROLE_MENU (id, role_id, menu_id)
values (3, 1, 2);
insert into SBSS_ROLE_MENU (id, role_id, menu_id)
values (4, 1, 1);
insert into SBSS_ROLE_MENU (id, role_id, menu_id)
values (5, 1, 5);
insert into SBSS_ROLE_MENU (id, role_id, menu_id)
values (6, 1, 6);
insert into SBSS_ROLE_MENU (id, role_id, menu_id)
values (7, 2, 1);
insert into SBSS_ROLE_MENU (id, role_id, menu_id)
values (8, 2, 5);
insert into SBSS_ROLE_MENU (id, role_id, menu_id)
values (9, 2, 6);
insert into SBSS_ROLE_MENU (id, role_id, menu_id)
values (12, 2, 7);
insert into SBSS_ROLE_MENU (id, role_id, menu_id)
values (11, 1, 8);
insert into SBSS_ROLE_MENU (id, role_id, menu_id)
values (10, 1, 7);
commit;
prompt 12 records loaded
prompt Loading SBSS_USER...
insert into SBSS_USER (id, username, password)
values (1, 'admin', 'admin');
insert into SBSS_USER (id, username, password)
values (2, 'user', 'user');
commit;
prompt 2 records loaded
prompt Loading SBSS_USER_ROLE...
insert into SBSS_USER_ROLE (id, user_id, role_id)
values (1, 1, 1);
insert into SBSS_USER_ROLE (id, user_id, role_id)
values (2, 2, 2);
commit;
prompt 2 records loaded
