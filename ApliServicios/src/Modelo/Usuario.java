
package Modelo;


public class Usuario 
{
   private String NombreUsuario;
   private String Contrasena;
   private String NivelAcceso;

    public Usuario(String NombreUsuario, String Contrasena, String NivelAcceso)
    {
        this.NombreUsuario = NombreUsuario;
        this.Contrasena = Contrasena;
       this.NivelAcceso = NivelAcceso;
    }

   public Usuario()
    {
        NombreUsuario ="" ;
        Contrasena = "";
        NivelAcceso="";
        
    }
   
   
    public String getNombreUsuario()
    {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) 
    {
        this.NombreUsuario = NombreUsuario;
    }

    public String getContrasena() 
    {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) 
    {
        this.Contrasena = Contrasena;
    }

   

    public String getNivelAcceso()
    {
        return NivelAcceso;
    }

    public void setNivelAcceso(String NivelAcceso)
    {
        this.NivelAcceso = NivelAcceso;
    }
   
   
   
   
   
   
}
