/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.prueba.AplicationServer;
import com.mycompany.prueba.model.ServerOperation;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;


/**
 *
 * @author Elverth y Rafa
 */
public class Server  {

    public Server()throws RemoteException{

    }

    public static void main(String[] args) {
        String ip = "//192.168.1.26/Server";
        try {
            ServerOperation stub = new ServerOperation();

            LocateRegistry.createRegistry(1099);
            Naming.rebind(ip,stub);
            System.out.println("hola");

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
