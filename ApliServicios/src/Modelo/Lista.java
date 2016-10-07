package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

public class Lista 
{
  private LinkedList<Servicio> ListaServicio= new LinkedList<Servicio>();        
  private LinkedList<Cliente> ListaCliente= new LinkedList<Cliente>();
  private LinkedList<Recurso> ListaRecurso= new LinkedList<Recurso>();
  private LinkedList<Obra> ListaObra= new LinkedList<Obra>();
  private LinkedList<Empleado> ListaEmpleado= new LinkedList<Empleado>();
  private LinkedList<Usuario> ListaUsuario= new LinkedList<Usuario>();
  private LinkedList<Motivo> ListaMotivo = new LinkedList<Motivo>();
  private LinkedList<Vehiculo> ListaVehiculo = new LinkedList<Vehiculo>();
  private LinkedList<Herramienta> ListaHerramienta = new LinkedList<Herramienta>();
  private LinkedList<TipoRecurso> ListaTipoRecurso= new LinkedList<TipoRecurso>();
  private LinkedList<Maquinaria> ListaMaquinaria = new LinkedList<Maquinaria>();

    public LinkedList<Servicio> getListaServicio()
    {
        return ListaServicio;
    }

    public LinkedList<Cliente> getListaCliente()
    {
        return ListaCliente;
    }

    public LinkedList<Recurso> getListaRecurso() 
    {
        return ListaRecurso;
    }

    public LinkedList<Obra> getListaObra()
    {
        return ListaObra;
    }

    public LinkedList<Empleado> getListaEmpleado()
    {
        return ListaEmpleado;
    }

    public LinkedList<Usuario> getListaUsuario()
    {
        return ListaUsuario;
    }
  
  public LinkedList<Motivo> getListaMotivo()
  {
    return ListaMotivo;      
  }

    public LinkedList<Vehiculo> getListaVehiculo() 
    {
        return ListaVehiculo;
    }

    public LinkedList<Herramienta> getListaHerramienta() 
    {
        return ListaHerramienta;
    }

    public LinkedList<TipoRecurso> getListaTipoRecurso()
    {
        return ListaTipoRecurso;
    }

    public LinkedList<Maquinaria> getListaMaquinaria()
    {
        return ListaMaquinaria;
    }
  
  // zona de los cargar, metodos que carga los datos que esta en el archivo de texto
  
