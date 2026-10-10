package br.com.faculdade.sistema_academico.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

    @Entity
    public class Aluno {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nome;
        private String ra;

        public Aluno() {
        }

        public Aluno(Long id, String nome, String ra) {
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
