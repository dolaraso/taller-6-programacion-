import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusquedaLinealGUI {
    private JPanel pGeneral;
    private JTextField txtValorBuscado;
    private JLabel Resultado;
    private JButton Buscar;
    private int[] array = {5, 3, 9, 2, 7, 1}; // Array de ejemplo

    public BusquedaLinealGUI() {
        Buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarValor();
            }
        });
    }

    private void buscarValor() {
        String valorBuscado = txtValorBuscado.getText();
        try {
            int valor = Integer.parseInt(valorBuscado);
            int resultado = BusquedaLineal.buscar(array, valor);
            if (resultado != -1) {
                Resultado.setText("El valor " + valor + " se encuentra en la posición: " + (resultado+1));
            } else {
                Resultado.setText("El valor " + valor + " no se encuentra en el arreglo.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Búsqueda Lineal");
        frame.setContentPane(new BusquedaLinealGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
