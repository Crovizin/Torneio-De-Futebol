package persistencia;

import exception.TimeNaoEncontradoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Time;

public class ImplTime implements IDAOTimes {

    @Override
    public List<Time> listarTodos() {

        List<Time> lista = new ArrayList<>();

        String sql = "SELECT * FROM time ORDER BY ranking";

        try (
            Connection conexao = Banco.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {

                Time time = new Time(
                        rs.getString("nome"),
                        rs.getString("pais"),
                        rs.getInt("ranking"),
                        rs.getString("curiosidade"),
                        rs.getString("resumo"),
                        rs.getDouble("chance_titulo"));

                lista.add(time);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

@Override
public Time buscarPorNome(String nome) throws TimeNaoEncontradoException {

    String sql = "SELECT * FROM time WHERE nome = ?";

    try (
        Connection conexao = Banco.conectar();
        PreparedStatement stmt = conexao.prepareStatement(sql)
    ) {

        stmt.setString(1, nome);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            return new Time(
                    rs.getString("nome"),
                    rs.getString("pais"),
                    rs.getInt("ranking"),
                    rs.getString("curiosidade"),
                    rs.getString("resumo"),
                    rs.getDouble("chance_titulo")
            );
        }

        // Se não encontrou o time
        throw new TimeNaoEncontradoException("O time \"" + nome + "\" não foi encontrado.");

    } catch (TimeNaoEncontradoException e) {
        throw e;

    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
}
}