/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Date;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author thiag
 */
@Entity
@Table(name = "corrida", catalog = "uber", schema = "")
public class Corrida implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcorrida")
    private Integer idcorrida;
    @Column(name = "origem")
    private String origem;
    @Column(name = "destino")
    private String destino;
    @Column(name = "valor")
    private float valor;
    @Column(name="dataCorrida")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCorrida;
    @Column(name="hora")
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date hora;

    public Corrida(Integer idcorrida, String origem, String destino, float valor, Date dataCorrida, Usuario usuario, Motorista motorista, Date hora) {
        this.idcorrida = idcorrida;
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
        this.dataCorrida = dataCorrida;
        this.hora = hora;
        this.usuario = usuario;
        this.motorista = motorista;
    }

    @ManyToOne
    private Usuario usuario;
    
    @ManyToOne
    private Motorista motorista;
    
    public Corrida() {
    }

    public Corrida(Integer idcorrida) {
        this.idcorrida = idcorrida;
    }

    public Corrida(Integer idcorrida, String origem, String destino, float valor, int usuarioIdusuario, int motoristaIdmotorista) {
        this.idcorrida = idcorrida;
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        Usuario oldUsuario = this.usuario;
        this.usuario = usuario;
        changeSupport.firePropertyChange("usuario", oldUsuario, usuario);
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        Motorista oldMotorista = this.motorista;
        this.motorista = motorista;
        changeSupport.firePropertyChange("motorista", oldMotorista, motorista);
    }
    
    

    public Integer getIdcorrida() {
        return idcorrida;
    }

    public void setIdcorrida(Integer idcorrida) {
        Integer oldIdcorrida = this.idcorrida;
        this.idcorrida = idcorrida;
        changeSupport.firePropertyChange("idcorrida", oldIdcorrida, idcorrida);
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        String oldOrigem = this.origem;
        this.origem = origem;
        changeSupport.firePropertyChange("origem", oldOrigem, origem);
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        String oldDestino = this.destino;
        this.destino = destino;
        changeSupport.firePropertyChange("destino", oldDestino, destino);
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        float oldValor = this.valor;
        this.valor = valor;
        changeSupport.firePropertyChange("valor", oldValor, valor);
    }

    public Date getDataCorrida() {
        return dataCorrida;
    }

    public void setDataCorrida(Date dataCorrida) {
        Date oldDataCorrida = this.dataCorrida;
        this.dataCorrida = dataCorrida;
        changeSupport.firePropertyChange("dataCorrida", oldDataCorrida, dataCorrida);
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        Date oldHora = this.hora;
        this.hora = hora;
        changeSupport.firePropertyChange("hora", oldHora, hora);
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcorrida != null ? idcorrida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Corrida)) {
            return false;
        }
        Corrida other = (Corrida) object;
        if ((this.idcorrida == null && other.idcorrida != null) || (this.idcorrida != null && !this.idcorrida.equals(other.idcorrida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Corrida[ idcorrida=" + idcorrida + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
