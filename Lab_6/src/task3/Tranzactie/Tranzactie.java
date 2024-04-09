package task3.Tranzactie;

import task3.Client;

public class Tranzactie {
    private StatusTranzactie status;
    private final Double cost;
    private final Client client;

    public Tranzactie(StatusTranzactie status, Double cost, Client client) {
        this.status = status;
        this.cost = cost;
        this.client = client;
    }

    public StatusTranzactie getStatus() {
        return status;
    }

    public Double getCost() {
        return cost;
    }

    public Client getClient() {
        return client;
    }

    public void setStatus(StatusTranzactie status) {
        this.status = status;
    }
}
