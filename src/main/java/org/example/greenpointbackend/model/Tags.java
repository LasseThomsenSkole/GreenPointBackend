package org.example.greenpointbackend.model;

public class Tags {

    private Titles titles;
    private Vision vision;
    private Brands brands;
    private Info info;
    private Health health;
    private ExternalPatners externPartners;
    private All all;

}

enum Titles {
    IN_STORE_TRAINER, IN_STORE_MERCHANDISE, CONTACT_LENSE_CONSULTANT,
    OPTICAL_DISPENSER, SALES_ASSISTANT, OPTICIAN,
    CL, KD, CLC, IST, ISM, OD
}

enum Vision {
    GLASSES, LENSES, FRAMES, DIVING_GOGGLES, SAFETY_GOGGLES,
    HARD_LENSES, SOFT_LENSES, LIQUIDS
}

enum Brands {
ALCON, COOPER, COOPERVISION, JNJ, JOHNSONJOHNSON, ADARO
}

enum Info {
    RE_ORDER, ORDER, CUSTOMER, CUSTOMERPATH, HQ,
    KAMPAGNE, HELP, IT, PRINTER, TELEPHONE
}

enum Health{
    MUNICIPALITY, KENNEDY_CENTER, COMMUNICATIONSCENTER,
    EYE_DOCTOR, FUNDUS, HEALTH_SECTOR
}

enum ExternalPatners {
    DHL, DAO, SCALEPOINT, INSURANCE, BANK,
    RESURS_BANK, EXPRESS_BANK,
    PRODUCT
}

enum All {
    ALL
}