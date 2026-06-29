-- Exercise 1: Control Structures in PL/SQL

-- 1. IF-THEN-ELSE: Check if a number is positive, negative or zero
DECLARE
    num NUMBER := 15;
BEGIN
    IF num > 0 THEN
        DBMS_OUTPUT.PUT_LINE('Number ' || num || ' is Positive');
    ELSIF num < 0 THEN
        DBMS_OUTPUT.PUT_LINE('Number ' || num || ' is Negative');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Number is Zero');
    END IF;
END;
/

-- 2. CASE Statement: Grade evaluation
DECLARE
    marks NUMBER := 85;
    grade VARCHAR2(10);
BEGIN
    grade := CASE
        WHEN marks >= 90 THEN 'A'
        WHEN marks >= 80 THEN 'B'
        WHEN marks >= 70 THEN 'C'
        WHEN marks >= 60 THEN 'D'
        ELSE 'F'
    END;
    DBMS_OUTPUT.PUT_LINE('Marks: ' || marks || ', Grade: ' || grade);
END;
/

-- 3. FOR Loop: Print first 5 numbers
BEGIN
    FOR i IN 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE('Number: ' || i);
    END LOOP;
END;
/

-- 4. WHILE Loop: Calculate factorial
DECLARE
    n NUMBER := 5;
    factorial NUMBER := 1;
    i NUMBER := 1;
BEGIN
    WHILE i <= n LOOP
        factorial := factorial * i;
        i := i + 1;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Factorial of ' || n || ' = ' || factorial);
END;
/