
package Controlador;
 import Vista.JFrameHerramienta;
 import Modelo.Lista;
 import Modelo.Herramienta;
 import Modelo. *;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class ControladorGuardarHerramienta implements ActionListener
{
    private final  JFrameHerramienta formHerramienta;
    private final Lista ListaHerramienta;

    @SuppressWarnings("LeakingThisInConstructor")
     
    public ControladorGuardarHerramienta(Lista listh)   
    {
        ListaHerramienta = listh;
        formHerramienta = new JFrameHerramienta();
        formHerramienta.agregarListener(this);
        formHerramienta.setVisible(true);
        
        
        
          
        formHerramienta.getTxtCodHerramienta().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,4,formHerramienta.getTxtCodHerramienta().getText()); 
               
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
              {   
                   CodigokeyPressed(e);
              }

       }
    );          
     //----------------------------------------
    formHerramienta.getTxtDescHerramienta().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,30,formHerramienta.getTxtDescHerramienta().getText()); 
                 ValidarSoloLetras(e);
              }
                 
       }
      );       
    
     formHerramienta.getTxtDescHerramienta().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,20,formHerramienta.getTxtMarca().getText()); 
                 ValidarSoloLetras(e);
              }
                 
       }
      );       
   
    
    }
    
    
    
    
    //-----------TxtCodigoEventoEnter-----------
    
    private void CodigokeyPressed(KeyEvent e)
    {
        String Cadena;
        Integer Posi;
        Cadena = formHerramienta.getTxtCodHerramienta().getText().trim();
        if (e.getKeyChar()==10 && (Cadena.length()>4))
        {
            Posi= ListaHerramienta.BuscarHerramienta(Cadena);
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
     //-----------ActivarDeshabilitarControles----------------
    
    private void ActivarControles()
    {
        formHerramienta.getTxtCodHerramienta().setEditable(false);
        formHerramienta.getTxtDescHerramienta().setEditable(true);
        formHerramienta.getBtnGrabar().setEnabled(true);
        formHerramienta.getBtnCancelar().setEnabled(true);
   
       
    }
    private void DeshabilitarControles()
    {
        formHerramienta.getTxtCodHerramienta().setEditable(true);
        formHerramienta.getTxtDescHerramienta().setEditable(false);
        formHerramienta.getBtnGrabar().setEnabled(false);
        formHerramienta.getBtnRegresar().setVisible(true);
        formHerramienta.getTxtCodHerramienta().setEditable(true);
        formHerramienta.getTxtDescHerramienta().setEditable(false);
        formHerramienta.getTxtMarca().setEditable(false);
        formHerramienta.getTxtCodHerramienta().requestFocusInWindow();
        
    }
   private void CargarDatos(int p)
    {
        Herramienta e = ListaHerramienta.getListaHerramienta().get(p);
        formHerramienta.getTxtCodHerramienta().setEnabled(false);
        formHerramienta.getBtnModificar().setEnabled(true);
        formHerramienta.getTxtDescHerramienta().setText(e.getDescHerramienrta());
        formHerramienta.getTxtMarca().setText(e.getMarca());
        
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
      private Boolean Verificar()
    {
        JFrameHerramienta e = formHerramienta;
        if(e.getTxtDescHerramienta().getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "la direccion  esta en blanco","Atención",JOptionPane.WARNING_MESSAGE);
            formHerramienta.getTxtDescHerramienta().requestFocusInWindow();
            return false;
        }
        
    
          return true;
    }
    
    //-----------------------Botonee-------------------------
        private void Limpiar()
       {
           formHerramienta.getTxtCodHerramienta().setText("");
           formHerramienta.getTxtDescHerramienta().setText("");
           formHerramienta.getTxtMarca().setText("");
           formHerramienta.getTxtCodHerramienta().setEnabled(true);
           formHerramienta.getTxtCodHerramienta().requestFocusInWindow();
       }     
    
       private void Grabar()
       {
           int posi;
        Herramienta herramienta;
        if (Verificar())
        {
            posi=ListaHerramienta.BuscarHerramienta(formHerramienta.getTxtCodHerramienta().getText());
            if(posi==-1)
            {
               herramienta= new Herramienta(formHerramienta.getTxtCodHerramienta().getText(),
                                      formHerramienta.getTxtDescHerramienta().getText(),
                                      formHerramienta.getTxtMarca().getText());
                      
               ListaHerramienta.getListaHerramienta().add(herramienta);
             
                JOptionPane.showMessageDialog(null," Guardado Correctamente","Datos almacenados",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                DeshabilitarControles();
                Limpiar();              
            }
            else
            {               
                ListaHerramienta.getListaHerramienta().get(posi).setDescHerramienrta(formHerramienta.getTxtDescHerramienta().getText());
                ListaHerramienta.getListaHerramienta().get(posi).setMarca(formHerramienta.getTxtMarca().getText());
                JOptionPane.showMessageDialog(null,"Datos Actualizados Correctamente","Información Actualizada",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                DeshabilitarControles();
                Limpiar(); 
            }
        }     
       }
   
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
          if (e.getSource().equals(formHerramienta.getBtnCancelar()))  
      {  
        Limpiar();  
        formHerramienta.getTxtCodHerramienta().setEditable(true);
        formHerramienta.getTxtDescHerramienta().setEditable(false);
      }
           if (e.getSource().equals(formHerramienta.getBtnRegresar()))  
      {  
        formHerramienta.dispose();
      }
             if (e.getSource().equals(formHerramienta.getBtnGrabar()))  
      {  
        Grabar();
      }
               if(e.getSource().equals(formHerramienta.getBtnModificar()))
        {
            formHerramienta.getBtnGrabar().setEnabled(true);
            
            ActivarControles();
            formHerramienta.getTxtCodHerramienta().setEditable(false);
            formHerramienta.getBtnModificar().setEnabled(false);
        }
    }
    

   
}
