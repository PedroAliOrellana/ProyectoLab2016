
package Modelo;


public class Recurso 
{
    private String Codigo;
    private String Descripcion;
    private float  tasa;
    private String unidMedida;

    public Recurso(String Codigo, String Descripcion, float tasa, String unidMedida)
    {
        this.Codigo = Codigo;
        this.Descripcion = Descripcion;
        this.tasa = tasa;
        this.unidMedida = unidMedida;
    }
    
    public Recurso() 
    {
        this.Codigo = "";
        this.Descripcion = "";
        this.tasa = 0;
        this.unidMedida = "";
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

    public float getTasa() {
        return tasa;
    }

    public void setTasa(float tasa) {
        this.tasa = tasa;
    }

    public String getUnidMedida() {
        return unidMedida;
    }

    public void setUnidMedida(String unidMedida) {
        this.unidMedida = unidMedida;
    }

    
}
