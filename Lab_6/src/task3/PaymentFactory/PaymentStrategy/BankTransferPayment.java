package task3.PaymentFactory.PaymentStrategy;

import task3.Client;

public class BankTransferPayment implements Payment{
    @Override
    public void pay(Client client, Double suma) {
        client.platesteCuTransfer(suma);
    }
}
