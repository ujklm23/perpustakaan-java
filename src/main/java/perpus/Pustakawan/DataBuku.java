/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package perpus.Pustakawan;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BukuModel;
import perpus.Login;

/**
 *
 * @author lucuria
 */
public class DataBuku extends javax.swing.JFrame {

    final BukuModel bukuModel = new BukuModel();
    DefaultTableModel defaultTableModel;

    public void clearRow() {
        if (defaultTableModel.getRowCount() != 0) {
            defaultTableModel.setRowCount(0);
        }
    }

    private void initData() {
        searchAlert.setText("");

        // fetch data
        ResultSet data = this.bukuModel.findAll();
        defaultTableModel = (DefaultTableModel) tabelBuku.getModel();

        // clear data first
        clearRow();

        // then inject row
        this.bukuModel.injectRow(defaultTableModel, data);
    }

    private void searchTableAction() {
        try {

            searchAlert.setText("");

            // check if input is empty
            if (searchBuku.getText().equals("")) {
                initData();
                return;
            }

            // get value from comboBox
            String selectedValue = cmbSearchBuku.getSelectedItem().toString();
            // search and fetch data
            ResultSet data = this.bukuModel.searchBy(selectedValue, searchBuku.getText());

            // clear data first
            clearRow();

            // if data doesn't exist
            if (!data.isBeforeFirst()) {
                searchAlert.setText("Data tidak ada!");
                return;
            }

            // then inject row with new data
            this.bukuModel.injectRow(defaultTableModel, data);

        } catch (SQLException ex) {
            Logger.getLogger(DataBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addSelectedRowToinput(BukuModel data) {
        kategoriBuku.setText(data.kategori);
        judulBuku.setText(data.judul);
        tahunBuku.setText(data.tahun + "");
        penerbitBuku.setText(data.penerbit);
        jumlahBuku.setText(data.jumlah + "");
        kodeBuku.setText(data.kode);
        kodeBuku.setEnabled(false);
    }

    public void getSelectedRow() {
        // place data to input
        int row = tabelBuku.getSelectedRow();
        this.bukuModel.kategori = tabelBuku.getModel().getValueAt(row, 1).toString();
        this.bukuModel.judul = tabelBuku.getModel().getValueAt(row, 2).toString();
        this.bukuModel.tahun = Integer.parseInt(tabelBuku.getModel().getValueAt(row, 3).toString());
        this.bukuModel.penerbit = tabelBuku.getModel().getValueAt(row, 4).toString();
        this.bukuModel.jumlah = Integer.parseInt(tabelBuku.getModel().getValueAt(row, 5).toString());
        this.bukuModel.kode = tabelBuku.getModel().getValueAt(row, 7).toString();
    }

    public BukuModel grabInputForm() {
        DataBukuAlert.setText("");

        // check if form is null
        if (kategoriBuku.getText().equals("") || judulBuku.getText().equals("")
                && tahunBuku.getText().equals("") || penerbitBuku.getText().equals("")
                && jumlahBuku.getText().equals("") || kodeBuku.getText().equals("")) {

            DataBukuAlert.setText("Data form kosong");
            return null;
        }

        // grab all input user
        this.bukuModel.kategori = kategoriBuku.getText();
        this.bukuModel.judul = judulBuku.getText();
        this.bukuModel.tahun = Integer.parseInt(tahunBuku.getText());
        this.bukuModel.penerbit = penerbitBuku.getText();
        this.bukuModel.jumlah = Integer.parseInt(jumlahBuku.getText());
        this.bukuModel.kode = kodeBuku.getText();

        return this.bukuModel;
    }

    public void clearInputForm() {
        kategoriBuku.setText("");
        judulBuku.setText("");
        tahunBuku.setText("");
        penerbitBuku.setText("");
        jumlahBuku.setText("");
        kodeBuku.setText("");
    }

    public void initLayout() {
        // hide button
        btnSimpan.setEnabled(false);
        btnUbah.setEnabled(false);
        btnHapus.setEnabled(false);

        // adjust table size
        tabelBuku.setRowHeight(25);
        tabelBuku.getColumnModel().getColumn(0).setPreferredWidth(1);
        tabelBuku.getColumnModel().getColumn(1).setPreferredWidth(130);
        tabelBuku.getColumnModel().getColumn(2).setPreferredWidth(230);
        tabelBuku.getColumnModel().getColumn(3).setPreferredWidth(1);
        tabelBuku.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabelBuku.getColumnModel().getColumn(5).setPreferredWidth(1);
        tabelBuku.getColumnModel().getColumn(6).setPreferredWidth(40);
        tabelBuku.getColumnModel().getColumn(7).setPreferredWidth(40);
    }

    /**
     * Creates new form DataBuku
     */
    public DataBuku() {
        initComponents();
        initData();
        initLayout();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dataBukuNav = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        peminjamanNav = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        pengembalianNav = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        judulBuku = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        kategoriBuku = new javax.swing.JTextField();
        penerbitBuku = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tahunBuku = new javax.swing.JTextField(8);
        jLabel5 = new javax.swing.JLabel();
        jumlahBuku = new javax.swing.JTextField();
        kodeBuku = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmbSearchBuku = new javax.swing.JComboBox<>();
        searchBuku = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBuku = new javax.swing.JTable();
        searchAlert = new javax.swing.JLabel();
        DataBukuAlert = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(137, 2, 185));

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Perpustakaan");

        dataBukuNav.setBackground(new java.awt.Color(204, 0, 204));

        jLabel6.setFont(new java.awt.Font("Cantarell", 0, 23)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Data Buku");

        javax.swing.GroupLayout dataBukuNavLayout = new javax.swing.GroupLayout(dataBukuNav);
        dataBukuNav.setLayout(dataBukuNavLayout);
        dataBukuNavLayout.setHorizontalGroup(
            dataBukuNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataBukuNavLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dataBukuNavLayout.setVerticalGroup(
            dataBukuNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataBukuNavLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel6)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        peminjamanNav.setBackground(new java.awt.Color(137, 2, 185));
        peminjamanNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                peminjamanNavMouseReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Cantarell", 0, 23)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Peminjaman");

        javax.swing.GroupLayout peminjamanNavLayout = new javax.swing.GroupLayout(peminjamanNav);
        peminjamanNav.setLayout(peminjamanNavLayout);
        peminjamanNavLayout.setHorizontalGroup(
            peminjamanNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(peminjamanNavLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel12)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        peminjamanNavLayout.setVerticalGroup(
            peminjamanNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(peminjamanNavLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel12)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pengembalianNav.setBackground(new java.awt.Color(137, 2, 185));
        pengembalianNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pengembalianNavMouseReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Cantarell", 0, 23)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Pengembalian");

        javax.swing.GroupLayout pengembalianNavLayout = new javax.swing.GroupLayout(pengembalianNav);
        pengembalianNav.setLayout(pengembalianNavLayout);
        pengembalianNavLayout.setHorizontalGroup(
            pengembalianNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pengembalianNavLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pengembalianNavLayout.setVerticalGroup(
            pengembalianNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pengembalianNavLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel13)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataBukuNav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(50, Short.MAX_VALUE))
            .addComponent(peminjamanNav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pengembalianNav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dataBukuNav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(peminjamanNav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pengembalianNav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel2.setText("Kategori");

        judulBuku.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        judulBuku.setMargin(new java.awt.Insets(2, 15, 2, 15));
        judulBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                judulBukuActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel3.setText("Judul");

        kategoriBuku.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        kategoriBuku.setMargin(new java.awt.Insets(2, 15, 2, 15));
        kategoriBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kategoriBukuActionPerformed(evt);
            }
        });

        penerbitBuku.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        penerbitBuku.setMargin(new java.awt.Insets(2, 15, 2, 15));

        jLabel4.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel4.setText("Penerbit");

        tahunBuku.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        tahunBuku.setMargin(new java.awt.Insets(2, 15, 2, 15));
        tahunBuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tahunBukuKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel5.setText("Tahun");

        jumlahBuku.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jumlahBuku.setMargin(new java.awt.Insets(2, 15, 2, 15));
        jumlahBuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jumlahBukuKeyTyped(evt);
            }
        });

        kodeBuku.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        kodeBuku.setMargin(new java.awt.Insets(2, 15, 2, 15));
        kodeBuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kodeBukuKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel7.setText("Kode");

        jLabel9.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel9.setText("Jumlah");

        btnTambah.setBackground(new java.awt.Color(244, 218, 254));
        btnTambah.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnSimpan.setBackground(new java.awt.Color(244, 218, 254));
        btnSimpan.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setBackground(new java.awt.Color(244, 218, 254));
        btnUbah.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(244, 218, 254));
        btnHapus.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnKeluar.setBackground(new java.awt.Color(244, 218, 254));
        btnKeluar.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Cantarell", 1, 23)); // NOI18N
        jLabel10.setText("Pencarian");

