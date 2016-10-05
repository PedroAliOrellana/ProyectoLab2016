package Controlador;

import Librerias.Validaciones;
import Modelo.Lista;
import Modelo.Usuario;
import Vista.JFrameGuardarUsuario;
import Vista.JFrameUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;


public class ControladorGuardarUsuario implements ActionListener
{
    private JFrameGuardarUsuario formUsuario;
    private Lista ListaUsuario;
    private JFrameUsuario formU;

    public ControladorGuardarUsuario(Lista gu) 
    {
        ListaUsuario = gu;
        formUsuario = new JFrameGuardarUsuario();
        formUsuario.agregarListener(this);
        formUsuario.setVisible(true);
        formUsuario.getTxtNombreUsuario().requestFocusInWindow();
        DeshabilitarControles();
            
        
        //---Zona de los listener
        
        formUsuario.getTxtNombreUsuario().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,14,formUsuario.getTxtNombreUsuario().getText()); 
                ValidarSoloLetras(e);
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
              {             
                  NombreUsuarioKeyPressed(e);
              }

       }
    );          
     //----------------------------------------
    formUsuario.getTxtPasw().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,11,formUsuario.getTxtPasw().getText());  
              }
            public void keyPressed(KeyEvent e) 
              {             
                  EnterKeyPressed(e,formUsuario.getTxtPasw().requestFocusInWindow());
              }
                 
       }
      );       
    
        formUsuario.getTxtConfPasw().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,11,formUsuario.getTxtConfPasw().getText()); 
              }
            
               public void keyPressed(KeyEvent e) 
              {             
                  EnterKeyPressed(e,formUsuario.getTxtConfPasw().requestFocusInWindow());
              }
                 
       }
      ); 
          formUsuario.getCmbNivelA().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                
              }
                 
            @Override
            public void keyPressed(KeyEvent e) 
              {             
                  if (e.getKeyChar()==10)
                   formUsuario.getBtnGrabar().requestFocusInWindow();    
              }

       }
    );     
          
    }

   
    
  private void ActivarControles()
  {
    formUsuario.getTxtPasw().setEditable(true);
    formUsuario.getTxtConfPasw().setEditable(true);
    formUsuario.getCmbNivelA().setEditable(false);
    formUsuario.getCmbNivelA().setEnabled(true);
    formUsuario.getTxtNombreUsuario().setEditable(false);
    formUsuario.getBtnGrabar().setEnabled(true);
    formUsuario.getLblConfPasw().setVisible(true);
    formUsuario.getLblPasw().setVisible(true);
    formUsuario.getTxtConfPasw().setVisible(true);
    formUsuario.getTxtPasw().setVisible(true);
    formUsuario.getBtnGrabar().requestFocusInWindow();
  }  
   
   private void DeshabilitarControles()
  {
    formUsuario.getTxtPasw().setEditable(false);
    formUsuario.getTxtConfPasw().setEditable(false);
    formUsuario.getCmbNivelA().setEditable(false);
    formUsuario.getCmbNivelA().setEnabled(false);
    formUsuario.getTxtNombreUsuario().setEditable(true);
    formUsuario.getBtnGrabar().setEnabled(false);
  }  
   
   
    private void CargarDatos(int p)
    {
        Usuario u = ListaUsuario.getListaUsuario().get(p);
        
        formUsuario.getTxtNombreUsuario().setEditable(false);
        formUsuario.getBtnGrabar().setEnabled(true);
        
        formUsuario.getTxtPasw().setText(u.getContrasena());
        formUsuario.getTxtConfPasw().setText(u.getContrasena());
        formUsuario.getCmbNivelA().setSelectedItem(u.getNivelAcceso());
        
    }
    
     private void NombreUsuarioKeyPressed(KeyEvent e)
    {
        String Cadena;
        Integer Posi;
        Cadena = formUsuario.getTxtNombreUsuario().getText().trim();
        if (e.getKeyChar()==10 && (Cadena.length()>3 && Cadena.length()<15))
        {
            Posi= ListaUsuario.BuscarUsuario(Cadena);
            if(Posi==-1)
            {
                int resp;
                resp = JOptionPane.showConfirmDialog(null, "El Usuario no esta registrado, ¿Desea registrarlo?","Registro",JOptionPane.YES_NO_OPTION);
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
                ActivarControles();
                formUsuario.getTxtConfPasw().setVisible(false);
                formUsuario.getTxtPasw().setVisible(false);
                formUsuario.getLblConfPasw().setVisible(false);
                formUsuario.getLblPasw().setVisible(false);
                formUsuario.getCmbNivelA().requestFocusInWindow();
                CargarDatos(Posi);
            }
        }
}
     
    private void EnterKeyPressed(KeyEvent e,Boolean txt)
   {
        if (e.getKeyChar()==10)
            txt=true;
   }
    
    private Boolean Verificar()
    {
        JFrameGuardarUsuario u = formUsuario;
        if(u.getTxtNombreUsuario().getText().length()==0)
        {
            Validaciones.Aviso("Nombre Usuario Vacio", "Atención");   
            formUsuario.getTxtNombreUsuario().requestFocusInWindow();
            return false;
        }
        if (u.getTxtPasw().getText().trim().length()==0)
       {
            Validaciones.Aviso("Contraseña Vacia", "Atención");   
            formUsuario.getTxtPasw().requestFocusInWindow();
            return false;
       }
    
        if (u.getTxtConfPasw().getText().trim().length()==0)
        {
            Validaciones.Aviso("Confirmar contraseña Vacio", "Atención");   
            formUsuario.getTxtConfPasw().requestFocusInWindow();
            return false;
        }  
        if (!u.getTxtConfPasw().getText().trim().equals(formUsuario.getTxtPasw().getText().trim()))
        {
            Validaciones.Aviso("Contraseñas direfentes", "Atención");   
            formUsuario.getTxtPasw().requestFocusInWindow();
            return false;
        }  
            if (u.getCmbNivelA().getSelectedIndex()==0)
        {
            Validaciones.Aviso("Nivel de Acceso Vacio", "Atención");   
            formUsuario.getCmbNivelA().requestFocusInWindow();
            return false;
        }  
        return true;
    }
    //------------zona de los botones-------------------------
  
  private void Limpiar()    
{
  formUsuario.getTxtConfPasw().setText("");  
  formUsuario.getTxtPasw().setText("");
  formUsuario.getTxtNombreUsuario().setText("");
  formUsuario.getCmbNivelA().setSelectedIndex(0);
  formUsuario.getLblConfPasw().setVisible(true);
  formUsuario.getLblPasw().setVisible(true);
  formUsuario.getTxtConfPasw().setVisible(true);
  formUsuario.getTxtPasw().setVisible(true);
  DeshabilitarControles();
}
  
  private void Grabar()
    {
        int posi;
        Usuario us;
        if (Verificar())
        {
            posi=ListaUsuario.BuscarUsuario(formUsuario.getTxtNombreUsuario().getText());
            if(posi==-1)
            {
                us= new Usuario(formUsuario.getTxtNombreUsuario().getText(),
                                formUsuario.getTxtPasw().getText(),
                                formUsuario.getCmbNivelA().getSelectedItem().toString());
                                  
                ListaUsuario.getListaUsuario().add(us);
                Validaciones.Confirmacion("Guardado correctamente", "Datos almacenados");
                DeshabilitarControles();
                Limpiar();              
            }
            else
            {               
                ActivarControles();
                ListaUsuario.getListaUsuario().get(posi).setNivelAcceso(formUsuario.getCmbNivelA().getSelectedItem().toString());
                Validaciones.Confirmacion("Datos Actualizados correctamente","Atención" );
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
        if (e.getSource().equals(formUsuario.getBtnCancelar()))  
      {  
        Limpiar();  
      }   
        if (e.getSource().equals(formUsuario.getBtnRegresar()))  
      {  
        formUsuario.dispose();
        new ControladorUsuario(ListaUsuario);       
      }
        if (e.getSource().equals(formUsuario.getBtnGrabar()))  
      {  
        Grabar();
      }
        
    }
    
}
