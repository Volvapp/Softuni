package entities.ex1;
import entities.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "wizard_deposits")
public class WizardDeposit extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 60, nullable = false)
    private String lastName;

    @Column(length = 1000)
    private String notes;

    @Column(nullable = false)
    private int age;

    @Column(name = "magic_wand_creator", length = 100)
    private String magicWandCreator;

    @Column(name = "magic_wand_size")
    private long magicWandSize;

    @Column(name = "deposit_group", length = 20)
    private String depositGroup;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deposit_start_date")
    private Date depositStartDate;

    @Column(name = "deposit_amount")
    private double depositAmount;

    @Column(name = "deposit_interest")
    private double depositInterest;

    @Column(name = "deposit_charge")
    private double depositCharge;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deposit_expiration_date")
    private Date depositExpirationDate;

    @Column(name = "is_deposit_expired")
    private boolean isDepositExpired;

}
