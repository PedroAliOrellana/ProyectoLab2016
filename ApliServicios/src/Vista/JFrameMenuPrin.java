/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionListener;
import javax.swing.JMenuItem;



public class JFrameMenuPrin extends javax.swing.JFrame {

    /**
     * Creates new form JFrameMenuPrin
     */
    public JFrameMenuPrin() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemCliente = new javax.swing.JMenuItem();
        jMenuItemServicio = new javax.swing.JMenuItem();
        jMenuItemObras = new javax.swing.JMenuItem();
        jMenuItemRecursos = new javax.swing.JMenuItem();
        jMenuItemUsuario = new javax.swing.JMenuItem();
        jMenuItemEmpleado = new javax.swing.JMenuItem();
        jMenuItemVehiculo = new javax.swing.JMenuItem();
        jMenuItemHerramienta = new javax.swing.JMenuItem();
        jMenuItemMotivo = new javax.swing.JMenuItem();
        jMenuItemMaquinaria = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jMenu1.setText("Maestros");

        jMenuItemCliente.setText("Cliente");
        jMenu1.add(jMenuItemCliente);

        jMenuItemServicio.setText("Servicio");
        jMenu1.add(jMenuItemServicio);

        jMenuItemObras.setText("Obras");
        jMenu1.add(jMenuItemObras);

        jMenuItemRecursos.setText("Recursos");
        jMenuItemRecursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRecursosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemRecursos);

        jMenuItemUsuario.setText("Usuario");
        jMenu1.add(jMenuItemUsuario);

        jMenuItemEmpleado.setText("Empleado");
        jMenu1.add(jMenuItemEmpleado);

        jMenuItemVehiculo.setText("Vehiculo");
        jMenu1.add(jMenuItemVehiculo);

        jMenuItemHerramienta.setText("Herramienta");
        jMenu1.add(jMenuItemHerramienta);

        jMenuItemMotivo.setText("Motivo");
        jMenuItemMotivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMotivoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemMotivo);

        jMenuItemMaquinaria.setText("Maquinaria");
        jMenu1.add(jMenuItemMaquinaria);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Movimientos");

        jMenuItem6.setText("Solicitud Servicio");
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Reportes");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(527, 432));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemRecursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRecursosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemRecursosActionPerformed

    private void jMenuItemMotivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMotivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemMotivoActionPerformed

 //---------------------
// ZONA DE LOS LISTENER    
//---------------------
    
//El ActionListener es el que se ejecutará cuando se selecciona un item del menu

    
    // ----- zona de los Get de los atributos
public JMenuItem getjMenuItemObras() 
{
  return jMenuItemObras;
}
//------------------------

    public JMenuItem getjMenuItemMaquinaria() {
        return jMenuItemMaquinaria;
    }


//-------------------------------
    public JMenuItem getjMenuItemServicio() {
        return jMenuItemServicio;
    }
//-------------------------------------- 
       public JMenuItem getjMenuItemRecursos() {
        return jMenuItemRecursos;
    }
//-------------------------------------- 
    public JMenuItem getjMenuItemUsuario() {
        return jMenuItemUsuario;
    }

    public JMenuItem getjMenuItemEmpleado() {
        return jMenuItemEmpleado;
    }

    public JMenuItem getjMenuItemMotivo() 
    {
        return jMenuItemMotivo;
    }

    public JMenuItem getjMenuItemCliente() {
        return jMenuItemCliente;
    }

    public JMenuItem getjMenuItemHerramienta() {
        return jMenuItemHerramienta;
    }

    public JMenuItem getjMenuItemVehiculo() {
        return jMenuItemVehiculo;
    }

    
public void agregarListener (ActionListener accion)
{
    this.jMenuItemObras.addActionListener(accion);    
    this.jMenuItemCliente.addActionListener(accion);
    this.jMenuItemServicio.addActionListener(accion);
    this.jMenuItemRecursos.addActionListener(accion);
    this.jMenuItemUsuario.addActionListener(accion);
    this.jMenuItemEmpleado.addActionListener(accion);
    this.jMenuItemMotivo.addActionListener(accion);
    this.jMenuItemHerramienta.addActionListener(accion);
    this.jMenuItemVehiculo.addActionListener(accion);
    jMenuItemMaquinaria.addActionListener(accion);
}    

 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItemCliente;
    private javax.swing.JMenuItem jMenuItemEmpleado;
    private javax.swing.JMenuItem jMenuItemHerramienta;
    private javax.swing.JMenuItem jMenuItemMaquinaria;
    private javax.swing.JMenuItem jMenuItemMotivo;
    private javax.swing.JMenuItem jMenuItemObras;
    private javax.swing.JMenuItem jMenuItemRecursos;
    private javax.swing.JMenuItem jMenuItemServicio;
    private javax.swing.JMenuItem jMenuItemUsuario;
    private javax.swing.JMenuItem jMenuItemVehiculo;
    // End of variables declaration//GEN-END:variables
}
