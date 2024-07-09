class ContaPoupanca extends Conta {
    private double rendimento;

    public ContaPoupanca(String titular, double saldo, double rendimento) {
        super(titular, saldo);
        this.rendimento = rendimento;
    }

    public void aplicarRendimento() {
        setSaldo(getSaldo() * rendimento);
    }

    @Override
    public void sacar(double valor) {
        if (valor > getSaldo()) {
            throw new IllegalArgumentException("Saldo insuficiente para realizar o saque.");
        }
        setSaldo(getSaldo() - valor);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Titular: " + getTitular());
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Rendimento: " + (rendimento * 100) + "%");
    }
}
