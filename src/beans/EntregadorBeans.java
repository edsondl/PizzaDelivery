/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 *
 * @author Edson Dias
 */
public class EntregadorBeans {
    
    private int ent_cod;
    private String ent_nome;
    private String ent_status;
    private String ent_dataCad;
    private String ent_permissao;
    
     public EntregadorBeans() {
    }
  
    public int getEnt_cod() {
        return ent_cod;
    }

    public void setEnt_cod(int ent_cod) {
        this.ent_cod = ent_cod;
    }

    public String getEnt_nome() {
        return ent_nome;
    }

    public void setEnt_nome(String ent_nome) {
        this.ent_nome = ent_nome;
    }

    public String getEnt_status() {
        return ent_status;
    }

    public void setEnt_status(String ent_status) {
        this.ent_status = ent_status;
    }

    public String getEnt_dataCad() {
        return ent_dataCad;
    }

    public void setEnt_dataCad(String ent_dataCad) {
        this.ent_dataCad = ent_dataCad;
    }

    public String getEnt_permissao() {
        return ent_permissao;
    }

    public void setEnt_permissao(String ent_permissao) {
        this.ent_permissao = ent_permissao;
    }
         
}
