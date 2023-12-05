package com.makeapi.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.makeapi.model.mahasiswa.MahasiswaModel;

@Repository
public interface MahasiswaRespository extends JpaRepository<MahasiswaModel, BigInteger> {

    
}
