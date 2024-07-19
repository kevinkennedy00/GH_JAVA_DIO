package Hospitalar.Medicos;

public class Procedimento {
    private int id;
    private String cpfPaciente;
    private String protocoloConsulta;
    private String procedimento;

    public Procedimento(String cpfPaciente, String protocoloConsulta, String procedimento) {
        this.id = id;
        this.cpfPaciente = cpfPaciente;
        this.protocoloConsulta = protocoloConsulta;
        this.procedimento = procedimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public String getProtocoloConsulta() {
        return protocoloConsulta;
    }

    public void setProtocoloConsulta(String protocoloConsulta) {
        this.protocoloConsulta = protocoloConsulta;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }
}
