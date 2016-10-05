
package Modelo;

public class Herramienta
{
    private String Codigo;
    private String Descripcion;
    private String Marca;
    private String CodTRecurso;

    public Herramienta(String Codigo, String Descripcion, String Marca, String CodTRecurso) 
    {
        this.Codigo = Codigo;
        this.Descripcion = Descripcion;
        this.Marca = Marca;
        this.CodTRecurso = CodTRecurso;
    }

        public Herramienta() 
    {
        this.Codigo = "";
        this.Descripcion = "";
        this.Marca = "";
        this.CodTRecurso = "";
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

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getCodTRecurso() {
        return CodTRecurso;
    }

    public void setCodTRecurso(String CodTRecurso) {
        this.CodTRecurso = CodTRecurso;
    }


   
    
    
}
