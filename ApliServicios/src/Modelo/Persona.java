
package Modelo;

public class Persona 
{
    private String cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String fechaNacimiento;
    private String sexo;
     
    //-----------------------------------
    public Persona(String cedula,    String nombre,   String apellido, 
                   String direccion, String telefono, String fechaNacimiento, String sexo) 
    {
        super();
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }
 //-----------------------------------
    public Persona() 
    {
        super();
        this.cedula = "";
        this.nombre = "";
        this.direccion = "";
        this.telefono = "";
        this.fechaNacimiento = "";
        this.sexo = "";
    }
 //-----------------------------------
    public String getCedula() 
    {
        return cedula;
    }
 //-----------------------------------
    public void setCedula(String cedula)
    {
        this.cedula = cedula;
    }
 //-----------------------------------
    public String getNombre()
    {
        return nombre;
    }
 //-----------------------------------
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
 //-----------------------------------
    public String getDireccion() {
        return direccion;
    }
 //-----------------------------------
    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }
 //-----------------------------------
    public String getTelefono() 
    {
        return telefono;
    }
 //-----------------------------------
    public void setTelefono(String telefono) 
    {
        this.telefono = telefono;
    }
 //-----------------------------------
    public String getFechaNacimiento() 
    {
        return fechaNacimiento;
    }
 //-----------------------------------
    public void setFechaNacimiento(String fechaNacimiento)
    {
        this.fechaNacimiento = fechaNacimiento;
    }
 //-----------------------------------
    public String getSexo() 
    {
        return sexo;
    }
 //-----------------------------------
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
 //-----------------------------------
    public String getApellido() {
        return apellido;
    }
 //-----------------------------------
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