  public void cargarServicio()
  {
     Servicio servicio=new Servicio();
           
    String Via;
    int Cnt;
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    boolean respon;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         //archivo = new File ("C:\\Arbitros.txt");
                           
         Via=System.getProperty("user.dir")+"/src/Archivos/Servicios.txt";   
        
         archivo = new File (Via);
         
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         
         Cnt=0;
         
         while((linea=br.readLine())!=null)
            {               
              Cnt++;
              
              switch (Cnt)
              {
                  case 1:servicio.setCodigo(linea);
                         break;
                      
                  case 2:servicio.setDescripcion(linea);
                         ListaServicio.add(servicio);
                         servicio=new Servicio();//resetear                         
                         Cnt=0;
                         break;    
              }                
              
            }
                        
      }
      catch(Exception e){
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
         }
      }    
  }   
  //---------------------------------
  
      public void cargarCliente()
  {
     Cliente cliente=new Cliente();
           
    String Via;
    int Cnt;
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    boolean respon;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         //archivo = new File ("C:\\Arbitros.txt");
                           
         Via=System.getProperty("user.dir")+"/src/Archivos/Cliente.txt";   
        
         archivo = new File (Via);
         
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         
         Cnt=0;
         
         while((linea=br.readLine())!=null)
            {               
              Cnt++;
              
              switch (Cnt)
              {
                  case 1:cliente.setRif(linea);
                         break;
                      
                  case 2:cliente.setRazonSocial(linea);
                         break;
                         
                  case 3:cliente.setDireccion(linea);
                         break;
                  case 4:cliente.setTelefono(linea);
                         break;  
                  case 5:cliente.setCorreo(linea);
                         ListaCliente.add(cliente);
                         cliente=new Cliente();//resetear                         
                         Cnt=0;
                         break;    
              }                
              
            }
                        
      }
      catch(Exception e){
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
         }
      }      
}
   //---------------------------------
  
   public void cargarRecurso()
  {
     Recurso recurso=new Recurso();
           
    String Via;
    int Cnt;
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    boolean respon;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         //archivo = new File ("C:\\Arbitros.txt");
                           
         Via=System.getProperty("user.dir")+"/src/Archivos/Recurso.txt";   
        
         archivo = new File (Via);
         
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         float ln=0;
         Cnt=0;
         
         while((linea=br.readLine())!=null)
            {               
              Cnt++;
              
              switch (Cnt)
              {
                  case 1:recurso.setCodigo(linea);
                         break;
                      
                  case 2:recurso.setDescripcion(linea);
                         break;
                         
                  case 3:recurso.setTasa(ln);
                         break;
                       
                  case 4:recurso.setUnidMedida(linea);
                         ListaRecurso.add(recurso);
                         recurso=new Recurso();//resetear                         
                         Cnt=0;
                         break;    
              }                
              
            }
                        
      }
      catch(Exception e){
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
         }
      }      
}
  //---------------------------------
   public void cargarObra()
  {
     Obra obra=new Obra();
           
    String Via;
    int Cnt;
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    boolean respon;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         //archivo = new File ("C:\\Arbitros.txt");
                           
         Via=System.getProperty("user.dir")+"/src/Archivos/Obra.txt";   
        
         archivo = new File (Via);
         
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         
         Cnt=0;
         
         while((linea=br.readLine())!=null)
            {               
              Cnt++;
              
              switch (Cnt)
              {
                  case 1:obra.setCodigo(linea);
                         break;
                      
                  case 2:obra.setDescripcion(linea);
                         break;
                         
                  case 3:obra.setLugar(linea);
                         ListaObra.add(obra);
                         obra=new Obra();//resetear                         
                         Cnt=0;
                         break;    
              }                
              
            }
                        
      }
      catch(Exception e){
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
         }
      }      
}
  
  //--------------------------------- 
      public void cargarEmpleado()
  {
    Empleado emp=new Empleado();
           
    String Via;
    int Cnt;
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    boolean respon;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         //archivo = new File ("C:\\Arbitros.txt");
                           
         Via=System.getProperty("user.dir")+"/src/Archivos/Empleado.txt";   
        
         archivo = new File (Via);
         
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         
         Cnt=0;
         
         while((linea=br.readLine())!=null)
            {               
              Cnt++;
              
              switch (Cnt)
              {
                  case 1:emp.setCedula(linea);
                         break;
                  case 2:emp.setNombre(linea);
                        break;
                  case 3:emp.setApellido(linea);
                        break;
                  case 4:emp.setDireccion(linea);
                        break;
                  case 5:emp.setTelefono(linea);
                        break;
                  case 6:emp.setFechaNacimiento(linea);
                        break;      
                  case 7:emp.setSexo(linea);
                        break;
                  case 8:emp.setFechaInicio(linea);
                        break;
                  case 9:emp.setCargo(linea); 
                         ListaEmpleado.add(emp);
                         emp=new Empleado();//resetear                         
                         Cnt=0;
                         break;    
              }                
              
            }
                        
      }
      catch(Exception e){
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
         }
      }      
}
   
  //---------------------------------
    public void cargarUsuario()
  {
     Usuario usuario=new Usuario();
           
    String Via;
    int Cnt;
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    boolean respon;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         //archivo = new File ("C:\\Arbitros.txt");
                           
         Via=System.getProperty("user.dir")+"/src/Archivos/Usuarios.txt";   
        
         archivo = new File (Via);
         
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         
         Cnt=0;
         
         while((linea=br.readLine())!=null)
            {               
              Cnt++;
              
              switch (Cnt)
              {
                  case 1:usuario.setNombreUsuario(linea);
                         break;
                      
                  case 2:usuario.setContrasena(linea);
                         break;
                         
                  case 3:usuario.setNivelAcceso(linea);
                          ListaUsuario.add(usuario);
                          usuario=new Usuario();
                          Cnt=0;
                         break;
  
              }                
              
            }
                        
      }
      catch(Exception e){
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
         }
      }      
} 

 //---------------------------------  
  public void cargarMotivo()
  {
     Motivo motivo =new Motivo();
           
    String Via;
    int Cnt;
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    boolean respon;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         //archivo = new File ("C:\\Arbitros.txt");
                           
         Via=System.getProperty("user.dir")+"/src/Archivos/Motivo.txt";   
        
         archivo = new File (Via);
         
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         
         Cnt=0;
         
         while((linea=br.readLine())!=null)
            {               
              Cnt++;
              
              switch (Cnt)
              {
                  case 1:motivo.setCodMotivo(linea);
                        break;
                  case 2:motivo.setDescMotivo(linea);
                         ListaMotivo.add(motivo);
                         motivo=new Motivo();                
                         Cnt=0;
                         break;    
              }                
              
            }
                        
      }
      catch(Exception e){
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
         }
      }    
  }   

 //--------------------------------
    public void cargarVehiculo()
  {
     Vehiculo vehiculo =new Vehiculo();
           
    String Via;
    int Cnt;
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    boolean respon;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         //archivo = new File ("C:\\Arbitros.txt");
                           
         Via=System.getProperty("user.dir")+"/src/Archivos/Vehiculo.txt";   
        
         archivo = new File (Via);
         
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         int ln=0;
         Cnt=0;
         
         while((linea=br.readLine())!=null)
            {               
              Cnt++;
              
              switch (Cnt)
              {
                  case 1:vehiculo.setPlaca(linea);
                        break;
                  case 2:vehiculo.setModelo(linea);
                        break;
                  case 3:vehiculo.setCapacidad(linea);
                        break;
                  case 4:vehiculo.setMarca(linea);;
                        break;      
                  case 5:vehiculo.setCodTRecurso(linea);
                         ListaVehiculo.add(vehiculo);
                         vehiculo=new Vehiculo();//regresar        
                         Cnt=0;
                         break;    
              }                
            }           
      }
      catch(Exception e){
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
         }
      }    
  }   
 //--------------------------------
    public void cargarHerramienta()
  {
     Herramienta her =new Herramienta();
           
    String Via;
    int Cnt;
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    boolean respon;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         //archivo = new File ("C:\\Arbitros.txt");
                           
         Via=System.getProperty("user.dir")+"/src/Archivos/Herramienta.txt";   
        
         archivo = new File (Via);
         
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         
         Cnt=0;
         
         while((linea=br.readLine())!=null)
            {               
              Cnt++;
              
              switch (Cnt)
              {
                  case 1:her.setCodigoHerramienta(linea);
                        break;
                  case 2:her.setDescHerramienrta(linea);
                        break;
                  case 3:her.setMarca(linea);
                        ListaHerramienta.add(her);
                        her=new Herramienta();//regresar        
                        Cnt=0;
                        break;    
              }                
            }           
      }
      catch(Exception e){
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
         }
      }    
  }   

      public void cargarTipoRecurso()
  {
     TipoRecurso tr =new TipoRecurso();
           
    String Via;
    int Cnt;
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    boolean respon;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         //archivo = new File ("C:\\Arbitros.txt");
                           
         Via=System.getProperty("user.dir")+"/src/Archivos/TipoRecurso.txt";   
        
         archivo = new File (Via);
         
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         
         Cnt=0;
         
         while((linea=br.readLine())!=null)
            {               
              Cnt++;
              
              switch (Cnt)
              {
                  case 1:tr.setCodigo(linea);
                        break;
                  case 2:tr.setDescripcion(linea);
                         ListaTipoRecurso.add(tr);
                         tr=new TipoRecurso();//regresar        
                         Cnt=0;
                         break;    
              }                
            }           
      }
      catch(Exception e){
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
         }
      }    
  }   

  //--------------------------------
    public void cargarMaquinaria()
  {
     Maquinaria maq =new Maquinaria();
           
    String Via;
    int Cnt;
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    boolean respon;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         //archivo = new File ("C:\\Arbitros.txt");
                           
         Via=System.getProperty("user.dir")+"/src/Archivos/Maquinaria.txt";   
        
         archivo = new File (Via);
         
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         int ln=0;
         Cnt=0;
         
         while((linea=br.readLine())!=null)
            {               
              Cnt++;
              
              switch (Cnt)
              {
                  case 1:maq.setPlaca(linea);
                        break;
                  case 2:maq.setModelo(linea);
                        break;
                  case 3:maq.setMarca(linea);
                        break;
                  case 4:maq.setPesoMax(linea);
                        break;
                  case 5:maq.setCodTRecurso(linea);
                        ListaMaquinaria.add(maq);
                        maq=new Maquinaria();//regresar        
                        Cnt=0;
                        break;    
              }                
            }           
      }
      catch(Exception e){
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
         }
      }    
  }   

 //---------------------------------

    
    
 //-------zona de los Buscar, busca si el dato esta en el archivo -------------------------
      public int BuscarServicio(String cod) 
    {
      Integer Posi;
      Servicio ser= new Servicio();
      String codLista;
  for (Posi=0;Posi< ListaServicio.size();Posi++)
     {
     ser=ListaServicio.get(Posi);
     codLista=ser.getCodigo();
     
     if (codLista.equals(cod))
        return Posi;
     }
   return -1;
    }
      
  //---------------------------------
     public int BuscarCliente(String r) 
    {
      Integer Posi;
      Cliente cli= new Cliente();
      String rsLista;
  for (Posi=0;Posi< ListaCliente.size();Posi++)
     {
     cli=ListaCliente.get(Posi);
     rsLista=cli.getRif();
     
     if (rsLista.equals(r))
        return Posi;
     }
   return -1;
    }
 //-----------------------------------    
 public int BuscarRecurso(String cod)
 {
      Integer Posi;
      Recurso rec= new Recurso();
      String codLista;
  for (Posi=0;Posi< ListaRecurso.size();Posi++)
     {
     rec=ListaRecurso.get(Posi);
     codLista=rec.getCodigo();
     if (codLista.equals(cod))
        return Posi;
     }
   return -1;  
   }
  //-----------------------------------    
 public int BuscarObra(String cod)
 {
      Integer Posi;
      Obra obr= new Obra();
      String codLista;
  for (Posi=0;Posi< ListaObra.size();Posi++)
     {
     obr=ListaObra.get(Posi);
     codLista=obr.getCodigo();
     if (codLista.equals(cod))
        return Posi;
     }
   return -1;  
   }
  //---------------------------------
   public int BuscarEmpleado(String C)
    {
        int posi;
        Empleado emp = new Empleado();
        String ced;
        
        for(posi = 0;posi<ListaEmpleado.size();posi++)
        {
            emp = ListaEmpleado.get(posi);
            ced= emp.getCedula();
            if(ced.equals(C))
                return posi;
        }
        return -1;
    }
