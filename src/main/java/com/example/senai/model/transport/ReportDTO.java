package com.example.senai.model.transport;

import java.math.BigDecimal;

public class ReportDTO {
	
	private BigDecimal diferenca;
	private BigDecimal gasto;
	private BigDecimal orcamento;
    private Integer resident;
    
    public ReportDTO(){}
    
	public ReportDTO(BigDecimal diferenca, BigDecimal gasto, BigDecimal orcamento, Integer resident) {
		this.diferenca = diferenca;
		this.gasto = gasto;
		this.orcamento = orcamento;
		this.resident = resident;
	}

	public BigDecimal getDiferenca() {
		return diferenca;
	}

	public void setDiferenca(BigDecimal diferenca) {
		this.diferenca = diferenca;
	}

	public BigDecimal getGasto() {
		return gasto;
	}

	public void setGasto(BigDecimal gasto) {
		this.gasto = gasto;
	}

	public BigDecimal getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(BigDecimal orcamento) {
		this.orcamento = orcamento;
	}

	public Integer getResident() {
		return resident;
	}

	public void setResident(Integer resident) {
		this.resident = resident;
	}

	
}
