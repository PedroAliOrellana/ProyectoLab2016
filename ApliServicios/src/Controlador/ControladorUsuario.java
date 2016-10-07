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
            formUsuario.getBtnBuscar().setEnabled(false);
            formUsuario.getTxtBuscar().requestFocusInWindow();
            
            
        cargarUsuario();
                //Zona de los KeyListener
        formUsuario.getTxtBuscar().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,15,formUsuario.getTxtBuscar().getText());
                ValidarSoloLetras(e);
                
                    if (formUsuario.getTxtBuscar().getText().length()>=0)
                    {
                        formUsuario.getBtnBuscar().setEnabled(true);
                    }
                    
                    if (formUsuario.getTxtBuscar().getText().length()==0)
                    {
                        cargarUsuario();
                        formUsuario.getBtnBuscar().setEnabled(false);
                    }
                    
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
          
  
          formUsuario.getTUsuario().addMouseListener(new java.awt.event.MouseAdapter() 
          {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) 
                {
                    int row = formUsuario.getTUsuario().rowAtPoint(evt.getPoint());
                    int col = formUsuario.getTUsuario().columnAtPoint(evt.getPoint());
                    if (row>=0)
                    {
                            ActivarBotonesClick(row,col); 
                    };

                }
            
            
            
           });
          
          
            
    }
    


    private boolean BuscarUsuarioxNombre()
    {   
           Usuario us=new Usuario();
           
        for (int row=0;row<ListaUsuario.getListaUsuario().size();row++)
        {  
            us=ListaUsuario.getListaUsuario().get(row); 
            if(formUsuario.getTxtBuscar().getText().equals(us.getNombreUsuario()))
            {      
                return true;
            } 
        }
          return false;          
    }
    
     private boolean BuscarUsuarioxNivelA()
    {
          Usuario us=new Usuario();
         for (int row=0;row<ListaUsuario.getListaUsuario().size();row++)
        {  
            us=ListaUsuario.getListaUsuario().get(row); 
            if(formUsuario.getTxtBuscar().getText().equals(us.getNivelAcceso()))
            {      
                return true;
            } 
        }
          return false;    
    }
     
    private int FilaEncontrada()
    {
          Integer Posi;
          Usuario us=new Usuario();
               
            for (Posi=0;Posi< ListaUsuario.getListaUsuario().size();Posi++)
            {
                us=ListaUsuario.getListaUsuario().get(Posi);
                if (formUsuario.getTxtBuscar().getText().equals(us.getNombreUsuario()))
                     return Posi;
            }
        return -1;  
    }
    
    private void CargarDatoEncontrado(int p)
    {
        Usuario us=new Usuario();
        us=ListaUsuario.getListaUsuario().get(p);
            formUsuario.getTUsuario().setValueAt(us.getNombreUsuario(), 0,0);
            formUsuario.getTUsuario().setValueAt(us.getNivelAcceso(), 0,1); 
    }
     
   private void LimpiarDatosTabla()
   {
        int Fila;  
         Usuario us=new Usuario();
  
         for (Fila=0;Fila<ListaUsuario.getListaUsuario().size();Fila++)
        {
            us=ListaUsuario.getListaUsuario().get(Fila);
            formUsuario.getTUsuario().setValueAt("", Fila,0);
            formUsuario.getTUsuario().setValueAt("",Fila,1); 
            
        }
   }
    
    private void ActivarBotonesClick(int row,int col)
    {
        try
        {
            if (formUsuario.getTUsuario().getValueAt(row,col).toString().length()==0)
            {
            }else
            {
                formUsuario.getBtnActPasw().setVisible(true);
                formUsuario.getBtnModificar().setVisible(true);
                formUsuario.getBtnBorrar().setVisible(true); 
            }
         }
        catch(Exception e1)
        {
               formUsuario.getBtnActPasw().setVisible(false);
               formUsuario.getBtnModificar().setVisible(false);
               formUsuario.getBtnBorrar().setVisible(false); 
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

        private void Eliminar(java.awt.event.MouseEvent e)
    {

        int resp,posi;
        int row = formUsuario.getTUsuario().rowAtPoint(e.getPoint());
        int col = formUsuario.getTUsuario().columnAtPoint(e.getPoint());
        resp = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar al empleado: " + formUsuario.getTUsuario().getValueAt(row, col)+"?","Eliminar",JOptionPane.YES_NO_OPTION);
        if(resp==0)
        {               
            posi = ListaUsuario.BuscarUsuario(formUsuario.getTUsuario().getValueAt(row, col).toString());
            ListaUsuario.getListaUsuario().remove(posi);
            JOptionPane.showMessageDialog(null, "Emleado eliminado");        
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
        if (e.getSource().equals(formUsuario.getBtnBuscar()))  
        { 

              Integer posi;
              posi=FilaEncontrada();
              if(BuscarUsuarioxNombre() && posi!=-1)
              {
                      LimpiarDatosTabla();
                      CargarDatoEncontrado(posi);                 
              }
              else
              {
                  LimpiarDatosTabla();
              }
        }
        if (e.getSource().equals(formUsuario.getBtnBorrar()))  
        {  
           
            
        }
            
    }
     
}
