
package Controlador;


import Librerias.Validaciones;
import Modelo.Servicio;
import Modelo.Lista;
import Vista.JFrameServicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;


public class ControladorServicio implements ActionListener
{
     private final JFrameServicio formServicio;
     private final Lista ListaServicio;

     @SuppressWarnings("LeakingThisInConstructor")
    public ControladorServicio(Lista ListServicio)
    {
        ListaServicio= ListServicio;
        formServicio = new JFrameServicio();
        formServicio.agregarListener(this);
        formServicio.setVisible(true);
         DeshabilitarControles();
        
  
         formServicio.getTxtCodServicio().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,4,formServicio.getTxtCodServicio().getText()); 
               
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
              {   
                   CodigokeyPressed(e);
              }

       }
    );          
     //----------------------------------------
    formServicio.getTxtDescServicio().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,11,formServicio.getTxtDescServicio().getText()); 
                 ValidarSoloLetras(e);
              }
                 
       }
      );       
    
     
          
 }      
    //-----------ActivarDeshabilitarControles----------------
    
    private void ActivarControles()
    {
        formServicio.getTxtCodServicio().setEditable(false);
        formServicio.getTxtDescServicio().setEditable(true);
        formServicio.getBtnGrabar().setEnabled(true);
        formServicio.getBtnCancelar().setEnabled(true);
   
       
    }
    private void DeshabilitarControles()
    {
        formServicio.getTxtCodServicio().setEditable(true);
        formServicio.getTxtDescServicio().setEditable(false);
        formServicio.getBtnGrabar().setEnabled(false);
    }
   private void CargarDatos(int p)
    {
        Servicio e = ListaServicio.getListaServicio().get(p);
        
        formServicio.getTxtCodServicio().setEnabled(false);
  
        formServicio.getTxtDescServicio().setText(e.getDescripcion());
        
    }
    //-----------TxtCodigoEventoEnter-----------
    
    private void CodigokeyPressed(KeyEvent e)
    {
        String Cadena;
        Integer Posi;
        Cadena = formServicio.getTxtCodServicio().getText().trim();
        if (e.getKeyChar()==10 && (Cadena.length()>4))
        {
            Posi= ListaServicio.BuscarServicio(Cadena);
            if(Posi==-1)
            {
                int resp;
                resp = JOptionPane.showConfirmDialog(null, "El Servicio no esta registrado, ¿Desea registrarlo?","Registro",JOptionPane.YES_NO_OPTION);
                if(resp==0)
                {               
                    ActivarControles();
                }
                else
                {
                    Limpiar();
                }
            }
            else
            {
                DeshabilitarControles();
                CargarDatos(Posi);
            }
        }
}
     //---------Verificar Controles----------------
    
    private Boolean Verificar()
    {
        JFrameServicio e = formServicio;
        if(e.getTxtDescServicio().getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "la direccion  esta en blanco","Atención",JOptionPane.WARNING_MESSAGE);
            formServicio.getTxtDescServicio().requestFocusInWindow();
            return false;
        }
        
    
          return true;
    }
    
    
    
//-------------------Botones de servicios------------------
    private void Limpiar()
{ 
    formServicio.getTxtCodServicio().setText("");
    formServicio.getTxtDescServicio().setText("");
    formServicio.getTxtCodServicio().setEnabled(true);
   
}
 private void Grabar()
 {
   int posi;
        Servicio servicio;
        if (Verificar())
        {
            posi=ListaServicio.BuscarServicio(formServicio.getTxtCodServicio().getText());
            if(posi==-1)
            {
               servicio= new Servicio(formServicio.getTxtCodServicio().getText(),
                                      formServicio.getTxtDescServicio().getText());
                      
               ListaServicio.getListaServicio().add(servicio);
             
                JOptionPane.showMessageDialog(null," Guardado Correctamente","Datos almacenados",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                DeshabilitarControles();
                Limpiar();              
            }
            else
            {               
                ListaServicio.getListaServicio().get(posi).setDescripcion(formServicio.getTxtDescServicio().getText());
                JOptionPane.showMessageDialog(null,"Datos Actualizados Correctamente","Información Actualizada",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                DeshabilitarControles();
                Limpiar(); 
            }
        }     
  }
  

    
     //-----------Validaciones---------------------
    
    private void ValidarTxt(KeyEvent e,int largo,String txt) 
    {
        if (txt.length()>largo){
            e.consume();
        }
    
    }
    
    private void ValidarSoloLetras(KeyEvent e)
    {
        Character s= e.getKeyChar();
        if (!Character.isLetter(s))
            e.consume();
    }
        
    
        private void ValidarTxtNum(KeyEvent e,int largo,String txt) 
    {
        if (txt.length()>largo)
        {
            e.consume();
            return;
        }
        
        char Digito; 
        Digito=e.getKeyChar();
        
        if (Digito<'0' || Digito >'9')
            e.consume();
 }

 @Override
    public void actionPerformed(ActionEvent e) 
    {
          if (e.getSource().equals(formServicio.getBtnCancelar()))  
      {  
        Limpiar();  
        formServicio.getTxtCodServicio().setEditable(true);
        formServicio.getTxtDescServicio().setEditable(false);
      }
           if (e.getSource().equals(formServicio.getBtnRegresar()))  
      {  
        formServicio.dispose();
      }
             if (e.getSource().equals(formServicio.getBtnGrabar()))  
      {  
        Grabar();
      }
               
    }


}
