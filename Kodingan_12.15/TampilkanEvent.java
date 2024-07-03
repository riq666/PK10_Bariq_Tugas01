package pk10_tugas01_12.pkg15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 * Menampilkan Peristiwa 12.15
 * @auther Bariq 25/6-2024
 */

public class TampilkanEvent extends JFrame implements ActionListener, ItemListener, ListSelectionListener, MouseListener, MouseMotionListener, KeyListener {
    
    private final JTextArea areaTampilan;
    private final JButton tombol;
    private final JCheckBox kotakCek;
    private final JList<String> daftar;
    private final JPanel panel;
    
    public TampilkanEvent() {
        super("Tampilkan Event");

        // Set layout manager
        setLayout(new BorderLayout());

        // Buat komponen
        areaTampilan = new JTextArea(10, 30);
        areaTampilan.setEditable(false);
        tombol = new JButton("Klik Saya");
        kotakCek = new JCheckBox("Centang Saya");
        String[] items = {"Item 1", "Item 2", "Item 3"};
        daftar = new JList<>(items);
        
        // Buat panel dan tambahkan tombol dan kotak cek
        panel = new JPanel();
        panel.add(tombol);
        panel.add(kotakCek);

        // Tambahkan komponen ke frame
        add(new JScrollPane(areaTampilan), BorderLayout.CENTER);
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(daftar), BorderLayout.SOUTH);
        
        // Daftarkan pendengar
        tombol.addActionListener(this);
        kotakCek.addItemListener(this);
        daftar.addListSelectionListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
        setFocusable(true);

        // Set properti frame
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Metode pembantu untuk menampilkan informasi event
    private void tampilkanInfoEvent(String namaEvent, AWTEvent event) {
        areaTampilan.append(namaEvent + ": " + event.toString() + "\n");
    }

    // Metode ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        tampilkanInfoEvent("ActionEvent", e);
    }

    // Metode ItemListener
    @Override
    public void itemStateChanged(ItemEvent e) {
        tampilkanInfoEvent("ItemEvent", e);
    }

    // Metode ListSelectionListener
    @Override
    public void valueChanged(ListSelectionEvent e) {
        tampilkanInfoEvent("ListSelectionEvent", e);
    }

    // Metode MouseListener
    @Override
    public void mouseClicked(MouseEvent e) {
        tampilkanInfoEvent("MouseEvent (diklik)", e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        tampilkanInfoEvent("MouseEvent (ditekan)", e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        tampilkanInfoEvent("MouseEvent (dilepas)", e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        tampilkanInfoEvent("MouseEvent (dimasuki)", e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        tampilkanInfoEvent("MouseEvent (ditinggalkan)", e);
    }

    // Metode MouseMotionListener
    @Override
    public void mouseDragged(MouseEvent e) {
        tampilkanInfoEvent("MouseMotionEvent (diseret)", e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        tampilkanInfoEvent("MouseMotionEvent (digerakkan)", e);
    }

    // Metode KeyListener
    @Override
    public void keyTyped(KeyEvent e) {
        tampilkanInfoEvent("KeyEvent (diketik)", e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        tampilkanInfoEvent("KeyEvent (ditekan)", e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        tampilkanInfoEvent("KeyEvent (dilepas)", e);
    }

    private void tampilkanInfoEvent(String listSelectionEvent, ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}