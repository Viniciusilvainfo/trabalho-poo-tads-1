import java.time.*;

// mantive todos os atributos e métodos que estavam no documento para realizar o trabalho no github. Adicionei getters para obter os dados de todos os atributos, mantive os atributos como privados para serem acessados diretamente somente na própria classe e mantive os demais métodos como públicos para serem acessados em outros pontos fora da classe.

public class Reserva {
    private Cliente cliente;
    private Quarto quarto;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;

    public Reserva(Cliente cliente, Quarto quarto, LocalDate dataCheckIn, LocalDate dataCheckOut) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public LocalDate getDataCheckIn() {
        return dataCheckIn;
    }

    public LocalDate getDataCheckOut() {
        return dataCheckOut;
    }

    public void confirmarReserva() {
        quarto.reservar();
    }

    public void cancelarReserva() {
        quarto.liberar();
    }
}
