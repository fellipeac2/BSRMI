/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverside;

import clientside.Client;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;

/**
 *
 * @author FELLIPE ADORNO
 */
public class PartidaImpl extends UnicastRemoteObject implements Partida {
    
    private Client jogador1;
    private String idJogador1;
    private Client jogador2;
    private String idJogador2;
    //private String idJogadorAtual;

    public PartidaImpl() throws RemoteException {
        super();
    }

    public PartidaImpl(Client jogador1, String idJogador1, Client jogador2, String idJogador2) throws RemoteException {
        this();
        this.jogador1 = jogador1;
        this.idJogador1 = idJogador1;
        this.jogador2 = jogador2;
        this.idJogador2 = idJogador2;
    }

   
    
    @Override
    public boolean atingir(String idFrom, int row, int col) throws RemoteException {
        Client to;
        if(idFrom.equals(getIdJogador1()))
            to = jogador2;
        else 
            to = jogador1;
        to.sendMessage("O jogador "+idFrom+" atingiu a posição "+ row + ", "+col+"!");
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof PartidaImpl))
            return false;
        PartidaImpl other = (PartidaImpl) obj;
        return (this.getIdJogador1() == other.getIdJogador1() && this.getIdJogador2() == other.getIdJogador2())||(this.getIdJogador1() == other.getIdJogador2() && this.getIdJogador2() == other.getIdJogador1());
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public String getIdJogador1() {
        return idJogador1;
    }

    public String getIdJogador2() {
        return idJogador2;
    }

    
}
