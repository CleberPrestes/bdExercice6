package posutfpr.banco.ativcinco.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.Query;


@Entity
@Table(name = "Funcionario")
@NamedQuery(name = "FuncEntity.byDependents",
query = "from FuncEntity f where f.dependents = ?1")

@NamedNativeQuery(name = "FuncEntity.byPartOfName",
query = "select * from  funcionario where nome like ?1", 
resultClass = FuncEntity.class)


public class FuncEntity extends AbstractPersistable<Long> {

	@Column(name = "nome", length = 64, nullable = true)
	private String name;

	@Column(name = "qtdDependente", length = 64, nullable = true)
	private int dependents;

	@Column(name = "salario", length = 64, nullable = true)
	private Long pay;

	@Column(name = "cargo", length = 64, nullable = true)
	private String responsibility;

	
	
	@ManyToOne
	@JoinColumn(name = "dep_id")
	private DepartamentEntity depart;

	public FuncEntity() {

	}

	public FuncEntity(String name, int dependents, Long pay, String responsibility, DepartamentEntity depart) {
		super();
		this.name = name;
		this.dependents = dependents;
		this.pay = pay;
		this.responsibility = responsibility;
		this.depart = depart;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDependents() {
		return dependents;
	}

	public void setDependents(int dependents) {
		this.dependents = dependents;
	}

	public Long getPay() {
		return pay;
	}

	public void setPay(Long pay) {
		this.pay = pay;
	}

	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	public DepartamentEntity getDepart() {
		return depart;
	}

	public void setDepart(DepartamentEntity depart) {
		this.depart = depart;
	}

}