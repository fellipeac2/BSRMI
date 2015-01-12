/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverside;

import clientside.Client;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author FELLIPE ADORNO
 */
public class ServerImpl extends UnicastRemoteObject implements Server {
    
    private final Map<String, Client> clients = new HashMap<>();
    private final Set<PartidaImpl> partidas = new HashSet<>();

    public ServerImpl() throws RemoteException {
        super();
    }
    
    @Override
    public boolean registerClient(String id, Client client) throws RemoteException {
        if(client == null || id == null)
            return false;
        if(clients.containsKey(id))
            return false;
        clients.put(id, client);
        return true;
    }

    @Override
    public boolean unRegisterClient(String id) throws RemoteException {
        
        if(id == null)
            return false;
        if(clients.containsKey(id))
            return false;
        clients.remove(id);
        return true;
    }

    @Override
    public Partida novaPartida(String idFrom, String idTo) throws RemoteException {
        if(!(clients.containsKey(idFrom) && clients.containsKey(idTo))) //falta verificar se uma exceção seria melhor
            return null;
        Client from = clients.get(idFrom);
        Client to = clients.get(idTo);
        PartidaImpl nova = new PartidaImpl(from, idFrom, to, idTo);
        if(partidas.contains(nova))
            return null;
        if(!to.invicte(idFrom,nova))
            return null;
        partidas.add(nova);
        return nova;
    }
    
}
