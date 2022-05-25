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
public class FuncionarioBeans {
    
    private int fun_Codigo;
    private String fun_Nome;
    private String fun_Cargo;
    private String fun_Permissao;
    private String fun_DataCad;

    public FuncionarioBeans() {
    }
   
    public FuncionarioBeans(int fun_Codigo, String fun_Nome, String fun_Cargo, String fun_Permissao, String fun_DataCad) {
        this.fun_Codigo = fun_Codigo;
        this.fun_Nome = fun_Nome;
        this.fun_Cargo = fun_Cargo;
        this.fun_Permissao = fun_Permissao;
        this.fun_DataCad = fun_DataCad;
    }

    /**
     * @return the fun_Codigo
     */
    public int getFun_Codigo() {
        return fun_Codigo;
    }

    /**
     * @param fun_Codigo the fun_Codigo to set
     */
    public void setFun_Codigo(int fun_Codigo) {
        this.fun_Codigo = fun_Codigo;
    }

    /**
     * @return the fun_Nome
     */
    public String getFun_Nome() {
        return fun_Nome;
    }

    /**
     * @param fun_Nome the fun_Nome to set
     */
    public void setFun_Nome(String fun_Nome) {
        this.fun_Nome = fun_Nome;
    }

    /**
     * @return the fun_Cargo
     */
    public String getFun_Cargo() {
        return fun_Cargo;
    }

    /**
     * @param fun_Cargo the fun_Cargo to set
     */
    public void setFun_Cargo(String fun_Cargo) {
        this.fun_Cargo = fun_Cargo;
    }

    /**
     * @return the fun_Permissao
     */
    public String getFun_Permissao() {
        return fun_Permissao;
    }

    /**
     * @param fun_Permissao the fun_Permissao to set
     */
    public void setFun_Permissao(String fun_Permissao) {
        this.fun_Permissao = fun_Permissao;
    }

    /**
     * @return the fun_DataCad
     */
    public String getFun_DataCad() {
        return fun_DataCad;
    }

    /**
     * @param fun_DataCad the fun_DataCadastro to set
     */
    public void setFun_DataCad(String fun_DataCad) {
        this.fun_DataCad = fun_DataCad;
    }
    
}
