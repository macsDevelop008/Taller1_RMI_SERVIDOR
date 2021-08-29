package com.mycompany.servidor.Model;

import com.mycompany.servidor.Structural.Character;
import com.mycompany.servidor.Structural.Player;
import com.mycompany.servidor.Structural.Sort;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ServerOperation extends UnicastRemoteObject implements RMIInterface {


    public final static String TABLE_ESPECIE = "ESPECIE";
    public final static String TABLE_JUGADOR = "JUGADOR";
    public final static String TABLE_PERSONAJE = "PERSONAJE";
     public ServerOperation() throws RemoteException {

    }

    @Override
    public void addPlayer(Player player) throws RemoteException {

    }

    @Override
    public void addCharater(Character character) throws RemoteException {

    }

    @Override
    public void addSort(Sort sort) throws RemoteException {

    }

    @Override
    public void deletePlayer(int id) throws RemoteException {

    }

    @Override
    public void deleteCharater(int id) throws RemoteException {

    }

    @Override
    public void deleteSort(int id) throws RemoteException {

    }

    @Override
    public Player getPlayer(int id) throws RemoteException {
        return null;
    }

    @Override
    public Character getCharacter(int id) throws RemoteException {
        return null;
    }

    @Override
    public Sort getSort(int id) throws RemoteException {
        return null;
    }

    @Override
    public List<Player> getPlayers() throws RemoteException {
        return null;
    }

    @Override
    public List<Character> getCharacters() throws RemoteException {
        return null;
    }

    @Override
    public List<Sort> getSorts() throws RemoteException {
        return null;
    }
}
