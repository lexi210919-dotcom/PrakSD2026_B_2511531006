package pekan8_2511531006;

import java.awt.*;
import javax.swing.*;

public class BubleSortGUI_1006 extends JFrame {

    private static final long serialVersionUID = 1L;
    private int[] array_1006;
    private JLabel[] labelArray_1006;
    private JButton stepButton_1006;
    private JButton resetButton_1006;
    private JButton setButton_1006;
    private JTextField inputField_1006;
    private JPanel panelArray_1006;
    private JTextArea stepArea_1006;
    private int i_1006 = 0;
    private int j_1006 = 0;
    private boolean sorting_1006 = false;
    private int stepCount_1006 = 1;
   
    public BubleSortGUI_1006() {

        setTitle("Bubble Sort Langkah per Langkah");
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel_1006 = new JPanel(new FlowLayout());

        inputField_1006 = new JTextField(30);
        setButton_1006 = new JButton("Set Array");

        inputPanel_1006.add(
                new JLabel("Masukkan angka (pisahkan dengan koma):"));
        inputPanel_1006.add(inputField_1006);
        inputPanel_1006.add(setButton_1006);

        panelArray_1006 = new JPanel();
        panelArray_1006.setLayout(new FlowLayout());

        JPanel controlPanel_1006 = new JPanel();

        stepButton_1006 = new JButton("Langkah Selanjutnya");
        resetButton_1006 = new JButton("Reset");

        stepButton_1006.setEnabled(false);

        controlPanel_1006.add(stepButton_1006);
        controlPanel_1006.add(resetButton_1006);

        stepArea_1006 = new JTextArea(8, 60);
        stepArea_1006.setEditable(false);
        stepArea_1006.setFont(
                new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scrollPane_1006 =
                new JScrollPane(stepArea_1006);

        add(inputPanel_1006, BorderLayout.NORTH);
        add(panelArray_1006, BorderLayout.CENTER);
        add(controlPanel_1006, BorderLayout.SOUTH);
        add(scrollPane_1006, BorderLayout.EAST);

        setButton_1006.addActionListener(
                e -> setArrayFromInput());

        stepButton_1006.addActionListener(
                e -> performStep());

        resetButton_1006.addActionListener(
                e -> reset());
    }

    private void setArrayFromInput() {

        String text_1006 =inputField_1006.getText().trim();
        if (text_1006.isEmpty())  return;
        String[] parts_1006 = text_1006.split(",");
        array_1006 =new int[parts_1006.length];
        try {
          for (int k_1006 = 0; k_1006 < parts_1006.length; k_1006++) {
              array_1006[k_1006] =Integer.parseInt( parts_1006[k_1006].trim());
            }
      } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog( this,"Masukkan hanya angka"
          		+ " yang dipisahkan koma!", "Error",JOptionPane.ERROR_MESSAGE);
        return;
        }

        i_1006 = 0;
        j_1006 = 0;
        stepCount_1006 = 1;
        sorting_1006 = true;
        stepButton_1006.setEnabled(true);
        stepArea_1006.setText("");
        panelArray_1006.removeAll();
        labelArray_1006 = new JLabel[array_1006.length];
        for (int k_1006 = 0; k_1006 < array_1006.length; k_1006++) {
            labelArray_1006[k_1006] =new JLabel(String.valueOf(array_1006[k_1006]));
            labelArray_1006[k_1006].setFont(new Font("Arial",Font.BOLD,24));
            labelArray_1006[k_1006].setOpaque(true);
            labelArray_1006[k_1006].setBackground(Color.WHITE);
            labelArray_1006[k_1006].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelArray_1006[k_1006].setPreferredSize(new Dimension(50, 50));
            labelArray_1006[k_1006].setHorizontalAlignment(SwingConstants.CENTER);
            panelArray_1006.add(labelArray_1006[k_1006]);
        }

        panelArray_1006.revalidate();
        panelArray_1006.repaint();
    }

    private void performStep() {
        if (!sorting_1006 || i_1006 >= array_1006.length - 1) {
             sorting_1006 = false;
             stepButton_1006.setEnabled(false);
             JOptionPane.showMessageDialog(this,"Sorting selesai!");
             return;
        }

        resetHighlights();
        StringBuilder stepLog_1006 =new StringBuilder();
        labelArray_1006[j_1006].setBackground(Color.CYAN);
        labelArray_1006[j_1006 + 1].setBackground(Color.CYAN);
        if (array_1006[j_1006]> array_1006[j_1006 + 1]) {
            // swap
            int temp_1006 =array_1006[j_1006];
            array_1006[j_1006] =array_1006[j_1006 + 1];
            array_1006[j_1006 + 1] =temp_1006;
            labelArray_1006[j_1006].setBackground(Color.RED);
            labelArray_1006[j_1006 + 1].setBackground(Color.RED);
            stepLog_1006.append("Langkah ").append(stepCount_1006).append(": Menukar elemen ke-")
                        .append(j_1006).append(  " dengan ke-")
                        .append(j_1006 + 1) .append("\n");

        } else {
       stepLog_1006.append("Langkah ").append(stepCount_1006).append(": Tidak ada pertukaran antara ke-")
                   .append(j_1006).append(" dan ke-") .append(j_1006 + 1).append("\n");
        }
       stepLog_1006.append("Hasil : ").append(arrayToString(array_1006)).append("\n\n");
       stepArea_1006.append( stepLog_1006.toString());
       updateLabels();
       j_1006++;
      if (j_1006 >= array_1006.length - i_1006 - 1) {
          j_1006 = 0;
          i_1006++;
        }
      stepCount_1006++;
    }

    private void updateLabels() {
       for (int k_1006 = 0; k_1006 < array_1006.length;k_1006++) {
            labelArray_1006[k_1006].setText(String.valueOf(array_1006[k_1006]));
        }
    }

    private void resetHighlights() {
        for (JLabel label_1006 : labelArray_1006) {
            label_1006.setBackground(Color.WHITE);
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
       i_1006 = 0;
       j_1006 = 0;
       stepCount_1006 = 1;
    }

    private String arrayToString(int[] arr_1006) {
       StringBuilder sb_1006 =new StringBuilder();
          for (int k_1006 = 0;k_1006 < arr_1006.length;k_1006++) {
              sb_1006.append(arr_1006[k_1006]);
              if (k_1006< arr_1006.length - 1) {sb_1006.append(", ");
            }
        }
       return sb_1006.toString();
    }

}