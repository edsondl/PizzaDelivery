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
public class CardapioBeans {

    private int car_Cod;
    private String car_Descricao;
    private String car_Tipo;
    private double car_Valor;

    public CardapioBeans() {
    }
  
    public CardapioBeans(int car_Cod, String car_Descricao, String car_Tipo, double car_Valor) {
        this.car_Cod = car_Cod;
        this.car_Descricao = car_Descricao;
        this.car_Tipo = car_Tipo;
        this.car_Valor = car_Valor;
    }
    
    /**
     * @return the car_Cod
     */
    public int getCar_Cod() {
        return car_Cod;
    }

    /**
     * @param car_Cod the car_Cod to set
     */
    public void setCar_Cod(int car_Cod) {
        this.car_Cod = car_Cod;
    }

    /**
     * @return the car_Descricao
     */
    public String getCar_Descricao() {
        return car_Descricao;
    }

    /**
     * @param car_Descricao the car_Descricao to set
     */
    public void setCar_Descricao(String car_Descricao) {
        this.car_Descricao = car_Descricao;
    }

    /**
     * @return the car_Tipo
     */
    public String getCar_Tipo() {
        return car_Tipo;
    }

    /**
     * @param car_Tipo the car_Tipo to set
     */
    public void setCar_Tipo(String car_Tipo) {
        this.car_Tipo = car_Tipo;
    }

    /**
     * @return the car_Valor
     */
    public double getCar_Valor() {
        return car_Valor;
    }

    /**
     * @param car_Valor the car_Valor to set
     */
    public void setCar_Valor(double car_Valor) {
        this.car_Valor = car_Valor;
    }
}
