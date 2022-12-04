-- app_user --
insert into book_store2.app_user(address,avatar,email,money,`password`,phone,`username`) 
values 
('Huế','https://static2.yan.vn/YanNews/2167221/202203/5-49b61e96.jpg','kimchi@gmail.com','1000000',"$2a$12$7Ge2d4ImqFSg9k/AKOATJOC64afHWCXEwB5JEWceUVyMoFu.FEaLi",'0978924518','Kim Chi'),
('Hồ Chí Minh','https://static2.yan.vn/YanNews/2167221/202203/5-49b61e96.jpg','kimdan@gmail.com','2000000',"$2a$12$7Ge2d4ImqFSg9k/AKOATJOC64afHWCXEwB5JEWceUVyMoFu.FEaLi",'0978924518','Kim Đan'),
('Hà Nội','https://static2.yan.vn/YanNews/2167221/202203/5-49b61e96.jpg','kimngan@gmail.com','3000000',"$2a$12$7Ge2d4ImqFSg9k/AKOATJOC64afHWCXEwB5JEWceUVyMoFu.FEaLi",'0978924518','Kim Ngân');


-- APP_ROLE -- 
insert into app_role(`role`) values ("ROLE_ADMIN");
insert into app_role(`role`) values ("ROLE_USER");

-- account role ---

insert into account_role(role_id,user_id) values (1,1);
insert into account_role(role_id,user_id) values (2,2);
insert into account_role(role_id,user_id) values (2,3);
insert into account_role(role_id,user_id) values (2,4);
insert into account_role(role_id,user_id) values (2,5);

-- cart -- 

insert into cart(total_price,user_id, book_id) 
values (2,1,1),
(2,1,2),
(2,1,3),
(2,2,1),
(3,2,4),
(1,2,2);

-- category --
insert into book_store2.category(`name`)
values
('Truyện đời'),
('Truyện nhảm'),
('Truyện hài'),
('Truyện buồn');

insert into book_store2.book (author,height,image_url,price,publisher,quantity,summary,title,total_pages,width,category_id)
values('Nguyễn Phi Hùng',100,'https://sachhay24h.com/uploads/images/tren-duong-bang-2.jpg',100000,'Báo tuổi đời',5,'ổn','Trên đường băng',200,100,1),
('Nguyễn Phi Hùng',100,'https://sachhay24h.com/uploads/images/tren-duong-bang-2.jpg',100000,'Báo tuổi đời',5,'ổn','Trên đường băng',200,100,1),
('Nguyễn Phi Hùng',100,'https://sachhay24h.com/uploads/images/tren-duong-bang-2.jpg',100000,'Báo tuổi đời',5,'ổn','Trên đường băng',200,100,1),
('Nguyễn Phi Hùng',100,'https://sachhay24h.com/uploads/images/tren-duong-bang-2.jpg',100000,'Báo tuổi đời',5,'ổn','Trên đường băng',200,100,1),
('Nguyễn Phi Hùng',100,'https://sachhay24h.com/uploads/images/tren-duong-bang-2.jpg',100000,'Báo tuổi đời',5,'ổn','Trên đường băng',200,100,1),
('Nguyễn Phi Hùng',100,'https://sachhay24h.com/uploads/images/tren-duong-bang-2.jpg',100000,'Báo tuổi đời',5,'ổn','Trên đường băng',200,100,1),
('Nguyễn Phi Hùng',100,'https://sachhay24h.com/uploads/images/tren-duong-bang-2.jpg',100000,'Báo tuổi đời',5,'ổn','Trên đường băng',200,100,1),
('Nguyễn Phi Hùng',100,'https://sachhay24h.com/uploads/images/tren-duong-bang-2.jpg',100000,'Báo tuổi đời',5,'ổn','Trên đường băng',200,100,1),
('Nguyễn Phi Hùng',100,'https://sachhay24h.com/uploads/images/tren-duong-bang-2.jpg',100000,'Báo tuổi đời',5,'ổn','Trên đường băng',200,100,1),
('Nguyễn Phi Hùng',100,'https://sachhay24h.com/uploads/images/tren-duong-bang-2.jpg',100000,'Báo tuổi đời',5,'ổn','Trên đường băng',200,100,1),
('Nguyễn Phi Hùng',100,'https://sachhay24h.com/uploads/images/tren-duong-bang-2.jpg',100000,'Báo tuổi đời',5,'ổn','Trên đường băng',200,100,1),
('Nguyễn Phi Hùng',100,'https://sachhay24h.com/uploads/images/tren-duong-bang-2.jpg',100000,'Báo tuổi đời',5,'ổn','Trên đường băng',200,100,1),
('Nguyễn Phi Hùng',100,'https://sachhay24h.com/uploads/images/tren-duong-bang-2.jpg',100000,'Báo tuổi đời',5,'ổn','Trên đường băng',200,100,1),
('Nguyễn Phi Hùng',100,'https://sachhay24h.com/uploads/images/tren-duong-bang-2.jpg',100000,'Báo tuổi đời',5,'ổn','Trên đường băng',200,100,1);

