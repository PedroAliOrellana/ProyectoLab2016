package Modelo;

public class Servicio 
{
   private String Codigo;
   private String Descripcion;

   

 public Servicio() 
   {
        this.Codigo = "";
        this.Descripcion = "";
    }

    public Servicio(String Codigo, String Descripcion) {
        this.Codigo = Codigo;
        this.Descripcion = Descripcion;
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

   
}
