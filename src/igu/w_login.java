package igu;

import org.ini4j.Wini;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.Usuario;

public class w_login extends javax.swing.JFrame {

    public w_login() {
        initComponents();
        try{
            File archivo = new File("myiniFinal.ini"); 
            Wini ini = new Wini(new File(archivo.getAbsolutePath()));            
            usuarios = ini.get("Archivos", "usuarios");
            LeerDatos_usuario();
        }
        catch(IOException e){
            System.err.println("Error al abrir el archivo");
            javax.swing.JOptionPane.showMessageDialog(null, 
                    "Error al abrir archivo", 
                    "Error", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtUser1 = new javax.swing.JLabel();
        txtPass1 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtUser1.setText("Usuario:");

        txtPass1.setText("Clave:");

        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Inicio Sesión");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUser1)
                            .addComponent(txtPass1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUser)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnIngresar)
                        .addGap(36, 36, 36)))
                .addContainerGap(199, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser1)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass1)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(btnIngresar)
                .addGap(84, 84, 84))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        int i = 0;
        while (i < lista_usuarios.size() && (!lista_usuarios.get(i).getClave().equals(new String(txtPass.getPassword())) || !lista_usuarios.get(i).getUsuario().equals(txtUser.getText()))) {
            i++;
        }
        
        if(i<lista_usuarios.size()){
            VerificarTipoUsuario(i);
        }
        else {
            javax.swing.JOptionPane.showMessageDialog(null, 
                    "Usuario o contraseña incorrectos", 
                    "Error de inicio de sesión", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed
    
    public static void LeerDatos_usuario(){
        try {
            File archivo = new File(usuarios);
            try (FileInputStream fin = new FileInputStream (archivo.getAbsolutePath())) {
                ObjectInputStream ois = new ObjectInputStream(fin);
                lista_usuarios = (ArrayList<Usuario>)ois.readObject();
            }
        } catch(IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al obtener los usuarios",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            System.out.print("Error en la lectura: " + ex.getMessage());
        }
    }
    
    public void VerificarTipoUsuario(int i){
        if (lista_usuarios.get(i).getTipo().equals("administrador")){
            w_principal Frame = new w_principal("admin");
            Frame.setVisible(true);
            Frame.pack();
            Frame.setLocationRelativeTo(null); 
            this.dispose();
        }
        else if(lista_usuarios.get(i).getTipo().equals("empleado")){
            w_principal Frame = new w_principal("emp");
            Frame.setVisible(true);
            Frame.pack();
            Frame.setLocationRelativeTo(null); 
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null,
                    "Tipo de usuario inválido",
                    "Error en el usuario cargado",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //variables globales
    private static String usuarios;
    private static ArrayList<Usuario> lista_usuarios = new ArrayList<>();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JLabel txtPass1;
    private javax.swing.JTextField txtUser;
    private javax.swing.JLabel txtUser1;
    // End of variables declaration//GEN-END:variables
}
