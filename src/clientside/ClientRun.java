/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientside;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import serverside.Partida;
import serverside.Server;

/**
 *
 * @author FELLIPE ADORNO
 */
public class ClientRun {
    public static void main(String a[]) {
        Server h = null;
        Client client;
        Partida partida;
        try {
            System.setSecurityManager(new RMISecurityManager());
            if(LocateRegistry.getRegistry(Registry.REGISTRY_PORT) == null)
                LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            h = (Server) Naming.lookup("rmi://192.168.0.9:"+Registry.REGISTRY_PORT+"/server");
            client = new ClientImpl();
            h.registerClient("fellipe", client);
            partida = h.novaPartida("fellipe", "ketlin");
            if(partida == null)
                System.out.println("Impossível inicializar uma nova partida!");
            else {
                partida.atingir("fellipe", 1, 1);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ClientRun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientRun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientRun.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
