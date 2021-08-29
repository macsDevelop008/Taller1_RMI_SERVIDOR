package com.mycompany.servidor.Model;

import com.mycompany.servidor.Structural.Player;
import com.mycompany.servidor.Structural.Sort;
import com.mycompany.servidor.Structural.Character;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIInterface extends Remote {

   void addPlayer(Player player) throws RemoteException;
   void addCharater(Character character)throws RemoteException;
   void addSort(Sort sort)throws RemoteException;

   void deletePlayer(int id)throws RemoteException;
   void deleteCharater(int id)throws RemoteException;
   void deleteSort(int id)throws RemoteException;

   Player getPlayer(int id)throws RemoteException;
   Character getCharacter(int id)throws RemoteException;
   Sort getSort(int id)throws RemoteException;

   List<Player> getPlayers()throws RemoteException;
   List<Character> getCharacters()throws RemoteException;
   List<Sort> getSorts()throws RemoteException;


}
