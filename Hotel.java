import java.util.*;

// mantive todos os atributos e métodos que estavam no documento para realizar o trabalho no github. Adicionei getters para obter os dados de todos os atributos, mantive os atributos como privados para serem acessados diretamente somente na própria classe e mantive os demais métodos como públicos para serem acessados em outros pontos fora da classe.

public class Hotel {
    private String nome;
    private String endereco;
    private List<Quarto> listaDeQuartos = new ArrayList<>(); //lista de instâncias de classe Quarto

    public Hotel(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public List<Quarto> getListaDeQuartos() {
        return listaDeQuartos;
    }

    public void adicionarQuarto(Quarto quarto) {
        listaDeQuartos.add(quarto);
    }

    public void removerQuarto(int numero) {
        for (Quarto quarto : listaDeQuartos) { //percorre os quartos e remove o quarto que tenha o número informado
            if(quarto.getNumero() == numero)
                listaDeQuartos.remove(quarto);
        }
    }

    public List<Quarto> listarQuartosDisponiveis() {
        List<Quarto> quartos = new ArrayList<>(); //cria um array vazio que vou armazenar os quartos disponíveis
        for (Quarto quarto : quartos) {
            if(quarto.getEstaDisponivel() == true)
                quartos.add(quarto);
        }
        return quartos;
    }
}
