/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author thiag
 */
@Entity
@Table(name = "motorista", catalog = "uber", schema = "")
public class Motorista implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmotorista")
    private Integer idmotorista;
    @Column(name = "nome")
    private String nome;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "carro")
    private String carro;
    @Column(name = "nota")
    private int nota;

    @OneToMany(mappedBy = "motorista")
    private List<Corrida> corridas = new ArrayList<>();
    
    public Motorista() {
    }

    public Motorista(Integer idmotorista) {
        this.idmotorista = idmotorista;
    }

    public Motorista(Integer idmotorista, String nome, String sexo, String carro, int nota) {
        this.idmotorista = idmotorista;
        this.nome = nome;
        this.sexo = sexo;
        this.carro = carro;
        this.nota = nota;
    }

    public List<Corrida> getCorridas() {
        return corridas;
    }

    public void setCorridas(List<Corrida> corridas) {
        this.corridas = corridas;
    }

    public Integer getIdmotorista() {
        return idmotorista;
    }

    public void setIdmotorista(Integer idmotorista) {
        Integer oldIdmotorista = this.idmotorista;
        this.idmotorista = idmotorista;
        changeSupport.firePropertyChange("idmotorista", oldIdmotorista, idmotorista);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        String oldSexo = this.sexo;
        this.sexo = sexo;
        changeSupport.firePropertyChange("sexo", oldSexo, sexo);
    }

    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        String oldCarro = this.carro;
        this.carro = carro;
        changeSupport.firePropertyChange("carro", oldCarro, carro);
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        int oldNota = this.nota;
        this.nota = nota;
        changeSupport.firePropertyChange("nota", oldNota, nota);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmotorista != null ? idmotorista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motorista)) {
            return false;
        }
        Motorista other = (Motorista) object;
        if ((this.idmotorista == null && other.idmotorista != null) || (this.idmotorista != null && !this.idmotorista.equals(other.idmotorista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
