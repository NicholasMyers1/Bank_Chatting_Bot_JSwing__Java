import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
	import javax.swing.JFrame;
	import javax.swing.JTextArea;
	import javax.swing.JTextField;
public class NickBot extends JFrame{
	int email=0;
	int account=0;
	//Typing Area: 
	private JTextField txtEnter = new JTextField();
	//Chat Area: 
	private JTextArea txtChat = new JTextArea();
	public NickBot(String introComment){
		//Frame Attributes: 
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(600,600);
			this.setVisible(true);
			this.setResizable(false);
			this.setLayout(null);
			this.setTitle("Java AI Nick's Bot");
		//txtEnter attributes: 
			txtEnter.setLocation(2,540);
			txtEnter.setSize(590,30);
			
			
		//txtEnter Action Event: 
			txtEnter.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					String userText=txtEnter.getText();
					txtChat.append("Customer: "+userText+"\n");
					/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						if(account==0&&userText.contains("account")||account==0&&userText.contains("login")||account==0&&userText.contains("password")||account==0&&userText.contains("email")){
							email=1;
							botTalk("Please enter your email address to have a reset code sent directly\n to your email to help reset your account!\n"
									+ "Then follow the simple directions in the email.");
						}
						else if(email==1&&userText.contains("@")&&userText.contains(".")){
							botTalk("An email was sent to: "+userText);
							botTalk("Did you receive the email?\nAn agent will be available if you still have an issue with your account.");
							email=2;
						}
						else if(email==2&&userText.contains("yes")){
							botTalk("Thank you for your patience and business with \"Nick's Bank\". Goodbye.");
							email=0;
							account=0;
						}
						else if(email==2&&userText.contains("no")){
							email=1;
							botTalk("Please try entering a valid email address this time if you did not receive the email!\n"
									+ "Then follow the simple directions in the email.");
						}
						else if(email==1&&!userText.contains("@")&&!userText.contains(".")){
							botTalk("Please enter a valid email!");
						}
						/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						else if(email==0&&userText.contains("balance")||account!=0){
							if(account==0){
								botTalk("Enter your username for your account to access your balance: ");
								account=1;
							}
							else if(account==1){
									double x=Math.random()*100000;//it would normally pull from the account, but this is a demonstration;
									botTalk(userText+", your balance is: "+x);
									botTalk("Did you find everything you need help with today?");
									account=2;
							}
							else if(account==2&&userText.contains("yes")){
								botTalk("Thank you for your patience and business with \"Nick's Bank\". Goodbye.");
								email=0;
								account=0;
							}
							else if(account==2&&userText.contains("no")){
								email=0;
								account=0;
								botTalk("What else could I help you with?");
							}	
						}
						////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						else if(email==0&&account==0){
							botTalk("I am sorry. What are you trying to ask?");
						}
					
					txtEnter.setText("");
				}
			});
			
			
			
			
		//txtChat Attributes:
			txtChat.setLocation(15,5);
			txtChat.setSize(560,510);
			txtChat.setEditable(false);
		//Add Items To Frame: 
			this.add(txtEnter);
			this.add(txtChat);
			txtChat.append("AI Nick's:\n"+introComment+"\n");
			txtEnter.setText("");
	}
	
	public void botTalk(String talk){
		txtChat.append("Support agent (Nick): "+talk+"\n");
	}
	
	public static void main(String[] args){
		//TODO Auto-generated method stub;
			new NickBot("support agent(Nick): Welcome to 'Nick's Bank' customer service chat.\nHow may I help you?");
	}
}