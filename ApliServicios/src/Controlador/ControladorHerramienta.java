
package Controlador;

import Modelo.Lista;

import Vista.JFrameGuardarHerramienta;
import java.awt.event.ActionListener;

public class ControladorHerramienta
{
    private JFrameGuardarHerramienta formHerramienta; 
    private Lista ListaHerramienta;  

    
    
    public ControladorHerramienta(Lista listHer)
    {
       ListaHerramienta= listHer;
        formHerramienta = new JFrameGuardarHerramienta();
        formHerramienta.agregarListener((ActionListener) this);
        formHerramienta.setVisible(true);
        //DeshabilitarControles();
    }

   
    
    
    
}
