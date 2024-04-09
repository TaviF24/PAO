package task3.PaymentFactory;

import task3.PaymentFactory.PaymentStrategy.BankTransferPayment;
import task3.PaymentFactory.PaymentStrategy.CardPayment;
import task3.PaymentFactory.PaymentStrategy.CashPayment;
import task3.PaymentFactory.PaymentStrategy.Payment;

public class PaymentFactory {
    public static Payment create(PaymentMethod paymentMethod) throws ClassNotFoundException {
        switch (paymentMethod){
            case CASH -> {
                return new CashPayment();
            }
            case CARD -> {
                return new CardPayment();
            }
            case BANK_TRANSFER -> {
                return new BankTransferPayment();
            }
            default -> { throw new ClassNotFoundException("Invalid method of payment"); }
        }
    }
}
