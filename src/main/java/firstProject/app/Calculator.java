/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package firstProject.app;

import java.util.ArrayList;
import java.util.Stack;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Calculator extends JFrame{
	String tem = "";

	String output = "";
	boolean reset = false;
	String n;
	String result,t="";
	String change;
	
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	
	static JTextField tf = new JTextField(10);
	

	static String[] btntext= {"AC", "!", "=", "<-","7", "8","9","x", "4", "5", "6", "+", "1", "2", "3", "-", "0","00", ".", "/"};
	static JButton[] btns=new JButton[20];

    
    public Calculator() { 
    	this.setTitle("계산기");
    	
    	panel1.setLayout(new GridLayout(1, 1, 5, 5));
    	panel2.setLayout(null);
    	
    	panel1.setBackground(Color.DARK_GRAY);
    	panel1.setOpaque(true);
    	panel2.setBackground(Color.LIGHT_GRAY);
    	panel2.setOpaque(true);
    	
    	this.add(panel1, BorderLayout.NORTH);
    	this.add(panel2);
    	
    	
    	tf.setText("0");
    	tf.setHorizontalAlignment(JTextField.RIGHT);
    	Font font = new Font("Arial", Font.BOLD, 60);
    	tf.setFont(font);
    	tf.setEditable(false);
    	
    	
    	
    	panel1.add(tf);
     
    	
       // 버튼들
        for(int i=0;i<btns.length;i++) {
        	btns[i]=new JButton(btntext[i]);
        	btns[i].setVisible(true);//보이게
        	panel2.add(btns[i]);
        	btns[i].addActionListener(listener);
        }
        
        if(tem.equals("")) {
			btns[0].setEnabled(false);
			btns[1].setEnabled(false);
			btns[2].setEnabled(false);
			btns[3].setEnabled(false);
			btns[7].setEnabled(false);
			btns[11].setEnabled(false);
			btns[15].setEnabled(false);
			btns[18].setEnabled(false);
			btns[19].setEnabled(false);
		}
    
        
        btns[0].setBounds(0,0, 110, 75);
        btns[1].setBounds(110,0, 110, 75);
        btns[2].setBounds(220,0, 110, 75);
        btns[3].setBounds(330,0, 65, 75);
        
        btns[4].setBounds(0,70, 110, 75);
        btns[5].setBounds(110,70, 110, 75);
        btns[6].setBounds(220,70, 110, 75);
        btns[7].setBounds(330,70, 65, 75);
        
        btns[8].setBounds(0,140, 110, 75);
        btns[9].setBounds(110,140, 110, 75);
        btns[10].setBounds(220,140, 110, 75);
        btns[11].setBounds(330,140, 65, 75);
        
        btns[12].setBounds(0,210, 110, 75);
        btns[13].setBounds(110,210, 110, 75);
        btns[14].setBounds(220,210, 110, 75);
        btns[15].setBounds(330,210, 65, 75);
        
        btns[16].setBounds(0,280, 110, 75);
        btns[17].setBounds(110,280, 110, 75);
        btns[18].setBounds(220,280, 110, 75);
        btns[19].setBounds(330,280, 65, 75);
        
        

        
  

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 활성 
        
        // 크기지정 
        this.setSize(395, 470); 
        this.setResizable(true);
        // 보여줘 
        
        this.setVisible(true);
    }
    
    
    
    public static void main(String[] args) { 
    	new Calculator(); 
    }
    
    ActionListener listener = new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		String input = e.getActionCommand();
    			
    		
			btns[0].setEnabled(true);
			btns[1].setEnabled(true);
			btns[2].setEnabled(true);
			btns[3].setEnabled(true);
			btns[7].setEnabled(true);
			btns[11].setEnabled(true);
			btns[15].setEnabled(true);
			btns[18].setEnabled(true);
			btns[19].setEnabled(true);
    		
    	
	    	if(opt(input)) { //숫자들은 그냥 출력만 함.
	    		if(reset) {
	    			tem = "";
	//    			output = "";
	    			change = "";
	    			tf.setText("");
	    			
	    			reset = false;
	    		}
	    		
	    		tem += input;
	    		tf.setText(tem);
	 //   		output += input;
	    		change += input;
	    	}
	    	
	    	else { //oprator들 다루는 else구문
	    		
	    		if(reset) {
	    			output = result;
	    			change = result;
	    			tem = output;
	    		}
	    		
	    		reset = false;
	   
	    		if(input.equals("AC")) {
	    			tf.setText("0");
	    			tem = "";
	 
	    			change = "";
	    			
	    			btns[0].setEnabled(false);
	    			btns[1].setEnabled(false);
	    			btns[2].setEnabled(false);
	    			btns[3].setEnabled(false);
	    			btns[7].setEnabled(false);
	    			btns[11].setEnabled(false);
	    			btns[15].setEnabled(false);
	    			btns[18].setEnabled(false);
	    			btns[19].setEnabled(false);
	    			
	    			
	    			btns[4].setEnabled(true);
	    			btns[5].setEnabled(true);
	    			btns[6].setEnabled(true);
	    			btns[8].setEnabled(true);
	    			btns[9].setEnabled(true);
	    			btns[10].setEnabled(true);
	    			btns[12].setEnabled(true);
	    			btns[13].setEnabled(true);
	    			btns[14].setEnabled(true);
	    			btns[16].setEnabled(true);
	    			btns[17].setEnabled(true);
	    			
	    		}
	    		
	    		//--------------------------------------------
	    		
	    		else if(input.equals("<-")){
	    			
	    			tem = tem.substring(0, tem.length()-1);
	        		tf.setText(tem);
	        		change = change.substring(0, change.length()-2);	        	}
	    		
	    		//--------------------------------------------
	    		
	    		else if(input.equals("!")) {
	    			tem += input;
	        		tf.setText(tem);
	    			
//	    			
	    		}
	    		
	    		//---------------------------------------------
	    		
	    		else if(!input.equals("0") && !input.equals("=")) {

	    			tem += input;
	        		tf.setText(tem);
	    			
	    		}
	    		
	    		//--------------------------------------------
	    		
	    		else if(input.equals("=")) {
	    			
	    			
	    			String u = "";
	    			reset = true;
	    			String str = "";
	    			
	    			change = tem;
	    			ArrayList<String> arr3 = changeString(change);
	    			
	    			for(int i =0;i<arr3.size() ; i++) {
	    				
	    				if(arr3.get(i).contains("!")) {
	    					if(arr3.get(i).contains(".")) {
	    						tf.setText("syntax error");
	    						
	    						for(int j=1 ; j<20 ; j++)
	    							btns[j].setEnabled(false);
	    		
	    						return;
	    					}
	    					str = arr3.get(i);
	    					str = str.substring(0,str.length()-1);
	    					
	    					int y = Integer.parseInt(str);
	    					
	    					int fac = factorial(y);
	    					
	    					arr3.set(i, Integer.toString(fac));
	    				}
	    			}
	    			
	    			
	    			n = postfix(arr3);
	
	    	
	    			BigDecimal c = new BigDecimal(n);
	    			DecimalFormat formatter = new DecimalFormat("0.#########");
	    			
	    			result=formatter.format(c);
	    			tf.setText(result);
	    			
	    		}
			}
	    }
    	
    };
    
    static boolean opt(String ch){
        if( (ch.equals("+")) || (ch.equals("-")) || (ch.equals("x")) || (ch.equals("/"))  || (ch.equals("=")) || ch.equals("AC") || ch.equals("<-") ||ch.equals("!"))
            return false;
        else return true;
    }

    int prece(String op){
        if(op == "-" || op =="+")
                return 1;
        else if(op == "/" || op =="x")
                return 2;
        else 
        	return 0;
        }
    
   
    ArrayList<String> changeString(String s) {
    	ArrayList<String> arr = new ArrayList<>();
 
    	String ad="";
    	for(int i =0;i<s.length() ; i++) {
    		char a = s.charAt(i);
    		
    		
    		if(a=='+' || a=='-'|| a=='x'|| a=='/') {
    			arr.add(ad);
    			ad = "";
    			arr.add(a + "");
    		}
    		else 
    			ad += a;
    	}
    	arr.add(ad);
    	
    	for(int i =0;i<arr.size() ; i++) {
    		if(arr.get(i).equals("")) {
    			arr.remove("");
    		}
    	}
    
    	for(int i =1;i<arr.size() ; i++) {
    		String prev = arr.get(i-1);
    		String curr = arr.get(i);
    		
    		if((prev.equals("+") || prev.equals("-") || prev.equals("x") ||  prev.equals("/")) && curr.equals("-")) {
    			arr.set(i, arr.get(i)+arr.get(i+1));
    			arr.remove(i+1);
    		}
    	}
    	return arr;
    }
    
    public String postfix(ArrayList<String> arr2) {
    	Stack<String> stack = new Stack<>();
    	ArrayList<String> calc = new ArrayList<>();
    	
    	
    	for(int i =0;i<arr2.size() ; i++) {
    		if(opt(arr2.get(i)))
    			calc.add(arr2.get(i));
    		else {
    			if(!stack.empty()) { //스택에 이미 뭐가 있을
        			if(prece(arr2.get(i)) <= prece(stack.peek())) {
        				
        				while(true){
        					
        					if(stack.empty() || prece(arr2.get(i)) > prece(stack.peek()))
        						break;
        					
        					calc.add(stack.peek());
        					stack.pop();
        					
        				}
        				
        				stack.push(arr2.get(i));
        				
        			}
        			else {
        				stack.push(arr2.get(i));
        			
        			}	
        		}
        		else { //스택에 암것도 없을
        			stack.push(arr2.get(i));
        		}
    		}
    	}
    	while(!stack.empty()){
    		calc.add(stack.peek());
			stack.pop();
        }
    	
    	Double re;
    	
    	for(int i =0;i<calc.size() ; i++) {
    		if(opt(calc.get(i))) {
    		
    			stack.push((calc.get(i)));
    		}
    		else {
    			double n2 = Double.parseDouble(stack.pop());
    			double n1 = Double.parseDouble(stack.pop());
    			
    			if(calc.get(i).equals("+"))
    				stack.push(Double.toString(n1+n2));
    			else if(calc.get(i).equals("-"))
    				stack.push(Double.toString(n1-n2));
    			else if(calc.get(i).equals("x"))
    				stack.push(Double.toString(n1*n2));
    			else if(calc.get(i).equals("/")) {
    				if(n2==0) {
    					tf.setText("숫자 아님");
    					return "";    					
    				}
    				else
    					stack.push(Double.toString(n1/n2));
    			}	
    		}
    	}
    	
    	return stack.pop();
    }
    
    public static int factorial(int n) {
    	if(n==0)
    		return 1;
    	else
    		return (n*factorial(n-1));
    }
    
