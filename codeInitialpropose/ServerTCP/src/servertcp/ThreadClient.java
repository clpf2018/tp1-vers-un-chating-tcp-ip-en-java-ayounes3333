/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class ThreadClient extends Thread {

    Socket s;

    public ThreadClient(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        System.out.println(s.getRemoteSocketAddress());
        try {
            BufferedReader ir = ServerTCP.getInput(s);
            PrintWriter reply = ServerTCP.getoutput(s);
            String line;

            while ((line = ir.readLine()) != null) {
                System.out.printf("je répond ping %s\n", line);
                reply.printf("je répond ping %s\n", line);
                reply.flush();
            }
            s.close();
        } catch (IOException ex) {
            System.err.println("Connection Closed!");
        }
    }

}
