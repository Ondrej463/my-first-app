package com.backendAplication.app.Data;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
//pridá všetky gettery a settery
@Data
//bezparametrický konštruktor
@NoArgsConstructor
//konštruktor s parametrami všetkých atribútov
@AllArgsConstructor
//definícia tabuľky
@Entity
@Table(name = "cars")
/**
 * Trieda Cars funguje ako tabuľka, má definované názvy stlpcov ako parametre
 */
public class Cars {
    //identifikátor sa bude automaticky generovať
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private String name;
    private String color;
    private int power;
}
