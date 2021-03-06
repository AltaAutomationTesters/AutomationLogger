  
 DELIMITER $$
 CREATE TRIGGER UPDATELOCATORLOG
BEFORE UPDATE  ON APP.LOCATORS
 FOR EACH ROW
	BEGIN 
		SET NEW.TIME_STAMP=CURRENT_TIMESTAMP;
		SET NEW.LOGS =CONCAT('Author: ' , NEW.AUTHOR , ', Locator IID: ' , NEW.IID , ', Locator Value: ', NEW.LOCATOR_VALUE , ', Locator Type: ' , NEW.LOCATOR_TYPE ,  ', DRIVER TYPE: ' , NEW.DRIVER_TYPE , ', Timestamp:  ' , NEW.TIME_STAMP , '\n', OLD.LOGS);
    END $$
DELIMITER ;

 UPDATE `APP`.`LOCATORS` SET `LOCATOR_VALUE`='BALLU56' WHERE `LOCATOR_ID`='1';

 SELECT * FROM APP.LOCATORS;  

 DROP TRIGGER UPDATELOCATORLOG;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 DELIMITER $$
CREATE TRIGGER UPDATEQUERYLOG
BEFORE UPDATE  ON APP.QUERIES
 FOR EACH ROW
	BEGIN 
		SET NEW.TIME_STAMP=CURRENT_TIMESTAMP;
		SET NEW.LOGS =CONCAT('Author: ' , NEW.AUTHOR , ', Query IID: ' , NEW.IID , ', Query Text: ', NEW.QUERY_STRING , ', Is Active? ' , NEW.IS_ACTIVE ,  ', DB DATA TYPE ARRAY: ' , NEW.DB_DATA_TYPE_ARRAY , ', QUERY TYPE: ' , NEW.QUERY_TYPE ,', VENDOR TYPE: ' , NEW.VENDOR_TYPE ,', Timestamp:  ' , NEW.TIME_STAMP , '\n', OLD.LOGS);
    END $$
DELIMITER ;

 UPDATE `APP`.`QUERIES` SET `QUERY_STRING`='BALLU56' WHERE `QUERY_ID`='1';

 SELECT * FROM APP.QUERIES;  

 DROP TRIGGER UPDATEQUERYLOG;
















 DELIMITER $$
CREATE TRIGGER UPDATEMESSAGELOG
BEFORE UPDATE  ON APP.MESSAGES
 FOR EACH ROW
	BEGIN 
		SET NEW.TIME_STAMP=CURRENT_TIMESTAMP;
		SET NEW.LOGS =CONCAT('Author: ' , NEW.AUTHOR , ', Message IID: ' , NEW.IID , ', Message Text: ', NEW.MESSAGE_TEXT , ', Is Client Side Message? ' , NEW.IS_CLIENT_MESSAGE ,  ', Timestamp:  ' , NEW.TIME_STAMP , '\n', OLD.LOGS);
    END $$
DELIMITER ;

 UPDATE `APP`.`MESSAGES` SET `MESSAGE_TEXT`='BALLU56' WHERE `MESSAGE_ID`='2';

 SELECT * FROM APP.MESSAGES;  

 DROP TRIGGER UPDATEMESSAGELOG;
 
 

 
 
 CREATE TRIGGER UPDATEQUERYLOG
 AFTER UPDATE  ON QUERIES
 FOR EACH ROW 
 UPDATE APP.QUERIES
 SET LOG_CHECKER = ADDED_BY || ' added ' || SQLQUERY || ' at '|| DBDATATYPEARRAY || ' with ' || APPLICATION_NAME ||  ' which is ' || QUERYTYPE || ' of Driver Type ' || DESCRIPTION || ' - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ' || EXISTING.LOG_CHECKER WHERE query_iid = EXISTING.query_iid