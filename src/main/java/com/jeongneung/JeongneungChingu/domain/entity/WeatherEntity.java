package com.jeongneung.JeongneungChingu.domain.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class WeatherEntity {

    @Id
    private Long id;
    private LocalDateTime dateTime;

    // WD1 : 1분 평균 풍향 (degree) : 0-N, 90-E, 180-S, 270-W, 360-무풍
    private float WD1;
    
    // WS1 : 1분 평균 풍속 (m/s)
    private float WS1;
    
    // WDS : 최대 순간 풍향 (degree)
    private float WDS;
    
    // WSS : 최대 순간 풍속 (m/s)
    private float WSS;
    
    // WD10 : 10분 평균 풍향 (degree)
    private float WD10;
    
    // WS10 : 10분 평균 풍속 (m/s)
    private float WS10;
    
    // TA : 1분 평균 기온 (C)
    private float TA;
    
    // RE : 강수감지 (0-무강수, 0이 아니면-강수)
    private int RE;
    
    // RN-15m : 15분 누적 강수량 (mm)
    private float RN15m;
    
    // RN-60m : 60분 누적 강수량 (mm)
    private float RN60m;
    
    // RN-12H : 12시간 누적 강수량 (mm)
    private float RN12H;
    
    // RN-DAY : 일 누적 강수량 (mm)
    private float RNDay;
    
    // HM : 1분 평균 상대습도 (%)
    private float HM;
    
    // PA : 1분 평균 현지기압 (hPa)
    private float PA;
    
    // PS : 1분 평균 해면기압 (hPa)
    private float PS;
    
    // TD : 이슬점온도 (C)
    private float TD;

    // 기본 생성자
    public WeatherEntity() {}

    // Getter와 Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public float getWD1() {
        return WD1;
    }

    public void setWD1(float WD1) {
        this.WD1 = WD1;
    }

    public float getWS1() {
        return WS1;
    }

    public void setWS1(float WS1) {
        this.WS1 = WS1;
    }

    public float getWDS() {
        return WDS;
    }

    public void setWDS(float WDS) {
        this.WDS = WDS;
    }

    public float getWSS() {
        return WSS;
    }

    public void setWSS(float WSS) {
        this.WSS = WSS;
    }

    public float getWD10() {
        return WD10;
    }

    public void setWD10(float WD10) {
        this.WD10 = WD10;
    }

    public float getWS10() {
        return WS10;
    }

    public void setWS10(float WS10) {
        this.WS10 = WS10;
    }

    public float getTA() {
        return TA;
    }

    public void setTA(float TA) {
        this.TA = TA;
    }

    public int getRE() {
        return RE;
    }

    public void setRE(int RE) {
        this.RE = RE;
    }

    public float getRN15m() {
        return RN15m;
    }

    public void setRN15m(float RN15m) {
        this.RN15m = RN15m;
    }

    public float getRN60m() {
        return RN60m;
    }

    public void setRN60m(float RN60m) {
        this.RN60m = RN60m;
    }

    public float getRN12H() {
        return RN12H;
    }

    public void setRN12H(float RN12H) {
        this.RN12H = RN12H;
    }

    public float getRNDay() {
        return RNDay;
    }

    public void setRNDay(float RNDay) {
        this.RNDay = RNDay;
    }

    public float getHM() {
        return HM;
    }

    public void setHM(float HM) {
        this.HM = HM;
    }

    public float getPA() {
        return PA;
    }

    public void setPA(float PA) {
        this.PA = PA;
    }

    public float getPS() {
        return PS;
    }

    public void setPS(float PS) {
        this.PS = PS;
    }

    public float getTD() {
        return TD;
    }

    public void setTD(float TD) {
        this.TD = TD;
    }
}

