
package Modelo;

public class Empleado extends Persona
{
    private String FechaInicio;
    private String Cargo;

    public Empleado(String FechaInicio, String cedula,   String nombre,          String apellido,
                    String direccion,   String telefono, String fechaNacimiento, String sexo,String Cargo)
    {
        super(cedula, nombre,apellido, direccion, telefono, fechaNacimiento, sexo);
        this.FechaInicio = FechaInicio;
        this.Cargo = Cargo;
    }

    public Empleado() {
        FechaInicio = "";
        Cargo="";
    }
    
    
    public String getFechaInicio()
    {
        return FechaInicio;
    }

    public void setFechaInicio(String FechaInicio) 
    {
        this.FechaInicio = FechaInicio;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }


    
    
    
}
