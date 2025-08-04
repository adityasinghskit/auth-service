package com.aditya.authservice.common.error;

public enum ErrorType {
    DETAILS_NOT_PRESENT(1, "Details to update is not present in body"),
    REQUEST_NOT_ALLOWED(2, "Not allowed:  Invalid Request"),
    NOT_FOUND(3, "Entity not found"),
    EMPTY_LIST(4, "No entries found for this entity"),
    KYC_APPROVED(5, "Can't update details after remittance kyc is approved"),
    STATUS_TRANSITION_NOT_ALLOWED(6, "this status transition is not allowed");

    private final int id;
    private final String message;

    ErrorType(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}