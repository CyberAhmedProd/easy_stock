package com.teamyostrik.easystock.exceptions;

public enum ErrorCode {

    ARTICLE_NOT_FOUND(1000),
    ARTICLE_NOT_VALID(1001),
    CATEGORY_NOT_FOUND(2000),
    CATEGORY_NOT_VALID(1001),
    CLIENT_NOT_FOUND(3000),
    CLIENT_NOT_VALID(1001),
    COMMANDE_CLIENT_NOT_FOUND(4000),
    COMMANDE_CLIENT_NOT_VALID(1001),
    COMMANDE_FOURNISSEUR_NOT_FOUND(5000),
    COMMANDE_FOURNISSEUR_NOT_VALID(1001),
    ENTREPRISE_NOT_FOUND(6000),
    ENTREPRISE_NOT_VALID(1001),
    FOURNISSEUR_NOT_FOUND(7000),
    FOURNISSEUR_NOT_VALID(1001),
    LIGNE_COMMANDE_CLIENT_NOT_FOUND(8000),
    LIGNE_COMMANDE_CLIENT_NOT_VALID(1001),
    LIGNE_COMMANDE_FOURNISSEUR_NOT_FOUND(9000),
    LIGNE_COMMANDE_FOURNISSEUR_NOT_VALID(1001),
    MOUVEMENT_STOCK_NOT_FOUND(10000),
    MOUVEMENT_STOCK_NOT_VALID(1001),
    UTILISATEUR_NOT_FOUND(11000),
    UTILISATEUR_NOT_VALID(1001),
    VENTE_NOT_FOUND(12000),
    VENTE_NOT_VALID(1001);

    private int code;

    ErrorCode(int code)
    {
        this.code = code;
    }

    public int getCode()
    {
        return code;
    }
}
