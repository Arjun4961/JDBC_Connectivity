# JDBC_Connectivity
For collable statemnt we need to store the procedure in workbench and the query is :DELIMITER //

CREATE PROCEDURE sp(IN rno INT, IN name VARCHAR(255), IN branch VARCHAR(255))
BEGIN
    INSERT INTO student1 (rno, name, branch) VALUES (rno, name, branch);
END //

DELIMITER ;
# To check the stored procedure 
SHOW PROCEDURE STATUS WHERE Db = 'college';
