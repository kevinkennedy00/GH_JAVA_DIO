package Front;

import MetodosGestao.MetodosGestaoHospitalar;

import java.util.Scanner;

public class SimuladorFrontEnd {
    public static void main(String[] args) {
        MetodosGestaoHospitalar metodos = new MetodosGestaoHospitalar();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==============================");
            System.out.println("Bem-vindo ao GH Hospital ABC");
            System.out.println("==============================\n");
            System.out.println("1. Adicionar novo paciente");
            System.out.println("2. Adicionar novo médico");
            System.out.println("3. Pesquisar paciente por CPF");
            System.out.println("4. Pesquisar médico por CRM");
            System.out.println("5. Excluir paciente por CPF");
            System.out.println("6. Excluir médico por CRM");
            System.out.println("7. Gerenciar consultas");
            System.out.println("8. Registrar procedimento médico");
            System.out.println("9. Sair\n");
            System.out.println("===============================");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consome a nova linha

            if (opcao == 1) {
                MetodosGestaoHospitalar.adicionarNovoPaciente(scanner);
            } else if (opcao == 2) {
                metodos.adicionarNovoMedico(scanner);
            } else if (opcao == 3) {
                metodos.pesquisarPacientePorCpf(scanner);
            } else if (opcao == 4) {
                metodos.pesquisarMedicoPorCrm();
            } else if (opcao == 5) {
                metodos.excluirPacientePeloCpf(scanner);
            } else if (opcao == 6) {
                metodos.excluirMedicoPorCrm();
            } else if (opcao == 7) {
                metodos.gerenciarConsultas(scanner);
            } else if (opcao == 8) {
                metodos.registrarProcedimentoMedico(scanner);
            } else if (opcao == 9) {
                metodos.sairDoSistema();
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
