/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverside;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author FELLIPE ADORNO
 */
public interface Partida extends Remote {
    public boolean atingir(String idFrom, int row, int col) throws RemoteException;
}
