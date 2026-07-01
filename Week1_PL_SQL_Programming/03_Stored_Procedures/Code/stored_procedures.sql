
CREATE TABLE Fin_Vaults_Registry (
    x_vault_id INT PRIMARY KEY,
    x_vault_tier VARCHAR2(25),
    x_net_liquidity NUMBER(12, 2)
);

CREATE TABLE Human_Capital_Force (
    x_resource_id INT PRIMARY KEY,
    x_resource_alias VARCHAR2(60),
    x_base_remuneration NUMBER(12, 2),
    x_division_tag VARCHAR2(35)
);

-- Baseline Records Seeding
INSERT INTO Fin_Vaults_Registry VALUES (901, 'Yield_Savings', 4850.00);
INSERT INTO Fin_Vaults_Registry VALUES (902, 'Active_Current', 2900.00);
INSERT INTO Fin_Vaults_Registry VALUES (903, 'Yield_Savings', 11200.00);

INSERT INTO Human_Capital_Force VALUES (7001, 'Resource_Alpha', 54000.00, 'Operations_Core');
INSERT INTO Human_Capital_Force VALUES (7002, 'Resource_Beta', 62500.00, 'Talent_Acquisition');
INSERT INTO Human_Capital_Force VALUES (7003, 'Resource_Gamma', 78000.00, 'Operations_Core');


-- =========================================================
-- SCENARIO 1: Process Monthly Interest (Savings Only)
-- =========================================================
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
    v_updated_rows INT := 0;
BEGIN
    UPDATE Fin_Vaults_Registry
    SET x_net_liquidity = x_net_liquidity * 1.01
    WHERE x_vault_tier = 'Yield_Savings';
    
    v_updated_rows := SQL%ROWCOUNT;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Number of accounts updated: ' || v_updated_rows);
END;
/



-- SCENARIO 2: Update Employee Bonus

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    target_division_in IN VARCHAR2,
    incentive_ratio_in IN NUMBER
) AS
    v_updated_staff INT := 0;
BEGIN
    UPDATE Human_Capital_Force
    SET x_base_remuneration = x_base_remuneration * (1 + (incentive_ratio_in / 100))
    WHERE x_division_tag = target_division_in;
    
    v_updated_staff := SQL%ROWCOUNT;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Number of employees updated: ' || v_updated_staff);
END;
/



-- SCENARIO 3: Cross-Vault Liquidity Routing Framework

CREATE OR REPLACE PROCEDURE TransferFunds (
    source_vault_in IN INT,
    target_vault_in IN INT,
    transfer_quantum_in IN NUMBER
) AS
    v_liquidity_checkpoint NUMBER;
BEGIN
    SELECT x_net_liquidity INTO v_liquidity_checkpoint 
    FROM Fin_Vaults_Registry 
    WHERE x_vault_id = source_vault_in;
    
    IF v_liquidity_checkpoint >= transfer_quantum_in THEN
        UPDATE Fin_Vaults_Registry 
        SET x_net_liquidity = x_net_liquidity - transfer_quantum_in 
        WHERE x_vault_id = source_vault_in;
        
        UPDATE Fin_Vaults_Registry 
        SET x_net_liquidity = x_net_liquidity + transfer_quantum_in 
        WHERE x_vault_id = target_vault_in;
        
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Fund transfer completed successfully.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds for transfer.');
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Registry node not found.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Procedure execution failed.');
END;
/