package student;

import java.awt.Color;
import java.awt.Container;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class StudentTable extends JFrame implements ActionListener {
    
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scroll;
    private Container c;
    private Font f,f1;
    private JLabel titleLabel, fnLabel, lnLabel,phoneLabel, gpaLabel,imgLabel;
    private JTextField fnTf, lnTf, phoneTf, gpaTf;
    private JButton addButton, deleteButton, clearButton;
    private ImageIcon icon,img,img2;
    private Cursor csr;
    
    
    private String[] columns = {"First Name", "Last Name", "Phone Number", "GPA"};
    private String[] rows = new String[4];
     
    StudentTable()
    {
        initComponents();
    }
    
    public void initComponents(){
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(400, 200,780, 690);
        this.setLocationRelativeTo(null);
        this.setTitle("Student Information");
        
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(32, 178, 170));
        
        
        //set Icon 
        icon = new ImageIcon(getClass().getResource("Miscellaneous-Icon.jpg"));
        this.setIconImage(icon.getImage());
        
        f = new Font("Tahoma", Font.BOLD, 18);
        f1 = new Font("Bodoni MT Black", Font.BOLD, 35);
        csr = new Cursor(Cursor.HAND_CURSOR);
        
        img = new ImageIcon(getClass().getResource("girl.jpg"));
        
        imgLabel = new JLabel(img);
        imgLabel.setBounds(515, 20,img.getIconWidth(), img.getIconHeight());
        c.add(imgLabel);
        
        titleLabel = new JLabel("Student - Table");
        titleLabel.setBounds(120, 5, 350, 60);
        titleLabel.setFont(f1);
        titleLabel.setForeground(new Color(220,220,220));
        c.add(titleLabel);
        
        fnLabel = new JLabel("First Name  ");
        fnLabel.setBounds(10, 80, 140, 30);
        fnLabel.setFont(f);
        c.add(fnLabel);
        
        fnTf = new JTextField();
        fnTf.setBounds(120, 80, 200, 30);
        fnTf.setFont(f);
        c.add(fnTf);
        
        addButton = new JButton("Add");
        addButton.setBounds(370, 80, 100, 30);
        addButton.setFont(f);
        addButton.setCursor(csr);
        addButton.setBackground(Color.green);
        addButton.setForeground(Color.white);
        c.add(addButton);
        
        
        lnLabel = new JLabel("Last Name  ");
        lnLabel.setBounds(10, 130, 140, 30);
        lnLabel.setFont(f);
        c.add(lnLabel);
        
        lnTf = new JTextField();
        lnTf.setBounds(120, 130, 200, 30);
        lnTf.setFont(f);
        c.add(lnTf);
        
        
        
        
        phoneLabel = new JLabel("Phone  ");
        phoneLabel.setBounds(10, 180, 140, 30);
        phoneLabel.setFont(f);
        c.add(phoneLabel);
        
        phoneTf = new JTextField();
        phoneTf.setBounds(120, 180, 200, 30);
        phoneTf.setFont(f);
        c.add(phoneTf);
        
        deleteButton = new JButton("Delete");
        deleteButton.setBounds(370, 180, 100, 30);
        deleteButton.setFont(f);
        deleteButton.setCursor(csr);
        deleteButton.setBackground(Color.red);
        deleteButton.setForeground(Color.white);
        c.add(deleteButton);
        
        
        gpaLabel = new JLabel("GPA Point ");
        gpaLabel.setBounds(10, 230, 140, 30);
        gpaLabel.setFont(f);
        c.add(gpaLabel);
        
        gpaTf = new JTextField();
        gpaTf.setBounds(120, 230, 200, 30);
        gpaTf.setFont(f);
        c.add(gpaTf);
        
        clearButton = new JButton("Clear");
        clearButton.setBounds(370, 230, 100, 30);
        clearButton.setFont(f);
        clearButton.setBackground(new Color(75,0,130));
        clearButton.setForeground(Color.white);
        clearButton.setCursor(csr);
        c.add(clearButton);
        
        table = new JTable();
        
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setFont(f);
        table.setSelectionBackground(new Color(175, 238, 238));
        table.setBackground(new Color(230, 240, 250));
        table.setRowHeight(30);
        
        scroll = new JScrollPane(table);
        scroll.setBounds(10, 360, 740,265);
        c.add(scroll);
        
        addButton.addActionListener(this);
        
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);
        
        table.addMouseListener(new MouseAdapter(){
        
            public void mouseClicked(MouseEvent me){
            
                int numberOfRow = table.getSelectedRow();
                
                String fn = model.getValueAt(numberOfRow,0).toString();
                String ln = model.getValueAt(numberOfRow,1).toString();
                String phone = model.getValueAt(numberOfRow,2).toString();
                String gpa = model.getValueAt(numberOfRow,3).toString();
                
                fnTf.setText(fn);
                lnTf.setText(ln);
                phoneTf.setText(phone);
                gpaTf.setText(gpa);
            }
        
        });
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==addButton){
            
            rows[0] = fnTf.getText();
            rows[1] = lnTf.getText();
            rows[2] = phoneTf.getText();
            rows[3] = gpaTf.getText();
            
            model.addRow(rows);
            
            
        }
        
       
        
        else if(e.getSource()==deleteButton){
            
            int numberOfRow = table.getSelectedRow();
            
            if (numberOfRow>=0) {
                model.removeRow(numberOfRow);
                
            }
            else{
                JOptionPane.showMessageDialog(null,"You haven't select any row");
            }
        }
        
        
        else if(e.getSource()==clearButton){
            
            fnTf.setText("");
            lnTf.setText("");
            phoneTf.setText("");
            gpaTf.setText("");
        }
    }
    
    
                //Main Function//
    public static void main(String[] args) {
        
        StudentTable frame = new StudentTable();
        frame.setVisible(true);
    }
  
}
