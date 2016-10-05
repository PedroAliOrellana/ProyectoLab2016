
package Modelo;


public class TipoRecurso
{
  private String Codigo;
  private String Descripcion;

    public TipoRecurso(String Codigo, String Descripcion)
    {
        this.Codigo = Codigo;
        this.Descripcion = Descripcion;
    }

   public TipoRecurso()
    {
        Codigo="" ;
        Descripcion="" ;
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
