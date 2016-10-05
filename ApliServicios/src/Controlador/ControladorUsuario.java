package Controlador;

import Modelo.Lista;
import Modelo.Usuario;
import Vista.JFrameGuardarUsuario;
import Vista.JFrameUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

public class ControladorUsuario implements ActionListener,KeyListener
{
    private JFrameUsuario formUsuario;
    private JFrameGuardarUsuario formGU;
    private Lista ListaUsuario;

    public ControladorUsuario(Lista lisUs) 
    {
            ListaUsuario = lisUs;

            formUsuario = new JFrameUsuario();
            formUsuario.agregarListener(this);
            formUsuario.setVisible(true);
            formUsuario.getBtnActualizarCont().setVisible(false);
            formUsuario.getBtnModificar().setVisible(false);
            formUsuario.getBtnBorrar().setVisible(false);
            formUsuario.getBtnActPasw().setVisible(false);
            
        cargarUsuario();
                //Zona de los KeyListener
        formUsuario.getTxtBuscar().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,15,formUsuario.getTxtBuscar().getText());
                ValidarSoloLetras(e);
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
               {             
              }
       }
                
              
    ); 
        
          formUsuario.getTUsuario().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
              
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
               {   
                 
              }
       }
      );    
          
      formUsuario.getTUsuario().addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int row = formUsuario.getTUsuario().rowAtPoint(evt.getPoint());
            int col = formUsuario.getTUsuario().columnAtPoint(evt.getPoint());
            if (row >= 0 && col >= 0) 
            {
                JOptionPane.showMessageDialog(null, formUsuario.getTUsuario().getValueAt(row, col));

            }
    }
});
        
    }
    


    private void CargarModificar()
    {
        
        Usuario us=new Usuario();
        int Fila=formUsuario.getTUsuario().getSelectedRow();
        System.out.print(Fila);
        if(Fila==-1)
        {
            formUsuario.getBtnActualizarCont().setVisible(false);
            formUsuario.getBtnModificar().setVisible(false);
            formUsuario.getBtnModificar().setVisible(false);
        }
        else
        {
            formUsuario.getBtnActualizarCont().setVisible(true);
            formUsuario.getBtnModificar().setVisible(true);
            formUsuario.getBtnModificar().setVisible(true);
            
            //formUsuario.getM();
            formUsuario.getTUsuario().getModel();
            
            formGU.getTxtNombreUsuario().setText(formUsuario.getTUsuario().getValueAt(Fila, 0).toString());
            formGU.getCmbNivelA().setSelectedItem(formUsuario.getTUsuario().getValueAt(Fila, 1).toString());
            formGU.getTxtPasw().setVisible(false);
            formGU.getTxtPasw().setVisible(false);
            formGU.getTxtNombreUsuario().setEditable(false);
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
        

    @Override
    public void actionPerformed(ActionEvent e) 
    {
         if (e.getSource().equals(formUsuario.getBtnNuevo()))  
      {  
          new ControladorGuardarUsuario(ListaUsuario);
          formUsuario.dispose();
      }   
        if (e.getSource().equals(formUsuario.getBtnRegresar()))  
      {  
        formUsuario.dispose();
      }
        if (e.getSource().equals(formUsuario.getBtnModificar()))  
      {  
        
          new ControladorGuardarUsuario(ListaUsuario);
          CargarModificar();
        
      }
    }

    private void cargarUsuario()
    {
         int Fila;  
         Usuario us=new Usuario();
  
         for (Fila=0;Fila<ListaUsuario.getListaUsuario().size();Fila++)
        {
            us=ListaUsuario.getListaUsuario().get(Fila);
            formUsuario.getTUsuario().setValueAt(us.getNombreUsuario(), Fila,0);
            formUsuario.getTUsuario().setValueAt(us.getNivelAcceso(), Fila,1);    
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
