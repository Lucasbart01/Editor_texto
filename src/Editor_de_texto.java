import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Editor_de_texto extends JFrame {
	private JLabel label1, label2,lbfonte, lbtamanho, lbcor, lbtipo;
	private JButton btGravar, btAbrir, btLimpar, btNegrito, btSalvar;
	private JTextField tfTexto;
	private TextArea taTexto;
	private FileDialog fdAbrir, fdSalvar;
	private String nome_do_arquivo;
	private JComboBox cbtamanhotxt, cbcortxt, cbfontetxt;

	public Editor_de_texto() {
		inicializarComponentes();
		definirEventos();
	}

	public void inicializarComponentes() {
		String[] cbCor = { "Preto (padrão)" , "Azul", "Vermelho"};
		String[] cbTamanhos = { "12 (padrão)" ,"10","14"};
		String[] cbFonte = {"Padrão", "Courier","Serif"};
		setTitle("Salvando Arquivos");
		setLayout(null);
		setBackground(new Color(192,192,192));
		setResizable(false);
		
		cbtamanhotxt = new JComboBox(cbTamanhos);
		cbcortxt = new JComboBox(cbCor);
		cbfontetxt = new JComboBox(cbFonte);
		label1 = new JLabel("Digite o texto aqui: ");
		label1.setBounds(5, 5, 200, 20);
		label2 = new JLabel("Status: ");
		label2.setBounds(5, 480, 200, 20);
		lbfonte = new JLabel("Fonte");
		lbfonte.setBounds(500, 20, 70, 20);
		lbtamanho = new JLabel("Tamanho: ");
		lbtamanho.setBounds(500, 50, 100, 20);
		lbcor = new JLabel("Cor:");
		lbcor.setBounds(500, 160, 100, 20);
		lbtipo = new JLabel("Estilo:");
		lbtipo.setBounds(500, 270, 100, 20);
		btGravar = new JButton("Gravar");
		btGravar.setBounds(200, 510, 100, 25);
		btAbrir = new JButton("Abrir");
		btAbrir.setBounds(80, 510, 100, 25);
		btLimpar = new JButton("Limpar");
		btLimpar.setBounds(320, 510, 100, 25);
		btNegrito = new JButton("Negrito");
		btNegrito.setBounds(490, 400, 90, 20);
		btSalvar = new JButton("Salvar");
		btSalvar.setBounds(490, 430, 90, 20);
		tfTexto = new JTextField();
		tfTexto.setBounds(50, 480, 430, 20);
		tfTexto.setEditable(false);
		taTexto = new TextArea();
		taTexto.setBounds(5, 25, 480, 450);
		fdAbrir = new FileDialog(this, "Abrir arquivo", FileDialog.LOAD);
		fdSalvar = new FileDialog(this, "Salvar arquivo", FileDialog.SAVE);
		
		cbtamanhotxt.setBounds(500,70, 70, 25);
		cbcortxt.setBounds(500, 180, 90, 25);
		cbfontetxt.setBounds(500, 290, 70, 25);
		
		
		
		//DEFININDO CORES E TAMANHOS
		
		label1.setFont(new Font("font", Font.BOLD, 14));
		label2.setFont(new Font("font", Font.BOLD, 13));
		lbfonte.setFont(new Font("font", Font.BOLD, 14));
		lbtamanho.setFont(new Font("font", Font.BOLD, 13));
		lbcor.setFont(new Font("font", Font.BOLD, 13));
		lbtipo.setFont(new Font("font", Font.BOLD, 13));
		
		btAbrir.setBackground(Color.white);
		btSalvar.setBackground(Color.white);
		btLimpar.setBackground(Color.white);
		btGravar.setBackground(Color.white);
		btNegrito.setBackground(Color.white);
		
		cbtamanhotxt.setBackground(Color.white);
		cbcortxt.setBackground(Color.white);
		cbfontetxt.setBackground(Color.white);
		
		
		
		
		add(cbtamanhotxt);
		add(cbcortxt);
		add(cbfontetxt);
		add(label1);
		add(label2);
		add(lbfonte);
		add(lbtamanho);
		add(lbcor);
		add(lbtipo);
		add(tfTexto);
		add(taTexto);
		add(btGravar);
		add(btAbrir);
		add(btLimpar);
		add(btNegrito);
		add(btSalvar);
	}

	public void definirEventos() {
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taTexto.setText("");
				tfTexto.setText("");
			}
		});
		btGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fdSalvar.setVisible(true);
					if (fdSalvar.getFile() == null) {
						return;
					}
					nome_do_arquivo = fdSalvar.getDirectory()
							+ fdSalvar.getFile();
					FileWriter out = new FileWriter(nome_do_arquivo);
					out.write(taTexto.getText());
					out.close();
					tfTexto.setText("Arquivo gravado com sucesso");
				} catch (IOException erro) {
					tfTexto.setText("Erro ao gravar no arquivo"
							+ erro.toString());
				}

			}
		});
		btAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fdAbrir.setVisible(true);
					if (fdAbrir.getFile() == null) {
						return;
					}
					nome_do_arquivo = fdAbrir.getDirectory()
							+ fdAbrir.getFile();
					FileReader in = new FileReader(nome_do_arquivo);
					String s = "";
					int i = in.read();
					while (i != -1) {
						s = s + (char) i;
						i = in.read();
					}
					taTexto.setText(s);
					in.close();
					tfTexto.setText("Arquivo aberto com sucesso");
				} catch (IOException erro) {
					tfTexto.setText("Erro ao abrir no arquivo"
							+ erro.toString());
				}

			}
		});
		
		
		//CASO SEM NEGRITO
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				   //CASO 1
if(cbtamanhotxt.getSelectedItem() == "10" && cbfontetxt.getSelectedItem() == "Courier") {
					
	taTexto.setFont(new Font("Courier",Font.PLAIN,10));
}
				
