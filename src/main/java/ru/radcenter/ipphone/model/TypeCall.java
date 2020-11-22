package ru.radcenter.ipphone.model;

import java.util.EnumSet;

public enum TypeCall {
    in("Входящий"),
    out("Исходящий"),
    missed("Пропущенный");

    public final String label;

    private TypeCall(String label) {
        this.label = label;
    }


}
