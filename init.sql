CREATE DATABASE blog;

USE blog;

CREATE TABLE `t_blog` (
   `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
   `title` varchar(60) DEFAULT NULL COMMENT '博客标题',
   `author` varchar(60) DEFAULT NULL COMMENT '博客作者',
   `content` mediumtext COMMENT '博客内容',
   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
   `update_time` datetime DEFAULT NULL COMMENT '更新时间',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4


# 自己造的几条数据
INSERT INTO `blog`.`t_blog`(`id`, `title`, `author`, `content`, `create_time`, `update_time`) VALUES (1, 'Springboot 为什么这', 'bywind', '没错 Springboot ', '2019-12-08 01:44:29', '2019-12-08 01:44:34');
INSERT INTO `blog`.`t_blog`(`id`, `title`, `author`, `content`, `create_time`, `update_time`) VALUES (3, 'Springboot 中 Redis', 'bywind', 'Spring Boot', '2019-12-08 01:44:29', '2019-12-08 01:44:29');
INSERT INTO `blog`.`t_blog`(`id`, `title`, `author`, `content`, `create_time`, `update_time`) VALUES (4, 'Springboot 中如何优化', 'bywind', NULL, '2019-12-08 01:44:29', '2019-12-08 01:44:29');
INSERT INTO `blog`.`t_blog`(`id`, `title`, `author`, `content`, `create_time`, `update_time`) VALUES (5, 'Springboot 消息队列', 'bywind', NULL, '2019-12-08 01:44:29', '2019-12-08 01:44:29');
INSERT INTO `blog`.`t_blog`(`id`, `title`, `author`, `content`, `create_time`, `update_time`) VALUES (6, 'Docker Compose + Springboot', 'bywind', NULL, '2019-12-08 01:44:29', '2019-12-08 01:44:29');