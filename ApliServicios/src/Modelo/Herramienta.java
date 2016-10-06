
package Modelo;

public class Herramienta
{
    private String CodigoHerramienta;
    private String DescHerramienrta;
    private String Marca;

    public Herramienta(String CodigoHerramienta, String DescHerramienrta, String Marca)
    {
        this.CodigoHerramienta = CodigoHerramienta;
        this.DescHerramienrta = DescHerramienrta;
        this.Marca = Marca;
    }
     public Herramienta()
    {
        CodigoHerramienta = "";
        DescHerramienrta = "";
        Marca = "";
    }
    

    public String getCodigoHerramienta()
    {
        return CodigoHerramienta;
    }

    public void setCodigoHerramienta(String CodigoHerramienta)
    {
        this.CodigoHerramienta = CodigoHerramienta;
    }

    public String getDescHerramienrta() 
    {
        return DescHerramienrta;
    }

    public void setDescHerramienrta(String DescHerramienrta)
    {
        this.DescHerramienrta = DescHerramienrta;
    }

    public String getMarca() 
    {
        return Marca;
    }

    public void setMarca(String Marca)
    {
        this.Marca = Marca;
    }
    
    
    
}
