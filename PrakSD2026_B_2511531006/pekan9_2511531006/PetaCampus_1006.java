package pekan9_2511531006;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import java.util.List;
 
public class PetaCampus_1006 extends JFrame {
 
    private Map<String, List<String>> graph_1006 = new LinkedHashMap<>();
    private Map<String, Point> posisiNode_1006 = new LinkedHashMap<>();
    private List<String> jalurDitemukan_1006 = new ArrayList<>();
    private List<String> nodeDikunjungi_1006 = new ArrayList<>();
    private Set<String> nodeVisited_1006 = new HashSet<>();
    private Set<String> nodeOnPath_1006 = new HashSet<>();
    private String startNode_1006 = "";
    private String goalNode_1006 = "";
    private JComboBox<String> comboAwal_1006;
    private JComboBox<String> comboTujuan_1006;
    private PanelGraph_1006 panelGraph_1006;
    private JLabel labelJalur_1006;
    private JLabel labelNodeDikunjungi_1006;
    private JLabel labelJumlahNode_1006;
    private JLabel labelHasil_1006;
 
    public PetaCampus_1006() {
        initGraph_1006();
        initGUI_1006();
    }
 
    private void initGraph_1006() {
        String[] nodes_1006 = {
            "Gerbang Utama", "Rektorat", "Perpustakaan", "FTI",
            "FKIP", "Lab Komputer", "Lab Jaringan", "Labor AI",
            "PKM", "Masjid", "Kantin", "Lapangan"
        };
 
        for (String node : nodes_1006) {
            graph_1006.put(node, new ArrayList<>());
        }
 
        addEdge_1006("Gerbang Utama", "Rektorat");
        addEdge_1006("Gerbang Utama", "Masjid");
        addEdge_1006("Gerbang Utama", "Lapangan");
        addEdge_1006("Rektorat", "Perpustakaan");
        addEdge_1006("Rektorat", "PKM");
        addEdge_1006("Rektorat", "FTI");
        addEdge_1006("Perpustakaan", "FTI");
        addEdge_1006("FTI", "Lab Komputer");
        addEdge_1006("FTI", "Lab Jaringan");
        addEdge_1006("Lab Komputer", "Labor AI");
        addEdge_1006("Lab Jaringan", "Labor AI");
        addEdge_1006("Lab Jaringan", "PKM");
        addEdge_1006("PKM", "Kantin");
        addEdge_1006("PKM", "FKIP");
        addEdge_1006("Masjid", "Kantin");
        addEdge_1006("Masjid", "Lapangan");
        addEdge_1006("FKIP", "Kantin");
        addEdge_1006("Lapangan", "Kantin");
 
        posisiNode_1006.put("Gerbang Utama", new Point(230, 60));
        posisiNode_1006.put("Rektorat",      new Point(370, 130));
        posisiNode_1006.put("Perpustakaan",  new Point(130, 130));
        posisiNode_1006.put("FTI",           new Point(540, 130));
        posisiNode_1006.put("FKIP",          new Point(370, 260));
        posisiNode_1006.put("Lab Komputer",  new Point(620, 230));
        posisiNode_1006.put("Lab Jaringan",  new Point(540, 290));
        posisiNode_1006.put("Labor AI",      new Point(620, 360));
        posisiNode_1006.put("PKM",           new Point(420, 200));
        posisiNode_1006.put("Masjid",        new Point(100, 250));
        posisiNode_1006.put("Kantin",        new Point(260, 360));
        posisiNode_1006.put("Lapangan",      new Point(130, 360));
    }
 
    private void addEdge_1006(String a, String b) {
        graph_1006.get(a).add(b);
        graph_1006.get(b).add(a);
    }
 
    private void initGUI_1006() {
        setTitle("PENCARIAN JALUR MENGGUNAKAN BFS DAN DFS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(780, 680);
        setLocationRelativeTo(null);
        setResizable(false);
 
        // Warna tema
        Color colorBg_1006      = new Color(30, 30, 45);
        Color colorPanel_1006   = new Color(40, 42, 60);
        Color colorHeader_1006  = new Color(25, 25, 40);
        Color colorBorder_1006  = new Color(80, 85, 120);
        Color colorText_1006    = new Color(220, 225, 255);
        Color colorBFS_1006     = new Color(40, 180, 90);
        Color colorDFS_1006     = new Color(220, 140, 30);
        Color colorReset_1006   = new Color(210, 50, 50);
 
        JPanel mainPanel_1006 = new JPanel(new BorderLayout(0, 0));
        mainPanel_1006.setBackground(colorBg_1006);
 
        // ===== HEADER =====
        JPanel headerPanel_1006 = new JPanel();
        headerPanel_1006.setBackground(colorHeader_1006);
        headerPanel_1006.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, colorBorder_1006));
        headerPanel_1006.setPreferredSize(new Dimension(780, 50));
        JLabel titleLabel_1006 = new JLabel("PENCARIAN JALUR MENGGUNAKAN BFS DAN DFS");
        titleLabel_1006.setFont(new Font("Consolas", Font.BOLD, 16));
        titleLabel_1006.setForeground(colorText_1006);
        headerPanel_1006.add(titleLabel_1006);
        mainPanel_1006.add(headerPanel_1006, BorderLayout.NORTH);
 
