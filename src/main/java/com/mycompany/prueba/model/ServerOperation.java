package com.mycompany.prueba.model;


import com.mycompany.prueba.database.DataBaseObjective;
import com.mycompany.prueba.database.DatabaseInformation;
import com.mycompany.prueba.database.MainDataBase;
import com.mycompany.prueba.database.TypeOfQuery;
import com.mycompany.prueba.valueobject.EspecieVO;
import com.mycompany.prueba.valueobject.JugadorVO;
import com.mycompany.prueba.valueobject.PersonajeVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ServerOperation extends UnicastRemoteObject implements RMIInterface {


    /* public final static String TABLE_ESPECIE = "ESPECIE";
     public final static String TABLE_JUGADOR = "JUGADOR";
     public final static String TABLE_PERSONAJE = "PERSONAJE";*/
    public final static String USER = "alex";
    public final static String PASSWORD = "prueba";
    public final static String BD = "xe";
    public final static DatabaseInformation dbi= new DatabaseInformation(USER, PASSWORD, BD);
    public ServerOperation() throws RemoteException {

    }

    @Override
    public void addPlayer(JugadorVO player) throws RemoteException {
        MainDataBase.simpleAccordingToTheDatabase(DataBaseObjective.ORACLE,
                dbi, new JugadorVO(player.getId(),
                        player.getCuenta(),
                        player.getContraseña(),
                        player.getApodo(),
                        player.getEmail(),
                        player.getEstadoRegistro(),
                        player.getFechaModificacion()), TypeOfQuery.INSERTAR);

    }

    @Override
    public void addCharater(PersonajeVO character) throws RemoteException {
        MainDataBase.simpleAccordingToTheDatabase(DataBaseObjective.ORACLE,
                dbi, new PersonajeVO(character.getId(),
                        character.getNombre(),
                        character.getFuerza(),
                        character.getMana(),
                        character.getEnergia(),
                        character.getId_especie(),
                        character.getId_jugador(),
                        character.getEstadoRegistro(),
                        character.getFechaModificacion()), TypeOfQuery.INSERTAR);
    }

    @Override
    public void addSort(EspecieVO sort) throws RemoteException {
        MainDataBase.simpleAccordingToTheDatabase(DataBaseObjective.ORACLE,
                dbi, new EspecieVO(sort.getId(),
                        sort.getNombre(),
                        sort.getEstadoRegistro(),
                        sort.getFechaModificacion()),
                TypeOfQuery.INSERTAR);

    }

    @Override
    public void deletePlayer(String id) throws RemoteException {
        MainDataBase.simpleAccordingToTheDatabase(DataBaseObjective.ORACLE,
                dbi,
                new JugadorVO(id),
                TypeOfQuery.ELIMINAR);

    }

    @Override
    public void deleteCharater(String id) throws RemoteException {
        MainDataBase.simpleAccordingToTheDatabase(DataBaseObjective.ORACLE,
                dbi,
                new PersonajeVO(id),
                TypeOfQuery.ELIMINAR);
    }

    @Override
    public void deleteSort(String id) throws RemoteException {
        MainDataBase.simpleAccordingToTheDatabase(DataBaseObjective.ORACLE,
                dbi,
                new EspecieVO(id),
                TypeOfQuery.ELIMINAR);
    }

    @Override
    public JugadorVO getPlayer(String id) throws RemoteException {

        return MainDataBase.findJugadorById(dbi,
                new JugadorVO(id));
    }

    @Override
    public PersonajeVO getCharacter(String id) throws RemoteException {
        return MainDataBase.findPersonajeById(dbi,
                new PersonajeVO(id));
    }

    @Override
    public EspecieVO getSort(String id) throws RemoteException {
        return MainDataBase.findEspecieById(dbi,
                new EspecieVO(id));
    }

    @Override
    public void updatePlayer(JugadorVO player) throws RemoteException {
            MainDataBase.simpleAccordingToTheDatabase(DataBaseObjective.ORACLE,
                    dbi, new JugadorVO(player.getId(),
                        player.getCuenta(),
                        player.getContraseña(),
                        player.getApodo(),
                        player.getEmail(),
                        player.getEstadoRegistro(),
                        player.getFechaModificacion()), TypeOfQuery.ACTUALIZAR);
    }

  @Override
    public void updateCharacter(PersonajeVO character) throws RemoteException {
      MainDataBase.simpleAccordingToTheDatabase(DataBaseObjective.ORACLE,
              dbi, new PersonajeVO(character.getId(),
                      character.getNombre(),
                      character.getFuerza(),
                      character.getMana(),
                      character.getEnergia(),
                      character.getId_especie(),
                      character.getId_jugador(),
                      character.getEstadoRegistro(),
                      character.getFechaModificacion()), TypeOfQuery.ACTUALIZAR);
    }

    @Override
    public void updateSort(EspecieVO sort) throws RemoteException {
        MainDataBase.simpleAccordingToTheDatabase(DataBaseObjective.ORACLE,
                dbi, new EspecieVO(sort.getId(),
                        sort.getNombre(),
                        sort.getEstadoRegistro(),
                        sort.getFechaModificacion()),
                TypeOfQuery.ACTUALIZAR);
    }

    @Override
    public List<JugadorVO> getPlayers() throws RemoteException {
        return MainDataBase.listJugador(dbi);
    }

    @Override
    public List<PersonajeVO> getCharacters() throws RemoteException {
        return MainDataBase.listPersonaje(dbi);
    }

    @Override
    public List<EspecieVO> getSorts() throws RemoteException {
        return MainDataBase.listEspecie(dbi);
    }
    @Override
    public List<PersonajeVO> getCharactersByPlayer(PersonajeVO player) throws RemoteException {
        return MainDataBase.listPersonajesSegunJugador(dbi, player);
    }
}
