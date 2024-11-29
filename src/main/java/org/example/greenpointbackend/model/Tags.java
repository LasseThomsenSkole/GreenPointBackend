package org.example.greenpointbackend.model;

import jakarta.persistence.*;
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
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Titles titles;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Vision vision;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Brands brands;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Info info;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Health health;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ExternalPatners externPartners;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
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