
package Modelo;


public class Cliente 
{
    private String rif;
    private String razonSocial;
    private String telefono;
    private String direccion;
    
    public Cliente(String rif, String razonSocial, String telefono, String direccion) 
    {
        this.rif = rif;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
  public Cliente() 
    {
        rif = "";
        razonSocial = "";
        telefono = "";
        direccion = "";
    }
    public String getRif() 
    {
        return rif;
    }

    public void setRif(String rif) 
    {
        this.rif = rif;
    }

    public String getRazonSocial() 
    {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) 
    {
        this.razonSocial = razonSocial;
    }

    public String getTelefono() 
    {
        return telefono;
    }

    public void setTelefono(String telefono) 
    {
        this.telefono = telefono;
    }

    public String getDireccion() 
    {
        return direccion;
    }

    public void setDireccion(String direccion) 
    {
        this.direccion = direccion;
    }
    
    
}
