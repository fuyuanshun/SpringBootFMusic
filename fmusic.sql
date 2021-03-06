﻿create database fmusic default charset=utf8;

use fmusic;

create table user(
id int primary key auto_increment,
username varchar(15) not null,
password varchar(50) not null,
email varchar(40) not null,
url varchar(64) not null,
state varchar(2) not null,
sex varchar(2) not null,
age int not null,
birthday date not null,
hobby varchar(20),
phone varchar(15),
address varchar(30),
validatecode varchar(64),
outdate datetime
);


create table music
(
id int primary key auto_increment,
name varchar(200) not null,
author varchar(50) not null,
path varchar(200) not null,
picpath varchar(200)
);

create table user_music(
  user_id int(11) not null,
  music_id int(11) not null,
  constraint music_fk foreign key(music_id) references music(id),
  constraint user_fk foreign key (user_id) references user(id)
) ;


insert into music (name, author, path) values ('ChrisMedina-Whatarewords.mp3', 'ChrisMedina', 'http://139.199.198.151:8080/repo/music/ChrisMedina-Whatarewords.mp3');
insert into music (name, author, path) values ('CMA-ForeverInMyHeart.mp3', 'CMA', 'http://139.199.198.151:8080/repo/music/CMA-ForeverInMyHeart.mp3');
insert into music (name, author, path) values ('JoeyMontana-Picky.mp3', 'JoeyMontana', 'http://139.199.198.151:8080/repo/music/JoeyMontana-Picky.mp3');
insert into music (name, author, path) values ('KatharineMcPhee-EverywhereIGo.mp3', 'KatharineMcPhee', 'http://139.199.198.151:8080/repo/music/KatharineMcPhee-EverywhereIGo.mp3');
insert into music (name, author, path) values ('Kozoro-Remember Me.mp3', 'Kozoro', 'http://139.199.198.151:8080/repo/music/Kozoro-Remember Me.mp3');
insert into music (name, author, path) values ('Lightscape-Cold(OriginalMix).mp3', 'Lightscape', 'http://139.199.198.151:8080/repo/music/Lightscape-Cold(OriginalMix).mp3');
insert into music (name, author, path) values ('Passenger-LetHerGo.mp3', 'Passenger', 'http://139.199.198.151:8080/repo/music/Passenger-LetHerGo.mp3');
insert into music (name, author, path) values ('StevieHoang-AllIHaveIsLove.mp3', 'StevieHoang', 'http://139.199.198.151:8080/repo/music/StevieHoang-AllIHaveIsLove.mp3');
insert into music (name, author, path) values ('TheWeeknd-TheHills.mp3', 'TheWeeknd', 'http://139.199.198.151:8080/repo/music/TheWeeknd-TheHills.mp3');
insert into music (name, author, path) values ('twentyonepilots-StressedOut.mp3', 'twentyonepilots', 'http://139.199.198.151:8080/repo/music/twentyonepilots-StressedOut.mp3');
insert into music (name, author, path) values ('岑宁儿-追光者.mp3', '岑宁儿', 'http://139.199.198.151:8080/repo/music/岑宁儿-追光者.mp3');
insert into music (name, author, path) values ('薛之谦-丑八怪.mp3', '薛之谦', 'http://139.199.198.151:8080/repo/music/薛之谦-丑八怪.mp3');
insert into music (name, author, path) values ('薛之谦-刚刚好.mp3', '薛之谦', 'http://139.199.198.151:8080/repo/music/薛之谦-刚刚好.mp3');
insert into music (name, author, path) values ('薛之谦-我好像在哪见过你.mp3', '薛之谦', 'http://139.199.198.151:8080/repo/music/薛之谦-我好像在哪见过你.mp3');
insert into music (name, author, path) values ('薛之谦-演员.mp3', '薛之谦', 'http://139.199.198.151:8080/repo/music/薛之谦-演员.mp3');
insert into music (name, author, path) values ('薛之谦-绅士.mp3', '薛之谦', 'http://139.199.198.151:8080/repo/music/薛之谦-绅士.mp3');
insert into music (name, author, path) values ('薛之谦-高尚.mp3', '薛之谦', 'http://139.199.198.151:8080/repo/music/薛之谦-高尚.mp3');
insert into music (name, author, path) values ('陈奕迅-一丝不挂.mp3', '陈奕迅', 'http://139.199.198.151:8080/repo/music/陈奕迅-一丝不挂.mp3');
insert into music (name, author, path) values ('陈奕迅-不要说话.mp3', '陈奕迅', 'http://139.199.198.151:8080/repo/music/陈奕迅-不要说话.mp3');
insert into music (name, author, path) values ('陈奕迅-孤独患者.mp3', '陈奕迅', 'http://139.199.198.151:8080/repo/music/陈奕迅-孤独患者.mp3');
insert into music (name, author, path) values ('陈奕迅-富士山下.mp3', '陈奕迅', 'http://139.199.198.151:8080/repo/music/陈奕迅-富士山下.mp3');
insert into music (name, author, path) values ('陈奕迅-最佳损友.mp3', '陈奕迅', 'http://139.199.198.151:8080/repo/music/陈奕迅-最佳损友.mp3');
insert into music (name, author, path) values ('陈奕迅-红玫瑰.mp3', '陈奕迅', 'http://139.199.198.151:8080/repo/music/陈奕迅-红玫瑰.mp3');
insert into music (name, author, path) values ('陈奕迅-苦瓜.mp3', '陈奕迅', 'http://139.199.198.151:8080/repo/music/陈奕迅-苦瓜.mp3');
insert into music (name, author, path) values ('陈奕迅-落花流水.mp3', '陈奕迅', 'http://139.199.198.151:8080/repo/music/陈奕迅-落花流水.mp3');
insert into music (name, author, path) values ('陈奕迅-陀飞轮.mp3', '陈奕迅', 'http://139.199.198.151:8080/repo/music/陈奕迅-陀飞轮.mp3');
