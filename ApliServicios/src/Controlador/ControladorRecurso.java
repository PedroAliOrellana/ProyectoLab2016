
package Controlador;

import Vista.JFrameRecurso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class ControladorRecurso implements ActionListener,KeyListener
{
    private JFrameRecurso formRecurso;

    public ControladorRecurso() {
        formRecurso = new JFrameRecurso();
        formRecurso.agregarListener(this);
        formRecurso.setVisible(true);
        
         //Zona de los KeyListener
        formRecurso.getTxtCodRecurso().addKeyListener(new KeyAdapter()
        {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                CodRecursoKeyTyped(e); 
              }
                 
            @Override
            public void keyPressed(KeyEvent e) 
               {             
              }
       }
       ); 
       
        //----------- txt Descripcion
        
         formRecurso.getTxtDescRecurso().addKeyListener(new KeyAdapter()
        {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                DescRecursoKeyTyped(e); 
              }
                 
            @Override
            public void keyPressed(KeyEvent e) 
               {             
              }
       }
       ); 
         
       //----------- txt Tasa 
        
         formRecurso.getTxtTasacRecurso().addKeyListener(new KeyAdapter()
        {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                TasaRecursoKeyTyped(e); 
              }
                 
            @Override
            public void keyPressed(KeyEvent e) 
               {             
              }
       }
       ); 
         
         //----------- txt Tasa 
        
        /* formRecurso.getTxtUnida().addKeyListener(new KeyAdapter()
        {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                UnidadMedidaKeyTyped(e); 
              }
                 
            @Override
            public void keyPressed(KeyEvent e) 
               {             
              }
       }
       ); 
         */   
    }
    
    
    
   //----------------------------------------
    private void CodRecursoKeyTyped(KeyEvent e)
    {
        if (formRecurso.getTxtCodRecurso().getText().length() == 3)
        {
            e.consume();
        }
    }
    
     //----------------------------------------
    private void DescRecursoKeyTyped(KeyEvent e)
    {
        if (formRecurso.getTxtDescRecurso().getText().length() == 20)
        {
            e.consume();
        }
    }
    
     //----------------------------------------
    private void TasaRecursoKeyTyped(KeyEvent e)
    {
        if (formRecurso.getTxtTasacRecurso().getText().length() == 9)
        {
            e.consume();
        }
    }
      //----------------------------------------
    private void UnidadMedidaKeyTyped(KeyEvent e)
    {
      /*  if (formRecurso.getCmbUnidad().)
        {
            e.consume();*/
        }
    
    
   //--------------------------------------------
    private void Limpiar()    
{
  formRecurso.getTxtCodRecurso().setText("");  
  formRecurso.getTxtDescRecurso().setText("");
  formRecurso.getTxtTasacRecurso().setText("");

}   
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource().equals(formRecurso.getBtnCancelar()))
        {
            Limpiar();
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) 
    {
    
    }

    @Override
    public void keyPressed(KeyEvent ke) 
    {
    }

    @Override
    public void keyReleased(KeyEvent ke) 
    {
    }
    
}
