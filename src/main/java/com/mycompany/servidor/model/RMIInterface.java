package com.mycompany.servidor.model;

import com.mycompany.servidor.Structural.Player;
import com.mycompany.servidor.Structural.Sort;
import com.mycompany.servidor.Structural.Character;
import com.mycompany.servidor.database.valueobject.EspecieVO;
import com.mycompany.servidor.database.valueobject.JugadorVO;
import com.mycompany.servidor.database.valueobject.PersonajeVO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIInterface extends Remote {

   void addPlayer(JugadorVO player) throws RemoteException;
   void addCharater(PersonajeVO character)throws RemoteException;
   void addSort(EspecieVO sort)throws RemoteException;

   void deletePlayer(String id)throws RemoteException;
   void deleteCharater(String id)throws RemoteException;
   void deleteSort(String id)throws RemoteException;

   JugadorVO getPlayer(String id)throws RemoteException;
   PersonajeVO getCharacter(String id)throws RemoteException;
   EspecieVO getSort(String id)throws RemoteException;

   void updatePlayer(JugadorVO player)throws RemoteException;
   void updateCharacter(PersonajeVO character)throws RemoteException;
   void updateSort(EspecieVO sort)throws RemoteException;

   List<JugadorVO> getPlayers()throws RemoteException;
   List<PersonajeVO> getCharacters()throws RemoteException;
   List<EspecieVO> getSorts()throws RemoteException;


}
