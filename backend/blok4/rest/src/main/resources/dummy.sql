insert into Beer(make, price, type, version) values ('Leffe', 1.09, 'Blond', 1);
insert into Beer(make, price, type, version) values ( 'Karmeliet', 2.09, 'Tripel', 1);
insert into User(lastName, firstName, username, password) values ( 'Janssens', 'Bram', 'bram', 'ADBBiieKz0G43fGALhxt84HX9hIZMWe/XQCNUpnmywE='); -- pw = bram
insert into User_ROLES (User_ID, ROLES) values (1, 'USER');
insert into User(lastName, firstName, username, password) values ( 'Ministrator', 'Ad', 'admin', 'jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg='); -- pw = admin
insert into User_ROLES (User_ID, ROLES) values (2, 'USER');
insert into User_ROLES (User_ID, ROLES) values (2, 'ADMIN');
