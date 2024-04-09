package task3.PaymentFactory.PaymentStrategy;

import task3.Client;

public class CashPayment implements Payment {
    @Override
    public void pay(Client client, Double suma) {
        client.platesteCuCash(suma);
    }
}
