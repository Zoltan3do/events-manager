	package entities;

	import java.time.LocalDate;

	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.EnumType;
	import jakarta.persistence.Enumerated;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;

	@Entity
	@Table(name="events")
	public class Evento {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		private long id;
		
		@Column(name = "titolo", nullable = false)
		private String titolo;
		
		@Column(name="data_evento", nullable =false)
		private LocalDate dataEvento;
		
		@Column(name = "descrzione", nullable=false)
		private String descrizione;
		
		@Column(name ="tipo_evento")
		@Enumerated(EnumType.STRING)
		private TipoEvento tipoEvento;
		
		@Column(name="numero_massimo_partecipanti")
		private int numeroMassimoPartecipanti;
		
		
		public Evento() {}
		
		public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
				int numeroMassimoPartecipanti) {
			super();
			this.titolo = titolo;
			this.dataEvento = dataEvento;
			this.descrizione = descrizione;
			this.tipoEvento = tipoEvento;
			this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getTitolo() {
			return titolo;
		}

		public void setTitolo(String titolo) {
			this.titolo = titolo;
		}

		public LocalDate getDataEvento() {
			return dataEvento;
		}

		public void setDataEvento(LocalDate dataEvento) {
			this.dataEvento = dataEvento;
		}

		public String getDescrizione() {
			return descrizione;
		}

		public void setDescrizione(String descrizione) {
			this.descrizione = descrizione;
		}

		public TipoEvento getTipoEvento() {
			return tipoEvento;
		}

		public void setTipoEvento(TipoEvento tipoEvento) {
			this.tipoEvento = tipoEvento;
		}

		public int getNumeroMassimoPartecipanti() {
			return numeroMassimoPartecipanti;
		}

		public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
			this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
		}

		@Override
		public String toString() {
			return "Evento [id=" + id + ", titolo=" + titolo + ", dataEvento=" + dataEvento + ", descrizione=" + descrizione
					+ ", tipoEvento=" + tipoEvento + ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti + "]";
		}
	}
		
		
		

