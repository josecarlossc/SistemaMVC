
package Controllers;

import Models.Usuarios;
import Models.UsuariosDao;
import Views.PanelAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Carlos Solis Cano <your.name at your.org>
 */
public class UsuariosControllers implements ActionListener, MouseListener{
    
    private Usuarios us;
    private UsuariosDao usDao;
    private PanelAdmin views; 
    
    DefaultTableModel modelo = new DefaultTableModel(); 

    public UsuariosControllers(Usuarios us, UsuariosDao usDao, PanelAdmin views) {
        this.us = us;
        this.usDao = usDao;
        this.views = views;
        this.views.btnRegistrarUser.addActionListener(this);
        this.views.TableUsers.addMouseListener(this);
        listarUsuarios();
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btnRegistrarUser) {
            if (views.txtUsuarioUser.getText().equals("") 
                    || views.txtNombreUser.getText().equals("")  
                    || String.valueOf(views.txtClaveUser.getPassword()).equals("") ) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            }else {
                us.setUsuario(views.txtUsuarioUser.getText());
                us.setNombre(views.txtNombreUser.getText());
                us.setClave(String.valueOf(views.txtClaveUser.getPassword()));
                us.setCaja(views.cbxCajaUser.getSelectedItem().toString());
                us.setRol(views.cbxRolUser.getSelectedItem().toString());
                if (usDao.registrar(us)) {
                    JOptionPane.showMessageDialog(null, "Usuario registrado con exito");
                }else{
                    JOptionPane.showMessageDialog(null, "Error al registrar el usuario");
                    }
            }
        } 
    }
    
    public void listarUsuarios(){
        List<Usuarios> lista = usDao.ListaUsuarios();
        modelo = (DefaultTableModel) views.TableUsers.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < lista.size(); i++){
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getUsuario();
            ob[2] = lista.get(i).getNombre();
            ob[3] = lista.get(i).getCaja();
            ob[4] = lista.get(i).getRol();
            ob[5] = lista.get(i).getEstado();
            modelo.addRow(ob);      
        }
        views.TableUsers.setModel(modelo);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == views.TableUsers) {
            int fila = views.TableUsers.rowAtPoint(e.getPoint());
            views.txtIdUser.setText(views.TableUsers.getValueAt(fila, 0).toString());
            views.txtUsuarioUser.setText(views.TableUsers.getValueAt(fila, 1).toString());
            views.txtNombreUser.setText(views.TableUsers.getValueAt(fila, 2).toString());
            views.cbxCajaUser.setSelectedItem(views.TableUsers.getValueAt(fila, 3).toString());
            views.cbxRolUser.setSelectedItem(views.TableUsers.getValueAt(fila, 4).toString()); 
            views.txtClaveUser.setEnabled(false);
            views.btnRegistrarUser.setEnabled(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
