delete from Taco_Order_Tacos;
delete from Taco_Ingredients;
delete from Taco;
delete from Taco_Order;
delete from Ingredient;
delete from User;
insert into Ingredient (id, name, type)
values ('FLTO', 'Flour Tortilla', 'WRAP');
insert into Ingredient (id, name, type)
values ('COTO', 'Corn Tortilla', 'WRAP');
insert into Ingredient (id, name, type)
values ('GRBF', 'Ground Beef', 'PROTEIN');
insert into Ingredient (id, name, type)
values ('CARN', 'Carnitas', 'PROTEIN');
insert into Ingredient (id, name, type)
values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
insert into Ingredient (id, name, type)
values ('LETC', 'Lettuce', 'VEGGIES');
insert into Ingredient (id, name, type)
values ('CHED', 'Cheddar', 'CHEESE');
insert into Ingredient (id, name, type)
values ('JACK', 'Monterrey Jack', 'CHEESE');
insert into Ingredient (id, name, type)
values ('SLSA', 'Salsa', 'SAUCE');
insert into Ingredient (id, name, type)
values ('SRCR', 'Sour Cream', 'SAUCE');

insert into user (city, fullname, password, phoneNumber, state, street, username, zip)
values ('Город', 'Имя', 'e54eadd13410fa6447397c0e00087bf67e9995e1f886acad63deac2afe41ed040231caedef76ade0', 'Телефон', 'стейт', 'улица', 'test', 'индекс');

insert into Taco (name, createdAt)
values ('Тестовое тако', CURRENT_TIMESTAMP());

insert into Taco_Ingredients(taco, ingredient)
values (1, 'FLTO');

insert into Taco_Ingredients(taco, ingredient)
values (1, 'GRBF');

insert into Taco_Order (deliveryName, deliveryStreet, deliveryCity,
    deliveryState, deliveryZip, ccNumber,
    ccExpiration, ccCVV, placedAt,
    user_id)
values ('deliveryName имя', 'улица', 'город', '11', '111111', '4111111111111111', '10/10', '123', CURRENT_TIMESTAMP(), 1);

insert into Taco_Order_Tacos (tacoOrder, taco)
values  (1, 1);
