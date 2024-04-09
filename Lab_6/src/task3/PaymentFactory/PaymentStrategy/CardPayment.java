package task3.PaymentFactory.PaymentStrategy;

import task3.Client;

public class CardPayment implements Payment{
    @Override
    public void pay(Client client, Double suma) {
        client.platesteCuCard(suma);
    }
}
