### Design patterns folosite:

- **Singleton**: Am folosit singleton pentru ca am vrut sa fie o singura instanta Magazin;
- **Builder**: Am folosit builder pentru clasa Client deoarece avea un numar relativ mare de parametrii, fiind mai usoara initializarea lor asa;
- **Factory**: Am aplicat factory pentru ca generam diferite tipuri de Payment, in functie de ce prefera clientul si in loc sa las vizibil procesul de creare, l-am ascuns dupa o metoda ce va fi folosita peste tot la instantieri;
- **Strategy**: Am utilizat strategy, folosindu-l impreuna cu factory deoarece, chiar daca actiunea de a plati este aceeasi, ea are diferite implementari, in functie de ce tip de payment se doreste a face astfel, cele 3 moduri de a plati: cash, card, transfer bancar au fiecare implementarea sa. Diferenta dintre el si factory este ca in factory imi creez obiectele, iar in strategy le folosesc implementarea.
