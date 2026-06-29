-- Exercise 3: Stored Procedures in PL/SQL

-- 1. Simple Stored Procedure: Greet a person
CREATE OR REPLACE PROCEDURE greet_person(p_name IN VARCHAR2) AS
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello, ' || p_name || '! Welcome.');
END;
/

-- Execute the procedure
BEGIN
    greet_person('Utsah');
END;
/

-- 2. Procedure with IN and OUT parameters: Calculate square
CREATE OR REPLACE PROCEDURE calculate_square(
    p_number IN NUMBER,
    p_result OUT NUMBER
) AS
BEGIN
    p_result := p_number * p_number;
END;
/

-- Execute and display result
DECLARE
    v_result NUMBER;
BEGIN
    calculate_square(7, v_result);
    DBMS_OUTPUT.PUT_LINE('Square of 7 = ' || v_result);
END;
/

-- 3. Procedure to calculate salary after bonus
CREATE OR REPLACE PROCEDURE calculate_salary(
    p_basic IN NUMBER,
    p_bonus_percent IN NUMBER,
    p_total OUT NUMBER
) AS
BEGIN
    p_total := p_basic + (p_basic * p_bonus_percent / 100);
END;
/

-- Execute
DECLARE
    v_total NUMBER;
BEGIN
    calculate_salary(50000, 20, v_total);
    DBMS_OUTPUT.PUT_LINE('Total Salary after bonus: ' || v_total);
END;
/