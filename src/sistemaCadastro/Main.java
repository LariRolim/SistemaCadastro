package sistemaCadastro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;



public class Main {
	
	//declaracao vetor funcionarios
	static Funcionario [] f = new Funcionario[0];
    //declaracao da ArrayList
    static ArrayList<Funcionario> novosFuncionarios = new ArrayList<Funcionario>();
    //declaracao scanner
    static Scanner s = new Scanner(System.in);
    
    // lê o cadastro dos funcionários de um arquivo txt e preenche o vetor de Funcionários
    public static void lerCadastros () {
    	File file = new File("C:\\Users\\manue\\eclipse-workspace\\sistema_cadastro\\src\\sistemaCadastro\\cadastros.txt");
		int tamanho;

	    try (Scanner scanner = new Scanner(file)) {
	    	tamanho = Integer.parseInt(scanner.next());
	    	f = new Funcionario[tamanho];
	    	for (int i = 0; i < tamanho; i++) {
	    		f[i] = new Funcionario();
	    		f[i].matricula = scanner.next();
	    		f[i].codigo_cargo = scanner.next();
	            f[i].nome = scanner.next();
	            f[i].salario = Double.parseDouble(scanner.next());
	           }
	    } catch (FileNotFoundException ex) {
	            ex.printStackTrace();
	    }     
    }
	
    // exibe todos os funcionários do vetor
	public static void exibeFuncionario (Funcionario []f ) { 
        for (int i = 0; i < f.length; i++) {
        	System.out.print("Matricula: " + f[i].matricula);
        	System.out.print(" Codigo do cargo: " + f[i].codigo_cargo);
            System.out.print(" Nome: " + f[i].nome);
            System.out.println(" Salario: R$ " + f[i].salario);
        }
   }
	
	// exibe um único funcionário do vetor, dado seu indíce
	public static void exibeUnicoFuncionario (Funcionario []f, int i ) { 
        	System.out.print("Matricula: " + f[i].matricula);
        	System.out.print(" Codigo do cargo: " + f[i].codigo_cargo);
            System.out.print(" Nome: " + f[i].nome);
            System.out.println(" Salario: R$ " + f[i].salario);
   }

	// usa da coleção ArrayList para cadastrar n funcionários
	public static void casdastrarFuncionario(ArrayList<Funcionario> novosFuncionariosCadastrados) {
		Scanner scanner = new Scanner(System.in);
		Funcionario novoF = new Funcionario();
		System.out.println("Insira a matrícula do novo funcionário");
		novoF.matricula = scanner.next();
		System.out.println("Insira o código do cargo do novo funcionário");
		novoF.codigo_cargo = scanner.next();
		System.out.println("Insira o nome do novo funcionário");
		novoF.nome = scanner.next();
		System.out.println("Insira o salário do novo funcionário");
		novoF.salario = scanner.nextDouble();
		
		novosFuncionariosCadastrados.add(novoF);
	}

