package clientside;


import java.rmi.Remote;
import java.rmi.RemoteException;
import serverside.Partida;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FELLIPE ADORNO
 */
public interface Client extends Remote {
    public boolean invicte(String nomeJogador, Partida partida) throws RemoteException;
    public void sendMessage(String msg) throws RemoteException;
}
