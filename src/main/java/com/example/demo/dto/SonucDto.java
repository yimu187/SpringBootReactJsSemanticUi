package com.example.demo.dto;

import java.io.Serializable;

public class SonucDto implements Serializable {

    private String recordId;
    private Long sayi;
    private String metin;
    private String tarih;

    public SonucDto() {
    }

    public SonucDto(String recordId, Long sayi, String metin, String tarih) {
        this.recordId = recordId;
        this.sayi = sayi;
        this.metin = metin;
        this.tarih = tarih;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public Long getSayi() {
        return sayi;
    }

    public void setSayi(Long sayi) {
        this.sayi = sayi;
    }

    public String getMetin() {
        return metin;
    }

    public void setMetin(String metin) {
        this.metin = metin;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
}
