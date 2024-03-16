/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.teodoro.xadrez;

import java.util.LinkedList;

/**
 *
 * @author teodoro
 */
public class Peca {
    int xp;
    int yp;
    boolean isWhite;
    boolean isBlack;
    String name;
    LinkedList<Peca> ps;
    int x;
    int y;
    private boolean primeiraJogada;
    
    
    
    public Peca(int xp, int yp, boolean isWhite, boolean isBlack,String n, LinkedList<Peca> ps){
        this.primeiraJogada = true;
      
        this.xp = xp;
        this.yp = yp;
        this.isWhite = isWhite;
        this.isBlack = isBlack;
        this.name = n;
        this.ps = ps;
        ps.add(this);
        x =xp*64;
        y=yp*64;
    }
    public void move(int xp, int yp){
        if(Xadrez.getPeca(xp*64, yp*64)!=null){
            if(Xadrez.getPeca(xp*64, yp*64).isWhite!=isWhite){
             Xadrez.getPeca(xp*64, yp*64).kill();    
            }else{
                 x =this.xp*64;
                 y=this.yp*64;
                return;
            }
           
        }
        
        this.xp = xp;
        this.yp = yp;
        x =xp*64;
        y=yp*64;
    }
    public void kill(){
        ps.remove(this);
    }
    
}
