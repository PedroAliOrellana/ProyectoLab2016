
package Modelo;

public class Motivo
{
    private String codMotivo;
    private String descMotivo;

    public Motivo(String codMotivo, String descMotivo) 
    {
        this.codMotivo = codMotivo;
        this.descMotivo = descMotivo;
    }

   
    public Motivo() 
    {
        codMotivo = "";
        descMotivo ="";
    }

    
    public String getCodMotivo() 
    {
        return codMotivo;
    }

    public void setCodMotivo(String codMotivo) 
    {
        this.codMotivo = codMotivo;
    }

    public String getDescMotivo()
    {
        return descMotivo;
    }

    public void setDescMotivo(String descMotivo) 
    {
        this.descMotivo = descMotivo;
    }
    
}
