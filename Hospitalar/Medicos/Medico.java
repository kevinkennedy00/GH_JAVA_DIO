package Hospitalar.Medicos;

public class Medico {
    private String nomeCompleto;
    private int idade;
    private String cpf;
    private String nomeDaRua;
    private String numeroDaCasa;
    private String cep;
    private String crm;
    private int especialidade;
    private String telefone;

    public Medico(String nomeCompleto, int idade, String cpf, String nomeDaRua, int numeroDaCasa, String cep, String crm, int especialidade, String telefone) {
        this.nomeCompleto = nomeCompleto;
        this.idade = idade;
        this.cpf = cpf;
        this.nomeDaRua = nomeDaRua;
        this.numeroDaCasa = String.valueOf(numeroDaCasa);
        this.cep = cep;
        this.crm = crm;
        this.especialidade = especialidade;
        this.telefone = telefone;
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public int getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(int especialidade) {
        this.especialidade = especialidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
