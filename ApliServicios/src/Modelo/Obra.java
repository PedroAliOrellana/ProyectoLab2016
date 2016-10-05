package Modelo;

public class Obra
{
    private String Codigo;
    private String Descripcion;
    private String Lugar;

    public Obra(String Codigo, String Descripcion, String Lugar) {
        this.Codigo = Codigo;
        this.Descripcion = Descripcion;
        this.Lugar = Lugar;
    }

       public Obra() {
        this.Codigo = "";
        this.Descripcion = "";
        this.Lugar = "";
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String Lugar) {
        this.Lugar = Lugar;
    }
       
}