if(cbtamanhotxt.getSelectedItem() == "12 (padrão)"  && cbfontetxt.getSelectedItem() == "Courier") {
					
   taTexto.setFont(new Font("Courier",Font.PLAIN,12));
}
				
if(cbtamanhotxt.getSelectedItem() == "14" && cbfontetxt.getSelectedItem() == "Courier") {
					
	 taTexto.setFont(new Font("Courier",Font.PLAIN,14));
}
				

                 //CASO 2
if(cbtamanhotxt.getSelectedItem() == "10" && cbfontetxt.getSelectedItem() == "Serif") {
	
	 taTexto.setFont(new Font("Serif",Font.PLAIN,10));
}

if(cbtamanhotxt.getSelectedItem() == "12 (padrão)"  && cbfontetxt.getSelectedItem() == "Serif") {
	
	 taTexto.setFont(new Font("Serif",Font.PLAIN,12));
}

if(cbtamanhotxt.getSelectedItem() == "14" && cbfontetxt.getSelectedItem() == "Serif") {
	
	 taTexto.setFont(new Font("Serif",Font.PLAIN,14));
}


                 //CASO 3
if(cbtamanhotxt.getSelectedItem() == "10" && cbfontetxt.getSelectedItem() == "Padrão") {
	
	 taTexto.setFont(new Font("font",Font.PLAIN,10));
}

if(cbtamanhotxt.getSelectedItem() == "12 (padrão)"  && cbfontetxt.getSelectedItem() == "Padrão") {
	
	 taTexto.setFont(new Font("font",Font.PLAIN,12));
}

if(cbtamanhotxt.getSelectedItem() == "14" && cbfontetxt.getSelectedItem() == "Padrão") {
	
	 taTexto.setFont(new Font("font",Font.PLAIN,14));
}


               //TROCAR CORES
if(cbcortxt.getSelectedItem( ) == "Preto (padrão)") {
	
	taTexto.setForeground(Color.black);
}

if(cbcortxt.getSelectedItem( ) == "Azul") {
	
	taTexto.setForeground(Color.blue);
}

if(cbcortxt.getSelectedItem( ) == "Vermelho") {
	
	taTexto.setForeground(Color.red );
}

		}
		});
		
		//CASOS COM NEGRITO
		btNegrito.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				  
				 // CASO 1
if(cbtamanhotxt.getSelectedItem() == "10" && cbfontetxt.getSelectedItem() == "Courier") {
						
					 taTexto.setFont(new Font("Courier",Font.BOLD,10));	
				}
				
if(cbtamanhotxt.getSelectedItem() == "12 (padrão)" && cbfontetxt.getSelectedItem() == "Courier") {
					
					 taTexto.setFont(new Font("Courier",Font.BOLD,12));
				}
				
if(cbtamanhotxt.getSelectedItem() == "14" && cbfontetxt.getSelectedItem() == "Courier") {
					
					 taTexto.setFont(new Font("Courier",Font.BOLD,14));	
				}
					 


                 //CASO 2
if(cbtamanhotxt.getSelectedItem() == "10" && cbfontetxt.getSelectedItem() == "Serif") {
				
			 taTexto.setFont(new Font("Serif",Font.BOLD,10));	
		}
		
if(cbtamanhotxt.getSelectedItem() == "12 (padrão)" && cbfontetxt.getSelectedItem() == "Serif") {
			
			 taTexto.setFont(new Font("Serif",Font.BOLD,12));
		}
		
if(cbtamanhotxt.getSelectedItem() == "14" && cbfontetxt.getSelectedItem() == "Serif") {
			
			 taTexto.setFont(new Font("Serif",Font.BOLD,14));	
		}



                  //CASO 3
if(cbtamanhotxt.getSelectedItem() == "10" && cbfontetxt.getSelectedItem() == "Padrão") {
		
	 taTexto.setFont(new Font("font",Font.BOLD,10));	
}

if(cbtamanhotxt.getSelectedItem() == "12 (padrão)" && cbfontetxt.getSelectedItem() == "Padrão") {
	
	 taTexto.setFont(new Font("font",Font.BOLD,12));
}

if(cbtamanhotxt.getSelectedItem() == "14" && cbfontetxt.getSelectedItem() == "Padrão") {
	
	 taTexto.setFont(new Font("font",Font.BOLD,14));	
}
			
			 }	
			
		});
		}
	
	public static void main(String args[]) {
		JFrame frame = new Editor_de_texto();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setBounds(250, 50, 630, 600);
	}
	
}