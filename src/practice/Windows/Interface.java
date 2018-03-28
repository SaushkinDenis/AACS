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
    protected DefaultListModel ListObjects = new DefaultListModel();   
    protected DefaultListModel ListActivities = new DefaultListModel();
    protected DefaultListModel ListDepartment = new DefaultListModel();
    protected DefaultListModel ListPosition = new DefaultListModel();
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
        this.setResizable(false);
        this.setTitle("Интеллектуальная Автоматизированная Система Разграничения Доступа");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabbedPane = new javax.swing.JTabbedPane();
        jToolBar5 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        ChangeAccount = new javax.swing.JButton();
        RemoveAccount = new javax.swing.JButton();
        UpdateListAccounts = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListAccounts = new javax.swing.JList();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextPhoneNumber = new javax.swing.JTextField();
        jComboBoxActivities = new javax.swing.JComboBox();
        jComboBoxPost = new javax.swing.JComboBox();
        jComboBoxDepartment = new javax.swing.JComboBox();
        jTextFirstLastName = new javax.swing.JTextField();
        SaveChangesAccount = new javax.swing.JButton();
        jTextRole = new javax.swing.JTextField();
        jTextRole.setEditable(false);
        ;
        jButton1 = new javax.swing.JButton();
        jToolBar4 = new javax.swing.JToolBar();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jListRole = new javax.swing.JList();
        UpdateListRole = new javax.swing.JButton();
        ChangeRole = new javax.swing.JButton();
        RemoveRole = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextNameRole = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
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

        jToolBar5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Панель управления", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N
        jToolBar5.setFloatable(false);
        jToolBar5.setRollover(true);
        jToolBar5.setAlignmentY(0.5F);

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

        jListAccounts.setModel(ListAccounts);
        jListAccounts.setMaximumSize(new java.awt.Dimension(30000, 30000));
        jListAccounts.setMinimumSize(new java.awt.Dimension(200, 200));
        jListAccounts.setPreferredSize(new java.awt.Dimension(270, 200));
        jScrollPane2.setViewportView(jListAccounts);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Панель редактирования", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N

        jLabel1.setText("ФИО");

        jLabel2.setText("Должность");

        jLabel3.setText("Отдел");

        jLabel4.setText("Направление деятельности");

        jLabel5.setText("Мобильный телефон");

        jLabel6.setText("Роль");

        jTextPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPhoneNumberActionPerformed(evt);
            }
        });

        jComboBoxActivities.setModel(new javax.swing.DefaultComboBoxModel(allActivities));
        jComboBoxActivities.setEditable(false);

        jComboBoxPost.setModel(new javax.swing.DefaultComboBoxModel(allPosition));
        jComboBoxPost.setEditable(false);
        jComboBoxPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPostActionPerformed(evt);
            }
        });

        jComboBoxDepartment.setModel(new javax.swing.DefaultComboBoxModel(allDepartment));
        jComboBoxDepartment.setEditable(false);

        jTextFirstLastName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFirstLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFirstLastNameActionPerformed(evt);
            }
        });

        SaveChangesAccount.setText("Сохранить");
        SaveChangesAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveChangesAccountActionPerformed(evt);
            }
        });

        jTextRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextRoleActionPerformed(evt);
            }
        });

        jButton1.setText("Отмена");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(SaveChangesAccount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextPhoneNumber, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxActivities, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxDepartment, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxPost, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFirstLastName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextRole, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFirstLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxActivities, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTextRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveChangesAccount)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(UpdateListAccounts)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChangeAccount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RemoveAccount))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateListAccounts)
                    .addComponent(ChangeAccount)
                    .addComponent(RemoveAccount)))
        );

        jToolBar5.add(jPanel1);

        TabbedPane.addTab("Пользователи", jToolBar5);

        jToolBar4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Панель управления", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N
        jToolBar4.setRollover(true);

        jListRole.setModel(ListRoles);
        jListRole.setMaximumSize(new java.awt.Dimension(20000000, 20000000));
        jListRole.setMinimumSize(new java.awt.Dimension(200, 200));
        jListRole.setPreferredSize(new java.awt.Dimension(270, 200));
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

        jLabel7.setText("Название");

        jLabel8.setText("Доступные объекты");

        jTextNameRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNameRoleActionPerformed(evt);
            }
        });

        jLabel9.setText("Должности");

        jList1.setModel(ListPosition);
        jScrollPane5.setViewportView(jList1);

        jLabel10.setText("Направление деятельности ");

        jLabel11.setText("Отдел");

        jList2.setModel(ListDepartment);
        jScrollPane6.setViewportView(jList2);

        jList3.setModel(ListActivities);
        jScrollPane7.setViewportView(jList3);

        jButton2.setText("Отмена");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Сохранить");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jList4.setModel(ListObjects);
        jScrollPane8.setViewportView(jList4);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(UpdateListRole)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChangeRole)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RemoveRole))
                    .addComponent(jScrollPane9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextNameRole))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextNameRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane7)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateListRole)
                    .addComponent(ChangeRole)
                    .addComponent(RemoveRole)))
        );

        jToolBar4.add(jPanel4);

        TabbedPane.addTab("Роли", jToolBar4);

        jToolBar7.setBorder(null);
        jToolBar7.setRollover(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Панель управления ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N

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
                .addGap(0, 685, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateTreeObject)
                    .addComponent(ChangeObject)
                    .addComponent(RemoveObject)))
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 219, Short.MAX_VALUE))
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
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 985, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreateObject)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreateRole))))
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
                    CreateRecord.createRecord("0",jTextFirstLastName.getText(),jComboBoxPost.getSelectedItem().toString(),jComboBoxDepartment.getSelectedItem().toString(),jComboBoxActivities.getSelectedItem().toString(),jTextPhoneNumber.getText(),role);
                    choiceRole = jTextFirstLastName.getText();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(WindowCreateRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        UpdateListAccountsActionPerformed(null);
    }//GEN-LAST:event_SaveChangesAccountActionPerformed

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
           
            RXLS = new ReadXLS(0,0,choiceAccount,5);
            for(String element:RXLS.srt) {
                newItem = element;
            }
            jTextRole.setText(newItem);

            
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ChangeAccountActionPerformed

    private void jTextRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextRoleActionPerformed

    private void jTextPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPhoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPhoneNumberActionPerformed

    private void jTextFirstLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFirstLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFirstLastNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ChangeAccountActionPerformed(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextNameRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNameRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNameRoleActionPerformed

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

    private void ChangeRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeRoleActionPerformed
        //WindowCreateRole.main();

        choiceRole = jListRole.getSelectedValuesList().toString().substring(1, jListRole.getSelectedValuesList().toString().length()-1);
        jTextFirstLastName.setText(choiceRole);
        String newItem = null;

        try {
            RXLS = new ReadXLS(1,0,choiceRole,0);
            for(String element:RXLS.srt) {
                newItem = element;
            }
            jTextNameRole.setText(newItem);

            RXLS = new ReadXLS(1,0,choiceRole,1);
            for(String element:RXLS.srt) {
                newItem = element;
            }
            jTextField1.setText(newItem);

            RXLS = new ReadXLS(1,0,choiceRole,2);
            for(String element:RXLS.srt) {
                newItem = element;
            }
            jTextField2.setText(newItem);
            //jComboBoxActivities.setSelectedItem(newItem);

            RXLS = new ReadXLS(1,0,choiceRole,3);
            for(String element:RXLS.srt) {
                newItem = element;
            }
            jTextField3.setText(newItem);
            
            /*            RXLS = new ReadXLS(1,0,choiceRole,4);
            for(String element:RXLS.srt) {
            newItem = element;
            }
            jTextField4.setText(newItem);*/
            
            RXLS = new ReadXLS(2,1,"Должность",0);
            for(String element:RXLS.srt) {
                ListPosition.addElement(element);    
            }
            
            RXLS = new ReadXLS(2,1,"Объект наблюдения",0);
            for (String element:RXLS.srt){
                ListObjects.addElement(element);    
            }
            
            RXLS = new ReadXLS(2,1,"Отдел",0);
            for (String element:RXLS.srt){
                ListDepartment.addElement(element);    
            }
            
            RXLS = new ReadXLS(2,1,"Направление деятельности",0);
            for (String element:RXLS.srt){
                ListActivities.addElement(element);    
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ChangeRoleActionPerformed

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String res1 = jListRole.getSelectedValuesList().toString().substring(1, jListRole.getSelectedValuesList().toString().length()-1);
        System.out.println(res1);

        try {
                RXLS = new ReadXLS (0,res1,"Подтвердите редактирование записи");
                if (RXLS.answerOfRemove){
                    ListRoles.removeElement(res1);
                    CreateRecord.createRecord("1",jTextNameRole.getText(),jList1.getSelectedValuesList().toString(),jList2.getSelectedValuesList().toString(), jList3.getSelectedValuesList().toString());
                }
        } catch (IOException ex) {
            Logger.getLogger(WindowCreateRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

        UpdateListRoleActionPerformed(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBoxPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPostActionPerformed
    
    
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBoxActivities;
    private javax.swing.JComboBox jComboBoxDepartment;
    private javax.swing.JComboBox jComboBoxPost;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JList jList3;
    private javax.swing.JList jList4;
    private javax.swing.JList jListAccounts;
    private javax.swing.JList jListRole;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextFirstLastName;
    private javax.swing.JTextField jTextNameRole;
    private javax.swing.JTextField jTextPhoneNumber;
    private javax.swing.JTextField jTextRole;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar7;
    private javax.swing.JTree jTreeObjects;
    // End of variables declaration//GEN-END:variables
}