        // ===== KONTROL PANEL =====
        JPanel controlPanel_1006 = new JPanel(new FlowLayout(FlowLayout.LEFT, 18, 10));
        controlPanel_1006.setBackground(colorBg_1006);
        controlPanel_1006.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, colorBorder_1006));
 
        // Label & ComboBox
        Font labelFont_1006 = new Font("Consolas", Font.PLAIN, 13);
        Font comboFont_1006 = new Font("Consolas", Font.PLAIN, 12);
 
        JLabel lblAwal_1006 = new JLabel("Lokasi Awal   : [");
        lblAwal_1006.setFont(labelFont_1006);
        lblAwal_1006.setForeground(colorText_1006);
 
        comboAwal_1006 = new JComboBox<>(graph_1006.keySet().toArray(new String[0]));
        comboAwal_1006.setFont(comboFont_1006);
        comboAwal_1006.setBackground(new Color(55, 58, 80));
        comboAwal_1006.setForeground(colorText_1006);
        comboAwal_1006.setPreferredSize(new Dimension(145, 26));
 
        JLabel lblBrAwal_1006 = new JLabel("]");
        lblBrAwal_1006.setFont(labelFont_1006);
        lblBrAwal_1006.setForeground(colorText_1006);
 
        JLabel lblTujuan_1006 = new JLabel("Lokasi Tujuan : [");
        lblTujuan_1006.setFont(labelFont_1006);
        lblTujuan_1006.setForeground(colorText_1006);
 
        comboTujuan_1006 = new JComboBox<>(graph_1006.keySet().toArray(new String[0]));
        comboTujuan_1006.setFont(comboFont_1006);
        comboTujuan_1006.setBackground(new Color(55, 58, 80));
        comboTujuan_1006.setForeground(colorText_1006);
        comboTujuan_1006.setPreferredSize(new Dimension(145, 26));
        comboTujuan_1006.setSelectedIndex(7); // default: Labor AI
 
        JLabel lblBrTujuan_1006 = new JLabel("]");
        lblBrTujuan_1006.setFont(labelFont_1006);
        lblBrTujuan_1006.setForeground(colorText_1006);
 
        // Tombol
        JButton btnBFS_1006   = buatTombol_1006("[ BFS ]",   colorBFS_1006,   colorText_1006);
        JButton btnDFS_1006   = buatTombol_1006("[ DFS ]",   colorDFS_1006,   colorText_1006);
        JButton btnReset_1006 = buatTombol_1006("[ RESET ]", colorReset_1006, colorText_1006);
 
        // Layout kontrol: dua baris
        JPanel inputPanel_1006 = new JPanel(new GridLayout(2, 1, 4, 4));
        inputPanel_1006.setBackground(colorBg_1006);
 
        JPanel row1_1006 = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 2));
        row1_1006.setBackground(colorBg_1006);
        row1_1006.add(lblAwal_1006);
        row1_1006.add(comboAwal_1006);
        row1_1006.add(lblBrAwal_1006);
 
        JPanel row2_1006 = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 2));
        row2_1006.setBackground(colorBg_1006);
        row2_1006.add(lblTujuan_1006);
        row2_1006.add(comboTujuan_1006);
        row2_1006.add(lblBrTujuan_1006);
 
        inputPanel_1006.add(row1_1006);
        inputPanel_1006.add(row2_1006);
 
        JPanel btnPanel_1006 = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 10));
        btnPanel_1006.setBackground(colorBg_1006);
        btnPanel_1006.add(btnBFS_1006);
        btnPanel_1006.add(btnDFS_1006);
        btnPanel_1006.add(btnReset_1006);
 
        controlPanel_1006.add(inputPanel_1006);
        controlPanel_1006.add(btnPanel_1006);
        mainPanel_1006.add(controlPanel_1006, BorderLayout.CENTER);
 
        // ===== GRAPH PANEL =====
        panelGraph_1006 = new PanelGraph_1006();
        panelGraph_1006.setPreferredSize(new Dimension(760, 430));
        panelGraph_1006.setBackground(colorPanel_1006);
        panelGraph_1006.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(colorBorder_1006, 1),
            "VISUALISASI GRAPH",
            TitledBorder.LEFT, TitledBorder.TOP,
            new Font("Consolas", Font.BOLD, 12),
            colorText_1006
        ));
 
        // ===== HASIL PANEL =====
        JPanel hasilPanel_1006 = new JPanel(new GridLayout(4, 1, 2, 2));
        hasilPanel_1006.setBackground(colorPanel_1006);
        hasilPanel_1006.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(1, 0, 0, 0, colorBorder_1006),
            BorderFactory.createEmptyBorder(6, 12, 6, 12)
        ));
 
        Font hasilFont_1006 = new Font("Consolas", Font.BOLD, 12);
        labelHasil_1006          = buatLabelHasil_1006("Hasil Pencarian :", hasilFont_1006, colorText_1006, colorPanel_1006);
        labelJalur_1006          = buatLabelHasil_1006("Jalur :", hasilFont_1006, new Color(100, 220, 255), colorPanel_1006);
        labelNodeDikunjungi_1006 = buatLabelHasil_1006("Node Dikunjungi :", hasilFont_1006, new Color(180, 255, 150), colorPanel_1006);
        labelJumlahNode_1006     = buatLabelHasil_1006("Jumlah Node Dikunjungi : 0", hasilFont_1006, new Color(255, 200, 100), colorPanel_1006);
 
        hasilPanel_1006.add(labelHasil_1006);
        hasilPanel_1006.add(labelJalur_1006);
        hasilPanel_1006.add(labelNodeDikunjungi_1006);
        hasilPanel_1006.add(labelJumlahNode_1006);
 
        JPanel southPanel_1006 = new JPanel(new BorderLayout());
        southPanel_1006.setBackground(colorBg_1006);
        southPanel_1006.add(panelGraph_1006, BorderLayout.CENTER);
        southPanel_1006.add(hasilPanel_1006, BorderLayout.SOUTH);
        mainPanel_1006.add(southPanel_1006, BorderLayout.SOUTH);
 
        // ===== AKSI TOMBOL =====
        btnBFS_1006.addActionListener(e -> jalankanBFS_1006());
        btnDFS_1006.addActionListener(e -> jalankanDFS_1006());
        btnReset_1006.addActionListener(e -> resetGraph_1006());
 
        setContentPane(mainPanel_1006);
        setVisible(true);
    }
 
    private JButton buatTombol_1006(String teks, Color bg, Color fg) {
        JButton btn = new JButton(teks);
        btn.setFont(new Font("Consolas", Font.BOLD, 13));
        btn.setBackground(bg);
        btn.setForeground(fg);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(fg.darker(), 1),
            BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return btn;
    }
 
    private JLabel buatLabelHasil_1006(String teks, Font f, Color fg, Color bg) {
        JLabel lbl = new JLabel(teks);
        lbl.setFont(f);
        lbl.setForeground(fg);
        lbl.setBackground(bg);
        lbl.setOpaque(true);
        return lbl;
    }

    private void jalankanBFS_1006() {
        startNode_1006 = (String) comboAwal_1006.getSelectedItem();
        goalNode_1006  = (String) comboTujuan_1006.getSelectedItem();
 
        if (startNode_1006.equals(goalNode_1006)) {
            tampilkanPesan_1006("Start dan Goal tidak boleh sama!");
            return;
        }
 
        nodeDikunjungi_1006.clear();
        jalurDitemukan_1006.clear();
        nodeVisited_1006.clear();
        nodeOnPath_1006.clear();
 
        // BFS dengan parent tracking
        Map<String, String> parent_1006 = new LinkedHashMap<>();
        Queue<String> antrian_1006 = new LinkedList<>();
        Set<String> dikunjungi_1006 = new LinkedHashSet<>();
 
        antrian_1006.add(startNode_1006);
        dikunjungi_1006.add(startNode_1006);
        parent_1006.put(startNode_1006, null);
        boolean ditemukan_1006 = false;
 
        while (!antrian_1006.isEmpty()) {
            String current_1006 = antrian_1006.poll();
            nodeDikunjungi_1006.add(current_1006);
            nodeVisited_1006.add(current_1006);
 
            if (current_1006.equals(goalNode_1006)) {
                ditemukan_1006 = true;
                break;
            }
 
            List<String> neighbors_1006 = graph_1006.get(current_1006);
            Collections.sort(neighbors_1006); // BFS terurut
            for (String neighbor_1006 : neighbors_1006) {
                if (!dikunjungi_1006.contains(neighbor_1006)) {
                    dikunjungi_1006.add(neighbor_1006);
                    antrian_1006.add(neighbor_1006);
                    parent_1006.put(neighbor_1006, current_1006);
                }
            }
        }
 
        if (ditemukan_1006) {
            rekonstruksiJalur_1006(parent_1006);
        }
 
        displayPath_1006("BFS", ditemukan_1006);
        panelGraph_1006.repaint();
    }
 
    private void jalankanDFS_1006() {
        startNode_1006 = (String) comboAwal_1006.getSelectedItem();
        goalNode_1006  = (String) comboTujuan_1006.getSelectedItem();
 
        if (startNode_1006.equals(goalNode_1006)) {
            tampilkanPesan_1006("Start dan Goal tidak boleh sama!");
            return;
        }
 
        nodeDikunjungi_1006.clear();
        jalurDitemukan_1006.clear();
        nodeVisited_1006.clear();
        nodeOnPath_1006.clear();
 
        Map<String, String> parent_1006 = new LinkedHashMap<>();
        Set<String> dikunjungi_1006 = new LinkedHashSet<>();
        Deque<String> stack_1006 = new ArrayDeque<>();
        boolean[] ditemukan_1006 = {false};
 
        dfsBFS_1006(startNode_1006, goalNode_1006, dikunjungi_1006, parent_1006, ditemukan_1006);
 
        if (ditemukan_1006[0]) {
            rekonstruksiJalur_1006(parent_1006);
        }
 
        displayPath_1006("DFS", ditemukan_1006[0]);
        panelGraph_1006.repaint();
    }
 
    private void dfsBFS_1006(String node, String goal, Set<String> visited, Map<String, String> parent, boolean[] found) {
        if (found[0]) return;
        visited.add(node);
        nodeDikunjungi_1006.add(node);
        nodeVisited_1006.add(node);
 
        if (node.equals(goal)) {
            found[0] = true;
            return;
        }
 
        List<String> neighbors_1006 = new ArrayList<>(graph_1006.get(node));
        Collections.sort(neighbors_1006);
        for (String neighbor : neighbors_1006) {
            if (!visited.contains(neighbor)) {
                parent.put(neighbor, node);
                dfsBFS_1006(neighbor, goal, visited, parent, found);
                if (found[0]) return;
            }
        }
    }
 
    private void rekonstruksiJalur_1006(Map<String, String> parent_1006) {
        LinkedList<String> jalur_1006 = new LinkedList<>();
        String current_1006 = goalNode_1006;
        while (current_1006 != null) {
            jalur_1006.addFirst(current_1006);
            current_1006 = parent_1006.get(current_1006);
        }
        jalurDitemukan_1006.addAll(jalur_1006);
        nodeOnPath_1006.addAll(jalur_1006);
    }
 
    private void displayPath_1006(String metode, boolean ditemukan) {
        labelHasil_1006.setText("Hasil Pencarian : " + metode +
            " | " + startNode_1006 + " → " + goalNode_1006);
 
        if (ditemukan) {
            String jalurStr = String.join(" → ", jalurDitemukan_1006);
            labelJalur_1006.setText("Jalur : " + jalurStr);
            String nodeStr = String.join(", ", nodeDikunjungi_1006);
            labelNodeDikunjungi_1006.setText("Node Dikunjungi : " + nodeStr);
        } else {
            labelJalur_1006.setText("Jalur : Tidak ditemukan");
            labelNodeDikunjungi_1006.setText("Node Dikunjungi : " + String.join(", ", nodeDikunjungi_1006));
        }
        labelJumlahNode_1006.setText("Jumlah Node Dikunjungi : " + nodeDikunjungi_1006.size());
    }
 
    private void resetGraph_1006() {
        nodeDikunjungi_1006.clear();
        jalurDitemukan_1006.clear();
        nodeVisited_1006.clear();
        nodeOnPath_1006.clear();
        startNode_1006 = "";
        goalNode_1006  = "";
        labelHasil_1006.setText("Hasil Pencarian :");
        labelJalur_1006.setText("Jalur :");
        labelNodeDikunjungi_1006.setText("Node Dikunjungi :");
        labelJumlahNode_1006.setText("Jumlah Node Dikunjungi : 0");
        panelGraph_1006.repaint();
    }
 
    private void tampilkanPesan_1006(String pesan) {
        JOptionPane.showMessageDialog(this, pesan, "Peringatan", JOptionPane.WARNING_MESSAGE);
    }
 
    class PanelGraph_1006 extends JPanel {
        private static final int R_1006 = 28; // radius node
 
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2_1006 = (Graphics2D) g;
            g2_1006.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2_1006.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
 
            drawEdges_1006(g2_1006);
            drawNodes_1006(g2_1006);
        }
 
        private void drawEdges_1006(Graphics2D g2) {
            Set<String> drawnEdge_1006 = new HashSet<>();
 
            for (String nodeA : graph_1006.keySet()) {
                for (String nodeB : graph_1006.get(nodeA)) {
                    String key1 = nodeA + "-" + nodeB;
                    String key2 = nodeB + "-" + nodeA;
                    if (drawnEdge_1006.contains(key1) || drawnEdge_1006.contains(key2)) continue;
                    drawnEdge_1006.add(key1);
 
                    Point pA = posisiNode_1006.get(nodeA);
                    Point pB = posisiNode_1006.get(nodeB);
                    if (pA == null || pB == null) continue;
 
                    // Cek apakah edge ini bagian dari jalur
                    boolean isPathEdge_1006 = false;
                    if (jalurDitemukan_1006.size() > 1) {
                        for (int i = 0; i < jalurDitemukan_1006.size() - 1; i++) {
                            String a = jalurDitemukan_1006.get(i);
                            String b = jalurDitemukan_1006.get(i + 1);
                            if ((a.equals(nodeA) && b.equals(nodeB)) ||
                                (a.equals(nodeB) && b.equals(nodeA))) {
                                isPathEdge_1006 = true;
                                break;
                            }
                        }
                    }
 
                    if (isPathEdge_1006) {
                        g2.setColor(new Color(80, 220, 255));
                        g2.setStroke(new BasicStroke(3.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                            0, new float[]{8, 4}, 0));
                    } else {
                        g2.setColor(new Color(90, 95, 130));
                        g2.setStroke(new BasicStroke(1.5f));
                    }
                    g2.drawLine(pA.x, pA.y, pB.x, pB.y);
                }
            }
        }
 
        private void drawNodes_1006(Graphics2D g2) {
            Font nodeFont_1006 = new Font("Consolas", Font.BOLD, 10);
            g2.setFont(nodeFont_1006);
            FontMetrics fm_1006 = g2.getFontMetrics();
 
            for (String node : posisiNode_1006.keySet()) {
                Point p_1006 = posisiNode_1006.get(node);
                Color fill_1006;
                Color border_1006;
 
                if (node.equals(startNode_1006) && !startNode_1006.isEmpty()) {
                    fill_1006   = new Color(40, 180, 90);
                    border_1006 = new Color(100, 255, 150);
                } else if (node.equals(goalNode_1006) && !goalNode_1006.isEmpty()) {
                    fill_1006   = new Color(210, 50, 50);
                    border_1006 = new Color(255, 130, 130);
                } else if (nodeOnPath_1006.contains(node)) {
                    fill_1006   = new Color(30, 120, 200);
                    border_1006 = new Color(80, 200, 255);
                } else if (nodeVisited_1006.contains(node)) {
                    fill_1006   = new Color(160, 110, 30);
                    border_1006 = new Color(230, 170, 60);
                } else {
                    fill_1006   = new Color(55, 58, 85);
                    border_1006 = new Color(120, 125, 170);
                }
 
                g2.setColor(fill_1006);
                g2.fillOval(p_1006.x - R_1006, p_1006.y - R_1006, R_1006 * 2, R_1006 * 2);
                g2.setColor(border_1006);
                g2.setStroke(new BasicStroke(2f));
                g2.drawOval(p_1006.x - R_1006, p_1006.y - R_1006, R_1006 * 2, R_1006 * 2);
 
                String[] kata_1006 = node.split(" ");
                g2.setColor(Color.WHITE);
                if (kata_1006.length == 1) {
                    int tw = fm_1006.stringWidth(node);
                    g2.drawString(node, p_1006.x - tw / 2, p_1006.y + 4);
                } else {
                    String line1 = kata_1006[0];
                    String line2 = String.join(" ", Arrays.copyOfRange(kata_1006, 1, kata_1006.length));
                    int tw1 = fm_1006.stringWidth(line1);
                    int tw2 = fm_1006.stringWidth(line2);
                    g2.drawString(line1, p_1006.x - tw1 / 2, p_1006.y - 4);
                    g2.drawString(line2, p_1006.x - tw2 / 2, p_1006.y + 9);
                }
            }
        }
    }
 
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new PetaCampus_1006());
    }
}