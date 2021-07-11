insert into ROLES (role_id, name) values (1, 'Administrator');
insert into ROLES (role_id, name) values (2, 'Viewer');

insert into USERS (user_id, enabled, password, username) values (1, true, 'pass1', 'user1');
insert into USERS (user_id, enabled, password, username) values (2, true, 'pass2', 'user2');

insert into users_roles (role_id, user_id) values (1, 1);
insert into users_roles (role_id, user_id) values (2, 2);

insert into SENSOR_TYPES (sensor_type_id, name) values (1, 'Pressure');
insert into SENSOR_TYPES (sensor_type_id, name) values (2, 'Voltage');
insert into SENSOR_TYPES (sensor_type_id, name) values (3, 'Temperature');
insert into SENSOR_TYPES (sensor_type_id, name) values (4, 'Humidity');

insert into SENSOR_UNITS (sensor_unit_id, name) values (1, 'bar');
insert into SENSOR_UNITS (sensor_unit_id, name) values (2, 'voltage');
insert into SENSOR_UNITS (sensor_unit_id, name) values (3, '*C');
insert into SENSOR_UNITS (sensor_unit_id, name) values (4, '%');

insert into SENSORS (description, location, model, name, range_from, range_to, sensor_type_id, sensor_unit_id) values ('qew', 'eqwq1', 'qeqw1', 'qweqew', 0, 1, 1, 1);
insert into SENSORS (description, location, model, name, range_from, range_to, sensor_type_id, sensor_unit_id) values ('qew2', 'eqwq2', 'qeqw2', 'qweqew', 0, 1, 1, 2);
insert into SENSORS (description, location, model, name, range_from, range_to, sensor_type_id, sensor_unit_id) values ('qew3', 'eqwq3', 'qeqw3', 'qweqew', 0, 1, 3, 3);
insert into SENSORS (description, location, model, name, range_from, range_to, sensor_type_id, sensor_unit_id) values ('qew4', 'eqwq4', 'qeqw4', 'qweqew', 0, 1, 2, 4);
insert into SENSORS (description, location, model, name, range_from, range_to, sensor_type_id, sensor_unit_id) values ('qew5', 'eqwq5', 'qeqw5', 'qweqew', 0, 1, 2, 1);
insert into SENSORS (description, location, model, name, range_from, range_to, sensor_type_id, sensor_unit_id) values ('qew6', 'eqwq6', 'qeqw6', 'qweqew', 0, 1, 3, 4);
insert into SENSORS (description, location, model, name, range_from, range_to, sensor_type_id, sensor_unit_id) values ('qew7', 'eqwq7', 'qeqw', 'qweqew', 0, 1, 4, 4);
insert into SENSORS (description, location, model, name, range_from, range_to, sensor_type_id, sensor_unit_id) values ('qew8', 'eqwq8', 'qeqw', 'qweqew', 0, 1, 2, 2);
insert into SENSORS (description, location, model, name, range_from, range_to, sensor_type_id, sensor_unit_id) values ('qew9', 'eqwq9', 'qeqw', 'qweqew', 0, 1, 3, 3);


