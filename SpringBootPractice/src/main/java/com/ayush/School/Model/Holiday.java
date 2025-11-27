package com.ayush.School.Model;


import jakarta.persistence.*;

@Entity
@Table(name="Holidays")
public class Holiday extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String day;
    private  String reason;

    @Enumerated(EnumType.STRING)
    private  Type type;

    public Holiday(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Holiday(String day, String reason, Type type) {
        this.day = day;
        this.reason = reason;
        this.type = type;
    }

    public enum Type{
        FESTIVAL, FEDERAL
    }
    public String getDay() {
        return day;
    }

    public String getReason() {
        return reason;
    }

    public Type getType() {
        return type;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "day='" + day + '\'' +
                ", reason='" + reason + '\'' +
                ", type=" + type +
                '}';
    }
}

