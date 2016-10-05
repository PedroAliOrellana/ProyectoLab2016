
package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JOptionPane;
//------------------------------------------------------

public class Rutinas 
{
  public static String getFechaActual() 
   {
      Date ahora = new Date();
      SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
      return formateador.format(ahora);
    }      
//-----------------------------------------------------------    
 public static boolean isDate(String fechax)
 {
  try {
      SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
      formatoFecha.setLenient(false);
      formatoFecha.parse(fechax);
      return true;
  } catch (ParseException e) 
     {
      return false;
     }
  
}
//----------------------------------------------------------------    
 public static Date CnvStringFecha(String fecha)
{
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    Date fechaDate = null;
    try {
        fechaDate = formato.parse(fecha);
    }
    catch (ParseException ex)
    {
        System.out.println(ex);
    }
    return fechaDate;
}
//------------------------------------------------------------------------
  public static String FormatoFecha(Date fecha)
{
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");        
    return formato.format(fecha);
}
//---------------------------------------------------------------------------   
 public static void Aviso(String Mensaje,
                           String CaptionWin) 
  {
      JOptionPane.showMessageDialog(null,
      Mensaje,
      CaptionWin,
      JOptionPane.WARNING_MESSAGE);
   }
 //--------------------------------------------------------------------------
 public static int Opciones(String Op1,String Op2,String Op3)
{        
  int optionType = JOptionPane.DEFAULT_OPTION;
int messageType = JOptionPane.PLAIN_MESSAGE; // no standard icon

Object[] selValues = { Op1, Op2, Op3 };

// Shows message, choices appear as buttons
int res = JOptionPane.showOptionDialog(null, "Selecciona una Opcion", "Accion",
                                       optionType, messageType,null ,
                                       selValues, selValues[0]);

return res;
}
 //-------------------------------------------------------------------------
 public static int Generar_Aleatorio(int limite) 
   { 
      return (int) (Math.random()*limite+1)-1;
   }

 //-------------------------------------------------------------------------
    //Sumarle dias a una fecha determinada
    //@param fch La fecha para sumarle los dias
    //@param dias Numero de dias a agregar
    //@return La fecha agregando los dias
   
 public static java.sql.Date sumarFechasDias(Date fch, int dias) 
    {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, dias);
        return new java.sql.Date(cal.getTimeInMillis());
    }
 
 //-----------------------
 public static String Apost(String Texto)
 {
   return "'"+Texto+"'";    
 } 

   
         
         
}
