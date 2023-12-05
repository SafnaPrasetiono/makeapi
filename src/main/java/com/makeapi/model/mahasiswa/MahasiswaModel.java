package com.makeapi.model.mahasiswa;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mahasiswa")
public class MahasiswaModel {
    @Id
    @Column(name = "MAHASISWA_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger MAHASISWA_ID;

    @Column(name = "NPM", nullable = false)
    private String NPM;
    @Column(name = "USERNAME", nullable = false)
    private String USERNAME;
    @Column(name = "FAKULTAS", nullable = false)
    private String FAKULTAS;
    @Column(name = "JURUSAN", nullable = false)
    private String JURUSAN;
    @Column(name = "ADDRESS", nullable = false)
    private String ADDRESS;
    @Column(name = "BORN", nullable = false)
    private String BORN;
    @Column(name = "PHONE", nullable = false)
    private String PHONE;
    @Column(name = "EMAIL", nullable = false)
    private String EMAIL;
}
