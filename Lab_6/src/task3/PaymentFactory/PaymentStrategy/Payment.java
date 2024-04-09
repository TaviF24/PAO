package task3.PaymentFactory.PaymentStrategy;

import task3.Client;

public interface Payment {
    void pay(Client client, Double suma);
}
