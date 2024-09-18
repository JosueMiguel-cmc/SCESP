package VO;
import java.time.*;
public class UsuarioVo {
    private String Nome;
    private String Ocupação;
    private String Genero;
    private int idade;
    private LocalDateTime horadeentrada;
    private LocalDateTime horadesaida;

    

    public UsuarioVo(String nome, String ocupação, String genero, int idade, LocalDateTime horadeentrada,
            LocalDateTime horadesaida) {
        this.Nome = nome;
        this.Ocupação = ocupação;
        this.Genero = genero;
        this.idade = idade;
        this.horadeentrada = horadeentrada;
        this.horadesaida = horadesaida;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getOcupação() {
        return Ocupação;
    }

    public void setOcupação(String ocupação) {
        Ocupação = ocupação;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public LocalDateTime getHoradeentrada() {
        return horadeentrada;
    }

    public void setHoradeentrada(LocalDateTime horadeentrada) {
        this.horadeentrada = horadeentrada;
    }

    public LocalDateTime getHoradesaida() {
        return horadesaida;
    }

    public void setHoradesaida(LocalDateTime horadesaida) {
        this.horadesaida = horadesaida;
    }

    public UsuarioVo(){

    }
    
    
    
    


}
