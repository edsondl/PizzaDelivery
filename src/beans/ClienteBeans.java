/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 *
 * @author hp
 */
public class ClienteBeans {
    
    private int cli_Codigo;
    private String cli_Nome;
    private String cli_Rua;
    private String cli_Bairro;
    private String cli_Telefone;
    private String cli_DataCad;

    public ClienteBeans() {
    }
  
    public ClienteBeans(int cli_Codigo, String cli_Nome, String cli_Rua, String cli_Bairro, String cli_Telefone, String cli_DataCad) {
        this.cli_Codigo = cli_Codigo;
        this.cli_Nome = cli_Nome;
        this.cli_Rua = cli_Rua;
        this.cli_Bairro = cli_Bairro;
        this.cli_Telefone = cli_Telefone;
        this.cli_DataCad = cli_DataCad;
    }
    
    /**
     * @return the cli_Codigo
     */
    public int getCli_Codigo() {
        return cli_Codigo;
    }

    /**
     * @param cli_Codigo the cli_Codigo to set
     */
    public void setCli_Codigo(int cli_Codigo) {
        this.cli_Codigo = cli_Codigo;
    }

    /**
     * @return the cli_Nome
     */
    public String getCli_Nome() {
        return cli_Nome;
    }

    /**
     * @param cli_Nome the cli_Nome to set
     */
    public void setCli_Nome(String cli_Nome) {
        this.cli_Nome = cli_Nome;
    }

    /**
     * @return the cli_Rua
     */
    public String getCli_Rua() {
        return cli_Rua;
    }

    /**
     * @param cli_Rua the cli_Rua to set
     */
    public void setCli_Rua(String cli_Rua) {
        this.cli_Rua = cli_Rua;
    }

    /**
     * @return the cli_Bairro
     */
    public String getCli_Bairro() {
        return cli_Bairro;
    }

    /**
     * @param cli_Bairro the cli_Bairro to set
     */
    public void setCli_Bairro(String cli_Bairro) {
        this.cli_Bairro = cli_Bairro;
    }

    /**
     * @return the cli_Telefone
     */
    public String getCli_Telefone() {
        return cli_Telefone;
    }

    /**
     * @param cli_Telefone the cli_Telefone to set
     */
    public void setCli_Telefone(String cli_Telefone) {
        this.cli_Telefone = cli_Telefone;
    }

    /**
     * @return the cli_DataCad
     */
    public String getCli_DataCad() {
        return cli_DataCad;
    }

    /**
     * @param cli_DataCad the cli_DataCad to set
     */
    public void setCli_DataCad(String cli_DataCad) {
        this.cli_DataCad = cli_DataCad;
    }

   
}

    