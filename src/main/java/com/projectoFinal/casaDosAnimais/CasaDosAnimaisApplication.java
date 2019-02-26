package com.projectoFinal.casaDosAnimais;

import java.text.SimpleDateFormat;
import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projectoFinal.casaDosAnimais.DAO.AnimalDAO;
import com.projectoFinal.casaDosAnimais.DAO.AuxiliarDAO;
import com.projectoFinal.casaDosAnimais.DAO.CategoriaDAO;
import com.projectoFinal.casaDosAnimais.DAO.ClienteDAO;
import com.projectoFinal.casaDosAnimais.DAO.EnderecoDAO;
import com.projectoFinal.casaDosAnimais.DAO.EspecieDAO;
import com.projectoFinal.casaDosAnimais.DAO.FornecedorDAO;
import com.projectoFinal.casaDosAnimais.DAO.MarcacaoDAO;
import com.projectoFinal.casaDosAnimais.DAO.ProdutoDAO;
import com.projectoFinal.casaDosAnimais.DAO.ProvinciaDAO;
import com.projectoFinal.casaDosAnimais.DAO.RacaDAO;
import com.projectoFinal.casaDosAnimais.DAO.TipoMarcacaoDAO;
import com.projectoFinal.casaDosAnimais.DAO.VeterinarioDAO;
import com.projectoFinal.casaDosAnimais.DAO.MunicipioDAO;
import com.projectoFinal.casaDosAnimais.dominio.Animal;
import com.projectoFinal.casaDosAnimais.dominio.Auxiliar;
import com.projectoFinal.casaDosAnimais.dominio.Categoria;
import com.projectoFinal.casaDosAnimais.dominio.Cliente;
import com.projectoFinal.casaDosAnimais.dominio.Endereco;
import com.projectoFinal.casaDosAnimais.dominio.Especie;
import com.projectoFinal.casaDosAnimais.dominio.Fornecedor;
import com.projectoFinal.casaDosAnimais.dominio.Marcacao;
import com.projectoFinal.casaDosAnimais.dominio.Produto;
import com.projectoFinal.casaDosAnimais.dominio.Provincia;
import com.projectoFinal.casaDosAnimais.dominio.Raca;
import com.projectoFinal.casaDosAnimais.dominio.TipoMarcacao;
import com.projectoFinal.casaDosAnimais.dominio.Veterinario;
import com.projectoFinal.casaDosAnimais.dominio.Municipio;


@SpringBootApplication
public class CasaDosAnimaisApplication implements CommandLineRunner {

	@Autowired
	private CategoriaDAO categoriaRepo; 
	
	@Autowired
	private ProdutoDAO produtoRepo;
	
	
	@Autowired
	private FornecedorDAO fornecedorRepo;
	
	
	@Autowired
	private ProvinciaDAO provinciaRepo;
	
	
	@Autowired
	private MunicipioDAO municipioRepo;
	
	
	@Autowired
	private EnderecoDAO enderecoRepo;
	
	
	@Autowired
	private ClienteDAO clienteRepo;
	
	
	@Autowired
	private RacaDAO racaRepo;
	
	
	@Autowired
	private EspecieDAO especieRepo;
	
	
	@Autowired
	private AnimalDAO animalRepo;
	
	
	@Autowired
	private MarcacaoDAO marcacaoRepo;
	
	@Autowired
	private AuxiliarDAO auxiliarRepo;
	
	@Autowired
	private TipoMarcacaoDAO tipoMarcacaoRepo;
	
	@Autowired
	private VeterinarioDAO veterinarioRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CasaDosAnimaisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Fornecedor f1=new Fornecedor(null,"Oracle","oracle@angola.co.ao");
		Fornecedor f2=new Fornecedor(null,"IBM","ibm@angola.co.ao");
		
		Categoria cat1= new Categoria(null,"Informatica");
		Categoria cat2= new Categoria (null,"Oficce");
		Categoria cat3= new Categoria (null,"Programacao");	
		
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		
		Produto p1 = new Produto(null,"computador",2000.00, f1);
		Produto p2 = new Produto(null,"Impressora",1200.00,f2);
		Produto p3 = new Produto(null,"Mause",800.00,f1);
		Produto p4= new Produto(null,"Java",200.00,f2);
		
		Provincia prov1 = new Provincia (null,"Luanda");
		Provincia prov2 = new Provincia (null,"Bengo");
		Provincia prov3 = new Provincia (null,"Kwanza Sul");
		
		Municipio municipio1 = new Municipio(null,"Belas",prov1);
		Municipio municipio2 = new Municipio(null,"Ingombota",prov1);
		Municipio municipio3 = new Municipio(null,"Cacuaco",prov1);
		Municipio municipio4 = new Municipio(null,"Caxito",prov2);
		Municipio municipio5 = new Municipio(null,"Cabo Ledo",prov2);
		Municipio municipio6 = new Municipio(null,"Kibala",prov3);
		Municipio municipio7 = new Municipio(null,"Porto Amboim",prov3);
		
		Cliente cliente1= new Cliente(null,"Melquisedec","melquisedec@ad",sdf.parse("12/04/1985 10:32"));
		cliente1.getTelefones().addAll(Arrays.asList("9238883838","938282828"));
		
