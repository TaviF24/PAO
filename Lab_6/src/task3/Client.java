package task3;

import task3.PaymentFactory.PaymentMethod;

import java.util.Random;

public class Client {
    private String nume;
    private Double sumaCash;
    private Double sumaInBanca;
    private Double sumaCard;
    private PaymentMethod metodaPlataPreferata;

    private Double tempSumaCash;
    private Double tempSumaInBanca;
    private Double tempSumaCard;

    private Client(){}

    public void platesteCuCash(Double pret) {
        sumaCash -= pret;
    }

    public void platesteCuTransfer(Double pret) {
        sumaInBanca -= pret;
    }

    public void platesteCuCard(Double pret) {
        sumaCard -= pret;
    }

    public PaymentMethod getMetodaPlataPreferata() {
        return metodaPlataPreferata;
    }

    public void SchimbaMetodaPlata(PaymentMethod metodaPlata) {
        this.metodaPlataPreferata = metodaPlata;
    }

    public Boolean verificaPlata(Double pret){  // "banca" clientului ii ia banii, dar asta nu inseamna ca au ajuns la vanzator
        switch (metodaPlataPreferata){           // astfel blochez clientul din a cumpara fara a avea destui bani
            case CASH -> {
                if(pret <= tempSumaCash){
                    tempSumaCash -= pret;
                    return true;
                }
                return false;
            }
            case CARD -> {
                if(pret <= tempSumaCard){
                    tempSumaCard -= pret;
                    return true;
                }
                return false;
            }
            case BANK_TRANSFER -> {
                if(pret <= tempSumaInBanca){
                    tempSumaInBanca -= pret;
                    return true;
                }
                return false;
            }
            default -> { return false; }
        }
    }

    public static class Builder{

        private final String nume;
        private Double sumaCash = 0.0;
        private Double sumaInBanca = 0.0;
        private Double sumaCard = 0.0;
        private PaymentMethod metodaPlataPreferata = PaymentMethod.values()[(new Random()).nextInt(PaymentMethod.values().length)];

        public Builder(String nume){
            this.nume = nume;
        }

        public Builder setSumaCash(Double sumaCash) {
            this.sumaCash = sumaCash;
            return this;
        }

        public Builder setSumaInBanca(Double sumaInBanca) {
            this.sumaInBanca = sumaInBanca;
            return this;
        }

        public Builder setSumaCard(Double sumaCard) {
            this.sumaCard = sumaCard;
            return this;
        }

        public Builder setMetodaPlataPreferata(PaymentMethod paymentMethod){
            this.metodaPlataPreferata = paymentMethod;
            return this;
        }

        public Client build(){
            Client client = new Client();
            client.nume = nume;
            client.sumaCash = sumaCash;
            client.sumaCard = sumaCard;
            client.sumaInBanca = sumaInBanca;
            client.metodaPlataPreferata = metodaPlataPreferata;

            client.tempSumaCash = sumaCash;
            client.tempSumaCard = sumaCard;
            client.tempSumaInBanca = sumaInBanca;
            return client;
        }
    }
}
