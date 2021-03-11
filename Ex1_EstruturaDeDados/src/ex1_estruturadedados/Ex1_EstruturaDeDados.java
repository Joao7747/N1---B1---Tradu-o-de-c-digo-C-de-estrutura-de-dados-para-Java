/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1_estruturadedados;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Ex1_EstruturaDeDados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        int opcaoMenu = 0;
        Pilha pilha = new Pilha();
        Funcionario func;
        boolean validacaoOpcaoMenu = false;
        boolean validacao = false;

        while (validacao == false) {

            while(validacaoOpcaoMenu == false) {
                try {
                    
                    System.out.println("MENU\n\n1-> empilha 2->desempilha "
                            + " 3->topo 4-> tamanho 5->  Somar");
                    opcaoMenu = Integer.parseInt(scan.nextLine());
                    validacaoOpcaoMenu = true;
                    
                } catch(Exception e)  {
                    
                    System.out.println("Opção inválida");
                    validacaoOpcaoMenu = false;
                }
            }
            
            
            switch (opcaoMenu) {

                case 1:

                    func = new Funcionario();

                    System.out.println(">>Digite o nome que deseja empilhar: ");
                    func.setNome(scan.nextLine());

                    System.out.println(">>Digite o salário que deseja empilhar: ");
                    func.setSalário(Double.parseDouble(scan.nextLine()));
                    pilha.empilha(func);
                    validacao = true;
                    break;

                case 2:

                    func = pilha.desempilha();
                    System.out.println(">>Desempilhado: " + func.getNome() + func.getSalário() + "\n\n");
                    validacao = true;
                    break;

                case 3:

                    func = pilha.retornaTopo();
                    System.out.println(">>Topo: " + func.getNome() + func.getSalário() + "\n\n");

                    System.out.println(">>Tipo: " + pilha.retornaTopo().getNome() + "\r\n" + pilha.retornaTopo().getSalário() + "\n\n");
                    validacao = true;

                    break;

                case 4:

                    System.out.println(">>Tamanho da pilha: " + pilha.tamanho());
                    validacao = true;

                    break;

                case 5:

                    double soma = 0;
                    Pilha pilhaAux = new Pilha();

                    while (pilha.tamanho() > 0) {
                        soma += pilha.retornaTopo().getSalário();
                        pilhaAux.empilha(pilha.desempilha());
                    }
                    while (pilhaAux.tamanho() > 0) {
                        pilha.empilha(pilhaAux.desempilha());
                    }

                    System.out.println("Soma: " + soma);
                    validacao = true;

                    break;

                default:
                    System.out.println("Opção inválida!");
                    validacao = false;
                     
            }
            
             System.out.println("Deseja realizar outra ação? <S/N>?");
             String resp = scan.nextLine();
             
             if(resp.toUpperCase().equals("S"))
             {
                validacao = false;
                validacaoOpcaoMenu = false;
             }
             else{
                validacao = true;
             }

        }

    }

}
