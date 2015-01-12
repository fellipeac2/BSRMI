/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverside;

import clientside.Client;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author FELLIPE ADORNO
 */
public interface Server extends Remote {
    public boolean registerClient(String id, Client client) throws RemoteException;
    public boolean unRegisterClient(String id) throws RemoteException;
    public Partida novaPartida(String idFrom, String idTo) throws RemoteException;
}
