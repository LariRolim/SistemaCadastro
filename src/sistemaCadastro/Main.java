package sistemaCadastro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;


public class Main {
	
	// Método para exibir todos os funcionários cadastrados
	public static void exibeFuncionario (Funcionario []f ) { 
        for (int i = 0; i < f.length; i++) {
        	System.out.print("Matricula: " + f[i].matricula);
        	System.out.print(" Codigo do cargo: " + f[i].codigo_cargo);
            System.out.print(" Nome: " + f[i].nome);
            System.out.println(" Salario: R$ " + f[i].salario);
        }
   }	
	
	// Método para exibir um único funcionário dado seu indice no vetor
	public static void exibeUnicoFuncionario (Funcionario []f, int i ) { 
        	System.out.print("Matricula: " + f[i].matricula);
        	System.out.print(" Codigo do cargo: " + f[i].codigo_cargo);
            System.out.print(" Nome: " + f[i].nome);
            System.out.println(" Salario: R$ " + f[i].salario);
   }
	
	// Método para cadastrar um novo funcionário
	public static void casdastrarFuncionario(ArrayList<Funcionario> novosFuncionariosCadastrados) {
		Scanner s = new Scanner(System.in);
		Funcionario novoF = new Funcionario();
		System.out.println("Insira a matrícula do novo funcionário");
		novoF.matricula = s.next();
		System.out.println("Insira o código do cargo do novo funcionário");
		novoF.codigo_cargo = s.next();
		System.out.println("Insira o nome do novo funcionário");
		novoF.nome = s.next();
		System.out.println("Insira o salário do novo funcionário");
		novoF.salario = s.nextDouble();
		
		novosFuncionariosCadastrados.add(novoF);
	}
	
	// Método para salvar os cadastros em um arquivo .txt
	public static void salvarCadastros(Funcionario []f, ArrayList<Funcionario> novosFuncionariosCadastrados) {
		Funcionario novof = new Funcionario();
		
		bubblesortMatricula(f); // ordenar vetor da mátricula
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
	
	// Método de ordenação por troca com a matrícula
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
	
	// Método de ordenação por troca com o nome
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
	
	// Método de ordenação por troca com o cargo
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
	
	// Método de ordenação por troca com o salário
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
	
	// Método de pesquisa binária (elementos precisam estar ordenados)
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
				return meio; // retorna a posição onde encontrou a chave
			}
			else {
				return -1; // retorna -1 indicando que não achou a chave
			}
	}
	
	// Método de pesquisa sequencial simples (na ordem em que estão inseridos)
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
			return i; // retorna a posição onde encontrou a chave
		}
		else {
			return -1; // retorna -1 indicando que não achou a chave
		}
	}
	
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
		System.out.println("0 - Sair e Salvar cadastro atual (txt)");
		System.out.println("=======================================\n");
		System.out.print("\n");
	}
	
	
	public static void salarioMenor(Funcionario f []) {
		int i, n = 0, contador = 0;
		Funcionario []novoF;
		
		// Percorre o vetor em busca de salário menor que 1320
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
	
	public static void salarioMaior(Funcionario f []) {
		int i, n = 0, contador = 0;
		Funcionario []novoF;
		
		// Percorre o vetor em busca de salário maior que 1320
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

	public static void salarioIgual(Funcionario f []) {
		int i, n = 0, contador = 0;
		Funcionario []novoF;
		
		// Percorre o vetor em busca de salário igual a 1320
		for(i = 0; i < f.length; i++) {
			if(f[i].salario == 1320.00) {
				contador++;
			}
		}
		
		novoF = new Funcionario[contador];
		
		for(i = 0; i < f.length; i++) {
			if(f[i].salario == 1320.00) {
				novoF[n] = f[i];
				n++;
			}
		}
		
		exibeFuncionario(novoF);
	}
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner s = new Scanner(System.in);
		
		int opcao, opcaoProcura, matriculaInput;
		String nomeInput;
		//declaracao vetor funcionarios
		Funcionario [] f; 
	    f = new Funcionario[0];
	    //declaracao da ArrayList
	    ArrayList<Funcionario> novosFuncionarios = new ArrayList<Funcionario>();
	    
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
	    
		
		do {
			menu();
			opcao = s.nextInt();
			switch (opcao) {
			case 1:
				exibeFuncionario(f);
				break;
			case 2:
				casdastrarFuncionario(novosFuncionarios);
				break;
			case 3:
				System.out.println("Você deseja ordenar os funcionários por nome, código do cargo ou salário?\n0: Nome\n1: Código do cargo\n2: Salário");
				opcaoProcura = s.nextInt();
				if(opcaoProcura == 0) {
					bubblesortNome(f);
					exibeFuncionario(f);
				}
				else if (opcaoProcura == 1) {
					bubblesortCargo(f);
					exibeFuncionario(f);
				}
				else if (opcaoProcura == 2) {
					bubblesortSalario(f);
					exibeFuncionario(f);
				}
				break;
			case 4:
				System.out.println("Você deseja procuar o funcionário pelo sua matricula ou pelo seu nome?\n0: Matricula\n1: Nome");
				opcaoProcura = s.nextInt();
				if(opcaoProcura == 0) {
					System.out.println("Insira a matricula do funcionário(a) que deseja procurar:");
					matriculaInput = s.nextInt();
					exibeUnicoFuncionario(f, buscaBinaria(f, matriculaInput));
				} else if (opcaoProcura == 1) {
					System.out.println("Insira o nome do funcionário(a) que deseja procurar:");
					nomeInput = s.next();
					exibeUnicoFuncionario(f, buscaSequencial(f, nomeInput));
				}
				else {
					System.out.println("Insira uma opção válida");
				}	
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

};