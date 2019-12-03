
//scripts to insert movie list
insert into movies(mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser)
values('Avatar',2787965087,'Yes','2017-03-15','Science Fiction','Yes');

insert into movies(mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser)
values('The Avengers',1518812988,'Yes','2017-12-23','Superhero','No');

insert into movies(mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser)
values('Titanic',2187463944,'Yes','2017-08-21','Romance','No');

insert into movies(mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser)
values('Jurassic World',1671713208,'No','2017-07-02','Science Fiction','Yes');

insert into movies(mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser)
values('Avengers:End Game',2750760348,'Yes','2022-11-02','Superhero','Yes');

//scripts to get all movie list based on movie id
select mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser from movies;

//scripts to get all movie list which is after date of launch and is active
select * from movies where mv_date_of_launch <= now() and mv_active='Yes';

//scripts to get all movielist 
select mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser from movies where movie_id=1;

//update the movie list based on movie id
update movies set mv_title='Frozen 2',mv_box_office=50.00,mv_active='No',mv_date_of_launch='2015-09-01',mv_genre='Romance',mv_has_teaser='Yes' where movie_id=1;



//scripts to create table favourite
create table favourite(fv_id int primary key,fv_us_id int,fv_mv_id int, foreign key(fv_us_id) references user(us_id),foreign key(fv_mv_id) references movies(movie_id));

//scripts to view favourite
select * from movies m inner join favourite f on m.movie_id = f.fv_id and f.fv_id=1;

select count(*) as no_of_favourites from movies m inner join favourite f on m.movie_id =f.fv_id and f.fv_id =1;

//scripts to remove movie list 
delete from favourite where fv_us_id=11 and fv_mv_id=1;
