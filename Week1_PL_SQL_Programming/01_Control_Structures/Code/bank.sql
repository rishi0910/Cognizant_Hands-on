--------------------------------------------------
-- 1. TABLES CREATION
--------------------------------------------------
CREATE TABLE loan_accounts (
    customer_id NUMBER,
    customer_age NUMBER,
    interest_rate NUMBER
);

CREATE TABLE bank_balances (
    account_holder_id NUMBER,
    current_balance NUMBER
);

CREATE TABLE customer_profiles (
    customer_id NUMBER,
    customer_name VARCHAR2(50),
    IsVIP VARCHAR2(10) DEFAULT 'FALSE'
);

CREATE TABLE active_loans (
    customer_id NUMBER,
    loan_number VARCHAR2(20),
    maturity_date DATE,
    outstanding_amount NUMBER
);

--------------------------------------------------
-- 2. SAMPLE DATA INSERTION
--------------------------------------------------
INSERT INTO loan_accounts VALUES (1, 65, 12.5);
INSERT INTO loan_accounts VALUES (2, 45, 10.5);

INSERT INTO bank_balances VALUES (1, 15000);
INSERT INTO bank_balances VALUES (2, 4500);

INSERT INTO customer_profiles (customer_id, customer_name) VALUES (1, 'Rishi Srivastava');
INSERT INTO customer_profiles (customer_id, customer_name) VALUES (2, 'Amit Sharma');

INSERT INTO active_loans VALUES (1, 'LN1001', SYSDATE + 15, 5000);
INSERT INTO active_loans VALUES (2, 'LN1002', SYSDATE + 45, 2500);

--------------------------------------------------
-- 3. PROCEDURES DEFINITION
--------------------------------------------------
CREATE OR REPLACE PROCEDURE GrantSeniorDiscount IS
BEGIN
    FOR r_cust IN (
        SELECT customer_id, interest_rate 
        FROM loan_accounts 
        WHERE customer_age > 60
    ) LOOP
        UPDATE loan_accounts
        SET interest_rate = interest_rate - 1
        WHERE customer_id = r_cust.customer_id;
        
        DBMS_OUTPUT.PUT_LINE('CustomerID: ' || r_cust.customer_id || ' interest rate is decreased by 1%.');
    END LOOP;
END;
/

CREATE OR REPLACE PROCEDURE EvaluateVipStatus IS
BEGIN
    FOR r_acct IN (
        SELECT account_holder_id, current_balance 
        FROM bank_balances 
        WHERE current_balance > 10000
    ) LOOP
        UPDATE customer_profiles
        SET IsVIP = 'TRUE'
        WHERE customer_id = r_acct.account_holder_id;
        
        DBMS_OUTPUT.PUT_LINE('CustomerID: ' || r_acct.account_holder_id || ' promoted to VIP based on balance.');
    END LOOP;
END;
/

CREATE OR REPLACE PROCEDURE GenerateDueReminders IS
BEGIN
    FOR r_loan IN (
        SELECT l.loan_number, c.customer_name, l.maturity_date
        FROM active_loans l
        JOIN customer_profiles c ON l.customer_id = c.customer_id
        WHERE l.maturity_date BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder sent to ' || r_loan.customer_name || ' for Loan account #' || r_loan.loan_number || '.');
    END LOOP;
END;
/

--------------------------------------------------
-- 4. EXECUTION MATRIX
--------------------------------------------------
BEGIN
    DBMS_OUTPUT.PUT_LINE('SCENARIO - 1: For applying discount to interest rate for the customers above age 60');
    GrantSeniorDiscount;
    DBMS_OUTPUT.PUT_LINE('PL/SQL procedure successfully completed.');
    DBMS_OUTPUT.PUT_LINE('--------------------------------------------------');
    
    DBMS_OUTPUT.PUT_LINE('SCENARIO - 2: Promote customers to VIP status based on balance');
    EvaluateVipStatus;
    DBMS_OUTPUT.PUT_LINE('PL/SQL procedure successfully completed.');
    DBMS_OUTPUT.PUT_LINE('--------------------------------------------------');
    
    DBMS_OUTPUT.PUT_LINE('SCENARIO - 3: Reminders for loans due within the next 30 days');
    GenerateDueReminders;
    DBMS_OUTPUT.PUT_LINE('PL/SQL procedure successfully completed.');
END;
/