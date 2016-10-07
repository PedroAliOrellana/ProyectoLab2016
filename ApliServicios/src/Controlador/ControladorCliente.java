
package Controlador;
import Modelo.Cliente;
import Modelo.Lista;
import Vista.JFrameCliente;
import Vista.JFrameGuardaCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;


public class ControladorCliente implements ActionListener,KeyListener
{
   private  JFrameCliente formCliente;
   private  JFrameGuardaCliente formGuardarCliente;
   private Lista ListaCliente;
    
   public ControladorCliente(Lista lisCliente)
   {
       ListaCliente = lisCliente ;
       formCliente = new JFrameCliente();
       formCliente.agregarListener(this);
       formCliente.setVisible(true);
      // formCliente.getBntNuevoCliente().setVisible(false);
      // formCliente.getBntModificar().setVisible(false);
      //formCliente.getBntBorrar().setVisible(false);
       //cargarCliente();
       
         //Zona de los KeyListener
        formCliente.getTxtBuscar().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                ValidarTxt(e,15,formCliente.getTxtBuscar().getText());
                ValidarSoloLetras(e);
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
               {             
              }
       }
                
              
    ); 
        
          formCliente.getTCliente().addKeyListener(new KeyAdapter()
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
          
      formCliente.getTCliente().addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int row = formCliente.getTCliente().rowAtPoint(evt.getPoint());
            int col = formCliente.getTCliente().columnAtPoint(evt.getPoint());
            if (row >= 0 && col >= 0) 
            {
                JOptionPane.showMessageDialog(null, formCliente.getTCliente().getValueAt(row, col));

            }
    }
});
            
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
    
    
     private void cargarCliente()
    {
         int Fila;  
         Cliente cliente=new Cliente();
  
         for (Fila=0;Fila<ListaCliente.getListaCliente().size();Fila++)
        {
            cliente=ListaCliente.getListaCliente().get(Fila);
            formCliente.getTCliente().setValueAt(cliente.getRif(), Fila, 0);
            formCliente.getTCliente().setValueAt(cliente.getRazonSocial(), Fila,1);    
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent e) 
    {
           if (e.getSource().equals(formCliente.getBntNuevoCliente()))  
      {  
          new ControladorGuardarCliente( );
          formCliente.dispose();
      }   
        if (e.getSource().equals(formCliente.getBntRegresar()))  
      {  
        formCliente.dispose();
      }
        if (e.getSource().equals(formCliente.getBntModificar()))  
      {  
        
          new ControladorGuardarCliente();
         // CargarModificar();
        
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
