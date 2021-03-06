drop database if exists Blog;
Create database Blog;

Use Blog;

create table `user`(
`id` int primary key auto_increment,
`username` varchar(30) not null unique,
`password` varchar(100) not null,
`enabled` boolean not null
);

create table `role`(
`id` int primary key auto_increment,
`role` varchar(30) not null
);

create table `user_role`(
`user_id` int not null,
`role_id` int not null,
primary key(`user_id`,`role_id`),
foreign key (`user_id`) references `user`(`id`),
foreign key (`role_id`) references `role`(`id`));

create table BlogPosts( 
blogId int primary key auto_increment,
blogTitle varchar(50) not null,
blogPreview varchar(255) not null,
blogContent mediumText not null,
isPublished boolean default false,
postDate varchar(50) not null,
featuredImagePath varchar(200),
userId int not null,

FOREIGN KEY fk_user_userId(userId) REFERENCES `user`(`id`) 
);

create table Comments( 
commentId int primary key auto_increment,
commentContent varchar(255) not null,
userName varchar(255) not null,

blogId int not null,

FOREIGN KEY fk_blogId_blogId(blogId) REFERENCES BlogPosts(blogId)

);

create table HashTags( 
hashTagId int primary key auto_increment,
hashTagName varchar(50) not null unique

);

CREATE TABLE BlogPostsHashTags(
blogId INT NOT NULL,
hashTagId INT NOT NULL,

BlogPostsHashTagsId INT PRIMARY KEY AUTO_INCREMENT NOT NULL,

FOREIGN KEY fk_BlogPosts_blogId(blogId) REFERENCES BlogPosts(blogId),
FOREIGN KEY fk_HashTags_hashTagId(hashTagId) REFERENCES HashTags(hashTagId)

);

create table Category( 
categoryId int primary key auto_increment,
categoryName varchar(50) not null unique

);

CREATE TABLE BlogPostsCategory(
blogId INT NOT NULL,
categoryId INT NOT NULL,

BlogPostsCategoryId INT PRIMARY KEY AUTO_INCREMENT NOT NULL,

FOREIGN KEY fk_BlogPosts_blogId(blogId) REFERENCES BlogPosts(blogId),
FOREIGN KEY fk_Category_categoryId(categoryId) REFERENCES Category(categoryId)

);