//    public static Double safeAdd(Double l, Double r) {
//    	if(r>0) {
//    		if(l > Double.MAX_VALUE-r){
//    			throw new ArithmeticException("OverFlow 발생");
//    		}
//    	}
//    	
//    	else {
//    		if(l < Double.MAX_VALUE-r) {
//    			throw new ArithmeticException("OverFlow 발생");
//    		}
//    	}
//    	
//    	return l+r;
//    }
    
//    public static Double safeSub(Double l, Double r) {
//    	if(r>0) {
//    		if(l > Double.MAX_VALUE-r){
//    			throw new ArithmeticException("OverFlow 발생");
//    		}
//    	}
//    	
//    	else {
//    		if(l < Double.MAX_VALUE-r) {
//    			throw new ArithmeticException("OverFlow 발생");
//    		}
//    	}
//    	
//    	return l+r;
//    }
    
//    public static Double safeMul(Double l, Double r) {
//    	if(r>0) {
//    		if(l > Double.MAX_VALUE-r){
//    			throw new ArithmeticException("OverFlow 발생");
//    		}
//    	}
//    	
//    	else {
//    		if(l < Double.MAX_VALUE-r) {
//    			throw new ArithmeticException("OverFlow 발생");
//    		}
//    	}
//    	
//    	return l*r;
//    }
}