//---------------------------------
     public int BuscarUsuario(String nomUs) 
    {
      Integer Posi;
      Usuario usu= new Usuario();
      String nomLista;
       for (Posi=0;Posi< ListaUsuario.size();Posi++)
      {
     usu=ListaUsuario.get(Posi);
     nomLista=usu.getNombreUsuario();
     
     if (nomLista.equals(nomUs))
        return Posi;
     }
   return -1;
    }
//----------------------------- 
   public int BuscarMotivo(String cod)
   {
      Integer Posi;
      Motivo mot= new Motivo();
      String codLista;
  for (Posi=0;Posi< ListaMotivo.size();Posi++)
     {
     mot=ListaMotivo.get(Posi);
     codLista=mot.getCodMotivo();
     
     if (codLista.equals(cod))
        return Posi;
     }
   return -1;  
   }
  //----------------------------- 
   public int BuscarVehiculo(String pla)
   {
      Integer Posi;
      Vehiculo ve= new Vehiculo();
      String plaLista;
  for (Posi=0;Posi<ListaVehiculo.size();Posi++)
     {
     ve=ListaVehiculo.get(Posi);
     plaLista=ve.getPlaca();
     if (plaLista.equals(pla))
        return Posi;
     }
   return -1;  
   }
   //----------------------------- 
   public int BuscarHerramienta(String cod) 
   {
       Integer Posi;
      Herramienta her= new Herramienta();
      String codLista;
  for (Posi=0;Posi< ListaHerramienta.size();Posi++)
     {
     her=ListaHerramienta.get(Posi);
     codLista=her.getCodigoHerramienta();
     
     if (codLista.equals(cod))
        return Posi;
     }
   return -1;  
   }
   //----------------------------- 
   public int BuscarTipoRecurso(String cod) 
   {
       Integer Posi;
      TipoRecurso tr= new TipoRecurso();
      String codLista;
  for (Posi=0;Posi< ListaTipoRecurso.size();Posi++)
     {
     tr=ListaTipoRecurso.get(Posi);
     codLista=tr.getCodigo();
     
     if (codLista.equals(cod))
        return Posi;
     }
   return -1;  
   }
   //-------------------------------
   public int BuscarMaquinaria(String pla)
   {
      Integer Posi;
      Maquinaria maq= new Maquinaria();
      String plaLista;
  for (Posi=0;Posi<ListaMaquinaria.size();Posi++)
     {
     maq=ListaMaquinaria.get(Posi);
     plaLista=maq.getPlaca();
     if (plaLista.equals(pla))
        return Posi;
     }
   return -1;  
   }
  //-------------------------------
      

   
   
   
   }