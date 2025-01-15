/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import niti.ObradaKlijentskihZahteva;

/**
 *
 * @author Matija
 */
public class Server extends Thread {
    private boolean signal=true;
    private ServerSocket serverSoket;
    private List<ObradaKlijentskihZahteva> klijenti;
    public Server(){
        klijenti = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            serverSoket = new ServerSocket(9000);
            System.out.println("Serverski soket je otvoren!");
            while(signal){
                Socket s = serverSoket.accept();
                System.out.println("Klijent se povezao!");
                
                ObradaKlijentskihZahteva okz = new ObradaKlijentskihZahteva(s);
                okz.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void zaustaviServer(){
        signal=false;
        try {
            for (ObradaKlijentskihZahteva k : klijenti) {
                k.prekini();
            }
            serverSoket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
