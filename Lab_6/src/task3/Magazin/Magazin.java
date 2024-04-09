package task3.Magazin;

import task3.Client;

import java.util.ArrayList;
import java.util.List;

public class Magazin {

    private static Magazin INSTANCE = null;
    private final List<Produs>produse;

    private CasaDeMarcat casaDeMarcat;

    private Magazin(){
        produse = new ArrayList<>();
        casaDeMarcat = new CasaDeMarcat();
    }
    public static Magazin getInstance(){
        if(INSTANCE==null){
            INSTANCE = new Magazin();
        }
        return INSTANCE;
    }

    public void insertProduse(Produs produs){
        produse.add(produs);
    }

    public void VerificaSiCumpara(Produs produs, Client client){
        if(!client.verificaPlata(produs.getPret())){
            System.out.println("Fonduri insuficiente. Metoda plata: " + client.getMetodaPlataPreferata() + ".");
        }else{
            casaDeMarcat.initiazaTranzactie(produs.getPret(),client);
        }
    }

    public void inchideMagazin(){
        casaDeMarcat.acceptaTranzactiile();
    }

    public Produs getProdus(Integer index){
        return produse.get(index);
    }

}
