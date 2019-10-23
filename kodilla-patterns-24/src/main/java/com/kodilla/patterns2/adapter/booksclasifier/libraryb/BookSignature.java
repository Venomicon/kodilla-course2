package com.kodilla.patterns2.adapter.booksclasifier.libraryb;

public class BookSignature {
    private final String signature;

    public BookSignature(String signature) {
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }

    @Override
    public String toString() {
        return "Signature " + signature;
    }
}
