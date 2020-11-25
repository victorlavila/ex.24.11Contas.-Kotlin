class Banco : Imprimivel {

    private val contas = ArrayList<ContaBancaria>()

    fun inserir(contaBancaria: ContaBancaria){
        contas.add(contaBancaria)
    }

    fun remover(contaBancaria: ContaBancaria){
        contas.remove(contaBancaria)
        println("Conta deletada com sucesso!")
    }

    fun procurarConta(numeroConta : String) : ContaBancaria?{
        for(conta in contas){
            if(conta.numeroDaConta == numeroConta){
                return conta
            }
        }
        return null
    }

    override fun mostrarDados() {
        val relatorio = Relatorio()
        for(conta in contas){
            if(conta is ContaCorrente){
                relatorio.gerarRelatorio(conta)
            }
            if(conta is ContaPoupanca){
                relatorio.gerarRelatorio(conta)
            }
        }
    }

}