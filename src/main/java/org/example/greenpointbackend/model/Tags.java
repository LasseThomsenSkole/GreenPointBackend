package org.example.greenpointbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String tags;




}

enum Titles {
    IN_STORE_TRAINER, IN_STORE_MERCHANDISE, CONTACT_LENSE_CONSULTANT, OPTICAL_DISPENSER, SALES_ASSISTANT, OPTICIAN
}
 enum Filter {
    IN_STORE_TRAINER, IN_STORE_MERCHANDISE, CONTACT_LENSE_CONSULTANT, OPTICAL_DISPENSER, SALES_ASSISTANT, OPTICIAN,CL, KD, CLC, IST, ISM, OD,
    GLAS, LINSER, AFBETALING, STEL, DYKKERBRILLER, SIKKERHEDSBRILLER, HÅRDE_LINSER,BLØDE_LINSER, VÆSKER, ALCON, COPPER, WOOPERVISION, JNJ, JOHNSONJOHNSON,
    BESTILLING, KUNDE, KUNDEVEJEN, HQ, KAMPAGNE, ADARO, DHL, DAO, SCALEPOINT, FORSIKRING, BANK, RESURS_BANK, EXPRESS_BANK, HJÆLP, IT, PRINTER, TELEFON,
    PRODUKT, KOMMUNE, KENNEDY_CENTRET, KOMMUNIKATIONSCENTRET, ØJENLÆGE, FUNDUS, SUNDHED, ALLE
}
