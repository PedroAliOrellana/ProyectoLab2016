package Controlador;

import Modelo.Lista;
import Vista.JFrameMenuPrin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControladorMenuPrin implements ActionListener
{
   private JFrameMenuPrin formMenuPrin;    
   private Lista lisEmpreServicios;
           
    public ControladorMenuPrin() 
    {
        lisEmpreServicios=new Lista();
        
        lisEmpreServicios.cargarServicio();        
        lisEmpreServicios.cargarCliente();
        lisEmpreServicios.cargarObra();
        lisEmpreServicios.cargarRecurso();
        lisEmpreServicios.cargarEmpleado();
        lisEmpreServicios.cargarUsuario();
        lisEmpreServicios.cargarMotivo();
        lisEmpreServicios.cargarMaquinaria();
        lisEmpreServicios.cargarVehiculo();
        lisEmpreServicios.cargarTipoRecurso();
        //lisEmpreServicios.cargarHerramienta();
        
        formMenuPrin = new JFrameMenuPrin();
        formMenuPrin.agregarListener(this);
        formMenuPrin.setVisible(true);
        
    }

//-----------------Espacio de los eventos de los Menu----------------------    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
      if (e.getSource().equals(formMenuPrin.getjMenuItemObras()))  
      {
          new ControladorGuardarObra(); 
      }  
      //-------------------------------------
      if (e.getSource().equals(formMenuPrin.getjMenuItemCliente()))  
      {
          new  ControladorCliente(lisEmpreServicios);
         System.out.println("Esta en cliente"); 
      } 
      //-------------------------------------
      if (e.getSource().equals( formMenuPrin.getjMenuItemServicio()))
      {
         new ControladorServicio(lisEmpreServicios);
      }
      if(e.getSource().equals(formMenuPrin.getjMenuItemRecursos()))
      {
          new ControladorRecurso();
      }
       if(e.getSource().equals(formMenuPrin.getjMenuItemEmpleado()))
      {
          new ControladorEmpleado(lisEmpreServicios);
          formMenuPrin.setVisible(false);
      }
       if(e.getSource().equals(formMenuPrin.getjMenuItemUsuario()))
      {
          new ControladorUsuario(lisEmpreServicios);
      }
       if(e.getSource().equals(formMenuPrin.getjMenuItemMotivo()))
       {
           new ControladorGuardarMotivo(lisEmpreServicios);
       }
       if(e.getSource().equals(formMenuPrin.getjMenuItemVehiculo()))
       {
           new ControladorGuardarVehiculo(lisEmpreServicios);
       }
       if(e.getSource().equals(formMenuPrin.getjMenuItemHerramienta()))
       {
            new ControladorGuardarHerramienta(lisEmpreServicios);
       }
       if(e.getSource().equals(formMenuPrin.getjMenuItemMaquinaria()))
       {
           new ControladorMaquinaria(lisEmpreServicios);
       }
    }

  
}
