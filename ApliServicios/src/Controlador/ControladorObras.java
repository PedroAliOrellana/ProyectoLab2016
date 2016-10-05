package Controlador;

import Util.Rutinas;
import Vista.JFrameObra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorObras implements ActionListener,KeyListener
{
   private JFrameObra formObra; 

    public ControladorObras() 
    {
        formObra = new JFrameObra();
        formObra.agregarListener(this);
        formObra.setVisible(true);
        
        //Zona de los KeyListener
        formObra.getTxtCodObra().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                CodObraKeyTyped(e); 
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
               {             
              }
       }
    );          
     //----------------------------------------
   formObra.getTxtDescObra().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                DescObraKeyTyped(e); 
               }
                 
       }
      );          
     //------------------------------------------------   
   formObra.getTxtLugarObra().addKeyListener(new KeyAdapter()
    {        
        @Override
         public void keyTyped (KeyEvent e)
         {     
            LugarObraKeyTyped(e); 
          }
                 
       }
      );   
   
   //--------------------------------------
      formObra.getTxtRif().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                RifClienteKeyTyped(e); 
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
               {             
              }
       }
    );
   
     //--------------------------------------
      formObra.getTxtRazonS().addKeyListener(new KeyAdapter()
      {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                RazonSClienteKeyTyped(e); 
               }
                 
            @Override
            public void keyPressed(KeyEvent e) 
               {             
              }
       }
    );
   
    }
    
    
   
//-------------------------------------
private void CodObraKeyTyped(KeyEvent e)
{
  String Cadena;
  Cadena=formObra.getTxtCodObra().getText();
  Cadena=Cadena.trim();
  
  if (Cadena.length()==5)
   {
     e.consume();   
   }   
}        
//-------------------------------------
private void DescObraKeyTyped(KeyEvent e)
{
  String Cadena;
  Cadena=formObra.getTxtDescObra().getText();
  Cadena=Cadena.trim();
  
  if (Cadena.length()==30)
   {
     e.consume();   
   }   
    
}        
//-------------------------------------
private void LugarObraKeyTyped(KeyEvent e)
{
  String Cadena;
  Cadena=formObra.getTxtLugarObra().getText();
  Cadena=Cadena.trim();
  
  if (Cadena.length()==50)
   {
     e.consume();   
   }   
    
}   
//-------------------------------------
private void RifClienteKeyTyped(KeyEvent e)
{
  String Cadena;
  Cadena=formObra.getTxtRif().getText();
  Cadena=Cadena.trim();
  
  if (Cadena.length()==10)
   {
     e.consume();   
   }   
    
}    

//-------------------------------------
private void RazonSClienteKeyTyped(KeyEvent e)
{
  String Cadena;
  Cadena=formObra.getTxtRazonS().getText();
  Cadena=Cadena.trim();
  
  if (Cadena.length()==30)
   {
     e.consume();   
   }   
    
}   

//-------------------------------------    
private void Limpiar()    
{
  formObra.getTxtCodObra().setText("");  
  formObra.getTxtDescObra().setText("");
  formObra.getTxtLugarObra().setText("");
  formObra.getTxtCodObra().requestFocusInWindow();
  formObra.getTxtRif().setText("");
  formObra.getTxtRazonS().setText("");
}        
//-------------------------------------    
private void Grabar()
{
   String Cadena;
   
   Cadena=formObra.getTxtCodObra().getText().trim();
   if (Cadena.length()==0)
    {
      Rutinas.Aviso("Codigo de Obra Vacio", "");   
      formObra.getTxtCodObra().requestFocusInWindow();
      return;
    }  
   
   if (formObra.getTxtDescObra().getText().trim().length()==0)
   {
      Rutinas.Aviso("Descripcion de Obra Vacio", "");   
      formObra.getTxtDescObra().requestFocusInWindow();
      return;       
   }  
   
}   
//--------------------------
    @Override
    public void keyTyped(KeyEvent e) 
    {
    }
//--------------------------------
    @Override
    public void keyPressed(KeyEvent e) 
    {
    }
//---------------------------------
    @Override
    public void keyReleased(KeyEvent e) 
    {
    }
//--------------------

    @Override
    public void actionPerformed(ActionEvent e) 
    {
      if (e.getSource().equals(formObra.getBtnCancelar()))  
      {  
        Limpiar();  
      }        
      //--------------------
      if (e.getSource().equals(formObra.getBtnGrabar()))  
      {  
        Grabar();  
      }        
      
    }
    
}
