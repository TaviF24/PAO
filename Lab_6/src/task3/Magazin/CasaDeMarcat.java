package task3.Magazin;

import task3.Client;
import task3.PaymentFactory.PaymentFactory;
import task3.PaymentFactory.PaymentStrategy.Payment;
import task3.Tranzactie.StatusTranzactie;
import task3.Tranzactie.Tranzactie;

import java.util.ArrayList;
import java.util.List;

public class CasaDeMarcat {
    private final List<Tranzactie> tranzactii;
    private Double sumaTotala=0.0;

    public CasaDeMarcat(){
        tranzactii = new ArrayList<>();
    }

    public void initiazaTranzactie(Double cost, Client client){
        tranzactii.add(new Tranzactie(StatusTranzactie.WAITING, cost, client));
    }

    public void acceptaTranzactiile(){
        for(Tranzactie tranzactie : tranzactii){
            try{
                Client client = tranzactie.getClient();
                Payment payment = PaymentFactory.create(client.getMetodaPlataPreferata());

                payment.pay(client, tranzactie.getCost());
                sumaTotala += tranzactie.getCost();
                tranzactie.setStatus(StatusTranzactie.ACCEPTED);

                System.out.println("Status tranzactie: " + tranzactie.getStatus().toString() + ". Metoda de plata: " + client.getMetodaPlataPreferata().toString() + ".");

            }catch (ClassNotFoundException e){
                System.err.println(e.getMessage());
            }
        }
        tranzactii.clear();
        System.out.println("Total incasari: " + sumaTotala + " RON");
    }
}
