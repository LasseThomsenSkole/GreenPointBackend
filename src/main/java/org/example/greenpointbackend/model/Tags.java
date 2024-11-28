package org.example.greenpointbackend.model;

public class Tags {

    private Titles titles;
    private Vision vision;
    private Brand brand;
    private Info info;
    private Health health;
    private ExternalPatners externPartners;
    private Alle alle;

}

enum Titles {
    IN_STORE_TRAINER, IN_STORE_MERCHANDISE, CONTACT_LENSE_CONSULTANT,
    OPTICAL_DISPENSER, SALES_ASSISTANT, OPTICIAN,
    CL, KD, CLC, IST, ISM, OD
}

enum Vision {
    GLAS, LINSER, STEL, DYKKEBRILLER, SIKKERHEDSBRILLER,
    HÅRDE_LINSER, BLØDE_LINSER, VÆSKER
}

enum Brand {
ALCON, COOPER, COOPERVISION, JNJ, JOHNSONJOHNSON, ADARO
}

enum Info {
    AFBESTILLING, BESTILLING, KUNDE, KUNDEVEJEN, HQ,
    KAMPAGNE, HJÆLP, IT, PRINTER, TELEFON
}

enum Health{
    KOMMUNE, KENNEDY_CENTRET, KOMMUNIKATIONSCENTRET,
    ØJENLÆGE, FUNDUS, SUNDHED
}

enum ExternalPatners {
    DHL, DAO, SCALEPOINT, FORSIKRING, BANK,
    RESURS_BANK, EXPRESS_BANK,
    PRODUKT
}

enum Alle {
    ALLE
}