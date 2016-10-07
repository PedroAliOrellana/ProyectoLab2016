
package Controlador;

import Modelo.Lista;

import Vista.JFrameHerramienta;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class ControladorHerramienta implements ActionListener,KeyListener
{
    private JFrameHerramienta formHerramienta; 
    private Lista ListaHerramienta;  

    
    
    public ControladorHerramienta(Lista listHer)
    {
       ListaHerramienta= listHer;
        formHerramienta = new JFrameHerramienta();
        formHerramienta.agregarListener(this);
        formHerramienta.setVisible(true);
        //DeshabilitarControles();
    }

   
    
    
    
}