		Cliente cliente2= new Cliente(null,"Maria","maria@ad",sdf.parse("30/12/1988 10:32"));
		cliente2.getTelefones().addAll(Arrays.asList("9132883838","901082828"));
		
		Endereco e1=new Endereco(null,"Apt 71","Rua Umbi Umbi","Bairro Precol",municipio2,cliente1);
		Endereco e2=new Endereco(null,"Vivenda 2","Rua KKK5000 ","Bairro Kilamba",municipio1,cliente2);
		Endereco e3=new Endereco(null,"Apt 72","Rua Umbi Umbi","Bairro Precol",municipio2,cliente1);
		
		Raca raca1= new Raca(null,"PitBull");
		Raca raca2= new Raca(null,"BullDog");

		
		Especie especie1= new Especie(null,"Cao", raca1);	
		raca1.setEspecie(especie1);
		
		Especie especie2= new Especie(null,"Gato", raca2);		
		raca2.setEspecie(especie2);
			
		
		Animal animal1= new Animal(null,"Pluto","Macho","Preto",sdf.parse("10/08/2018 10:32"),especie1,cliente2);
		Animal animal2= new Animal(null,"Max","Macho","Branco",sdf.parse("11/09/2013 21:32"),especie2,cliente1);
		Animal animal3= new Animal(null,"Vlad","Femea","Castanho",sdf.parse("12/11/2018 10:32"),especie1,cliente2);
		
		cliente1.getEnderecos().addAll(Arrays.asList(e1,e3));
		cliente2.getEnderecos().addAll(Arrays.asList(e2));

		cliente1.getAnimais().addAll(Arrays.asList(animal2));
		cliente2.getAnimais().addAll(Arrays.asList(animal1,animal3));
		
		especie1.getAnimais().addAll(Arrays.asList(animal1,animal3));
		especie2.getAnimais().addAll(Arrays.asList(animal2));
		
		prov1.getMunicipios().addAll(Arrays.asList(municipio1,municipio2,municipio3));
		prov2.getMunicipios().addAll(Arrays.asList(municipio4,municipio5));
		prov3.getMunicipios().addAll(Arrays.asList(municipio6,municipio7));
		
		f1.getProdutos().addAll(Arrays.asList(p1,p3));
		f2.getProdutos().addAll(Arrays.asList(p2,p4));
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		cat3.getProdutos().addAll(Arrays.asList(p4,p1));
				
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat3,cat2));
		
		
		TipoMarcacao tpm1= new TipoMarcacao(null,"Consulta Routina");
		TipoMarcacao tpm2= new TipoMarcacao(null,"Consulta Urgencia");
		
		Auxiliar aux1= new Auxiliar(null,"Maria","escrituraria",sdf.parse("04/11/1980 11:32"));
		Auxiliar aux2= new Auxiliar(null,"Manuela","escrituraria",sdf.parse("10/08/1988 11:00"));		
		
		Veterinario vet1= new Veterinario(null,"Miguel Santos","miguelsanto@casadosAnimais",2333,"Cirurgia",sdf.parse("19/01/1970 11:00"));
		
		Marcacao marcacao1 = new Marcacao(null,sdf.parse("19/01/2019 11:00"),"Consulta Marcada",aux1,tpm1,vet1,animal1);		
		Marcacao marcacao2 = new Marcacao(null,sdf.parse("19/01/2019 15:00"),"Consulta Marcada",aux2,tpm2,vet1,animal1);	
		
		tpm1.getMarcacoes().addAll(Arrays.asList(marcacao1));
		tpm2.getMarcacoes().addAll(Arrays.asList(marcacao2));
		
		vet1.getMarcacoes().addAll(Arrays.asList(marcacao1,marcacao2));
		aux1.getMarcacoes().addAll(Arrays.asList(marcacao1));
		aux2.getMarcacoes().addAll(Arrays.asList(marcacao2));
		animal1.getMarcacoes().addAll(Arrays.asList(marcacao1,marcacao2));
		
		provinciaRepo.saveAll(Arrays.asList(prov1,prov2,prov3));
		municipioRepo.saveAll(Arrays.asList(municipio1,municipio2,municipio3,municipio4,municipio5,municipio6,municipio7));
		
		fornecedorRepo.saveAll(Arrays.asList(f1,f2));	
		categoriaRepo.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6,cat7));   		
		produtoRepo.saveAll(Arrays.asList(p1,p2,p3,p4));  		
			
		clienteRepo.saveAll(Arrays.asList(cliente1,cliente2));
		enderecoRepo.saveAll(Arrays.asList(e1,e2,e3));
		
		
		racaRepo.saveAll(Arrays.asList(raca1,raca2));
		especieRepo.saveAll(Arrays.asList(especie1,especie2));
		
		animalRepo.saveAll(Arrays.asList(animal1,animal2,animal3));
		
		auxiliarRepo.saveAll(Arrays.asList(aux1,aux2));	
		veterinarioRepo.saveAll(Arrays.asList(vet1));
		tipoMarcacaoRepo.saveAll(Arrays.asList(tpm1,tpm2));
		marcacaoRepo.saveAll(Arrays.asList(marcacao1,marcacao2));		
		
	}

}

