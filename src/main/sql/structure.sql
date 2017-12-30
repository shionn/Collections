
-- user
CREATE TABLE IF NOT EXISTS `user` (
  `email`    varchar(128) CHARACTER SET utf8 NOT NULL,
  `password` varchar(256) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- items
CREATE TABLE IF NOT EXISTS `item` (
  id          int(11)                         NOT NULL AUTO_INCREMENT,
  collection  varchar(32)  CHARACTER SET utf8 NOT NULL,
  name        varchar(128) CHARACTER SET utf8 NULL,
  author      varchar(128) CHARACTER SET utf8 NULL,
  numbers     varchar(128) CHARACTER SET utf8 NULL,
  plateform   varchar(128) CHARACTER SET utf8 NULL,
  region      varchar(128) CHARACTER SET utf8 NULL,
  complete    boolean                         NULL,
  year        varchar(32)  CHARACTER SET utf8 NULL,
  qty         int(11)                         NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;


