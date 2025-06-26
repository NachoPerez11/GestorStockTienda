package igu;

import org.ini4j.Wini;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import logica.Producto;

public class w_lista_productos extends javax.swing.JFrame {
    
    //variables globales
    String archivoProductos, tipo;   
    ArrayList <Producto> listaProductos = new ArrayList<>();
    
    public w_lista_productos(String t) {
        initComponents();
        tipo = t;
        try {
            File archivo = new File("myiniFinal.ini");
            Wini ini = new Wini(new File(archivo.getAbsolutePath()));
            archivoProductos = ini.get("Archivos", "productos");
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(null, 
                    "Error al abrir el archivo", 
                    "Error", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        this.cargarDatos();
        this.mostrarDatos();
    }
    
    private void cargarDatos() {
        try {
            File archivo = new File(archivoProductos);
            FileInputStream fis = new FileInputStream(archivo.getAbsolutePath());
            ObjectInputStream ois = new ObjectInputStream(fis);
            listaProductos = (ArrayList<Producto>) ois.readObject();
            ois.close();
        }catch (IOException | ClassNotFoundException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, 
                    "Error al abrir el archivo", 
                    "Error", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    private void mostrarDatos() {
        String matriz[][] = new String[listaProductos.size()][6];
        for (int i = 0; i < listaProductos.size(); i++) {
            matriz[i][0] = String.valueOf(listaProductos.get(i).getCantidadStock());
            matriz[i][1] = listaProductos.get(i).getNombre();
            matriz[i][2] = listaProductos.get(i).getCodigo();
            matriz[i][3] = listaProductos.get(i).getDescripcion();
            matriz[i][4] = String.valueOf(listaProductos.get(i).getPrecioVenta() + "0");
        }
        jTableProd.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{"Stock", "Nombre", "Código", "Descripción", "Precio"}));
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProd = new javax.swing.JTable();
        jLabelLista = new javax.swing.JLabel();
        btnVolverMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Código", "Stock", "Precio", "Descripción"
            }
        ));
        jScrollPane1.setViewportView(jTableProd);

        jLabelLista.setText("LISTA DE PRODUCTOS");

        btnVolverMenu.setText("Volver al menú principal");
        btnVolverMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabelLista, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVolverMenu)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLista)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVolverMenu)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverMenuActionPerformed
        w_principal volver = new w_principal(tipo);
        volver.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverMenuActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolverMenu;
    private javax.swing.JLabel jLabelLista;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProd;
    // End of variables declaration//GEN-END:variables
}
