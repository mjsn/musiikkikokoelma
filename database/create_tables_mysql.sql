CREATE TABLE levyArtisti (
	id SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nimi VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE levyGenre (
	id SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nimi VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE levyTyyppi (
	id SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nimi VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE levy (
	id SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	tunnus VARCHAR(20),
	otsikko VARCHAR(255) NOT NULL,
	artistiId SMALLINT NOT NULL,
	genreId SMALLINT NOT NULL,
	arvosana INT,
	julkaisuVuosi CHAR(4),
	tyyppiId SMALLINT,
	levyMaara INT,
	levyKunto INT,
	kansiKunto INT,
	muutaTietoa VARCHAR(255),
	FOREIGN KEY (artistiId) REFERENCES levyArtisti(id),
	FOREIGN KEY (genreId) REFERENCES levyGenre(id),
	FOREIGN KEY (tyyppiId) REFERENCES levyTyyppi(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE authority (
  id integer NOT NULL auto_increment PRIMARY KEY,
  role varchar(255) NOT NULL UNIQUE
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 
 CREATE TABLE levyUser (
  id integer NOT NULL auto_increment PRIMARY KEY,
  username varchar(255) NOT NULL UNIQUE,
  password_encrypted varchar(255) NOT NULL,
  enabled tinyint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE levyUser_authority (
  id integer NOT NULL auto_increment PRIMARY KEY,
  levyUser_id integer NOT NULL,
  authority_id integer NOT NULL,
  FOREIGN KEY (levyUser_id) REFERENCES levyUser(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (authority_id) REFERENCES authority(id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

