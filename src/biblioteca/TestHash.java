package biblioteca;

import Hashh.TablaHash;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author José
 */
public class TestHash {
    
    public static void main(String[] args) {
       int tam = Integer.parseInt(JOptionPane.showInputDialog("Número de datos a registrar"));
       VentanaPrincipal.n(tam);
       VentanaPrincipal vp = new VentanaPrincipal();
       vp.setVisible(true);
    }
}
