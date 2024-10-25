import java.util.*;

// mantive todos os atributos e métodos que estavam no documento para realizar o trabalho no github. Adicionei getters para obter os dados de todos os atributos, mantive os atributos como privados para serem acessados diretamente somente na própria classe e mantive os demais métodos como públicos para serem acessados em outros pontos fora da classe.

public class Administrador {
    private String nome;
    private int id;
    private List<Hotel> hoteis = new ArrayList<>(); //lista de instâncias de classe Hotel

    public Administrador(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public List<Hotel> getHoteis() {
        return hoteis;
    }

    public void adicionarHotel(Hotel hotel) {
        hoteis.add(hotel);
    }

    public void removerHotel(String nome) {
        for (Hotel hotel : hoteis) { //percorre os hoteis e remove o hotel que tenha o nome informado
            if(hotel.getNome().equals(nome)) // usei o equals pq == não compara o conteúdo da string em java 
                hoteis.remove(hotel);
        }
    }
}
