package com.makeapi.services;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.makeapi.model.mahasiswa.MahasiswaModel;
import com.makeapi.model.response.CustomResponse;
import com.makeapi.model.response.ResultResponse;
import com.makeapi.repository.MahasiswaRespository;

@Service
public class MahasiswaServices {
  @Autowired
  MahasiswaRespository mahasiswaRepository;

  public ResultResponse MahasiswaData() {
    // SET DATA RESPONSE
    CustomResponse result = new CustomResponse();
    try {
      List<MahasiswaModel> data = mahasiswaRepository.findAll();
      result.setStatus(HttpStatus.OK);
      result.setMessage("Data Mahasiswa");
      result.setData(data);
    } catch (Exception ex) {
      result.setStatus(HttpStatus.BAD_REQUEST);
      result.setMessage(ex.toString());
      result.getData();
    }

    // SET RESULT RESPONSE
    ResultResponse res = new ResultResponse();
    res.setResultGeneral(result);

    return res;
  }

  public ResultResponse MahasiswaCreate(MahasiswaModel mahasiswaModel) {
    CustomResponse result = new CustomResponse();

    try {
      mahasiswaRepository.save(mahasiswaModel);
      result.setStatus(HttpStatus.OK);
      result.setMessage("Data Mahasiswa saved!");
      result.setData(null);
    } catch (Exception ex) {
      result.setStatus(HttpStatus.BAD_REQUEST);
      result.setMessage(ex.toString());
      result.getData();
    }

    // SET RESULT RESPONSE
    ResultResponse res = new ResultResponse();
    res.setResultGeneral(result);

    return res;
  }

  public ResultResponse MahasiswaDelete(JSONObject objParam) {
    // SET DATA RESPONSE
    CustomResponse result = new CustomResponse();
    try {
      BigInteger id = new BigInteger(objParam.getString("id"));
      Optional<MahasiswaModel> data = mahasiswaRepository.findById(id);
      if (data.isEmpty()) {
        result.setStatus(HttpStatus.EXPECTATION_FAILED);
        result.setMessage("Data Mahasiswa Not Found!");
        result.setData(null);
      } else {
        mahasiswaRepository.delete(data.get());
        result.setStatus(HttpStatus.OK);
        result.setMessage("Data Mahasiswa");
        result.setData(data);
      }
    } catch (Exception ex) {
      result.setStatus(HttpStatus.BAD_REQUEST);
      result.setMessage(ex.toString());
      result.getData();
    }

    // SET RESULT RESPONSE
    ResultResponse res = new ResultResponse();
    res.setResultGeneral(result);

    return res;
  }
}
