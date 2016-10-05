
package Modelo;


public class MotivoRechazo 
{
    private String CodigoMotivo;
    private String DescripcionMotivo;

    public MotivoRechazo(String CodigoMotivo, String DescripcionMotivo)
    {
        this.CodigoMotivo = CodigoMotivo;
        this.DescripcionMotivo = DescripcionMotivo;
    }

     public MotivoRechazo()
    {
        CodigoMotivo = "";
        DescripcionMotivo ="" ;
    }
    
    
    
    public String getCodigoMotivo() 
    {
        return CodigoMotivo;
    }

    public void setCodigoMotivo(String CodigoMotivo)
    {
        this.CodigoMotivo = CodigoMotivo;
    }

    public String getDescripcionMotivo()
    {
        return DescripcionMotivo;
    }

    public void setDescripcionMotivo(String DescripcionMotivo)
    {
        this.DescripcionMotivo = DescripcionMotivo;
    }
    
    
   
}
