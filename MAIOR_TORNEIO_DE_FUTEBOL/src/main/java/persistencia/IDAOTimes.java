
package persistencia;

import exception.TimeNaoEncontradoException;
import java.util.List;
import model.Time;

public interface IDAOTimes {

    List<Time> listarTodos();

    Time buscarPorNome(String nome) throws TimeNaoEncontradoException;

}