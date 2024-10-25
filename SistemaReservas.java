import java.time.*;
import java.util.*;

// mantive todos os atributos e métodos que estavam no documento para realizar o trabalho no github. Adicionei getters para obter os dados de todos os atributos, mantive os atributos como privados para serem acessados diretamente somente na própria classe e mantive os demais métodos como públicos para serem acessados em outros pontos fora da classe.

public class SistemaReservas {

    private List<Hotel> hoteis = new ArrayList<>(); //lista de instâncias de classe Hoteis
    private List<Cliente> clientes = new ArrayList<>(); //lista de instâncias de classe Clientes

    public void adicionarHotel() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("nome do hotel");
        String nome = scanner.nextLine(); // pega a linha toda contando os espaços em branco

        System.out.println("endereço do hotel");
        String endereco = scanner.nextLine();

        hoteis.add(new Hotel(nome, endereco));
    }

    public void listarHoteis() {
        System.out.println("hotéis disponíveis");

        for (Hotel hotel : hoteis) {
            System.out.println(hotel.getNome() + " localizado em: " + hotel.getEndereco());
        }
    }

    public void adicionarQuarto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("nome do hotel");
        String nomeHotel = scanner.nextLine();
        
        Hotel hotel = existeHotel(nomeHotel);

        if(hotel == null){
            System.out.println("nenhum hotel encontrado com esse nome tente novamente");
            return;
        }

        System.out.println("número do quarto");
        int numero = scanner.nextInt();

        System.out.println("tipo do quarto");
        String tipo = scanner.nextLine();

        System.out.println("preço do quarto");
        double preco = scanner.nextDouble();

        hotel.adicionarQuarto(new Quarto(numero, tipo, preco));
    }

    public void listarQuartosDisponiveis() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("nome do hotel");
        String nomeHotel = scanner.nextLine();

        Hotel hotel = existeHotel(nomeHotel);

        if(hotel == null){
            System.out.println("nenhum hotel encontrado com esse nome tente novamente");
            return;
        }

        List<Quarto> quartos = hotel.listarQuartosDisponiveis();

        for (Quarto quarto : quartos) {
            System.out.println(quarto);
        }
    }

    public void fazerReserva() {
        Scanner scanner = new Scanner(System.in);

        Cliente cliente = adicionarCliente();

        System.out.println("nome do hotel");
        String nomeHotel = scanner.nextLine();

        Hotel hotel = existeHotel(nomeHotel);

        if(hotel == null){
            System.out.println("nenhum hotel encontrado com esse nome tente novamente");
            return;
        }

        System.out.println("número do quarto");
        int numeroQuarto = scanner.nextInt();

        Quarto quarto = existeQuarto(hotel, numeroQuarto);

        if(quarto == null || !quarto.getEstaDisponivel()) {
            System.out.println("nenhum quarto encontrado com esse número tente novamente");
            return;
        }

        System.out.println("data de check in");
        LocalDate checkIn = LocalDate.parse(scanner.nextLine());

        System.out.println("data de check out");
        LocalDate checkOut = LocalDate.parse(scanner.nextLine());

        Reserva reserva = new Reserva(cliente, quarto, checkIn, checkOut);
        cliente.fazerReserva(reserva);

        System.out.println("reserva realizada com sucesso");
    }

    public void cancelarReserva() {
        Scanner scanner = new Scanner(System.in);

        Cliente cliente = adicionarCliente();

        System.out.println("nome do hotel");
        String nomeHotel = scanner.nextLine();

        Hotel hotel = existeHotel(nomeHotel);

        if(hotel == null){
            System.out.println("nenhum hotel encontrado com esse nome tente novamente");
            return;
        }

        System.out.println("número do quarto");
        int numeroQuarto = scanner.nextInt();

        Quarto quarto = existeQuarto(hotel, numeroQuarto);

        if(quarto == null || quarto.getEstaDisponivel() != true) {
            System.out.println("nenhum quarto encontrado com esse número tente novamente");
            return;
        }

        List<Reserva> reservas = cliente.getReservas();

        for (Reserva reserva : reservas) {
            if(reserva.getQuarto().getNumero() == numeroQuarto) {
                cliente.cancelarReserva(reserva);
                System.out.println("reserva cancelada com sucesso");
                break;
            }
        }

        System.out.println("erro ao cancelar reserva tenta novamente");
    }

    public void listarReservasCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("nome do cliente");
        String nomeCliente = scanner.nextLine();

        Cliente cliente = existeCliente(nomeCliente);

        if(cliente == null) {
            System.out.println("cliente não encontrado tente novamente");
            return;
        }

        List<Reserva> reservas = cliente.getReservas();

        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }

    public Cliente adicionarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("nome do cliente");
        String nomeCliente = scanner.nextLine();

        Cliente cliente = existeCliente(nomeCliente);

        if(cliente == null) {
            System.out.println("email do cliente");
            String email = scanner.nextLine();

            System.out.println("telefone do cliente");
            String telefone = scanner.nextLine();

            cliente = new Cliente(nomeCliente, email, telefone);
            clientes.add(cliente);
        }

        return cliente;
    }

    public Hotel existeHotel(String nome) {
        Hotel hotelExistente = null;

        for (Hotel hotel : hoteis) { //percorre os hoteis e obtem o hotel que tenha o nome informado
            if(hotel.getNome().equals(nome)) // usei o equals pq == não compara o conteúdo da string em java 
                hotelExistente = hotel;
        }

        return hotelExistente;
    }

    public Quarto existeQuarto(Hotel hotel, int numero) {
        Quarto quartoExistente = null;

        List<Quarto> quartos = hotel.listarQuartosDisponiveis();
        for (Quarto quarto : quartos) { //percorre os quartos disponíveis e obtem o quarto que tenha o número informado
            if(quarto.getNumero() == numero)
                quartoExistente = quarto;
        }

        return quartoExistente;
    }

    public Cliente existeCliente(String nome) {
        Cliente clienteExistente = null;

        for (Cliente cliente : clientes) { //percorre os clientes e obtem o cliente que tenha o nome informado
            if(cliente.getNome().equals(nome)) // usei o equals pq == não compara o conteúdo da string em java 
                clienteExistente = cliente;
        }

        return clienteExistente;
    }
}
