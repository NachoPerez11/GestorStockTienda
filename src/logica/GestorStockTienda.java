package logica;
import igu.w_login;

public class GestorStockTienda {
    public static void main(String[] args){
        w_login Frame = new w_login();
        Frame.setVisible(true);
        Frame.pack();
        Frame.setLocationRelativeTo(null); 
    }    
}


/*
// ----------------------------------------------  MÉTODOS PARA CRUD ----------------------------------------------
    
    public void Agregar_usuario(){
        Usuario s = new Usuario("","","","");       
        s.setId(this.jTextField1.getText());
        s.setNombre(this.jTextField2.getText());
        s.setUsuario(this.jTextField3.getText());
        s.setClave(this.jTextField4.getText());
        s.setTipo(this.jComboBox1.getSelectedItem().toString());
        estructura_usuarios.add(s);
        JOptionPane.showMessageDialog(null, "dato Agregado:" );
    } 
    
    public void GrabarDatos_usuario(){
     try {
         File archivo = new File(usuarios);  
         FileOutputStream fos = new FileOutputStream(archivo.getAbsolutePath()); 
                ObjectOutputStream oos = new ObjectOutputStream(fos);   
                oos.writeObject(estructura_usuarios); // write MenuArray to ObjectOutputStream
                oos.close(); 
            } catch(Exception ex) {
                ex.printStackTrace();
            }
    }
    public void MostrarDatos_usuario(){
        String matriz[][] = new String[estructura_usuarios.size()][4];
            for (int i = 0; i < estructura_usuarios.size(); i++) {

                matriz[i][0]=estructura_usuarios.get(i).getId();
                matriz[i][1]=estructura_usuarios.get(i).getNombre();
                 matriz[i][2]=estructura_usuarios.get(i).getUsuario(); 
                 matriz[i][3]=estructura_usuarios.get(i).getTipo(); 
            }
            jTable1.setModel(new javax.swing.table.DefaultTableModel(matriz, new String [] {"Id","Nombre","usuario","Tipo"}) );
    }

    public void LeerDatos_usuario(){
              try {
                 File archivo = new File(usuarios);  
                FileInputStream fin= new FileInputStream (archivo.getAbsolutePath());  
                ObjectInputStream ois = new ObjectInputStream(fin);
                estructura_usuarios = (ArrayList<usuarios>)ois.readObject();
                fin.close();
            } catch(Exception ex) {
                ex.printStackTrace();
            }
    }
}
*/
