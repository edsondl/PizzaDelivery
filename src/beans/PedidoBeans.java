/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edson Dias
 */
public class PedidoBeans {

    private int CodigoPedido;
    private int CodigoCliente;
    private int CodigoFuncionario;
    private int CodigoEntregador;
    private String Data;
    private String Hora;
    private double Valor;
    private double Total;
    private String Status;
    private List<Integer> CodCardapio;
    private List<Integer> Quantidade;
    
    public PedidoBeans() {
        CodCardapio = new ArrayList<>();
        Quantidade = new ArrayList<>();
        
     }  

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }
    
    public PedidoBeans(int CodigoPedido, int CodigoCliente, int CodigoFuncionario, int CodigoEntregador, String Data, String Hora, double Valor, String Status, List<Integer> CodCardapio, List<Integer> Quantidade) {
        this.CodigoPedido = CodigoPedido;
        this.CodigoCliente = CodigoCliente;
        this.Data = Data;
        this.Hora = Hora;
        this.Valor = Valor;
        this.Status = Status;
        this.CodCardapio = CodCardapio;
        this.Quantidade = Quantidade;
        
    }

    
    /**
     * @return the CodigoPedido
     */
    public int getCodigoPedido() {
        return CodigoPedido;
    }

    /**
     * @param CodigoPedido the CodigoPedido to set
     */
    public void setCodigoPedido(int CodigoPedido) {
        this.CodigoPedido = CodigoPedido;
    }

    /**
     * @return the CodigoCliente
     */
    public int getCodigoCliente() {
        return CodigoCliente;
    }

    /**
     * @param CodigoCliente the CodigoCliente to set
     */
    public void setCodigoCliente(int CodigoCliente) {
        this.CodigoCliente = CodigoCliente;
    }

    /**
     * @return the CodigoFuncionario
     */
    public int getCodigoFuncionario() {
        return CodigoFuncionario;
    }

    /**
     * @param CodigoFuncionario the CodigoFuncionario to set
     */
    public void setCodigoFuncionario(int CodigoFuncionario) {
        this.CodigoFuncionario = CodigoFuncionario;
    }

    /**
     * @return the CodigoEntregador
     */
    public int getCodigoEntregador() {
        return CodigoEntregador;
    }

    /**
     * @param CodigoEntregador the CodigoEntregador to set
     */
    public void setCodigoEntregador(int CodigoEntregador) {
        this.CodigoEntregador = CodigoEntregador;
    }

    /**
     * @return the Data
     */
    public String getData() {
        return Data;
    }

    /**
     * @param Data the Data to set
     */
    public void setData(String Data) {
        this.Data = Data;
    }

    /**
     * @return the Hora
     */
    public String getHora() {
        return Hora;
    }

    /**
     * @param Hora the Hora to set
     */
    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    /**
     * @return the Valor
     */
    public double getValor() {
        return Valor;
    }

    /**
     * @param Valor the Valor to set
     */
    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    /**
     * @return the Status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }

    /**
     * @return the CodCardapio
     */
    public int getCodCardapio(int Posicao) {
        return CodCardapio.get(Posicao);
    }

    /**
     * @param CodCardapio the CodCardapio to set
     */
    public void setCodCardapio(int CodCardapio) {
        this.CodCardapio.add(CodCardapio);
    }

    /**
     * @return the Quantidade
     */
    public int getQuantidade(int Posicao) {
        return Quantidade.get(Posicao);
    }

    /**
     * @param Quantidade the Quantidade to set
     */
    public void setQuantidade(int Quantidade) {
        this.Quantidade.add(Quantidade);
    }
    
}