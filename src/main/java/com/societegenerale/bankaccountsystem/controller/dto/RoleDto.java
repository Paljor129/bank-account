package com.societegenerale.bankaccountsystem.controller.dto;

import com.societegenerale.bankaccountsystem.domain.entity.Client;
import com.societegenerale.bankaccountsystem.domain.entity.enums.RoleEnum;

public class RoleDto {
    private String description;

    private RoleEnum label;

    private Client client;

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