	// subescreve o cadastro atual com o novo número de funcionários, os funcionários antigos e os funcionários recém cadastrados
	public static void salvarCadastros(Funcionario []f, ArrayList<Funcionario> novosFuncionariosCadastrados) {
		Funcionario novof = new Funcionario();
		// ordernar os cadastros por matricula antes de salvar
		bubblesortMatricula(f);
		// subscrever cadastros.txt com cadastros antigos + cadastros novos
        try {
            File arquivo = new File("C:\\Users\\manue\\eclipse-workspace\\sistema_cadastro\\src\\sistemaCadastro\\cadastros.txt");
            FileWriter writer = new FileWriter(arquivo);
            
            writer.write(String.valueOf(f.length + novosFuncionariosCadastrados.size()));
            for (int i = 0; i < f.length; i++) {
            	writer.write('\n' + f[i].matricula + " " + f[i].codigo_cargo + " " + f[i].nome + " " + f[i].salario);
            }
            for (int i = 0; i < novosFuncionariosCadastrados.size(); i++) {
            	novof = novosFuncionariosCadastrados.get(i);
            	writer.write("\n" + novof.matricula + " " + novof.codigo_cargo + " " + novof.nome + " " + novof.salario);
  		    }
            writer.close();

            System.out.println("O cadastro atual foi salvo com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	// algoritmo de ordenação para ordenar o vetor funcionários pela matrícula
	public static void bubblesortMatricula (Funcionario f []) {
		int i, fim, pos;
		Funcionario chave;
		boolean troca;
		fim = f.length - 2; pos = 0;
		do {
			troca = false;
			for (i = 0; i <= fim; i++) {
				if (f[i].matricula.compareTo(f[i + 1].matricula) > 0) {
					chave = f[i]; 
					f[i] = f[i+1]; 
					f[i+1] = chave;
					
					pos = i; 
					troca = true;
				}
			}
			fim = pos-1;
		} while (troca == true);
	}
	
	// algoritmo de ordenação para ordenar o vetor funcionários pelo nome
	public static void bubblesortNome (Funcionario f []) {
		int i, fim, pos;
		Funcionario chave;
		boolean troca;
		fim = f.length - 2; pos = 0;
		do {
			troca = false;
			for (i = 0; i <= fim; i++) {
				if (f[i].nome.compareTo(f[i + 1].nome) > 0) {
					chave = f[i]; 
					f[i] = f[i+1]; 
					f[i+1] = chave;
					
					pos = i; 
					troca = true;
				}
			}
			fim = pos-1;
		} while (troca == true);
	}
	
	// algoritmo de ordenação para ordenar o vetor funcionários pelo cargo
	public static void bubblesortCargo (Funcionario f []) {
		int i, fim, pos;
		Funcionario chave;
		boolean troca;
		fim = f.length - 2; pos = 0;
		do {
			troca = false;
			for (i = 0; i <= fim; i++) {
				if (f[i].codigo_cargo.compareTo(f[i + 1].codigo_cargo) > 0) {
					chave = f[i]; 
					f[i] = f[i+1]; 
					f[i+1] = chave;
					
					pos = i; 
					troca = true;
				}
			}
			fim = pos-1;
		} while (troca == true);
	}
	
	// algoritmo de ordenação para ordenar o vetor funcionários pelo salário
	public static void bubblesortSalario (Funcionario f []) {
		int i, fim, pos;
		Funcionario chave;
		boolean troca;
		fim = f.length - 2; 
		pos = 0;
		do {
			troca = false;
			for (i = 0; i <= fim; i++) {
				if (f[i].salario > f[i + 1].salario) {
					chave = f[i]; 
					f[i] = f[i+1]; 
					f[i+1] = chave;
					
					pos = i; 
					troca = true;
				}
			}
			fim = pos-1;
		} while (troca == true);
	}

	// recebe entrada do usuário para escolher de que forma será a ordenação dos funcionários
	public static void escolherOpcaoDeOrdenacao (int opcao) {
		if (opcao == 1) {
			bubblesortMatricula(f);
			exibeFuncionario(f);
		} else if(opcao == 2) {
			bubblesortNome(f);
			exibeFuncionario(f);
		} else if (opcao == 3) {
			bubblesortCargo(f);
			exibeFuncionario(f);
		} else if (opcao == 4) {
			bubblesortSalario(f);
			exibeFuncionario(f);
		} else {
			System.out.println("Essa opção é inválida.");
		}
		
	}
	
	// recebe entrada do usuário para escolher a forma de busca
	public static void escolherOpcaoDeBusca (int opcao) {
		int matriculaInput;
		String nomeInput;
		
		if(opcao == 1) {
			System.out.println("Insira a matricula do funcionário(a) que deseja procurar:");
			matriculaInput = s.nextInt();
			exibeUnicoFuncionario(f, buscaBinaria(f, matriculaInput));
		} else if (opcao == 2) {
			System.out.println("Insira o nome do funcionário(a) que deseja procurar:");
			nomeInput = s.next();
			exibeUnicoFuncionario(f, buscaSequencial(f, nomeInput));
		}
		else {
			System.out.println("Insira uma opção válida");
		}	
	}
	
	// algoritmo de busca binaria para procurar funcionário pela matrícula
	public static int buscaBinaria (Funcionario f[ ], int chave) {
		int n = f.length;
		int inicio = 0, meio = Math.round(f.length / 2), fim = n - 1;
		boolean achou = false;
		while (inicio <= fim){
			meio = (inicio + fim) / 2;
			if (Integer.parseInt(f[meio].matricula) == chave) {
				achou = true;
				break;
			}
			else if (Integer.parseInt(f[meio].matricula) > chave) {
				fim = meio - 1;
			}
			else {
				inicio = meio + 1;
			}
		}
			if (achou == true){
				return meio; 
			}
			else {
				return -1; 
			}
	}
	
	// algoritmo de busca sequencial para procurar funcionário pela nome
	public static int buscaSequencial (Funcionario f[ ], String procurado) {
		int i;
		boolean achou = false;
		
		for (i = 0; i < f.length; i++) {
			if ((f[i].nome).compareTo(procurado) == 0) {
				achou = true;
				break;
			}
		}
		if (achou == true) {
			return i; 
		}
		else {
			return -1;
		}
	}

	// exibe menu de opções para o funcionário interagir com o sistema
	public static void menu() {
		System.out.println("\n\n######## SISTEMA DE CADASTROS ########");
		System.out.println("\n=======================================");
		System.out.println("1 - Ler cadastros");
		System.out.println("2 - Casdatrar funcionário");
		System.out.println("3 - Ordenar funcionários");
		System.out.println("4 - Procurar funcionário");
		System.out.println("5 - Funcionários c/ salário > 1320,00");
		System.out.println("6 - Funcionários c/ salário < 1320,00");
		System.out.println("7 - Funcionários c/ salário == 1320,00");
		System.out.println("0 - Salvar cadastro atual e sair");
		System.out.println("=======================================\n");
		System.out.print("\n");
	}
	
	// filtra os funcionários com salário < 1320.00
	public static void salarioMenor(Funcionario f []) {
		int i, n = 0, contador = 0;
		Funcionario []novoF;
		
		for(i = 0; i < f.length; i++) {
			if(f[i].salario < 1320.00) {
				contador++;
			}
		}
		
		novoF = new Funcionario[contador];
		
		for(i = 0; i < f.length; i++) {
			if(f[i].salario < 1320.00) {
				novoF[n] = f[i];
				n++;
			}
		}
		
		exibeFuncionario(novoF);
	}
	
	// filtra os funcionários com salário > 1320.00
	public static void salarioMaior(Funcionario f []) {
		int i, n = 0, contador = 0;
		Funcionario []novoF;
		
		for(i = 0; i < f.length; i++) {
			if(f[i].salario > 1320.00) {
				contador++;
			}
		}
		
		novoF = new Funcionario[contador];
		
		for(i = 0; i < f.length; i++) {
			if(f[i].salario > 1320.00) {
				novoF[n] = f[i];
				n++;
			}
		}
		
		exibeFuncionario(novoF);
	}

	// filtra os funcionários com salário == 1320.00
	public static void salarioIgual(Funcionario f []) {
		// declarando variáveis
		int i, n = 0, contador = 0;
		// declarando o vetor
		Funcionario []novoF;
		
		// percorrendo o vetor e contando quantos funcionários se encaixam na condição
		for(i = 0; i < f.length; i++) {
			if(f[i].salario == 1320.00) {
				contador++;
			}
		}
		
		// atribuindo um novo vetor com o tamanho do contador à variável novoF
		novoF = new Funcionario[contador];
		
		// percorrendo vetor funcionários novamente e adicionando os funcionários que se encaixam na condição ao novo vetor
		for(i = 0; i < f.length; i++) {
			if(f[i].salario == 1320.00) {
				novoF[n] = f[i];
				n++;
			}
		}
		
		exibeFuncionario(novoF);
	}
	
	// programa principal
	public static void main(String[] args) {
		int opcao, opcaoProcura;
		
		lerCadastros();
		
		do {
			menu();
			opcao = s.nextInt();
			switch (opcao) {
			case 1:
				lerCadastros();
				System.out.println("Os cadastros foram lidos com sucesso!");
				break;
			case 2:
				casdastrarFuncionario(novosFuncionarios);
				System.out.println("Funcionário cadastrado com sucesso!");
				break;
			case 3:	
				System.out.println("Você deseja ordenar os funcionários por nome, código do cargo ou salário?\n1: Matrícula\n2: Nome\n3: Código do cargo\n4: Salário");
				opcaoProcura = s.nextInt();
				escolherOpcaoDeOrdenacao(opcaoProcura);
				break;
			case 4:
				System.out.println("Você deseja procuar o funcionário pelo sua matricula ou pelo seu nome?\n1: Matricula\n2: Nome");
				opcaoProcura = s.nextInt();
				escolherOpcaoDeBusca(opcaoProcura);		
				break;
			case 5:
				salarioMaior(f);
				break;
			case 6:
				salarioMenor(f);
				break;
			case 7:
				salarioIgual(f);
				break;
			case 0:
				lerCadastros();
				salvarCadastros(f, novosFuncionarios);
				System.out.println("Até a próxima");
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
				}
			} while (opcao != 0);
		s.close();
	}

}