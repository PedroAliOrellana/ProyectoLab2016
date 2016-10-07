
package Controlador;

import Librerias.Validaciones;
import Modelo.*;
import Vista.JFrameGuardarVehiculo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

public class ControladorGuardarVehiculo implements ActionListener,KeyListener
{
    private JFrameGuardarVehiculo formVehiculo;
    private Lista ListaVehiculo;

    public ControladorGuardarVehiculo(Lista lisV) 
    {
        ListaVehiculo = lisV;
        formVehiculo = new JFrameGuardarVehiculo();
        formVehiculo.agregarListener(this);
        formVehiculo.setVisible(true);
        DeshabilitarControles(); 
     
                //Zona de los KeyListener
             formVehiculo.getTxtMarca().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,10,formVehiculo.getTxtMarca().getText()); 
                ValidarSoloLetras(e);
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
              {             
              }

       }
    ); 
       
          formVehiculo.getTxtModelo().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
               ValidarTxt(e,10,formVehiculo.getTxtModelo().getText()); 
                ValidarSoloLetras(e);
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
               {   
              }
       }
      );  
          
          formVehiculo.getTxtPlaca().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
               ValidarTxt(e,6,formVehiculo.getTxtPlaca().getText()); 
           
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
               {
                   PlacakeyPressed(e);   
              }
       }
      );     
        
         formVehiculo.getTxtCapacidad().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
               ValidarTxtNum(e,1,formVehiculo.getTxtCapacidad().getText()); 
               
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
               {   
              }
       }
      ); 
         
         
    }
