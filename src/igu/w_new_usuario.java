package igu;

import org.ini4j.Wini;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.Usuario;

public class w_new_usuario extends javax.swing.JFrame {
    
    //variables globales
    String usuarios, tipo;
    ArrayList<Usuario> lista_usuarios = new ArrayList<>();
    
    public w_new_usuario(String t) {
        initComponents();
        tipo = t;
        try{
            File archivo = new File("myiniFinal.ini"); 
            Wini ini = new Wini(new File(archivo.getAbsolutePath()));            
            usuarios = ini.get("Archivos", "usuarios");                      
        }catch(IOException e){
            javax.swing.JOptionPane.showMessageDialog(null, 
                    "Error al abrir archivo", 
                    "Error", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ComboBoxTipo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnSaveUser = new javax.swing.JButton();
        IdInput = new javax.swing.JTextField();
        UsuarioInput = new javax.swing.JTextField();
        ClaveInput = new javax.swing.JPasswordField();
        txtContra = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "administrador", "empleado" }));

        jLabel3.setText("Tipo:");

        btnSaveUser.setText("Registrar");
        btnSaveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveUserActionPerformed(evt);
            }
        });

        txtContra.setText("Contraseña:");

        txtUsuario.setText("Usuario:");

        txtId.setText("Id");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtContra)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUsuario))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSaveUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboBoxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ClaveInput)
                    .addComponent(UsuarioInput)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(IdInput, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(129, 129, 129))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId)
                    .addComponent(IdInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario)
                    .addComponent(UsuarioInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContra)
                    .addComponent(ClaveInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(btnSaveUser)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        btnVolver.setText("Volver al menu principal");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveUserActionPerformed
        this.Agregar_usuario();
        this.GrabarDatos_usuario();
        JOptionPane.showMessageDialog(null, "Nuevo usuario registrado!");
        limpiarCamposUsuario();
    }//GEN-LAST:event_btnSaveUserActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        w_principal volver = new w_principal(tipo);
        volver.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed
    
    //metodos
    public void Agregar_usuario() {
        Usuario u = new Usuario("", "", "", "");
        u.setId(this.IdInput.getText());
        u.setUsuario(this.UsuarioInput.getText());
        u.setClave(new String(this.ClaveInput.getPassword()));
        u.setTipo(this.ComboBoxTipo.getSelectedItem().toString());
        lista_usuarios.add(u);
    }

    public void GrabarDatos_usuario() {
        try {
            File archivo = new File(usuarios);
            FileOutputStream fos = new FileOutputStream(archivo.getAbsolutePath());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lista_usuarios);
            oos.close();
        } catch (IOException ex) {
        }
    }

    public void LeerDatos_usuario() {
        try {
            File archivo = new File(usuarios);
            FileInputStream fin = new FileInputStream(archivo.getAbsolutePath());
            ObjectInputStream ois = new ObjectInputStream(fin);
            try {
                lista_usuarios = (ArrayList<Usuario>) ois.readObject();
            } catch (ClassNotFoundException e) {
                System.err.println(e.getMessage());
            }
            fin.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void limpiarCamposUsuario() {
        IdInput.setText("");
        ClaveInput.setText("");
        UsuarioInput.setText("");
        ComboBoxTipo.setSelectedIndex(0);
        IdInput.requestFocus();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField ClaveInput;
    private javax.swing.JComboBox<String> ComboBoxTipo;
    private javax.swing.JTextField IdInput;
    private javax.swing.JTextField UsuarioInput;
    private javax.swing.JButton btnSaveUser;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtContra;
    private javax.swing.JLabel txtId;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
}
