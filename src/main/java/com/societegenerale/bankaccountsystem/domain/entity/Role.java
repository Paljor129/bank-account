package com.societegenerale.bankaccountsystem.domain.entity;

import com.societegenerale.bankaccountsystem.domain.entity.enums.RoleEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role extends AbstractBaseEntity {

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "label", length = 200, nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum label;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public Role() {
        this(RoleEnum.ROLE_USER, null);
    }

    public Role(RoleEnum role, Client client) {
        super();
        this.setLabel(role);
        this.setClient(client);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RoleEnum getLabel() {
        return label;
    }

    public void setLabel(RoleEnum label) {
        this.label = label;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
