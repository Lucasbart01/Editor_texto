import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Editor_de_texto extends JFrame {
	private JLabel label1, label2,lbfonte, lbtamanho;
	private JButton btGravar, btAbrir, btLimpar, btNegrito;
	private JTextField tfTexto;
	private TextArea taTexto;
	private FileDialog fdAbrir, fdSalvar;
	private String nome_do_arquivo;
	private JComboBox cbtamanhotxt;

	public Editor_de_texto() {
		inicializarComponentes();
		definirEventos();
	}

	public void inicializarComponentes() {
		
		String[] cbTamanhos = { "10", "12 (padrão)","14", "16" };
		setTitle("Salvando Arquivos");
		setLayout(null);
		setBounds(250, 50, 600, 600);
		setResizable(false);
		
		cbtamanhotxt = new JComboBox(cbTamanhos);
		label1 = new JLabel("Digite o texto aqui: ");
		label1.setBounds(5, 5, 200, 20);
		label2 = new JLabel("Status: ");
		label2.setBounds(5, 480, 200, 20);
		lbfonte = new JLabel("Fonte");
		lbfonte.setBounds(500, 20, 70, 20);
		lbtamanho = new JLabel("Tamanho: ");
		lbtamanho.setBounds(500, 50, 100, 20);
		btGravar = new JButton("Gravar");
		btGravar.setBounds(200, 510, 100, 25);
		btAbrir = new JButton("Abrir");
		btAbrir.setBounds(80, 510, 100, 25);
		btLimpar = new JButton("Limpar");
		btLimpar.setBounds(320, 510, 100, 25);
		btNegrito = new JButton("Negrito");
		btNegrito.setBounds(490, 450, 90, 20);
		tfTexto = new JTextField();
		tfTexto.setBounds(50, 480, 430, 20);
		tfTexto.setEditable(false);
		taTexto = new TextArea();
		taTexto.setBounds(5, 25, 480, 450);
		fdAbrir = new FileDialog(this, "Abrir arquivo", FileDialog.LOAD);
		fdSalvar = new FileDialog(this, "Salvar arquivo", FileDialog.SAVE);
		
		cbtamanhotxt.setBounds(500,80, 70, 25);
		
		add(cbtamanhotxt);
		add(label1);
		add(label2);
		add(lbfonte);
		add(lbtamanho);
		add(tfTexto);
		add(taTexto);
		add(btGravar);
		add(btAbrir);
		add(btLimpar);
		add(btNegrito);
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
		
		cbtamanhotxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(cbtamanhotxt.getSelectedItem() == "10") {
					
					 taTexto.setFont(new Font("font",Font.PLAIN,10));
					
				}
				
				if(cbtamanhotxt.getSelectedItem() == "12 (padrão)") {
					
					 taTexto.setFont(new Font("font",Font.PLAIN,12));
				}
				
				if(cbtamanhotxt.getSelectedItem() == "14") {
					
					 taTexto.setFont(new Font("font",Font.PLAIN,14));	
				}
				
				if(cbtamanhotxt.getSelectedItem() == "16") {
					
					 taTexto.setFont(new Font("font",Font.PLAIN,16));	
				}
				
			}
		});
		
		
		
		btNegrito.addMouseListener(new MouseAdapter() {
			 public void mousePressed(MouseEvent e) {
				
				 if(cbtamanhotxt.getSelectedItem() == "10") {
						
					 taTexto.setFont(new Font("font",Font.BOLD,10));	
				}
				
				if(cbtamanhotxt.getSelectedItem() == "12 (padrão)") {
					
					 taTexto.setFont(new Font("font",Font.BOLD,12));
				}
				
				if(cbtamanhotxt.getSelectedItem() == "14") {
					
					 taTexto.setFont(new Font("font",Font.BOLD,14));	
				}
				
				if(cbtamanhotxt.getSelectedItem() == "16") {
					
					 taTexto.setFont(new Font("font",Font.BOLD,16));	
				}
				 
				

			 }	
			
		});
		}
	
	

	public static void main(String args[]) {
		JFrame frame = new Editor_de_texto();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}