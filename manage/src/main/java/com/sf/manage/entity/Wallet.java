package com.sf.manage.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "m_wallet")
public class Wallet {
    /**
     * 钱包id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * 会员id
     */
    private long memberId;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "walletId")
    private List<Cash> cashs;
}
