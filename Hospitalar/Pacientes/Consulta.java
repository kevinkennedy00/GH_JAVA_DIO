package Hospitalar.Pacientes;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta {
    private int id;
    private String cpfPaciente;
    private int especialidade;
    private LocalDate dataConsulta;
    private LocalTime horario;
    private String protocolo;

    public Consulta(String cpfPaciente, int especialidade, LocalDate dataConsulta, LocalTime horario, String protocolo) {
        this.id = id;
        this.cpfPaciente = cpfPaciente;
        this.especialidade = especialidade;
        this.dataConsulta = dataConsulta;
        this.horario = horario;
        this.protocolo = protocolo;
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

    public int getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(int especialidade) {
        this.especialidade = especialidade;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }
}
