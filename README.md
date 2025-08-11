# Bank-Account-Simulation

* Built Points for Bank Account Simulation.

1.Account Class Design
Fields:
(i) accountNumber (unique ID)
(ii) accountHolderName
(iii) balance (double)
(iv) transactionHistory (List of transactions)

Methods:

(i) deposit(double amount)
(ii) withdraw(double amount)
(iii) getBalance()
(iv) getTransactionHistory()

2 .Transaction Class
Fields:

(i) transactionId (UUID)
(ii) dateTime (LocalDateTime)
(iii) type (DEPOSIT/WITHDRAW)
(iv) amount
(v) balanceAfterTransaction

3 .Bank Class (Manager)

1. Manage multiple accounts (using HashMap<Long, Account>).
2. Create new account.
3. Search account by account number.
4. Close account.

   
[ 3 ]. User Interface (Simulation Menu)

Options:
Create account
Deposit money
Withdraw money
Show balance
Show transaction history
Exit


