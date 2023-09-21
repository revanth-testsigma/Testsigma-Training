// Custom Exceptions
class AccountException extends Exception {
    public AccountException(String message) {
        super(message);
    }
}

class TransactionFailedException extends AccountException {
    public TransactionFailedException(String message) {
        super(message);
    }
}

class InvalidTransactionException extends TransactionFailedException {
    public InvalidTransactionException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends InvalidTransactionException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}