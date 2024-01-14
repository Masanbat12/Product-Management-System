/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import com.sun.tools.javac.Main;
import java.awt.*;
import java.io.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;




public class ProductForm extends javax.swing.JFrame {
    public ProductForm() {
        initComponents();
        Show_Products_In_JTable();
        Connection conn = getConnection();
        if (conn != null) {
            JOptionPane.showMessageDialog(this, "Connected to database successfully!", "Connection Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to connect to the database. Check your settings.", "Connection Failed", JOptionPane.ERROR_MESSAGE);
        }
    }
    String ImgPath = null;
    int position = 0 ;

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&zeroDateTimeBehavior=CONVERT_TO_NULL", "masan", "19961996m");
            JOptionPane.showMessageDialog(null, "connected");
            return con;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error connecting to the database: " + ex.getMessage(),
                    "Database Connection Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "Not connected");
            return con;
        }
    }

    public boolean checkInputs() {
        if (txt_name.getText().isEmpty() || txt_AddDate.getDate() == null || txt_price.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all the required fields", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Double.parseDouble(txt_price.getText()); // Consistently using Double as in validateInput
            return true;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }



    //Resize Image
    public  ImageIcon ResizeImage(String imagePath, byte[] pic){
        ImageIcon myImage = null;
        if(imagePath != null)
        {
            myImage = new ImageIcon(imagePath);
        }else{
            myImage = new ImageIcon(pic);
        }
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);

        return image;
    }

    //Displaying Data In  JTable:

    public ArrayList<Product> getProductList() {
        ArrayList<Product> productList = new ArrayList<>();
        Connection con = getConnection();
        String query = "SELECT * FROM products";

        Statement st = null;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                Product product = new Product(
                        // Getting Data As Int And String.
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("add_date"),
                        Float.parseFloat(rs.getString("price")),
                        rs.getBytes("image")); // Getting image as byte array.
                        productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return productList;
    }

    // Filling the JTable_Products
    public void Show_Products_In_JTable()
    {
        ArrayList<Product> list = getProductList();
        DefaultTableModel model = (DefaultTableModel) JTable_Products.getModel();
        model.setRowCount(0);
        //clear the JTable content
        Object[] row = new Object [5];
        for(int i = 0 ; i < list.size(); i++){
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getPrice();
            row[3] = list.get(i).getDate();
            row[4] = "Image Data";

            model.addRow(row);
        }
        model.fireTableDataChanged();
    }

    public void ShowItem(int index)
    {
        txt_id.setText(Integer.toString(getProductList().get(index).getId()));
        txt_name.setText(getProductList().get(index).getName());
        txt_price.setText(Float.toString(getProductList().get(index).getPrice()));
        try {
            java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse((String)getProductList().get(index).getDate());
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            txt_AddDate.setDate(sqlDate);
        } catch (ParseException ex) {
            Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        lbl_image.setIcon(ResizeImage(null, getProductList().get(index).getPicture()));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        popupMenu1 = new java.awt.PopupMenu();
        popupMenu2 = new java.awt.PopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_Products = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        txt_price = new javax.swing.JTextField();
        Btn_Choose_Image = new javax.swing.JButton();
        Btn_Update = new javax.swing.JButton();
        Btn_Delete = new javax.swing.JButton();
        Btn_First = new javax.swing.JButton();
        Btn_Next = new javax.swing.JButton();
        Btn_Previous = new javax.swing.JButton();
        Btn_Last = new javax.swing.JButton();
        Btn_Insert = new javax.swing.JButton();
        lbl_image = new javax.swing.JLabel();
        txt_AddDate = new com.toedter.calendar.JDateChooser();

        popupMenu1.setLabel("popupMenu1");

        popupMenu2.setLabel("popupMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 255));

        JTable_Products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Byte.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        JTable_Products.setFocusTraversalPolicyProvider(true);
        JTable_Products.setGridColor(new java.awt.Color(0, 0, 0));
        JTable_Products.setSelectionBackground(new java.awt.Color(255, 255, 204));
        JTable_Products.setShowGrid(true);
        JTable_Products.setSurrendersFocusOnKeystroke(true);
        JTable_Products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_ProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable_Products);
        JTable_Products.getAccessibleContext().setAccessibleParent(JTable_Products);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Product Name:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Id:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("AddDate");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Price:");

        Btn_Choose_Image.setBackground(new java.awt.Color(204, 204, 255));
        Btn_Choose_Image.setText("Choose Image");
        Btn_Choose_Image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Choose_ImageActionPerformed(evt);
            }
        });

        Btn_Update.setBackground(new java.awt.Color(255, 255, 204));
        Btn_Update.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        Btn_Update.setText("Update");
        Btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_UpdateActionPerformed(evt);
            }
        });

        Btn_Delete.setBackground(new java.awt.Color(255, 0, 0));
        Btn_Delete.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        Btn_Delete.setText("Delete");
        Btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DeleteActionPerformed(evt);
            }
        });

        Btn_First.setBackground(new java.awt.Color(102, 255, 102));
        Btn_First.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        Btn_First.setText("|<- First");
        Btn_First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_FirstActionPerformed(evt);
            }
        });

        Btn_Next.setBackground(new java.awt.Color(102, 255, 102));
        Btn_Next.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        Btn_Next.setText("Next ->");
        Btn_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_NextActionPerformed(evt);
            }
        });

        Btn_Previous.setBackground(new java.awt.Color(102, 255, 102));
        Btn_Previous.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        Btn_Previous.setText("<- Previous");
        Btn_Previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_PreviousActionPerformed(evt);
            }
        });

        Btn_Last.setBackground(new java.awt.Color(102, 255, 102));
        Btn_Last.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        Btn_Last.setText("Last ->|");
        Btn_Last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LastActionPerformed(evt);
            }
        });

        Btn_Insert.setBackground(new java.awt.Color(153, 255, 255));
        Btn_Insert.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        Btn_Insert.setText("Insert");
        Btn_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_InsertActionPerformed(evt);
            }
        });

        lbl_image.setBackground(new java.awt.Color(204, 255, 204));
        lbl_image.setForeground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 358, Short.MAX_VALUE)
                        .addComponent(Btn_Choose_Image)
                        .addGap(86, 86, 86))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Btn_First)
                                        .addGap(18, 18, 18)
                                        .addComponent(Btn_Next))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Btn_Previous)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Btn_Last)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(53, 53, 53)
                                        .addComponent(txt_AddDate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(26, 26, 26)
                                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Btn_Update)
                                        .addGap(18, 18, 18)
                                        .addComponent(Btn_Delete)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Btn_Insert)))
                                .addGap(12, 12, 12)
                                .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(txt_AddDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Btn_Update)
                                    .addComponent(Btn_Insert))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_First)
                            .addComponent(Btn_Next))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_Previous)
                            .addComponent(Btn_Last))
                        .addGap(58, 58, 58))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(Btn_Choose_Image)
                .addGap(168, 168, 168))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_NextActionPerformed(java.awt.event.ActionEvent evt) {
        position++;
        if(position >= getProductList().size())
        {
            position = getProductList().size()-1;
        }
        ShowItem(position);
    }

    private void JTable_ProductsMouseClicked(java.awt.event.MouseEvent evt) {
        int index =JTable_Products.getSelectedRow();
        ShowItem(index);
    }

    private void Btn_FirstActionPerformed(java.awt.event.ActionEvent evt) {
        position = 0;
        ShowItem(position);
    }

    private void Btn_LastActionPerformed(java.awt.event.ActionEvent evt) {
        position = getProductList().size()-1;
        ShowItem(position);
    }

    private void Btn_PreviousActionPerformed(java.awt.event.ActionEvent evt) {
        position--;
        if(position < 0)
        {
            position = 0;
        }
        ShowItem(position);
    }

    private void Btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {
        try (Connection con = getConnection()) {
            if (con != null) {
                String sql = "DELETE FROM products WHERE product_id = ?";
                try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                    preparedStatement.setInt(1, Integer.parseInt(txt_id.getText())); // Product ID

                    int rowsAffected = preparedStatement.executeUpdate();
                    Show_Products_In_JTable();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Product deleted successfully");
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error deleting product: " + ex.getMessage());
        }
    }



    private void Btn_Choose_ImageActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = file.getSelectedFile();
            String path =selectedFile.getAbsolutePath();
            lbl_image.setIcon(ResizeImage(path, null));
            ImgPath = path; // Make sure this line is correctly setting the ImgPath
        }
        else{
            System.out.println("No File Been Selected");
        }
    }

    private void Btn_InsertActionPerformed(java.awt.event.ActionEvent evt) {
        // Input validation
        if (txt_name.getText().isEmpty() || txt_AddDate.getDate() == null || txt_price.getText().isEmpty() || ImgPath == null) {
            JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty");
            return;
        }

        try {
            // Parse product ID from input
            int yourProductId = Integer.parseInt(txt_id.getText());

            // Check if the product ID already exists
            String checkIdSql = "SELECT COUNT(*) FROM products WHERE product_id = ?";
            try (Connection con = getConnection(); PreparedStatement preparedStatement = con.prepareStatement(checkIdSql)) {
                preparedStatement.setInt(1, yourProductId);

                try (ResultSet rs = preparedStatement.executeQuery()) {
                    if (rs.next() && rs.getInt(1) > 0) {
                        JOptionPane.showMessageDialog(null, "Product ID already exists. Please use a different ID.");
                        return;
                    }
                }
            }

            // Insert the new product
            String sql = "INSERT INTO products(product_id, name, price, add_date, image) VALUES (?, ?, ?, ?, ?)";
            Connection con = getConnection();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, yourProductId);
                ps.setString(2, txt_name.getText());
                ps.setFloat(3, Float.parseFloat(txt_price.getText()));
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = dateFormat.format(txt_AddDate.getDate());
                ps.setString(4, formattedDate);
                InputStream img = new FileInputStream(new File(ImgPath));
                ps.setBlob(5, img);

                int affectedRows = ps.executeUpdate();
                if (affectedRows > 0) {
                    JOptionPane.showMessageDialog(null, "Product Inserted Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Product Insertion Failed");
                }
            }

            // Refreshing the product list in UI
            Show_Products_In_JTable();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid Product ID");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }


    private void Btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {
        String sql = "";
        if (checkInputs() && txt_id.getText() != null) {
            try (Connection con = getConnection()) {
                if (con != null) {
                    int rowsAffected = 0; // Initialize rowsAffected variable

                    // Prepare the SQL query based on whether an image is provided
                    if (ImgPath == null) {
                        // Without image
                        sql = "UPDATE products SET name = ?, price = ?, add_Date = ? WHERE product_id = ?";
                    } else {
                        // With image
                        sql = "UPDATE products SET name = ?, price = ?, add_Date = ?, image = ? WHERE product_id = ?";
                    }

                    // Prepare and execute the SQL statement
                    try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                        preparedStatement.setString(1, txt_name.getText()); // Product Name
                        preparedStatement.setDouble(2, Double.parseDouble(txt_price.getText())); // Price
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String formattedDate = dateFormat.format(txt_AddDate.getDate());
                        preparedStatement.setString(3, formattedDate); // Adding the Date

                        if (ImgPath != null) {
                            // Handling the image
                            try (InputStream img = new FileInputStream(new File(ImgPath))) {
                                preparedStatement.setBlob(4, img); // Image
                                preparedStatement.setInt(5, Integer.parseInt(txt_id.getText())); // Product ID
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(null, "Image file not found: " + ex.getMessage());
                            }
                        } else {
                            // No image case
                            preparedStatement.setInt(4, Integer.parseInt(txt_id.getText())); // Product ID
                        }

                        // Execute the update
                        rowsAffected = preparedStatement.executeUpdate();

                        Show_Products_In_JTable();
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(this, "Product updated successfully");
                        }
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty Or Wrong!");
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" date=" Look and feel setting code (optional) ">
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
            java.util.logging.Logger.getLogger(ProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductForm().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Choose_Image;
    private javax.swing.JButton Btn_Delete;
    private javax.swing.JButton Btn_First;
    private javax.swing.JButton Btn_Insert;
    private javax.swing.JButton Btn_Last;
    private javax.swing.JButton Btn_Next;
    private javax.swing.JButton Btn_Previous;
    private javax.swing.JButton Btn_Update;
    private javax.swing.JTable JTable_Products;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_image;
    private java.awt.PopupMenu popupMenu1;
    private java.awt.PopupMenu popupMenu2;
    private com.toedter.calendar.JDateChooser txt_AddDate;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    // End of variables declaration//GEN-END:variables


}
