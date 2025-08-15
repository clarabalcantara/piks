package piks;
import java.util.TreeMap;
import java.util.ArrayList;
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

	public void gravarObjetos(){

	}

	public void lerObjetos(){
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
