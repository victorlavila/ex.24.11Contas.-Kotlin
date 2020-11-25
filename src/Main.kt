fun main() {

    var contaCorrente1 = ContaCorrente(3.0/100)
    var contaPoupanca1 = ContaPoupanca(500.0)
    var relatorio = Relatorio(contaCorrente1, contaPoupanca1)

    contaCorrente1.depositar(500.0)
    contaPoupanca1.depositar(500.0)

    contaCorrente1.sacar(300.0)
    contaPoupanca1.sacar(550.0)

    println("--------------------------------------------------------------------------")

    relatorio.gerarRelatorio()

}