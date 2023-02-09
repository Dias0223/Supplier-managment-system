/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupplierManagment;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author DIAS-PC
 */
public class Supplier extends javax.swing.JFrame {

    /**
     * Creates new form Stock
     */
    public Supplier() {
        initComponents();
        Connect();
        load();
        Image icon = new ImageIcon(this.getClass().getResource("/Icon.png")).getImage();
       this.setIconImage(icon);
    }
    
    Connection con;
    PreparedStatement pst;
    DefaultTableModel df;
    
    public void Connect() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/company","root","");
            
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Supplier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Supplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void load(){
        
        int a;
        
        try {
            pst=con.prepareStatement("select*from supplier");
            ResultSet rs=pst.executeQuery();
            
            ResultSetMetaData rd=rs.getMetaData();
            a = rd.getColumnCount();
            df =(DefaultTableModel)Supplier_Table.getModel();
            df.setRowCount(0);
            
            while(rs.next()){
                
                Vector v2 = new Vector();
                for(int i=1; i<=a; i++ ){
                    
                    v2.add(rs.getString("Sup_Id"));
                    v2.add(rs.getString("Sup_Name"));
                    v2.add(rs.getString("Sup_Phone_Number"));
                    v2.add(rs.getString("Sup_Address"));
                    v2.add(rs.getString("Sup_Email"));
                    
                }
                df.addRow(v2);
            }
               
            
        } catch (SQLException ex) {
            Logger.getLogger(Supplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
        
    }
    
    
    
    
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_Su_tp = new javax.swing.JTextField();
        txt_Su_name = new javax.swing.JTextField();
        txt_Su_add = new javax.swing.JTextField();
        txt_Su_em = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Sup_Name = new javax.swing.JLabel();
        Sup_TP = new javax.swing.JLabel();
        Sup_Add = new javax.swing.JLabel();
        Sup_email = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        bnt_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_report = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Supplier_Table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btn_home = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        jButton4.setText("Add");

        jButton7.setText("Add");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Supplier Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Phone Number");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Address");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Email Address");

        txt_Su_tp.setBackground(new java.awt.Color(204, 204, 204));
        txt_Su_tp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_Su_tp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Su_tpKeyReleased(evt);
            }
        });

        txt_Su_name.setBackground(new java.awt.Color(204, 204, 204));
        txt_Su_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_Su_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Su_nameKeyReleased(evt);
            }
        });

        txt_Su_add.setBackground(new java.awt.Color(204, 204, 204));
        txt_Su_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_Su_add.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Su_addKeyReleased(evt);
            }
        });

        txt_Su_em.setBackground(new java.awt.Color(204, 204, 204));
        txt_Su_em.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_Su_em.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Su_emKeyReleased(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\DIAS-PC\\Downloads\\13147415471557740366-128.png")); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Supplier Information");

        Sup_Name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Sup_Name.setForeground(new java.awt.Color(255, 0, 0));

        Sup_TP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Sup_TP.setForeground(new java.awt.Color(255, 0, 0));

        Sup_Add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Sup_Add.setForeground(new java.awt.Color(255, 0, 0));

        Sup_email.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Sup_email.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel1))
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_Su_name, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Su_add, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Su_em, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Sup_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Su_tp, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Sup_TP, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Sup_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Sup_email, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Su_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Sup_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Su_tp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(4, 4, 4)
                .addComponent(Sup_TP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Su_add, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(2, 2, 2)
                .addComponent(Sup_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_Su_em, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Sup_email, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btn_add.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        bnt_edit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bnt_edit.setText("Edit");
        bnt_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_editActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_report.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_report.setText("Report");
        btn_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportActionPerformed(evt);
            }
        });

        btn_clear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bnt_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_report, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bnt_edit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_add, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_report, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        Supplier_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier ID", "Supplier Name", "Phone Number", "Address", "Email Address"
            }
        ));
        Supplier_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Supplier_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Supplier_Table);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\DIAS-PC\\Downloads\\5020973501543238905-32.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_home.setText("Home");
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        
        if(txt_Su_name.getText().trim().isEmpty()){
            
            Sup_Name.setText("Supplier Name is Empty");
            
        }else if(txt_Su_tp.getText().trim().isEmpty()){
            
            Sup_TP.setText("Supplier Phone Number is Empty");
            
        }else if(txt_Su_add.getText().trim().isEmpty()){
            
            Sup_Add.setText("Supplier Address is Empty");
            
        }else if(txt_Su_em.getText().trim().isEmpty()){
            
            Sup_email.setText("Supplier Email is Empty");
            
        }else
        
        try {
            
                String Sup_Name =txt_Su_name.getText();
                String Sup_Phone_Number =txt_Su_tp.getText();
                String Sup_Address =txt_Su_add.getText();
                String Sup_Email =txt_Su_em.getText();
            
            
            
            // TODO add your handling code here:

            pst= con.prepareStatement("insert into supplier(Sup_Name,Sup_Phone_Number,Sup_Address,Sup_Email)values(?,?,?,?)");
            
            pst.setString(1, Sup_Name);
            pst.setString(2, Sup_Phone_Number);
            pst.setString(3, Sup_Address);
            pst.setString(4, Sup_Email);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"Supplier Data Add Successfully","Info",JOptionPane.INFORMATION_MESSAGE);
            
            
            
            txt_Su_name.setText("");
            txt_Su_tp.setText("");
            txt_Su_add.setText("");
            txt_Su_em.setText("");
            txt_Su_name.requestFocus();
            load();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Supplier Data Can Not Add","Error",JOptionPane.ERROR_MESSAGE);
        }
               
               
               
               
               
               
               
               
               
        
    }//GEN-LAST:event_btn_addActionPerformed

    private void Supplier_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Supplier_TableMouseClicked
        // TODO add your handling code here:
        
        df = (DefaultTableModel)Supplier_Table.getModel();
        int selected = Supplier_Table.getSelectedRow();
        
        int Sup_Id = Integer.parseInt(df.getValueAt(selected,0).toString());
        txt_Su_name.setText(df.getValueAt(selected,1).toString());
        txt_Su_tp.setText(df.getValueAt(selected,2).toString());
        txt_Su_add.setText(df.getValueAt(selected,3).toString());
        txt_Su_em.setText(df.getValueAt(selected,4).toString());
        
        btn_add.setEnabled(false);
        
        
        
        
    }//GEN-LAST:event_Supplier_TableMouseClicked

    private void bnt_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_editActionPerformed
        // TODO add your handling code here:
        
        
        
        df = (DefaultTableModel)Supplier_Table.getModel();
        int selected = Supplier_Table.getSelectedRow();
        
        int Sup_Id = Integer.parseInt(df.getValueAt(selected,0).toString());
        
        
                String Sup_Name =txt_Su_name.getText();
                String Sup_Phone_Number =txt_Su_tp.getText();
                String Sup_Address =txt_Su_add.getText();
                String Sup_Email =txt_Su_em.getText();
            
            
            
        try {
            // TODO add your handling code here:

            pst= con.prepareStatement("update supplier set Sup_Name=?,Sup_Phone_Number=?,Sup_Address=?,Sup_Email=? where Sup_Id=? ");
            
            pst.setString(1, Sup_Name);
            pst.setString(2, Sup_Phone_Number);
            pst.setString(3, Sup_Address);
            pst.setString(4, Sup_Email);
            pst.setInt(5, Sup_Id);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"Supplier Data Updated Successfully","Info",JOptionPane.INFORMATION_MESSAGE);
            
            
            txt_Su_name.setText("");
            txt_Su_tp.setText("");
            txt_Su_add.setText("");
            txt_Su_em.setText("");
            txt_Su_name.requestFocus();
            load();
            btn_add.setEnabled(true);
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this,"Supplier Data Can Not Update","Error",JOptionPane.ERROR_MESSAGE);
        }
            
           
        
        
        
        
        
        
        
    }//GEN-LAST:event_bnt_editActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        
        df = (DefaultTableModel)Supplier_Table.getModel();
        int selected = Supplier_Table.getSelectedRow();
        
        int Sup_Id = Integer.parseInt(df.getValueAt(selected,0).toString());
        
        
                
            
            
            
        try {
            // TODO add your handling code here:

            pst= con.prepareStatement("delete from supplier where Sup_Id = ?");
            
            
            pst.setInt(1, Sup_Id);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"Supplier Data Delete Successfully","Info",JOptionPane.INFORMATION_MESSAGE);
           
            
            txt_Su_name.setText("");
            txt_Su_tp.setText("");
            txt_Su_add.setText("");
            txt_Su_em.setText("");
            txt_Su_name.requestFocus();
            load();
            btn_add.setEnabled(true);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Supplier Data Can Not Delete","Error",JOptionPane.ERROR_MESSAGE);
        }
        
  
        
        
        
        
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        
        
         txt_Su_name.setText(""); 
         txt_Su_tp.setText(""); 
         txt_Su_add.setText(""); 
         txt_Su_em.setText("");
         btn_add.setEnabled(true);
         
    }//GEN-LAST:event_btn_clearActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        this.setExtendedState(Supplier.ICONIFIED);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        // TODO add your handling code here:

        new Dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportActionPerformed
        
     try{
            InputStream in= new FileInputStream(new File("D:\\CODSE201F-016\\SupplierManagment\\src\\SupplierManagment\\Supplier.jrxml"));
            JasperDesign jd=JRXmlLoader.load(in);
            String sql="select*from supplier";
            JRDesignQuery newQuery= new JRDesignQuery();
            newQuery.setText(sql);
            jd.setQuery(newQuery);
            JasperReport jr=JasperCompileManager.compileReport(jd);
            HashMap para=new HashMap();
            JasperPrint j = JasperFillManager.fillReport(jr, para,con);
            JasperViewer.viewReport(j,false);
            
     
         
     }catch(Exception e){
         
         JOptionPane.showMessageDialog(null, e);
     }
    }//GEN-LAST:event_btn_reportActionPerformed

    private void txt_Su_tpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Su_tpKeyReleased
        // TODO add your handling code here:
        
      Sup_TP.setText("");
     
      
      String Sup_Phone_Number = txt_Su_tp.getText();
        if(Sup_Phone_Number.matches("^[0-9]*$") && Sup_Phone_Number.length()==10 ){
            
            txt_Su_tp.setBackground(Color.green);
            
        } else {
            
            txt_Su_tp.setBackground(new Color(255,102,102));
            Sup_TP.setText("Incorect Format");
        }
        
        
        
    }//GEN-LAST:event_txt_Su_tpKeyReleased

    private void txt_Su_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Su_nameKeyReleased
        // TODO add your handling code here:
        
      Sup_Name.setText("");
        
    }//GEN-LAST:event_txt_Su_nameKeyReleased

    private void txt_Su_addKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Su_addKeyReleased
        // TODO add your handling code here:
        
       Sup_Add.setText("");
    }//GEN-LAST:event_txt_Su_addKeyReleased

    private void txt_Su_emKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Su_emKeyReleased
        // TODO add your handling code here:
        
       Sup_email.setText("");
       
        String Sup_Email = txt_Su_em.getText();
        if(Sup_Email.matches("^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")){
            
            txt_Su_em.setBackground(Color.green);
            
        } else {
            
            txt_Su_em.setBackground(new Color(255,102,102));
            Sup_email.setText("Incorect Format");
        }
       
       
    }//GEN-LAST:event_txt_Su_emKeyReleased

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
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Supplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Sup_Add;
    private javax.swing.JLabel Sup_Name;
    private javax.swing.JLabel Sup_TP;
    private javax.swing.JLabel Sup_email;
    private javax.swing.JTable Supplier_Table;
    private javax.swing.JButton bnt_edit;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_report;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_Su_add;
    private javax.swing.JTextField txt_Su_em;
    private javax.swing.JTextField txt_Su_name;
    private javax.swing.JTextField txt_Su_tp;
    // End of variables declaration//GEN-END:variables
}
