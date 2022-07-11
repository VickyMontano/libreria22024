package web;

import data.LibreriaDAO;
import entity.Libros;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        List <Libros> libros = new LibreriaDAO().findAll();
        libros.forEach(System.out::println);
        req.setAttribute("pepe", libros);
        req.setAttribute("cantidadLibros", calcularCant(libros));
        req.setAttribute("precioTotal", calcularPrecio(libros));
        req.getRequestDispatcher("libros.jsp").forward(req, res);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res){
        String accion = req.getParameter("accion");
        if(accion!=null){
            switch(accion){
                case "insertar":
                    guardarLibro(req,res);
                    break;
                default:
                    accionDefault(req,res);
                    break;
                
            }
        }
    }
    
    private void accionDefault(HttpServletRequest req, HttpServletResponse res){
    
    }
    
    private void guardarLibro(HttpServletRequest req, HttpServletResponse res){
        String nombre = req.getParameter("nombre");
        String autor = req.getParameter("autor");
        int cantPaginas = Integer.parseInt(req.getParameter("cantPaginas"));
        double precio = Double.parseDouble(req.getParameter("precio"));
        int copias = Integer.parseInt(req.getParameter("copias"));
        
        Libros libro = new Libros(nombre,autor,cantPaginas,precio,copias);
        int regMod = new LibreriaDAO().create(libro);
        System.out.println("Insertados: " + regMod);
        accionDefault(req,res);
    }
    
    private int calcularCant(List<Libros> lista){
        int cantidad=0;
        for (int i = 0; i < lista.size(); i++) {
            cantidad += lista.get(i).getCopias();
        }
        return cantidad;
    }
    
    private double calcularPrecio(List<Libros> lista){
        double precio=0;
        for (int i = 0; i < lista.size(); i++) {
            precio += (lista.get(i).getCopias()*lista.get(i).getPrecio());
        }
        return precio;
    }
    
    
}
