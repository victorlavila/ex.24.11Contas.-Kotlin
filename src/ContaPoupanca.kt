class ContaPoupanca(private var limiteDeCredito : Double, numeroDaConta : String) :
        ContaBancaria(numeroDaConta), Imprimivel {

    private val limiteDeCreditoFixo = limiteDeCredito

    override fun depositar(valor: Double) {
        saldo += valor
        println("R$$valor depositados na conta de número $numeroDaConta")
        if(saldo > 0){
            limiteDeCredito = limiteDeCreditoFixo
        }
    }

    override fun sacar(valor: Double) {
       if(valor <= saldo){
           saldo -= valor
           println("R$$valor sacados na conta de número $numeroDaConta")
       } else{
           if(valor <= (saldo + limiteDeCredito)){
               saldo -= valor
               println("R$$valor sacados na conta de número $numeroDaConta")
               if(valor >= limiteDeCredito){
                   limiteDeCredito = 0.0
               } else{
                   limiteDeCredito -= valor
               }
         } else {
                println("Saque não autorizado.")
           }
        }

    }
    override fun mostrarDados() {
        println("Número da Conta: $numeroDaConta")
        println("Saldo: $saldo")
        println("Limete: $limiteDeCredito")
    }

}