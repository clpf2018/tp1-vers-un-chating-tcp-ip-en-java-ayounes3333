/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clienttcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class ThreadEmeteur extends Thread {

    Socket s;

    public ThreadEmeteur(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        System.out.println(s.getRemoteSocketAddress());
        try {
            Scanner scanner = new Scanner(System.in);
            PrintWriter reply = ClientTCP.getoutput(s);
            String line= "";

            while (!line.equalsIgnoreCase("_end")) {
                System.out.print("Message: ");
                line = scanner.nextLine();
                reply.printf(line);
            }
            s.close();
        } catch (IOException ex) {
            System.err.println("Connection Closed!");
        }
    }
    
}