        jLabel11.setFont(new java.awt.Font("Cantarell", 1, 30)); // NOI18N
        jLabel11.setText("Data Buku");

        cmbSearchBuku.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        cmbSearchBuku.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "judul", "kategori", "penerbit", "kode" }));
        cmbSearchBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSearchBukuActionPerformed(evt);
            }
        });

        searchBuku.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        searchBuku.setMargin(new java.awt.Insets(2, 15, 2, 15));
        searchBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBukuActionPerformed(evt);
            }
        });
        searchBuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBukuKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchBukuKeyTyped(evt);
            }
        });

        tabelBuku.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        tabelBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Kategori", "Judul", "Tahun", "Penerbit", "Jumlah", "Status", "Kode"
            }
        ));
        tabelBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelBukuMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelBuku);

        searchAlert.setFont(new java.awt.Font("Cantarell", 0, 25)); // NOI18N
        searchAlert.setForeground(new java.awt.Color(255, 0, 0));

        DataBukuAlert.setFont(new java.awt.Font("Cantarell", 0, 23)); // NOI18N
        DataBukuAlert.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchAlert))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbSearchBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchBuku))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(91, 91, 91)
                                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(DataBukuAlert)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(72, 72, 72)
                                        .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jumlahBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(kategoriBuku)
                                    .addComponent(judulBuku)
                                    .addComponent(tahunBuku)
                                    .addComponent(penerbitBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7))
                                .addGap(136, 136, 136)
                                .addComponent(kodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(62, 62, 62))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel11)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(DataBukuAlert)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jumlahBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(kategoriBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(judulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tahunBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(penerbitBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(searchAlert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSearchBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed

        BukuModel data = grabInputForm();

        if (data == null) {
            return;
        }

        // insert buku
        boolean isSuccess = this.bukuModel.insertRow(data);

        // success
        if (isSuccess) {
            kategoriBuku.setText("");
            judulBuku.setText("");
            tahunBuku.setText("");
            penerbitBuku.setText("");
            jumlahBuku.setText("");
            kodeBuku.setText("");

            initData();
            return;
        }

        JOptionPane.showMessageDialog(null, "Gagal Tambah Data");

    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        BukuModel data = grabInputForm();

        if (data == null) {
            DataBukuAlert.setText("Data Kosong");
            return;
        }

        // emable button
        btnTambah.setEnabled(true);

        System.out.println("data ->" + data);

        // edit row via model
        int rowAffected = this.bukuModel.editRow(data);

        System.out.println("rowAffected " + rowAffected);

        // is success
        if (rowAffected > 0) {
            JOptionPane.showMessageDialog(null, "Sukses mengubah data");
            btnSimpan.setEnabled(false);
            clearRow();
            clearInputForm();
            initData();
            return;
        }
        JOptionPane.showMessageDialog(null, "Gagal mengubah data");

    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // disable button
        btnUbah.setEnabled(false);

        getSelectedRow();
        // enable simpan
        btnSimpan.setEnabled(true);

        addSelectedRowToinput(this.bukuModel);
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Data Buku Akan di Hapus?");

        if (confirm == 0) {
            getSelectedRow();
            int rowAffected = this.bukuModel.deleteRow(this.bukuModel.kode);

            if (rowAffected > 0) {
                JOptionPane.showMessageDialog(null, "Sukses dihapus");
                clearInputForm();
                initData();
                return;
            }

            JOptionPane.showMessageDialog(null, "Gagal dihapus");
        }

    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        int isLogout = JOptionPane.showConfirmDialog(null, "Anda akan keluar?");

        if (isLogout == 0) {
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void searchBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBukuActionPerformed

    private void cmbSearchBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSearchBukuActionPerformed
        this.searchTableAction();
    }//GEN-LAST:event_cmbSearchBukuActionPerformed

    private void searchBukuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBukuKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBukuKeyTyped
    private void searchBukuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBukuKeyReleased
        this.searchTableAction();
    }//GEN-LAST:event_searchBukuKeyReleased

    private void tahunBukuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tahunBukuKeyTyped
        // Limit input user

        boolean max = tahunBuku.getText().length() > 3;
        if (max) {
            evt.consume();
        }
    }//GEN-LAST:event_tahunBukuKeyTyped

    private void jumlahBukuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumlahBukuKeyTyped
        // Limit input user

        boolean max = jumlahBuku.getText().length() > 3;
        if (max) {
            evt.consume();
        }
    }//GEN-LAST:event_jumlahBukuKeyTyped

    private void kodeBukuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodeBukuKeyTyped
        // Limit input user

        boolean max = kodeBuku.getText().length() > 9;
        if (max) {
            evt.consume();
        }
    }//GEN-LAST:event_kodeBukuKeyTyped

    private void tabelBukuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBukuMouseReleased
        btnUbah.setEnabled(true);
        btnSimpan.setEnabled(false);
        btnHapus.setEnabled(true);
    }//GEN-LAST:event_tabelBukuMouseReleased

    private void kategoriBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kategoriBukuActionPerformed
    }//GEN-LAST:event_kategoriBukuActionPerformed

    private void peminjamanNavMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_peminjamanNavMouseReleased
        new Peminjaman().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_peminjamanNavMouseReleased

    private void judulBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_judulBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_judulBukuActionPerformed

    private void pengembalianNavMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pengembalianNavMouseReleased
        new Pengembalian().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_pengembalianNavMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DataBuku.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataBuku.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataBuku.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataBuku.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataBuku().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DataBukuAlert;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cmbSearchBuku;
    private javax.swing.JPanel dataBukuNav;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField judulBuku;
    private javax.swing.JTextField jumlahBuku;
    private javax.swing.JTextField kategoriBuku;
    private javax.swing.JTextField kodeBuku;
    private javax.swing.JPanel peminjamanNav;
    private javax.swing.JTextField penerbitBuku;
    private javax.swing.JPanel pengembalianNav;
    private javax.swing.JLabel searchAlert;
    private javax.swing.JTextField searchBuku;
    private javax.swing.JTable tabelBuku;
    private javax.swing.JTextField tahunBuku;
    // End of variables declaration//GEN-END:variables
}
