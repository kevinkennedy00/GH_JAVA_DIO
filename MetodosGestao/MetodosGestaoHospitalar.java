package MetodosGestao;

import Hospitalar.Medicos.Medico;
import Hospitalar.Medicos.Procedimento;
import Hospitalar.Pacientes.Consulta;
import Hospitalar.Pacientes.Paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

import static MetodosGestao.Validacoes.*;

public class MetodosGestaoHospitalar {
    private List<Medico> medicos = new ArrayList<>();
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Consulta> consultas = new ArrayList<>();
    private List<Procedimento> procedimentos = new ArrayList<>();

    public static void adicionarNovoPaciente(Scanner scanner) {
        scanner = new Scanner(System.in);

        String cpf = validarCpf("Digite o CPF do paciente: ", scanner);
        if (cpf == null) {
            System.out.println("CPF inválido. Operação cancelada.");
            return;
        }

        String nome = validarEntradaString("Digite o nome completo do paciente: ", scanner);
        int idade = validarEntradaInteiro("Digite a idade do paciente: ", scanner);
        String nomeRua = validarEntradaString("Digite o nome da rua: ", scanner);
        int numeroCasa = validarEntradaInteiro("Digite o número da casa: ", scanner);
        String cep = validarCep("Digite o CEP da rua (somente números): ", scanner);
        String sintomas = validarEntradaString("Digite os sintomas do paciente: ", scanner);
        String telefone = validarTelefone("Digite o telefone do paciente com DDD: ", scanner);

        scanner.close();

        LocalDateTime hoje = LocalDateTime.now();
        String protocolo = String.format("%d%02d%02d%02d", hoje.getYear(), hoje.getMonthValue(), hoje.getDayOfMonth(), new Random().nextInt(99) + 1);

        System.out.println("Paciente registrado:");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Idade: " + idade);
        System.out.println("Endereço: " + nomeRua + ", " + numeroCasa + ", CEP: " + cep);
        System.out.println("Sintomas: " + sintomas);
        System.out.println("Telefone: " + telefone);
        System.out.println("Protocolo de atendimento: " + protocolo);
    }
    public void adicionarNovoMedico(Scanner scanner) {
        String cpf = Validacoes.validarCpf("Digite o CPF do do medico: ", scanner);
        for (Medico medico : medicos) {
            if (medico.getCpf().equals(cpf)) {
                System.out.println("Operação falhou: médico já cadastrado.");
                return;
            }
        }

        String nome = validarEntradaString("Digite o nome completo do médico: ", scanner);
        int idade = validarEntradaInteiro("Digite a idade do médico: ", scanner);
        String nomeDaRua = validarEntradaString("Digite o nome da rua: ", scanner);
        int numeroDaCasa = validarEntradaInteiro("Digite o número da casa: ", scanner);
        String cep = Validacoes.validarCep("Digite o CEP (ex: 00000000): ", scanner);
        String crm = Validacoes.validarCrm("Digite o CRM do médico (formato: CRM/XX123456): ");

        int especialidade;
        while (true) {
            especialidade = validarEntradaInteiro("1- Pediatria\n" + "2- Cirurgia Geral\n" + "3- Ginecologia e Obstetrícia\n" + "4- Anestesiologia\n" + "5- Ortopedia e Traumatologia\n" + "6- Medicina do Trabalho\n" + "7- Cardiologia\n" + "Digite a especialidade do médico: ", scanner);
            if (1 <= especialidade && especialidade <= 7) {
                break;
            } else {
                System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 7.");
            }
        }

        String telefone = validarTelefone("Digite o telefone do médico com o DDD: ", scanner);
        telefone = telefone.replaceAll("[^0-9]", "");

        Medico medico = new Medico(nome, idade, cpf, nomeDaRua, numeroDaCasa, cep, crm, especialidade, telefone);
        medicos.add(medico);

        System.out.println("O médico " + nome + ", foi registrado.");
    }

    public void pesquisarPacientePorCpf(Scanner scanner) {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }

