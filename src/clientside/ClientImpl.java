/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientside;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;
import serverside.Partida;

/**
 *
 * @author FELLIPE ADORNO
 */
public class ClientImpl extends UnicastRemoteObject implements Client {

    public ClientImpl() throws RemoteException {
    }
    
    

    @Override
    public boolean invicte(String nomeJogador, Partida partida) throws RemoteException {
        int result = JOptionPane.showConfirmDialog(null, "Você deseja começar uma nova partida com "+nomeJogador+"?");
        return (result == 0);
    }

    @Override
    public void sendMessage(String msg) throws RemoteException {
        System.out.println(msg);
    }
    
}
