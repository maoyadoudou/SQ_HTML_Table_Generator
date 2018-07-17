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
		  //将软件字体调大
		  Font font = new Font("TimesRoman", Font.PLAIN,40);

	      JFrame frame = new JFrame();	      
	      
	      //显示部分
	      JPanel panel = new JPanel();
	      text = new JTextArea(50,100);
	      text.setLineWrap(true);
	       
	      JScrollPane scroller = new JScrollPane(text);
	      scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	      scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	      panel.add(scroller);
	      frame.add(panel, BorderLayout.CENTER);
	      
	      
	      //输入部分
	      JPanel panelInput = new JPanel();
	      final JTextField rowText = new JTextField(8);
	      final JTextField columnText = new JTextField(8);
	      panelInput.setLayout(new GridLayout(1, 2));
	      //设置字体
	      JLabel jl1 = new JLabel("行 (row)：", SwingConstants.CENTER);
	      jl1.setFont(font);
	      panelInput.add(jl1);
	      rowText.setHorizontalAlignment(JTextField.LEFT);
	      panelInput.add(rowText);
	      rowText.setFont(font);
	      
	      JLabel jl2 = new JLabel("列 (column)：", SwingConstants.RIGHT);
	      jl2.setFont(font);
	      panelInput.add(jl2);
	      columnText.setHorizontalAlignment(JTextField.LEFT);;
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
             	 text.setFont(font);
	        	 text.setText("");
	        	 //判定不为空
	        	 if( rowText.getText().trim().length() == 0 || columnText.getText().trim().length() == 0 ) {
	        		 text.append("出现问题，输入不能为空\n");
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
	        			 //输入不是整数
	        			 text.append("请确认您输入的整数。");
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
