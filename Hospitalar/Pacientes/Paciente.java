package Hospitalar.Pacientes;

public class Paciente {
    private String nomeCompleto;
    private int idade;
    private String cpf;
    private String nomeDaRua;
    private String numeroDaCasa;
    private String cep;
    private String sintomasDoPaciente;
    private String telefone;
    private String protocolo;

    public Paciente(String nomeCompleto, int idade, String cpf, String nomeDaRua, String numeroDaCasa, String cep, String sintomasDoPaciente, String telefone, String protocolo) {
        this.nomeCompleto = nomeCompleto;
        this.idade = idade;
        this.cpf = cpf;
        this.nomeDaRua = nomeDaRua;
        this.numeroDaCasa = numeroDaCasa;
        this.cep = cep;
        this.sintomasDoPaciente = sintomasDoPaciente;
        this.telefone = telefone;
        this.protocolo = protocolo;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeDaRua() {
        return nomeDaRua;
    }

    public void setNomeDaRua(String nomeDaRua) {
        this.nomeDaRua = nomeDaRua;
    }

    public String getNumeroDaCasa() {
        return numeroDaCasa;
    }

    public void setNumeroDaCasa(String numeroDaCasa) {
        this.numeroDaCasa = numeroDaCasa;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getSintomasDoPaciente() {
        return sintomasDoPaciente;
    }

    public void setSintomasDoPaciente(String sintomasDoPaciente) {
        this.sintomasDoPaciente = sintomasDoPaciente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }
}
