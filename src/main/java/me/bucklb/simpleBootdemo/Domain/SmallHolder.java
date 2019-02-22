package me.bucklb.simpleBootdemo.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SmallHolder {

    // Want to see how mapper works with nesting ...
    String a;
    String b;
    Smaller c;

    @Override
    public String toString() {
        return "SmallHolder{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c=" + c +
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

    public Smaller getC() {
        return c;
    }

    public void setC(Smaller s) {
        this.c = s;
    }
}
