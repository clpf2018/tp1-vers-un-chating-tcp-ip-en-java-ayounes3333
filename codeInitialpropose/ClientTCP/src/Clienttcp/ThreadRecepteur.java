/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clienttcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Lenovo
 */
public class ThreadRecepteur extends Thread {

    Socket s;

    public ThreadRecepteur(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        System.out.println(s.getRemoteSocketAddress());
        try {
            BufferedReader ir = ClientTCP.getInput(s);
            String line;

            while ((line = ir.readLine()) != null) {
                System.out.print("\r          ");
                System.out.println(line);
            }
            s.close();
        } catch (IOException ex) {
            System.err.println("Connection Closed!");
        }
    }
    
}
