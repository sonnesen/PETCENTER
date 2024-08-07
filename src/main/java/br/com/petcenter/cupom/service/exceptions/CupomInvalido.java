package br.com.petcenter.cupom.service.exceptions;

import java.security.InvalidParameterException;

public class CupomInvalido extends InvalidParameterException {
    public CupomInvalido(String message) {
        super(message);
    }
}
