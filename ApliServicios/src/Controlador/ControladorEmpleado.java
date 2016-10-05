
package Controlador;

import Librerias.Validaciones;
import Vista.JFrameEmpleado;
import Vista.JFrameRecurso;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.ListAdapter;

public class ControladorEmpleado implements ActionListener,KeyListener
{
    private Lista ListaEmpleado;
    private JFrameEmpleado formEmpleado;
    public ControladorEmpleado(Lista ListEmpleado) 
    {
        ListaEmpleado = ListEmpleado;
        formEmpleado = new JFrameEmpleado();
        formEmpleado.agregarListener(this);
        formEmpleado.setVisible(true);
        DeshabilitarControles();
        
        formEmpleado.getTxtApellidos().addKeyListener(new KeyAdapter()
         {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidarTxt(e,14,formEmpleado.getTxtApellidos().getText()); 
               }
            //-----------
            @Override
            public void keyPressed (KeyEvent e)
              {     
                 //CodigokeyPressed(e); 
              }
         }
       );
        formEmpleado.getTxtCedula().addKeyListener(new KeyAdapter()
         {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidarTxtNum(e,7,formEmpleado.getTxtCedula().getText()); 
               }
            //-----------
            @Override
            public void keyPressed (KeyEvent e)
              {     
                 CedulakeyPressed(e); 
              }
         }
       );
        
            formEmpleado.getTxtDireccion().addKeyListener(new KeyAdapter()
         {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidarTxt(e,49,formEmpleado.getTxtDireccion().getText()); 
               }
            //-----------
            @Override
            public void keyPressed (KeyEvent e)
              {     
                 //CodigokeyPressed(e); 
              }
         }
       );
            
        formEmpleado.getTxtNombre().addKeyListener(new KeyAdapter()
         {        
            @Override
            public void keyTyped (KeyEvent e)
              {     
                 ValidarTxt(e,14,formEmpleado.getTxtNombre().getText()); 
               }
            //-----------
            @Override
            public void keyPressed (KeyEvent e)
              {     
                 //CodigokeyPressed(e); 
              }
         }
       );
    
    }
    
    //-----------ActivarDeshabilitarControles----------------
    
    private void ActivarControles()
    {
        formEmpleado.getTxtApellidos().setEditable(true);
        formEmpleado.getTxtDireccion().setEditable(true);
        formEmpleado.getTxtFechaIng().setEditable(true);
        formEmpleado.getTxtFechaNac().setEditable(true);
        formEmpleado.getTxtTlf().setEditable(true);
        formEmpleado.getTxtNombre().setEditable(true);
        formEmpleado.getCmbNacionalidad().setEnabled(false);
        formEmpleado.getTxtCedula().setEditable(false);
        formEmpleado.getCmbSexo().setEnabled(true);
        formEmpleado.getcmbCargo().setEnabled(true);
        formEmpleado.getBtnGrabar().setEnabled(true);
    }
    
    private void DeshabilitarControles()
    {
        formEmpleado.getTxtApellidos().setEditable(false);
        formEmpleado.getTxtDireccion().setEditable(false);
        formEmpleado.getTxtFechaIng().setEditable(false);
        formEmpleado.getTxtFechaNac().setEditable(false);
        formEmpleado.getTxtTlf().setEditable(false);
        formEmpleado.getTxtNombre().setEditable(false);
        formEmpleado.getCmbSexo().setEnabled(false);
        formEmpleado.getcmbCargo().setEnabled(false);
        formEmpleado.getTxtCedula().setEditable(true);
        formEmpleado.getTxtCedula().requestFocusInWindow();
        formEmpleado.getCmbNacionalidad().setEnabled(true);
        formEmpleado.getBtnGrabar().setEnabled(false);
    }
    
    //--------------CargarDatos-----------------
    
    private void CargarDatos(int p)
    {
        Empleado e = ListaEmpleado.getListaEmpleado().get(p);
        
        formEmpleado.getTxtCedula().setEditable(false);
        formEmpleado.getCmbNacionalidad().setEnabled(false);
        formEmpleado.getBtnModificar().setEnabled(true);
        
        formEmpleado.getTxtNombre().setText(e.getNombre());
        formEmpleado.getTxtApellidos().setText(e.getApellido());
        formEmpleado.getTxtDireccion().setText(e.getDireccion());
        formEmpleado.getTxtFechaIng().setText(e.getFechaInicio());
        formEmpleado.getTxtFechaNac().setText(e.getFechaNacimiento());
        formEmpleado.getTxtTlf().setText(e.getTelefono());
        formEmpleado.getCmbSexo().setSelectedItem(e.getSexo());
        formEmpleado.getcmbCargo().setSelectedItem("Carrero");
        
    }
    
    //-----------TxtCedulaEventoEnter-----------
    
    private void CedulakeyPressed(KeyEvent e)
    {
        String Cadena;
        Integer Posi;
        Cadena = formEmpleado.getTxtCedula().getText().trim();
        if (e.getKeyChar()==10 && (Cadena.length()>6 && Cadena.length()<9))
        {
            Posi= ListaEmpleado.BuscarEmpleado(Cadena);
            if(Posi==-1)
            {
                int resp;
                resp = JOptionPane.showConfirmDialog(null, "El Empleado no esta registrado, ¿Desea registrarlo?","Registro",JOptionPane.YES_NO_OPTION);
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
        JFrameEmpleado e = formEmpleado;
        if(e.getTxtNombre().getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "Nombre esta en blanco","Atención",JOptionPane.WARNING_MESSAGE);
            formEmpleado.getTxtNombre().requestFocusInWindow();
            return false;
        }
        if(e.getTxtApellidos().getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "Apellido esta en blanco","Atención",JOptionPane.WARNING_MESSAGE);
            formEmpleado.getTxtApellidos().requestFocusInWindow();
            return false;
        }
        if(e.getTxtDireccion().getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "Dirección esta en blanco","Atención",JOptionPane.WARNING_MESSAGE);
            formEmpleado.getTxtDireccion().requestFocusInWindow();
            return false;
        }
        if(e.getTxtTlf().getText().trim().length()<=12)
        {
            JOptionPane.showMessageDialog(null, "Error en el Nro de Telefono " ,"Atención",JOptionPane.WARNING_MESSAGE);
            formEmpleado.getTxtTlf().requestFocusInWindow();
            return false;
        }
          if(e.getCmbSexo().getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(null, "Seleccione el sexo","Atención",JOptionPane.WARNING_MESSAGE);
            formEmpleado.getCmbSexo().requestFocusInWindow();
            return false;
        }
        if(!Validaciones.isDate(formEmpleado.getTxtFechaNac().getText()))
        {
            JOptionPane.showMessageDialog(null,"Error en la Fecha de Nacimiento", "",JOptionPane.WARNING_MESSAGE); 
            formEmpleado.getTxtFechaNac().requestFocusInWindow();
            return false;   
        }
        if(!Validaciones.isDate(formEmpleado.getTxtFechaIng().getText()))
        {
            JOptionPane.showMessageDialog(null,"Error en la Fecha de Ingreso", "",JOptionPane.WARNING_MESSAGE); 
            formEmpleado.getTxtFechaIng().requestFocusInWindow();
            return false;   
        }
          if(e.getcmbCargo().getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(null, "Seleccione el cargo","Atención",JOptionPane.WARNING_MESSAGE);
            formEmpleado.getcmbCargo().requestFocusInWindow();
            return false;
        }
          return true;
    }
    
    //--------------Grabar------------------------
    
    private void Grabar()
    {
        int posi;
        Empleado emp;
        if (Verificar())
        {
            posi=ListaEmpleado.BuscarEmpleado(formEmpleado.getTxtCedula().getText());
            if(posi==-1)
            {
                emp= new Empleado(formEmpleado.getTxtFechaIng().getText(),
                formEmpleado.getTxtCedula().getText(),
                formEmpleado.getTxtNombre().getText(),
                formEmpleado.getTxtApellidos().getText(),
                formEmpleado.getTxtDireccion().getText(),
                formEmpleado.getTxtTlf().getText(),
                formEmpleado.getTxtFechaNac().getText(),
                formEmpleado.getCmbSexo().getSelectedItem().toString(),
                formEmpleado.getcmbCargo().getSelectedItem().toString());  
                ListaEmpleado.getListaEmpleado().add(emp);
                JOptionPane.showMessageDialog(null,"Empleado Guardado Correctamente","Datos almacenados",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                DeshabilitarControles();
                Limpiar();              
            }
            else
            {               
                ListaEmpleado.getListaEmpleado().get(posi).setApellido(formEmpleado.getTxtApellidos().getText());
                ListaEmpleado.getListaEmpleado().get(posi).setTelefono(formEmpleado.getTxtTlf().getText());
                ListaEmpleado.getListaEmpleado().get(posi).setDireccion(formEmpleado.getTxtDireccion().getText());
                ListaEmpleado.getListaEmpleado().get(posi).setFechaInicio(formEmpleado.getTxtFechaIng().getText());
                ListaEmpleado.getListaEmpleado().get(posi).setFechaNacimiento(formEmpleado.getTxtFechaNac().getText());
                ListaEmpleado.getListaEmpleado().get(posi).setNombre(formEmpleado.getTxtNombre().getText());
                ListaEmpleado.getListaEmpleado().get(posi).setSexo(formEmpleado.getCmbSexo().getSelectedItem().toString());
                //ListaEmpleado.getListaEmpleado().get(posi).setCargo(formEmpleado.getcmbCargo().getSelectedItem().toString());
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
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource().equals(formEmpleado.getBtnCancelar()))
        {
            Limpiar();
            DeshabilitarControles();
        }
        if(ae.getSource().equals(formEmpleado.getBtnModificar()))
        {
            formEmpleado.getBtnGrabar().setEnabled(true);
            ActivarControles();
            formEmpleado.getCmbNacionalidad().setEnabled(false);
            formEmpleado.getTxtCedula().setEditable(false);
            formEmpleado.getBtnModificar().setEnabled(false);
        }
        if(ae.getSource().equals(formEmpleado.getBtnGrabar()))
        {
            Grabar();
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

    private void Limpiar() 
    {
      formEmpleado.getTxtApellidos().setText("");
      formEmpleado.getTxtCedula().setText("");
      formEmpleado.getTxtDireccion().setText("");
      formEmpleado.getTxtFechaIng().setText("");
      formEmpleado.getTxtFechaNac().setText("");
      formEmpleado.getTxtNombre().setText("");
      formEmpleado.getTxtTlf().setText("");
      formEmpleado.getcmbCargo().setSelectedIndex(0);
      formEmpleado.getCmbSexo().setSelectedIndex(0);
      formEmpleado.getCmbNacionalidad().setSelectedIndex(0);
      formEmpleado.getTxtCedula().requestFocusInWindow();
    }
    
}
