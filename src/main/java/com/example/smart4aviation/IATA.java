package com.example.smart4aviation;

/**
 * enum representing International Air Transport Association code
 * @param code code of airport
 */
public enum IATA
{
    SEA("SEA"), YYZ("YYZ"), YYT("YYT"), ANC("ANC"),
    LAX("LAX"), MIT("MIT"), LEW("LEW"), GDN("GDN"),
    KRK("KRK"), PPX("PPX");
    private String code;

    private IATA(String c) {
        code = c;
    }
    public boolean equalsIATA(String otherCode) {
        return code.equals(otherCode);
    }

    public String toString() {
        return this.code;
    }



}
