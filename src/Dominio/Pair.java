package Dominio;

import java.util.*;
import java.io.Serializable;

/* @author: Claudia Martinez Alquezar */

public class Pair <F, S> implements Serializable{

    private final F first;
    private final S second;


    /* Constructor con tipos F y S */
    public Pair(F first, S second) {
        super();
        this.first = first;
        this.second = second;
    }

    public String toString()    {
           return "(" + first + ", " + second + ")";
    }

    public F getFirst() {
        return first;
    }


    public S getSecond() {
        return second;
    }


    @Override
    public int hashCode() {
        int hashFirst = first != null ? first.hashCode() : 0;
        int hashSecond = second != null ? second.hashCode() : 0;

        return (hashFirst + hashSecond) * hashSecond + hashFirst;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Pair) {
            Pair otherPair = (Pair) other;
            return
            ((  this.first == otherPair.first ||
                ( this.first != null && otherPair.first != null &&
                  this.first.equals(otherPair.first))) &&
             (  this.second == otherPair.second ||
                ( this.second != null && otherPair.second != null &&
                  this.second.equals(otherPair.second))) );
        }

        return false;
    }

}
