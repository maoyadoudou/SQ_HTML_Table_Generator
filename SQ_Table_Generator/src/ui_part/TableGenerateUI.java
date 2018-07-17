package ui_part;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import io_part.SimpleTable;
import io_part.TableGenerate;

public class TableGenerateUI{
	 JTextArea text;
	
	public static void main(String[] args) {
		TableGenerateUI gui = new TableGenerateUI();
		gui.go();
	}

	private void go() {
		  //������������
		  Font font = new Font("TimesRoman", Font.PLAIN,40);

	      JFrame frame = new JFrame();	      
	      
	      //��ʾ����
	      JPanel panel = new JPanel();
	      text = new JTextArea(50,100);
	      text.setLineWrap(true);
	       
	      JScrollPane scroller = new JScrollPane(text);
	      scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	      scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	      panel.add(scroller);
	      frame.add(panel, BorderLayout.CENTER);
	      
	      
	      //���벿��
	      JPanel panelInput = new JPanel();
	      final JTextField rowText = new JTextField(8);
	      final JTextField columnText = new JTextField(8);
	      panelInput.setLayout(new GridLayout(1, 2));
	      //��������
	      JLabel jl1 = new JLabel("�� (row)��", SwingConstants.CENTER);
	      jl1.setFont(font);
	      panelInput.add(jl1);
	      rowText.setHorizontalAlignment(JTextField.LEFT);
	      panelInput.add(rowText);
	      rowText.setFont(font);
	      
	      JLabel jl2 = new JLabel("�� (column)��", SwingConstants.RIGHT);
	      jl2.setFont(font);
	      panelInput.add(jl2);
	      columnText.setHorizontalAlignment(JTextField.LEFT);;
	      panelInput.add(columnText);
	      columnText.setFont(font);
	      frame.add(BorderLayout.NORTH, panelInput);
	      
	      //���ð�������
	      JPanel panelButton = new JPanel();
	      JButton jb = new JButton("Table generate!");
	      jb.setFont(font);
	      panelButton.add(jb);
	      frame.add(BorderLayout.SOUTH, panelButton);

	      
	      // jb �����¼���������SimpleTable���tableWithRowColumn����������������html����
	      jb.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {  
	        	 //������ı���
             	 text.setFont(font);
	        	 text.setText("");
	        	 //�ж���Ϊ��
	        	 if( rowText.getText().trim().length() == 0 || columnText.getText().trim().length() == 0 ) {
	        		 text.append("�������⣬���벻��Ϊ��\n");
	        	 } else {
	        		 String rowstr = rowText.getText().trim();
	        		 String columnstr = columnText.getText().trim(); 
	        		 try {
	        			 int row = Integer.parseInt(rowstr);
	        			 int column = Integer.parseInt(columnstr);
	        			 TableGenerate tg = new SimpleTable();
	        			 ArrayList<String> list = tg.tableWithRowColumn(row, column);
	        			 for (String string : list) {
	        				 text.append(string + "\n");	
	        			 } 
	        		 } catch (Exception el) {
	        			 //���벻������
	        			 text.append("��ȷ���������������");
	        		 }
	        	 }
	         }
	      }); 
	      frame.pack();
//	      frame.setSize(1200,1000);
	      frame.setResizable(false);
	      frame.setVisible(true);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}
