package MetodosGestao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validacoes {
    private static Scanner scanner = new Scanner(System.in);

    public static LocalDate validarEntradaData(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();
            try {
                return LocalDate.parse(entrada, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Use o formato YYYY-MM-DD. Tente novamente.");
            }
        }
    }

    public static LocalTime validarEntradaHorario(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();
            try {
                return LocalTime.parse(entrada, DateTimeFormatter.ofPattern("HH:mm"));
            } catch (DateTimeParseException e) {
                System.out.println("Horário inválido. Use o formato HH:MM. Tente novamente.");
            }
        }
    }

    public static String validarEntradaString(String mensagem, Scanner scanner) {
        while (true) {
            System.out.print(mensagem);
            String dadosUsuario = Validacoes.scanner.nextLine().trim();
            if (dadosUsuario.matches("[a-zA-Z\\s]+") && !dadosUsuario.isEmpty()) {
                return dadosUsuario;
            } else {
                System.out.println("Entrada inválida. Por favor, insira um nome válido.");
            }
        }
    }

    public static int validarEntradaInteiro(String mensagem, Scanner scanner) {
        while (true) {
            System.out.print(mensagem);
            String entrada = Validacoes.scanner.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
            }
        }
    }

    public static String validarCpf(String mensagem, Scanner scanner) {
        while (true) {
            System.out.print(mensagem);
            String cpf = Validacoes.scanner.nextLine().trim();
            if (cpf.matches("\\d{11}")) {
                return String.format("%s.%s.%s-%s", cpf.substring(0, 3), cpf.substring(3, 6), cpf.substring(6, 9), cpf.substring(9));
            } else {
                System.out.println("CPF inválido. O CPF deve conter 11 números e apenas números.");
            }
        }
    }

    public static String validarCep(String mensagem, Scanner scanner) {
        while (true) {
            System.out.print(mensagem);
            String cep = Validacoes.scanner.nextLine().trim();
            if (cep.matches("\\d{8}")) {
                return String.format("%s-%s", cep.substring(0, 5), cep.substring(5));
            } else {
                System.out.println("CEP inválido. O CEP deve conter 8 números e apenas números.");
            }
        }
    }

    public static String validarTelefone(String mensagem, Scanner scanner) {
        while (true) {
            System.out.print(mensagem);
            String telefone = Validacoes.scanner.nextLine().trim();
            if (telefone.matches("\\d{10,11}")) {
                if (telefone.length() == 10) {
                    return String.format("(%s) %s-%s", telefone.substring(0, 2), telefone.substring(2, 6), telefone.substring(6));
                } else {
                    return String.format("(%s) %s-%s", telefone.substring(0, 2), telefone.substring(2, 7), telefone.substring(7));
                }
            } else {
                System.out.println("Telefone inválido. O telefone deve conter 10 ou 11 números e apenas números.");
            }
        }
    }

    public static String validarCrm(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String crm = scanner.nextLine().trim().toUpperCase();
            if (crm.matches("CRM/[A-Z]{2}\\d{6}")) {
                return crm;
            } else {
                System.out.println("CRM inválido. Formato correto é 'CRM/XX123456'. Deve conter a sigla do estado e 6 números.");
            }
        }
    }
}
