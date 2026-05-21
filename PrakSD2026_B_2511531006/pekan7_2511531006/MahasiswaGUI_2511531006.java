package pekan7_2511531006;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MahasiswaGUI_2511531006 extends JFrame {

    private JTextField tfNama_2511531006;
    private JTextField tfNim_2511531006;
    private JTextField tfProdi_2511531006;
    private JButton btnTambah_2511531006;
    private JButton btnHapus_2511531006;
    private JButton btnSort_2511531006;
    private JComboBox<String> cbAlgoritma_2511531006;
    private JTable table_2511531006;
    private DefaultTableModel tableModel_2511531006;
    private JTextArea taLog_2511531006;
    private ArrayList<Mahasiswa_2511531006> dataList_2511531006;

    public MahasiswaGUI_2511531006() {
        setTitle("Aplikasi Sorting Nama Mahasiswa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);

        dataList_2511531006 = new ArrayList<>();
        initComponents_2511531006();
        setVisible(true);
    }

    private void initComponents_2511531006() {
        JPanel mainPanel_2511531006 = new JPanel(new BorderLayout(10, 10));
        mainPanel_2511531006.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel inputPanel_2511531006 = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel_2511531006.setBorder(BorderFactory.createTitledBorder("Input Data Mahasiswa"));

        inputPanel_2511531006.add(new JLabel("Nama:"));
        tfNama_2511531006 = new JTextField();
        inputPanel_2511531006.add(tfNama_2511531006);

        inputPanel_2511531006.add(new JLabel("NIM:"));
        tfNim_2511531006 = new JTextField();
        inputPanel_2511531006.add(tfNim_2511531006);

        inputPanel_2511531006.add(new JLabel("Prodi:"));
        tfProdi_2511531006 = new JTextField();
        inputPanel_2511531006.add(tfProdi_2511531006);

        btnTambah_2511531006 = new JButton("Tambah Data");
        inputPanel_2511531006.add(btnTambah_2511531006);

        btnHapus_2511531006 = new JButton("Hapus Data");
        inputPanel_2511531006.add(btnHapus_2511531006);

        mainPanel_2511531006.add(inputPanel_2511531006, BorderLayout.NORTH);

        String[] columnNames_2511531006 = {"No", "Nama", "NIM", "Prodi"};
        tableModel_2511531006 = new DefaultTableModel(columnNames_2511531006, 0) {
            @Override
            public boolean isCellEditable(int row_2511531006, int column_2511531006) {
                return false;
            }
        };

        table_2511531006 = new JTable(tableModel_2511531006);
        mainPanel_2511531006.add(new JScrollPane(table_2511531006), BorderLayout.CENTER);

        JPanel bottomPanel_2511531006 = new JPanel(new BorderLayout(10, 10));

        JPanel controlPanel_2511531006 = new JPanel();
        controlPanel_2511531006.add(new JLabel("Pilih Algoritma:"));
        cbAlgoritma_2511531006 = new JComboBox<>();
        cbAlgoritma_2511531006.addItem("Insertion Sort");
        cbAlgoritma_2511531006.addItem("Selection Sort");
        cbAlgoritma_2511531006.addItem("Bubble Sort");
        controlPanel_2511531006.add(cbAlgoritma_2511531006);

        btnSort_2511531006 = new JButton("Mulai Sorting");
        controlPanel_2511531006.add(btnSort_2511531006);

        bottomPanel_2511531006.add(controlPanel_2511531006, BorderLayout.NORTH);

        taLog_2511531006 = new JTextArea(10, 50);
        taLog_2511531006.setEditable(false);
        bottomPanel_2511531006.add(new JScrollPane(taLog_2511531006), BorderLayout.CENTER);

        mainPanel_2511531006.add(bottomPanel_2511531006, BorderLayout.SOUTH);

        add(mainPanel_2511531006);

        btnTambah_2511531006.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e_2511531006) {
                tambahData_2511531006();
            }
        });

        btnHapus_2511531006.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e_2511531006) {
                hapusData_2511531006();
            }
        });

        btnSort_2511531006.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e_2511531006) {
                mulaiSorting_2511531006();
            }
        });
    }

    private void tambahData_2511531006() {
        String nama_2511531006 = tfNama_2511531006.getText();
        String nim_2511531006  = tfNim_2511531006.getText();
        String prodi_2511531006 = tfProdi_2511531006.getText();

        if (nama_2511531006.isEmpty() || nim_2511531006.isEmpty() || prodi_2511531006.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Isi semua data!");
            return;
        }

        dataList_2511531006.add(new Mahasiswa_2511531006(nama_2511531006, nim_2511531006, prodi_2511531006));
        updateTabel_2511531006();

        tfNama_2511531006.setText("");
        tfNim_2511531006.setText("");
        tfProdi_2511531006.setText("");
    }

    private void hapusData_2511531006() {
        int row_2511531006 = table_2511531006.getSelectedRow();
        if (row_2511531006 >= 0) {
            dataList_2511531006.remove(row_2511531006);
            updateTabel_2511531006();
        }
    }

    private void updateTabel_2511531006() {
        tableModel_2511531006.setRowCount(0);
        int no_2511531006 = 1;
        for (Mahasiswa_2511531006 m_2511531006 : dataList_2511531006) {
            tableModel_2511531006.addRow(new Object[]{
                no_2511531006++,
                m_2511531006.getNama_2511531006(),
                m_2511531006.getNim_2511531006(),
                m_2511531006.getProdi_2511531006()
            });
        }
    }

    private String getNamaList_2511531006() {
        StringBuilder sb_2511531006 = new StringBuilder("[");
        for (int i_2511531006 = 0; i_2511531006 < dataList_2511531006.size(); i_2511531006++) {
            sb_2511531006.append(dataList_2511531006.get(i_2511531006).getNama_2511531006());
            if (i_2511531006 < dataList_2511531006.size() - 1) sb_2511531006.append(", ");
        }
        return sb_2511531006.append("]").toString();
    }

    private void mulaiSorting_2511531006() {
        if (dataList_2511531006.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data kosong!");
            return;
        }

        String algo_2511531006 = (String) cbAlgoritma_2511531006.getSelectedItem();
        taLog_2511531006.setText("=== " + algo_2511531006 + " ===\n");
        taLog_2511531006.append("Data Awal: " + getNamaList_2511531006() + "\n\n");

        if (algo_2511531006.equals("Insertion Sort")) {
            insertionSort_2511531006();
        } else if (algo_2511531006.equals("Selection Sort")) {
            selectionSort_2511531006();
        } else {
            bubbleSort_2511531006();
        }

        taLog_2511531006.append("Hasil: " + getNamaList_2511531006());
        updateTabel_2511531006();
    }

    private void insertionSort_2511531006() {
        int n_2511531006 = dataList_2511531006.size();
        for (int i_2511531006 = 1; i_2511531006 < n_2511531006; i_2511531006++) {
            Mahasiswa_2511531006 key_2511531006 = dataList_2511531006.get(i_2511531006);
            int j_2511531006 = i_2511531006 - 1;
            while (j_2511531006 >= 0 && dataList_2511531006.get(j_2511531006).getNama_2511531006()
                    .compareToIgnoreCase(key_2511531006.getNama_2511531006()) > 0) {
                dataList_2511531006.set(j_2511531006 + 1, dataList_2511531006.get(j_2511531006));
                j_2511531006--;
            }
            dataList_2511531006.set(j_2511531006 + 1, key_2511531006);
            taLog_2511531006.append("Langkah " + i_2511531006 + ": " + getNamaList_2511531006() + "\n");
        }
    }

    private void selectionSort_2511531006() {
        int n_2511531006 = dataList_2511531006.size();
        for (int i_2511531006 = 0; i_2511531006 < n_2511531006 - 1; i_2511531006++) {
            int min_2511531006 = i_2511531006;
            for (int j_2511531006 = i_2511531006 + 1; j_2511531006 < n_2511531006; j_2511531006++) {
                if (dataList_2511531006.get(j_2511531006).getNama_2511531006()
                        .compareToIgnoreCase(dataList_2511531006.get(min_2511531006).getNama_2511531006()) < 0) {
                    min_2511531006 = j_2511531006;
                }
            }
            if (min_2511531006 != i_2511531006) {
                Mahasiswa_2511531006 temp_2511531006 = dataList_2511531006.get(i_2511531006);
                dataList_2511531006.set(i_2511531006, dataList_2511531006.get(min_2511531006));
                dataList_2511531006.set(min_2511531006, temp_2511531006);
            }
            taLog_2511531006.append("Pass " + (i_2511531006 + 1) + ": " + getNamaList_2511531006() + "\n");
        }
    }

    private void bubbleSort_2511531006() {
        int n_2511531006 = dataList_2511531006.size();
        for (int i_2511531006 = 0; i_2511531006 < n_2511531006 - 1; i_2511531006++) {
            for (int j_2511531006 = 0; j_2511531006 < n_2511531006 - i_2511531006 - 1; j_2511531006++) {
                if (dataList_2511531006.get(j_2511531006).getNama_2511531006()
                        .compareToIgnoreCase(dataList_2511531006.get(j_2511531006 + 1).getNama_2511531006()) > 0) {
                    Mahasiswa_2511531006 temp_2511531006 = dataList_2511531006.get(j_2511531006);
                    dataList_2511531006.set(j_2511531006, dataList_2511531006.get(j_2511531006 + 1));
                    dataList_2511531006.set(j_2511531006 + 1, temp_2511531006);
                }
            }
            taLog_2511531006.append("Pass " + (i_2511531006 + 1) + ": " + getNamaList_2511531006() + "\n");
        }
    }

    public static void main(String[] args_2511531006) {
        new MahasiswaGUI_2511531006();
    }
}
