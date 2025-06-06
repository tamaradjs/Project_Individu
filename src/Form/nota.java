package Form;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;
import koneksi.koneksi;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class nota extends javax.swing.JFrame {
    public String id, nama, jenis, telp, almt;
    public String kdbrg, nmbrg, jenisbrg, hb, hj;
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;

    public nota() {
        initComponents();
        String KD = userid.getUserLogin();
        jLabel16.setText(KD);
        kosong();
        aktif();
        autonumber();
        nama();
    }

    //Method Nama Kasir
    protected void nama(){
     try {
        String sql = "SELECT * FROM kasir WHERE id_kasir='"+jLabel16.getText()+"'";
        Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);

        if(hasil.next()){
            jLabel17.setText(hasil.getString("nm_kasir"));
        }
    } catch (SQLException e){
        JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
    }
}

    //Method Aktif
    protected void aktif(){
        txtqty.requestFocus();
        jtgl.setEditor(new JSpinner.DateEditor(jtgl,"yyyy/MM/dd"));
        Object[] Baris ={"KD Barang","Nama","Harga Beli","Harga Jual","QTY","Total"};
        tabmode = new DefaultTableModel(null, Baris);
        tbltransaksi.setModel(tabmode);
}

    //Method Kosong
    protected void kosong(){
        txtid.setText("");
        txtnm.setText("");
        txtalmt.setText("");
        txtkdbrg.setText("");
        txtnmbrg.setText("");
        txthb.setText("");
        txthj.setText("");
        txtqty.setText("");
        txttotal.setText("");
}
    
    
    //Method Auto Number
    protected void autonumber(){
    try {
        String sql = "SELECT idnota FROM nota order by idnota asc";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        txtidnota.setText("IN0001");
        while (rs.next()) {
            String id_nota = rs.getString("idnota").substring(2);
            int AN = Integer.parseInt(id_nota) + 1;
            String Nol = "";

            if(AN<10)
                {Nol = "000";}
            else if(AN<100)
                {Nol = "00";}
            else if(AN<1000)
                {Nol = "0";}
            else if(AN<10000)
                {Nol = "";}

            txtidnota.setText("IN" + Nol + AN);
        }
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Auto Number Gagal" +e);
    }
}

    
    //Method Item Terpilih Pelanggan
    public void itemTerpilih(){
        popuppelanggan Pp = new popuppelanggan();
        Pp.plgn = this;
        txtid.setText(id);
        txtnm.setText(nama);
        txtalmt.setText(almt);
}

    //Method Item Terpilih Barang
    
    public void itemTerpilihBrg(){
        popupbarang Pbrg = new popupbarang();
        Pbrg.brg = this;
        txtkdbrg.setText(kdbrg);
        txtnmbrg.setText(nmbrg);
        txthb.setText(hb);
        txthj.setText(hj);
        txtqty.requestFocus();
    }

    
    //Method Hitung
    public void hitung(){
        int total = 0;
        for (int i=0; i < tbltransaksi.getRowCount(); i++){
            int amount = Integer.valueOf(tbltransaksi.getValueAt(i, 5).toString());
            total += amount;
        }
        txtttotal.setText(Integer.toString(total));
}
    
    //Method Cetak
    public void cetak() {
        try{
            String path="./src/Form/nota.jasper";
            HashMap parameter = new HashMap();
            parameter.put("id_nota",txtidnota.getText());
            JasperPrint print = JasperFillManager.fillReport(path,parameter,conn);
            JasperViewer.viewReport(print,false);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada" +ex);   
        }
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        bhapus1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtkdbrg = new javax.swing.JTextField();
        bcaribrg = new javax.swing.JButton();
        txtnmbrg = new javax.swing.JTextField();
        txthb = new javax.swing.JTextField();
        txthj = new javax.swing.JTextField();
        txtqty = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        btambah = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtnm = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtalmt = new javax.swing.JTextArea();
        bcarip = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtidnota = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbltransaksi = new javax.swing.JTable();
        bhapus = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bbatal = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();
        txtttotal = new javax.swing.JTextField();
        totalharga = new javax.swing.JLabel();
        jtgl = new javax.swing.JSpinner();

        jTextField2.setText("jTextField2");

        bhapus1.setText("Hapus");
        bhapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapus1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("NOTA");

        jLabel2.setText("ID Kasir");

        jLabel3.setText("ID Nota");

        jLabel4.setText("Nama Kasir");

        jLabel5.setText("Tgl Nota");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Barang"));

        jLabel10.setText("KD Barang");

        jLabel11.setText("Nama");

        jLabel12.setText("Harga Beli");

        jLabel13.setText("Harga Jual");

        jLabel14.setText("QTY");

        jLabel15.setText("Total");

        txtkdbrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkdbrgActionPerformed(evt);
            }
        });

        bcaribrg.setText("cari");
        bcaribrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaribrgActionPerformed(evt);
            }
        });

        txtnmbrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnmbrgActionPerformed(evt);
            }
        });

        txthb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthbActionPerformed(evt);
            }
        });

        txthj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthjActionPerformed(evt);
            }
        });

        txtqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqtyActionPerformed(evt);
            }
        });

        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });

        btambah.setText("Tambah");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(54, 54, 54)
                        .addComponent(txttotal))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(58, 58, 58)
                        .addComponent(txtqty))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnmbrg, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(txthb)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txthj))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtkdbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bcaribrg, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtkdbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcaribrg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtnmbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txthb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txthj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btambah)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Pelanggan"));

        jLabel7.setText("ID Pelanggan");

        jLabel8.setText("Nama");

        jLabel9.setText("Alamat");

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        txtnm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnmActionPerformed(evt);
            }
        });

        txtalmt.setColumns(20);
        txtalmt.setRows(5);
        jScrollPane1.setViewportView(txtalmt);

        bcarip.setText("cari");
        bcarip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaripActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bcarip, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtnm)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcarip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtnm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jLabel16.setText("jLabel16");

        txtidnota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidnotaActionPerformed(evt);
            }
        });

        jLabel17.setText("jLabel17");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Transaksi"));

        tbltransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbltransaksi);

        bhapus.setText("Hapus");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bhapus)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        bsimpan.setText("Simpan");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        bbatal.setText("Batal");
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });

        bkeluar.setText("Keluar");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });

        txtttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtttotalActionPerformed(evt);
            }
        });

        totalharga.setText("Total Harga");

        jtgl.setModel(new javax.swing.SpinnerDateModel());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(348, 348, 348)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(88, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(txtidnota, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(158, 158, 158))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(bbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(bkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(totalharga)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(txtidnota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsimpan)
                    .addComponent(bbatal)
                    .addComponent(bkeluar)
                    .addComponent(totalharga)
                    .addComponent(txtttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidnotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidnotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidnotaActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtnmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnmActionPerformed

    private void bcaripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaripActionPerformed

        popuppelanggan Pp = new popuppelanggan();
        Pp.plgn = this;
        Pp.setVisible(true);
        Pp.setResizable(false);
    
    }//GEN-LAST:event_bcaripActionPerformed

    private void txtkdbrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkdbrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkdbrgActionPerformed

    private void bcaribrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaribrgActionPerformed
        
        popupbarang Pbrg = new popupbarang();
        Pbrg.brg = this;
        Pbrg.setVisible(true);
        Pbrg.setResizable(false);

    }//GEN-LAST:event_bcaribrgActionPerformed

    private void txtnmbrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnmbrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnmbrgActionPerformed

    private void txthbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthbActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalActionPerformed

    private void txtqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqtyActionPerformed

        int xhrgj = Integer.parseInt(txthj.getText());
        int xqty = Integer.parseInt(txtqty.getText());
        int xjml = xhrgj * xqty;
        txttotal.setText(String.valueOf(xjml));

    }//GEN-LAST:event_txtqtyActionPerformed

    private void txthjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthjActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed

        int index = tbltransaksi.getSelectedRow();
        tabmode.removeRow(index);
        tbltransaksi.setModel(tabmode);
        hitung();
    }//GEN-LAST:event_bhapusActionPerformed

    private void bhapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapus1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bhapus1ActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
       
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fd = sdf.format(jtgl.getValue());
        String sql = "insert into nota values (?,?,?,?)";
        String zsql ="insert into isi values(?,?,?,?,?)";
        try{
        
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtidnota.getText());
            stat.setString(2, fd);
            stat.setString(3, txtid.getText());
            stat.setString(4, jLabel16.getText());
        
            stat.executeUpdate();
        
        int t = tbltransaksi.getRowCount();
        for (int i=0; i < t; i++)
        {
            String xkd = tbltransaksi.getValueAt(i,0).toString();
            String xhb = tbltransaksi.getValueAt(i,2).toString();
            String xhj = tbltransaksi.getValueAt(i,3).toString();
            String xqty = tbltransaksi.getValueAt(i,4).toString();
            
            PreparedStatement stat2 = conn.prepareStatement(zsql);
            stat2.setString(1, txtidnota.getText());
            stat2.setString(2, xkd);
            stat2.setString(3, xhb);
            stat2.setString(4, xhj);
            stat2.setString(5, xqty);
            
            stat2.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            cetak();
          }
          catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan" + e);
          }
             kosong();
             aktif();
             autonumber();
             
        
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed

        kosong();
        aktif();
        autonumber();
    }//GEN-LAST:event_bbatalActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed

        dispose();

    }//GEN-LAST:event_bkeluarActionPerformed

    private void txtttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtttotalActionPerformed

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
     
    try{
        String kode = txtkdbrg.getText();
        String nama = txtnmbrg.getText();
        int hargab = Integer.parseInt(txthb.getText());
        int hargaj = Integer.parseInt(txthj.getText());
        int qty = Integer.parseInt(txtqty.getText());
        int total = Integer.parseInt(txttotal.getText());

        tabmode.addRow(new Object[]{kode, nama, hargab, hargaj, qty, total});
        tbltransaksi.setModel(tabmode);
        } 
        catch(Exception e) {
        System.out.println("Error : "+e);
    }

        txtkdbrg.setText("");
        txtnmbrg.setText("");
        txthb.setText("");
        txthj.setText("");
        txtqty.setText("");
        txttotal.setText("");
        hitung();

    }//GEN-LAST:event_btambahActionPerformed

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
            java.util.logging.Logger.getLogger(nota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bcaribrg;
    private javax.swing.JButton bcarip;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bhapus1;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton btambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JSpinner jtgl;
    private javax.swing.JTable tbltransaksi;
    private javax.swing.JLabel totalharga;
    private javax.swing.JTextArea txtalmt;
    private javax.swing.JTextField txthb;
    private javax.swing.JTextField txthj;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtidnota;
    private javax.swing.JTextField txtkdbrg;
    private javax.swing.JTextField txtnm;
    private javax.swing.JTextField txtnmbrg;
    private javax.swing.JTextField txtqty;
    private javax.swing.JTextField txttotal;
    private javax.swing.JTextField txtttotal;
    // End of variables declaration//GEN-END:variables
}
