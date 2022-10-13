
package Controllers;

import Views.PanelAdmin;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Jose Carlos Solis Cano <your.name at your.org>
 */
public class ConfigController implements MouseListener{

    private PanelAdmin views;

    public ConfigController(PanelAdmin views) {
        this.views = views;
        this.views.JLabelCategorias.addMouseListener(this);
        this.views.JLabelClientes.addMouseListener(this);
        this.views.JLabelConfiguracion.addMouseListener(this);
        this.views.JLabelMedidas.addMouseListener(this);
        this.views.JLabelNuevaCompra.addMouseListener(this);
        this.views.JLabelNuevaVenta.addMouseListener(this);
        this.views.JLabelProveedores.addMouseListener(this);
        this.views.JLabelUsuarios.addMouseListener(this);
        this.views.JLabelProductos.addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       if (e.getSource() == views.JLabelCategorias) {
           views.JPanelCategorias.setBackground(new Color(255,51,51));
       }else if (e.getSource() == views.JLabelClientes) {
           views.JPanelClientes.setBackground(new Color(255,51,51));
       }else if (e.getSource() == views.JLabelConfiguracion) {
           views.JPanelConfiguracion.setBackground(new Color(255,51,51));
       }else if (e.getSource() == views.JLabelMedidas) {
           views.JPanelMedidas.setBackground(new Color(255,51,51));
       }else if (e.getSource() == views.JLabelNuevaCompra) {
           views.JPanelNuevaCompra.setBackground(new Color(255,51,51));
       }else if (e.getSource() == views.JLabelNuevaVenta) {
           views.JPanelNuevaVenta.setBackground(new Color(255,51,51));
       }else if (e.getSource() == views.JLabelProveedores) {
           views.JPanelProveedor.setBackground(new Color(255,51,51));
       }else if (e.getSource() == views.JLabelUsuarios) {
           views.JPanelUsuarios.setBackground(new Color(255,51,51));
       }else{
           views.JPanelProductos.setBackground(new Color(255,51,51));
       }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == views.JLabelCategorias) {
           views.JPanelCategorias.setBackground(new Color(51,51,51));
       }else if (e.getSource() == views.JLabelClientes) {
           views.JPanelClientes.setBackground(new Color(51,51,51));
       }else if (e.getSource() == views.JLabelConfiguracion) {
           views.JPanelConfiguracion.setBackground(new Color(51,51,51));
       }else if (e.getSource() == views.JLabelMedidas) {
           views.JPanelMedidas.setBackground(new Color(51,51,51));
       }else if (e.getSource() == views.JLabelNuevaCompra) {
           views.JPanelNuevaCompra.setBackground(new Color(51,51,51));
       }else if (e.getSource() == views.JLabelNuevaVenta) {
           views.JPanelNuevaVenta.setBackground(new Color(51,51,51));
       }else if (e.getSource() == views.JLabelProveedores) {
           views.JPanelProveedor.setBackground(new Color(51,51,51));
       }else if (e.getSource() == views.JLabelUsuarios) {
           views.JPanelUsuarios.setBackground(new Color(51,51,51));
       }else{
           views.JPanelProductos.setBackground(new Color(51,51,51));
       }
    }
    
}
