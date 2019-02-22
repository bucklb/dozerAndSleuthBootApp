package me.bucklb.simpleBootdemo.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Smaller {

    String a;
    String b;

    @Override
    public String toString() {
        return "Smaller{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }

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
}
