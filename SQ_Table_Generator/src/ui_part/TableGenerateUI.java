package ui_part;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		  //将软件字体调大
		  Font font = new Font("TimesRoman", Font.PLAIN,40);

	      JFrame frame = new JFrame();	      
	      
	      //显示部分
	      JPanel panel = new JPanel();
	      text = new JTextArea(50,120);
	      text.setLineWrap(true);
	       
	      JScrollPane scroller = new JScrollPane(text);
	      scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	      scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	      panel.add(scroller);
	      frame.add(panel, BorderLayout.CENTER);
	      
	      
	      //输入部分
	      JPanel panelInput = new JPanel();
	      final JTextField rowText = new JTextField(5);
	      final JTextField columnText = new JTextField(5);
	      panelInput.setLayout(new GridLayout(2, 1));
	      //设置字体
	      JLabel jl1 = new JLabel("行 (row)：", SwingConstants.RIGHT);
	      jl1.setFont(font);
	      panelInput.add(jl1);
	      panelInput.add(rowText);
	      rowText.setFont(font);
	      
	      JLabel jl2 = new JLabel("列 (column)：", SwingConstants.RIGHT);
	      jl2.setFont(font);
	      panelInput.add(jl2);
	      panelInput.add(columnText);
	      columnText.setFont(font);
	      frame.add(BorderLayout.NORTH, panelInput);
	      
	      //设置按键部分
	      JPanel panelButton = new JPanel();
	      JButton jb = new JButton("Table generate!");
	      jb.setFont(font);
	      panelButton.add(jb);
	      frame.add(BorderLayout.SOUTH, panelButton);

	      
	      // jb 按键事件发生后，想SimpleTable类的tableWithRowColumn传递行列数，返回html语言
	      jb.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {  
	        	 //先清空文本区
	        	 text.setText("");
	        	 String rowstr = rowText.getText().trim();
	        	 String columnstr = columnText.getText().trim(); 
	        	 int row = Integer.parseInt(rowstr);
	        	 int column = Integer.parseInt(columnstr);
	             TableGenerate tg = new SimpleTable();
	 			 ArrayList<String> list = tg.tableWithRowColumn(row, column);
	 			 text.setFont(font);
	 			 for (String string : list) {
	 				 text.append(string + "\n");	
	             } 
	         }
	      }); 
	       
	      frame.setSize(1500,1000);
	      frame.setVisible(true);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}
