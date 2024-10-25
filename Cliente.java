import java.util.*;

// mantive todos os atributos e métodos que estavam no documento para realizar o trabalho no github. Adicionei getters para obter os dados de todos os atributos, mantive os atributos como privados para serem acessados diretamente somente na própria classe e mantive os demais métodos como públicos para serem acessados em outros pontos fora da classe.

public class Cliente {
    private String nome;
    private String email;
    private String telefone;
    private List<Reserva> reservas = new ArrayList<>(); //lista de instâncias de classe Reserva

    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void fazerReserva(Reserva reserva) {
        reservas.add(reserva);
        reserva.confirmarReserva();
    }

    public void cancelarReserva(Reserva reserva) {
        reservas.remove(reserva);
        reserva.cancelarReserva();
    }
}
