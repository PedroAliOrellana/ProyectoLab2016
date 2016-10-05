
package Modelo;


public class Vehiculo 
{
    private String Placa;
    private String Modelo;
    private String Capacidad;
    private String Marca;
    private String CodTRecurso;

    public Vehiculo() 
    {
        Placa = "";
        Modelo = "";
        Capacidad="";
        Marca = "";
        CodTRecurso ="";
    }

    
    public Vehiculo(String Placa, String Modelo, String Capacidad, String Marca, String CodTRecurso) 
    {
        this.Placa = Placa;
        this.Modelo = Modelo;
        this.Capacidad = Capacidad;
        this.Marca = Marca;
        this.CodTRecurso=CodTRecurso;
    }

   
    public String getPlaca() 
    {
        return Placa;
    }

    public void setPlaca(String Placa) 
    {
        this.Placa = Placa;
    }

    public String getModelo()
    {
        return Modelo;
    }

    public void setModelo(String Modelo) 
    {
        this.Modelo = Modelo;
    }

    public String getCapacidad() 
    {
        return Capacidad;
    }

    public void setCapacidad(String Capacidad) 
    {
        this.Capacidad = Capacidad;
    }

    public String getMarca() 
    {
        return Marca;
    }

    public void setMarca(String Marca) 
    {
        this.Marca = Marca;
    }

    public String getCodTRecurso() {
        return CodTRecurso;
    }

    public void setCodTRecurso(String CodTRecurso) {
        this.CodTRecurso = CodTRecurso;
    }

  
    
    
}
