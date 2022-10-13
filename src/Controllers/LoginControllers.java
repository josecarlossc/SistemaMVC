/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Usuarios;
import Models.UsuariosDao;
import Views.FrmLogin;
import Views.PanelAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author josec
 */
public class LoginControllers implements ActionListener{
    private Usuarios us;
    private UsuariosDao usDao;
    private FrmLogin views;

    public LoginControllers(Usuarios us, UsuariosDao usDao, FrmLogin views) {
        this.us = us;
        this.usDao = usDao;
        this.views = views;
        this.views.btnLogin.addActionListener(this);
        this.views.btnCancelar.addActionListener(this);
        this.views.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== views.btnLogin){
            if (views.txtUsuario.getText().equals("") 
                || String.valueOf(views.txtClave.getPassword()).equals("")){
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }else{
                String usuario = views.txtUsuario.getText();
                String clave = String.valueOf(views.txtClave.getPassword());
                us = usDao.login(usuario,clave);
                if(us.getUsuario() !=null){
                    PanelAdmin admin = new PanelAdmin();
                    admin.setVisible(true);
                    this.views.dispose();
                            
                }else{
                    JOptionPane.showMessageDialog(null, "El Usuario y/o Contraseña no son válidos");
                }
            }
        }else{
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(pregunta == 0){
                System.exit(0);
            }
        }
    }
    
    
}

