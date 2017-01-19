package Dominio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paola
 */
public class Nodo {
    private Nodo left; //pointer to the left child
    private String data; //Objeto hoja (conjunto, secuencia o palabra)
    private Nodo right; //pointer to the right child

    Nodo() {}

    Nodo(Nodo left, String data, Nodo right) {
        this.left = left;
        this.data = data;
        this.right = right;
    }

    public Nodo getLeft() {
        return this.left;
    }

    public Nodo getRight() {
        return this.right;
    }

    public String getData() {
        return this.data;
    }
}
