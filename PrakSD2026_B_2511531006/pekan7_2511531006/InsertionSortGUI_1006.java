package pekan7_2511531006;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class InsertionSortGUI_1006 extends JFrame {
   private static final long serialVersionUID = 1L;
   private int[] array_1006;
   private JLabel[] labelArray_1006;
   private JButton stepButton_1006, resetButton_1006, setButton_1006;
   private JTextField inputField_1006;
   private JPanel panelArray_1006;
   private JTextArea stepArea_1006;
   private int i_1006 = 1, j_1006;
   private boolean sorting_1006 = false;
   private int stepCount_1006 = 1;

    public InsertionSortGUI_1006() {

        setTitle("Insertion Sort Langkah per Langkah");
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel input
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputField_1006 = new JTextField(30);
        setButton_1006 = new JButton("Set Array");
        inputPanel.add(new JLabel("Masukkan angka (pisahkan dengan koma):"));
        inputPanel.add(inputField_1006);
        inputPanel.add(setButton_1006);

        // Panel array visual
        panelArray_1006 = new JPanel();
        panelArray_1006.setLayout(new FlowLayout());

        // Panel kontrol
        JPanel controlPanel = new JPanel();
        stepButton_1006 = new JButton("Langkah Selanjutnya");
        resetButton_1006 = new JButton("Reset");
        stepButton_1006.setEnabled(false);
        controlPanel.add(stepButton_1006);
        controlPanel.add(resetButton_1006);

        // Area teks untuk log langkah-langkah
        stepArea_1006 = new JTextArea(8, 60);
        stepArea_1006.setEditable(false);
        stepArea_1006.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(stepArea_1006);

        // Tambahkan panel ke frame
        add(inputPanel, BorderLayout.NORTH);
        add(panelArray_1006, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.EAST);

        // Event Set Array
        setButton_1006.addActionListener(e -> setArrayFromInput());

        // Event Langkah Selanjutnya
        stepButton_1006.addActionListener(e -> performStep());

        // Event Reset
        resetButton_1006.addActionListener(e -> reset());

    }

    private void setArrayFromInput() {
    String text = inputField_1006.getText().trim();
    if (text.isEmpty()) return;
    String[] parts = text.split(",");
    array_1006 = new int[parts.length];
    try {
        for (int k_1006 = 0; k_1006 < parts.length; k_1006++) {
            array_1006[k_1006] = Integer.parseInt(parts[k_1006].trim());
      }
    } catch (NumberFormatException e) {
         JOptionPane.showMessageDialog(this,"Masukkan hanya angka yang dipisahkan"
        		  + "dengan koma!","Error",JOptionPane.ERROR_MESSAGE  );
         return;    }
     i_1006 = 1;
     stepCount_1006 = 1;
     sorting_1006 = true;
     stepButton_1006.setEnabled(true);
     stepArea_1006.setText("");
     panelArray_1006.removeAll();
     labelArray_1006 = new JLabel[array_1006.length];
     for (int k_1006 = 0; k_1006 < array_1006.length; k_1006++) {
         labelArray_1006[k_1006] = new JLabel(String.valueOf(array_1006[k_1006]));
         labelArray_1006[k_1006].setFont( new Font("Arial", Font.BOLD, 24));
         labelArray_1006[k_1006].setBorder( BorderFactory.createLineBorder(Color.BLACK));
         labelArray_1006[k_1006].setPreferredSize(new Dimension(50, 50));
         labelArray_1006[k_1006].setHorizontalAlignment( SwingConstants.CENTER);
         panelArray_1006.add(labelArray_1006[k_1006]);
    }
     panelArray_1006.revalidate();
     panelArray_1006.repaint();

    }
   private void performStep() {
      if (i_1006 < array_1006.length && sorting_1006) {
          int key_1006 = array_1006[i_1006];
          j_1006 = i_1006 - 1;

        StringBuilder stepLog_1006 = new StringBuilder();
        stepLog_1006.append("Langkah ").append(stepCount_1006)
        .append(":Memasukkan ") .append(key_1006).append("\n");

        while (j_1006 >= 0 && array_1006[j_1006] > key_1006) {
        array_1006[j_1006 + 1] = array_1006[j_1006];
        j_1006--;

        }

        array_1006[j_1006 + 1] = key_1006;
        updateLabels_1006();
        stepLog_1006.append("Hasil: ") .append(arrayToString_1006(array_1006)) .append("\n\n");
        stepArea_1006.append(stepLog_1006.toString());

        i_1006++;
        stepCount_1006++;

        if (i_1006 >= array_1006.length) {
              sorting_1006 = false;
              stepButton_1006.setEnabled(false);
              JOptionPane.showMessageDialog( this,"Sorting selesai!");
        }
      }
   }
      private void updateLabels_1006() {
           for (int k_1006 = 0; k_1006 < array_1006.length; k_1006++) {
              labelArray_1006[k_1006].setText(String.valueOf(array_1006[k_1006]));
    	    }
    	}
    private void reset() {
        inputField_1006.setText("");
        panelArray_1006.removeAll();
        panelArray_1006.revalidate();
        panelArray_1006.repaint();
        stepArea_1006.setText("");
        stepButton_1006.setEnabled(false);
        sorting_1006 = false;
        i_1006 = 1;
       stepCount_1006 = 1;
    	}
    private String arrayToString_1006(int[] arr_1006) {
       StringBuilder sb_1006 = new StringBuilder();
       for (int k_1006 = 0; k_1006 < arr_1006.length; k_1006++) {
            sb_1006.append(arr_1006[k_1006]);
            if (k_1006 < arr_1006.length - 1) {
             sb_1006.append(", ");
    	        }
    	    }

    	    return sb_1006.toString();
    	}

    	public static void main(String[] args) {
          SwingUtilities.invokeLater(() -> {
                 InsertionSortGUI_1006 gui_1006 = new InsertionSortGUI_1006();
                 gui_1006.setVisible(true);

    	    });
    	}
    	}
