package kino;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.JTextComponent;

/**
 * KINO – kino biļešu rezervācijas sistēmas grafiskā saskarne VIENĀ failā.
 *
 * Galvenais logs (JFrame) un visi pakārtotie dialoglodziņi (JDialog) ir izveidoti ar NetBeans GUI Builder
 * šajā pašā formā (Inspector → Other Components):
 *   dlgLogin, dlgRegister, dlgMovie, dlgSessions, dlgSeats, dlgProfile, dlgMyRes, dlgReview, dlgAdmin.
 * Komponentes izvietotas atbilstoši GUI skicēm.
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Izveido galveno logu un visus dialoglodziņus.
     */
    public MainFrame() {
        initComponents();
        customInit();
    }

    /**
     * Šo metodi izsauc konstruktors, lai inicializētu formu.
     * Kods ģenerēts ar NetBeans GUI Builder (Design skatā to labot nevar).
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgLogin = new javax.swing.JDialog();
        lblTitleLogin = new javax.swing.JLabel();
        txtLoginUser = new javax.swing.JTextField();
        txtLoginPass = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnOpenRegister = new javax.swing.JButton();
        btnGuest = new javax.swing.JButton();
        dlgRegister = new javax.swing.JDialog();
        lblTitleReg = new javax.swing.JLabel();
        txtVards = new javax.swing.JTextField();
        txtUzvards = new javax.swing.JTextField();
        txtRegUser = new javax.swing.JTextField();
        txtRegPass = new javax.swing.JPasswordField();
        txtRegPass2 = new javax.swing.JPasswordField();
        txtEpasts = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        dlgMovie = new javax.swing.JDialog();
        lblTitleMovie = new javax.swing.JLabel();
        lblZvaigznes = new javax.swing.JLabel();
        pnlLineMovie = new javax.swing.JPanel();
        lblPlakatsMovie = new javax.swing.JLabel();
        lblNosaukums = new javax.swing.JLabel();
        txtApraksts = new javax.swing.JTextArea();
        lblInfo = new javax.swing.JLabel();
        btnRezervetMovie = new javax.swing.JButton();
        btnPlans = new javax.swing.JButton();
        pnlLine2 = new javax.swing.JPanel();
        lblAtsauksmes = new javax.swing.JLabel();
        btnRakstit = new javax.swing.JButton();
        scrollAtsauksmesMovie = new javax.swing.JScrollPane();
        pnlAtsauksmesMovie = new javax.swing.JPanel();
        dlgSessions = new javax.swing.JDialog();
        lblTitleSess = new javax.swing.JLabel();
        lblPlakatsSess = new javax.swing.JLabel();
        scrollSeansiSess = new javax.swing.JScrollPane();
        tblSeansiSess = new javax.swing.JTable();
        btnIzveleties = new javax.swing.JButton();
        btnAizvert = new javax.swing.JButton();
        dlgSeats = new javax.swing.JDialog();
        lblTitleSeat = new javax.swing.JLabel();
        lblFilmaSeat = new javax.swing.JLabel();
        pnlVietas = new javax.swing.JPanel();
        lblBrivs = new javax.swing.JLabel();
        lblAiznemts = new javax.swing.JLabel();
        lblIzveleta = new javax.swing.JLabel();
        lblVietas = new javax.swing.JLabel();
        lblIemaksa = new javax.swing.JLabel();
        btnRezervetSeat = new javax.swing.JButton();
        lblTitleSeat1 = new javax.swing.JLabel();
        lblFilmaSeat1 = new javax.swing.JLabel();
        dlgProfile = new javax.swing.JDialog();
        lblTitleProf = new javax.swing.JLabel();
        lblAvatars = new javax.swing.JLabel();
        lblVards = new javax.swing.JLabel();
        lblStatuss = new javax.swing.JLabel();
        lblEpasts = new javax.swing.JLabel();
        pnlLineProf = new javax.swing.JPanel();
        lblSaraksts = new javax.swing.JLabel();
        scrollPirkumi = new javax.swing.JScrollPane();
        tblPirkumi = new javax.swing.JTable();
        btnRezervacijas = new javax.swing.JButton();
        btnIziet = new javax.swing.JButton();
        dlgMyRes = new javax.swing.JDialog();
        lblTitleMyRes = new javax.swing.JLabel();
        scrollMyRes = new javax.swing.JScrollPane();
        tblMyRes = new javax.swing.JTable();
        btnAtceltMyRes = new javax.swing.JButton();
        btnAtpakal = new javax.swing.JButton();
        lblPiezime = new javax.swing.JLabel();
        dlgReview = new javax.swing.JDialog();
        lblTitleRev = new javax.swing.JLabel();
        lblFilmaRev = new javax.swing.JLabel();
        lblVertejums = new javax.swing.JLabel();
        cmbVertejums = new javax.swing.JComboBox();
        scrollTeksts = new javax.swing.JScrollPane();
        txtTeksts = new javax.swing.JTextArea();
        btnPublicet = new javax.swing.JButton();
        btnAtceltRev = new javax.swing.JButton();
        dlgAdmin = new javax.swing.JDialog();
        lblTitleAdm = new javax.swing.JLabel();
        lblAdmins = new javax.swing.JLabel();
        lblAdminaIkona = new javax.swing.JLabel();
        pnlLineAdm = new javax.swing.JPanel();
        tabs = new javax.swing.JTabbedPane();
        pnlFilmasAdm = new javax.swing.JPanel();
        lblFilmuPark = new javax.swing.JLabel();
        scrollFilmasAdm = new javax.swing.JScrollPane();
        tblFilmas = new javax.swing.JTable();
        lblFNosaukums = new javax.swing.JLabel();
        txtFNosaukums = new javax.swing.JTextField();
        lblFZanrs = new javax.swing.JLabel();
        txtFZanrs = new javax.swing.JTextField();
        lblFIlgums = new javax.swing.JLabel();
        txtFIlgums = new javax.swing.JTextField();
        lblFVecums = new javax.swing.JLabel();
        txtFVecums = new javax.swing.JTextField();
        lblFPlakats = new javax.swing.JLabel();
        txtFPlakats = new javax.swing.JTextField();
        lblFTreileris = new javax.swing.JLabel();
        txtFTreileris = new javax.swing.JTextField();
        lblFApraksts = new javax.swing.JLabel();
        scrollFApraksts = new javax.swing.JScrollPane();
        txtFApraksts = new javax.swing.JTextArea();
        btnPievienot = new javax.swing.JButton();
        btnRediget = new javax.swing.JButton();
        btnDzestFilmu = new javax.swing.JButton();
        lblFPiezime = new javax.swing.JLabel();
        pnlSeansi = new javax.swing.JPanel();
        lblSeansuPark = new javax.swing.JLabel();
        scrollSeansiAdm = new javax.swing.JScrollPane();
        tblSeansiAdm = new javax.swing.JTable();
        lblSFilma = new javax.swing.JLabel();
        cmbSFilma = new javax.swing.JComboBox();
        lblSZale = new javax.swing.JLabel();
        cmbSZale = new javax.swing.JComboBox();
        lblSDatums = new javax.swing.JLabel();
        txtSDatums = new javax.swing.JTextField();
        lblSLaiks = new javax.swing.JLabel();
        txtSLaiks = new javax.swing.JTextField();
        lblSCena = new javax.swing.JLabel();
        txtSCena = new javax.swing.JTextField();
        btnIzveidot = new javax.swing.JButton();
        btnMainit = new javax.swing.JButton();
        btnAtceltSeansu = new javax.swing.JButton();
        lblSPiezime = new javax.swing.JLabel();
        pnlAtsAdm = new javax.swing.JPanel();
        lblAFiltrs = new javax.swing.JLabel();
        txtAFiltrs = new javax.swing.JTextField();
        btnMeklet = new javax.swing.JButton();
        scrollAtsAdm = new javax.swing.JScrollPane();
        tblAtsauksmes = new javax.swing.JTable();
        btnDzestAtsauksmi = new javax.swing.JButton();
        lblAPiezime = new javax.swing.JLabel();
        pnlLietotaji = new javax.swing.JPanel();
        lblLietPark = new javax.swing.JLabel();
        scrollLietotaji = new javax.swing.JScrollPane();
        tblLietotaji = new javax.swing.JTable();
        btnBlokat = new javax.swing.JButton();
        btnAtblokat = new javax.swing.JButton();
        btnDzestLietotaju = new javax.swing.JButton();
        lblLPiezime = new javax.swing.JLabel();
        pnlRezervacijas = new javax.swing.JPanel();
        lblRFilma = new javax.swing.JLabel();
        cmbRFilma = new javax.swing.JComboBox();
        lblRDatums = new javax.swing.JLabel();
        txtRDatums = new javax.swing.JTextField();
        btnFiltret = new javax.swing.JButton();
        scrollRezAdm = new javax.swing.JScrollPane();
        tblRezAdm = new javax.swing.JTable();
        btnAtceltRezervaciju = new javax.swing.JButton();
        lblRPiezime = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        btnAdmin = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        pnlLine = new javax.swing.JPanel();
        lblMeklet = new javax.swing.JLabel();
        txtMeklet = new javax.swing.JTextField();
        scrollFilmas = new javax.swing.JScrollPane();
        pnlFilmas = new javax.swing.JPanel();

        dlgLogin.setTitle("KINO – pieslēgšanās");
        dlgLogin.setModal(true);
        dlgLogin.setResizable(false);
        dlgLogin.getContentPane().setLayout(null);

        lblTitleLogin.setText("KINO");
        dlgLogin.getContentPane().add(lblTitleLogin);
        lblTitleLogin.setBounds(20, 10, 250, 44);

        txtLoginUser.setText("Lietotājvārds");
        txtLoginUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dlgLogin.getContentPane().add(txtLoginUser);
        txtLoginUser.setBounds(20, 70, 290, 40);

        txtLoginPass.setText("Parole");
        txtLoginPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dlgLogin.getContentPane().add(txtLoginPass);
        txtLoginPass.setBounds(20, 125, 290, 40);

        btnLogin.setText("Ielogoties");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        dlgLogin.getContentPane().add(btnLogin);
        btnLogin.setBounds(20, 190, 135, 38);

        btnOpenRegister.setText("Reģistrēties");
        btnOpenRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenRegisterActionPerformed(evt);
            }
        });
        dlgLogin.getContentPane().add(btnOpenRegister);
        btnOpenRegister.setBounds(175, 190, 135, 38);

        btnGuest.setText("Turpināt kā viesis");
        btnGuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuestActionPerformed(evt);
            }
        });
        dlgLogin.getContentPane().add(btnGuest);
        btnGuest.setBounds(20, 245, 290, 26);

        dlgRegister.setTitle("KINO – reģistrēšanās");
        dlgRegister.setModal(true);
        dlgRegister.setResizable(false);
        dlgRegister.getContentPane().setLayout(null);

        lblTitleReg.setText("KINO.reg");
        dlgRegister.getContentPane().add(lblTitleReg);
        lblTitleReg.setBounds(20, 10, 250, 44);

        txtVards.setText("Vārds");
        txtVards.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dlgRegister.getContentPane().add(txtVards);
        txtVards.setBounds(20, 65, 290, 40);

        txtUzvards.setText("Uzvārds");
        txtUzvards.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dlgRegister.getContentPane().add(txtUzvards);
        txtUzvards.setBounds(20, 115, 290, 40);

        txtRegUser.setText("Lietotājvārds");
        txtRegUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dlgRegister.getContentPane().add(txtRegUser);
        txtRegUser.setBounds(20, 165, 290, 40);

        txtRegPass.setText("Parole");
        txtRegPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dlgRegister.getContentPane().add(txtRegPass);
        txtRegPass.setBounds(20, 215, 290, 40);

        txtRegPass2.setText("Atkārtot paroli");
        txtRegPass2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dlgRegister.getContentPane().add(txtRegPass2);
        txtRegPass2.setBounds(20, 265, 290, 40);

        txtEpasts.setText("E-pasts");
        txtEpasts.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dlgRegister.getContentPane().add(txtEpasts);
        txtEpasts.setBounds(20, 315, 290, 40);

        btnRegister.setText("Reģistrēties");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        dlgRegister.getContentPane().add(btnRegister);
        btnRegister.setBounds(90, 385, 150, 38);

        dlgMovie.setTitle("KINO – filma");
        dlgMovie.setModal(true);
        dlgMovie.setResizable(false);
        dlgMovie.getContentPane().setLayout(null);

        lblTitleMovie.setText("KINO");
        dlgMovie.getContentPane().add(lblTitleMovie);
        lblTitleMovie.setBounds(24, 8, 220, 54);

        lblZvaigznes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblZvaigznes.setText("★★★★★");
        dlgMovie.getContentPane().add(lblZvaigznes);
        lblZvaigznes.setBounds(640, 12, 276, 44);

        pnlLineMovie.setLayout(null);
        dlgMovie.getContentPane().add(pnlLineMovie);
        pnlLineMovie.setBounds(24, 64, 892, 4);
        dlgMovie.getContentPane().add(lblPlakatsMovie);
        lblPlakatsMovie.setBounds(24, 80, 150, 225);

        lblNosaukums.setText("Flow");
        dlgMovie.getContentPane().add(lblNosaukums);
        lblNosaukums.setBounds(192, 76, 600, 44);

        txtApraksts.setEditable(false);
        txtApraksts.setLineWrap(true);
        txtApraksts.setText("Apraksts");
        txtApraksts.setWrapStyleWord(true);
        dlgMovie.getContentPane().add(txtApraksts);
        txtApraksts.setBounds(192, 124, 724, 150);

        lblInfo.setText("Žanrs | Ilgums | Vecums");
        dlgMovie.getContentPane().add(lblInfo);
        lblInfo.setBounds(192, 280, 724, 26);

        btnRezervetMovie.setText("rezervēt vietu");
        btnRezervetMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRezervetMovieActionPerformed(evt);
            }
        });
        dlgMovie.getContentPane().add(btnRezervetMovie);
        btnRezervetMovie.setBounds(24, 318, 150, 40);

        btnPlans.setText("plāns");
        btnPlans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlansActionPerformed(evt);
            }
        });
        dlgMovie.getContentPane().add(btnPlans);
        btnPlans.setBounds(192, 318, 110, 40);

        pnlLine2.setLayout(null);
        dlgMovie.getContentPane().add(pnlLine2);
        pnlLine2.setBounds(24, 372, 892, 3);

        lblAtsauksmes.setText("<html><font color=\"#F2B01E\">★</font> ATSAUKSMES <font color=\"#F2B01E\">★</font></html>");
        dlgMovie.getContentPane().add(lblAtsauksmes);
        lblAtsauksmes.setBounds(24, 380, 320, 38);

        btnRakstit.setText("Rakstīt atsauksmi");
        btnRakstit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRakstitActionPerformed(evt);
            }
        });
        dlgMovie.getContentPane().add(btnRakstit);
        btnRakstit.setBounds(736, 384, 180, 32);

        pnlAtsauksmesMovie.setLayout(null);
        scrollAtsauksmesMovie.setViewportView(pnlAtsauksmesMovie);

        dlgMovie.getContentPane().add(scrollAtsauksmesMovie);
        scrollAtsauksmesMovie.setBounds(24, 424, 892, 156);

        dlgSessions.setTitle("KINO – seansu plānošana");
        dlgSessions.setModal(true);
        dlgSessions.setResizable(false);
        dlgSessions.getContentPane().setLayout(null);

        lblTitleSess.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleSess.setText("Seansu plānošana");
        dlgSessions.getContentPane().add(lblTitleSess);
        lblTitleSess.setBounds(20, 10, 640, 34);
        dlgSessions.getContentPane().add(lblPlakatsSess);
        lblPlakatsSess.setBounds(24, 60, 150, 225);

        tblSeansiSess.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Diena", "Laiks", "Zāle"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollSeansiSess.setViewportView(tblSeansiSess);

        dlgSessions.getContentPane().add(scrollSeansiSess);
        scrollSeansiSess.setBounds(194, 60, 420, 190);

        btnIzveleties.setText("Izvēlēties vietas");
        btnIzveleties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzveletiesActionPerformed(evt);
            }
        });
        dlgSessions.getContentPane().add(btnIzveleties);
        btnIzveleties.setBounds(194, 262, 190, 38);

        btnAizvert.setText("Aizvērt");
        btnAizvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAizvertActionPerformed(evt);
            }
        });
        dlgSessions.getContentPane().add(btnAizvert);
        btnAizvert.setBounds(394, 262, 120, 38);

        dlgSeats.setTitle("KINO – vietu rezervēšana");
        dlgSeats.setModal(true);
        dlgSeats.setResizable(false);
        dlgSeats.getContentPane().setLayout(null);

        lblTitleSeat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleSeat.setText("Vietu rezervēšana");
        dlgSeats.getContentPane().add(lblTitleSeat);
        lblTitleSeat.setBounds(0, 10, 780, 36);

        lblFilmaSeat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFilmaSeat.setText("filmu: Flow");
        dlgSeats.getContentPane().add(lblFilmaSeat);
        lblFilmaSeat.setBounds(0, 48, 780, 30);

        pnlVietas.setLayout(null);
        dlgSeats.getContentPane().add(pnlVietas);
        pnlVietas.setBounds(32, 100, 716, 362);

        lblBrivs.setText("<html><font color=\"#4F81BD\">■</font> brīva</html>");
        dlgSeats.getContentPane().add(lblBrivs);
        lblBrivs.setBounds(40, 478, 120, 24);

        lblAiznemts.setText("<html><font color=\"#C0504D\">■</font> aizņemta</html>");
        dlgSeats.getContentPane().add(lblAiznemts);
        lblAiznemts.setBounds(170, 478, 120, 24);

        lblIzveleta.setText("<html><font color=\"#F79646\">■</font> izvēlēta</html>");
        dlgSeats.getContentPane().add(lblIzveleta);
        lblIzveleta.setBounds(300, 478, 120, 24);

        lblVietas.setText("Izvēlētās vietas: –");
        dlgSeats.getContentPane().add(lblVietas);
        lblVietas.setBounds(40, 520, 480, 26);

        lblIemaksa.setText("Iemaksa: 1,00 € par katru rezervēto vietu");
        dlgSeats.getContentPane().add(lblIemaksa);
        lblIemaksa.setBounds(40, 552, 480, 24);

        btnRezervetSeat.setText("Rezervēt");
        btnRezervetSeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRezervetSeatActionPerformed(evt);
            }
        });
        dlgSeats.getContentPane().add(btnRezervetSeat);
        btnRezervetSeat.setBounds(560, 520, 190, 46);

        lblTitleSeat1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleSeat1.setText("Vietu rezervēšana");
        dlgSeats.getContentPane().add(lblTitleSeat1);
        lblTitleSeat1.setBounds(0, 10, 780, 36);

        lblFilmaSeat1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFilmaSeat1.setText("filmu: Flow");
        dlgSeats.getContentPane().add(lblFilmaSeat1);
        lblFilmaSeat1.setBounds(0, 48, 780, 30);

        dlgProfile.setTitle("KINO – profils");
        dlgProfile.setModal(true);
        dlgProfile.setResizable(false);
        dlgProfile.getContentPane().setLayout(null);

        lblTitleProf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleProf.setText("PROFILE");
        dlgProfile.getContentPane().add(lblTitleProf);
        lblTitleProf.setBounds(0, 10, 660, 34);
        dlgProfile.getContentPane().add(lblAvatars);
        lblAvatars.setBounds(30, 58, 140, 140);

        lblVards.setText("Vārds: Lietotājs");
        dlgProfile.getContentPane().add(lblVards);
        lblVards.setBounds(200, 78, 430, 30);

        lblStatuss.setText("Statuss: lietotājs");
        dlgProfile.getContentPane().add(lblStatuss);
        lblStatuss.setBounds(200, 116, 430, 30);

        lblEpasts.setText("E-pasts: –");
        dlgProfile.getContentPane().add(lblEpasts);
        lblEpasts.setBounds(200, 154, 430, 30);

        pnlLineProf.setLayout(null);
        dlgProfile.getContentPane().add(pnlLineProf);
        pnlLineProf.setBounds(20, 214, 620, 3);

        lblSaraksts.setText("Lietotāja iepirkumu saraksts:");
        dlgProfile.getContentPane().add(lblSaraksts);
        lblSaraksts.setBounds(24, 224, 520, 30);

        tblPirkumi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Filma", "Laiks"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPirkumi.setViewportView(tblPirkumi);

        dlgProfile.getContentPane().add(scrollPirkumi);
        scrollPirkumi.setBounds(24, 260, 612, 160);

        btnRezervacijas.setText("Manas rezervācijas");
        btnRezervacijas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRezervacijasActionPerformed(evt);
            }
        });
        dlgProfile.getContentPane().add(btnRezervacijas);
        btnRezervacijas.setBounds(24, 438, 200, 38);

        btnIziet.setText("Iziet");
        btnIziet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzietActionPerformed(evt);
            }
        });
        dlgProfile.getContentPane().add(btnIziet);
        btnIziet.setBounds(536, 438, 100, 38);

        dlgMyRes.setTitle("KINO – manas rezervācijas");
        dlgMyRes.setModal(true);
        dlgMyRes.setResizable(false);
        dlgMyRes.getContentPane().setLayout(null);

        lblTitleMyRes.setText("Manas rezervācijas");
        lblTitleMyRes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dlgMyRes.getContentPane().add(lblTitleMyRes);
        lblTitleMyRes.setBounds(0, 12, 740, 34);

        tblMyRes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Filma", "Datums", "Laiks", "Vieta", "Iemaksa", "Statuss"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollMyRes.setViewportView(tblMyRes);

        dlgMyRes.getContentPane().add(scrollMyRes);
        scrollMyRes.setBounds(24, 60, 692, 230);

        btnAtceltMyRes.setText("Atcelt rezervāciju");
        btnAtceltMyRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtceltMyResActionPerformed(evt);
            }
        });
        dlgMyRes.getContentPane().add(btnAtceltMyRes);
        btnAtceltMyRes.setBounds(24, 306, 200, 38);

        btnAtpakal.setText("Atpakaļ");
        btnAtpakal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtpakalActionPerformed(evt);
            }
        });
        dlgMyRes.getContentPane().add(btnAtpakal);
        btnAtpakal.setBounds(240, 306, 120, 38);

        lblPiezime.setText("Rezervāciju var atcelt ne vēlāk kā 15 minūtes pirms seansa sākuma.");
        dlgMyRes.getContentPane().add(lblPiezime);
        lblPiezime.setBounds(24, 354, 692, 28);

        dlgReview.setTitle("KINO – atsauksme");
        dlgReview.setModal(true);
        dlgReview.setResizable(false);
        dlgReview.getContentPane().setLayout(null);

        lblTitleRev.setText("Jūsu atsauksme");
        lblTitleRev.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dlgReview.getContentPane().add(lblTitleRev);
        lblTitleRev.setBounds(0, 12, 540, 34);

        lblFilmaRev.setText("Filma");
        dlgReview.getContentPane().add(lblFilmaRev);
        lblFilmaRev.setBounds(24, 54, 490, 26);

        lblVertejums.setText("Vērtējums:");
        dlgReview.getContentPane().add(lblVertejums);
        lblVertejums.setBounds(24, 92, 100, 28);

        cmbVertejums.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "4", "3", "2", "1" }));
        dlgReview.getContentPane().add(cmbVertejums);
        cmbVertejums.setBounds(130, 92, 100, 28);

        txtTeksts.setColumns(20);
        txtTeksts.setRows(5);
        txtTeksts.setLineWrap(true);
        txtTeksts.setWrapStyleWord(true);
        scrollTeksts.setViewportView(txtTeksts);

        dlgReview.getContentPane().add(scrollTeksts);
        scrollTeksts.setBounds(24, 132, 492, 150);

        btnPublicet.setText("Publicēt");
        btnPublicet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublicetActionPerformed(evt);
            }
        });
        dlgReview.getContentPane().add(btnPublicet);
        btnPublicet.setBounds(24, 298, 150, 38);

        btnAtceltRev.setText("Atcelt");
        btnAtceltRev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtceltRevActionPerformed(evt);
            }
        });
        dlgReview.getContentPane().add(btnAtceltRev);
        btnAtceltRev.setBounds(190, 298, 120, 38);

        dlgAdmin.setTitle("KINO – administrēšana");
        dlgAdmin.setModal(true);
        dlgAdmin.setResizable(false);
        dlgAdmin.getContentPane().setLayout(null);

        lblTitleAdm.setText("KINO");
        dlgAdmin.getContentPane().add(lblTitleAdm);
        lblTitleAdm.setBounds(24, 8, 220, 54);

        lblAdmins.setText("Administrators");
        lblAdmins.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dlgAdmin.getContentPane().add(lblAdmins);
        lblAdmins.setBounds(640, 16, 230, 36);
        dlgAdmin.getContentPane().add(lblAdminaIkona);
        lblAdminaIkona.setBounds(880, 14, 40, 40);

        pnlLineAdm.setLayout(null);
        dlgAdmin.getContentPane().add(pnlLineAdm);
        pnlLineAdm.setBounds(24, 64, 892, 4);

        pnlFilmasAdm.setLayout(null);

        lblFilmuPark.setText("Filmu pārvaldība");
        pnlFilmasAdm.add(lblFilmuPark);
        lblFilmuPark.setBounds(10, 6, 300, 30);

        tblFilmas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nosaukums", "Žanrs", "Ilgums", "Vecums"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollFilmasAdm.setViewportView(tblFilmas);

        pnlFilmasAdm.add(scrollFilmasAdm);
        scrollFilmasAdm.setBounds(10, 44, 440, 330);

        lblFNosaukums.setText("Nosaukums");
        pnlFilmasAdm.add(lblFNosaukums);
        lblFNosaukums.setBounds(470, 44, 130, 28);
        pnlFilmasAdm.add(txtFNosaukums);
        txtFNosaukums.setBounds(620, 44, 250, 28);

        lblFZanrs.setText("Žanrs");
        pnlFilmasAdm.add(lblFZanrs);
        lblFZanrs.setBounds(470, 82, 130, 28);
        pnlFilmasAdm.add(txtFZanrs);
        txtFZanrs.setBounds(620, 82, 250, 28);

        lblFIlgums.setText("Ilgums (min)");
        pnlFilmasAdm.add(lblFIlgums);
        lblFIlgums.setBounds(470, 120, 130, 28);
        pnlFilmasAdm.add(txtFIlgums);
        txtFIlgums.setBounds(620, 120, 250, 28);

        lblFVecums.setText("Vecums (ierobež.)");
        pnlFilmasAdm.add(lblFVecums);
        lblFVecums.setBounds(470, 158, 130, 28);
        pnlFilmasAdm.add(txtFVecums);
        txtFVecums.setBounds(620, 158, 250, 28);

        lblFPlakats.setText("Plakāts");
        pnlFilmasAdm.add(lblFPlakats);
        lblFPlakats.setBounds(470, 196, 130, 28);
        pnlFilmasAdm.add(txtFPlakats);
        txtFPlakats.setBounds(620, 196, 250, 28);

        lblFTreileris.setText("Treilera saite");
        pnlFilmasAdm.add(lblFTreileris);
        lblFTreileris.setBounds(470, 234, 130, 28);
        pnlFilmasAdm.add(txtFTreileris);
        txtFTreileris.setBounds(620, 234, 250, 28);

        lblFApraksts.setText("Apraksts");
        pnlFilmasAdm.add(lblFApraksts);
        lblFApraksts.setBounds(470, 272, 130, 28);

        txtFApraksts.setColumns(20);
        txtFApraksts.setRows(5);
        txtFApraksts.setLineWrap(true);
        txtFApraksts.setWrapStyleWord(true);
        scrollFApraksts.setViewportView(txtFApraksts);

        pnlFilmasAdm.add(scrollFApraksts);
        scrollFApraksts.setBounds(620, 272, 250, 102);

        btnPievienot.setText("Pievienot");
        btnPievienot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPievienotActionPerformed(evt);
            }
        });
        pnlFilmasAdm.add(btnPievienot);
        btnPievienot.setBounds(10, 392, 120, 36);

        btnRediget.setText("Rediģēt");
        btnRediget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedigetActionPerformed(evt);
            }
        });
        pnlFilmasAdm.add(btnRediget);
        btnRediget.setBounds(140, 392, 120, 36);

        btnDzestFilmu.setText("Dzēst");
        btnDzestFilmu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDzestFilmuActionPerformed(evt);
            }
        });
        pnlFilmasAdm.add(btnDzestFilmu);
        btnDzestFilmu.setBounds(270, 392, 120, 36);

        lblFPiezime.setText("Ja filmai ir aktīvi seansi vai rezervācijas, pirms dzēšanas tiek rādīts brīdinājums.");
        pnlFilmasAdm.add(lblFPiezime);
        lblFPiezime.setBounds(10, 440, 860, 28);

        tabs.addTab("Filmas", pnlFilmasAdm);

        pnlSeansi.setLayout(null);

        lblSeansuPark.setText("Seansu pārvaldība");
        pnlSeansi.add(lblSeansuPark);
        lblSeansuPark.setBounds(10, 6, 300, 30);

        tblSeansiAdm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Filma", "Zāle", "Datums", "Laiks", "Cena"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollSeansiAdm.setViewportView(tblSeansiAdm);

        pnlSeansi.add(scrollSeansiAdm);
        scrollSeansiAdm.setBounds(10, 44, 490, 330);

        lblSFilma.setText("Filma");
        pnlSeansi.add(lblSFilma);
        lblSFilma.setBounds(530, 44, 100, 28);

        cmbSFilma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2012", "Flow", "Transformers", "Harry Potter", "The Shawshank Redemption" }));
        pnlSeansi.add(cmbSFilma);
        cmbSFilma.setBounds(640, 44, 240, 28);

        lblSZale.setText("Kinozāle");
        pnlSeansi.add(lblSZale);
        lblSZale.setBounds(530, 84, 100, 28);

        cmbSZale.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1. zāle", "2. zāle", "3. zāle" }));
        pnlSeansi.add(cmbSZale);
        cmbSZale.setBounds(640, 84, 240, 28);

        lblSDatums.setText("Datums");
        pnlSeansi.add(lblSDatums);
        lblSDatums.setBounds(530, 124, 100, 28);
        pnlSeansi.add(txtSDatums);
        txtSDatums.setBounds(640, 124, 240, 28);

        lblSLaiks.setText("Laiks");
        pnlSeansi.add(lblSLaiks);
        lblSLaiks.setBounds(530, 164, 100, 28);
        pnlSeansi.add(txtSLaiks);
        txtSLaiks.setBounds(640, 164, 240, 28);

        lblSCena.setText("Biļetes cena (€)");
        pnlSeansi.add(lblSCena);
        lblSCena.setBounds(530, 204, 110, 28);
        pnlSeansi.add(txtSCena);
        txtSCena.setBounds(640, 204, 240, 28);

        btnIzveidot.setText("Izveidot");
        btnIzveidot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzveidotActionPerformed(evt);
            }
        });
        pnlSeansi.add(btnIzveidot);
        btnIzveidot.setBounds(10, 392, 120, 36);

        btnMainit.setText("Mainīt");
        btnMainit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainitActionPerformed(evt);
            }
        });
        pnlSeansi.add(btnMainit);
        btnMainit.setBounds(140, 392, 120, 36);

        btnAtceltSeansu.setText("Atcelt seansu");
        btnAtceltSeansu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtceltSeansuActionPerformed(evt);
            }
        });
        pnlSeansi.add(btnAtceltSeansu);
        btnAtceltSeansu.setBounds(270, 392, 160, 36);

        lblSPiezime.setText("Sistēma pārbauda, vai izvēlētajā zālē norādītajā laikā jau nav cita seansa.");
        pnlSeansi.add(lblSPiezime);
        lblSPiezime.setBounds(10, 440, 860, 28);

        tabs.addTab("Seansi", pnlSeansi);

        pnlAtsAdm.setLayout(null);

        lblAFiltrs.setText("Filtrs:");
        pnlAtsAdm.add(lblAFiltrs);
        lblAFiltrs.setBounds(10, 8, 60, 28);
        pnlAtsAdm.add(txtAFiltrs);
        txtAFiltrs.setBounds(75, 8, 330, 28);

        btnMeklet.setText("Meklēt");
        btnMeklet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMekletActionPerformed(evt);
            }
        });
        pnlAtsAdm.add(btnMeklet);
        btnMeklet.setBounds(415, 8, 100, 28);

        tblAtsauksmes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lietotājs", "Filma", "Vērtējums", "Atsauksmes teksts", "Datums"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollAtsAdm.setViewportView(tblAtsauksmes);

        pnlAtsAdm.add(scrollAtsAdm);
        scrollAtsAdm.setBounds(10, 50, 868, 324);

        btnDzestAtsauksmi.setText("Dzēst atsauksmi");
        btnDzestAtsauksmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDzestAtsauksmiActionPerformed(evt);
            }
        });
        pnlAtsAdm.add(btnDzestAtsauksmi);
        btnDzestAtsauksmi.setBounds(10, 392, 190, 36);

        lblAPiezime.setText("Dzēšana notiek pēc administratora apstiprinājuma.");
        pnlAtsAdm.add(lblAPiezime);
        lblAPiezime.setBounds(10, 440, 860, 28);

        tabs.addTab("Atsauksmes", pnlAtsAdm);

        pnlLietotaji.setLayout(null);

        lblLietPark.setText("Lietotāju pārvaldība");
        pnlLietotaji.add(lblLietPark);
        lblLietPark.setBounds(10, 6, 300, 30);

        tblLietotaji.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Vārds", "Uzvārds", "Lietotājvārds", "E-pasts", "Statuss"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollLietotaji.setViewportView(tblLietotaji);

        pnlLietotaji.add(scrollLietotaji);
        scrollLietotaji.setBounds(10, 44, 868, 330);

        btnBlokat.setText("Bloķēt");
        btnBlokat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlokatActionPerformed(evt);
            }
        });
        pnlLietotaji.add(btnBlokat);
        btnBlokat.setBounds(10, 392, 120, 36);

        btnAtblokat.setText("Atbloķēt");
        btnAtblokat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtblokatActionPerformed(evt);
            }
        });
        pnlLietotaji.add(btnAtblokat);
        btnAtblokat.setBounds(140, 392, 120, 36);

        btnDzestLietotaju.setText("Dzēst");
        btnDzestLietotaju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDzestLietotajuActionPerformed(evt);
            }
        });
        pnlLietotaji.add(btnDzestLietotaju);
        btnDzestLietotaju.setBounds(270, 392, 120, 36);

        lblLPiezime.setText("Bloķēts lietotājs nevar pieslēgties, rezervēt biļetes vai rakstīt atsauksmes.");
        pnlLietotaji.add(lblLPiezime);
        lblLPiezime.setBounds(10, 440, 860, 28);

        tabs.addTab("Lietotāji", pnlLietotaji);

        pnlRezervacijas.setLayout(null);

        lblRFilma.setText("Filma:");
        pnlRezervacijas.add(lblRFilma);
        lblRFilma.setBounds(10, 8, 60, 28);

        cmbRFilma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Visas filmas", "2012", "Flow", "Transformers", "Harry Potter", "The Shawshank Redemption" }));
        pnlRezervacijas.add(cmbRFilma);
        cmbRFilma.setBounds(70, 8, 230, 28);

        lblRDatums.setText("Datums:");
        pnlRezervacijas.add(lblRDatums);
        lblRDatums.setBounds(330, 8, 70, 28);
        pnlRezervacijas.add(txtRDatums);
        txtRDatums.setBounds(405, 8, 150, 28);

        btnFiltret.setText("Filtrēt");
        btnFiltret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltretActionPerformed(evt);
            }
        });
        pnlRezervacijas.add(btnFiltret);
        btnFiltret.setBounds(570, 8, 100, 28);

        tblRezAdm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Lietotājs", "Filma", "Datums", "Laiks", "Vieta", "Statuss"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollRezAdm.setViewportView(tblRezAdm);

        pnlRezervacijas.add(scrollRezAdm);
        scrollRezAdm.setBounds(10, 50, 868, 324);

        btnAtceltRezervaciju.setText("Atcelt rezervāciju");
        btnAtceltRezervaciju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtceltRezervacijuActionPerformed(evt);
            }
        });
        pnlRezervacijas.add(btnAtceltRezervaciju);
        btnAtceltRezervaciju.setBounds(10, 392, 210, 36);

        lblRPiezime.setText("Administrators var atcelt jebkuru rezervāciju neatkarīgi no atlikušā laika līdz seansam.");
        pnlRezervacijas.add(lblRPiezime);
        lblRPiezime.setBounds(10, 440, 860, 28);

        tabs.addTab("Rezervācijas", pnlRezervacijas);

        dlgAdmin.getContentPane().add(tabs);
        tabs.setBounds(24, 78, 892, 510);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KINO");
        setResizable(false);
        getContentPane().setLayout(null);

        lblTitle.setText("KINO");
        getContentPane().add(lblTitle);
        lblTitle.setBounds(24, 8, 220, 54);

        btnAdmin.setText("Administrēšana");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdmin);
        btnAdmin.setBounds(480, 16, 170, 36);

        btnUser.setText("Lietotājs");
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });
        getContentPane().add(btnUser);
        btnUser.setBounds(670, 14, 246, 40);

        pnlLine.setLayout(null);
        getContentPane().add(pnlLine);
        pnlLine.setBounds(24, 64, 892, 4);
        getContentPane().add(lblMeklet);
        lblMeklet.setBounds(32, 88, 28, 28);

        txtMeklet.setText("Search...");
        getContentPane().add(txtMeklet);
        txtMeklet.setBounds(24, 80, 892, 40);

        pnlFilmas.setLayout(null);
        scrollFilmas.setViewportView(pnlFilmas);

        getContentPane().add(scrollFilmas);
        scrollFilmas.setBounds(24, 132, 892, 410);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        DemoData.User u = DemoData.login(Ui.value(txtLoginUser), Ui.value(txtLoginPass));
        if (u == null) {
            JOptionPane.showMessageDialog(dlgLogin, "Nepareizs lietotājvārds vai parole!", "Kļūda", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(dlgLogin, "Ieeja ir veiksmīga!", "KINO", JOptionPane.INFORMATION_MESSAGE);
        user = u;
        loggedIn = true;
        dlgLogin.dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnOpenRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenRegisterActionPerformed
        openRegister();
    }//GEN-LAST:event_btnOpenRegisterActionPerformed

    private void btnGuestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuestActionPerformed
        user = DemoData.GUEST;
        loggedIn = true;
        dlgLogin.dispose();
    }//GEN-LAST:event_btnGuestActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        String vards = Ui.value(txtVards);
        String uzvards = Ui.value(txtUzvards);
        String lietotajvards = Ui.value(txtRegUser);
        String parole = Ui.value(txtRegPass);
        String parole2 = Ui.value(txtRegPass2);
        String epasts = Ui.value(txtEpasts);
        if (vards.isEmpty() || uzvards.isEmpty() || lietotajvards.isEmpty()
                || parole.isEmpty() || parole2.isEmpty() || epasts.isEmpty()) {
            kluda(dlgRegister, "Lūdzu, aizpildiet visus laukus!");
            return;
        }
        if (!epasts.matches("[^@\\s]+@[^@\\s]+\\.[^@\\s]+")) {
            kluda(dlgRegister, "E-pasta adrese ir ievadīta nepareizā formātā!");
            return;
        }
        if (!parole.equals(parole2)) {
            kluda(dlgRegister, "Paroles nesakrīt!");
            return;
        }
        if (!DemoData.register(vards, uzvards, lietotajvards, parole, epasts)) {
            kluda(dlgRegister, "Šāds lietotājvārds jau eksistē!");
            return;
        }
        JOptionPane.showMessageDialog(dlgRegister, "Reģistrēšana ir veiksmīga!", "KINO", JOptionPane.INFORMATION_MESSAGE);
        dlgRegister.dispose();
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnRezervetMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRezervetMovieActionPerformed
        if (user.guest()) {
            JOptionPane.showMessageDialog(dlgMovie, "Vietu rezervēšanai nepieciešams pieslēgties sistēmai.", "KINO", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        // rezervācija tuvākajam seansam; citu seansu var izvēlēties pogas "plāns" logā
        DemoData.Seanss tuvakais = DemoData.sessionsFor(film.id()).get(0);
        openSeats(tuvakais);
    }//GEN-LAST:event_btnRezervetMovieActionPerformed

    private void btnPlansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlansActionPerformed
        openSessions();
    }//GEN-LAST:event_btnPlansActionPerformed

    private void btnRakstitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRakstitActionPerformed
        if (user.guest()) {
            JOptionPane.showMessageDialog(dlgMovie, "Atsauksmes var rakstīt tikai reģistrēti lietotāji.", "KINO", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        openReview();
    }//GEN-LAST:event_btnRakstitActionPerformed

    private void btnIzveletiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzveletiesActionPerformed
        int rinda = tblSeansiSess.getSelectedRow();
        if (rinda < 0 || rinda >= sessions.size()) {
            JOptionPane.showMessageDialog(dlgSessions, "Izvēlieties seansu tabulā!", "KINO", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (user.guest()) {
            JOptionPane.showMessageDialog(dlgSessions, "Vietu rezervēšanai nepieciešams pieslēgties sistēmai.", "KINO", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        openSeats(sessions.get(rinda));
    }//GEN-LAST:event_btnIzveletiesActionPerformed

    private void btnAizvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAizvertActionPerformed
        dlgSessions.dispose();
    }//GEN-LAST:event_btnAizvertActionPerformed

    private void btnRezervetSeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRezervetSeatActionPerformed
        java.util.List<String> izveletas = izveletasVietas();
        if (user.guest()) {
            JOptionPane.showMessageDialog(dlgSeats, "Vietu rezervēšanai nepieciešams pieslēgties sistēmai.", "KINO", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (izveletas.isEmpty()) {
            JOptionPane.showMessageDialog(dlgSeats, "Lūdzu, izvēlieties vismaz vienu vietu!", "Kļūda", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int atbilde = JOptionPane.showConfirmDialog(dlgSeats,
                "Rezervēt vietas (rinda-vieta): " + String.join(", ", izveletas) + "?\nIemaksa: "
                + izveletas.size() + ",00 € (1,00 € par katru vietu).",
                "Rezervācija", JOptionPane.YES_NO_OPTION);
        if (atbilde != JOptionPane.YES_OPTION) {
            return;
        }
        for (String vieta : izveletas) {
            String[] d = vieta.split("-");
            DemoData.addReservation(film.nosaukums(), seanss.diena(), seanss.laiks(), d[0] + ". rinda, " + d[1] + ". vieta");
        }
        JOptionPane.showMessageDialog(dlgSeats, "Rezervācija ir veiksmīga!", "KINO", JOptionPane.INFORMATION_MESSAGE);
        dlgSeats.dispose();
    }//GEN-LAST:event_btnRezervetSeatActionPerformed

    private void btnRezervacijasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRezervacijasActionPerformed
        openReservations();
    }//GEN-LAST:event_btnRezervacijasActionPerformed

    private void btnIzietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzietActionPerformed
        logoutRequested = true;
        dlgProfile.dispose();
    }//GEN-LAST:event_btnIzietActionPerformed

    private void btnAtceltMyResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtceltMyResActionPerformed
        int rinda = tblMyRes.getSelectedRow();
        if (rinda < 0) {
            JOptionPane.showMessageDialog(dlgMyRes, "Izvēlieties rezervāciju tabulā!", "KINO", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        DemoData.Reservation r = DemoData.RESERVATIONS.get(rinda);
        if (!"aktīva".equals(r.statuss)) {
            JOptionPane.showMessageDialog(dlgMyRes, "Šī rezervācija jau ir atcelta!", "KINO", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (r.minutesToStart < 15) {
            JOptionPane.showMessageDialog(dlgMyRes,
                    "Rezervāciju vairs nevar atcelt – līdz seansa sākumam atlikušas mazāk par 15 minūtēm!",
                    "Kļūda", JOptionPane.ERROR_MESSAGE);
            return;
        }
        r.statuss = "atcelta";
        tblMyRes.getModel().setValueAt("atcelta", rinda, 5);
        JOptionPane.showMessageDialog(dlgMyRes, "Rezervācija ir veiksmīgi atcelta!", "KINO", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAtceltMyResActionPerformed

    private void btnAtpakalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtpakalActionPerformed
        dlgMyRes.dispose();
    }//GEN-LAST:event_btnAtpakalActionPerformed

    private void btnPublicetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublicetActionPerformed
        String teksts = txtTeksts.getText().trim();
        if (teksts.length() < 3) {
            JOptionPane.showMessageDialog(dlgReview, "Ievadiet atsauksmes tekstu!", "Kļūda", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int vertejums = Integer.parseInt((String) cmbVertejums.getSelectedItem());
        String laiks = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy"));
        DemoData.addReview(film.id(), new DemoData.Review(user.vards(), vertejums, teksts, laiks));
        loadReviews();
        JOptionPane.showMessageDialog(dlgReview, "Atsauksme ir veiksmīgi publicēta!", "KINO", JOptionPane.INFORMATION_MESSAGE);
        dlgReview.dispose();
    }//GEN-LAST:event_btnPublicetActionPerformed

    private void btnAtceltRevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtceltRevActionPerformed
        dlgReview.dispose();
    }//GEN-LAST:event_btnAtceltRevActionPerformed

    private void btnPievienotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPievienotActionPerformed
        String nosaukums = txtFNosaukums.getText().trim();
        if (nosaukums.isEmpty()) {
            kluda(dlgAdmin, "Ievadiet filmas nosaukumu!");
            return;
        }
        int ilgums;
        try {
            ilgums = Integer.parseInt(txtFIlgums.getText().trim());
        } catch (NumberFormatException ex) {
            kluda(dlgAdmin, "Ilgumam jābūt veselam skaitlim (minūtēs)!");
            return;
        }
        modelisFilmas.addRow(new Object[]{nosaukums, txtFZanrs.getText().trim(), ilgums + " min", txtFVecums.getText().trim()});
        notiritFilmasLaukus();
        info(dlgAdmin, "Filmu dati ir veiksmīgi saglabāti!");
    }//GEN-LAST:event_btnPievienotActionPerformed

    private void btnRedigetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedigetActionPerformed
        int rinda = tblFilmas.getSelectedRow();
        if (rinda < 0) {
            kluda(dlgAdmin, "Izvēlieties filmu tabulā!");
            return;
        }
        modelisFilmas.setValueAt(txtFNosaukums.getText().trim(), rinda, 0);
        modelisFilmas.setValueAt(txtFZanrs.getText().trim(), rinda, 1);
        modelisFilmas.setValueAt(txtFIlgums.getText().trim() + " min", rinda, 2);
        modelisFilmas.setValueAt(txtFVecums.getText().trim(), rinda, 3);
        info(dlgAdmin, "Filmu dati ir veiksmīgi saglabāti!");
    }//GEN-LAST:event_btnRedigetActionPerformed

    private void btnDzestFilmuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDzestFilmuActionPerformed
        int rinda = tblFilmas.getSelectedRow();
        if (rinda < 0) {
            kluda(dlgAdmin, "Izvēlieties filmu tabulā!");
            return;
        }
        if (apstiprinat(dlgAdmin, "Vai tiešām dzēst izvēlēto filmu?\nJa filmai ir aktīvi seansi vai rezervācijas, tās tiks atceltas.")) {
            modelisFilmas.removeRow(rinda);
            notiritFilmasLaukus();
        }
    }//GEN-LAST:event_btnDzestFilmuActionPerformed

    private void btnIzveidotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzveidotActionPerformed
        String datums = txtSDatums.getText().trim();
        String laiks = txtSLaiks.getText().trim();
        String cena = txtSCena.getText().trim().replace(',', '.');
        if (datums.isEmpty() || laiks.isEmpty() || cena.isEmpty()) {
            kluda(dlgAdmin, "Aizpildiet datumu, laiku un biļetes cenu!");
            return;
        }
        try {
            Double.parseDouble(cena);
        } catch (NumberFormatException ex) {
            kluda(dlgAdmin, "Cenai jābūt skaitlim!");
            return;
        }
        String zale = (String) cmbSZale.getSelectedItem();
        for (int i = 0; i < modelisSeansi.getRowCount(); i++) {
            if (zale.equals(modelisSeansi.getValueAt(i, 1)) && datums.equals(modelisSeansi.getValueAt(i, 2))
                    && laiks.equals(modelisSeansi.getValueAt(i, 3))) {
                kluda(dlgAdmin, "Izvēlētajā zālē šajā laikā jau ir cits seanss – seansu laiki krustojas!");
                return;
            }
        }
        modelisSeansi.addRow(new Object[]{cmbSFilma.getSelectedItem(), zale, datums, laiks, cena});
        info(dlgAdmin, "Seanss ir veiksmīgi saglabāts!");
    }//GEN-LAST:event_btnIzveidotActionPerformed

    private void btnMainitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainitActionPerformed
        int rinda = tblSeansiAdm.getSelectedRow();
        if (rinda < 0) {
            kluda(dlgAdmin, "Izvēlieties seansu tabulā!");
            return;
        }
        modelisSeansi.setValueAt(cmbSFilma.getSelectedItem(), rinda, 0);
        modelisSeansi.setValueAt(cmbSZale.getSelectedItem(), rinda, 1);
        modelisSeansi.setValueAt(txtSDatums.getText().trim(), rinda, 2);
        modelisSeansi.setValueAt(txtSLaiks.getText().trim(), rinda, 3);
        modelisSeansi.setValueAt(txtSCena.getText().trim(), rinda, 4);
        info(dlgAdmin, "Seanss ir veiksmīgi saglabāts!");
    }//GEN-LAST:event_btnMainitActionPerformed

    private void btnAtceltSeansuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtceltSeansuActionPerformed
        int rinda = tblSeansiAdm.getSelectedRow();
        if (rinda < 0) {
            kluda(dlgAdmin, "Izvēlieties seansu tabulā!");
            return;
        }
        if (apstiprinat(dlgAdmin, "Vai atcelt izvēlēto seansu?\nVisas tā rezervācijas tiks atceltas, iemaksa – atzīmēta kā atgriežama.")) {
            modelisSeansi.removeRow(rinda);
            info(dlgAdmin, "Seanss ir atcelts!");
        }
    }//GEN-LAST:event_btnAtceltSeansuActionPerformed

    private void btnMekletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMekletActionPerformed
        String f = txtAFiltrs.getText().trim();
        sorterAtsauksmes.setRowFilter(f.isEmpty() ? null : javax.swing.RowFilter.regexFilter("(?i)" + java.util.regex.Pattern.quote(f)));
    }//GEN-LAST:event_btnMekletActionPerformed

    private void btnDzestAtsauksmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDzestAtsauksmiActionPerformed
        int rinda = tblAtsauksmes.getSelectedRow();
        if (rinda < 0) {
            kluda(dlgAdmin, "Izvēlieties atsauksmi tabulā!");
            return;
        }
        if (apstiprinat(dlgAdmin, "Vai dzēst izvēlēto atsauksmi?")) {
            modelisAtsauksmes.removeRow(tblAtsauksmes.convertRowIndexToModel(rinda));
            info(dlgAdmin, "Atsauksme ir veiksmīgi dzēsta!");
        }
    }//GEN-LAST:event_btnDzestAtsauksmiActionPerformed

    private void btnBlokatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlokatActionPerformed
        mainitStatusu("bloķēts");
    }//GEN-LAST:event_btnBlokatActionPerformed

    private void btnAtblokatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtblokatActionPerformed
        mainitStatusu("aktīvs");
    }//GEN-LAST:event_btnAtblokatActionPerformed

    private void btnDzestLietotajuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDzestLietotajuActionPerformed
        int rinda = tblLietotaji.getSelectedRow();
        if (rinda < 0) {
            kluda(dlgAdmin, "Izvēlieties lietotāju tabulā!");
            return;
        }
        if (apstiprinat(dlgAdmin, "Vai dzēst izvēlēto lietotāju?")) {
            modelisLietotaji.removeRow(rinda);
            info(dlgAdmin, "Lietotāja konts ir veiksmīgi dzēsts!");
        }
    }//GEN-LAST:event_btnDzestLietotajuActionPerformed

    private void btnFiltretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltretActionPerformed
        java.util.List<javax.swing.RowFilter<Object, Object>> filtri = new java.util.ArrayList<>();
        String filma = (String) cmbRFilma.getSelectedItem();
        if (filma != null && !"Visas filmas".equals(filma)) {
            filtri.add(javax.swing.RowFilter.regexFilter("^" + java.util.regex.Pattern.quote(filma) + "$", 2));
        }
        String datums = txtRDatums.getText().trim();
        if (!datums.isEmpty()) {
            filtri.add(javax.swing.RowFilter.regexFilter(java.util.regex.Pattern.quote(datums), 3));
        }
        sorterRezervacijas.setRowFilter(filtri.isEmpty() ? null : javax.swing.RowFilter.andFilter(filtri));
    }//GEN-LAST:event_btnFiltretActionPerformed

    private void btnAtceltRezervacijuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtceltRezervacijuActionPerformed
        int rinda = tblRezAdm.getSelectedRow();
        if (rinda < 0) {
            kluda(dlgAdmin, "Izvēlieties rezervāciju tabulā!");
            return;
        }
        int m = tblRezAdm.convertRowIndexToModel(rinda);
        if ("atcelta".equals(modelisRezervacijas.getValueAt(m, 6))) {
            kluda(dlgAdmin, "Šī rezervācija jau ir atcelta!");
            return;
        }
        if (apstiprinat(dlgAdmin, "Vai atcelt izvēlēto rezervāciju?")) {
            modelisRezervacijas.setValueAt("atcelta", m, 6);
            info(dlgAdmin, "Rezervācija ir veiksmīgi atcelta!");
        }
    }//GEN-LAST:event_btnAtceltRezervacijuActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        openAdmin();
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        if (user.guest()) {
            // viesis: atgriežas pieslēgšanās logā
            relogin();
            return;
        }
        openProfile();
        if (logoutRequested) {
            logoutRequested = false;
            relogin();
        }
    }//GEN-LAST:event_btnUserActionPerformed

    // ===================================================================
    //  Lietotnes stāvoklis (kopīgs visiem logiem)
    // ===================================================================
    private DemoData.User user = DemoData.GUEST;        // pieslēgušais lietotājs
    private DemoData.Film film;                          // izvēlētā filma
    private DemoData.Seanss seanss;                      // izvēlētais seanss
    private java.util.List<DemoData.Seanss> sessions = new ArrayList<>();
    private boolean loggedIn;
    private boolean logoutRequested;
    private JTextField[] registerFields;
    private final java.util.List<JToggleButton> seats = new ArrayList<>();

    // ===================================================================
    //  Programmas ieeja
    // ===================================================================
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception ex) {
            // izmanto noklusējuma izskatu
        }
        java.awt.EventQueue.invokeLater(() -> new MainFrame().start());
    }

    /** Parāda pieslēgšanās dialogu, pēc veiksmīgas pieslēgšanās – galveno logu. */
    public void start() {
        loggedIn = false;
        resetLogin();
        showDialog(dlgLogin);
        if (!loggedIn) {
            System.exit(0);
        }
        refreshMain();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /** Atgriežas pieslēgšanās dialogā (viesis vai lietotājs nospieda "Iziet"). */
    private void relogin() {
        setVisible(false);
        start();
    }

    // ===================================================================
    //  Palīgmetodes
    // ===================================================================
    private void kluda(java.awt.Component vecaks, String zina) {
        JOptionPane.showMessageDialog(vecaks, zina, "Kļūda", JOptionPane.ERROR_MESSAGE);
    }

    private void info(java.awt.Component vecaks, String zina) {
        JOptionPane.showMessageDialog(vecaks, zina, "KINO", JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean apstiprinat(java.awt.Component vecaks, String jautajums) {
        return JOptionPane.showConfirmDialog(vecaks, jautajums, "Apstiprinājums", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    /** Parāda modālo dialogu, centrējot to pret galveno logu (vai ekrānu, ja galvenais logs vēl nav redzams). */
    private void showDialog(javax.swing.JDialog d) {
        d.setLocationRelativeTo(isShowing() ? this : null);
        d.setVisible(true);
    }

    /** Darbības, ko GUI Builder neģenerē: izskats, ikonas, sākotnējie dati. */
    private void customInit() {
        initMain();
        initLogin();
        initRegister();
        initMovie();
        initSessions();
        initSeats();
        initProfile();
        initMyRes();
        initReview();
        initAdmin();
    }

    // ===================================================================
    //  Galvenais logs (JFrame): filmu saraksts
    // ===================================================================
    private void initMain() {
        Ui.fit(this, 940, 560, 3);
        Ui.title(lblTitle, 38);
        Ui.line(pnlLine);

        btnUser.setIcon(Ui.userIcon(36));
        btnUser.setHorizontalTextPosition(SwingConstants.LEFT);
        btnUser.setIconTextGap(10);
        Ui.flatButton(btnUser, 17);
        Ui.button(btnAdmin, Ui.TEAL);

        lblMeklet.setIcon(Ui.magnifier(26));
        Ui.field(txtMeklet);
        txtMeklet.setBorder(BorderFactory.createCompoundBorder(Ui.blueBorder(2), BorderFactory.createEmptyBorder(2, 40, 2, 8)));
        txtMeklet.setFont(txtMeklet.getFont().deriveFont(17f));
        Ui.hint(txtMeklet, "Search...");
        txtMeklet.getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { loadFilms(Ui.value(txtMeklet)); }
            @Override public void removeUpdate(DocumentEvent e) { loadFilms(Ui.value(txtMeklet)); }
            @Override public void changedUpdate(DocumentEvent e) { loadFilms(Ui.value(txtMeklet)); }
        });

        Ui.scroll(scrollFilmas);
        scrollFilmas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pnlFilmas.setLayout(new BoxLayout(pnlFilmas, BoxLayout.Y_AXIS));
        pnlFilmas.setBackground(Color.WHITE);
        pnlFilmas.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
        loadFilms("");
    }

    /** Atjauno galvenā loga datus pēc pieslēgšanās. */
    private void refreshMain() {
        btnUser.setText(user.vards());
        btnAdmin.setVisible(user.admin());
    }

    /** Aizpilda filmu sarakstu (ar filtru pēc nosaukuma). */
    private void loadFilms(String filtrs) {
        pnlFilmas.removeAll();
        String f = filtrs == null ? "" : filtrs.toLowerCase();
        for (final DemoData.Film f1 : DemoData.FILMS) {
            if (!f.isEmpty() && !f1.nosaukums().toLowerCase().contains(f)) {
                continue;
            }
            pnlFilmas.add(new FilmCard(f1, () -> openMovie(f1)));
            pnlFilmas.add(Box.createVerticalStrut(8));
        }
        pnlFilmas.revalidate();
        pnlFilmas.repaint();
    }

    // ===================================================================
    //  Dialogu atvēršana
    // ===================================================================
    private void openRegister() {
        for (JTextField t : registerFields) {
            Ui.clear(t);
        }
        showDialog(dlgRegister);
    }

    private void openMovie(DemoData.Film izveletaFilma) {
        film = izveletaFilma;
        refreshMovie();
        showDialog(dlgMovie);
    }

    private void openSessions() {
        refreshSessions();
        showDialog(dlgSessions);
    }

    private void openSeats(DemoData.Seanss izveletaisSeanss) {
        seanss = izveletaisSeanss;
        refreshSeats();
        showDialog(dlgSeats);
    }

    private void openProfile() {
        refreshProfile();
        showDialog(dlgProfile);
    }

    private void openReservations() {
        refreshMyRes();
        showDialog(dlgMyRes);
    }

    private void openReview() {
        refreshReview();
        showDialog(dlgReview);
    }

    private void openAdmin() {
        lblAdmins.setText(user.vards());
        showDialog(dlgAdmin);
    }

    // ===================================================================
    //  Dialogs: pieslēgšanās
    // ===================================================================
    private void initLogin() {
        Ui.fit(dlgLogin, 330, 300, 3);
        Ui.title(lblTitleLogin, 32);
        Ui.field(txtLoginUser);
        Ui.field(txtLoginPass);
        Ui.hint(txtLoginUser, "Lietotājvārds");
        Ui.hint(txtLoginPass, "Parole");
        Ui.button(btnLogin, Ui.BLUE);
        Ui.button(btnOpenRegister, Ui.BLUE);
        Ui.flatButton(btnGuest, 12);
        dlgLogin.getRootPane().setDefaultButton(btnLogin);
        dlgLogin.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent e) {
                btnLogin.requestFocusInWindow();
            }
        });
    }

    private void resetLogin() {
        Ui.clear(txtLoginUser);
        Ui.clear(txtLoginPass);
    }

    // ===================================================================
    //  Dialogs: reģistrēšanās
    // ===================================================================
    private void initRegister() {
        Ui.fit(dlgRegister, 330, 460, 3);
        Ui.title(lblTitleReg, 28);
        registerFields = new JTextField[]{txtVards, txtUzvards, txtRegUser, txtRegPass, txtRegPass2, txtEpasts};
        String[] paskaidrojumi = {"Vārds", "Uzvārds", "Lietotājvārds", "Parole", "Atkārtot paroli", "E-pasts"};
        for (int i = 0; i < registerFields.length; i++) {
            Ui.field(registerFields[i]);
            Ui.hint(registerFields[i], paskaidrojumi[i]);
        }
        Ui.button(btnRegister, Ui.BLUE);
        dlgRegister.getRootPane().setDefaultButton(btnRegister);
        dlgRegister.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent e) {
                btnRegister.requestFocusInWindow();
            }
        });
    }

    // ===================================================================
    //  Dialogs: filmas informācija un atsauksmes
    // ===================================================================
    private void initMovie() {
        Ui.fit(dlgMovie, 940, 600, 3);
        Ui.title(lblTitleMovie, 38);
        Ui.title(lblZvaigznes, 30);
        Ui.line(pnlLineMovie);
        Ui.line(pnlLine2);
        Ui.title(lblNosaukums, 30);
        Ui.area(txtApraksts, 14);
        Ui.label(lblInfo, 13, true);
        Ui.button(btnRezervetMovie, Ui.ORANGE);
        Ui.button(btnPlans, Ui.TEAL);
        Ui.button(btnRakstit, Ui.BLUE);
        Ui.title(lblAtsauksmes, 24);
        Ui.scroll(scrollAtsauksmesMovie);
        pnlAtsauksmesMovie.setLayout(new BoxLayout(pnlAtsauksmesMovie, BoxLayout.Y_AXIS));
        pnlAtsauksmesMovie.setBackground(Color.WHITE);
        pnlAtsauksmesMovie.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
    }

    private void refreshMovie() {
        lblZvaigznes.setText(Ui.stars(film.vertejums()));
        lblPlakatsMovie.setIcon(Ui.poster(film.nosaukums(), 150, 225));
        lblNosaukums.setText(film.nosaukums());
        txtApraksts.setText(film.apraksts());
        txtApraksts.setCaretPosition(0);
        lblInfo.setText(DemoData.filmMeta(film));
        btnRezervetMovie.setEnabled(!user.guest());
        btnRakstit.setEnabled(!user.guest());
        loadReviews();
    }

    /** Parāda filmas atsauksmes (katra – atsevišķā rāmī). */
    private void loadReviews() {
        pnlAtsauksmesMovie.removeAll();
        java.util.List<DemoData.Review> list = DemoData.reviewsFor(film.id());
        if (list.isEmpty()) {
            JLabel tukss = new JLabel("Šai filmai vēl nav atsauksmju.");
            Ui.label(tukss, 14, false);
            pnlAtsauksmesMovie.add(tukss);
        }
        for (DemoData.Review r : list) {
            pnlAtsauksmesMovie.add(createReviewCard(r));
            pnlAtsauksmesMovie.add(Box.createVerticalStrut(8));
        }
        pnlAtsauksmesMovie.revalidate();
        pnlAtsauksmesMovie.repaint();
    }

    private JPanel createReviewCard(DemoData.Review r) {
        JPanel card = new JPanel(null);
        card.setBackground(Color.WHITE);
        card.setBorder(Ui.blueBorder(2));
        card.setPreferredSize(new Dimension(850, 88));
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 88));
        card.setAlignmentX(LEFT_ALIGNMENT);

        JLabel vards = new JLabel(r.lietotajs(), Ui.userIcon(26), JLabel.LEFT);
        Ui.label(vards, 15, true);
        vards.setBounds(10, 6, 210, 30);
        card.add(vards);

        JLabel zvaigznes = new JLabel(Ui.stars(r.vertejums()));
        Ui.title(zvaigznes, 18);
        zvaigznes.setBounds(224, 6, 130, 30);
        card.add(zvaigznes);

        JLabel laiks = new JLabel(r.laiks(), JLabel.RIGHT);
        Ui.label(laiks, 12, true);
        laiks.setBounds(590, 6, 230, 24);
        card.add(laiks);

        JTextArea teksts = new JTextArea(r.teksts());
        Ui.area(teksts, 13);
        teksts.setEditable(false);
        teksts.setFocusable(false);
        teksts.setBounds(12, 38, 800, 44);
        card.add(teksts);
        return card;
    }

    // ===================================================================
    //  Dialogs: seansu plānošana
    // ===================================================================
    private void initSessions() {
        Ui.fit(dlgSessions, 640, 350, 3);
        Ui.title(lblTitleSess, 24);
        Ui.scroll(scrollSeansiSess);
        Ui.table(tblSeansiSess, false);
        tblSeansiSess.setRowHeight(36);
        tblSeansiSess.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Ui.button(btnIzveleties, Ui.ORANGE);
        Ui.button(btnAizvert, Ui.BLUE);
    }

    private void refreshSessions() {
        lblPlakatsSess.setIcon(Ui.poster(film.nosaukums(), 150, 225));
        DefaultTableModel modelis = (DefaultTableModel) tblSeansiSess.getModel();
        modelis.setRowCount(0);
        sessions = DemoData.sessionsFor(film.id());
        for (DemoData.Seanss s : sessions) {
            modelis.addRow(new Object[]{s.diena(), s.laiks(), s.zale()});
        }
        modelis.addRow(new Object[]{"-", "-", "-"});
        tblSeansiSess.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblSeansiSess.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblSeansiSess.getColumnModel().getColumn(2).setPreferredWidth(120);
        tblSeansiSess.setRowSelectionInterval(0, 0);
    }

    // ===================================================================
    //  Dialogs: vietu rezervēšana
    // ===================================================================
    private void initSeats() {
        Ui.fit(dlgSeats, 780, 640, 3);
        Ui.title(lblTitleSeat, 26);
        Ui.label(lblFilmaSeat, 20, false);
        for (JLabel l : new JLabel[]{lblBrivs, lblAiznemts, lblIzveleta, lblVietas, lblIemaksa}) {
            Ui.label(l, 14, false);
        }
        pnlVietas.setLayout(null);
        pnlVietas.setOpaque(false);
        Ui.button(btnRezervetSeat, Ui.ORANGE);
    }

    private void refreshSeats() {
        lblFilmaSeat.setText("filmu: " + film.nosaukums() + "   (" + seanss.diena() + " " + seanss.laiks() + ", " + seanss.zale() + ")");
        pnlVietas.removeAll();
        seats.clear();
        buildSeats();
        updateInfo();
        pnlVietas.revalidate();
        pnlVietas.repaint();
    }

    /**
     * Izveido sēdvietu pogas pēc skices: kreisais un labais bloks (3 vietas platumā, 8 rindas)
     * un vidējais bloks (10 vietas platumā, 8 rindas, viena rinda zemāk).
     */
    private void buildSeats() {
        java.util.Set<String> aiznemtas = DemoData.occupiedSeats(seanss.id());
        final int w = 41, h = 34, stepX = 43, stepY = 40, gap = 14;
        for (int rinda = 0; rinda < 9; rinda++) {
            for (int bloks = 0; bloks < 3; bloks++) {
                boolean vidus = bloks == 1;
                if (!vidus && rinda > 7) continue;      // sāni: rindas 0..7
                if (vidus && rinda < 1) continue;       // vidus: rindas 1..8
                int cols = vidus ? 10 : 3;
                int startX = bloks == 0 ? 0 : (vidus ? 3 * stepX + gap : 3 * stepX + gap + 10 * stepX + gap);
                int startVieta = bloks == 0 ? 1 : (vidus ? 4 : 14);
                for (int c = 0; c < cols; c++) {
                    String nosaukums = (rinda + 1) + "-" + (startVieta + c);
                    final JToggleButton poga = new JToggleButton();
                    poga.setName(nosaukums);
                    poga.setBounds(startX + c * stepX, rinda * stepY, w, h);
                    poga.setFocusPainted(false);
                    poga.setOpaque(true);
                    poga.setContentAreaFilled(true);
                    poga.setToolTipText((rinda + 1) + ". rinda, " + (startVieta + c) + ". vieta");
                    if (aiznemtas.contains(nosaukums)) {
                        poga.setBackground(Ui.RED);
                        poga.setBorder(BorderFactory.createLineBorder(Ui.RED.darker(), 2, true));
                        poga.setEnabled(false);
                    } else {
                        stilsBrivs(poga);
                        poga.addActionListener(e -> {
                            if (poga.isSelected()) stilsIzvelets(poga); else stilsBrivs(poga);
                            updateInfo();
                        });
                    }
                    seats.add(poga);
                    pnlVietas.add(poga);
                }
            }
        }
    }

    private void stilsBrivs(JToggleButton b) {
        b.setBackground(Ui.BLUE);
        b.setBorder(BorderFactory.createLineBorder(new Color(0x1F3B5C), 2, true));
    }

    private void stilsIzvelets(JToggleButton b) {
        b.setBackground(Ui.ORANGE);
        b.setBorder(BorderFactory.createLineBorder(Ui.ORANGE.darker().darker(), 2, true));
    }

    private java.util.List<String> izveletasVietas() {
        java.util.List<String> r = new ArrayList<>();
        for (JToggleButton b : seats) {
            if (b.isSelected() && b.isEnabled()) r.add(b.getName());
        }
        return r;
    }

    private void updateInfo() {
        java.util.List<String> r = izveletasVietas();
        lblVietas.setText("Izvēlētās vietas (rinda-vieta): " + (r.isEmpty() ? "–" : String.join(", ", r)));
        lblIemaksa.setText("Iemaksa: " + (r.isEmpty() ? 1 : r.size()) + ",00 € (1,00 € par katru rezervēto vietu)");
    }

    // ===================================================================
    //  Dialogs: profils
    // ===================================================================
    private void initProfile() {
        Ui.fit(dlgProfile, 660, 500, 3);
        Ui.title(lblTitleProf, 26);
        lblAvatars.setIcon(Ui.userIcon(140));
        for (JLabel l : new JLabel[]{lblVards, lblStatuss, lblEpasts}) {
            Ui.label(l, 19, false);
        }
        Ui.line(pnlLineProf);
        Ui.title(lblSaraksts, 18);
        Ui.scroll(scrollPirkumi);
        Ui.table(tblPirkumi, false);
        tblPirkumi.setRowHeight(32);
        Ui.button(btnRezervacijas, Ui.BLUE);
        Ui.button(btnIziet, Ui.RED);
    }

    private void refreshProfile() {
        lblVards.setText("Vārds: " + user.vards());
        lblStatuss.setText("Statuss: " + user.statuss());
        lblEpasts.setText("E-pasts: " + user.epasts());
        DefaultTableModel modelis = (DefaultTableModel) tblPirkumi.getModel();
        modelis.setRowCount(0);
        for (DemoData.Purchase p : DemoData.purchasesFor(user)) {
            modelis.addRow(new Object[]{p.filma(), p.laiks()});
        }
        tblPirkumi.getColumnModel().getColumn(0).setPreferredWidth(400);
        tblPirkumi.getColumnModel().getColumn(1).setPreferredWidth(180);
        btnRezervacijas.setEnabled(!user.guest());
    }

    // ===================================================================
    //  Dialogs: manas rezervācijas
    // ===================================================================
    private void initMyRes() {
        Ui.fit(dlgMyRes, 740, 410, 3);
        Ui.title(lblTitleMyRes, 26);
        Ui.scroll(scrollMyRes);
        Ui.table(tblMyRes, true);
        tblMyRes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Ui.button(btnAtceltMyRes, Ui.RED);
        Ui.button(btnAtpakal, Ui.BLUE);
        Ui.label(lblPiezime, 13, false);
    }

    private void refreshMyRes() {
        DefaultTableModel modelis = (DefaultTableModel) tblMyRes.getModel();
        modelis.setRowCount(0);
        for (DemoData.Reservation r : DemoData.RESERVATIONS) {
            modelis.addRow(new Object[]{r.filma, r.datums, r.laiks, r.vieta, "1,00 €", r.statuss});
        }
        int[] platumi = {130, 110, 60, 150, 80, 80};
        for (int i = 0; i < platumi.length; i++) {
            tblMyRes.getColumnModel().getColumn(i).setPreferredWidth(platumi[i]);
        }
    }

    // ===================================================================
    //  Dialogs: atsauksmes rakstīšana
    // ===================================================================
    private void initReview() {
        Ui.fit(dlgReview, 540, 360, 3);
        Ui.title(lblTitleRev, 24);
        Ui.label(lblFilmaRev, 16, true);
        Ui.label(lblVertejums, 15, false);
        Ui.combo(cmbVertejums);
        Ui.scroll(scrollTeksts);
        txtTeksts.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        txtTeksts.setForeground(Ui.TEXT);
        Ui.button(btnPublicet, Ui.BLUE);
        Ui.button(btnAtceltRev, Ui.RED);
    }

    private void refreshReview() {
        lblFilmaRev.setText("Filma: " + film.nosaukums());
        txtTeksts.setText("");
        cmbVertejums.setSelectedIndex(0);
    }

    // ===================================================================
    //  Dialogs: administrēšana (5 cilnes)
    // ===================================================================
    private DefaultTableModel modelisFilmas, modelisSeansi, modelisAtsauksmes, modelisLietotaji, modelisRezervacijas;
    private TableRowSorter<DefaultTableModel> sorterAtsauksmes, sorterRezervacijas;

    private void notiritFilmasLaukus() {
        txtFNosaukums.setText("");
        txtFZanrs.setText("");
        txtFIlgums.setText("");
        txtFVecums.setText("");
        txtFPlakats.setText("");
        txtFTreileris.setText("");
        txtFApraksts.setText("");
    }

    private void iestatitPlatumus(JTable t, int... platumi) {
        for (int i = 0; i < platumi.length; i++) {
            t.getColumnModel().getColumn(i).setPreferredWidth(platumi[i]);
        }
    }

    private void mainitStatusu(String statuss) {
        int rinda = tblLietotaji.getSelectedRow();
        if (rinda < 0) {
            kluda(dlgAdmin, "Izvēlieties lietotāju tabulā!");
            return;
        }
        modelisLietotaji.setValueAt(statuss, rinda, 5);
        info(dlgAdmin, "Lietotāja konts ir veiksmīgi atjaunināts!");
    }

    private void initAdmin() {
        Ui.fit(dlgAdmin, 940, 620, 3);
        Ui.title(lblTitleAdm, 38);
        Ui.title(lblAdmins, 18);
        lblAdminaIkona.setIcon(Ui.userIcon(36));
        Ui.line(pnlLineAdm);
        tabs.setFont(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.BOLD, 14));
        tabs.setForeground(Ui.TEXT);

        // virsraksti, uzraksti un ievades lauki
        for (javax.swing.JLabel l : new javax.swing.JLabel[]{lblFilmuPark, lblSeansuPark, lblLietPark}) {
            Ui.title(l, 20);
        }
        javax.swing.JLabel[] teksti = {lblFNosaukums, lblFZanrs, lblFIlgums, lblFVecums, lblFPlakats, lblFTreileris, lblFApraksts,
            lblSFilma, lblSZale, lblSDatums, lblSLaiks, lblSCena, lblAFiltrs, lblRFilma, lblRDatums};
        for (javax.swing.JLabel l : teksti) {
            Ui.label(l, 14, false);
        }
        for (javax.swing.JLabel l : new javax.swing.JLabel[]{lblFPiezime, lblSPiezime, lblAPiezime, lblLPiezime, lblRPiezime}) {
            Ui.label(l, 12, false);
            l.setForeground(Ui.HINT);
        }
        javax.swing.text.JTextComponent[] lauki = {txtFNosaukums, txtFZanrs, txtFIlgums, txtFVecums, txtFPlakats, txtFTreileris,
            txtSDatums, txtSLaiks, txtSCena, txtAFiltrs, txtRDatums};
        for (javax.swing.text.JTextComponent t : lauki) {
            Ui.field(t);
        }
        Ui.area(txtFApraksts, 14);
        txtFApraksts.setOpaque(true);
        txtFApraksts.setBackground(java.awt.Color.WHITE);
        Ui.scroll(scrollFApraksts);
        for (javax.swing.JComboBox<?> c : new javax.swing.JComboBox<?>[]{cmbSFilma, cmbSZale, cmbRFilma}) {
            Ui.combo(c);
        }
        for (javax.swing.JButton b : new javax.swing.JButton[]{btnPievienot, btnIzveidot, btnMeklet, btnFiltret}) {
            Ui.button(b, Ui.BLUE);
        }
        for (javax.swing.JButton b : new javax.swing.JButton[]{btnRediget, btnMainit, btnBlokat}) {
            Ui.button(b, Ui.TEAL);
        }
        btnAtblokat.setText("Atbloķēt");
        Ui.button(btnAtblokat, Ui.TEAL);
        for (javax.swing.JButton b : new javax.swing.JButton[]{btnDzestFilmu, btnAtceltSeansu, btnDzestAtsauksmi, btnDzestLietotaju, btnAtceltRezervaciju}) {
            Ui.button(b, Ui.RED);
        }

        for (javax.swing.JPanel p : new javax.swing.JPanel[]{pnlFilmasAdm, pnlSeansi, pnlAtsAdm, pnlLietotaji, pnlRezervacijas}) {
            p.setBackground(java.awt.Color.WHITE);
        }

        // tabulas
        for (JScrollPane s : new JScrollPane[]{scrollFilmasAdm, scrollSeansiAdm, scrollAtsAdm, scrollLietotaji, scrollRezAdm}) {
            Ui.scroll(s);
        }
        for (JTable t : new JTable[]{tblFilmas, tblSeansiAdm, tblAtsauksmes, tblLietotaji, tblRezAdm}) {
            Ui.table(t, true);
            t.setRowHeight(30);
            t.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        }
        iestatitPlatumus(tblFilmas, 170, 100, 80, 70);
        iestatitPlatumus(tblSeansiAdm, 140, 80, 100, 70, 60);
        iestatitPlatumus(tblAtsauksmes, 100, 110, 90, 400, 100);
        iestatitPlatumus(tblLietotaji, 40, 100, 110, 140, 280, 100);
        iestatitPlatumus(tblRezAdm, 50, 110, 150, 100, 60, 150, 100);
        modelisFilmas = (DefaultTableModel) tblFilmas.getModel();
        modelisSeansi = (DefaultTableModel) tblSeansiAdm.getModel();
        modelisAtsauksmes = (DefaultTableModel) tblAtsauksmes.getModel();
        modelisLietotaji = (DefaultTableModel) tblLietotaji.getModel();
        modelisRezervacijas = (DefaultTableModel) tblRezAdm.getModel();

        for (DemoData.Film f : DemoData.FILMS) {
            modelisFilmas.addRow(new Object[]{f.nosaukums(), f.zanrs(), f.ilgums() + " min", f.vecums() + "+"});
        }
        modelisSeansi.addRow(new Object[]{"Flow", "1. zāle", "03.10.2026", "19:35", "7.50"});
        modelisSeansi.addRow(new Object[]{"2012", "2. zāle", "03.10.2026", "21:30", "7.00"});
        modelisSeansi.addRow(new Object[]{"Flow", "1. zāle", "04.10.2026", "11:15", "6.50"});
        modelisSeansi.addRow(new Object[]{"Harry Potter", "3. zāle", "05.10.2026", "10:35", "6.50"});
        modelisAtsauksmes.addRow(new Object[]{"Lietotajs", "Flow", "5", "Interesanta un forša multfilma!", "21.09.2026"});
        modelisAtsauksmes.addRow(new Object[]{"anna21", "2012", "4", "Spēcīgi efekti, bet garš sižets.", "22.09.2026"});
        modelisAtsauksmes.addRow(new Object[]{"user77", "Flow", "1", "(aizskarošs saturs)", "24.09.2026"});
        modelisAtsauksmes.addRow(new Object[]{"marta", "Transformers", "3", "Vidēja filma.", "25.09.2026"});
        modelisLietotaji.addRow(new Object[]{"1", "Jānis", "Bērziņš", "janis1", "janis@inbox.lv", "aktīvs"});
        modelisLietotaji.addRow(new Object[]{"2", "Anna", "Kalniņa", "anna21", "anna21@inbox.lv", "aktīvs"});
        modelisLietotaji.addRow(new Object[]{"3", "Pēteris", "Ozols", "user77", "peteris@gmail.com", "bloķēts"});
        modelisLietotaji.addRow(new Object[]{"4", "Marta", "Liepa", "marta", "marta@inbox.lv", "aktīvs"});
        for (DemoData.Reservation r : DemoData.RESERVATIONS) {
            modelisRezervacijas.addRow(new Object[]{String.valueOf(r.id), "Lietotajs", r.filma, r.datums, r.laiks, r.vieta, r.statuss});
        }
        sorterAtsauksmes = new TableRowSorter<>(modelisAtsauksmes);
        tblAtsauksmes.setRowSorter(sorterAtsauksmes);
        sorterRezervacijas = new TableRowSorter<>(modelisRezervacijas);
        tblRezAdm.setRowSorter(sorterRezervacijas);

        // izvēlētās filmas dati parādās ievades laukos
        tblFilmas.getSelectionModel().addListSelectionListener(e -> {
            int r = tblFilmas.getSelectedRow();
            if (!e.getValueIsAdjusting() && r >= 0) {
                txtFNosaukums.setText(String.valueOf(modelisFilmas.getValueAt(r, 0)));
                txtFZanrs.setText(String.valueOf(modelisFilmas.getValueAt(r, 1)));
                txtFIlgums.setText(String.valueOf(modelisFilmas.getValueAt(r, 2)).replace(" min", ""));
                txtFVecums.setText(String.valueOf(modelisFilmas.getValueAt(r, 3)));
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnAizvert;
    private javax.swing.JButton btnAtblokat;
    private javax.swing.JButton btnAtceltMyRes;
    private javax.swing.JButton btnAtceltRev;
    private javax.swing.JButton btnAtceltRezervaciju;
    private javax.swing.JButton btnAtceltSeansu;
    private javax.swing.JButton btnAtpakal;
    private javax.swing.JButton btnBlokat;
    private javax.swing.JButton btnDzestAtsauksmi;
    private javax.swing.JButton btnDzestFilmu;
    private javax.swing.JButton btnDzestLietotaju;
    private javax.swing.JButton btnFiltret;
    private javax.swing.JButton btnGuest;
    private javax.swing.JButton btnIziet;
    private javax.swing.JButton btnIzveidot;
    private javax.swing.JButton btnIzveleties;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnMainit;
    private javax.swing.JButton btnMeklet;
    private javax.swing.JButton btnOpenRegister;
    private javax.swing.JButton btnPievienot;
    private javax.swing.JButton btnPlans;
    private javax.swing.JButton btnPublicet;
    private javax.swing.JButton btnRakstit;
    private javax.swing.JButton btnRediget;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnRezervacijas;
    private javax.swing.JButton btnRezervetMovie;
    private javax.swing.JButton btnRezervetSeat;
    private javax.swing.JButton btnUser;
    private javax.swing.JComboBox cmbRFilma;
    private javax.swing.JComboBox cmbSFilma;
    private javax.swing.JComboBox cmbSZale;
    private javax.swing.JComboBox cmbVertejums;
    private javax.swing.JDialog dlgAdmin;
    private javax.swing.JDialog dlgLogin;
    private javax.swing.JDialog dlgMovie;
    private javax.swing.JDialog dlgMyRes;
    private javax.swing.JDialog dlgProfile;
    private javax.swing.JDialog dlgRegister;
    private javax.swing.JDialog dlgReview;
    private javax.swing.JDialog dlgSeats;
    private javax.swing.JDialog dlgSessions;
    private javax.swing.JLabel lblAFiltrs;
    private javax.swing.JLabel lblAPiezime;
    private javax.swing.JLabel lblAdminaIkona;
    private javax.swing.JLabel lblAdmins;
    private javax.swing.JLabel lblAiznemts;
    private javax.swing.JLabel lblAtsauksmes;
    private javax.swing.JLabel lblAvatars;
    private javax.swing.JLabel lblBrivs;
    private javax.swing.JLabel lblEpasts;
    private javax.swing.JLabel lblFApraksts;
    private javax.swing.JLabel lblFIlgums;
    private javax.swing.JLabel lblFNosaukums;
    private javax.swing.JLabel lblFPiezime;
    private javax.swing.JLabel lblFPlakats;
    private javax.swing.JLabel lblFTreileris;
    private javax.swing.JLabel lblFVecums;
    private javax.swing.JLabel lblFZanrs;
    private javax.swing.JLabel lblFilmaRev;
    private javax.swing.JLabel lblFilmaSeat;
    private javax.swing.JLabel lblFilmaSeat1;
    private javax.swing.JLabel lblFilmuPark;
    private javax.swing.JLabel lblIemaksa;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblIzveleta;
    private javax.swing.JLabel lblLPiezime;
    private javax.swing.JLabel lblLietPark;
    private javax.swing.JLabel lblMeklet;
    private javax.swing.JLabel lblNosaukums;
    private javax.swing.JLabel lblPiezime;
    private javax.swing.JLabel lblPlakatsMovie;
    private javax.swing.JLabel lblPlakatsSess;
    private javax.swing.JLabel lblRDatums;
    private javax.swing.JLabel lblRFilma;
    private javax.swing.JLabel lblRPiezime;
    private javax.swing.JLabel lblSCena;
    private javax.swing.JLabel lblSDatums;
    private javax.swing.JLabel lblSFilma;
    private javax.swing.JLabel lblSLaiks;
    private javax.swing.JLabel lblSPiezime;
    private javax.swing.JLabel lblSZale;
    private javax.swing.JLabel lblSaraksts;
    private javax.swing.JLabel lblSeansuPark;
    private javax.swing.JLabel lblStatuss;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleAdm;
    private javax.swing.JLabel lblTitleLogin;
    private javax.swing.JLabel lblTitleMovie;
    private javax.swing.JLabel lblTitleMyRes;
    private javax.swing.JLabel lblTitleProf;
    private javax.swing.JLabel lblTitleReg;
    private javax.swing.JLabel lblTitleRev;
    private javax.swing.JLabel lblTitleSeat;
    private javax.swing.JLabel lblTitleSeat1;
    private javax.swing.JLabel lblTitleSess;
    private javax.swing.JLabel lblVards;
    private javax.swing.JLabel lblVertejums;
    private javax.swing.JLabel lblVietas;
    private javax.swing.JLabel lblZvaigznes;
    private javax.swing.JPanel pnlAtsAdm;
    private javax.swing.JPanel pnlAtsauksmesMovie;
    private javax.swing.JPanel pnlFilmas;
    private javax.swing.JPanel pnlFilmasAdm;
    private javax.swing.JPanel pnlLietotaji;
    private javax.swing.JPanel pnlLine;
    private javax.swing.JPanel pnlLine2;
    private javax.swing.JPanel pnlLineAdm;
    private javax.swing.JPanel pnlLineMovie;
    private javax.swing.JPanel pnlLineProf;
    private javax.swing.JPanel pnlRezervacijas;
    private javax.swing.JPanel pnlSeansi;
    private javax.swing.JPanel pnlVietas;
    private javax.swing.JScrollPane scrollAtsAdm;
    private javax.swing.JScrollPane scrollAtsauksmesMovie;
    private javax.swing.JScrollPane scrollFApraksts;
    private javax.swing.JScrollPane scrollFilmas;
    private javax.swing.JScrollPane scrollFilmasAdm;
    private javax.swing.JScrollPane scrollLietotaji;
    private javax.swing.JScrollPane scrollMyRes;
    private javax.swing.JScrollPane scrollPirkumi;
    private javax.swing.JScrollPane scrollRezAdm;
    private javax.swing.JScrollPane scrollSeansiAdm;
    private javax.swing.JScrollPane scrollSeansiSess;
    private javax.swing.JScrollPane scrollTeksts;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblAtsauksmes;
    private javax.swing.JTable tblFilmas;
    private javax.swing.JTable tblLietotaji;
    private javax.swing.JTable tblMyRes;
    private javax.swing.JTable tblPirkumi;
    private javax.swing.JTable tblRezAdm;
    private javax.swing.JTable tblSeansiAdm;
    private javax.swing.JTable tblSeansiSess;
    private javax.swing.JTextField txtAFiltrs;
    private javax.swing.JTextArea txtApraksts;
    private javax.swing.JTextField txtEpasts;
    private javax.swing.JTextArea txtFApraksts;
    private javax.swing.JTextField txtFIlgums;
    private javax.swing.JTextField txtFNosaukums;
    private javax.swing.JTextField txtFPlakats;
    private javax.swing.JTextField txtFTreileris;
    private javax.swing.JTextField txtFVecums;
    private javax.swing.JTextField txtFZanrs;
    private javax.swing.JPasswordField txtLoginPass;
    private javax.swing.JTextField txtLoginUser;
    private javax.swing.JTextField txtMeklet;
    private javax.swing.JTextField txtRDatums;
    private javax.swing.JPasswordField txtRegPass;
    private javax.swing.JPasswordField txtRegPass2;
    private javax.swing.JTextField txtRegUser;
    private javax.swing.JTextField txtSCena;
    private javax.swing.JTextField txtSDatums;
    private javax.swing.JTextField txtSLaiks;
    private javax.swing.JTextArea txtTeksts;
    private javax.swing.JTextField txtUzvards;
    private javax.swing.JTextField txtVards;
    // End of variables declaration//GEN-END:variables

    // ===================================================================
    //  Palīgklases (iekļautas šajā failā, lai viss GUI būtu vienā failā)
    // ===================================================================

    /**
     * Demonstrācijas dati saskarnes formu pārbaudei.
     * Vēlāk šo klasi aizstās DAO slānis, kas strādā ar Apache Derby datu bāzi.
     */
    static final class DemoData {

        private DemoData() { }

        // ---------- datu struktūras ----------
        public record User(String lietotajvards, String vards, String statuss, String epasts, boolean admin, boolean guest) { }

        public record Film(int id, String nosaukums, String zanrs, int ilgums, int vecums, String apraksts, int vertejums) { }

        public record Seanss(int id, int filmId, String diena, String laiks, String zale) { }

        public record Review(String lietotajs, int vertejums, String teksts, String laiks) { }

        public record Purchase(String filma, String laiks) { }

        public static final class Reservation {
            public final int id;
            public final String filma, datums, laiks, vieta;
            public final int minutesToStart;
            public String statuss;

            public Reservation(int id, String filma, String datums, String laiks, String vieta, int minutesToStart, String statuss) {
                this.id = id; this.filma = filma; this.datums = datums; this.laiks = laiks;
                this.vieta = vieta; this.minutesToStart = minutesToStart; this.statuss = statuss;
            }
        }

        public static final User GUEST = new User("viesis", "Viesis", "viesis", "-", false, true);

        // ---------- lietotāji ----------
        private static final Map<String, String> PASSWORDS = new LinkedHashMap<>();
        private static final Map<String, User> USERS = new LinkedHashMap<>();

        static {
            USERS.put("lietotajs", new User("lietotajs", "Lietotajs", "lietotājs", "lietotais112@inbox.lv", false, false));
            PASSWORDS.put("lietotajs", "parole");
            USERS.put("admin", new User("admin", "Administrators", "administrators", "admin@kino.lv", true, false));
            PASSWORDS.put("admin", "admin");
        }

        /** @return lietotājs vai null, ja dati nepareizi */
        public static User login(String lietotajvards, String parole) {
            String p = PASSWORDS.get(lietotajvards);
            return (p != null && p.equals(parole)) ? USERS.get(lietotajvards) : null;
        }

        /** @return false, ja lietotājvārds jau aizņemts */
        public static boolean register(String vards, String uzvards, String lietotajvards, String parole, String epasts) {
            if (USERS.containsKey(lietotajvards)) {
                return false;
            }
            USERS.put(lietotajvards, new User(lietotajvards, vards, "lietotājs", epasts, false, false));
            PASSWORDS.put(lietotajvards, parole);
            return true;
        }

        // ---------- filmas ----------
        public static final List<Film> FILMS = List.of(
            new Film(1, "2012", "Drāma", 158, 12,
                "2009. gadā amerikāņu ģeologs Adrians Helmslijs apmeklēja savu draugu Satnamu Indijā, kurš bija atklājis, ka Saules uzliesmojuma radīta neitrīno plūsma strauji silda Zemes kodolu. Adrians informēja prezidenta administrācijas vadītāju Karlu Anhauzeru un pašu ASV prezidentu Tomasu Vilsonu, ka šī sildīšana izraisīs notikumu ķēdi, kas novedīs pie globālas kataklizmas.",
                4),
            new Film(2, "Flow", "Animācija", 85, 6,
                "Īsspalvains, tumši pelēks kaķis dzīvo mežā, mājas augšējā stāvā, kurā atrodas mākslinieka darbnīca; ap māju ir izvietotas kaķa statujas dažādās pozās. Kādu dienu mežā pie upes kaķis nejauši uzduras piecu suņu grupai, kas makšķerē. Kad divi no tiem sāk strīdēties par nokertajām zivīm, kaķis nozog zivi un aizbēg no suņiem. Pēkšņi viņiem pretī metas briežu bars, kam seko milzīga ūdens straume, kas pārklāj zemi.",
                5),
            new Film(3, "Transformers", "Fantastika", 144, 12,
                "Divu citplanētiešu robotu rasu – Autobotu un Decepticonu – konflikts nonāk uz Zemes. Pusaudzis Sems Vitviks nejauši kļūst par atslēgu karā par spēcīgu artefaktu, kas var izšķirt Visuma likteni.",
                3),
            new Film(4, "Harry Potter", "Fantāzija", 152, 12,
                "Zēns Harijs Poters uzzina, ka ir burvis, un sāk mācības Cūkkārpas Burvju un Raganu skolā, kur viņu gaida draudzība, pārbaudījumi un cīņa ar tumšo burvi, kurš nogalināja viņa vecākus.",
                5),
            new Film(5, "The Shawshank Redemption", "Drāma", 142, 16,
                "Bankieris Endijs Dufreins tiek notiesāts par sievas un viņas mīļākā slepkavību un nonāk Šoušenkas cietumā, kur gadu desmitiem ilgā draudzība ar Redu un neatlaidīga cerība palīdz viņam saglabāt cilvēcību.",
                5)
        );

        public static String filmMeta(Film f) {
            return "Žanrs: " + f.zanrs() + "   |   Ilgums: " + f.ilgums() + " min   |   Vecums: " + f.vecums() + "+";
        }

        // ---------- seansi ----------
        public static List<Seanss> sessionsFor(int filmId) {
            List<Seanss> r = new ArrayList<>();
            r.add(new Seanss(filmId * 10 + 1, filmId, "Otr.", "21:55-23:20", "1. zāle"));
            r.add(new Seanss(filmId * 10 + 2, filmId, "Treš.", "09:05-10:30", "2. zāle"));
            r.add(new Seanss(filmId * 10 + 3, filmId, "Piekt.", "19:35-21:00", "1. zāle"));
            r.add(new Seanss(filmId * 10 + 4, filmId, "Sun.", "11:15-12:40", "3. zāle"));
            return r;
        }

        /** Aizņemtās vietas seansam, formātā "rinda-vieta" (numerācija no 1). */
        public static Set<String> occupiedSeats(int seanssId) {
            Set<String> s = new TreeSet<>();
            int seed = seanssId * 7;
            for (int i = 0; i < 22; i++) {
                int row = (seed + i * 5) % 9 + 1;
                int col = (seed * 3 + i * 7) % 16 + 1;
                s.add(row + "-" + col);
            }
            return s;
        }

        // ---------- atsauksmes ----------
        private static final Map<Integer, List<Review>> REVIEWS = new LinkedHashMap<>();

        static {
            REVIEWS.put(2, new ArrayList<>(List.of(
                new Review("Lietotajs", 5, "Loti interesanta un forša multfilma! Viss ir skaidrs pat bez vārdiem, un kaķis ir ļoti mīlīgs. Lūdzu, veidojiet vēl tik jaukas un brīnišķīgas multfilmas.", "10:40 21.09.2026"),
                new Review("anna21", 4, "Skaists vizuālais risinājums un pārdomāts stāsts.", "18:05 22.09.2026"))));
            REVIEWS.put(1, new ArrayList<>(List.of(
                new Review("marta", 3, "Spēcīgi efekti, bet sižets mazliet par garu.", "20:15 23.09.2026"))));
        }

        public static List<Review> reviewsFor(int filmId) {
            return REVIEWS.computeIfAbsent(filmId, k -> new ArrayList<>());
        }

        public static void addReview(int filmId, Review r) {
            reviewsFor(filmId).add(0, r);
        }

        // ---------- pirkumi un rezervācijas ----------
        public static List<Purchase> purchasesFor(User u) {
            List<Purchase> r = new ArrayList<>();
            if (u == null || u.guest()) return r;
            r.add(new Purchase("Flow", "19:35-20:00"));
            r.add(new Purchase("2012", "08:22-11:00"));
            r.add(new Purchase("Transformers", "21:30-00:00"));
            r.add(new Purchase("Harry Potter", "10:35-12:45"));
            r.add(new Purchase("The Shawshank Redemption", "18:00-20:22"));
            return r;
        }

        public static final List<Reservation> RESERVATIONS = new ArrayList<>(List.of(
            new Reservation(101, "Flow", "03.10.2026", "19:35", "5. rinda, 8. vieta", 180, "aktīva"),
            new Reservation(102, "2012", "03.10.2026", "21:30", "3. rinda, 4. vieta", 45, "aktīva"),
            new Reservation(103, "Harry Potter", "05.10.2026", "10:35", "2. rinda, 6. vieta", 10, "aktīva")
        ));

        private static int nextReservationId = 104;

        public static Reservation addReservation(String filma, String diena, String laiks, String vieta) {
            Reservation r = new Reservation(nextReservationId++, filma, diena, laiks.substring(0, 5), vieta, 600, "aktīva");
            RESERVATIONS.add(r);
            return r;
        }
    }

    /**
     * Palīgklase vienota izskata (krāsas, fonti, rāmji) un nelielu ikonu veidošanai.
     * Forma tiek izkārtota ar NetBeans GUI Builder, bet izskata detaļas (krāsas, fonti,
     * ikonas, ievades lauku paskaidrojošais teksts) tiek uzstādītas šeit.
     */
    static final class Ui {

        private Ui() { }

        public static final Color BLUE = new Color(0x4F81BD);
        public static final Color DARK = new Color(0x385D8A);
        public static final Color TEXT = new Color(0x3B6EA5);
        public static final Color TEAL = new Color(0x4BACC6);
        public static final Color ORANGE = new Color(0xF79646);
        public static final Color RED = new Color(0xC0504D);
        public static final Color GOLD = new Color(0xF2B01E);
        public static final Color HINT = new Color(0x7F9DBF);

        private static final String FONT = Font.SANS_SERIF;

        // ---------------------------------------------------------------- logi
        /**
         * Uzstāda loga SATURA laukuma izmēru (bez virsraksta joslas un rāmja), lai visas komponentes
         * ietilptu, ieliek zilu rāmi un novieto logu ekrāna centrā.
         */
        public static void fit(RootPaneContainer w, int width, int height, int borderWidth) {
            JComponent saturs = (JComponent) w.getContentPane();
            saturs.setBackground(Color.WHITE);
            saturs.setBorder(BorderFactory.createLineBorder(BLUE, borderWidth));
            saturs.setPreferredSize(new Dimension(width, height));
            ((Window) w).pack();
            ((Window) w).setLocationRelativeTo(null);
        }

        // ------------------------------------------------------------ komponentes
        public static void title(JLabel l, int size) {
            l.setFont(new Font(FONT, Font.BOLD, size));
            l.setForeground(BLUE);
        }

        public static void label(JLabel l, int size, boolean bold) {
            l.setFont(new Font(FONT, bold ? Font.BOLD : Font.PLAIN, size));
            l.setForeground(TEXT);
        }

        public static void line(JPanel p) {
            p.setBackground(BLUE);
        }

        public static void field(JTextComponent t) {
            t.setFont(new Font(FONT, Font.PLAIN, 15));
            t.setForeground(TEXT);
            t.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(BLUE, 2), BorderFactory.createEmptyBorder(2, 8, 2, 8)));
        }

        public static void button(JButton b, Color background) {
            b.setBackground(background);
            b.setForeground(Color.WHITE);
            b.setFont(new Font(FONT, Font.BOLD, 13));
            b.setFocusPainted(false);
            b.setOpaque(true);
            b.setContentAreaFilled(true);
            b.setBorder(BorderFactory.createLineBorder(background.darker(), 2));
            b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        public static void flatButton(JButton b, int size) {
            b.setFont(new Font(FONT, Font.BOLD, size));
            b.setForeground(TEXT);
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
            b.setFocusPainted(false);
            b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        public static void area(JTextArea a, int size) {
            a.setFont(new Font(FONT, Font.PLAIN, size));
            a.setForeground(TEXT);
            a.setOpaque(false);
            a.setLineWrap(true);
            a.setWrapStyleWord(true);
        }

        public static void scroll(JScrollPane s) {
            s.setBorder(BorderFactory.createLineBorder(BLUE, 2));
            s.getViewport().setBackground(Color.WHITE);
            s.getVerticalScrollBar().setUnitIncrement(16);
        }

        public static void combo(JComboBox<?> c) {
            c.setFont(new Font(FONT, Font.PLAIN, 14));
            c.setForeground(TEXT);
            c.setBackground(Color.WHITE);
        }

        // --------------------------------------------------------------- tabulas
        /** Tabula ar mainīgām zilām/ciāna rindām (kā skicēs). */
        public static void table(JTable t, boolean showHeader) {
            t.setRowHeight(34);
            t.setFont(new Font(FONT, Font.BOLD, 14));
            t.setShowGrid(false);
            t.setIntercellSpacing(new Dimension(0, 0));
            t.setFillsViewportHeight(true);
            t.setSelectionBackground(DARK);
            t.setSelectionForeground(Color.WHITE);
            DefaultTableCellRenderer r = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable tbl, Object v, boolean sel, boolean foc, int row, int col) {
                    super.getTableCellRendererComponent(tbl, v, sel, foc, row, col);
                    setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
                    setForeground(Color.WHITE);
                    setBackground(sel ? DARK : (row % 2 == 0 ? BLUE : TEAL));
                    return this;
                }
            };
            t.setDefaultRenderer(Object.class, r);
            t.setDefaultRenderer(String.class, r);
            if (showHeader) {
                t.getTableHeader().setReorderingAllowed(false);
                t.getTableHeader().setFont(new Font(FONT, Font.BOLD, 13));
                t.getTableHeader().setBackground(DARK);
                t.getTableHeader().setForeground(Color.WHITE);
                t.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
                    @Override
                    public Component getTableCellRendererComponent(JTable tbl, Object v, boolean sel, boolean foc, int row, int col) {
                        super.getTableCellRendererComponent(tbl, v, false, false, row, col);
                        setBackground(DARK);
                        setForeground(Color.WHITE);
                        setFont(new Font(FONT, Font.BOLD, 13));
                        setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
                        return this;
                    }
                });
            } else {
                t.setTableHeader(null);
            }
        }

        // ----------------------------------------------- ievades lauku paskaidrojumi
        /** Parāda pelēku paskaidrojošo tekstu (kā skicēs), kamēr lauks tukšs. */
        public static void hint(final JTextField f, final String hint) {
            final char echo = (f instanceof JPasswordField) ? ((JPasswordField) f).getEchoChar() : 0;
            f.putClientProperty("hint.text", hint);
            f.putClientProperty("hint.echo", echo);
            showHint(f);
            f.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (isHint(f)) {
                        f.putClientProperty("hint.on", Boolean.FALSE);
                        f.setText("");
                        f.setForeground(TEXT);
                        if (f instanceof JPasswordField) ((JPasswordField) f).setEchoChar(echo);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (value(f).isEmpty()) showHint(f);
                }
            });
        }

        private static void showHint(JTextField f) {
            f.putClientProperty("hint.on", Boolean.TRUE);
            if (f instanceof JPasswordField) ((JPasswordField) f).setEchoChar((char) 0);
            f.setText((String) f.getClientProperty("hint.text"));
            f.setForeground(HINT);
        }

        public static boolean isHint(JTextField f) {
            return Boolean.TRUE.equals(f.getClientProperty("hint.on"));
        }

        /** Lauka saturs (tukšs, ja redzams tikai paskaidrojošais teksts). */
        public static String value(JTextField f) {
            if (isHint(f)) return "";
            if (f instanceof JPasswordField) return new String(((JPasswordField) f).getPassword());
            return f.getText().trim();
        }

        public static void clear(JTextField f) {
            if (f.getClientProperty("hint.text") != null) showHint(f); else f.setText("");
        }

        // ----------------------------------------------------------------- ikonas
        public static String stars(int n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= 5; i++) sb.append(i <= n ? '★' : '☆');
            return sb.toString();
        }

        public static Icon userIcon(final int size) {
            return new Icon() {
                @Override
                public void paintIcon(Component c, Graphics g, int x, int y) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(new Color(0xE6E6E6));
                    g2.fill(new Ellipse2D.Double(x, y, size, size));
                    g2.setClip(new Ellipse2D.Double(x, y, size, size));
                    g2.setColor(new Color(0x595959));
                    g2.fill(new Ellipse2D.Double(x + size * 0.32, y + size * 0.16, size * 0.36, size * 0.36));
                    g2.fill(new Ellipse2D.Double(x + size * 0.12, y + size * 0.58, size * 0.76, size * 0.7));
                    g2.setClip(null);
                    g2.setColor(new Color(0x404040));
                    g2.setStroke(new BasicStroke(Math.max(1.5f, size / 28f)));
                    g2.draw(new Ellipse2D.Double(x + 1, y + 1, size - 2, size - 2));
                    g2.dispose();
                }

                @Override public int getIconWidth() { return size; }
                @Override public int getIconHeight() { return size; }
            };
        }

        public static Icon magnifier(final int size) {
            return new Icon() {
                @Override
                public void paintIcon(Component c, Graphics g, int x, int y) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(BLUE);
                    g2.setStroke(new BasicStroke(size / 9f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                    g2.draw(new Ellipse2D.Double(x + 2, y + 2, size * 0.58, size * 0.58));
                    g2.drawLine(x + (int) (size * 0.62), y + (int) (size * 0.62), x + size - 3, y + size - 3);
                    g2.dispose();
                }

                @Override public int getIconWidth() { return size; }
                @Override public int getIconHeight() { return size; }
            };
        }

        /** Plakāta vietturis: krāsains gradients ar filmas nosaukumu. */
        public static Icon poster(final String title, final int w, final int h) {
            return new Icon() {
                @Override
                public void paintIcon(Component c, Graphics g, int x, int y) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                    float hue = (Math.abs(title.hashCode()) % 360) / 360f;
                    Color c1 = Color.getHSBColor(hue, 0.55f, 0.55f);
                    Color c2 = Color.getHSBColor((hue + 0.12f) % 1f, 0.75f, 0.25f);
                    g2.setPaint(new GradientPaint(x, y, c1, x, y + h, c2));
                    g2.fillRect(x, y, w, h);
                    g2.setColor(new Color(255, 255, 255, 230));
                    g2.setFont(new Font(FONT, Font.BOLD, Math.max(12, w / 6)));
                    FontMetrics fm = g2.getFontMetrics();
                    java.util.List<String> lines = wrap(title, fm, w - 14);
                    int ty = y + h - 12 - (lines.size() - 1) * fm.getHeight();
                    for (String s : lines) {
                        g2.drawString(s, x + 8, ty);
                        ty += fm.getHeight();
                    }
                    g2.setColor(new Color(0x2B2B2B));
                    g2.setStroke(new BasicStroke(1.5f));
                    g2.drawRect(x, y, w - 1, h - 1);
                    g2.dispose();
                }

                @Override public int getIconWidth() { return w; }
                @Override public int getIconHeight() { return h; }
            };
        }

        private static java.util.List<String> wrap(String text, FontMetrics fm, int maxWidth) {
            java.util.List<String> lines = new java.util.ArrayList<>();
            StringBuilder cur = new StringBuilder();
            for (String word : text.split(" ")) {
                String test = cur.length() == 0 ? word : cur + " " + word;
                if (fm.stringWidth(test) > maxWidth && cur.length() > 0) {
                    lines.add(cur.toString());
                    cur = new StringBuilder(word);
                } else {
                    cur = new StringBuilder(test);
                }
            }
            if (cur.length() > 0) lines.add(cur.toString());
            return lines;
        }

        public static Border blueBorder(int width) {
            return BorderFactory.createLineBorder(BLUE, width);
        }
    }

    /**
     * Filmas karte galvenā loga sarakstā: plakāts, nosaukums, vērtējums un īss apraksts.
     * Karte tiek veidota programmatiski, jo to atkārto katrai filmai.
     */
    static class FilmCard extends JPanel {

        public FilmCard(DemoData.Film film, final Runnable onClick) {
            setLayout(null);
            setBackground(Color.WHITE);
            setBorder(Ui.blueBorder(2));
            setPreferredSize(new Dimension(850, 162));
            setMaximumSize(new Dimension(Integer.MAX_VALUE, 162));
            setAlignmentX(LEFT_ALIGNMENT);
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            JLabel poster = new JLabel(Ui.poster(film.nosaukums(), 98, 142));
            poster.setBounds(10, 9, 98, 142);
            add(poster);

            JLabel name = new JLabel(film.nosaukums());
            Ui.title(name, 28);
            name.setBounds(124, 6, 520, 42);
            add(name);

            JLabel stars = new JLabel(Ui.stars(film.vertejums()), JLabel.RIGHT);
            Ui.title(stars, 26);
            stars.setBounds(630, 6, 224, 42);
            add(stars);

            JTextArea text = new JTextArea(film.apraksts());
            Ui.area(text, 13);
            text.setEditable(false);
            text.setFocusable(false);
            text.setBounds(124, 54, 730, 98);
            add(text);

            MouseAdapter click = new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    onClick.run();
                }
            };
            addMouseListener(click);
            poster.addMouseListener(click);
            name.addMouseListener(click);
            stars.addMouseListener(click);
            text.addMouseListener(click);
        }
    }
}
