import exceptions.SaldoInsuficienteException;

public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(String titular, double saldo, double limite) {
        super(titular, saldo);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > getSaldo() + this.limite) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque.");
        }
        setSaldo(getSaldo() - valor);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Titular: " + getTitular());
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Limite: " + limite);
    }

}
