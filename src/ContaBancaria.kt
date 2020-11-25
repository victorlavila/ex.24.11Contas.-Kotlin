abstract class ContaBancaria (val numeroDaConta : String) {
    init{
        println("Conta número $numeroDaConta criada com sucesso!")
    }

    protected var saldo : Double = 0.0

    abstract fun sacar(valor : Double)

    abstract fun depositar(valor : Double)

    fun transferir(valor : Double, conta: ContaBancaria){
        if(conta === this){
            println("Você não pode transferir para si mesmo")
        } else{
            val saldoOriginal = saldo
            sacar(valor)
            if(saldo != saldoOriginal){
                conta.depositar(valor)
                println("Transferência realizada da conta $numeroDaConta para a conta ${conta.numeroDaConta} no valor de $valor")
            }
        }
    }

}