package me.bucklb.simpleBootdemo.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LargeHolder {

    // Want to see how mapper works with nesting ...
    String A;
    String b;
    Larger c;

    @Override
    public String toString() {
        return "LargeHolder{" +
                "a='" + A + '\'' +
                ", b='" + b + '\'' +
                ", c=" + c +
                '}';
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        this.A = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public Larger getC() {
        return c;
    }

    public void setC(Larger l) {
        this.c = l;
    }
}
