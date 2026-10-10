package br.com.faculdade.sistema_academico.dto;

public class AlunoResponse {

        private Long id;
        private String nome;
        private String ra;

        public AlunoResponse() {
        }

        public AlunoResponse(Long id, String nome, String ra) {
            this.id = id;
            this.nome = nome;
            this.ra = ra;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getRa() {
            return ra;
        }

        public void setRa(String ra) {
            this.ra = ra;
        }
}

