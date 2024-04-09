package task3;

import task3.Magazin.Magazin;
import task3.Magazin.Produs;
import task3.PaymentFactory.PaymentMethod;

public class Main {
    public static void main(String[] args){
        Magazin magazin = Magazin.getInstance();
        magazin.insertProduse(new Produs(1.0, "P1"));
        magazin.insertProduse(new Produs(2.0, "P2"));
        magazin.insertProduse(new Produs(3.0, "P3"));
        magazin.insertProduse(new Produs(4.0, "P4"));
        magazin.insertProduse(new Produs(5.0, "P5"));
        magazin.insertProduse(new Produs(6.0, "P6"));
        magazin.insertProduse(new Produs(7.0, "P7"));



        Client client1 = new Client.Builder("client 1")
                                    .setSumaCard(2.0)
                                    .setSumaCash(3.0)
                                    .setSumaInBanca(4.0)
                                    .build();

        Client client2 = new Client.Builder("client 2")
                .setSumaCard(2.0)
                .setSumaCash(3.0)
                .setSumaInBanca(5.0)
                .setMetodaPlataPreferata(PaymentMethod.BANK_TRANSFER)
                .build();

        magazin.VerificaSiCumpara(magazin.getProdus(0), client1);
        magazin.VerificaSiCumpara(magazin.getProdus(1), client1);

        magazin.VerificaSiCumpara(magazin.getProdus(3), client2);
        magazin.VerificaSiCumpara(magazin.getProdus(2), client2);
        magazin.inchideMagazin();
    }
}
