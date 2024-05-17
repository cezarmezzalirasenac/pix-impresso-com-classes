import java.util.ArrayList;
import java.util.Scanner;

import classes.CaixaEletronico;
import classes.Conta;
import classes.ContaCorrente;
import classes.ContaPoupanca;
import classes.ContaSalario;
import classes.Transacao;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Conta> contas = new ArrayList<Conta>();
        contas.add(new ContaCorrente(1, 123,
                1234, 0,
                "Cezar Mezzalira",
                "123.456.789-00",
                "1234567891234567", "123", 5000));
        contas.add(new ContaSalario(2, 123,
                1234, 0,
                "Cezar Mezzalira",
                "123.456.789-00",
                "1234567891234563", "123", 2000));

        contas.add(new ContaPoupanca(3, 123,
                1234, 0,
                "Cezar Mezzalira",
                "123.456.789-00",
                "1234567891234562", "123", 50));

        // TODO - Criar uma lista de caixas eletronicos
        ArrayList<CaixaEletronico> caixas = new ArrayList<CaixaEletronico>();

        // TODO - Criar objetos do tipo caixa eletronico
        caixas.add(new CaixaEletronico(1,
                "PB-Centro",
                10000));
        caixas.add(new CaixaEletronico(2,
                "PB-GralhaAzul",
                5000));
        caixas.add(new CaixaEletronico(3,
                "PB-Planalto",
                5000));

        // Lista de transacoes
        ArrayList<Transacao> transacoes = new ArrayList<Transacao>();

        Scanner scanner = new Scanner(System.in);
        // ENTRADA
        // 1 - Ir até um caixa eletrônico
        // 2 - Inserir o cartão
        // 2.1 - Ler os dados do cartão
        System.out.println("Insira o numero do cartão: ");
        String numeroCartao = scanner.nextLine();

        // Buscando a conta pelo número do cartão
        Conta contaSaque = null;
        // para cada item da lista atribua o valor para a variavel conta
        for (Conta conta : contas) {

            // se o número do cartão for igual ao número do cartão de uma conta
            if (conta.getNumeroCartao().equals(numeroCartao)) {
                contaSaque = conta;
                break;
            }
        }

        // se a conta for nula, vai mostrar um erro e terminar o programa
        if (contaSaque == null) {
            scanner.close();
            throw new Error("Conta não encontrada");
        }

        // 3 - Inserir a senha
        System.out.println("Insira a senha: ");
        String senha = scanner.nextLine();

        // 4 - Validar a senha (processamento intermediario)
        // se a senha estiver incorreta, vai mostrar um erro e terminar o programa
        if (!contaSaque.getSenha().equals(senha)) {
            scanner.close();
            throw new Error("Senha inválida");
        }
        // 5 - Informar o valor do saque
        System.out.println("Informe o valor do saque");
        double valorSaque = scanner.nextDouble();
        // TODO - 5.1 - Informar o id do Caixa Eletronico
        System.out.println("Informe o ID do Caixa Eletrônico");
        int idCaixaEletronico = scanner.nextInt();

        scanner.close();

        // TODO - 5.2 - Buscar o caixa eletronico na lista
        CaixaEletronico caixaSaque = null;
        for (CaixaEletronico caixaEletronico : caixas) {
            if (caixaEletronico.getIdCaixaEletronico() == idCaixaEletronico) {
                caixaSaque = caixaEletronico;
                break;
            }
        }
        if (caixaSaque == null) {
            throw new Error("Caixa Eletrônico não encontrado");
        }

        // PROCESSAMENTO
        // 6 - Validar se o caixa possui saldo
        if (caixaSaque.getSaldo() < valorSaque) {
            throw new Error("Caixa Eletrônico sem saldo");
        }
        // 7 - Validar se a conta possui saldo
        if (contaSaque.getSaldo() < valorSaque) {
            throw new Error("Conta sem saldo");
        }
        // 8 - Liberar o dinheiro para o cliente
        System.out.println("Por favor aguarde... \n O dinheiro estará disponível em instantes");
        // 9 - Registrar a transação
        Transacao transacao = new Transacao(1,
                contaSaque.getIdConta(),
                caixaSaque.getIdCaixaEletronico(),
                valorSaque,
                'D');
        transacoes.add(transacao);

        // SAÍDA

        // 10 - Encerrar a operação
        System.out.println("Operação concluída! \n Obrigado por utilizar o sistema Pix Impresso");
        // 10.1 - Mostrar o comprovante da transação em tela
        System.out.println("Comprovante: ");
        System.out.println("Data: " + transacao.getDataHora().toString());
        System.out.println("Valor: " + transacao.getValor());
        System.out.println("Tipo: " + transacao.getTipoTransacao());
    }
}