        String cpf = Validacoes.validarCpf("Digite o CPF do paciente: ", scanner);
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                System.out.println("O paciente " + paciente.getNomeCompleto() + ", com protocolo de atendimento " + paciente.getProtocolo() + " foi encontrado, favor aguardar atendimento.");
                return;
            }
        }

        System.out.println("Paciente não encontrado.");
    }

    public void pesquisarMedicoPorCrm() {
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
            return;
        }

        String crm = Validacoes.validarCrm("Digite o CRM do médico: ");
        for (Medico medico : medicos) {
            if (medico.getCrm().equals(crm)) {
                String[] especialidades = {"Pediatria", "Cirurgião(a) Geral", "Ginecologia e Obstetrícia", "Anestesiologia", "Ortopedia e Traumatologia", "Medicina do Trabalho", "Cardiologia"};
                System.out.println("O médico " + medico.getNomeCompleto() + ", com especialidade em " + especialidades[medico.getEspecialidade() - 1] + ", consta em nosso sistema.");
                return;
            }
        }

        System.out.println("Médico não encontrado.");
    }

    public void excluirPacientePeloCpf(Scanner scanner) {
        String cpf = String.valueOf(validarEntradaInteiro("Digite o CPF do paciente que deseja excluir: ", scanner));
        Iterator<Paciente> iterator = pacientes.iterator();
        while (iterator.hasNext()) {
            Paciente paciente = iterator.next();
            if (paciente.getCpf().equals(cpf)) {
                iterator.remove();
                System.out.println("O paciente " + paciente.getNomeCompleto() + ", portador do CPF " + cpf + ", foi removido do nosso sistema.");
                return;
            }
        }

        System.out.println("Operação falhou: CPF não encontrado.");
    }

    public void excluirMedicoPorCrm() {
        String crm = Validacoes.validarCrm("Digite o CRM do médico (formato: CRM/XX123456): ");
        Iterator<Medico> iterator = medicos.iterator();
        while (iterator.hasNext()) {
            Medico medico = iterator.next();
            if (medico.getCrm().equals(crm)) {
                String[] especialidades = {"Pediatria", "Cirurgião(a) Geral", "Ginecologia e Obstetrícia", "Anestesiologia", "Ortopedia e Traumatologia", "Medicina do Trabalho", "Cardiologia"};
                iterator.remove();
                System.out.println("O médico " + medico.getNomeCompleto() + ", com especialidade " + especialidades[medico.getEspecialidade() - 1] + ", foi removido do nosso sistema.");
                return;
            }
        }

        System.out.println("Operação falhou: CRM não encontrado.");
    }

    public void gerenciarConsultas(Scanner scanner) {
        Map<Integer, String> especialidadeValores = new HashMap<>();
        especialidadeValores.put(1, "Pediatria");
        especialidadeValores.put(2, "Cirurgia Geral");
        especialidadeValores.put(3, "Ginecologia e Obstetrícia");
        especialidadeValores.put(4, "Anestesiologia");
        especialidadeValores.put(5, "Ortopedia e Traumatologia");
        especialidadeValores.put(6, "Medicina do Trabalho");
        especialidadeValores.put(7, "Cardiologia");

        while (true) {
            System.out.println("0. Voltar ao menu inicial");
            System.out.println("1. Listar consultas");
            System.out.println("2. Agendar nova consulta");
            System.out.println("3. Cancelar consulta");
            int opcao = validarEntradaInteiro("Escolha uma opção: ", scanner);

            if (opcao == 0) {
                System.out.println("Voltando ao menu inicial...");
                break;
            } else if (opcao == 1) {
                String cpfPaciente = Validacoes.validarCpf("Digite o CPF do paciente: ", scanner);
                boolean pacienteEncontrado = false;
                for (Paciente paciente : pacientes) {
                    if (paciente.getCpf().equals(cpfPaciente)) {
                        pacienteEncontrado = true;
                        break;
                    }
                }

                if (!pacienteEncontrado) {
                    System.out.println("Paciente não encontrado.");
                    continue;
                }

                List<Consulta> consultasDoPaciente = new ArrayList<>();
                for (Consulta consulta : consultas) {
                    if (consulta.getCpfPaciente().equals(cpfPaciente)) {
                        consultasDoPaciente.add(consulta);
                    }
                }

                if (!consultasDoPaciente.isEmpty()) {
                    System.out.println("\nConsultas agendadas:");
                    for (Consulta consulta : consultasDoPaciente) {
                        String especialidadeNome = especialidadeValores.getOrDefault(consulta.getEspecialidade(), "Especialidade desconhecida");
                        System.out.println("ID: " + consulta.getId() + ", Especialidade: " + especialidadeNome + ", Data: " + consulta.getDataConsulta() + ", Horário: " + consulta.getHorario() + ", Protocolo: " + consulta.getProtocolo());
                    }
                } else {
                    System.out.println("Nenhuma consulta encontrada.");
                }
            } else if (opcao == 2) {
                String cpfPaciente = Validacoes.validarCpf("Digite o CPF do paciente: ", scanner);
                boolean pacienteEncontrado = false;
                for (Paciente paciente : pacientes) {
                    if (paciente.getCpf().equals(cpfPaciente)) {
                        pacienteEncontrado = true;
                        break;
                    }
                }

                if (!pacienteEncontrado) {
                    System.out.println("Paciente não encontrado.");
                    continue;
                }

                int especialidade;
                while (true) {
                    especialidade = validarEntradaInteiro("1- Pediatria\n" + "2- Cirurgia Geral\n" + "3- Ginecologia e Obstetrícia\n" + "4- Anestesiologia\n" + "5- Ortopedia e Traumatologia\n" + "6- Medicina do Trabalho\n" + "7- Cardiologia\n" + "Digite a especialidade do médico: ", scanner);
                    if (1 <= especialidade && especialidade <= 7) {
                        break;
                    } else {
                        System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 7.");
                    }
                }

                LocalDate dataConsulta = Validacoes.validarEntradaData("Digite a data da consulta (YYYY-MM-DD): ");
                LocalTime horarioConsulta = Validacoes.validarEntradaHorario("Digite o horário da consulta (HH:MM): ");

                String protocolo = String.format("%04d%02d%02d%02d", LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth(), new Random().nextInt(100));
                Consulta consulta = new Consulta(cpfPaciente, especialidade, dataConsulta, horarioConsulta, protocolo);
                consultas.add(consulta);
                System.out.println("A consulta foi agendada com sucesso. Protocolo: " + protocolo);
            } else if (opcao == 3) {
                int protocolo = validarEntradaInteiro("Digite o protocolo da consulta que deseja cancelar: ", scanner);
                Iterator<Consulta> iterator = consultas.iterator();
                while (iterator.hasNext()) {
                    Consulta consulta = iterator.next();
                    if (consulta.getProtocolo().equals(String.valueOf(protocolo))) {
                        iterator.remove();
                        System.out.println("Consulta cancelada com sucesso.");
                        break;
                    }
                }
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public void registrarProcedimentoMedico(Scanner scanner) {
        String crm = Validacoes.validarCrm("Digite o CRM do médico (formato: CRM/XX123456): ");
        boolean medicoEncontrado = false;
        for (Medico medico : medicos) {
            if (medico.getCrm().equals(crm)) {
                medicoEncontrado = true;
                break;
            }
        }

        if (!medicoEncontrado) {
            System.out.println("Médico não encontrado.");
            return;
        }

        String cpf = Validacoes.validarCpf("Digite o CPF do paciente: ", scanner);
        boolean pacienteEncontrado = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                pacienteEncontrado = true;
                break;
            }
        }

        if (!pacienteEncontrado) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        while (true) {
            System.out.println("1. Registrar procedimento");
            System.out.println("2. Listar procedimentos");
            int opcao = validarEntradaInteiro("Escolha uma opção: ", scanner);

            if (opcao == 1) {
                int protocolo = validarEntradaInteiro("Digite o protocolo da consulta: ", scanner);
                String procedimento = validarEntradaString("Descreva o procedimento realizado: ", scanner);

                Procedimento proc = new Procedimento(cpf, String.valueOf(protocolo), procedimento);
                procedimentos.add(proc);
                System.out.println("Procedimento registrado com sucesso.");
            } else if (opcao == 2) {
                for (Procedimento proc : procedimentos) {
                    if (proc.getCpfPaciente().equals(cpf)) {
                        System.out.println("O paciente " + cpf + ", com protocolo de atendimento " + proc.getProtocoloConsulta() + ", realizou o procedimento: " + proc.getProcedimento());
                    }
                }
            } else {
                System.out.println("Opção inválida.");
            }

            break;
        }
    }

    public void sairDoSistema() {
        System.out.println("\nObrigado por usar o sistema GH Hospital ABC.");
        System.out.println("=============================================");
        System.out.println("           Sistema encerrado com sucesso!            ");
        System.out.println("=============================================\n");
    }

}
