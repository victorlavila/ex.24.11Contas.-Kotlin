
    val banco = Banco()

    fun main() {

        menu@ while (true){
            println("1 - Criar conta | 2 - Selecionar conta | 3 - Remover conta | 4 - Gerar relatório")
            println("Outro valor irá finalizar a aplicação")
            when(readLine()) {
                "1" -> escolhaNumeroUm()
                "2" -> escolhaNumeroDois()
                "3" -> escolhaTres()
                "4" -> banco.mostrarDados()
                else -> break@menu
            }
        }

    }

    fun escolhaNumeroUm(){
        when(readLine()){
            "1" -> {
                println("Digite o número da conta: ")
                val numeroConta = readLine()
                println("Digite a taxa de operação")
                val txDeOperacao = readLine()?.toDouble()
                if(txDeOperacao !=null && numeroConta != null){
                    val contaCorrente = ContaCorrente(txDeOperacao, numeroConta)
                    banco.inserir(contaCorrente)
                }
            }
            "2" -> {
                println("Digite o número da conta: ")
                val numeroConta = readLine()
                println("Digite o limite de crédito: ")
                val limite = readLine()?.toDouble()
                if(limite != null && numeroConta != null){
                    val contaPoupanca = ContaPoupanca(limite, numeroConta)
                    banco.inserir(contaPoupanca)
                }
            }
            else -> println("Número inválido")
        }
    }

    private fun escolhaNumeroDois(){
        println("Digite o número da conta: ")
        val numeroConta = readLine()
        if(numeroConta != null){
            val conta = banco.procurarConta(numeroConta)
            if(conta != null){
                println("a - depositar | b - sacar | c - transferir | d - gerar relatório")
                println("Qualquer outro caractere irá retornar para o menu anterior. ")
                when(readLine()) {
                    "a" -> escolhaA(conta)
                    "b" -> escolhaB(conta)
                    "c" -> escolhaC(conta)
                    "d" -> escolhaD(conta)
                }
            } else{
                println("Conta inexistente.")
            }
        }
    }

    private fun escolhaA(conta: ContaBancaria){
        println("Digite o valor: ")
        val deposito = readLine()?.toDouble()
        if(deposito != null){
            conta.depositar(deposito)
        }
    }

    private fun escolhaB(conta: ContaBancaria){
        println("Digite o valor: ")
        val saque = readLine()?.toDouble()
        if(saque != null){
            conta.sacar(saque)
        }
    }

    private fun escolhaC(conta: ContaBancaria){
        println("Digite o valor: ")
        val numeroTransferencia = readLine()
        if(numeroTransferencia != null){
            val contaTransferencia = banco.procurarConta(numeroTransferencia)
            if(contaTransferencia != null){
                println("Valor que deseja transferir: ")
                val valorTransferencia = readLine()?.toDouble()
                if(valorTransferencia != null){
                    conta.transferir(valorTransferencia, contaTransferencia)
                }
            }else {
                println("Conta inexistente")
            }
        }
    }

    private fun escolhaD(conta: ContaBancaria){
        val relatorio = Relatorio()
        if(conta is ContaCorrente){
            relatorio.gerarRelatorio(conta)
        }
        if(conta is ContaPoupanca){
            relatorio.gerarRelatorio(conta)
        }
    }

    private fun escolhaTres(){
        println("Digite o número da conta: ")
        val numeroConta = readLine()
        if(numeroConta != null){
            val conta = banco.procurarConta(numeroConta)
            if(conta != null){
                banco.remover(conta)
            } else {
                println("Conta inexistente! ")
            }
        }
    }