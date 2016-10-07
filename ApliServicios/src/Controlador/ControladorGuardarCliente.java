
package Controlador;
import Vista.JFrameGuardaCliente;
import Modelo.Lista;
import Modelo.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;


public class ControladorGuardarCliente implements ActionListener
{
    private JFrameGuardaCliente  formGuardarCliente;
    private Lista  ListaCliente;
    
    public ControladorGuardarCliente()
    {
        ListaCliente =new Lista();
        formGuardarCliente = new JFrameGuardaCliente();
        formGuardarCliente.agregarListener(this);
        formGuardarCliente.setVisible(true);
        
    formGuardarCliente.getTxtRif().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,10,formGuardarCliente.getTxtRif().getText()); 
                
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
              {             
              }

       }
    );          
     //----------------------------------------
    formGuardarCliente.getTxtRazonSocial().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,30,formGuardarCliente.getTxtRazonSocial().getText()); 
                ValidarSoloLetras(e);
              }
                 
       }
      );       
    
        formGuardarCliente.getTxtDirreccion().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,40,formGuardarCliente.getTxtDirreccion().getText()); 
                
               }
                 
       }
      ); 
            formGuardarCliente.getTxtTelefono().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,11,formGuardarCliente.getTxtTelefono().getText()); 
                
               }
                 
       }
      ); 
                formGuardarCliente.getTxtCorreo().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,30,formGuardarCliente.getTxtCorreo().getText()); 
                
               }
                 
       }
      );    
        
    }
    //-----------ActivarDeshabilitarControles----------------
    
    private void ActivarControles()
    {
        formGuardarCliente.getTxtRif().setEditable(false);
        formGuardarCliente.getTxtRazonSocial().setEditable(false);
        formGuardarCliente.getTxtDirreccion().setEditable(false);
        formGuardarCliente.getTxtTelefono().setEditable(false);
        formGuardarCliente.getTxtCorreo().setEditable(false);
        formGuardarCliente.getBtnGrabar().setEnabled(true);
        formGuardarCliente.getBtnCancelar().setEnabled(true);
   
       
    }
    private void DeshabilitarControles()
    {
        formGuardarCliente.getTxtRif().setEditable(true);
        formGuardarCliente.getTxtDirreccion().setEditable(false);
        formGuardarCliente.getTxtTelefono().setEditable(false);
        formGuardarCliente.getTxtCorreo().setEditable(false);
        formGuardarCliente.getBtnGrabar().setEnabled(false);
    }
   private void CargarDatos(int p)
    {
        
        Cliente e = ListaCliente.getListaCliente().get(p);
       
        formGuardarCliente.getTxtRif().setEnabled(true);
        formGuardarCliente.getBtnModificar().setEnabled(true);
        formGuardarCliente.getTxtRazonSocial().setText(e.getRazonSocial());
        formGuardarCliente.getTxtDirreccion().setText(e.getDireccion());
        formGuardarCliente.getTxtTelefono().setText(e.getTelefono());
        formGuardarCliente.getTxtCorreo().setText(e.getCorreo());
        
        
    }
    //-----------TxtCodigoEventoEnter-----------
    
    private void CodigokeyPressed(KeyEvent e)
    {
        String Cadena;
        Integer Posi;
        Cadena = formGuardarCliente.getTxtRif().getText().trim();
        if (e.getKeyChar()==10 && (Cadena.length()>4))
        {
            Posi= ListaCliente.BuscarCliente(Cadena);
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
        JFrameGuardaCliente e = formGuardarCliente;
        if(e.getTxtRazonSocial().getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "la direccion  esta en blanco","Atención",JOptionPane.WARNING_MESSAGE);
            formGuardarCliente.getTxtRazonSocial().requestFocusInWindow();
            return false;
        }
         if(e.getTxtDirreccion().getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "la direccion  esta en blanco","Atención",JOptionPane.WARNING_MESSAGE);
            formGuardarCliente.getTxtDirreccion().requestFocusInWindow();
            return false;
        }
         if(e.getTxtTelefono().getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "la direccion  esta en blanco","Atención",JOptionPane.WARNING_MESSAGE);
            formGuardarCliente.getTxtTelefono().requestFocusInWindow();
            return false;
        }
         if(e.getTxtCorreo().getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "la direccion  esta en blanco","Atención",JOptionPane.WARNING_MESSAGE);
            formGuardarCliente.getTxtCorreo().requestFocusInWindow();
            return false;
        }
        
    
          return true;
    }
    
    
    
//-------------------Botones de servicios------------------
    private void Limpiar()
{ 
    formGuardarCliente.getTxtRif().setText("");
    formGuardarCliente.getTxtRazonSocial().setText("");
    formGuardarCliente.getTxtDirreccion().setText("");
    formGuardarCliente.getTxtTelefono().setText("");
    formGuardarCliente.getTxtCorreo().setText("");
   
}
 private void Grabar()
 {
   int posi;
       Cliente  cliente;
        if (Verificar())
        {
            posi=ListaCliente.BuscarCliente(formGuardarCliente.getTxtRif().getText());
            if(posi==-1)
            {
               cliente =  new Cliente (formGuardarCliente.getTxtRif().getText(),
                                       formGuardarCliente.getTxtRazonSocial().getText(),
                                       formGuardarCliente.getTxtDirreccion().getText(),
                                       formGuardarCliente.getTxtTelefono().getText(),
                                       formGuardarCliente.getTxtCorreo().getText());
                      
               ListaCliente.getListaCliente().add(cliente);
             
                JOptionPane.showMessageDialog(null," Guardado Correctamente","Datos almacenados",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                DeshabilitarControles();
                Limpiar();              
            }
            else
            {               
                ListaCliente.getListaCliente().get(posi).setRazonSocial(formGuardarCliente.getTxtRazonSocial().getText());
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
          if (e.getSource().equals(formGuardarCliente.getBtnCancelar()))  
      {  
        Limpiar();  
        
      }
           if (e.getSource().equals(formGuardarCliente.getBtnRegresar()))  
      {  
        formGuardarCliente.dispose();
      }
             if (e.getSource().equals(formGuardarCliente.getBtnGrabar()))  
      {  
        Grabar();
      }
               if(e.getSource().equals(formGuardarCliente.getBtnModificar()))
        {
            formGuardarCliente.getBtnGrabar().setEnabled(true);
            
            ActivarControles();
            formGuardarCliente.getTxtRif().setEditable(false);
            formGuardarCliente.getBtnModificar().setEnabled(false);
        }
    }


}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

