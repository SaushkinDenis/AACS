package practice.Windows;

import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import practice.CreateRecord;
import practice.LogisticsRole;
import practice.ReadXLS;

public class Interface extends javax.swing.JFrame {
    
    protected ReadXLS RXLS;
    protected String[] allPosition, allActivities, allDepartment;
    protected String choiceRole = "", choiceAccount = "";
    protected DefaultListModel ListAccounts = new DefaultListModel();
    protected DefaultListModel ListRoles = new DefaultListModel();
    protected DefaultTreeModel TreeObjects;
    
    public Interface() throws IOException {
        
        this.RXLS = new ReadXLS (0,0,"",0);
        for(String element:RXLS.srt) {
        if (!(ListAccounts.contains(element))){
        ListAccounts.addElement(element);
        }
        }
        
        
        this.RXLS = new ReadXLS(1,0,"",0);
        for(String element:RXLS.srt) {
        if (!(ListRoles.contains(element))){
        ListRoles.addElement(element);
        }
        }
        
        
        this.RXLS = new ReadXLS(2,1,"Должность",0);
        allPosition = RXLS.srt;
        
        this.RXLS = new ReadXLS(2,1,"Отдел",0);
        allDepartment = RXLS.srt;
        
        this.RXLS = new ReadXLS(2,1,"Направление деятельности",0);
        allActivities = RXLS.srt;

        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("picture4.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabbedPane = new javax.swing.JTabbedPane();
        jToolBar5 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListAccounts = new javax.swing.JList();
        ChangeAccount = new javax.swing.JButton();
        RemoveAccount = new javax.swing.JButton();
        UpdateListAccounts = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFirstLastName = new javax.swing.JTextField();
        jTextPhoneNumber = new javax.swing.JTextField();
        jComboBoxPost = new javax.swing.JComboBox();
        jComboBoxDepartment = new javax.swing.JComboBox();
        jComboBoxActivities = new javax.swing.JComboBox();
        SaveChangesAccount = new javax.swing.JButton();
        jToolBar4 = new javax.swing.JToolBar();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jListRole = new javax.swing.JList();
        UpdateListRole = new javax.swing.JButton();
        ChangeRole = new javax.swing.JButton();
        RemoveRole = new javax.swing.JButton();
        jToolBar7 = new javax.swing.JToolBar();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTreeObjects = new javax.swing.JTree();
        UpdateTreeObject = new javax.swing.JButton();
        ChangeObject = new javax.swing.JButton();
        RemoveObject = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        CreateAccount = new javax.swing.JButton();
        CreateObject = new javax.swing.JButton();
        CreateRole = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Statistics = new javax.swing.JMenuItem();
        jMenu18 = new javax.swing.JMenu();
        Reference = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TabbedPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabbedPaneMouseClicked(evt);
            }
        });

        jToolBar5.setRollover(true);

        jListAccounts.setModel(ListAccounts);
        jScrollPane2.setViewportView(jListAccounts);

        ChangeAccount.setText("Редактировать");
        ChangeAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeAccountActionPerformed(evt);
            }
        });

        RemoveAccount.setText("Удалить");
        RemoveAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveAccountActionPerformed(evt);
            }
        });

        UpdateListAccounts.setText("Обновить");
        UpdateListAccounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateListAccountsActionPerformed(evt);
            }
        });

        jLabel1.setText("ФИО");

        jLabel2.setText("Должность");

        jLabel3.setText("Отдел");

        jLabel4.setText("Направление деятельности");

        jLabel5.setText("Мобильный телефон");

        jComboBoxPost.setModel(new javax.swing.DefaultComboBoxModel(allPosition));
        jComboBoxPost.setEditable(true);

        jComboBoxDepartment.setModel(new javax.swing.DefaultComboBoxModel(allDepartment));
        jComboBoxDepartment.setEditable(true);

        jComboBoxActivities.setModel(new javax.swing.DefaultComboBoxModel(allActivities));
        jComboBoxActivities.setEditable(true);

        SaveChangesAccount.setText("Сохранить");
        SaveChangesAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveChangesAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(UpdateListAccounts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChangeAccount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RemoveAccount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                .addComponent(SaveChangesAccount)
                .addGap(145, 145, 145))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextPhoneNumber)
                    .addComponent(jComboBoxActivities, 0, 170, Short.MAX_VALUE)
                    .addComponent(jComboBoxDepartment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxPost, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFirstLastName)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UpdateListAccounts)
                            .addComponent(ChangeAccount)
                            .addComponent(RemoveAccount)
                            .addComponent(SaveChangesAccount)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextFirstLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBoxPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBoxDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBoxActivities, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar5.add(jPanel1);

        TabbedPane.addTab("Пользователи", jToolBar5);

        jToolBar4.setRollover(true);

        jListRole.setModel(ListRoles);
        jScrollPane9.setViewportView(jListRole);

        UpdateListRole.setText("Обновить");
        UpdateListRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateListRoleActionPerformed(evt);
            }
        });

        ChangeRole.setText("Редактировать");
        ChangeRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeRoleActionPerformed(evt);
            }
        });

        RemoveRole.setText("Удалить");
        RemoveRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveRoleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(UpdateListRole)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChangeRole)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RemoveRole))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 457, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateListRole)
                    .addComponent(ChangeRole)
                    .addComponent(RemoveRole))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar4.add(jPanel4);

        TabbedPane.addTab("Роли", jToolBar4);

        jToolBar7.setRollover(true);

        jTreeObjects.setModel(TreeObjects);
        jScrollPane4.setViewportView(jTreeObjects);

        UpdateTreeObject.setText("Обновить");
        UpdateTreeObject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateTreeObjectActionPerformed(evt);
            }
        });

        ChangeObject.setText("Редактировать");
        ChangeObject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeObjectActionPerformed(evt);
            }
        });

        RemoveObject.setText("Удалить");
        RemoveObject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveObjectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(UpdateTreeObject)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChangeObject)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RemoveObject))
                    .addComponent(jScrollPane4))
                .addGap(0, 457, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateTreeObject)
                    .addComponent(ChangeObject)
                    .addComponent(RemoveObject))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar7.add(jPanel3);

        TabbedPane.addTab("Объекты", jToolBar7);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 142, Short.MAX_VALUE))
        );

        TabbedPane.addTab("Уведомления", jPanel2);

        CreateAccount.setText("Новый пользователь");
        CreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateAccountActionPerformed(evt);
            }
        });

        CreateObject.setText("Новый объект");
        CreateObject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateObjectActionPerformed(evt);
            }
        });

        CreateRole.setText("Новая роль");
        CreateRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateRoleActionPerformed(evt);
            }
        });

        jMenu1.setText("Меню");

        Statistics.setText("Статистика");
        Statistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatisticsActionPerformed(evt);
            }
        });
        jMenu1.add(Statistics);

        jMenuBar1.add(jMenu1);

        jMenu18.setText("Справка");

        Reference.setText("О программе");
        Reference.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReferenceActionPerformed(evt);
            }
        });
        jMenu18.add(Reference);

        jMenuBar1.add(jMenu18);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreateObject)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreateRole)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(TabbedPane))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CreateObject)
                        .addComponent(CreateRole))
                    .addComponent(CreateAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabbedPane))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void StatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatisticsActionPerformed
       
    }//GEN-LAST:event_StatisticsActionPerformed

    private void ReferenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReferenceActionPerformed
        reference.main();
    }//GEN-LAST:event_ReferenceActionPerformed

    private void CreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateAccountActionPerformed
        WindowCreateRecord.main(); 
        UpdateListAccountsActionPerformed(null);
    }//GEN-LAST:event_CreateAccountActionPerformed

    private void CreateObjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateObjectActionPerformed
        WindowCreateObject.main();
        UpdateTreeObjectActionPerformed(null);
    }//GEN-LAST:event_CreateObjectActionPerformed

    private void CreateRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateRoleActionPerformed
        WindowCreateRole.main();
        UpdateListRoleActionPerformed(null);
    }//GEN-LAST:event_CreateRoleActionPerformed

    private void UpdateListAccountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateListAccountsActionPerformed
        
        try {
            RXLS = new ReadXLS (0,0,"",0);
            for(String i:RXLS.srt) {
                if (!(ListAccounts.contains(i))){
                    ListAccounts.addElement(i);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UpdateListAccountsActionPerformed

    private void RemoveAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveAccountActionPerformed

        choiceAccount = jListAccounts.getSelectedValuesList().toString().substring(1, jListAccounts.getSelectedValuesList().toString().length()-1);
        try {
            RXLS = new ReadXLS (0,choiceAccount,"Подтвердите удаление записи.");
            if (RXLS.answerOfRemove){
                ListAccounts.removeElement(choiceAccount);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RemoveAccountActionPerformed

    private void ChangeAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeAccountActionPerformed
        
        choiceAccount = jListAccounts.getSelectedValuesList().toString().substring(1, jListAccounts.getSelectedValuesList().toString().length()-1);
        jTextFirstLastName.setText(choiceAccount);
        String newItem = null;
        
        try {
            RXLS = new ReadXLS(0,0,choiceAccount,1);
            for(String element:RXLS.srt) {
               newItem = element; 
            }
            jComboBoxPost.setSelectedItem(newItem);
            
            RXLS = new ReadXLS(0,0,choiceAccount,2);
            for(String element:RXLS.srt) {
               newItem = element; 
            }
            jComboBoxDepartment.setSelectedItem(newItem);
            
            RXLS = new ReadXLS(0,0,choiceAccount,3);
            for(String element:RXLS.srt) {
               newItem = element; 
            }
            jComboBoxActivities.setSelectedItem(newItem);
            
            RXLS = new ReadXLS(0,0,choiceAccount,4);
            for(String element:RXLS.srt) {
               newItem = element; 
            }
            jTextPhoneNumber.setText(newItem);
            
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ChangeAccountActionPerformed

    private void UpdateListRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateListRoleActionPerformed
        
        try {
            RXLS = new ReadXLS(1,0,"",0);
            for(String element:RXLS.srt) {
                if (!(ListRoles.contains(element))){
                    ListRoles.addElement(element);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UpdateListRoleActionPerformed

    private void RemoveRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveRoleActionPerformed
        
        choiceRole = jListRole.getSelectedValuesList().toString().substring(1, jListRole.getSelectedValuesList().toString().length()-1);
        try {
            RXLS = new ReadXLS (1,choiceRole,"Подтвердите удаление записи.");
             if (RXLS.answerOfRemove){
                ListRoles.removeElement(choiceRole);
             }
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RemoveRoleActionPerformed

    private void TabbedPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabbedPaneMouseClicked
        UpdateListAccountsActionPerformed(null);
        UpdateListRoleActionPerformed(null);
        UpdateTreeObjectActionPerformed(null);
    }//GEN-LAST:event_TabbedPaneMouseClicked

    private void ChangeObjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeObjectActionPerformed
        
    }//GEN-LAST:event_ChangeObjectActionPerformed

    private void UpdateTreeObjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateTreeObjectActionPerformed
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Объекты");
        // Содержимое корневого узла
        DefaultMutableTreeNode objectOfObservation = new DefaultMutableTreeNode("Объекты наблюдения");
        root.add(objectOfObservation);
        DefaultMutableTreeNode post = new DefaultMutableTreeNode("Должности");
        root.add(post);
        DefaultMutableTreeNode department = new DefaultMutableTreeNode("Отделы");
        root.add(department);
        DefaultMutableTreeNode activities = new DefaultMutableTreeNode("Направления деятельности");
        root.add(activities);
        DefaultMutableTreeNode leafTreeObjects;
        
        try {
            RXLS = new ReadXLS (2,1,"Объект наблюдения",0);
            for(String element:RXLS.srt) {
                leafTreeObjects = new DefaultMutableTreeNode(element);
                leafTreeObjects.setAllowsChildren(false);
                objectOfObservation.add(leafTreeObjects);
            }
            
            RXLS = new ReadXLS (2,1,"Должность",0);
            for(String element:RXLS.srt) {
                leafTreeObjects = new DefaultMutableTreeNode(element);
                leafTreeObjects.setAllowsChildren(false);
                post.add(leafTreeObjects);
            }
            
            RXLS = new ReadXLS (2,1,"Отдел",0);
            for(String element:RXLS.srt) {
                leafTreeObjects = new DefaultMutableTreeNode(element);
                leafTreeObjects.setAllowsChildren(false);
                department.add(leafTreeObjects);
            }
            
            RXLS = new ReadXLS (2,1,"Направление деятельности",0);
            for(String element:RXLS.srt) {
                leafTreeObjects = new DefaultMutableTreeNode(element);
                leafTreeObjects.setAllowsChildren(false);
                activities.add(leafTreeObjects);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        TreeObjects = new DefaultTreeModel(root, true);
        jTreeObjects.setModel(TreeObjects);
    }//GEN-LAST:event_UpdateTreeObjectActionPerformed

    private void RemoveObjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveObjectActionPerformed
        
        TreePath[] choiseObjects = jTreeObjects.getSelectionPaths();
        
        try {
            RXLS = new ReadXLS(2,choiseObjects[0].getLastPathComponent().toString(),"Подтвердите удаление записи.");
            if (RXLS.answerOfRemove = false){
                UpdateTreeObjectActionPerformed(null);
            }
           
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_RemoveObjectActionPerformed

    private void SaveChangesAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveChangesAccountActionPerformed

        ArrayList setrole = new ArrayList();
        String res1 = jListAccounts.getSelectedValuesList().toString().substring(1, jListAccounts.getSelectedValuesList().toString().length()-1);

        try {


            RXLS = new ReadXLS(1,0,"",0);
            for (String item:RXLS.srt){
            setrole.add(item);
            }
        } catch (IOException ex) {
            Logger.getLogger(WindowCreateRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
	
        try {
            String role = LogisticsRole.setRole(jComboBoxPost.getSelectedItem().toString(),jComboBoxDepartment.getSelectedItem().toString(),jComboBoxActivities.getSelectedItem().toString());
            if (!(role == "")){
                JOptionPane optionPaneFact = new JOptionPane();
                UIManager.put("OptionPane.yesButtonText", "Да");
                UIManager.put("OptionPane.noButtonText", "Нет");
                optionPaneFact.updateUI();
                int result = optionPaneFact.showConfirmDialog(null, "Новому пользователю будет соответствовать следующая роль: "+role+ ". Выбрать роль вручную?", "Подтверждение роли!", 
                optionPaneFact.YES_NO_OPTION, optionPaneFact.QUESTION_MESSAGE);

            switch(result){
                case JOptionPane.YES_OPTION: 
                    Object changeRole = JOptionPane.showInputDialog(null,"Выберите роль","Выбор роли",JOptionPane.QUESTION_MESSAGE, null, setrole.toArray(), setrole.get(0) );
                    role = (String) changeRole; 
                    break;
                case JOptionPane.NO_OPTION:  
                    break;
                case JOptionPane.CLOSED_OPTION:  
                    break;
                default: 
                    break;
	    }
            
            RXLS = new ReadXLS (0,res1,"Подтвердите редактирование записи");
            if (RXLS.answerOfRemove){
                ListAccounts.removeElement(res1);
            }
            CreateRecord.createRecord("0",jTextFirstLastName.getText(),jComboBoxPost.getSelectedItem().toString(),jComboBoxDepartment.getSelectedItem().toString(),jComboBoxActivities.getSelectedItem().toString(),jTextPhoneNumber.getText(),role);
            choiceRole = jTextFirstLastName.getText();
            }
        } catch (IOException ex) {
            Logger.getLogger(WindowCreateRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        UpdateListAccountsActionPerformed(null);      
    }//GEN-LAST:event_SaveChangesAccountActionPerformed

    private void ChangeRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeRoleActionPerformed
        WindowCreateRole.main();
    }//GEN-LAST:event_ChangeRoleActionPerformed
    
    
    public static void main()  {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Interface().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ChangeAccount;
    private javax.swing.JButton ChangeObject;
    private javax.swing.JButton ChangeRole;
    private javax.swing.JButton CreateAccount;
    private javax.swing.JButton CreateObject;
    private javax.swing.JButton CreateRole;
    private javax.swing.JMenuItem Reference;
    private javax.swing.JButton RemoveAccount;
    private javax.swing.JButton RemoveObject;
    private javax.swing.JButton RemoveRole;
    private javax.swing.JButton SaveChangesAccount;
    private javax.swing.JMenuItem Statistics;
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JButton UpdateListAccounts;
    private javax.swing.JButton UpdateListRole;
    private javax.swing.JButton UpdateTreeObject;
    private javax.swing.JComboBox jComboBoxActivities;
    private javax.swing.JComboBox jComboBoxDepartment;
    private javax.swing.JComboBox jComboBoxPost;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jListAccounts;
    private javax.swing.JList jListRole;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFirstLastName;
    private javax.swing.JTextField jTextPhoneNumber;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar7;
    private javax.swing.JTree jTreeObjects;
    // End of variables declaration//GEN-END:variables
}
