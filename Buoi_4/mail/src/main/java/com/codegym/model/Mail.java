package com.codegym.model;

public class Mail {
    private int id;
    private String languages;
    private int size;
    private boolean spam;
    private String signature;

    public Mail() {
    }

    public Mail(int id, String languages, int size, boolean spam, String signature) {
        this.id = id;
        this.languages = languages;
        this.size = size;
        this.spam = spam;
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isSpam() {
        return spam;
    }

    public void setSpam(boolean spam) {
        this.spam = spam;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
