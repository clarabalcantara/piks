package piks;
import java.util.TreeMap;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
// implem. modelo de negocios + repositorio;
public class Repositorio {
	private TreeMap<String, Conta> contasPIKS; private TreeMap<Integer, Cliente> clientesCPF; 
	
	public Repositorio() {
		this.contasPIKS = new TreeMap<String, Conta>(); this.clientesCPF = new TreeMap<Integer, Cliente>();}
		// diferenca .put e .add
	public void adicionarConta(Conta cta){ this.contasPIKS.put(cta.getChavePiks(), cta); }
	public void removerConta(Conta cta) { // metodo em analise * corrigir
		if (cta.getSaldo() == 0) {
			this.contasPIKS.remove(cta.getChavePiks()); 
			this.clientesCPF.remove(cta.getCliente().getCpf());
			cta.getLancamentos().clear();
		}
	}
	public Conta localizarConta (String chavePiks) { return this.contasPIKS.get(chavePiks); }
	public void adicionarCliente(Cliente cli) { this.clientesCPF.put(cli.getCpf(), cli); }
	public void removerCliente(Cliente cli) { this.clientesCPF.remove(cli.getCpf()); }
	public Cliente localizarCliente(int cpf) { return this.clientesCPF.get(cpf); }
	public ArrayList<Conta> listarContas() { return new ArrayList<Conta>(this.contasPIKS.values()); }
	public ArrayList<Cliente> listarClientes() { return new ArrayList<Cliente>(this.clientesCPF.values()); }

	// parte do .csv
	// retirado do projeto 2 do professor Fausto
	public static void lerObjetos() {
      try {
         File f1 = new File((new File(".\\contasPIKS.csv")).getCanonicalPath());
         File f2 = new File((new File(".\\lancamentos.csv")).getCanonicalPath());
         if (!f1.exists() || !f2.exists()) {
            System.out.println("criando arquivo .csv vazio");
            FileWriter arqconta = new FileWriter(f1);
            FileWriter arqlancamento = new FileWriter(f2);
            arqconta.close();
            arqlancamento.close();
            return;
         }
      } catch (Exception var22) {
         throw new RuntimeException("criacao dos arquivos vazios:" + var22.getMessage());
      }

      try {
         File f1 = new File((new File(".\\contasPIKS.csv")).getCanonicalPath());
         Scanner arqconta = new Scanner(f1);
         System.out.println("Repositorio - lendo objetos...");

         String linha;
         String[] partes;
         String chave;
         while(arqconta.hasNextLine()) {
            linha = arqconta.nextLine().trim();
            partes = linha.split(";");
            int id = Integer.parseInt(partes[0]);
            chave = partes[1];
            double saldo = Double.parseDouble(partes[2]);
            double limite = Double.parseDouble(partes[3]);
            int cpf = Integer.parseInt(partes[4]);
            String nome = partes[5];
            Cliente cliente = new Cliente(cpf, nome);
            Object conta;
            if (limite == 0.0) {
               conta = new Conta(id, chave, saldo);
            } else {
               conta = new ContaEspecial(id, chave, saldo, limite);
            }

            cliente.setConta((Conta)conta);
            ((Conta)conta).setCliente(cliente);
            adicionarConta((Conta)conta);
            adicionarCliente(cliente);
         }

         arqconta.close();
         File f2 = new File((new File(".\\lancamentos.csv")).getCanonicalPath());
         Scanner arqlan = new Scanner(f2);

         while(arqlan.hasNextLine()) {
            linha = arqlan.nextLine().trim();
            partes = linha.split(";");
            chave = partes[0];
            LocalDateTime datahora = LocalDateTime.parse(partes[1], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            double valor = Double.parseDouble(partes[2]);
            String tipo = partes[3];
            Lancamento lanc = new Lancamento(datahora, valor, tipo);
            Conta conta = localizarConta(chave);
            conta.adicionar(lanc);
         }

         arqlan.close();
      } catch (Exception var21) {
         throw new RuntimeException("leitura arquivo de contasPIKS:" + var21.getMessage());
      }
   }
   public static void gravarObjetos() {
	try {
	   File f1 = new File((new File(".\\contasPIKS.csv")).getCanonicalPath());
	   FileWriter arqconta = new FileWriter(f1);
	   File f2 = new File((new File(".\\lancamentos.csv")).getCanonicalPath());
	   FileWriter arqlan = new FileWriter(f2);
	   System.out.println("Repositorio - gravando objetos...");
	   Iterator var7 = contasPIKS.values().iterator();

	   while(true) {
		  Conta cta;
		  do {
			 if (!var7.hasNext()) {
				arqconta.close();
				arqlan.close();
				return;
			 }

			 cta = (Conta)var7.next();
			 Double limite;
			 if (cta instanceof ContaEspecial esp) {
				limite = esp.getLimite();
			 } else {
				limite = 0.0;
			 }

			 int var10000 = cta.getId();
			 String linha = "" + var10000 + ";" + cta.getChavePiks() + ";" + cta.getSaldo() + ";" + String.valueOf(limite) + ";" + cta.getCliente().getCpf() + ";" + cta.getCliente().getNome();
			 arqconta.write(linha + "\n");
		  } while(cta.getLancamentos().isEmpty());

		  Iterator var10 = cta.getLancamentos().iterator();

		  while(var10.hasNext()) {
			 Lancamento lan = (Lancamento)var10.next();
			 String s = lan.getDatahora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
			 String var10001 = cta.getChavePiks();
			 arqlan.write(var10001 + ";" + s + ";" + lan.getValor() + ";" + lan.getTipo() + "\n");
		  }
	   }
	} catch (Exception var12) {
	   throw new RuntimeException("problema na criação do arquivo  contasPIKS " + var12.getMessage());
	}
 }

	
}
