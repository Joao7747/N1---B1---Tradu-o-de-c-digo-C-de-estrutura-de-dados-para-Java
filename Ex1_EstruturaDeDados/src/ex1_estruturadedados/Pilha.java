package ex1_estruturadedados;

public class Pilha {
    
    
    private final int capacidade = 10;
    private Funcionario[] dados = new Funcionario[capacidade];
    private int topo = 0;
    
    public int tamanho()
    {
        return topo;   
    }
    
    public void empilha(Funcionario p_valor) throws Exception
    {
        if (tamanho() != capacidade)
        {
            topo++;
            dados[topo] = p_valor;
        }
        else
        {
            throw new Exception("A pilha está cheia!!!");
        }
    }
    public Funcionario desempilha() throws Exception
    {
        if (tamanho() == 0)            
            throw new Exception("A pilha está vazia!!!");            
        else
        {
            Funcionario retorno = dados[topo];
            dados[topo] = null;
            topo--;
            return retorno;
        }
    }
    public Funcionario retornaTopo() throws Exception
    {
        if (tamanho() == 0)
            throw new Exception("A pilha está vazia!!!");
        else
            return dados[topo];
    }
     
}
