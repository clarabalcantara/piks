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
	public void removerConta(Conta cta) {
		if (cta.getSaldo() == 0) {
			this.contasPIKS.remove(cta.getChavePiks()); 
			this.clientesCPF.remove(cta.getCliente().getCpf());
			cta.getLancamentos().clear();
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
