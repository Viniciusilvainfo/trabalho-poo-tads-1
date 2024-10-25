// mantive todos os atributos e métodos que estavam no documento para realizar o trabalho no github. Adicionei getters para obter os dados de todos os atributos, mantive os atributos como privados para serem acessados diretamente somente na própria classe e mantive os demais métodos como públicos para serem acessados em outros pontos fora da classe.

public class Quarto {
    private int numero;
    private String tipo;
    private double preco;
    private boolean estaDisponivel = true;

    public Quarto(int numero, String tipo, double preco) {
        this.numero = numero;
        this.tipo = tipo;
        this.preco = preco;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPreco() {
        return preco;
    }

    public boolean getEstaDisponivel() {
        return estaDisponivel;
    }

    public void reservar() {
        estaDisponivel = false;
    }

    public void liberar() {
        estaDisponivel = true;
    }
}
