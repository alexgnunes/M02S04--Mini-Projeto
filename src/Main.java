import exceptions.SaldoInsuficienteException;

public class Main {
    public static void main(String[] args) throws SaldoInsuficienteException {

        Banco banco = new Banco();

        ContaCorrente contaCorrente1 = new ContaCorrente("João", 1000.0, 500.0);
        ContaPoupanca contaPoupanca1 = new ContaPoupanca("Maria", 2000.0, 0.05);

        banco.adicionarConta(contaCorrente1);
        banco.adicionarConta(contaPoupanca1);

        System.out.println("Detalhes das contas no banco:");
        banco.detalharContas();
        System.out.println();

        contaCorrente1.depositar(500.0);
        System.out.println("Depósito de R$500.00 realizado na conta de João.");

        try {
            contaCorrente1.sacar(1200.0);
            System.out.println("Saque de R$1200.00 realizado na conta de João.");
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        contaPoupanca1.aplicarRendimento();
        System.out.println("Rendimento aplicado na conta de Maria.");

        try {
            contaPoupanca1.sacar(2500.0);
            System.out.println("Saque de R$2500.00 realizado na conta de Maria.");
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("Detalhes das contas no banco após operações:");
        banco.detalharContas();
    }
}
