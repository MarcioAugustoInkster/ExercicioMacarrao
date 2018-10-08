package entra21.java.dao;

import entra21.java.bean.MacarraoBean;
import entra21.java.classe.Macarrao;
import entra21.java.coneccao.Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MacarraoDAO {
    private Connection coneccao;
    
    public MacarraoBean obterPeloId(int id) {
        if (coneccao != null) {
            String sql = "SELECT * FROM macarroes WHERE id = ?";
            
            try {
                PreparedStatement ps = coneccao.prepareStatement(sql);
                ps.setInt(1, id);
                
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    MacarraoBean macarrao = new MacarraoBean();
                    macarrao.setId(rs.getInt("id"));
                    macarrao.setTipo(rs.getString("tipo"));
                    macarrao.setMarca(rs.getString("marca"));
                    macarrao.setPeso(rs.getDouble("peso"));
                    macarrao.setAldente(rs.getBoolean("aldente"));
                    
                    return macarrao;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                Banco.desconectar();
            }
        }
        return null;
    }
    
    public int inserir(Macarrao macarrao) {
        MacarraoBean macarraoBean = new MacarraoBean();
        
        if (coneccao != null) {
            String sql = "INSERT INTO macarroes (tipo, peso, marca, aldente) ";
                sql += "VALUES (?, ?, ?, ?)";
            
            try {
                PreparedStatement ps = coneccao.prepareStatement(sql, 
                    PreparedStatement.RETURN_GENERATED_KEYS);
                
                ps.setString(1, macarraoBean.getTipo());
                ps.setDouble(2, macarraoBean.getPeso());
                ps.setString(3, macarraoBean.getMarca());
                ps.setBoolean(4, macarraoBean.isAldente());
                ps.execute();
                
                ResultSet rs = ps.getGeneratedKeys();
                
                if (rs.next()) {
                    
                }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return -1;
    }
    
    public boolean alterar(MacarraoBean macarrao) {
        coneccao = Banco.conectar();
        
        if (coneccao != null) {
            String sql = "UPDATE macarroes SET tipo = ?, marca = ?, ";
                sql += "peso = ?, aldente = ? WHERE id = ?";
                
            try {
                PreparedStatement ps = coneccao.prepareStatement(sql);
                ps.setString(1, macarrao.getTipo());
                ps.setString(2, macarrao.getMarca());
                ps.setDouble(3, macarrao.getPeso());
                ps.setBoolean(4, macarrao.isAldente());
                ps.setInt(5, macarrao.getId());
                
                return ps.executeUpdate() == 1;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                Banco.desconectar();
            }
        }
        return false;
    }
    
    public boolean excluir(int id) {
        coneccao = Banco.conectar();
        
        if (coneccao != null) {
            String sql = "DELETE FROM macarroes WHERE id = ?";
            
            try {
                PreparedStatement ps = coneccao.prepareStatement(sql);
                ps.setInt(1, id);
                
                return ps.executeUpdate() == 1;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                Banco.desconectar();
            }
        }
        return false;
    }
}
