
package Controlador;

import Librerias.Validaciones;

import Modelo.Lista;
import Modelo.Motivo;
import Vista.JFrameGuardarMotivo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class ControladorGuardarMotivo implements ActionListener
{
    private JFrameGuardarMotivo formMotivo;
    private Lista ListaMotivo;  
    
     
public ControladorGuardarMotivo(Lista lisMo)
        
{       ListaMotivo= lisMo;
        formMotivo = new JFrameGuardarMotivo();
        formMotivo.agregarListener(this);
        formMotivo.setVisible(true);
        DeshabilitarControles();
        
          formMotivo.getTxtCodigo().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,4,formMotivo.getTxtCodigo().getText()); 
               
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
              {  
                  CodigokeyPressed(e);
              }

       }
    );          
     //----------------------------------------
    formMotivo.getTxtDesc().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,11,formMotivo.getTxtDesc().getText()); 
                 ValidarSoloLetras(e);
              }
                 
       }
      );
    

}
//-----------ActivarDeshabilitarControles----------------
    
    private void ActivarControles()
    {
        formMotivo.getTxtCodigo().setEditable(false);
        formMotivo.getTxtDesc().setEditable(true);
        formMotivo.getBtnCancelar().setEnabled(true);
        formMotivo.getBtnGuardar().setEnabled(true);
       
    }
    private void DeshabilitarControles()
            
    {
        formMotivo.getTxtCodigo().setEditable(true);
        formMotivo.getTxtDesc().setEditable(false);
        formMotivo.getBtnGuardar().setEnabled(false);
    }
   private void CargarDatos(int p)
    {
        Motivo e = ListaMotivo.getListaMotivo().get(p);
        
        formMotivo.getTxtCodigo().setEnabled(false);
        
  
        formMotivo.getBtnModificar().setEnabled(true);
        formMotivo.getTxtDesc().setText(e.getDescMotivo());
        
    }
    //-----------TxtCedulaEventoEnter-----------
    
    private void CodigokeyPressed(KeyEvent e)
    {
        String Cadena;
        Integer Posi;
        Cadena = formMotivo.getTxtCodigo().getText().trim();
        if (e.getKeyChar()==10 && (Cadena.length()>4))
        {
            Posi= ListaMotivo.BuscarMotivo(Cadena);
            if(Posi==-1)
            {
                int resp;
                resp = JOptionPane.showConfirmDialog(null, "El Motivo no esta registrado, ¿Desea registrarlo?","Registro",JOptionPane.YES_NO_OPTION);
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
        JFrameGuardarMotivo e = formMotivo;
        if(e.getTxtDesc().getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "la direccion  esta en blanco","Atención",JOptionPane.WARNING_MESSAGE);
            formMotivo.getTxtDesc().requestFocusInWindow();
            return false;
        }
        
    
          return true;
    }

//-------Botones-------------------------
   public void Limpiar()
   {
     formMotivo.getTxtCodigo().setText("");
     formMotivo.getTxtDesc().setText("");
  
   }
public void Grabar()

{
   int posi;
        Motivo motivo;
        if (Verificar())
        {
            posi=ListaMotivo.BuscarMotivo(formMotivo.getTxtCodigo().getText());
            if(posi==-1)
            {
               motivo= new Motivo(formMotivo.getTxtCodigo().getText(),
                                  formMotivo.getTxtDesc().getText());
                       
                  
                ListaMotivo.getListaMotivo().add(motivo);
               
                JOptionPane.showMessageDialog(null," Guardado Correctamente","Datos almacenados",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                DeshabilitarControles();
                Limpiar();              
            }
            else
            {               
                ListaMotivo.getListaMotivo().get(posi).setDescMotivo(formMotivo.getTxtDesc().getText());
   
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
          if (e.getSource().equals(formMotivo.getBtnCancelar()))  
      {  
        Limpiar(); 
       
      } 
       if (e.getSource().equals(formMotivo.getBtnRegresar()))  
      {  
        formMotivo.dispose();
      }
          if (e.getSource().equals(formMotivo.getBtnGuardar()))  
      {  
        Grabar();
    }
          if(e.getSource().equals(formMotivo.getBtnModificar()))
        {
            formMotivo.getBtnGuardar().setEnabled(true);
 
            ActivarControles();
            formMotivo.getTxtCodigo().setEditable(false);
    
            formMotivo.getBtnModificar().setEnabled(false);
        }
}
}