import java.util.Date;
import java.util.Scanner;

class Pessoa {
    protected String nome;
    protected Date dataNascimento;

    public Pessoa(String nome, Date dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public int calcularIdade() {
        // Implementação simples para cálculo de idade com base na data atual e data de nascimento.
        Date hoje = new Date();
        return hoje.getYear() - dataNascimento.getYear();
    }
}

class Funcionario extends Pessoa {
    private int matricula;
    private double salario;
    private Date dataAdmissao;

    public Funcionario(String nome, Date dataNascimento, int matricula, double salario, Date dataAdmissao) {
        super(nome, dataNascimento);
        this.matricula = matricula;
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
    }

    public void ajustarSalario(double percentual) {
        this.salario += this.salario * percentual / 100;
    }

    public void promover(String novoCargo) {
        System.out.println("Funcionário promovido para: " + novoCargo);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", idade=" + calcularIdade() +
                ", salario=" + salario +
                '}';
    }
}

class Cliente extends Pessoa {
    private String codigo;
    private String profissao;

    public Cliente(String nome, Date dataNascimento, String codigo, String profissao) {
        super(nome, dataNascimento);
        this.codigo = codigo;
        this.profissao = profissao;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", idade=" + calcularIdade() +
                ", profissao='" + profissao + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando um funcionário
        Funcionario funcionario = new Funcionario("João", new Date(90, 5, 25), 1234, 2500.0, new Date(120, 1, 1));
        funcionario.ajustarSalario(10);
        funcionario.promover("Gerente");

        // Criando um cliente
        Cliente cliente = new Cliente("Maria", new Date(85, 3, 10), "C001", "Advogada");

        // Exibindo os objetos
        System.out.println(funcionario);
        System.out.println(cliente);

        scanner.close();
    }
}
