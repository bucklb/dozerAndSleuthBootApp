package me.bucklb.simpleBootdemo.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Larger {

    @Override
    public String toString() {
        return "Larger{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }

    String a;
    String b;
    String c;
    String d;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
        this.d = c+c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }






}
