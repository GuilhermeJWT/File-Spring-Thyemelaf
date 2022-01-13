package br.com.systemsgs.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "arquivo_dados")
public class ModelFile implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "cod_arq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "end_arq")
    private String enderecoArquivo;

    @Column(name = "nom_orig")
    private String nomeOrigem;

    @Column(name = "cod_categ")
    private Integer codigoCategoria;

    @Column(name = "cod_usu_incl")
    private Integer codigoUsuarioIncl;

    @Column(name = "dat_incl")
    private LocalDateTime dataIncl = LocalDateTime.now();

    @Column(name = "dat_expur")
    private LocalDateTime dataExpurgo = LocalDateTime.now();

    @Column(name = "dsc_arq")
    private String descricaoArquivo;

    @Column(name = "tam_arq")
    private Long tamanhoArquivo;

    @Column(name = "flg_migr")
    private String flagMigr;

    @Column(name = "cod_algtm_hash")
    private String hash;

    @Column(name = "flg_ati")
    private String ativo;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "data")
    @Lob
    private byte[] data;
    
    public ModelFile() {
    	
    }

    public ModelFile(String enderecoArquivo, String nomeOrigem, Integer codigoCategoria, Integer codigoUsuarioIncl, String descricaoArquivo, Long tamanhoArquivo, String flagMigr, String hash, String ativo, String type, byte[] data) {
        this.enderecoArquivo = enderecoArquivo;
        this.nomeOrigem = nomeOrigem;
        this.codigoCategoria = codigoCategoria;
        this.codigoUsuarioIncl = codigoUsuarioIncl;
        this.descricaoArquivo = descricaoArquivo;
        this.tamanhoArquivo = tamanhoArquivo;
        this.flagMigr = flagMigr;
        this.hash = hash;
        this.ativo = ativo;
        this.type = type;
        this.data = data;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnderecoArquivo() {
		return enderecoArquivo;
	}

	public void setEnderecoArquivo(String enderecoArquivo) {
		this.enderecoArquivo = enderecoArquivo;
	}

	public String getNomeOrigem() {
		return nomeOrigem;
	}

	public void setNomeOrigem(String nomeOrigem) {
		this.nomeOrigem = nomeOrigem;
	}

	public Integer getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(Integer codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public Integer getCodigoUsuarioIncl() {
		return codigoUsuarioIncl;
	}

	public void setCodigoUsuarioIncl(Integer codigoUsuarioIncl) {
		this.codigoUsuarioIncl = codigoUsuarioIncl;
	}

	public LocalDateTime getDataIncl() {
		return dataIncl;
	}

	public void setDataIncl(LocalDateTime dataIncl) {
		this.dataIncl = dataIncl;
	}

	public LocalDateTime getDataExpurgo() {
		return dataExpurgo;
	}

	public void setDataExpurgo(LocalDateTime dataExpurgo) {
		this.dataExpurgo = dataExpurgo;
	}

	public String getDescricaoArquivo() {
		return descricaoArquivo;
	}

	public void setDescricaoArquivo(String descricaoArquivo) {
		this.descricaoArquivo = descricaoArquivo;
	}

	public Long getTamanhoArquivo() {
		return tamanhoArquivo;
	}

	public void setTamanhoArquivo(Long tamanhoArquivo) {
		this.tamanhoArquivo = tamanhoArquivo;
	}

	public String getFlagMigr() {
		return flagMigr;
	}

	public void setFlagMigr(String flagMigr) {
		this.flagMigr = flagMigr;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public byte[] getData() {
		return data;
	}
	
	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelFile other = (ModelFile) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
}
