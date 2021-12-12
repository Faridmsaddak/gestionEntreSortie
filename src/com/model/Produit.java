/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author lenovo
 */
public class Produit {
    private int id;
    private String nomProduit;
    private String quantiteProduit;

    public Produit(int id, String nomProduit, String quantiteProduit) {
        this.id = id;
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;
    }

    public Produit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getQuantiteProduit() {
        return quantiteProduit;
    }

    public void setQuantiteProduit(String quantiteProduit) {
        this.quantiteProduit = quantiteProduit;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", nomProduit=" + nomProduit + ", quantiteProduit=" + quantiteProduit + '}';
    }
    
    
}