//-----------------------------------
    
    private void DeshabilitarControles()
    {
             formVehiculo.getBtnCancelar1().setEnabled(true);
            formVehiculo.getBtnEliminar().setEnabled(false);
            formVehiculo.getBtnModificar().setEnabled(false);
            formVehiculo.getBtnGrabar().setEnabled(false);        
            formVehiculo.getBtnRegresar().setVisible(true); 
            formVehiculo.getTxtPlaca().setEditable(true);
            formVehiculo.getTxtMarca().setEditable(false);
            formVehiculo.getTxtCapacidad().setEditable(false);
            formVehiculo.getTxtModelo().setEditable(false);
            formVehiculo.getTxtPlaca().requestFocusInWindow();
             formVehiculo.getBtnEliminar().setEnabled(false);
    }
      private void ActivarControles()
    {
        formVehiculo.getTxtPlaca().setEditable(true);
        formVehiculo.getTxtMarca().setEditable(true);
        formVehiculo.getTxtCapacidad().setEditable(true);
        formVehiculo.getTxtModelo().setEditable(true);
        formVehiculo.getBtnGrabar().setEnabled(true);
        formVehiculo.getBtnCancelar1().setEnabled(true);
       
    }
   //---------------------------------
     private void CargarDatos(int p)
    {
        Vehiculo e = ListaVehiculo.getListaVehiculo().get(p);
        
        formVehiculo.getTxtPlaca().setEditable(false);
        formVehiculo.getBtnModificar().setEnabled(true);
        formVehiculo.getBtnEliminar().setEnabled(true);
        formVehiculo.getTxtMarca().setText(e.getMarca());
        formVehiculo.getTxtCapacidad().setText(e.getCapacidad());
        formVehiculo.getTxtModelo().setText(e.getModelo());
        
    }
     //-------------------------------------------------
     private void Limpiar()    
{
  formVehiculo.getTxtMarca().setText("");  
  formVehiculo.getTxtCapacidad().setText("");
  formVehiculo.getTxtModelo().setText("");
  formVehiculo.getTxtPlaca().setText("");
  formVehiculo.getTxtPlaca().setEditable(true);
  formVehiculo.getBtnModificar().setEnabled(false);
  formVehiculo.getTxtPlaca().requestFocusInWindow();
   formVehiculo.getBtnEliminar().setEnabled(false);
  
}
  //-----------TxtCedulaEventoEnter-----------
    
    private void PlacakeyPressed(KeyEvent e)
    {
        String Cadena;
        Integer Posi;
        Cadena = formVehiculo.getTxtPlaca().getText().trim();
        if (e.getKeyChar()==10 && (Cadena.length()>6 && Cadena.length()<9))
        {
            Posi= ListaVehiculo.BuscarVehiculo(Cadena);
            if(Posi==-1)
            {
                int resp;
                resp = JOptionPane.showConfirmDialog(null, "El Vehiculo no esta registrado, ¿Desea registrarlo?","Registro",JOptionPane.YES_NO_OPTION);
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
    
  private  Boolean Verificar()
  {
      Vehiculo vehiculo;
      int existe;
      String Cadena, Marca, Modelo, Placa, Capacidad;
    
      Cadena=formVehiculo.getTxtPlaca().getText().trim();
    
    if (Cadena.length()==0)
     {
       Validaciones.Aviso("Indique la Placa", "");   
       formVehiculo.getTxtPlaca().requestFocusInWindow();
       return false;
     }  
    Cadena=formVehiculo.getTxtMarca().getText().trim();
    
    if (Cadena.length()==0)
     {
       Validaciones.Aviso("Indique la Marca", "");   
       formVehiculo.getTxtMarca().requestFocusInWindow();
       return false;
     }  
    
    Cadena=formVehiculo.getTxtCapacidad().getText().trim();
    if (Cadena.length()==0)
     {
       Validaciones.Aviso("Indique la Capacidad", "");   
       formVehiculo.getTxtCapacidad().requestFocusInWindow();
       return false;
     }  
  
    
    Cadena=formVehiculo.getTxtModelo().getText().trim();
    
    if (Cadena.length()==0)
     {
       Validaciones.Aviso("Indique el Modelo", "");   
       formVehiculo.getTxtModelo().requestFocusInWindow();
       return false;
     }
     return true;
   }
   
     //--------------Grabar------------------------
    
    private void Grabar()
    {
        int posi;
        Vehiculo veh;
        if (Verificar())
        {
            posi=ListaVehiculo.BuscarVehiculo(formVehiculo.getTxtPlaca().getText());
            if(posi==-1)
            {
                veh= new Vehiculo(formVehiculo.getTxtPlaca().getText(),
                formVehiculo.getTxtModelo().getText(),
                formVehiculo.getTxtCapacidad().getText(),
                formVehiculo.getTxtMarca().getText(),
                formVehiculo.getTxtMarca().getText()); 
                ListaVehiculo.getListaVehiculo().add(veh);
                JOptionPane.showMessageDialog(null,"Vehiculo Guardado Correctamente","Datos almacenados",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                DeshabilitarControles();
                Limpiar();              
            }
            else
            {               
                ListaVehiculo.getListaVehiculo().get(posi).setMarca(formVehiculo.getTxtMarca().getText());
                ListaVehiculo.getListaVehiculo().get(posi).setCapacidad(formVehiculo.getTxtCapacidad().getText());
                ListaVehiculo.getListaVehiculo().get(posi).setModelo(formVehiculo.getTxtModelo().getText());
                
              
                //ListaEmpleado.getListaEmpleado().get(posi).setCargo(formEmpleado.getcmbCargo().getSelectedItem().toString());
                JOptionPane.showMessageDialog(null,"Datos Actualizados Correctamente","Información Actualizada",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                DeshabilitarControles();
                Limpiar(); 
            }
        }        
    }
    //-------------Eliminar----------------------
     private void Eliminar()
    {
        int resp,posi;
        resp = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar Vehiculo: " + formVehiculo.getTxtPlaca().getText()+"?","Eliminar",JOptionPane.YES_NO_OPTION);
        if(resp==0)
        {               
            posi = ListaVehiculo.BuscarVehiculo(formVehiculo.getTxtPlaca().getText());
            ListaVehiculo.getListaVehiculo().remove(posi);
            Limpiar();
            JOptionPane.showMessageDialog(null, "Vehiculo eliminado");
            DeshabilitarControles();            
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
        if (e.getSource().equals(formVehiculo.getBtnCancelar1()))  
      {  
        Limpiar();  
      }   
        if (e.getSource().equals(formVehiculo.getBtnRegresar()))  
      {  
        formVehiculo.dispose();
      }
        if (e.getSource().equals(formVehiculo.getBtnGrabar()))  
      {  
        Grabar();
      }
        if(e.getSource().equals(formVehiculo.getBtnEliminar()))
      {
            Eliminar();
      }
        if(e.getSource().equals(formVehiculo.getBtnModificar()))
      {
            formVehiculo.getBtnGrabar().setEnabled(true);
            ActivarControles();
            formVehiculo.getTxtPlaca().setEditable(false);
            formVehiculo.getBtnModificar().setEnabled(false);
      }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

   