INSERT INTO levyArtisti
	(id, nimi)
VALUES
	(1, 'X'),
	(2, 'DAOKO'),
	(3, '平沢進'),
	(4, 'ボンジュール鈴木'),
	(5, '花澤香菜'),
	(6, 'BABYMETAL'),
	(7, 'さユり'),
	(8, 'フィッシュマンズ'),
	(9, 'The Beatles'),
	(10, '筋肉少女帯'),
	(11, 'Aimer'),
	(12, 'Perfume');
	
	
INSERT INTO levyGenre
	(id, nimi)
VALUES
	(1, 'Tuntematon'),
	(2, 'Blues'),
	(3, 'Elektroninen'),
	(4, 'Fuusio'),
	(5, 'Hip hop'),
	(6, 'House'),
	(7, 'Jazz'),
	(8, 'Klassinen'),
	(9, 'Metalli'),
	(10, 'Pop'),
	(11, 'Punk'),
	(12, 'Reggae'),
	(13, 'Dub'),
	(14, 'Rock'),
	(15, 'Tekno');
	
	
INSERT INTO levyTyyppi
	(id, nimi)
VALUES
	(1, '8cm'),
	(2, '12cm'),
	(3, '7"'),
	(4, '10"'),
	(5, '12"');
	
	
INSERT INTO levy
	(id, tunnus, otsikko, artistiId, genreId, arvosana, julkaisuVuosi, tyyppiId, levyMaara, levyKunto, kansiKunto, muutaTietoa)
VALUES
	(1, '32AH5224-5', 'Blue Blood', 1, 9, 5, '1989', 5, 2, 5, 5, ''),
	(2, 'MHCL-30398', 'Jealousy', 1, 9, 5, '1991', 2, 1, 5, 5, 'Re-master'),
	(3, 'TFCC-86508', 'DAOKO', 2, 10, 5, '2015', 2, 1, 5, 5, ''),
	(4, 'POCH-1328', 'Aurora', 3, 3, 5, '1994', 2, 1, 5, 5, ''),
	(5, 'COCP-35525', '救済の技法', 3, 3, 5, '1998', 2, 1, 5, 5, 'Re-master'),
	(6, 'BUTA-003', 'Lollipopシンドローム', 4, 10, 5, '2015', 2, 1, 5, 5, ''),
	(7, 'SVWC-70064~65', 'Blue Avenue', 5, 10, 5, '2015', 2, 2, 5, 5, 'Limited Edition+Blu-ray'),
	(8, 'SVWC-70251~52', 'Opportunity', 5, 10, 5, '2017', 2, 2, 5, 5, 'Limited Edition+Blu-ray'),
	(9, 'TFJC-38024', 'BABYMETAL', 6, 9, 4, '2015', 5, 2, 5, 4, 'Limited Edition'),
	(10, 'BVCL-793-4', 'ミカヅキの航海', 7, 10, 4, '2017', 2, 2, 5, 4, 'Limited Edition+Blu-ray'),
	(11, 'PCCAX-7', 'Neo Yankees'' Holiday', 8, 13, 4, '1998', 2, 1, 5, 4, ''),
	(12, 'VJCA-4', 'Chappie,Don''t Cry', 8, 13, 4, '1991', 2, 1, 5, 4, ''),
	(13, 'PCS-7088 ', 'Abbey Road', 9, 14, 5, '1969', 5, 1, 3, 3, ''),
	(14, 'TFCC-86304', '猫のテブクロ', 10, 9, 3, '1989', 2, 1, 5, 4, ''),
	(15, 'TFCC-88010', '断罪!断罪!また断罪!!', 10, 9, 4, '1991', 2, 1, 5, 4, ''),
	(16, 'DFCL-1932', 'Sleepless Nights', 11, 10, 4, '2012', 2, 1, 5, 4, ''),
	(17, 'SVWC-70227', 'ざらざら', 5, 10, 5, '2016', 2, 1, 5, 5, ''),
	(18, 'TKCA-73655', 'レーザービーム / 微かなカオリ', 12, 3, 5, '2011', 2, 1, 4, 4, ''),
	(19, 'TKCA-73735', 'JPN', 12, 3, 5, '2011', 2, 1, 4, 4, ''),
	(20, 'TKCA-73325', 'GAME', 12, 3, 5, '2008', 2, 1, 4, 4, '');

	
	
INSERT INTO authority
	(id, role)
VALUES
	(1,'ROLE_USER'),
	(2,'ROLE_ADMIN');


INSERT INTO levyUser
	(id, username, password_encrypted, enabled)
VALUES
	(1, 'admin', '7ce6e44b6def1ab410906e5ae23a006c1f1a8d83830b742947e4c6cf7bb84d19a6dedd1c0e13ff71', 1);
	
	
INSERT INTO levyUser_authority
	(levyUser_id, authority_id)
VALUES
	(1,2);
	
