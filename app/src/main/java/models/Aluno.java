package models;

import android.os.Parcel;
import android.os.Parcelable;

public class Aluno implements Parcelable{
    private String nome;
    private int idade;
    private String matricula;
    private String curso;
    private String data_formacao;
    private String data_ingresso;
    private String email;
    private String centro;

    public Aluno(){
        this.nome = "";
        this.idade = 0;
        this.matricula = "";
        this.curso = "";
        this.data_formacao = "";
        this.data_ingresso = "";
        this.email = "";
        this.centro = "";
    }

    public Aluno(String nome, int idade, String matricula, String curso, String data_formacao, String data_ingresso, String email, String centro) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
        this.curso = curso;
        this.data_formacao = data_formacao;
        this.data_ingresso = data_ingresso;
        this.email = email;
        this.centro = centro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getData_formacao() {
        return data_formacao;
    }

    public void setData_formacao(String data_formacao) {
        this.data_formacao = data_formacao;
    }

    public String getData_ingresso() {
        return data_ingresso;
    }

    public void setData_ingresso(String data_ingresso) {
        this.data_ingresso = data_ingresso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(nome);
        dest.writeInt(idade);
        dest.writeString(matricula);
        dest.writeString(curso);
        dest.writeString(data_formacao);
        dest.writeString(data_ingresso);
        dest.writeString(email);
        dest.writeString(centro);
    }

    public static final Parcelable.Creator<Aluno> CREATOR = new Parcelable.Creator<Aluno>(){
        @Override
        public Aluno createFromParcel(Parcel source) {

            return new Aluno(source);
        }

        @Override
        public Aluno[] newArray(int size) {

            throw new UnsupportedOperationException();
        }
    };

    public Aluno(Parcel source) {

        this.nome = source.readString();
        this.idade = source.readInt();
        this.matricula = source.readString();
        this.curso = source.readString();
        this.data_formacao = source.readString();
        this.data_ingresso = source.readString();
        this.email = source.readString();
        this.centro = source.readString();
    }

}
