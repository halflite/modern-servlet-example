LOCK TABLES `account` WRITE; 

/*!40000 ALTER TABLE `account` DISABLE KEYS */
; 

INSERT 
INTO `account` 
VALUES ( 
  1
  , 'testuser1@example.com'
  , '81dc9bdb52d04dc20036dbd8313ed055'
  , 'てすとゆーざー壱号'
  , 'ENABLED'
  , '2019-02-01 00:00:00'
  , '2019-02-01 00:00:00'
) 
, ( 
  2
  , 'testuser2@example.com'
  , '674f3c2c1a8a6f90461e8a66fb5550ba'
  , 'てすとゆーざー弐号'
  , 'ENABLED'
  , '2019-02-01 00:00:00'
  , '2019-02-01 00:00:00'
); 

/*!40000 ALTER TABLE `account` ENABLE KEYS */
; 

UNLOCK TABLES; 
