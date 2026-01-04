package com.logimetrics.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusMaquina {
    ATIVA,
    INATIVA,
    MANUTENCAO;

    @JsonValue
    public String toValue() {
        return name().toLowerCase(); 
    }

    @JsonCreator
    public static StatusMaquina fromValue(String value) {
        if (value == null) return null;
        return StatusMaquina.valueOf(value.toUpperCase()); 
    }
}