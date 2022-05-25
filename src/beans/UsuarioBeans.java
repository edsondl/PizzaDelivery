/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author linux
 */

public class UsuarioBeans {
    
    public int Id;
    public String Usuario;
    public String Senha;
    //public String ConfirmaSenha;
    public String Tipo;
    public String Email;
    public String DataCad;
     
    public UsuarioBeans() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

//    public String getConfirmaSenha() {
//        return ConfirmaSenha;
//    }
//
//    public void setConfirmaSenha(String ConfirmaSenha) {
//        this.ConfirmaSenha = ConfirmaSenha;
//    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDataCad() {
        return DataCad;
    }

    public void setDataCad(String DataCad) {
        this.DataCad = DataCad;
    }

}
 