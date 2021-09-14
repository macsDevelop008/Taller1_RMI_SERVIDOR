package com.mycompany.prueba.model;

import com.mycompany.prueba.valueobject.EspecieVO;
import com.mycompany.prueba.valueobject.JugadorVO;
import com.mycompany.prueba.valueobject.PersonajeVO;

import javax.swing.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
@SuppressWarnings("unchecked")
public class ServicioFuture extends UnicastRemoteObject implements RMIInterface {

    ServerOperation Oracle = new ServerOperation();
    ServerOperationPos Postgres = new ServerOperationPos();

    @Override
    public void addPlayer(JugadorVO player) throws RemoteException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Oracle.addPlayer(player);
                JOptionPane.showMessageDialog(null,"Player added");
            } catch (Exception e) {

            }

        });
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                Postgres.addPlayer(player);
                JOptionPane.showMessageDialog(null,"Player added");
            } catch (Exception e) {

            }

        });

    }

    @Override
    public void addCharater(PersonajeVO character) throws RemoteException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Oracle.addCharater(character);
                JOptionPane.showMessageDialog(null,"Player added");
            } catch (Exception e) {

            }

        });
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                Postgres.addCharater(character);
                JOptionPane.showMessageDialog(null,"Player added");
            } catch (Exception e) {

            }

        });
    }

    @Override
    public void addSort(EspecieVO sort) throws RemoteException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Oracle.addSort(sort);
                JOptionPane.showMessageDialog(null,"Player added");
            } catch (Exception e) {

            }

        });
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                Postgres.addSort(sort);
                JOptionPane.showMessageDialog(null,"Player added");
            } catch (Exception e) {

            }

        });

    }


    @Override
    public void deletePlayer(String id) throws RemoteException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Oracle.deletePlayer(id);
                JOptionPane.showMessageDialog(null,"Player deleted");
            } catch (Exception e) {

            }

        });
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                Postgres.deletePlayer(id);
                JOptionPane.showMessageDialog(null,"Player deleted");
            } catch (Exception e) {

            }

        });
    }

    @Override
    public void deleteCharater(String id) throws RemoteException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Oracle.deleteCharater(id);
                JOptionPane.showMessageDialog(null,"Player deleted");
            } catch (Exception e) {

            }

        });
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                Postgres.deleteCharater(id);
                JOptionPane.showMessageDialog(null,"Player deleted");
            } catch (Exception e) {

            }

        });
    }


    @Override
    public void deleteSort(String id) throws RemoteException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Oracle.deleteSort(id);
                JOptionPane.showMessageDialog(null,"Sort deleted");
            } catch (Exception e) {

            }

        });
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                Postgres.deleteSort(id);
                JOptionPane.showMessageDialog(null,"Sort deleted");
            } catch (Exception e) {

            }

        });

    }

    @Override
    public JugadorVO getPlayer(String id) throws RemoteException {
        JugadorVO player = null;
        try {
            CompletableFuture<JugadorVO> future1 = CompletableFuture.supplyAsync(()-> {
                try {
                    return Oracle.getPlayer(id);
                }catch (Exception e)
                {
                    return null;
                }
            });
            CompletableFuture<JugadorVO> future2 = CompletableFuture.supplyAsync(()-> {
                try {
                    return Postgres.getPlayer(id);
                }catch (Exception e)
                {
                    e.printStackTrace();
                    return null;
                }
            });
            CompletableFuture<Object> any = CompletableFuture.anyOf(future1,future2);
            player = (JugadorVO) any.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return player;
    }

    @Override
    public PersonajeVO getCharacter(String id) throws RemoteException {
        PersonajeVO Character = null;
        try {
            CompletableFuture<PersonajeVO> future1 = CompletableFuture.supplyAsync(()-> {
                try {
                    return Oracle.getCharacter(id);
                }catch (Exception e)
                {
                    return null;
                }
            });
            CompletableFuture<PersonajeVO> future2 = CompletableFuture.supplyAsync(()-> {
                try {
                    return Postgres.getCharacter(id);
                }catch (Exception e)
                {
                    e.printStackTrace();
                    return null;
                }
            });
            CompletableFuture<Object> any = CompletableFuture.anyOf(future1,future2);
            Character = (PersonajeVO) any.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Character;
    }

    @Override
    public EspecieVO getSort(String id) throws RemoteException {

        EspecieVO sort = null;
        try {
            CompletableFuture<EspecieVO> future1 = CompletableFuture.supplyAsync(()-> {
                try {
                    return Oracle.getSort(id);
                }catch (Exception e)
                {
                    return null;
                }
            });
            CompletableFuture<EspecieVO> future2 = CompletableFuture.supplyAsync(()-> {
                try {
                    return Postgres.getSort(id);
                }catch (Exception e)
                {
                    e.printStackTrace();
                    return null;
                }
            });
            CompletableFuture<Object> any = CompletableFuture.anyOf(future1,future2);
            sort = (EspecieVO) any.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sort;
    }

    @Override
    public void updatePlayer(JugadorVO player) throws RemoteException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Oracle.updatePlayer(player);
                JOptionPane.showMessageDialog(null,"Player Update");
            } catch (Exception e) {

            }

        });
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                Postgres.updatePlayer(player);
                JOptionPane.showMessageDialog(null,"Player Update");
            } catch (Exception e) {

            }

        });
    }



    @Override
    public void updateCharacter(PersonajeVO character) throws RemoteException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Oracle.updateCharacter(character);
                JOptionPane.showMessageDialog(null,"character update");
            } catch (Exception e) {

            }

        });
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                Postgres.updateCharacter(character);
                JOptionPane.showMessageDialog(null,"character update");
            } catch (Exception e) {

            }

        });

    }

    @Override
    public void updateSort(EspecieVO sort) throws RemoteException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Oracle.updateSort(sort);
                JOptionPane.showMessageDialog(null,"sort update");
            } catch (Exception e) {

            }

        });
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                Postgres.updateSort(sort);
                JOptionPane.showMessageDialog(null,"sort update");
            } catch (Exception e) {

            }

        });
    }

    @Override
    public List<JugadorVO> getPlayers() throws RemoteException {
        List<JugadorVO> ListPlayer = null;
        try {
            CompletableFuture<List<JugadorVO>> future1 = CompletableFuture.supplyAsync(()-> {
                try {
                    return Oracle.getPlayers();
                }catch (Exception e)
                {
                    return null;
                }
            });
            CompletableFuture<List<JugadorVO> > future2 = CompletableFuture.supplyAsync(()-> {
                try {
                    return Postgres.getPlayers();
                }catch (Exception e)
                {
                    e.printStackTrace();
                    return null;
                }
            });
            CompletableFuture<Object> any = CompletableFuture.anyOf(future1,future2);
            return  ListPlayer = (List<JugadorVO>) any.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ListPlayer;
    }

    @Override
    public List<PersonajeVO> getCharacters() throws RemoteException {
        List<PersonajeVO> ListCharac = null;
        try {
            CompletableFuture<List<PersonajeVO>> future1 = CompletableFuture.supplyAsync(()-> {
                try {
                    return Oracle.getCharacters();
                }catch (Exception e)
                {
                    return null;
                }
            });
            CompletableFuture<List<PersonajeVO>> future2 = CompletableFuture.supplyAsync(()-> {
                try {
                    return Postgres.getCharacters();
                }catch (Exception e)
                {
                    e.printStackTrace();
                    return null;
                }
            });
            CompletableFuture<Object> any = CompletableFuture.anyOf(future1,future2);
            return  ListCharac = (List<PersonajeVO> ) any.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ListCharac;
    }

    @Override
    public List<EspecieVO> getSorts() throws RemoteException {
        List<EspecieVO> ListSort = null;
        try {
            CompletableFuture<List<EspecieVO>> future1 = CompletableFuture.supplyAsync(()-> {
                try {
                    return Oracle.getSorts();
                }catch (Exception e)
                {
                    return null;
                }
            });
            CompletableFuture<List<EspecieVO> > future2 = CompletableFuture.supplyAsync(()-> {
                try {
                    return Postgres.getSorts();
                }catch (Exception e)
                {
                    e.printStackTrace();
                    return null;
                }
            });
            CompletableFuture<Object> any = CompletableFuture.anyOf(future1,future2);
            return  ListSort = (List<EspecieVO>) any.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ListSort;
    }

    @Override
    public List<PersonajeVO> getCharactersByPlayer(PersonajeVO player) throws RemoteException {
        List<PersonajeVO> ListCharByPlayer = null;
        try {
            CompletableFuture<List<PersonajeVO>> future1 = CompletableFuture.supplyAsync(()-> {
                try {
                    return Oracle.getCharactersByPlayer(player);
                }catch (Exception e)
                {
                    return null;
                }
            });
            CompletableFuture<List<PersonajeVO> > future2 = CompletableFuture.supplyAsync(()-> {
                try {
                    return Postgres.getCharactersByPlayer(player);
                }catch (Exception e)
                {
                    e.printStackTrace();
                    return null;
                }
            });
            CompletableFuture<Object> any = CompletableFuture.anyOf(future1,future2);
            return  ListCharByPlayer = (List<PersonajeVO>) any.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ListCharByPlayer;
    }

    public ServicioFuture() throws RemoteException {
    }
}
