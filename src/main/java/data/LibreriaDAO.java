package data;

import static data.Conexion.close;
import static data.Conexion.getConexion;
import entity.Libros;
import java.sql.*;
import java.util.*;

public class LibreriaDAO {

    private static final String SQL_CREATE = "INSERT INTO libros(nombre, autor, cantPaginas, precio, copias) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_READ = "SELECT * FROM libros";
    private static final String SQL_UPDATE_PRECIO = "UPDATE libros SET precio = ? WHERE idlibros = ?";
    private static final String SQL_UPDATE_COPIAS = "UPDATE libros SET copias = ? WHERE idlibros = ?";
    private static final String SQL_DELETE = "DELETE FROM libros WHERE idlibros = ?";
    private static final String SQL_SELECT_BY_NAME = "SELECT * FROM users WHERE name = ?";

    public List<Libros> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Libros libro = null;
        List<Libros> libros = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idLibros = rs.getInt(1);
                String nombre = rs.getString(2);
                String autor = rs.getString(3);
                int cantPaginas = rs.getInt(4);
                double precio = rs.getDouble(5);
                int copias = rs.getInt(6);

                libro = new Libros(idLibros, nombre, autor, cantPaginas, precio, copias);

                libros.add(libro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return libros;
    }

    public int create(Libros libro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_CREATE);
            stmt.setString(1, libro.getNombre());
            stmt.setString(2, libro.getAutor());
            stmt.setInt(3, libro.getCantPaginas());
            stmt.setDouble(4, libro.getPrecio());
            stmt.setInt(5, libro.getCopias());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int updatePrecio(Libros libro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_PRECIO);
            stmt.setDouble(1, libro.getPrecio());
            stmt.setInt(2, libro.getIdLibros());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int updateCopias(Libros libro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_COPIAS);
            stmt.setInt(1, libro.getCopias());
            stmt.setInt(2, libro.getIdLibros());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int delete(Libros libro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, libro.getIdLibros());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
