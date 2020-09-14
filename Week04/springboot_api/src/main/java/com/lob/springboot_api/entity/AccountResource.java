package com.lob.springboot_api.entity;

import org.springframework.hateoas.RepresentationModel;

public class AccountResource extends RepresentationModel {

    private String accountId;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
