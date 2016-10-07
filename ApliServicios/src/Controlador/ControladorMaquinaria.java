
package Controlador;

import Librerias.Validaciones;
import Modelo.Empleado;
import Modelo.Lista;
import Modelo.Maquinaria;
import Vista.JFrameEmpleado;
import Vista.JFrameMaquinaria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

public class ControladorMaquinaria implements ActionListener,KeyListener
{
    private JFrameMaquinaria formMaquinaria;
    private Lista ListaMaquinaria;

    public ControladorMaquinaria(Lista lisMaq) 
    {
        ListaMaquinaria =lisMaq;
        formMaquinaria=new JFrameMaquinaria();
        formMaquinaria.agregarListener(this);
        formMaquinaria.setVisible(true);
        DeshabilitarControles();
        
        formMaquinaria.getTxtPlaca1().addKeyListener(new KeyAdapter()
         {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidarTxt(e,6,formMaquinaria.getTxtPlaca1().getText()); 
               }
            //-----------
            @Override
            public void keyPressed (KeyEvent e)
              {     
                 PlacakeyPressed(e); 
              }
         }
       );
        formMaquinaria.getTxtMarca().addKeyListener(new KeyAdapter()
         {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidarTxt(e,19,formMaquinaria.getTxtMarca().getText()); 
               }
            //-----------
            @Override
            public void keyPressed (KeyEvent e)
              {     
                 
              }
         }
       );
        formMaquinaria.getTxtPesoMax().addKeyListener(new KeyAdapter()
         {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidarTxtNum(e,4,formMaquinaria.getTxtPesoMax().getText()); 
               }
            //-----------
            @Override
            public void keyPressed (KeyEvent e)
              {     
                 //CodigokeyPressed(e); 
              }
         }
       );
        formMaquinaria.getTxtModelo1().addKeyListener(new KeyAdapter()
         {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidarTxt(e,19,formMaquinaria.getTxtModelo1().getText()); 
               }
            //-----------
            @Override
            public void keyPressed (KeyEvent e)
              {     
                 //CedulakeyPressed(e); 
              }
         }
       );
        
    }
    
      private void ValidarTxt(KeyEvent e,int largo,String txt) 
    {
        if (txt.length()>largo){
            e.consume();
        }
    }
    
        private void ValidarTxtNum(KeyEvent e,int largo,String txt) 
    {
        if (txt.length()>largo){
            e.consume();
            return;
    }
    char Digito;
    Digito=e.getKeyChar();
    if (Digito<'0' || Digito >'9')
    e.consume();
    }

        
    //------EventoKeyPress---------
    private void PlacakeyPressed(KeyEvent e)
    {
        String Cadena;
        Integer Posi,resp;
        Cadena = formMaquinaria.getTxtPlaca1().getText().trim();
        if (e.getKeyChar()==10 && (Cadena.length()>5 && Cadena.length()<8))
        {
            Posi = ListaMaquinaria.BuscarMaquinaria(formMaquinaria.getTxtPlaca1().getText());
            if(Posi==-1)
            {
               resp = JOptionPane.showConfirmDialog(null, "La maquinaria no esta registrada, ¿Desea registrarla?","Registro",JOptionPane.YES_NO_OPTION);
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
                
            }
        }
    }
    
     private Boolean Verificar()
    {
        JFrameMaquinaria e = formMaquinaria;
        if(e.getTxtMarca().getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "Marca esta en blanco","Atención",JOptionPane.WARNING_MESSAGE);
            formMaquinaria.getTxtMarca().requestFocusInWindow();
            return false;
        }
        if(e.getTxtModelo1().getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "Modelo esta en blanco","Atención",JOptionPane.WARNING_MESSAGE);
            formMaquinaria.getTxtModelo1().requestFocusInWindow();
            return false;
        }
        if(e.getTxtPesoMax().getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "Peso Maximo esta en blanco","Atención",JOptionPane.WARNING_MESSAGE);
            formMaquinaria.getTxtPesoMax().requestFocusInWindow();
            return false;
        }
        return true;
    }
    
     //--------------Grabar------------------------
    
    private void Grabar()
    {
        int posi;
        Maquinaria maq;
        if (Verificar())
        {
            posi=ListaMaquinaria.BuscarMaquinaria(formMaquinaria.getTxtPlaca1().getText());
            if(posi==-1)
            {
                maq= new Maquinaria(formMaquinaria.getTxtPlaca1().getText(),
                formMaquinaria.getTxtModelo1().getText(),
                formMaquinaria.getTxtMarca().getText(),
                formMaquinaria.getTxtPesoMax().getText(),
                "");
                ListaMaquinaria.getListaMaquinaria().add(maq);
                JOptionPane.showMessageDialog(null,"Maquinaria Guardada Correctamente","Datos almacenados",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                DeshabilitarControles();
     
                Limpiar();              
            }
            else
            {    
                
                formMaquinaria.getBtnModificar().setEnabled(true);
                formMaquinaria.getBtnEliminar().setEnabled(true);
                ListaMaquinaria.getListaMaquinaria().get(posi).setMarca(formMaquinaria.getTxtMarca().getText());
                ListaMaquinaria.getListaMaquinaria().get(posi).setModelo(formMaquinaria.getTxtModelo1().getText());
                ListaMaquinaria.getListaMaquinaria().get(posi).setPesoMax(formMaquinaria.getTxtPesoMax().getText());
                //ListaEmpleado.getListaEmpleado().get(posi).setCargo(formEmpleado.getcmbCargo().getSelectedItem().toString());
                JOptionPane.showMessageDialog(null,"Datos Actualizados Correctamente","Información Actualizada",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                DeshabilitarControles();
                Limpiar(); 
            }
        }        
    }
    
     private void Limpiar() 
    {
      formMaquinaria.getTxtMarca().setText("");
      formMaquinaria.getTxtModelo1().setText("");
      formMaquinaria.getTxtPesoMax().setText("");
      formMaquinaria.getTxtPlaca1().setText("");
      formMaquinaria.getTxtPlaca1().requestFocusInWindow();
    }
    
        private void ActivarControles()
    {
        formMaquinaria.getTxtMarca().setEditable(true);
        formMaquinaria.getTxtModelo1().setEditable(true);
        formMaquinaria.getTxtPesoMax().setEditable(true);
        formMaquinaria.getTxtPlaca1().setEditable(false);
        formMaquinaria.getBtnGrabar().setEnabled(true);
        
        formMaquinaria.getBtnGrabar().setEnabled(true);
    }
    
    private void DeshabilitarControles()
    {
        formMaquinaria.getTxtMarca().setEditable(false);
        formMaquinaria.getTxtModelo1().setEditable(false);
        formMaquinaria.getTxtPesoMax().setEditable(false);
        formMaquinaria.getTxtPlaca1().setEditable(true);
        formMaquinaria.getBtnModificar().setEnabled(false);
        formMaquinaria.getBtnEliminar().setEnabled(false);
        formMaquinaria.getBtnGrabar().setEnabled(false);
        
        formMaquinaria.getTxtPlaca1().requestFocusInWindow();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource().equals(formMaquinaria.getBtnGrabar()))
        {
            Grabar();
        }
        if(ae.getSource().equals(formMaquinaria.getBtnCancelar1()))
        {
            DeshabilitarControles();
            Limpiar();
        }
        if(ae.getSource().equals(formMaquinaria.getBtnModificar()))
        {
            ActivarControles();
            formMaquinaria.getBtnModificar().setEnabled(false);
        }
        if(ae.getSource().equals(formMaquinaria.getBtnEliminar()))
        {
        
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
