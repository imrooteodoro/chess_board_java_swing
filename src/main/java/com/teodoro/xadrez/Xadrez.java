/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.teodoro.xadrez;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author teodoro
 */
public class Xadrez {
    public static  LinkedList<Peca> ps = new LinkedList<>( );
    public static Peca selectedPeca =null;
    public static void main(String[] args) throws IOException {
      
        BufferedImage all = ImageIO.read(new File("/home/teodoro/Downloads/chess.png"));
        Image imgs[] = new Image [12];
        int ind = 0; 
        for(int y =0;y<400;y+=200){
             for(int x =0;x<1200;x+=200){
                 imgs[ind] = all.getSubimage(x, y, 200, 200).getScaledInstance(64,64, BufferedImage.SCALE_SMOOTH);
                 ind++;
             }
            
             }
        //Peoes brancos
        Peca wpawn = new Peca(7, 6, true, false, "pawn", ps);
        Peca wpawn1 = new Peca(6, 6, true, false, "pawn", ps);
        Peca wpawn2 = new Peca(5, 6, true, false, "pawn", ps);
        Peca wpawn3 = new Peca(4, 6, true, false, "pawn", ps);
        Peca wpawn4 = new Peca(3, 6, true, false, "pawn", ps);
        Peca wpawn5 = new Peca(2, 6, true, false, "pawn", ps);
        Peca wpawn6 = new Peca(1, 6, true, false, "pawn", ps);
        Peca wpawn7 = new Peca(0, 6, true, false, "pawn", ps);
        //Pecas brancas mais fortes
        Peca wrook = new Peca(7, 7, true, false, "rook", ps);
        Peca wrook2 = new Peca(0, 7, true, false, "rook", ps);
        Peca wknight = new Peca(6, 7, true, false, "knight", ps);
        Peca wknight2 = new Peca(1, 7, true, false, "knight", ps);
        Peca wbishop = new Peca(5, 7, true, false, "bishop", ps);
        Peca wbishop2 = new Peca(2, 7, true, false, "bishop", ps);
        Peca wking = new Peca(4, 7, true, false, "king", ps);
        Peca wqueen = new Peca(3, 7, true, false, "queen", ps);
        
        
        
        
        //Peças pretas
        Peca bpawn = new Peca(0, 1, false, true, "pawn", ps);
        Peca bpawn1 = new Peca(1, 1, false, true, "pawn", ps);
        Peca bpawn2 = new Peca(2, 1, false, true, "pawn", ps);
        Peca bpawn3 = new Peca(3, 1, false, true, "pawn", ps);
        Peca bpawn4 = new Peca(4, 1, false, true, "pawn", ps);
        Peca bpawn5 = new Peca(5, 1, false, true, "pawn", ps);
        Peca bpawn6 = new Peca(6, 1, false, true, "pawn", ps);
        Peca bpawn7 = new Peca(7, 1, false, true, "pawn", ps);
        //Pecas brancas mais fortes
        Peca brook = new Peca(0, 0, false, true, "rook", ps);
        Peca brook2 = new Peca(7, 0,false, true, "rook", ps);
        Peca bknight = new Peca(1, 0, false, true, "knight", ps);
        Peca bknight2 = new Peca(6, 0, false, true, "knight", ps);
        Peca bbishop = new Peca(2, 0, false, true, "bishop", ps);
        Peca bbishop2 = new Peca(5, 0, false, true, "bishop", ps);
        Peca bking = new Peca(4, 0, false, true, "king", ps);
        Peca bqueen = new Peca(3, 0, false, true , "queen", ps);
        
       
       
        JFrame frame = new JFrame();
        frame.setBounds(10, 10, 512,512);
        frame.setUndecorated(true);
        JPanel pn= new JPanel(){
            @Override
            public void paint(Graphics g){
                boolean white = true;
                for(int y= 0;y<8;y++){
                    for(int x= 0;x<8;x++){
                        if(white){
                            g.setColor(Color.white);
                            
                        }else{
                            g.setColor(Color.gray);
                        }
                        g.fillRect(x*64, y*64, 64, 64);
                         white=!white;
                    }
                    white=!white;
                   
                }
                for(Peca p: ps){
                    int ind = 0;
                    if(p.name.equalsIgnoreCase("king")){
                    ind =0;
                }
                    if(p.name.equalsIgnoreCase("queen")){
                    ind =1;
                }
                    if(p.name.equalsIgnoreCase("bishop")){
                    ind =2;
                }
                    if(p.name.equalsIgnoreCase("knight")){
                    ind =3;
                }
                    if(p.name.equalsIgnoreCase("rook")){
                    ind =4;
                }
                    if(p.name.equalsIgnoreCase("pawn")){
                    ind =5;
                }
                    if(!p.isWhite){
                        ind+=6;
                    }
                    g.drawImage(imgs[ind], p.x, p.y, this);
                }
            }
        
    };
        frame.add(pn);
        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(selectedPeca!=null){
                    selectedPeca.x =e.getX() -32;
                    selectedPeca.y = e.getY() -32;
                    frame.repaint();
                }
                
            }

            @Override
            public void mouseMoved(MouseEvent e) {
          
            }
        });
        frame.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
             
                //System.out.println(getPeca(e.getX(), e.getY()).isWhite?"white ":"black " + getPeca(e.getX(),e.getY()).name);
                selectedPeca = getPeca(e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                selectedPeca.move(e.getX()/64, e.getY()/64);
                frame.repaint();
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            private Object getPìece(int x, int y) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
            
        });
        
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
       
    }
    public static Peca getPeca(int x, int y){
        int xp = x/64;
        int yp = y/64;
        
        for(Peca p:ps){
            if(p.xp==xp&&p.yp==yp){
                return p;
            }
            
        }
        return null;
        
    }
}
