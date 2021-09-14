package com.mycompany.prueba.model;

import com.mycompany.prueba.DatabaseInformation;
import com.mycompany.prueba.MainDataBase;
import com.mycompany.prueba.valueobject.EspecieVO;
import com.mycompany.prueba.valueobject.JugadorVO;
import com.mycompany.prueba.valueobject.PersonajeVO;
import com.mycompany.prueba.DataBaseObjective;
import com.mycompany.prueba.TypeOfQuery;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ServerOperationPos extends UnicastRemoteObject implements RMIInterface {

    public final static String USER = "alex";
    public final static String PASSWORD = "prueba";
    public final static String BD = "xe";

    public final static String USERPOS = "usqflxaqeyzjlg";
    public final static String PASSWORDPOS = "23350f39fffcc74b5f869b2c2049a5b9424dff80e35fbddc40946985664ed014";
    public final static String BDPOS = "d7n31ha057s6gf";

    public final static DatabaseInformation dbi= new DatabaseInformation(USER, PASSWORD, BD);
    public final static DatabaseInformation post = new DatabaseInformation(USERPOS, PASSWORDPOS, BDPOS);
    public ServerOperationPos() throws RemoteException {

    }

    @Override
    public void addPlayer(JugadorVO player) throws RemoteException {
        MainDataBase.simpleAccordingToTheDatabase(DataBaseObjective.POSTGRESQL,
                post, new JugadorVO(player.getId(),
                        player.getCuenta(),
                        player.getContraseña(),
                        player.getApodo(),
                        player.getEmail(),
                        player.getEstadoRegistro(),
                        player.getFechaModificacion()), TypeOfQuery.INSERTAR);

    }

    @Override
    public void addCharater(PersonajeVO character) throws RemoteException {
        MainDataBase.simpleAccordingToTheDatabase(DataBaseObjective.POSTGRESQL,
                post, new PersonajeVO(character.getId(),
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
        MainDataBase.simpleAccordingToTheDatabase(DataBaseObjective.POSTGRESQL,
                post, new EspecieVO(sort.getId(),
                        sort.getNombre(),
                        sort.getEstadoRegistro(),
                        sort.getFechaModificacion()),
                TypeOfQuery.INSERTAR);

    }

    @Override
    public void deletePlayer(String id) throws RemoteException {
        MainDataBase.simpleAccordingToTheDatabase(DataBaseObjective.POSTGRESQL,
                post,
                new JugadorVO(id),
                TypeOfQuery.ELIMINAR);

    }

    @Override
    public void deleteCharater(String id) throws RemoteException {
        MainDataBase.simpleAccordingToTheDatabase(DataBaseObjective.POSTGRESQL,
                post,
                new PersonajeVO(id),
                TypeOfQuery.ELIMINAR);
    }

    @Override
    public void deleteSort(String id) throws RemoteException {
        MainDataBase.simpleAccordingToTheDatabase(DataBaseObjective.POSTGRESQL,
                post,
                new EspecieVO(id),
                TypeOfQuery.ELIMINAR);
    }

    @Override
    public JugadorVO getPlayer(String id) throws RemoteException {

        return MainDataBase.findJugadorById(DataBaseObjective.POSTGRESQL,post,
                new JugadorVO(id));
    }

    @Override
    public PersonajeVO getCharacter(String id) throws RemoteException {
        return MainDataBase.findPersonajeById(DataBaseObjective.POSTGRESQL,post,
                new PersonajeVO(id));
    }

    @Override
    public EspecieVO getSort(String id) throws RemoteException {
        return MainDataBase.findEspecieById(DataBaseObjective.POSTGRESQL,post,
                new EspecieVO(id));
    }

    @Override
    public void updatePlayer(JugadorVO player) throws RemoteException {
        MainDataBase.simpleAccordingToTheDatabase(DataBaseObjective.POSTGRESQL,
                post, new JugadorVO(player.getId(),
                        player.getCuenta(),
                        player.getContraseña(),
                        player.getApodo(),
                        player.getEmail(),
                        player.getEstadoRegistro(),
                        player.getFechaModificacion()), TypeOfQuery.ACTUALIZAR);
    }

    @Override
    public void updateCharacter(PersonajeVO character) throws RemoteException {
        MainDataBase.simpleAccordingToTheDatabase(DataBaseObjective.POSTGRESQL,
                post, new PersonajeVO(character.getId(),
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
        MainDataBase.simpleAccordingToTheDatabase(DataBaseObjective.POSTGRESQL,
                post, new EspecieVO(sort.getId(),
                        sort.getNombre(),
                        sort.getEstadoRegistro(),
                        sort.getFechaModificacion()),
                TypeOfQuery.ACTUALIZAR);
    }

    @Override
    public List<JugadorVO> getPlayers() throws RemoteException {
        return MainDataBase.listJugador(DataBaseObjective.POSTGRESQL,post);
    }

    @Override
    public List<PersonajeVO> getCharacters() throws RemoteException {
        return MainDataBase.listPersonaje(DataBaseObjective.POSTGRESQL,post);
    }

    @Override
    public List<EspecieVO> getSorts() throws RemoteException {
        return MainDataBase.listEspecie(DataBaseObjective.POSTGRESQL,post);
    }
    @Override
    public List<PersonajeVO> getCharactersByPlayer(PersonajeVO player) throws RemoteException {
        return MainDataBase.listPersonajesSegunJugador(DataBaseObjective.POSTGRESQL,post, player);
    }


}
