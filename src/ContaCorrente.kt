open class ContaCorrente(private val txDeoperacao : Double, numeroDaConta : String) : ContaBancaria(numeroDaConta), Imprimivel {


    override fun depositar(valor: Double)  {
            saldo += valor
            saldo -= txDeoperacao
            println("R$$valor depositado na conta de número $numeroDaConta")
    }

    override fun sacar(valor: Double) {
        if(valor <= saldo){
            saldo -= valor
            println("R$$valor sacados na conta de número $numeroDaConta")
            saldo -= txDeoperacao
        } else{
            println("Saque não autorizado!")
        }
    }

    override fun mostrarDados() {
        println("Número da conta: $numeroDaConta")
        println("Saldo: $saldo")
        println("Taxa de operação: $txDeoperacao")
    }

}