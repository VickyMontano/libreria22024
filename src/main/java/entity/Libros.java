package entity;

public class Libros {
    private int idLibros;
    private String nombre;
    private String autor;
    private int cantPaginas;
    private double precio;
    private int copias;

    public Libros(int idLibros, String nombre, String autor, int cantPaginas, double precio, int copias) {
        this.idLibros = idLibros;
        this.nombre = nombre;
        this.autor = autor;
        this.cantPaginas = cantPaginas;
        this.precio = precio;
        this.copias = copias;
    }

    public Libros(String nombre, String autor, int cantPaginas, double precio, int copias) {
        this.nombre = nombre;
        this.autor = autor;
        this.cantPaginas = cantPaginas;
        this.precio = precio;
        this.copias = copias;
    }

    public int getIdLibros() {
        return idLibros;
    }

    public void setIdLibros(int idLibros) {
        this.idLibros = idLibros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }

    @Override
    public String toString() {
        return "Libros{" + "nombre=" + nombre + ", autor=" + autor + ", cantPaginas=" + cantPaginas + ", precio=" + precio + ", copias=" + copias + '}';
    }
}
