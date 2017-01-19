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
import java.util.*;
public class ArbolBool {
    private Nodo root;
    public ArrayList<String> postfix;

    ArbolBool() {
        this.root = new Nodo();
        this.postfix = new ArrayList<String>();
    }

    private static int pref(String op) {
        int prf = 99;
        if (op.equals("\"")) prf = 8;
        if (op.equals("}")) prf = 7;
        if (op.equals("{")) prf = 6;
        if (op.equals("!")) prf = 5;
        if (op.equals("|")) prf = 4;
        if (op.equals("&")) prf = 3;
        if (op.equals(")")) prf = 2;
        if (op.equals("(")) prf = 1;
        return prf;
    }

    public boolean isOperator(String s) {
        return s.equals("&") || s.equals("|") || s.equals("!");
    }

    public Nodo getRaiz() { return this.root; }
    

    private static String depurar(String s) {
        s = '(' + s + ')';
        String simbols = "&|!(){}\"";
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if (simbols.contains("" + s.charAt(i))) {
                str += " " + s.charAt(i) + " ";
            }
            else str += s.charAt(i);
        }
        return str.replaceAll("\\s+", " ").trim();
    }

    private ArrayList<String> convertir(Stack<String> pilasalida) {
        ArrayList<String> result = new ArrayList<String>();
        while(!pilasalida.isEmpty()) {
            result.add(pilasalida.pop());
        }
        return result;
    }

    public void createArbol(String expressio) {
        String expr = depurar(expressio);
        String[] arrayInfix = expr.split(" ");
        Stack < String > E = new Stack < String > (); //Pila entrada
        Stack < String > P = new Stack < String > (); //Pila temporal para operadores
        Stack < String > S = new Stack < String > (); //Pila salida

        for (int i = 0 ; i < arrayInfix.length; ++i) {
            E.push(arrayInfix[i]);
            while (!E.isEmpty()) {
                switch (pref(E.peek())){
                    case 1:
                        P.push(E.pop());
                        break;
                    case 2:
                        while(!P.isEmpty() && !P.peek().equals("(")) {
                            S.push(P.pop());
                        }
                        if(!P.isEmpty()) P.pop();
                        E.pop();
                        break;
                    case 3:
                        while(!P.isEmpty() && (pref(P.peek()) >= pref(E.peek()))) {
                            S.push(P.pop());
                        }
                        P.push(E.pop());
                        break;
                    case 4:
                        while(!P.isEmpty() && (pref(P.peek()) >= pref(E.peek()))) {
                            S.push(P.pop());
                        }
                        P.push(E.pop());
                        break;
                    case 5:
                        while(!P.isEmpty() && (pref(P.peek()) >= pref(E.peek()))) {
                            S.push(P.pop());
                        }
                        P.push(E.pop());
                        break;
                    default:
                        if(!E.isEmpty()) S.push(E.pop());
                }
            }

        }

        ArrayList<String> postfix = convertir(S);
        this.postfix = postfix;
        
        final Stack<Nodo> nodes = new Stack<Nodo>();
        for (int i = postfix.size() -1 ; i >= 0; --i) {
            String ch  = postfix.get(i);
            if (isOperator(ch)) {
                Nodo leftNode = null;
                Nodo rightNode = null;
                if(!nodes.isEmpty()) {
                    rightNode = nodes.pop();
                }
                if(!nodes.isEmpty()) {
                    leftNode = nodes.pop();
                }
                nodes.push(new Nodo(leftNode, ch, rightNode));
            }
            
            else if(ch.equals("{")) {
                String conjunto = "{ ";
                --i;
                while(i >= 0 && !postfix.get(i).equals("}")) {
                    conjunto += postfix.get(i) + " ";
                    --i;
                }
                conjunto += "}";
                nodes.add(new Nodo(null,conjunto,null));
                
            }
            
            else if(ch.equals("\"")) {
                String secuencia= "\" ";
                --i;
                while(i >=0 && !postfix.get(i).equals("\"")) {
                    secuencia += postfix.get(i) + " ";
                    --i;
                }
                secuencia += "\"";
                nodes.add(new Nodo(null,secuencia,null));
            }
            
            else {
                nodes.add(new Nodo(null, ch, null));
            }
        }
        this.root = nodes.pop();

    }

    public ArrayList<String> getPostfix() { return this.postfix; }




}
